package org.example.testCases.LoginLogout;

import org.example.testCases.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

class LoginEmptyFieldsTest {
    private WebDriver webDriver;
    @FindBy(xpath = "//*[@id='login-form']/div[1]/div[1]")
    private WebElement errorMessage;

    @BeforeEach
    public void setup() {
        webDriver = WebDriverProvider.setupWebDriver();
        webDriver.navigate().to(LoginEmptyFields.LOGIN_URL);
    }

    @Test
    public void loginWithEmptyFieldsTest() {
        LoginEmptyFields loginEmptyFields = new LoginEmptyFields(webDriver);
        loginEmptyFields.run();
        Assertions.assertTrue(errorMessage.isDisplayed());
    }

    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }
}
