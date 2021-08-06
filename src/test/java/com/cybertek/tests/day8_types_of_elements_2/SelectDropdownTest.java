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

public class SelectDropdownTest {
    //How to locate and interact Dropdown menu that offers a list of options.
    //first, check if you have select tag while finding locator, if so we can locate just like we did before

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
    public void Test1(){
        driver.get("http://practice.cybertekschool.com/dropdown");

        //1- locate your dropdown element just like before
        WebElement dropdownElement=driver.findElement(By.id("state"));
        
        //2- Create an object to use special methods that comes from Select class in Selenium
        //then, pass element as a constructor parameter
        Select stateDropdown=new Select(dropdownElement);

        //getOptions()--> returns all the available options from the dropdown
        List<WebElement> options = stateDropdown.getOptions();
        
        //then u can use it whatever you want to do with it.
        //example;
        //print size of options
        System.out.println("options.size() = " + options.size());

        //prints option one by one
        for (WebElement option : options) {
            System.out.println(option.getText());

        }
    }
    @Test
    public void Test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");

        //1- locating dropdown
        WebElement dropdownElement=driver.findElement(By.id("state"));

        //2- creating object
        Select stateDropdown=new Select(dropdownElement);

        //verify that first selection is select a State.
        String expectedOption="Select a State";
        String actualOption=stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption,actualOption,"verify first selection");

        //HOW TO SELECT OPTIONS FROM DROPDOWN -we have 3 types of it
        //1- Select using visible text
        Thread.sleep(2000);
        stateDropdown.selectByVisibleText("Virginia");

        //let's verify if Virginia is selected
        expectedOption="Virginia"; //we used former String bucket:)
        actualOption=stateDropdown.getFirstSelectedOption().getText(); //here, firstselected must be what we currently selected
        Assert.assertEquals(actualOption,expectedOption,"verify first selection");

        //2- Select using index
        Thread.sleep(2000);
        stateDropdown.selectByIndex(51);

        expectedOption="Wyoming";
        actualOption=stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"verify first selection");

        //3- select using value
        Thread.sleep(2000);
        stateDropdown.selectByValue("TX"); //it becomes first selected after selecting

        expectedOption="Texas";
        actualOption=stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"verify first selection");

    }
}
