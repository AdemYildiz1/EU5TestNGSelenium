package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframeTest {

    /*In html we can have one html page inside to another. This is made possible by tag <iframe> or <frame>.
     By using frames we can put html inside the html. when we have page with frames, selenium cannot control what is inside the frame.
    So we have to switch iframe first. When we switch to iframe it will not see the default page, until we switched back.

    So, We can switch our Html with 3 ways
    1. by using switchTo().frame(nameOrId:)
    2. by using switchTo().frame(index:)
    3. by using switchTo().frame(frame webElement)
    */

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
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");

        //How to switch frames
        //1.SWITCHING USING by name or ID attribute of iframe
        driver.switchTo().frame("mce_0_ifr");

        //clearing before sendKeys(it is not part of iframe, it is just general clear method)
        driver.findElement(By.cssSelector("#tinymce")).clear();

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith");

        //goes back to first frame(main Html)
        //goes back to first frame, useful when we switched multiple frames
        driver.switchTo().defaultContent(); //Always goes to main html/default one

        //2.SWITCHING USING by INDEX-- index is based on iframes it starts from '0'
        driver.switchTo().frame(0);
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#tinymce")).clear();

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith WITH INDEX");

        //second way to switch parent
        driver.switchTo().parentFrame(); //Always goes one html up

        //3.SWITCHING USING by FRAME WEB ELEMENT
        //location iframe with any valid locator
        WebElement iframeElement= driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(iframeElement);

        driver.findElement(By.cssSelector("#tinymce")).clear();

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith WITH WEBELEMENT");
    }

    //if we have nested Iframe
    //!!! you can switch one frame at a time,just parent to child (means cannot switch to grandchild directly).
    //!!! You can not switch between siblings in frame(only parent to child).
    //!!! we can go back to parent frame or main frame directly
    @Test
    public void Test2(){
        driver.get("http://practice.cybertekschool.com/nested_frames");

        /* EXAMPLE
        in this example of web page, we have 6 Html ( each frame has one html plus main html)

        HTML (defaultContent)
             frame-top (parentFrame)
                frame-left
                frame-middle
                frame-right
             frame-bottom
         */

        //Let's get text of "MIDDLE" in html that is in frame-middle
        //switch to frame top
        driver.switchTo().frame("frame-top");

        //switch to frame middle
        driver.switchTo().frame("frame-middle");

        System.out.println(driver.findElement(By.id("content")).getText());

        //Let's get text of "RIGHT"
        // goes back to frame-top
        driver.switchTo().parentFrame();

        //switching right with index
        driver.switchTo().frame(2);

        System.out.println(driver.findElement(By.tagName("body")).getText());

        //Let's get text of "BOTTOM"
        //go to main html to switch bottom
        driver.switchTo().defaultContent();

        driver.switchTo().frame(1);

        System.out.println( driver.findElement(By.tagName("body")).getText());


    }
}
