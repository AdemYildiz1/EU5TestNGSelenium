package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

public class WebDriverFactory {
    //in this package we are going to create only reusable codes/methods/helper tools that we will use
    //here class and method are created to handle browser part -that we've learnt (remember!!opening empty browser)
    //WebDriverFactory: it has static method based on information it will return needed web driver for me and also set up browser

    //Task: write a static method that takes a string parameter name: browserType
    //based on the value of parameter
    //it will set up the browser and
    //the method will return chromedriver or firefoxdriver object.
    //name of method: getDriver

    public static WebDriver getDriver(String browserType){

        WebDriver driver=null;

        switch (browserType.toLowerCase()){
            case"chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case"firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
        }
        return driver;


    }

}
