package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {

    public static void main(String[] args) {

        /* TEST CASE: Verify confirmation message
         Step-1 open chrome browser
         Step-2 go to http://practice.cybertekschool.com/forgot_password Links to an external site.
         Step-3 enter any email
         Step-4 verify that email is displayed in the input box
         Step-5 click on Retrieve password
         Step-6 verify that confirmation message says 'Your e-mail's been sent!'
         */

        //Step-1 open chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        //Step-2 go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //step-3 enter any email
        WebElement EmailInputBox = driver.findElement(By.name("email"));

        String expectedEmail="smith@gmail.com";

        //sendKeys()--> send keyboard action to the web element
        EmailInputBox.sendKeys(expectedEmail);

        // Step-4 verify that email is displayed in the input box
        //to see what displayed in box or anywhere we need get  text from web elements
        //Way 1, getText(); --> it will work except input boxes,
        //Way 2, getAttribute("value") -->  works including input box.

        String actualEmail = EmailInputBox.getAttribute("value");

        if(expectedEmail.equals(actualEmail)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        //Step-5 click on Retrieve password
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        //Step-6 verify that confirmation message says 'Your e-mail's been sent!'
        WebElement actualConfirmationMessage = driver.findElement(By.name("confirmation_message"));
        actualConfirmationMessage.getText();

        //save actual message to a variable
        String actualMessage = actualConfirmationMessage.getText();

        //save expected message
        String expectedMessage= "Your e-mail's been sent!";

        if(expectedMessage.equals(actualMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedMessage: "+expectedMessage);
            System.out.println("actualMessage: "+actualMessage);
        }

        //close browser
        driver.quit();
    }
}
