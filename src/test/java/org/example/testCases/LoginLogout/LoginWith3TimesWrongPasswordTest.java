package org.example.testCases.LoginLogout;

import org.example.testCases.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class LoginWith3TimesWrongPasswordTest {
    private WebDriver webDriver;


    @BeforeEach
    public void setup() {
        webDriver = WebDriverProvider.setupWebDriver();
    }

    @Test
    public void test() {
        LoginWith3TimesWrongPassword loginWith3TimesWrongPassword = new LoginWith3TimesWrongPassword(webDriver);

        loginWith3TimesWrongPassword.run();

        WebElement captcha = webDriver.findElement(By.id("captcha"));

        Assertions.assertTrue(captcha.isDisplayed());
    }

    @AfterEach
    public void tearDown() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.err.println("Thread sleep interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            webDriver.quit();
        }
    }

}
