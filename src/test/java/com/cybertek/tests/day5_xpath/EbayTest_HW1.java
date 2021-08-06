package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbayTest_HW1 {

    public static void main(String[] args) {
        /* Test case 1
         1-Go to Ebay
         2-enter search term
         3-click on search button
         4-print number of results
         */

        //1-
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com");

        //2-
        WebElement searchBox =driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("term");

        //3-
        driver.findElement(By.id("gh-btn")).click();

        //4-
        WebElement NumberOfResult = driver.findElement(By.xpath("//h1/span"));
        NumberOfResult.getText();
        System.out.println(NumberOfResult.getText());

        driver.quit();

    }
}
