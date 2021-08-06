package com.cybertek.tests.day7_testng;

import org.testng.annotations.Test;

public class FirstTestNGTest {
    //we are going to replace main method with @Test Annotation from now on

    @Test
    public  void test1(){
        System.out.println("My First Test Case");

    }

    @Test
    public void test2(){
        System.out.println("My Second Test Case");

    }
}
