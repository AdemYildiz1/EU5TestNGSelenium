package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElements {

    //When we try to interact with disabled elements 2 things can happen:
    //1.no action will be happen and code will not fail, not complain
    //2.no action will be happen but we can get ElementNotInteractableException: element not intractable

    //1.no action will be happen and code will not fail, not complain
    @Test
    public void test1(){
        WebDriver driver= WebDriverFactory.getDriver("CHROME");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement greenRadioBtn=driver.findElement(By.id("green"));

         //how to check any element is enabled or not"
        System.out.println("greenRadioBtn.isEnabled(): "+greenRadioBtn.isEnabled());
        Assert.assertFalse(greenRadioBtn.isEnabled(),"Verify green radio button NOT enabled(disabled)");

        greenRadioBtn.click();
    }
    //2.no action will be happen but we can get ElementNotInteractableException: element not intractable
    @Test
    public void test2(){
        WebDriver driver= WebDriverFactory.getDriver("CHROME");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputBox= driver.findElement(By.cssSelector("#input-example>input"));
        inputBox.sendKeys("some message"); //"element not intractable" appears while it fails
    }

}
