package com.cybertek.tests.day7_testng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @BeforeMethod
    public  void setUp(){
        System.out.println("Open Browser");
    }

    //1- Assert.assertEquals("actual","expected"); it checks two values are the same
    @Test
    public  void test1(){

        System.out.println("First Assertion");
        Assert.assertEquals("title","tiTle");

        System.out.println("Second Assertion");
        Assert.assertEquals("url","url");
    }

    @Test
    public  void test2(){
        Assert.assertEquals("test2","test2");
    }
   //2- if smth is returning TRUE or not we use this Assert.assertTrue(condition), here we are expecting TRUE
    @Test
    public void test3(){
        String expectedTitle="Cyb";
        String actualTitle="Cybertek";

        Assert.assertTrue(actualTitle.startsWith(expectedTitle),"verify title start with");
    }
    @Test
    public void test4(){
        //verify email contains @ sign
        String email ="mike@smith.com";

        Assert.assertTrue(email.contains("@"),"verify email contains @");
    }
    //3- if smth is returning FALSE or not we use this Assert.assertFalse(condition), here we are expecting false
    @Test
    public void test5(){
        Assert.assertFalse(0>1,"Verify that 0 is not greater than 1");
    }

    //4-Assert.assertNotEquals("actual","expected"); it checks two values are NOT the same each other
    @Test
    public void test6(){
        Assert.assertNotEquals("one","two");
    }

    @AfterMethod
    public void TearDownMethod(){
        System.out.println("Close Browser");
    }



}
