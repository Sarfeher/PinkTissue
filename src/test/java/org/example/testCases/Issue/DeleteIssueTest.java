package org.example.testCases.Issue;

import org.example.testCases.LoginLogout.SuccessfulLogin;
import org.example.testCases.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

class DeleteIssueTest {
    private WebDriver webDriver;

    @BeforeEach
    void setUp() {
        webDriver = WebDriverProvider.setupWebDriver();
        SuccessfulLogin logIn = new SuccessfulLogin(webDriver);
        webDriver.navigate().to(SuccessfulLogin.URL);
        logIn.run();

        CreateIssue createIssue = new CreateIssue(webDriver);
        createIssue.run();

        SearchIssue searchIssue = new SearchIssue(webDriver);
        searchIssue.run();
    }

    @AfterEach
    void tearDown() {
        webDriver.quit();
    }

    @Test
    public void deleteIssueSuccessfully() {
        // Arrange
        DeleteIssue deleteIssue = new DeleteIssue(webDriver);
        // Act
        deleteIssue.run();
        boolean isPopUpWindow = deleteIssue.isPopUpWindow();
        // Assert
        Assertions.assertTrue(isPopUpWindow);
    }
}
