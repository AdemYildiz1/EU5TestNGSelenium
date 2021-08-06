package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBox_HW {
    /*
    TC #2: SeleniumEasy Checkbox Verification – Section 1
    1.Open Chrome browser
    2.Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
    3.Verify “Success – Check box is checked” message is NOT displayed.
    4.Click to checkbox under “Single Checkbox Demo” section
    5.Verify “Success – Check box is checked” message is displayed.
     */
    WebDriver driver;

    @BeforeMethod
    public void setUP(){
        driver= WebDriverFactory.getDriver("chrome");

    }
    @AfterMethod
    public void tearDow() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void Test1(){
        //2-
        driver.get(" http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement singleCheckBox =driver.findElement(By.xpath("//input[@id='isAgeSelected']"));

        //3-Verify “Success – Check box is checked” message is NOT displayed.
        Assert.assertFalse(singleCheckBox.isSelected(),"verify it is NOT selected");

        //4- Click to checkbox under “Single Checkbox Demo”
        singleCheckBox.click();

        //5- Verify “Success - Check box is checked” message is displayed.
        Assert.assertTrue(singleCheckBox.isSelected(),"verify it is selected");

        WebElement displayedMessage=driver.findElement(By.cssSelector("div[id='txtAge']"));

        String actualMessage=displayedMessage.getText();

        String expectedMessage="Success - Check box is checked";

        Assert.assertEquals(actualMessage,expectedMessage,"verify displayed message");

    }
         /*
        TC #3: SeleniumEasy Checkbox Verification –Section 2
        1.Open Chrome browser
        2.Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
        3.Verify “Check All” button text is “Check All”
        4.Click to “Check All” button
        5.Verify all check boxes are checked
        6.Verify button text changed to “Uncheck All”
         */
    @Test
    public void Test2(){
        //2-
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        //3-Verify “Check All” button text is “Check All”
        WebElement checkAllButon =driver.findElement(By.cssSelector("#check1"));
        System.out.println("check all button text :  = " + checkAllButon.getAttribute("value"));

        String actualText =checkAllButon.getAttribute("value");
        String expectedText="Check All";
        Assert.assertEquals(actualText,expectedText,"verify Check All button text");

        //4- Click to “Check All” button
        checkAllButon.click();

        //5-
        //checkbox1
        WebElement checkBox1=driver.findElement(By.xpath("(//input[@id='check1']/..//label/input)[1]"));
        Assert.assertTrue(checkBox1.isSelected(),"verify that checkbox 1 is selected");

        //checkbox2
        WebElement checkBox2 =driver.findElement(By.xpath("(//input[@id='check1']/..//label/input)[2]"));
        Assert.assertTrue(checkBox2.isSelected(),"verify that checkbox 2 is selected");

        //checkBox3
        WebElement checkBox3 =driver.findElement(By.xpath("(//input[@id='check1']/..//label/input)[2]"));
        Assert.assertTrue(checkBox3.isSelected(),"verify that checkbox 3 is selected");

        //checkBox4
        WebElement checkBox4 =driver.findElement(By.xpath("(//input[@id='check1']/..//label/input)[4]"));
        Assert.assertTrue(checkBox4.isSelected(),"verify that checkbox 4 is selected");

        //6-Verify button text changed to “Uncheck All”
        System.out.println("checkAllButon.getAttribute(\"value\") = " + checkAllButon.getAttribute("value"));

        String actualLastCheckAll=checkAllButon.getAttribute("value");
        String expectedLastCheckAll="Uncheck All";

        Assert.assertEquals(actualLastCheckAll,expectedLastCheckAll,"verify Last ALL check button text");
    }
}
