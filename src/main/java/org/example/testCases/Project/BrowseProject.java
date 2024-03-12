package org.example.testCases.Project;

import org.example.testCases.Runnable;
import org.example.testCases.BaseTestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowseProject extends BaseTestCase implements Runnable {
    @FindBy(id = "browse_link") private WebElement projectButton;
    @FindBy(id = "project_view_all_link_lnk") private WebElement viewAllProjectButton;

    public BrowseProject(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void run() {
        wait.until(ExpectedConditions.visibilityOf(projectButton));
        projectButton.click();
        wait.until(ExpectedConditions.visibilityOf(viewAllProjectButton));
        viewAllProjectButton.click();
    }
}
