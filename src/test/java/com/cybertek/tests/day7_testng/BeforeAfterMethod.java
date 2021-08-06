package com.cybertek.tests.day7_testng;

import org.testng.annotations.*;

public class BeforeAfterMethod {

    //@BeforeClass and @AfterClass runs once before and after everything in the  class
    //@BeforeMethod and @AfterMethod is executed right before and after each test case/annotation
    //@BeforeMethods helps ...?
    //@AfterMethod helps driver close even though my test case fails.
    // (//) or (@Ignore)  ignore that specific test case so that NgTest method doesn't run

    @BeforeClass
    public  void setUpClass(){
        System.out.println("---BEFORE CLASS---");
        System.out.println("Executed one time before class");
    }

    @Test
    public  void  test1(){
        System.out.println("First Test Case");

    }
    @BeforeMethod
    public  void setUp(){
        System.out.println("BEFORE METHOD--> WebDriver,Opening Browser");
    }
    @AfterMethod
    public  void tearDown(){
        System.out.println("AFTER METHOD--> Closing Browser, Quit");
    }

    @Test
    public  void test2(){
        System.out.println("Second Test Case");
    }

    @Test
    public  void test3(){
        System.out.println("Third Test Case");
    }
    @AfterClass
    public  void  tearDownClass(){
        System.out.println("---AFTER CLASS---");
        System.out.println("Some reporting code here");
    }

}
