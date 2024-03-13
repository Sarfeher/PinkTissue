package org.example.testCases.Project;

import org.example.testCases.BaseTestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BrowseProjectByLead extends BaseTestCase {
    @FindBy(id = "project-filter-text")
    WebElement searchBar;
    @FindAll
            (@FindBy(xpath = "//*[text()='Admin']"))
    List<WebElement> searchedLead;
    @FindAll(@FindBy(tagName = "tr"))
    List<WebElement> rows;

    public BrowseProjectByLead(WebDriver webDriver) {
        super(webDriver);
    }
    public void run(String projectLead) {
        searchBar.sendKeys(projectLead);
        searchedLead = webDriver.findElements(By.xpath("//*[text()='" + projectLead + "']"));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"), searchedLead.size() + 1));
    }

    public boolean isEqual() {
        return searchedLead.size() == (rows.size() - 1);
    }
}
