package org.example.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverProvider {
    private static final String BROWSER_VERSION = "122";

    public static WebDriver setupWebDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion(BROWSER_VERSION);

        return new ChromeDriver(chromeOptions);
    }
}
