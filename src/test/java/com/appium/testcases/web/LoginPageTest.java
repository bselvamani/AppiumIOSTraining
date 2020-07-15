package com.appium.testcases.web;

import com.appium.helper.Config;
import com.appium.testcases.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class LoginPageTest extends BaseTest {

    @Test
    public void test_myAccountPage() {
        driver.get(Config.Instance().getUrl());

        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys(Config.Instance().getUser());
        driver.findElement(By.id("passwd")).sendKeys(Config.Instance().getPassword());

        assertTrue(driver.findElement(By.linkText("My account")).isDisplayed());
    }
}