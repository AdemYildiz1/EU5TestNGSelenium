package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ThreadSleepExample {

    /* in web page during loading time, there could be some differences,
    For Example;
    -Here, our web element in html is being part of html but hidden (during loading time)
    here, while locating/finding no error no complain, but if you try to use that element you can not interact during loading
    it fails if you don't put "wait" it will say in console: ElementNotInteractableException
     */
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("CHROME");

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/3");


        Thread.sleep(6000);
        //it is STATIC WAIT= it will not check any condition it comes from java
        //Here, It waits 6000 no mather what our condition has,for eg; what if loading is too long or too less
        //so it is not so useful, especially it extends your regression execution time, that's why we need DYNAMIC WAIT.
        //DYNAMIC WAIT can check if element is clickable,visible or internet is fat..etc


        WebElement inputBox=driver.findElement(By.id("username"));
        inputBox.sendKeys("MikeSmith");
        //before sendKeys sends value to username box, it needs displaying on the screen. But,
        //our web element (username box) is not displayed on the screen on the certain time/because of loading time
        //so it fails. to be able to solve that problem we waits with "Thread.sleep(6000)"

    }
}
