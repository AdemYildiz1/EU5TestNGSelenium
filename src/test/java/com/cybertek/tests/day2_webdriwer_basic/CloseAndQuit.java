package com.cybertek.tests.day2_webdriwer_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver(); // it always opens empty browser page


        driver.get("http://practice.cybertekschool.com");

        Thread.sleep(2000);

        //close current tab
        driver.close();
                                   // here my code got stuck gives error here because my browser was closed(in line 20)
        driver=new ChromeDriver(); //I have to open new empty browser to continue new navigating

        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(5000);

        driver.close();

        //closes all tabs
        driver.quit();
    }
}
