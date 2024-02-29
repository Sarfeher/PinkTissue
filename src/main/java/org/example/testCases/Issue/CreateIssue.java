package org.example.testCases.Issue;

import io.github.cdimascio.dotenv.Dotenv;
import org.example.testCases.Runnable;
import org.example.testCases.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateIssue extends TestCase implements Runnable {
    private final Dotenv dotenv = Dotenv.load();

    public CreateIssue(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void run() {
        WebElement createIssueButton = webDriver.findElement(By.id("create_link"));
        createIssueButton.click();

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("create-issue-dialog")));

        WebElement summaryInputField = webDriver.findElement(By.id("summary"));
        summaryInputField.sendKeys(
                String.format("This is an automated created issue for testing purpose. Created by %s.",
                        dotenv.get("JIRA_USERNAME")));

        // IFRAME SWITCH:
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mce_0_ifr")));
        webDriver.switchTo().frame(iframe);

        WebElement descriptionInputField = webDriver.findElement(By.id("tinymce"));
        descriptionInputField.sendKeys("This is for testing purpose!");

        webDriver.switchTo().defaultContent();

        // SUBMIT:
        WebElement submitButton = webDriver.findElement(By.id("create-issue-submit"));
        submitButton.click();
    }
}
