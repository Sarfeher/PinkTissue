package org.example.testCases.Project;

import org.example.testCases.BaseTestCase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BrowseCoalaProject extends BaseTestCase {
    @FindBy(id = "project-filter-text")
    private WebElement searchBar;
    @FindBy(xpath = "//*[@id=\"project-name-val\"]")
    private WebElement project;
    @FindBy(xpath = "//*[@id=\"projects\"]/div/table/tbody/tr/td[1]/a")
    private WebElement projectNameInTable;

    public BrowseCoalaProject(WebDriver webDriver) {
        super(webDriver);
    }

    public void run(String projectName) {
        searchBar.sendKeys(projectName);
        wait.until(ExpectedConditions.attributeToBe(projectNameInTable, "title", projectName));
    }
}
