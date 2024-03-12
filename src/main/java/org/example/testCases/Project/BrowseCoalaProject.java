package org.example.testCases.Project;

import org.example.testCases.BaseTestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowseCoalaProject extends BaseTestCase{

    public BrowseCoalaProject(WebDriver webDriver) {
        super(webDriver);
    }

    public void run(String projectName) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(1));

        WebElement searchBar = webDriver.findElement(By.xpath("//*[@id='project-filter-text']"));
        searchBar.sendKeys(projectName);
        searchBar.submit();

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        WebElement nameOfProject = webDriver.findElement(By.xpath("//*[@id=\"projects\"]/div/table/tbody/tr/td[1]/a"));
        nameOfProject.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"project-name-val\"]")));


    }
}
