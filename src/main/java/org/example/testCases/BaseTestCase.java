package org.example.testCases;

import org.openqa.selenium.WebDriver;

public abstract class BaseTestCase {
    protected final WebDriver webDriver;

    public BaseTestCase(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
