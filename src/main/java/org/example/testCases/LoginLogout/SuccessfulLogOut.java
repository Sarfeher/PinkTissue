package org.example.testCases.LoginLogout;

import org.example.testCases.Runnable;
import org.example.testCases.BaseTestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuccessfulLogOut extends BaseTestCase implements Runnable {
    private static final String URL = "https://jira-auto.codecool.metastage.net/secure/Dashboard.jspa";

    public SuccessfulLogOut(WebDriver webDriver) {
        super(webDriver);
    }


    @Override
    public void run() {
        webDriver.navigate().to(URL);
        WebElement dropDown = webDriver.findElement(By.id("header-details-user-fullname"));
        dropDown.click();

        WebElement logOutButton = webDriver.findElement(By.id("log_out"));
        logOutButton.click();
    }
}
