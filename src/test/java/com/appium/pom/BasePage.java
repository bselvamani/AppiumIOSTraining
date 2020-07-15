package com.appium.pom;

import com.appium.helper.Config;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected IOSDriver<IOSElement> driver;

    public BasePage(IOSDriver<IOSElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void openURL() {
        driver.get(Config.Instance().getUrl());
    }

    public void back() {
        driver.navigate().back();
    }
}
