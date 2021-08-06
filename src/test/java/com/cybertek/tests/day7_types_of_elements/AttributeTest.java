package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AttributeTest {
    /*
         When we need to get text of the web element
          1.getText();    -->we've already learnt

          2.getAttribute("value");     -->(inputboxes) we've learn but/it gets attribute value as well
          3.getAttribute("outerHTML"); --> manipulate and verify(contains)
          4.getAttribute("innerHTML"); --> it will work certain cases
     */
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioButton= driver.findElement(By.id("blue"));

        //REMEMBER Whatever we passed to inputboxes we used it to get the text from inputbox
        blueRadioButton.getAttribute("value");

        //2- getAttribute("value")
        //examples;
        //get the value of type attribute
        System.out.println(blueRadioButton.getAttribute("type")); //radio
        //get the value of name attribute
        System.out.println(blueRadioButton.getAttribute("name")); //color
        //get the value of checked
        //Since check attribute does not keep any value, it will return true or false based on the condition
        System.out.println(blueRadioButton.getAttribute("checked"));//true or false(means default button is selected or no)

        //trying to get attribute that does not exist
        //when we use non exist attribute it will return null to us.
        System.out.println(blueRadioButton.getAttribute("href")); //returns null

        //3- getAttribute("outerHTML"); --> manipulate and verify(contains)
        System.out.println(blueRadioButton.getAttribute("outerHTML"));// returns full html of that web elements.

        //Example; how can we use outerHTML attribute
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement button2= driver.findElement(By.name("button2"));

        String outerHTML=button2.getAttribute("outerHTML");
        System.out.println("outerHTML = " + outerHTML);

        Assert.assertTrue(outerHTML.contains("button2"));

        //4- getAttribute("innerHTML")
        System.out.println("inner HTML: "+button2.getAttribute("innerHTML")); //gets the text of that element


        driver.quit();
    }
}
