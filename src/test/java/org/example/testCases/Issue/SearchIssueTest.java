package org.example.testCases.Issue;

import io.github.cdimascio.dotenv.Dotenv;
import org.example.LogIn;
import org.example.WebDriverProvider;
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
    private LogIn logIn;

    @BeforeEach
    void setUp() {
        webDriver = WebDriverProvider.setupWebDriver();
        logIn = new LogIn(webDriver);

        logIn.logIn();

        CreateIssue createIssue = new CreateIssue(webDriver, logIn);
        createIssue.run();
    }

    @AfterEach
    void tearDown() {
        DeleteIssue deleteIssue = new DeleteIssue(webDriver, logIn);
        deleteIssue.run();

        webDriver.quit();
    }

    @Test
    public void test() {
        // Given
        SearchIssue searchIssue = new SearchIssue(webDriver, logIn);
        // When
        searchIssue.run();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(8));
        WebElement issueTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("summary-val")));
        String titleText = issueTitle.getText();
        // Then
        Assertions.assertTrue(titleText.contains(dotenv.get("JIRA_USERNAME")));
    }
}
