package org.example.testCases.LoginLogout;

import org.example.testCases.BaseTestCase;
import org.example.testCases.Runnable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessfulLogOut extends BaseTestCase implements Runnable {
    public static final String URL = "https://jira-auto.codecool.metastage.net/secure/Dashboard.jspa";
    @FindBy(id = "header-details-user-fullname")
    private WebElement dropDown;
    @FindBy(id = "log_out")
    private WebElement logOutButton;

    public SuccessfulLogOut(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void run() {
        webDriver.navigate().to(URL);
        dropDown.click();
        logOutButton.click();
    }
}
