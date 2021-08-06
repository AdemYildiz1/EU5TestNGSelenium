package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassNameTest {

    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement homeLink= driver.findElement(By.className("nav-link"));
        homeLink.click();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //prints multiple button headers
        //way-1
        System.out.println(driver.findElement(By.className("h3")).getText());

        /* class name LOCATOR
        If id,name,tagName is not useful then we use -className- locator
        .It is useful to locate multiple elements in one shot(we'll learn later)

        if there is space in value you CAN-NOT use it.

         */
    }
}
