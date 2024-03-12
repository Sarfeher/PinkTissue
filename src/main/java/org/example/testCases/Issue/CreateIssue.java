package org.example.testCases.Issue;

import io.github.cdimascio.dotenv.Dotenv;
import org.example.testCases.BaseTestCase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateIssue extends BaseTestCase implements Runnable {
    private final Dotenv dotenv = Dotenv.load();
    @FindBy(id = "create_link")
    private WebElement createIssueButton;
    @FindBy(id = "create-issue-dialog")
    private WebElement creatIssueDialog;
    @FindBy(id = "summary")
    private WebElement summaryInputField;
    @FindBy(id = "mce_0_ifr")
    private WebElement iframe;
    @FindBy(id = "tinymce")
    private WebElement descriptionInputField;
    @FindBy(id = "create-issue-submit")
    private WebElement submitButton;
    @FindBy(id = "header")
    private WebElement header;

    public CreateIssue(WebDriver webDriver) {
        super(webDriver);
    }

    private void clickCreateIssueButton() {
        createIssueButton.click();
    }

    public void createIssue() {
        wait.until(ExpectedConditions.visibilityOf(creatIssueDialog));
        summaryInputField.sendKeys(
                String.format("This is an automated created issue for testing purpose. Created by %s.",
                        dotenv.get("JIRA_USERNAME")));

        switchIframe();
    }

    private void switchIframe() {
        wait.until(ExpectedConditions.visibilityOf(iframe));
        webDriver.switchTo().frame(iframe);
        descriptionInputField.sendKeys("This is for testing purpose!");
        webDriver.switchTo().defaultContent();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public String getHeader() {
        return header.getAttribute("aria-hidden");
    }

    @Override
    public void run() {
        clickCreateIssueButton();
        createIssue();
        clickSubmitButton();
    }
}
