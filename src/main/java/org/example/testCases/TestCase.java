package org.example.testCases;

import org.openqa.selenium.WebDriver;

public abstract class TestCase {
    protected final WebDriver webDriver;

    public TestCase(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
