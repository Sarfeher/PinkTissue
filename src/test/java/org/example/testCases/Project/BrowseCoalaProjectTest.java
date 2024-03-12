package org.example.testCases.Project;

import org.example.testCases.WebDriverProvider;
import org.example.testCases.LoginLogout.SuccessfulLogin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class BrowseCoalaProjectTest {
    private WebDriver webDriver;

    @BeforeEach
    public void setup() {
        webDriver = WebDriverProvider.setupWebDriver();
        SuccessfulLogin logIn = new SuccessfulLogin(webDriver);
        BrowseProject browseProject = new BrowseProject(webDriver);
        webDriver.navigate().to(SuccessfulLogin.URL);
        logIn.run();
        browseProject.run();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/project.csv", numLinesToSkip = 1)
    public void test(String projectName) {
        BrowseCoalaProject browseCoalaProject = new BrowseCoalaProject(webDriver);
        browseCoalaProject.run(projectName);
        WebElement filteredElement = webDriver.findElement(By.xpath("//*[@id='projects']/div/table/tbody/tr/td[1]/a"));
        //WebElement projectFilterField = webDriver.findElement(By.xpath("//*[@id=\"project-name-val\"]"));
        //Assertions.assertEquals(projectName, projectFilterField.getText());
        System.out.println(projectName + " project name");
        System.out.println(filteredElement.getText() + " get text");
        System.out.println(filteredElement);
        System.out.println(filteredElement.getAttribute("title") + " ez a title");
        Assertions.assertEquals(projectName, filteredElement.getText());
    }
    //*[@id="projects"]/div/table/tbody/tr/td[1]/a/text()

    @AfterEach
    public void tearDown() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.err.println("Thread sleep interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
           // webDriver.quit();
        }
    }
}
