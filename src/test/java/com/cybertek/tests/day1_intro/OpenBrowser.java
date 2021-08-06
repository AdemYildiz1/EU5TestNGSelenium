package com.cybertek.tests.day1_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class OpenBrowser {

    public static void main(String[] args) {

        //we have to enter this line when we want to open chrome
        //**hey WebDriverManager, can you make chrome ready for me to automate.
        // gives selenium needed language so that it knows how to talk with this specific browser
        WebDriverManager.chromedriver().setup();

        //webdriver represent the browser
        // driver itself is an object that represent one top browser. eg here, driver represents chrome browser
        //new ChromeDriver()--> this part will open chrome browser. first it will always be empty here
        WebDriver driver=new ChromeDriver();

        //.get(url) method, we pass our url as a parameter, So we gave command to navigate
        driver.get("https://cybertekschool.com");

        //EXAMPLE-2
       // this line will allow selenium to automate firefox browser.
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver1=new FirefoxDriver();

        driver1.get("https://www.facebook.com");


    }
}
