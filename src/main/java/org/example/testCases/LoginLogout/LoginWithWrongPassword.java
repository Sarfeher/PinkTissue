package org.example.testCases.LoginLogout;

import org.example.testCases.BaseTestCase;
import org.example.testCases.Runnable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginWithWrongPassword extends BaseTestCase implements Runnable {
    public static final String USER_NAME = "automation74";
    public static final String USER_PASSWORD = "wrongPassword";
    public static final String LOGIN_URL = "https://jira-auto.codecool.metastage.net/login.jsp?os_destination=%2Fsecure%2FRapidBoard.jspa%3FrapidView%3D3%26projectKey%3DMTP";
    @FindBy(id = "login-form-username")
    private WebElement userName;
    @FindBy(id = "login-form-password")
    private WebElement userPassword;
    @FindBy(id = "login-form-submit")
    private WebElement button;

    public LoginWithWrongPassword(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void run() {
        userName.sendKeys(USER_NAME);
        userPassword.sendKeys(USER_PASSWORD);

        button.click();
    }
}
