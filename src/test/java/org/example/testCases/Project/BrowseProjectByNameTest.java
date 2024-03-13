package org.example.testCases.Project;

import org.example.testCases.LoginLogout.SuccessfulLogin;
import org.example.testCases.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class BrowseProjectByNameTest {
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
        BrowseProjectByName browseProjectByName = new BrowseProjectByName(webDriver);
        browseProjectByName.run(projectName);

        WebElement filteredElement = webDriver.findElement(By.xpath("//*[@id='projects']/div/table/tbody/tr/td[1]/a"));

        Assertions.assertEquals(projectName, filteredElement.getText());
    }


    @AfterEach
    public void tearDown() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.err.println("Thread sleep interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            webDriver.quit();
        }
    }
}
