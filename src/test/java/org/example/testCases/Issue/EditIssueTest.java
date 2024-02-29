package org.example.testCases.Issue;

import org.example.testCases.WebDriverProvider;
import org.example.testCases.LoginLogout.SuccessfulLogin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class EditIssueTest {
    private WebDriver webDriver;
    private SearchIssue searchIssue;

    @BeforeEach
    void setUp() {
        webDriver = WebDriverProvider.setupWebDriver();
        SuccessfulLogin logIn = new SuccessfulLogin(webDriver);

        logIn.run();

        CreateIssue createIssue = new CreateIssue(webDriver);
        createIssue.run();
        searchIssue = new SearchIssue(webDriver);
        searchIssue.run();
    }

    @AfterEach
    void tearDown() {
        DeleteIssue deleteIssue = new DeleteIssue(webDriver);
        searchIssue.run();
        deleteIssue.run();

        webDriver.quit();
    }

    @Test
    public void editIssueSuccessfully() {
        // Given
        EditIssue editIssue = new EditIssue(webDriver);
        // When
        editIssue.run();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        WebElement popUpWindow = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(".aui-message.closeable.aui-message-success.aui-will-close")));
        // Then
        Assertions.assertNotNull(popUpWindow);
    }
}
