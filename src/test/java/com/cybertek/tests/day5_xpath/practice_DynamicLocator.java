package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class practice_DynamicLocator {
    public static void main(String[] args) {

        //write a locator for etsy.com based on text variable, locator will dynamically change.
        
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.etsy.com");

        String text = "Clothing & Shoes";

        WebElement xPathText= driver.findElement(By.xpath("//ul[@data-ui='top-nav-category-list']//span[contains(text(),'"+ text+"')]"));

        System.out.println(xPathText.getText());




    }
}
