package org.example.testCases.Issue;

import io.github.cdimascio.dotenv.Dotenv;
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

class SearchIssueTest {
    private final Dotenv dotenv = Dotenv.load();
    private WebDriver webDriver;

    @BeforeEach
    void setUp() {
        webDriver = WebDriverProvider.setupWebDriver();
        SuccessfulLogin logIn = new SuccessfulLogin(webDriver);

        logIn.run();

        CreateIssue createIssue = new CreateIssue(webDriver);
        createIssue.run();
    }

    @AfterEach
    void tearDown() {
        DeleteIssue deleteIssue = new DeleteIssue(webDriver);
        deleteIssue.run();

        webDriver.quit();
    }

    @Test
    public void test() {
        // Given
        SearchIssue searchIssue = new SearchIssue(webDriver);
        // When
        searchIssue.run();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(8));
        WebElement issueTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("summary-val")));
        String titleText = issueTitle.getText();
        // Then
        Assertions.assertTrue(titleText.contains(dotenv.get("JIRA_USERNAME")));
    }
}
