package com.appium.driver;

import com.appium.helper.Config;
import com.appium.helper.Project;

import java.util.concurrent.TimeUnit;

public class Emulator {
    private static Emulator instance = null;
    private Process emulator;

    private Emulator() {
    }

    // static method to create instance of Singleton class
    public static Emulator getInstance() {
        if (instance == null)
            instance = new Emulator();

        return instance;
    }

    public void startEmulatorDevice() throws Exception {
        stopEmulatorDevice();

        String emulator_path = Project.ROOT + "/src/test/resources/device";
        String xcode_path = Config.Instance().getXCodePath();

        emulator = Runtime.getRuntime().exec(emulator_path + "/start-simulator " + xcode_path);
        emulator.waitFor(50, TimeUnit.SECONDS);
    }

    public void stopEmulatorDevice() throws Exception {
        String emulator_path = Project.ROOT + "/src/test/resources/device";

        emulator = Runtime.getRuntime().exec(emulator_path + "/stop-simulator");
        emulator.waitFor(50, TimeUnit.SECONDS);
    }
}
