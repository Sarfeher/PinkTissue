package org.example.testCases.LoginLogout;

import org.example.testCases.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class LoginWithWrongPasswordTest {

    private WebDriver webDriver;


    @BeforeEach
    public void setup() {
        webDriver = WebDriverProvider.setupWebDriver();
    }

    @Test
    public void test() {
        LoginWithWrongPassword loginWithWrongPassword = new LoginWithWrongPassword(webDriver);

        loginWithWrongPassword.run();

        WebElement errorMessage = webDriver.findElement(By.xpath("//*[@id='login-form']/div[1]/div[1]"));

        Assertions.assertTrue(errorMessage.isDisplayed());
    }

    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }
}
