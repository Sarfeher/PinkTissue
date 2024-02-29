package org.example.testCases.LoginLogout;

import org.example.testCases.Runnable;
import org.example.testCases.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginWith3TimesWrongPassword extends TestCase implements Runnable {
    public static final String USER_NAME = "automation74";
    public static final String USER_PASSWORD = "wrongPassword";
    private static final String URL = "https://jira-auto.codecool.metastage.net/login.jsp?os_destination=%2Fsecure%2FRapidBoard.jspa%3FrapidView%3D3%26projectKey%3DMTP";

    public LoginWith3TimesWrongPassword(WebDriver webDriver) {
        super(webDriver);
    }


    @Override
    public void run() {
        webDriver.navigate().to(URL);
        WebElement userName = webDriver.findElement(By.id("login-form-username"));
        WebElement userPassword = webDriver.findElement(By.id("login-form-password"));
        WebElement button = webDriver.findElement(By.id("login-form-submit"));
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(1));

        userName.sendKeys(USER_NAME);
        userPassword.sendKeys(USER_PASSWORD);

        button.click();
        webDriver.navigate().to(URL);
         userName = webDriver.findElement(By.id("login-form-username"));
         userPassword = webDriver.findElement(By.id("login-form-password"));
         button = webDriver.findElement(By.id("login-form-submit"));

        userName.sendKeys(USER_NAME);
        userPassword.sendKeys(USER_PASSWORD);

        button.click();

        webDriver.navigate().to(URL);
         userName = webDriver.findElement(By.id("login-form-username"));
         userPassword = webDriver.findElement(By.id("login-form-password"));
         button = webDriver.findElement(By.id("login-form-submit"));

        userName.sendKeys(USER_NAME);
        userPassword.sendKeys(USER_PASSWORD);

        button.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("captcha")));


    }
}
