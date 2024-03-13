package org.example.testCases.LoginLogout;

import io.github.cdimascio.dotenv.Dotenv;
import org.example.testCases.BaseTestCase;
import org.example.testCases.Runnable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessfulLogin extends BaseTestCase implements Runnable {

    public static final String URL = "https://jira-auto.codecool.metastage.net/login.jsp?os_destination=%2Fsecure%2FRapidBoard.jspa%3FrapidView%3D3%26projectKey%3DMTP";
    private final Dotenv dotenv = Dotenv.load();
    @FindBy(id = "login-form-username")
    private WebElement userName;
    @FindBy(id = "login-form-password")
    private WebElement userPassword;
    @FindBy(id = "login-form-submit")
    private WebElement button;


    public SuccessfulLogin(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void run() {
        userName.sendKeys(dotenv.get("JIRA_USERNAME"));
        userPassword.sendKeys(dotenv.get("JIRA_PASSWORD"));
        button.click();
    }
}
