package com.appium.driver;

import com.appium.helper.Config;

import com.appium.helper.Project;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {
    public AppiumDriver driver;

    public String device = "emulator";
    public String application = "app";

    public void setupDriver() throws MalformedURLException {
        closeDriver();

        String appiumURL = Appium.getInstance().getAppiumServiceURL();

        driver = new IOSDriver<>(new URL(appiumURL), getCapabilities());
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    public void closeDriver() {
        if (driver != null)
            driver.quit();
    }

    private DesiredCapabilities getCapabilities() {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.IOS);
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 50);

        if (device.equalsIgnoreCase("emulator")) {
            dc.setCapability(MobileCapabilityType.DEVICE_NAME, Config.Instance().getDeviceName());
        } else if (application.equalsIgnoreCase("real")) {
            dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8");
        }

        if (application.equalsIgnoreCase("app")) {
            dc.setCapability(MobileCapabilityType.APP, Project.ROOT + Config.Instance().getApplication());
        } else if (application.equalsIgnoreCase("web")) {
            dc.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.SAFARI);
        }
        return dc;
    }
}
