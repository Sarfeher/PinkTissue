package org.example.testCases.Project;

import org.example.testCases.LoginLogout.SuccessfulLogin;
import org.example.testCases.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

class OrderProjectsByNameDescOrderTest {
    private WebDriver webDriver;
    @FindBy(xpath = "//*[@id=\"projects\"]/div/table/tbody/tr[1]/td[1]/a")
    private WebElement projectFilterField;

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
        OrderProjectsByNameDescOrder orderProjectsByNameDescOrder = new OrderProjectsByNameDescOrder(webDriver);
        orderProjectsByNameDescOrder.run();

        String expected = "Use It To Practice Project";

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
