package com.cybertek.tests.day2_webdriwer_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver(); // gives empty chrome browser object

        //EXAMPLE; lets open 2 website in the same tab browser
        // way-1 to navigate website , with driver.get()
        driver.get("https://www.google.com");

        //way-2 navigate to website with different selenium method
        driver.navigate().to("https://www.facebook.com");

        // for waiting here before next execution (eg; 3 second) then move on
        Thread.sleep(3000);//if yo see red error, after hower over click the throws InterruptedException

        //how to go back previous page
        driver.navigate().back();

        Thread.sleep(2000);

        //goes forward after going back

        driver.navigate().forward();

        //refresh to web page

        driver.navigate().refresh();


    }
}
