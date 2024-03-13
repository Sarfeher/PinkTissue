package org.example.testCases.Project;

import org.example.testCases.LoginLogout.SuccessfulLogin;
import org.example.testCases.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

class BrowseAllAdminProjectTest {

    private WebDriver webDriver;

    @BeforeEach
    public void setup() {
        webDriver = WebDriverProvider.setupWebDriver();
        SuccessfulLogin logIn = new SuccessfulLogin(webDriver);
        BrowseProject browseProject = new BrowseProject(webDriver);
        logIn.run();
        browseProject.run();
    }

    @Test
    public void test() {
        BrowseAllAdminProject browseAllAdminProject = new BrowseAllAdminProject(webDriver);
        browseAllAdminProject.run();

        int sizeOfAdmin = webDriver.findElements(By.xpath("//*[text()='Admin']")).size();
        WebElement tableBody = webDriver.findElement(By.className("projects-list"));
        List<WebElement> rows = tableBody.findElements(By.tagName("tr"));

        Assertions.assertEquals(sizeOfAdmin, rows.size() - 1);

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
