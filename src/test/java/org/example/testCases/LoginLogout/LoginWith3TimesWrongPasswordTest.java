package org.example.testCases.LoginLogout;

import org.example.testCases.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.example.testCases.LoginLogout.LoginWith3TimesWrongPassword.LOGIN_URL;

class LoginWith3TimesWrongPasswordTest {
    private WebDriver webDriver;
    @FindBy(id = "captcha")
    private WebElement captcha;

    @BeforeEach
    public void setup() {
        webDriver = WebDriverProvider.setupWebDriver();
        webDriver.navigate().to(LOGIN_URL);
    }

    @Test
    public void Login3TimesWrongPasswordTest() {
        LoginWith3TimesWrongPassword loginWith3TimesWrongPassword = new LoginWith3TimesWrongPassword(webDriver);

        loginWith3TimesWrongPassword.run();

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
