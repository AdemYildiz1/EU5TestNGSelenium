package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxDemo {

    //Basically, one of interaction with checkbox does not affect on the other checkboxes
    //And we use the same methods as the methods of radio buttons

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkBox1 = driver.findElement(By.xpath("//input[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[2]"));

        //how to verify checkbox is selected or not? /see on the console
        System.out.println("checkBox1.isSelected() = " + checkBox1.isSelected());//false, default
        System.out.println("checkBox2.isSelected() = " + checkBox2.isSelected());//true, default

        //verify checkbox 1 is NOT selected selected, 2 is selected (according to default)
        Assert.assertFalse(checkBox1.isSelected(),"verify chexbox 1 is NOT selected");
        Assert.assertTrue(checkBox2.isSelected(),"verify chexbox 2 is selected");

        //how to check checkboxes?
        //just like the radio button we use the click() method
        Thread.sleep(2000);
        checkBox1.click();

        //verify after click
        Assert.assertTrue(checkBox1.isSelected(),"verify checkbox 1 is selected");
        Assert.assertTrue(checkBox2.isSelected(),"verify checkbox 2 is selected");

        Thread.sleep(2000);
        driver.quit();
    }


}
