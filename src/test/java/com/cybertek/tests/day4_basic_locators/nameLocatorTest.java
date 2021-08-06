package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize(); // this makes browser full screen.

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement FullNameInput= driver.findElement(By.name("full_name"));

        FullNameInput.sendKeys("Mike Smith");

        //put some email click sign up button

        //proper way we do
        WebElement emailInput=driver.findElement(By.name("email"));
        emailInput.sendKeys("smith@mike.com");

        //lazy way
        driver.findElement(By.name("email")).sendKeys("smith@mike.com");

        //proper way
        WebElement signUpButton= driver.findElement(By.name("wooden_spoon"));
        signUpButton.click();

        //lazy way
        driver.findElement(By.name("wooden_spoon")).click();

        /* name LOCATOR
        if we can not use -id-, or it is dynamic we look for the -name-.

        we use -name- locator is NOT %99.99 percent dynamic.
        if name can be duplicate(radio buttons) so be careful don't use -name- locator
         */

    }
}
