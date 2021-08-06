package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitExample {

    /*
    ImplicitWait do we have webElement in a part of htm or not
    type Does not care element is clickable, interactable, visible,enabled,disabled or url is switching to sth else..etc
    so in this cases we use;
    DYNAMIC WAIT
    2- Explicitly type: -> after creating object->wait.until(ExpectedConditions.visibilityOf
    !!! it waits until certain condition matches

    Here, our web element in html is being part of html so NO complain , error while finding/locating element
    but Element is not displayed on the screen.
    So you try to use the element, it fails. So if you don't put "wait" it will say in console: ElementNotInteractableException.
     */

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("CHROME");

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        driver.findElement(By.tagName("button")).click();

        WebElement usernameInput = driver.findElement(By.id("username"));

        //How to wait explicitly?
        //create Explicit wait object
        WebDriverWait wait =new WebDriverWait(driver,10);

        wait.until(ExpectedConditions.visibilityOf(usernameInput));// it waits till userInput is visible

        usernameInput.sendKeys("MikeSmith");
    }
    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        //click enable
        driver.findElement(By.xpath("//*[.='Enable']")).click();

        //finding inputbox
        WebElement inputBox =driver.findElement(By.cssSelector("#input-example>input"));

        WebDriverWait wait=new WebDriverWait(driver,10); //if time is not enough it gives timeoutException

        wait.until(ExpectedConditions.elementToBeClickable(inputBox));//it waits till inputBox is clickable

        inputBox.sendKeys("MikeSmith");
        //!if no any "wait" it says ElementNotInteractableException




    }
}