package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikipediaTest_HW3 {
    public static void main(String[] args) {

        /* Test case 3
         1-Go to wikipedia.org (Links to an external site.)
         2-enter search term `selenium web driver`
         3-click on search button
         4-click on search result `Selenium (software)`
         5-verify url ends with `Selenium_(software)'
        */

        //1-
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.wikipedia.org/");

        //2-
        WebElement searchBox= driver.findElement(By.id("searchInput"));
        searchBox.sendKeys("selenium web driver");

        //3
        WebElement searchButton= driver.findElement(By.xpath("//i[@data-jsl10n='search-input-button']"));
        searchButton.click();

        //4
        WebElement ClickSelSoftware= driver.findElement(By.xpath("//a[@data-serp-pos='0']"));
        ClickSelSoftware.click();

        //5 verify url ends with `Selenium_(software)'

        //Actual URL
        String actualResult=driver.getCurrentUrl();

        //expected Result
        String expectedResult="Selenium_(software)";

        if(actualResult.endsWith(expectedResult)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }



    }
}
