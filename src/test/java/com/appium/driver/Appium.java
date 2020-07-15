package com.appium.driver;

import com.appium.helper.Config;
import com.appium.helper.Project;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Appium {
    private static Appium instance = null;
    private Process appium;
    private AppiumDriverLocalService appiumService;

    private Appium() {
    }

    // static method to create instance of Singleton class
    public static Appium getInstance() {
        if (instance == null)
            instance = new Appium();

        return instance;
    }

    public void startAppiumService() throws Exception {
        stopAppiumService();

        AppiumServiceBuilder appiumBuilder = new AppiumServiceBuilder();
        appiumBuilder.usingPort(4723);
        appiumBuilder.withIPAddress("127.0.0.1");

        HashMap<String, String> environment = new HashMap();
        environment.put("JAVA_HOME", Config.Instance().getJavaHome());
        environment.put("PATH", System.getenv("PATH") + ":" + "/usr/local/bin:" + System.getenv("JAVA_HOME"));
        appiumBuilder.withEnvironment(environment);

        appiumService = AppiumDriverLocalService.buildService(appiumBuilder);
        appiumService.start();
    }

    public String getAppiumServiceURL() {
        return appiumService.getUrl().toString();
    }

    public void stopAppiumService() throws Exception {
        String appium_path = Project.ROOT + "/src/test/resources/appium";
        appium = Runtime.getRuntime().exec(appium_path + "/stop-appium-server");

        appium.waitFor(20, TimeUnit.SECONDS);
    }
}
