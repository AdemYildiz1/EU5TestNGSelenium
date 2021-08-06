package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TagNameLocator {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //this makes browser full screen
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

        //send keys to full name
        WebElement fullNameInput = driver.findElement(By.tagName("input"));
        fullNameInput.sendKeys("Mike Smith With TagName");

        //send keys to email
        WebElement emailInput  = driver.findElement(By.name("email"));
        emailInput.sendKeys("mike@smith.com");

        //click button with lazy way
        driver.findElement(By.tagName("button")).click();

        Thread.sleep(3000);

        //close browser
        driver.close();

        /*Tag LOCATOR
        -If we can't use -id- or -name- we look for tag name to locate our web element.

        we use tag name; if
        .tag is used only one time
        .there are multiple same tags but you want to point the first tag

        -check if it is first or jus it is used for one time
        .ctrl-F and write your tag name it shows how many this tag name we have.
        because selenium reads the source code from top bottom

        we can not use -index- while we are using -tag name-.
         */
    }
}



