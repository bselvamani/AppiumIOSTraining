package com.appium.pom.app;

import com.appium.pom.BasePage;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage extends BasePage {

    @iOSXCUITFindBy(id = "Alert Views")
    private WebElement btnAlertViews;

    @iOSXCUITFindBy(id = "Steppers")
    private WebElement btnSteppers;

    public HomePage(IOSDriver<IOSElement> driver) {
        super(driver);
    }

    public boolean isInitialized() {
        return this.btnAlertViews.isDisplayed();
    }

    public AlertViewPage onClickAlertViews() {
        btnAlertViews.click();
        return new AlertViewPage(driver);
    }

    public SteppersPage onClickSteppers() {
        btnSteppers.click();
        return new SteppersPage(driver);
    }
}
