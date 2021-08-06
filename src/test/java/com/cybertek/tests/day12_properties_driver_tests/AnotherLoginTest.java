package com.cybertek.tests.day12_properties_driver_tests;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class AnotherLoginTest extends TestBase {

    //here we test without "page object model" that is designed in login class in pages package for our app
    @Test
    public void test1(){

        driver.get(ConfigurationReader.get("url"));// we can get our url dynamically

        String username= ConfigurationReader.get("driver_username");
        String password= ConfigurationReader.get("driver_password");

        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password + Keys.TAB);



    }
}
