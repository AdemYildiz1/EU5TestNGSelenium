package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {

    public static void main(String[] args) throws InterruptedException {

        /*TASK
        -go to amazon.com
        -search for selenium
        -click search button
        -verify 1-48 of 304 results for"selenium"
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.co.uk");

        //-search for selenium
        WebElement inputSearchBox= driver.findElement(By.id("twotabsearchtextbox"));
        inputSearchBox.sendKeys("selenium");

        Thread.sleep(2000);

       // -click search button
        driver.findElement(By.xpath("(//form)[2]/div[3]/div")).click();

        //get actual text
        //first part (1-48 of 276 results for)
        WebElement actualtext1= driver.findElement(By.xpath("//span[contains(text(),'results')]"));
        actualtext1.getText();

       //second part of text 1-48 of 276 results for
        WebElement actualtext2=driver.findElement(By.xpath("//span[contains(text(),'results')]/../span[3]"));
        actualtext2.getText();

        String actualResult=actualtext1.getText().concat(actualtext2.getText());

        driver.quit();

        //expected result
       String expectedResult = "1-48 of 276 results for\"selenium\"";

        if (expectedResult.equals(actualResult)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");

            System.out.println("actualResult: "+actualResult);
            System.out.println("expectedResult: " +expectedResult);
        }

    }
}
