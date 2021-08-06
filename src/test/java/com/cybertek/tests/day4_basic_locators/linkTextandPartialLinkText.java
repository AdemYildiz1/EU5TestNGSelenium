package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class linkTextandPartialLinkText {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        //By.linkText(""); it works for all text of link to locate link webelement on the page
        WebElement link1=driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger"));
        link1.click();

        //By.partialLinkText(""); it works for unique part of link to locate link webelement on the page
        WebElement link4 = driver.findElement(By.partialLinkText("Example 4"));
        link4.click();


    }
}
