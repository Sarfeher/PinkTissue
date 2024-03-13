package org.example.testCases.Issue;

import org.example.testCases.LoginLogout.SuccessfulLogin;
import org.example.testCases.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

class CreateIssueTest {
    private WebDriver webDriver;

    @BeforeEach
    void setUp() {
        webDriver = WebDriverProvider.setupWebDriver();
        SuccessfulLogin logIn = new SuccessfulLogin(webDriver);
        webDriver.navigate().to(SuccessfulLogin.URL);
        logIn.run();
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
        // Arrange
        CreateIssue createIssue = new CreateIssue(webDriver);
        // Act
        createIssue.run();
        String headerAttribute = createIssue.getHeader();
        // Assert
        Assertions.assertNull(headerAttribute);
    }
}
