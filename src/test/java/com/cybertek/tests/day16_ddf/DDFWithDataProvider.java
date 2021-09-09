package com.cybertek.tests.day16_ddf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {
    /* Here, test code/script and data is separated. And,
    Running the same test case with(against) the different sets of test data.
    Basically, DataProvider provides/return data for our test annotation. And,
    the data that is provided by DataProvider decides how many times a test case runs
    ->that is we called Data Driven Frame work(DDF),
    */

    @DataProvider // Will return data to @test annotation
    public Object[][] testData() {
        String[][] data={
                {"person of interested","10"},
                {"Sherlock","9"},
                {"Breaking bad","8"},
                {"The Office","7"},
                {"WestWorld","10"},
                {"Gotham","9"},
                {"Dark","8"}
        };
        return data;
    }
    @Test(dataProvider = "testData")
    public void test1(String tvShow, String rate){
        System.out.println("Tv Show: "+tvShow+"has rating: "+rate); //it is executed 8 times/for each data
    }
}
