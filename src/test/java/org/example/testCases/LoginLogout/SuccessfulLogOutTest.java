package org.example.testCases.LoginLogout;

import org.example.testCases.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

class SuccessfulLogOutTest {
    private WebDriver webDriver;
    @FindBy(id = "user-options") private WebElement userOptions;

    @BeforeEach
    public void setup(){
        webDriver = WebDriverProvider.setupWebDriver();
        SuccessfulLogin logIn = new SuccessfulLogin(webDriver);
        logIn.run();
    }

    @Test
    public void successfulLogOutTest(){
        SuccessfulLogOut successfulLogOut = new SuccessfulLogOut(webDriver);
        successfulLogOut.run();

        Assertions.assertNotNull(userOptions);
    }

    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
