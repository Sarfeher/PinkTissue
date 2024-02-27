package org.example.testCases.Issue;

import org.example.testCases.Runnable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeleteIssue implements Runnable {
    private final WebDriver webDriver;
    private final SearchIssue searchIssue;

    public DeleteIssue(WebDriver webDriver, SearchIssue searchIssue) {
        this.webDriver = webDriver;
        this.searchIssue = searchIssue;
    }

    @Override
    public void run() {
        searchIssue.run();

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        WebElement moreButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("opsbar-operations_more")));
        moreButton.click();

        WebElement deleteButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"delete-issue\"]/a/span")));
        deleteButton.click();

        WebElement deleteConfirm = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("delete-issue-submit")));
        deleteConfirm.click();
    }
}
