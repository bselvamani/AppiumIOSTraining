package com.appium.testcases.app;

import com.appium.testcases.BaseTest;
import com.appium.pom.app.HomePage;
import com.appium.pom.app.AlertViewPage;
import com.appium.pom.app.SteppersPage;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import static org.testng.AssertJUnit.assertTrue;

public class UICatalogTest extends BaseTest {

    protected HomePage homePage;
    protected AlertViewPage alertViewPage;
    protected SteppersPage steppersPage;

    @Test
    public void test_alert_view1() {
        homePage = new HomePage((IOSDriver<IOSElement>) driver);
        assertTrue(homePage.isInitialized());

        alertViewPage = homePage.onClickAlertViews();
        assertTrue(alertViewPage.isInitialized());

        alertViewPage.onClickText()
                .setText("Welcome to web automation")
                .onClickOk();

        alertViewPage.back();
        assertTrue(homePage.isInitialized());
    }


    @Test
    public void test_steppers1() {
        homePage = new HomePage((IOSDriver<IOSElement>) driver);
        assertTrue(homePage.isInitialized());

        steppersPage = homePage.onClickSteppers();
        assertTrue(steppersPage.isInitialized());

        steppersPage.onClickDefaultIncrement()
                .onClickDefaultIncrement();

        int value = steppersPage.getDefaultIncrementText();
        assertTrue(value == 2);
    }

    @Test(enabled = false)
    public void test_alert_view() {
        driver.findElementByAccessibilityId("Alert Views").click();
        driver.findElementByXPath("//*[@value='Text Entry']").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("Welcome to web automation");
        driver.findElementByName("OK").click();

        driver.navigate().back();

        assertTrue(driver.findElementByAccessibilityId("Alert Views").isDisplayed());
    }

    @Test(enabled = false)
    public void test_steppers() {
        driver.findElementByAccessibilityId("Steppers").click();

        List<WebElement> webElements = driver.findElementsByXPath("//XCUIElementTypeButton[@name='Increment']");
        webElements.get(0).click();
        webElements.get(0).click();

        webElements = driver.findElementsByXPath("//XCUIElementTypeStaticText[@type='XCUIElementTypeStaticText']");
        int value = Integer.parseInt(webElements.get(1).getText());

        assertTrue(value == 2);
    }
}