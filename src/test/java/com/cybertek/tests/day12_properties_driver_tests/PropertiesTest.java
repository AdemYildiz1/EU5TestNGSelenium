package com.cybertek.tests.day12_properties_driver_tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PropertiesTest {

    //Let's use configuration reader and try to get value from configuration.properties(control center)
    @Test
    public void test1(){
        String browserType= ConfigurationReader.get("browser");

        System.out.println("browserType :"+browserType);

        String url=ConfigurationReader.get("url");

        System.out.println("url = " + url);

    }
    @Test
    public void openBrowserWithConf(){
        //By changing values in configuration, we can get browser and url that we want to use dynamically.

        WebDriver driver=WebDriverFactory.getDriver(ConfigurationReader.get("browser")); //we can get our browser dynamically

        driver.get(ConfigurationReader.get("url"));// we can get our url dynamically

        String username= ConfigurationReader.get("driver_username");
        String password= ConfigurationReader.get("driver_password");

        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password + Keys.ENTER);
        //Keys.ENTER is used to click and enter the application
        //We have Keys.ENTER to use for short cut

    }
}
