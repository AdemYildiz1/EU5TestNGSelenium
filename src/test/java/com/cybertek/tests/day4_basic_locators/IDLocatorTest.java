package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IDLocatorTest {

    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //click don't click button
        WebElement dontClickButton = driver.findElement(By.id("disappearing_button"));
        dontClickButton.click();


        /* id LOCATOR is first locator type that we will look for,

        -if static, use it
        -if dynamic, don't use it
        (check if id is dynamic with refreshing couple of time)
         */
    }
}
