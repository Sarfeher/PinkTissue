package org.example.testCases.Project;

import org.example.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

class BrowseCoalaProjectTest {
    WebDriver webDriver;

    @BeforeEach
    public void setup() {
        webDriver = WebDriverProvider.setupWebDriver();
    }

    @Test
    public void test() {
        BrowseCoalaProject browseCoalaProject = new BrowseCoalaProject(webDriver);
        browseCoalaProject.run();

        WebElement projectFilterField = webDriver.findElement(By.xpath("//*[@id=\"project-name-val\"]"));
        String expected = "COALA project";

        Assertions.assertEquals(expected, projectFilterField.getText());
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