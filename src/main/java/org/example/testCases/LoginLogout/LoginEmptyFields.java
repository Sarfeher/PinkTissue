package org.example.testCases.LoginLogout;

import org.example.testCases.BaseTestCase;
import org.example.testCases.Runnable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginEmptyFields extends BaseTestCase implements Runnable {
    public static final String LOGIN_URL = "https://jira-auto.codecool.metastage.net/login.jsp?os_destination=%2Fsecure%2FRapidBoard.jspa%3FrapidView%3D3%26projectKey%3DMTP";
    @FindBy(id = "login-form-submit")
    private WebElement button;

    public LoginEmptyFields(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void run() {
        button.click();
    }
}
