package org.example.testCases.Issue;

import org.example.testCases.Runnable;
import org.example.testCases.BaseTestCase;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DeleteIssue extends BaseTestCase implements Runnable {
    @FindBy(id = "delete-issue")
    private WebElement deleteButton;
    @FindBy(id = "delete-issue-submit")
    private WebElement deleteConfirm;
    @FindBy(id = "opsbar-operations_more")
    private WebElement moreButton;
    @FindBy(css = ".aui-message.closeable.aui-message-success.aui-will-close")
    private WebElement popUpWindow;

    public DeleteIssue(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickMoreButton() {
        try {
            wait.until(ExpectedConditions.visibilityOf(moreButton)).click();
        } catch (StaleElementReferenceException e) {
            e.getMessage();
            wait.until(ExpectedConditions.visibilityOf(moreButton)).click();
        }
    }

    public void clickDeleteButton() {
        wait.until(ExpectedConditions.visibilityOf(deleteButton)).click();
    }

    public void clickDeleteConfirm() {
        wait.until(ExpectedConditions.visibilityOf(deleteConfirm)).click();
    }

    public boolean isPopUpWindow() {
        return null != wait.until(ExpectedConditions.visibilityOf(popUpWindow));
    }

    @Override
    public void run() {
        clickMoreButton();
        clickDeleteButton();
        clickDeleteConfirm();
    }
}
