package org.example.testCases.LoginLogout;

import org.example.testCases.BaseTestCase;
import org.example.testCases.Runnable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginWith3TimesWrongPassword extends BaseTestCase implements Runnable {
    public static final String USER_NAME = "automation74";
    public static final String USER_PASSWORD = "wrongPassword";
    public static final String LOGIN_URL = "https://jira-auto.codecool.metastage.net/login.jsp?os_destination=%2Fsecure%2FRapidBoard.jspa%3FrapidView%3D3%26projectKey%3DMTP";
    @FindBy(id = "login-form-username")
    private WebElement userName;
    @FindBy(id = "login-form-password")
    private WebElement userPassword;
    @FindBy(id = "login-form-submit")
    private WebElement button;
    @FindBy(id = "captcha")
    private WebElement captcha;

    public LoginWith3TimesWrongPassword(WebDriver webDriver) {
        super(webDriver);
    }

    private void loginWithWrongPassword() {
        userName.sendKeys(USER_NAME);
        userPassword.sendKeys(USER_PASSWORD);
        button.click();
    }

    private void loginWithWrongPasswordAndNavigateBackToLoginUrl() {
        loginWithWrongPassword();
        webDriver.navigate().to(LOGIN_URL);
    }

    public boolean isCaptchaDisplayed(){
        return captcha.isDisplayed();
    }

    @Override
    public void run() {
        loginWithWrongPasswordAndNavigateBackToLoginUrl();

        loginWithWrongPasswordAndNavigateBackToLoginUrl();

        loginWithWrongPassword();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("captcha")));
    }

}
