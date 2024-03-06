package org.example.testCases;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.testCases.LoginLogout.SuccessfulLogin;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StepDefinitions {

    private SuccessfulLogin successfulLogin;
    private final WebDriver webDriver = WebDriverProvider.setupWebDriver();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        successfulLogin = new SuccessfulLogin(webDriver);
    }
    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        successfulLogin.run();
    }
    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        WebElement userOption = webDriver.findElement(By.id("user-options"));
        Assertions.assertNotNull(userOption);
        webDriver.quit();
    }
}
