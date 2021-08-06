package com.cybertek.tests.day14_extent_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentDemoTest {

    //This class will be standalone to demonstrate ONLY for how Extent reports works!
    //then we will move the code from here to the testBase

    //1- this class is used for starting and building reports
    ExtentReports report;
    //2- this class is used to create HTML report file
    ExtentHtmlReporter htmlReporter;
    //3- this will define a test, enables adding logs, authors, test steps
    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp(){
        // initialize the class
        report=new ExtentReports();

        //create a report path
        String projectPath=System.getProperty("user.dir"); //this is where my project is located

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
    //if we use TestNG as a frame work and  use ExtentReports as a reporting tool
    // so we have to know and remember this test part(below)
    @Test
    public void test1() {
        //give name to current test
        extentLogger=report.createTest("TC123 login as a Driver Test");

        //test steps
        extentLogger.info("Open chrome browser");

        extentLogger.info("Go to this URL");

        extentLogger.info("Enter driver user name password");

        extentLogger.info("Click login");

        extentLogger.info("Verify logged in");

        //pass();--> marks the test case as passed
        extentLogger.pass("TC123 is passed");

    }
    @AfterMethod
    public void tearDown(){
        //this is the when the report is actually created
        report.flush();
    }
}


