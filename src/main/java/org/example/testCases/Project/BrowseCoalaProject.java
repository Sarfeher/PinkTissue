package org.example.testCases.Project;

import org.example.testCases.BaseTestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowseCoalaProject extends BaseTestCase implements Runnable {

    public BrowseCoalaProject(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void run() {

        WebElement searchBar = webDriver.findElement(By.xpath("//*[@id='project-filter-text']"));
        searchBar.sendKeys("COALA");

        WebElement nameOfProject = webDriver.findElement(By.xpath("//*[@id=\"projects\"]/div/table/tbody/tr/td[1]/a"));
        nameOfProject.click();

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(1));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"project-name-val\"]")));


    }
}
