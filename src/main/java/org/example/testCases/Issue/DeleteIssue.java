package org.example.testCases.Issue;

import org.example.LogIn;
import org.example.testCases.Runnable;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeleteIssue extends Issue implements Runnable {
    public DeleteIssue(WebDriver webDriver, LogIn logIn) {
        super(webDriver, logIn);
    }

    @Override
    public void run() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement moreButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("opsbar-operations_more")));
        // Handle exception:
        try {
            moreButton.click();
        } catch (StaleElementReferenceException e) {
            e.getMessage();
            moreButton = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("opsbar-operations_more")));
            moreButton.click();
        }

        WebElement deleteButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"delete-issue\"]/a/span")));
        deleteButton.click();

        WebElement deleteConfirm = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("delete-issue-submit")));
        deleteConfirm.click();
    }
}
