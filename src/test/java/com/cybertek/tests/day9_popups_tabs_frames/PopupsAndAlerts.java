package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("Chrome");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    //if it is clickable(HTML PUP UPS), we locate popups and apply what we want in the same way.
    @Test
    public void Test1(){
        driver.get("https://www.primefaces.org/showcase-v8/ui/overlay/confirmDialog.xhtml");

        //click the destroy the world button
        driver.findElement(By.xpath("//button[.='Destroy the World']")).click();

        //click No button
        driver.findElement(By.xpath("//button[.='No']")).click();
    }
    //if it is not clickable (JS ALERTS/NON HTML ALERTS), Here there is no inspection to locate element
    // We use Alert Class and create an object that enables us to use methods
    @Test
    public void Test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        //Click "Click For JS Alert" Button.
        driver.findElement(By.xpath("//button[1]")).click();

        //!switch to JS alert pop up to my driver by creating object from Alert Class,here selenium jumps to alert pop up
        //then use methods( accept(),dismiss(),sendKeys,getText() )
        Alert alert=driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();  //we can use accept method

        //Click "For JS Confirm"
        driver.findElement(By.xpath("//button[2]")).click();
        Thread.sleep(2000);
        alert.dismiss();

        //click "For JS Prompt"
        driver.findElement(By.xpath("//button[3]")).click();
        Thread.sleep(2000);
        alert.sendKeys("smithMike");
        //accept OK
        alert.accept();



    }
}
