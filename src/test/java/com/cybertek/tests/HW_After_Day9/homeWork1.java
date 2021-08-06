package com.cybertek.tests.HW_After_Day9;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class homeWork1 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver=WebDriverFactory.getDriver("Chrome");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test1(){
        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");

        String actualResult=driver.findElement(By.xpath("//small[.='The date of birth is not valid']")).getText();
        System.out.println("actualResult = " + actualResult);

        String expectedResult="The date of birth is not valid";

        Assert.assertEquals(actualResult,expectedResult,"verify if D.o.B is not Valid");
    }
    @Test
    public void test2() throws InterruptedException {
        WebElement languageElement= driver.findElement(By.xpath("//input[@id='inlineCheckbox1']/../.."));
        System.out.println("languageElement.getText() = " + languageElement.getText());

        String actualResult=languageElement.getText();

        String expectedResult="C++\n" +  "Java\n" +  "JavaScript";

        Assert.assertEquals(expectedResult,actualResult,"verify Languages");
    }
    @Test
    public void test3(){
        driver.findElement(By.tagName("input")).sendKeys("A");
        WebElement messageDisplay=driver.findElement(By.xpath("//small[@data-bv-validator='stringLength']"));
        System.out.println("messageDisplay.getText() = " + messageDisplay.getText());

        String actualResult=messageDisplay.getText();
        String expectedResult="first name must be more than 2 and less than 64 characters long";

        Assert.assertEquals(actualResult,expectedResult,"verify displayed message for wrong first name");

    }
    @Test
    public void test4(){
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("B");

        WebElement lastNameDisplayed=driver.findElement(By.xpath("(//i)[2]/..//small[2]"));
        System.out.println("lastNameDisplayed.getText() = " + lastNameDisplayed.getText());

        String actualResult=lastNameDisplayed.getText();
        String expectedResult="The last name must be more than 2 and less than 64 characters long";

        Assert.assertEquals(actualResult,expectedResult,"verifay displayed last name while it is wrong");
    }
}
