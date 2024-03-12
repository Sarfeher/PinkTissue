package org.example.testCases.Issue;

import org.example.testCases.Runnable;
import org.example.testCases.BaseTestCase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditIssue extends BaseTestCase implements Runnable {
    @FindBy(id = "edit-issue")
    private WebElement editButton;
    @FindBy(id = "summary")
    private WebElement summary;
    @FindBy(id = "edit-issue-submit")
    private WebElement submitButton;
    @FindBy(css = ".aui-message.closeable.aui-message-success.aui-will-close")
    private WebElement popUpWindow;

    public EditIssue(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickEditIssue() {
        wait.until(ExpectedConditions.visibilityOf(editButton)).click();
    }

    public void editSummary() {
        String text = wait.until(ExpectedConditions.visibilityOf(summary)).getText();
        summary.sendKeys(text + "EDITED.");
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public boolean isPopUpWindow() {
        return null != wait.until(ExpectedConditions.visibilityOf(popUpWindow));
    }

    @Override
    public void run() {
        clickEditIssue();
        editSummary();
        clickSubmitButton();
    }
}
