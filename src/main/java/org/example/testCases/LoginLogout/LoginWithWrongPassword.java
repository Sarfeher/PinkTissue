package org.example.testCases.LoginLogout;

import org.example.testCases.Runnable;
import org.example.testCases.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginWithWrongPassword extends TestCase implements Runnable {
    public static final String USER_NAME = "automation74";
    public static final String USER_PASSWORD = "wrongPassword";
    private static final String URL = "https://jira-auto.codecool.metastage.net/login.jsp?os_destination=%2Fsecure%2FRapidBoard.jspa%3FrapidView%3D3%26projectKey%3DMTP";

    public LoginWithWrongPassword(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void run() {
        webDriver.navigate().to(URL);
        WebElement userName = webDriver.findElement(By.id("login-form-username"));
        WebElement userPassword = webDriver.findElement(By.id("login-form-password"));
        WebElement button = webDriver.findElement(By.id("login-form-submit"));

        userName.sendKeys(USER_NAME);
        userPassword.sendKeys(USER_PASSWORD);

        button.click();
    }
}
