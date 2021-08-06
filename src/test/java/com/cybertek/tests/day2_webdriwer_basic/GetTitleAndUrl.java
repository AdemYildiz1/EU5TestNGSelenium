package com.cybertek.tests.day2_webdriwer_basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {

    public static void main(String[] args) {

        //Task: open crown and navigate to http://practice.cybertekschool.com

        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");


       // getting title with selenium
        String title = driver.getTitle(); //drive.getTitle() then Alt+enter enter--shortcut for creating variable.

        //soutv+ enter --short way to print variable and value
        System.out.println("title = " + title);

        // getCurrentUrl(), gets the url from browser by creating variable then print
        String currentUrl = driver.getCurrentUrl();  //driver.getCurrentUrl() then Alt+enter enter
        System.out.println("currentUrl = " + currentUrl);

        //getPageSource(), gets the source of the page
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);

    }
}
