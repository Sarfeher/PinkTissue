package org.example.testCases.Project;

import org.example.testCases.Runnable;
import org.example.testCases.BaseTestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderProjectsByNameDescOrder extends BaseTestCase implements Runnable {
    @FindBy(xpath = "//*[@id=\"projects\"]/div/table/thead/tr/th[1]") private WebElement orderButtonByName;

    public OrderProjectsByNameDescOrder(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void run() {
        orderButtonByName.click();
    }
}
