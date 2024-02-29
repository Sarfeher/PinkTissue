package org.example.testCases.LoginLogout;

import org.example.testCases.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class SuccessfulLogOutTest {
    private WebDriver webDriver;

    @BeforeEach
    public void setup(){
        webDriver = WebDriverProvider.setupWebDriver();
        SuccessfulLogin logIn = new SuccessfulLogin(webDriver);
        logIn.run();
    }

    @Test
    // TODO: rename test to more accurate
    public void test(){
        SuccessfulLogOut successfulLogOut = new SuccessfulLogOut(webDriver);
        successfulLogOut.run();

        WebElement userOptions = webDriver.findElement(By.id("user-options"));
        Assertions.assertNotNull(userOptions);
    }

    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
