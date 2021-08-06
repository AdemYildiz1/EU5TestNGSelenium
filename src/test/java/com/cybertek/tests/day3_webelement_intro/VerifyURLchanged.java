package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyURLchanged {

    public static void main(String[] args) {

        /* TEST CASES: Verify URL changed
         STEP 1-open chrome browser
         STEP 2-go to http://practice.cybertekschool.com/forgot_password Links to an external site.
         STEP 3-enter any email
         STEP 4-click on Retrieve password
         STEP 5-verify that url changed to http://practice.cybertekschool.com/email_sent
        */

        //STEP 1-open chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        //STEP 2-go to "http://practice.cybertekschool.com/forgot_password"
        driver.get("http://practice.cybertekschool.com/forgot_password");
        
        //STEP 3-enter any email
        WebElement EmailInputBox = driver.findElement(By.name("email"));

        //sendKeys-->sends keyboard action to web element
        EmailInputBox.sendKeys("adem-3804@hotmail.com");

        //STEP 5- Click retrieve password button
        WebElement retrievePasswordButton =driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        //STEP 5- verify that url changed to http://practice.cybertekschool.com/email_sent

        //Create expected result (URL), comes from my TEST CASES.
        String expectedURL="http://practice.cybertekschool.com/email_sent";

        //after some actions (entering email,click retrieve password button...etc), comes from SELENIUM
        String actualURL = driver.getCurrentUrl();

        if(expectedURL.equals(actualURL)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");

            // if fails we can see both results to see what happened
            System.out.println("expected result: "+expectedURL);
            System.out.println("Actual result: "+ actualURL);

        }

        //Close browser
        driver.quit();
    }
}
