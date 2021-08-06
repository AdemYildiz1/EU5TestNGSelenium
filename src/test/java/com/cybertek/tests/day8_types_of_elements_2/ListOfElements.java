package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    //How to find and interact with more than one elements at a time?-->findElements()

    WebDriver driver;

    @BeforeMethod
    public void setUP(){
        driver= WebDriverFactory.getDriver("CHROME");

    }

    @AfterMethod
    public void test2() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void Test1(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //to locate, we find common locator between them, it could be tagName, class name or sth else
        //This is not just one element it is list of element so our elements is saved in List./Like ArrayList
        List<WebElement> buttons = driver.findElements(By.tagName("button"));//shortcut, alt+enter

        System.out.println("buttons.size() = " + buttons.size());//6

        //verify button size
        Assert.assertEquals(buttons.size(),6,"verify buttons size");

        //to print each one, we use for each loop. Shortcut to create; write iter and click enter
        for (WebElement button : buttons) {
            System.out.println("button.isDisplayed() = " + button.isDisplayed());
            Assert.assertTrue(button.isDisplayed(),"verify button is displayed");
        }

        //click second button-remember index start 0 in array
        buttons.get(1).click();

    }
    //findElements() method does not throw NoSuchElementException, if you locator is wrong it will return you empty list.
    //so it looks test passed. That's why we use size()   verification to find out correct result!
    @Test
    public void Test2(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //regular findElement method will throw No Such Element(NSE) if locator does not exist
        driver.findElement(By.tagName("buthwertyuikxfdfd"));//it fails

        // But findElements will NOT throw NSE even If locator does not exist
        List<WebElement> buttons = driver.findElements(By.tagName("buttonsdfghjdfghjt"));//it passed
        System.out.println("buttons.size() = " + buttons.size()); //0  ,   verification says fail


    }
}
