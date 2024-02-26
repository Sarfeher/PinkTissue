package org.example.testCases.LoginLogout;

import org.example.testCases.Runnable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginEmptyFields implements Runnable {
    private static final String URL = "https://jira-auto.codecool.metastage.net/login.jsp?os_destination=%2Fsecure%2FRapidBoard.jspa%3FrapidView%3D3%26projectKey%3DMTP";
    private final WebDriver webDriver;

    public LoginEmptyFields(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public void run() {
        webDriver.navigate().to(URL);
        webDriver.navigate().to(URL);

        WebElement button = webDriver.findElement(By.id("login-form-submit"));

        button.click();
    }
}
