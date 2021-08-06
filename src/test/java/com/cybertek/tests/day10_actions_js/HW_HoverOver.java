package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HW_HoverOver {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("CHROME");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    //TEST CASE: hover over for one img in website and verify bu using user name
    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1=driver.findElement(By.xpath("(//img)[1]"));

        Actions actions=new Actions(driver);

        Thread.sleep(2000);
        actions.moveToElement(img1).perform() ;

        //verify our mouse is hovering over!
        WebElement text= driver.findElement(By.xpath("//h5[.='name: user1']"));

        Assert.assertTrue(text.isDisplayed(),"verify text 1 is displayed");

    }

    /*TEST CASE: Hover over for all image in the website dynamically
    verify each name: user name displayed
    */
    @Test
    public void HoverOverDynamic() throws InterruptedException {

            driver.get("http://practice.cybertekschool.com/hovers");

        for (int i=1; i<=3; i++) {

            String xpathImg ="(//img)["+i+"]"; //we did string manipulation with index for each image
            WebElement img=driver.findElement(By.xpath(xpathImg));
            System.out.println(xpathImg);

            Actions actions=new Actions(driver);

            Thread.sleep(1000);
            actions.moveToElement(img).perform();

            //verify our mouse is hovering over!
            WebElement text= driver.findElement(By.xpath("//h5[.='name: user"+i+"']")); // "//h5[.='name: user1']" is manipulated

            Assert.assertTrue(text.isDisplayed(),"verify text " +i+ " is displayed");

        }
    }
}
