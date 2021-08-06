package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("Chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void SwitchWindowTest() {

        driver.get("http://practice.cybertekschool.com/windows");

        //get title
        System.out.println("Get title before new window = " + driver.getTitle());

        //click link and open new window
        driver.findElement(By.linkText("Click Here")).click();

        //try to get title of new window before switching
        System.out.println("Get title after new window = " + driver.getTitle());//same title, so need to switch

        //Switching to current window to new window (if we have two windows)
        // by using (getWindowHandle(s)) those are unique identifiers,codes/id for that windows.
        String currentWindowHandle=driver.getWindowHandle(); //it has id/code for current one as a string so we saved it

        Set<String> windowHandles = driver.getWindowHandles(); //it has for id/codes far all of them so we saved as a list

        for(String handle:windowHandles){
            if(!handle.equals(currentWindowHandle)){
                driver.switchTo().window(handle);
            }
        }
        //get title after switching
        System.out.println("Title after switch new window = " + driver.getTitle());
    }

    @Test
    public void moreThan2Window() {
        driver.get("http://practice.cybertekschool.com/windows");

        driver.findElement(By.linkText("Click Here")).click();

        //before switch
        System.out.println("Before switch: = " + driver.getTitle());

        Set<String> windowHandles = driver.getWindowHandles();

        //loop through each window
        for (String handle: windowHandles) {

            driver.switchTo().window(handle);

            if(driver.getTitle().equals("New Window")){ //while title equals to my expected title
                break;
            }
        }
        System.out.println("After switching: = " + driver.getTitle());
    }

}