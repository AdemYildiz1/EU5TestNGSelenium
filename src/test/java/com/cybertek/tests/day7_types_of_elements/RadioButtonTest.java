package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    /*Features Radio buttons;
    you may not have multiple selection option
    it is selected. But after selecting you can change selected one by clicking another one
    Basically,means one of interaction radio button affects other one
    */

    //Test Case; Verify if radio buttons selected
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        //location radio buttons
        WebElement blueRadioBtn= driver.findElement(By.cssSelector("#blue"));
        WebElement redRadioBtn= driver.findElement(By.cssSelector("#red"));

        //how to check radio button is selected
        System.out.println("blueRadioBtn.isSelected(): "+blueRadioBtn.isSelected());
        System.out.println("redRadioBtn.isSelected(): "+redRadioBtn.isSelected());

        //1st We'll verify blue is selected red is NOT selected
        //blue--> returns true
        Assert.assertTrue(blueRadioBtn.isSelected(),"verify that blue is selected");
        //red-->false
        Assert.assertFalse(redRadioBtn.isSelected(),"verify that red is NOT selected");


        ////2nd We'll verify blue is NOT selected red is selected(Completely opposite of 1st assertion versions)
        //Click red button, here red will be selected blue will not.
        redRadioBtn.click();

        //blue-->false
        Assert.assertFalse(blueRadioBtn.isSelected(),"verify that blue is NOT selected");
        //red-->true
        Assert.assertTrue(redRadioBtn.isSelected(),"verify that red is selected");


        Thread.sleep(3000);
        driver.quit();
    }
}
