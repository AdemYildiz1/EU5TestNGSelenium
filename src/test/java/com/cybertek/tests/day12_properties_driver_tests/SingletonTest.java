package com.cybertek.tests.day12_properties_driver_tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {

    @Test
    public void test1(){
        String s1=Singleton.getInstance();
        String s2=Singleton.getInstance();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }
    @Test
    public void test2(){
        WebDriver driver= Driver.get();

        driver.get("https://www.google.com");
        Driver.closeDriver();  // we use it instead of quit. if we use it it make driver null in Driver class and give us new driver
        //otherwise it goes on with the same driver because of singleton features that is applied Driver class in utilities
    }
    @Test
    public void test3(){
        WebDriver driver= Driver.get();

        driver.get("https://www.amazon.com");
    }
}
