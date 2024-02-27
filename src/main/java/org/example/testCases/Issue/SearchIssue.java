package org.example.testCases.Issue;

import io.github.cdimascio.dotenv.Dotenv;
import org.example.LogIn;
import org.example.testCases.Runnable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchIssue extends Issue implements Runnable {
    private final Dotenv dotenv = Dotenv.load();

    public SearchIssue(WebDriver webDriver, LogIn logIn) {
        super(webDriver, logIn);
    }

    @Override
    public void run() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));

        WebElement issuesButton = webDriver.findElement(By.id("find_link"));
        issuesButton.click();

        WebElement searchForIssues = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("issues_new_search_link_lnk")));
        searchForIssues.click();

        WebElement searchInputField = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("searcher-query")));
        searchInputField.sendKeys(dotenv.get("JIRA_USERNAME"));
        // Pop-up message sometimes might be in the way:
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.aui-message")));

        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button[type='button'][original-title='Search for issues']")));
        searchButton.click();
    }
}
