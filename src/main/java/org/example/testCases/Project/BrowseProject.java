package org.example.testCases.Project;
import org.example.testCases.Runnable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowseProject implements Runnable {
    private final WebDriver webDriver;

    public BrowseProject(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public void run() {

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(1));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("browse_link")));
        WebElement projectButton = webDriver.findElement(By.id("browse_link"));
        projectButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("project_view_all_link_lnk")));
        WebElement viewAllProjectButton = webDriver.findElement(By.id("project_view_all_link_lnk"));
        viewAllProjectButton.click();

    }
}
