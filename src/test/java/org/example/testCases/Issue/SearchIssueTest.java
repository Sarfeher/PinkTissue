package org.example.testCases.Issue;

import io.github.cdimascio.dotenv.Dotenv;
import org.example.testCases.LoginLogout.SuccessfulLogin;
import org.example.testCases.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

class SearchIssueTest {
    private final Dotenv dotenv = Dotenv.load();
    private WebDriver webDriver;

    @BeforeEach
    void setUp() {
        webDriver = WebDriverProvider.setupWebDriver();
        SuccessfulLogin logIn = new SuccessfulLogin(webDriver);
        webDriver.navigate().to(SuccessfulLogin.URL);
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
        // Arrange
        SearchIssue searchIssue = new SearchIssue(webDriver);
        // Act
        searchIssue.run();
        String titleText = searchIssue.getTitleText();
        // Assert
        Assertions.assertTrue(titleText.contains(dotenv.get("JIRA_USERNAME")));
    }
}
