package com.appium.testcases;

import com.appium.driver.Emulator;
import com.appium.driver.Driver;
import com.appium.driver.Appium;
import org.apache.log4j.Logger;
import org.testng.annotations.*;

public class BaseTest extends Driver {

    protected final Logger logger = Logger.getLogger(BaseTest.class);

    @BeforeSuite
    public void beforeSuite() throws Exception {

        if (System.getProperty("application") != null)
            application = System.getProperty("application");

        logger.info("Starting Appium Service ...");
        Appium.getInstance().startAppiumService();

        logger.info("Starting Emulator ...");
        Emulator.getInstance().startEmulatorDevice();
    }

    @BeforeTest
    public void beforeTest() throws Exception {
        logger.info("Setting up driver...");
        setupDriver();
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        logger.info("Closing driver ...");
        closeDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() throws Exception {
        logger.info("Closing Emulator ...");
        Emulator.getInstance().stopEmulatorDevice();

        logger.info("Closing Appium Service ...");
        Appium.getInstance().stopAppiumService();
    }
}
