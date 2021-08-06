package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitExample {
    /*
    -Here, our web element in html is NOT part of the html until certain time(during loading time)
     while finding/locating element it complains, fails directly.
     if you don't put "wait" it will say in console: NoSuchElementException

    we can solve it by using generally with dynamic ways not static way
    DYNAMIC WAIT-1
     1- ImplicitWait type--> driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS)
     calls it once, (set of driver)
     !!!WAITS UNTIL ELEMENT IS FOUND(till it appears in html) in certain time. It comes from selenium.
     it will check till the time is specified, once it finds at any time it moves on/ run.
     if it does not find till that time, then it will give us NoSuchElementException
     */
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("CHROME");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //we put here for each findElement method
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");

        WebElement element = driver.findElement(By.cssSelector("#finish"));

        System.out.println(element.getText());
    }
}