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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionsTest {

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

    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1=driver.findElement(By.tagName("img"));

        //Actions-->class that contains all the user advanced interactions like hover over, double click drag..etc
        //how to create actions object-->passing driver as a constructor
        Actions actions=new Actions(driver);

        //perform()-->perform the action
        //moveToElement-->move your mouse to webelement(hover over)
        Thread.sleep(2000);
        actions.moveToElement(img1).perform() ;

        //verify our mouse is hovering over!
        WebElement viewLink= driver.findElement(By.linkText("View profile"));

        Assert.assertTrue(viewLink.isDisplayed(),"verify view link is displayed");

    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        Actions actions=new Actions(driver);

        /* LOGIC
        if no elements in web list it says list is empty so we can use this feature to create basic if statement
        in this case we can get rid of from both pups up "Accept cookies" OR "Accept and close"

        List<WebElement> acceptAndClose= driver.findElements(By.xpath("//*[.='Accept and Close']"));
        acceptAndClose.get(0).click();
        List<WebElement> acceptCookies= driver.findElements(By.xpath("//*[.='Accept and Cookies']"));
        acceptCookies.get(0).click();

        Thread.sleep(1000);
        if(acceptAndClose.size()>0){
            acceptAndClose.get(0).click();
        }else if(acceptCookies.size()>0){
            acceptCookies.get(0).click();
        }
        */

        //close if cookies appears use both(below) automatically or do specific inspection find element by id..etc
        //1- driver.findElement(By.xpath("//*[.='Accept and Close']")).click();
        //2- driver.findElement(By.xpath("//*[.='Accept and Cookies']")).click();
        //Or or or use LOGIC(above ) to solve all like that problem in advance
        driver.findElement(By.xpath("//*[.='Accept and Close']")).click();

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        Thread.sleep(3000);
        actions.dragAndDrop(source,target).perform();
    }
    @Test
    public void dragAndDropChanning() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[.='Accept and Close']")).click();

        Actions actions=new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        //SECOND WAY USING LIKE CHAIN WAY--> imagine you are clicking source and dropping to target then realising
        //first way is recommended
        Thread.sleep(2000);
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().perform();

    }
}