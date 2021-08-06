package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locator_HW_2 {
    public static void main(String[] args) {

        /*  XPATH PRACTICES
     DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
       1. Open Chrome browser
       2. Go to http://practice.cybertekschool.com/forgot_password to an external site.
       3. Locate all the WebElements on the page using XPATH locator only (total of 6)
          a. “Home” link
          b. “Forgot password” header
          c. “E-mail” text
          d. E-mail input box
          e. “Retrieve password” button
       4.Print text of a,b,c,e and put some email to d
        */

        //1-
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        //2-
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //3-
        // a
        WebElement homeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));
        System.out.println(homeLink.getText());

        //b
        WebElement ForgetPasswordText= driver.findElement(By.xpath("//h2[text()='Forgot Password']"));
        System.out.println(ForgetPasswordText.getText());

        //c
        WebElement EmailText = driver.findElement(By.xpath("//label[@for='email']"));
        System.out.println(EmailText.getText());

        //d
        WebElement EmailInputBox = driver.findElement(By.xpath("//input[@type='text']"));
        EmailInputBox.sendKeys("Mike@smith");

        //f
        WebElement RetrievePasswordButton = driver.findElement(By.xpath("//i[text()='Retrieve password']"));
        System.out.println(RetrievePasswordButton.getText());

        driver.quit();
    }
}
