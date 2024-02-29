package org.example.testCases.LoginLogout;

import org.example.testCases.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class LoginEmptyFieldsTest {
    private WebDriver webDriver;

    @BeforeEach
    public void setup() {
        webDriver = WebDriverProvider.setupWebDriver();
    }

    @Test
    // TODO: rename test to more accurate
    public void test() {
        LoginEmptyFields loginEmptyFields = new LoginEmptyFields(webDriver);
        loginEmptyFields.run();
        WebElement errorMessage = webDriver.findElement(By.xpath("//*[@id='login-form']/div[1]/div[1]"));

        Assertions.assertTrue(errorMessage.isDisplayed());
    }

    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }

}
