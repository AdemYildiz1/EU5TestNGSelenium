package com.cybertek.tests.day10_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {

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
    //how to upload a file from desktop to webpage with selenium
    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/upload");

        //locating choose file
        WebElement chooseFile = driver.findElement(By.name("file"));
        /*
        How to get to path of the file from my "fileUpload" in desktop so that we can send it with senKeys?
        -hold shift button
        -Right click on file
        -copy as Path -->"C:\Users\A Yildiz\Desktop\fileUpload.txt"
         */

        //we use senKeys method for sending file path that is my computer related
        chooseFile.sendKeys("C:\\Users\\A Yildiz\\Desktop\\file.txt");

        //clicking upload
        driver.findElement(By.id("file-submit")).click();

        //getting file name from browser
        String actualFileName=driver.findElement(By.id("uploaded-files")).getText();

        //verify
        Assert.assertEquals(actualFileName,"file.txt","verify file name");

        //BUT IT IS NOT DYNAMIC IT DOES NOT WORK ON DIFFERENT COMPUTER because PATH IS UNIQUE for my COMPUTER.
        //IF WE WANT A FILE TO WORK WITH DIFFERENT COMPUTER/ENVIRONMENT AS WELL.
        //BASICALLY PATH NEEDS TO BE UPDATED,IT HAS TO BE DYNAMICLY UPLOADED.
        //OUR TEST CASES RELATED FILE MUST BE IN PROJECT SIDE IN INTELLIJ, NOT IN THE DESKTOP,
        //Example; Create resources and file for test cases
        //1.Right click on test (NOT TESTS)
        //2.New->Directory
        //3.Choose resources or type:resources
        //4.OK
        //THIS FILE is not JAVA RELATED AS WELL, IT IS RELATED TEXT FILE, EXEL FILE... ETC
        //FINALLY WE OPEN A FOLDER IN INTELLIJ AND PUT THESE FILES IN IT.

    }
    //by using this dynamic way, we can use any file for our test cases from any folder
    //for example,resources folder in the same project with my collaborators
    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/upload");

        //locating choose file
        WebElement chooseFile = driver.findElement(By.name("file"));
        /*
textfile->right click copy absulate path it gives: C:\Users\A Yildiz\IdeaProjects\EU5TestNGSelenium\src\test\resources\textfile.txt

C:\Users\A Yildiz\IdeaProjects\EU5TestNGSelenium\ --> different part,it is static in my computer

src\test\resources\textfile.txt --> same part with one who has same intellij project with me

How can we get where my project is located dynamically? dynamically,
olarak projemin bulundugu yeri nasil alabilirim/varabilirim, yani different parti?
     */
        //we use senKeys method for sending file
        String projectPath =System.getProperty("user.dir"); //C:\Users\A Yildiz\IdeaProjects\EU5TestNGSelenium\
                                                           //different part(where my project is located).But we get it dynamically

        String filePath="src\\test\\resources\\textfile.txt"; //same part with ones who have same intellij project with me
                                                              //To get this, right click copy "path from content root" /relative path

        String fullPath=projectPath+"\\"+filePath; //--> concat these and give as an absulate path to send key

        chooseFile.sendKeys(fullPath); //file path

        //clicking upload
        driver.findElement(By.id("file-submit")).click();

        //getting file name from browser
        String actualFileName=driver.findElement(By.id("uploaded-files")).getText();

        //verify
        Assert.assertEquals(actualFileName,"textfile.txt","verify file name");

    }

}