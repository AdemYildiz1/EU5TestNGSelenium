package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbayTest2_HW2 {

    public static void main(String[] args) {
        /*Test case 2
        1-Go to Ebay
        2-search Selenium
        3-click on search button
        4-verify title contains Selenium
         */

        //1-
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com");

        //2-
        WebElement EbaysearchBox =driver.findElement(By.id("gh-ac"));
        EbaysearchBox.sendKeys("selenium");

        //3- lazy way
        driver.findElement(By.id("gh-btn")).click();

        //4-verify title contains Selenium
        //get title
        String title = driver.getTitle();
        System.out.println("Title: "+ title);

        driver.quit();

        //Actual result
        String actualResult=title;

        //expected result
         String expectedResult="selenium";

        if(actualResult.contains(expectedResult)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");

            System.out.println("actualResult: "+ actualResult);
            System.out.println("expectedResult: "+ expectedResult);
        }


    }
}
