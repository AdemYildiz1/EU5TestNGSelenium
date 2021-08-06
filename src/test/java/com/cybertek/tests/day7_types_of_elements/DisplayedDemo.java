package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {

    @Test
    public void Test1() throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement usernameInput= driver.findElement(By.cssSelector("#username"));
        System.out.println("usernameInput.isDisplayed() = " + usernameInput.isDisplayed());//prints true or not

        //TASK
        //1- Verify usernameInput is not displayed on the screen
        //2- Click start button
        //3- verify user name displayed on the screen.

        //1- Verify usernameInput is not displayed on the screen
        Assert.assertFalse(usernameInput.isDisplayed(),"Verify username Input box is NOT displayed");

        //2- Click start button;
        WebElement startButton=driver.findElement(By.cssSelector("#start>button"));
        startButton.click();

        //It takes time after click start button so wait until element display otherwise it fails
        Thread.sleep(6000);

        //3- verify user name displayed on the screen.
        Assert.assertTrue(usernameInput.isDisplayed(),"Verify username Input box is displayed");


        driver.quit();


    }
}
