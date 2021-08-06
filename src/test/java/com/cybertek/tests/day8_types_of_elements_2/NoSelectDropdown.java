package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropdown {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void Test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropdownElement= driver.findElement(By.id("dropdownMenuLink"));

       //click the dropdown to see available options
        dropdownElement.click();
        Thread.sleep(2000);

        //If it has no select tag, then no creating object
        //so we use regular way(as we did in ListOfClass) to get all the options in the dropdown
        //We can use (className,tagName..etc) as a locator that can be common between them/list
        //Then we can use List methods to get size, expected options from list.
        List<WebElement> dropdownOptions =  driver.findElements(By.className("dropdown-item"));

        //print size of options
        System.out.println("dropdownOptions.size() = " + dropdownOptions.size());
        Assert.assertEquals(dropdownOptions.size(),5,"verfy size of options");

        //print them one by one
        for (WebElement option : dropdownOptions) {
            System.out.println(option.getText());
        }
        //click yahoo
        dropdownOptions.get(2).click();



    }
}
