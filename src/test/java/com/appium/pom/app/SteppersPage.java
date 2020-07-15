package com.appium.pom.app;

import java.util.List;

import com.appium.pom.BasePage;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SteppersPage extends BasePage {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Increment']")
    private List<WebElement> btnIncrement;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@type='XCUIElementTypeStaticText']")
    private List<WebElement> txtIncrement;

    public SteppersPage(IOSDriver<IOSElement> driver) {
        super(driver);
    }

    public boolean isInitialized() {
        return btnIncrement.size() > 0;
    }

    public SteppersPage onClickDefaultIncrement() {
        btnIncrement.get(0).click();
        return this;
    }

    public int getDefaultIncrementText() {
        return Integer.parseInt(txtIncrement.get(1).getText());
    }
}
