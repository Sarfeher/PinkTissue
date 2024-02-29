package org.example.testCases.Project;

import org.example.testCases.Runnable;
import org.example.testCases.BaseTestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderProjectsByNameDescOrder extends BaseTestCase implements Runnable {

    public OrderProjectsByNameDescOrder(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void run() {
        WebElement orderButtonByName = webDriver.findElement(By.xpath("//*[@id=\"projects\"]/div/table/thead/tr/th[1]"));
        orderButtonByName.click();
    }
}
