package org.example.testCases.Issue;

import org.example.testCases.LoginLogout.SuccessfulLogin;
import org.example.testCases.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

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
        deleteIssue.run();

        webDriver.quit();
    }

    @Test
    public void editIssueSuccessfully() {
        // Arrange
        EditIssue editIssue = new EditIssue(webDriver);
        // Act
        editIssue.run();
        boolean isPopUpWindow = editIssue.isPopUpWindow();
        // Assert
        Assertions.assertTrue(isPopUpWindow);
    }
}
