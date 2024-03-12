package org.example.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseTestCase {
    protected final WebDriver webDriver;
    protected final WebDriverWait wait;

    public BaseTestCase(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        PageFactory.initElements(webDriver, this);
    }
}
