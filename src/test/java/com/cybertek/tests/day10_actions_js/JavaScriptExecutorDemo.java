package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorDemo {
    WebDriver driver;

    //some times we can NOT click in selenium
    //Selenium does NOT have scroll down or scroll up option
    //And we can type in input box even though it is not clickable
    //So in these cases we force I mean we do them with javaScriptExecutor

    //here, after casting  we use google to search how people solved this problem (screenshot in selenium)
    //write how to solve problem and click the stack overflow and see how people solved then copy past.

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
    public void ClickWithJs() {
        driver.get("http://practice.cybertekschool.com/");

        WebElement dropdownLink = driver.findElement(By.linkText("Dropdown"));

        JavascriptExecutor jse = (JavascriptExecutor) driver; //here casting should be done.

        jse.executeScript("arguments[0].click();", dropdownLink);
    }

    @Test
    //we can NOT send some text with senKeys without enabling the box
    //we did it before with enabling. Now we use by forcing with JS
    public void typeWithJS() {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //we searched google how to sendKeys in selenium with JS
        String text = "Hello disabled input"; //Text that we sent

        jse.executeScript("arguments[0].setAttribute('value', '" + text + "')", inputBox);

    }

    @Test
    public void ScrollDownAndUp() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();

        //here page is scrolling down so noo need to find element

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //jse.executeScript("scrollBy(0, 250);")

        //scroll down
        //jse.executeScript("scroll(0, 250);"); //we searched in google  how to scrolldown with JS in selenium
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            jse.executeScript("scrollBy(0, 250);");//to see/observe well that's why we put it  in loop
        }
        // scroll up
        //jse.executeScript("scroll(0, -250);");
        for (int a = 0; a < 10; a++) {
            Thread.sleep(1000);
            jse.executeScript("scrollBy(0, -250);");
        }
    }
    @Test
    //scroll until element that you want
    public void scrollToElement() throws InterruptedException {
        driver.get("https://www.amazon.com/");

        WebElement eng=driver.findElement(By.id("icp-touch-link-language"));

        Thread.sleep(2000);

        JavascriptExecutor jse=(JavascriptExecutor) driver;

        //we searched in google how to scroll till element
        jse.executeScript("arguments[0].scrollIntoView(true);", eng);
    }
}
