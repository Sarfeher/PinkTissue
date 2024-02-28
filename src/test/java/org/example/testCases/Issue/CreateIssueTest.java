package org.example.testCases.Issue;

import org.example.LogIn;
import org.example.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class CreateIssueTest {
    private WebDriver webDriver;

    @BeforeEach
    void setUp() {
        webDriver = WebDriverProvider.setupWebDriver();
        LogIn logIn = new LogIn(webDriver);

        logIn.logIn();
    }

    @AfterEach
    void tearDown() {
        SearchIssue searchIssue = new SearchIssue(webDriver);
        DeleteIssue deleteIssue = new DeleteIssue(webDriver);
        searchIssue.run();
        deleteIssue.run();

        webDriver.quit();
    }

    @Test
    public void createIssueSuccessfully() {
        // Given
        CreateIssue createIssue = new CreateIssue(webDriver);
        // When
        createIssue.run();
        WebElement header = webDriver.findElement(By.id("header"));
        String headerAttribute = header.getAttribute("aria-hidden");
        // Then
        Assertions.assertNull(headerAttribute);
    }
}
