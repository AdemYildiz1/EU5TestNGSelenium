package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLnotChanged {

    public static void main(String[] args) {
        /*TEST CASE: Verify URL not changed
        STEP 1- open chrome browser
        STEP 2- go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        STEP 3- click on Retrieve password
        STEP 4-verify that url did not change*/

        //1-
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        //2
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //save expected Url Before clicking button
        String expectedUrl=driver.getCurrentUrl();

        //3-click on Retrieve password
        WebElement retrievePasswordButton=driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();
        /*Here basically similar to what we did in java-->String/WebElement , str/retrievePasswordButton = driver.findE..."     ";
        "WebElement"            -->interface/class that represent elements on the web page.
        "retrievePasswordButton"-->webElement's object, its name given by us
        "driver"                --> representing my browser,
        "findElement"             -->method used to find element on a page
        So "driver.findElement.."  goes and finds our web element based on id attribute that has "form_submit" value
        then, put whatever we found as a web element in the "retrievePasswordButton"
        finally, we use "retrievePasswordButton" that has our web element with .click() method to implement
        */

        //save expected Url After clicking button
        String actualUrl=driver.getCurrentUrl();

        // STEP 4-verify that url did not change
        // for this I need to get URL before Step-3 (above,I did) and after clicking/Step-3 (above I did)
        //then I CAN compare if it changes

        if(expectedUrl.equals(actualUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        //close your browser
        driver.quit();


    }
}
