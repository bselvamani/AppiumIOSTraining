package com.appium.pom.app;

import com.appium.pom.BasePage;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AlertViewPage extends BasePage {

    @iOSXCUITFindBy(xpath = "//*[@value='Text Entry']")
    public WebElement btnText;

    @iOSXCUITFindBy(className = "XCUIElementTypeTextField")
    public WebElement txtText;

    @iOSXCUITFindBy(xpath = "//*[@name='OK']")
    public WebElement btnOk;

    public AlertViewPage(IOSDriver<IOSElement> driver) {
        super(driver);
    }

    public boolean isInitialized() {
        return btnText.isDisplayed();
    }

    public AlertViewPage onClickText() {
        btnText.click();
        return this;
    }

    public AlertViewPage setText(String text) {
        txtText.sendKeys(text);
        return this;
    }

    public void onClickOk() {
        btnOk.click();
    }

}
