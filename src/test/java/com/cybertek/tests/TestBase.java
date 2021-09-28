package com.cybertek.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    //1- this class is used for starting and building reports
    protected ExtentReports report;
    //2- this class is used to create HTML report file
    protected ExtentHtmlReporter htmlReporter;
    //3- this will define a test, enables adding logs, authors, test steps
    protected ExtentTest extentLogger;

    @BeforeTest
    public void SetUpTest(){
        // initialize the class
        report=new ExtentReports();

        //create a report path
        String projectPath= System.getProperty("user.dir");//this is where my project is located

        //test-output-->folder
        //report.htm-->report file
        //path of report->it will be created during the execution, not directly right click create folder..etc!
        String path=projectPath + "/test-output/report.html";

        //initialize the html reporter with the report path
        //basically, it says where my html report goes
        htmlReporter= new ExtentHtmlReporter(path);

        //attach the html report to report object
        report.attachReporter(htmlReporter);

        //title in report
        htmlReporter.config().setReportName("Vytrac Smoke Test");

        //set environment information
        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
    }

    @BeforeMethod
    public void setUp() {
        driver = Driver.get(); //we changed it from WebDriverFactory to Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions=new Actions(driver);
        wait= new WebDriverWait(driver,10);
        driver.get(ConfigurationReader.get("url"));

    }
    //ITestResult class describes the result of a test in TestNG

    public void tearDown(ITestResult result) throws InterruptedException, IOException {
        //If test fails
        if(result.getStatus()==ITestResult.FAILURE){
            //record the name of failed test case
            extentLogger.fail(result.getName());

            //take the screenshot and return location of screenshot
            String screenShotPath= BrowserUtils.getScreenshot(result.getName());

            //add your screenshot to your report
            extentLogger.addScreenCaptureFromPath(screenShotPath);

            //capture the exception and put inside the report
            extentLogger.fail(result.getThrowable());

        }

        Thread.sleep(2000);
        Driver.closeDriver();  //we changed it from driver.quit to Driver.CloseDriver();
    }
    @AfterTest
        public void tearDownTest(){
        //this is the when the report is actually created
        report.flush();

    }
}
