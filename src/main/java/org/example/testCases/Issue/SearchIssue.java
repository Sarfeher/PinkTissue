package org.example.testCases.Issue;

import io.github.cdimascio.dotenv.Dotenv;
import org.example.testCases.BaseTestCase;
import org.example.testCases.Runnable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchIssue extends BaseTestCase implements Runnable {
    private final Dotenv dotenv = Dotenv.load();
    @FindBy(id = "find_link")
    private WebElement issuesButton;
    @FindBy(id = "issues_new_search_link_lnk")
    private WebElement searchForIssues;
    @FindBy(id = "searcher-query")
    private WebElement searchInputField;
    @FindBy(css = "div.aui-message")
    private WebElement message;
    @FindBy(css = "button[type='button'][original-title='Search for issues']")
    private WebElement searchButton;
    @FindBy(id = "summary-val")
    private WebElement issueTitle;

    public SearchIssue(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickIssues() {
        issuesButton.click();
    }

    public void clickSearchIssues() {
        wait.until(ExpectedConditions.visibilityOf(searchForIssues)).click();
    }

    public void fillInputField() {
        wait.until(ExpectedConditions.elementToBeClickable(searchInputField))
                .sendKeys(dotenv.get("JIRA_USERNAME"));
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.invisibilityOf(message));
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public String getTitleText() {
        return wait.until(ExpectedConditions.visibilityOf(issueTitle)).getText();
    }

    @Override
    public void run() {
        clickIssues();
        clickSearchIssues();
        fillInputField();
        clickSearchButton();
    }
}
