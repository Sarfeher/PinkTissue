package org.example.testCases.Project;

import org.example.testCases.WebDriverProvider;
import org.example.testCases.LoginLogout.SuccessfulLogin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


class BrowseProjectTest {
    private WebDriver webDriver;

    @BeforeEach
    public void setup() {
        webDriver = WebDriverProvider.setupWebDriver();
        SuccessfulLogin logIn = new SuccessfulLogin(webDriver);
        logIn.run();
    }

    @Test
    public void test() {
        BrowseProject browseProject = new BrowseProject(webDriver);
        browseProject.run();

        WebElement projectFilterField = webDriver.findElement(By.id("project-filter-text"));

        Assertions.assertNotNull(projectFilterField);
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
