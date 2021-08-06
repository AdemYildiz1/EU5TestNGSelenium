package com.cybertek.tests.day11_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {
    /* How to deal with tables in page/how can we get information tables.

    WebTables
In html tables are represented with <table> tag
Tables are made of <thead> and <tbody>

<thead> --> this is the table header, here we have table column names
 <tr> table row, indicates one whole row
  <th> --> this tag indicates a cell that is used for Table Headers/ th represent column number as well

<tbody> this is where the data is
 <tr> table row, indicates one whole row
  <td> --> cell in a table body // represents table data
     */
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("CHROME");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void printTable() {

        WebElement table1=driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println(table1.getText());

        //we can verify any if table has an information/data that we are looking for.
        //Ex: 1
        Assert.assertTrue(table1.getText().contains("jdoe@hotmail.com"));
    }

    @Test
    public void getAllheader(){
        //how many columns we have? which means what is the number of "th"-->Table headers
       List<WebElement>headers= driver.findElements(By.xpath("//table[@id='table1']//th"));
       System.out.println("headers.size() = " + headers.size());

       //print each headers
        for (WebElement header : headers) {
            System.out.println(header.getText());
        }
    }
    @Test
    public void printTableSize() {
        //how many columns we have
        List<WebElement>headers= driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println( headers.size());

        //number of rows
        List<WebElement>allRowsWithHeader= driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println(allRowsWithHeader.size());

        //number of rows without header(recommended)
        List<WebElement>allRowsWithoutHeader=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println(allRowsWithoutHeader.size());
    }
    @Test
    public void getRow() {
        //print the second row information
        WebElement row2= driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));
        System.out.println(row2.getText());

        //get all rows dynamically
        //1- find number of rows
        List<WebElement>numRows=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        //2- iterate one by one
        for (int i = 1; i <= numRows.size(); i++) {
            WebElement row= driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]"));//string manipulation for each row
            System.out.println(i+"-"+row.getText());
        }
    }
    @Test
    public void getAllCellInOneRow(){
        //let's print each cell of a specific row
        //ex: let's put a list all cells of row-1
        List<WebElement>allCellsInOneRow=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));

        for (WebElement element : allCellsInOneRow) {
            System.out.println(element.getText());
        }
    }
    @Test
    public void getAsingleCellInOneRow(){
        //let's print "http://www.jdoe.com" in the table/ it is in 5th cell in  3rd row.
        WebElement singleCell=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[5]"));
        System.out.println("singleCell.getText() = " + singleCell.getText());

        //let's print "fbach@yahoo.com" in the table/ it is in 3th cell in  2rd row.
        WebElement singleCell2=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]/td[3]"));
        System.out.println("singleCell2.getText() = " + singleCell2.getText());
    }
    @Test
    public void printAllCellsByIndex(){
        //let's print all cells  in the table dynamically/Here, we use nested loop

       int rowNumber=getNumberOfRow();
       int columnNumber=getNumberOfColumn();

       //iterate through each row on the table
        for (int i = 1; i <=rowNumber; i++) {

            //iterate through each cell in the row
            for (int j = 1; j <= columnNumber; j++) {
                String cellXpath="//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]"; //string manipulation
                System.out.println(cellXpath);

                WebElement cell=driver.findElement(By.xpath(cellXpath));
                System.out.println(cell.getText());
            }
        }
    }
    @Test
    public void getCellInRelationToAnotherCellInSameRow(){
        //usually table is dynamic/ if you click anywhere or refresh rows can be changed
        //so we have to find a cell based on the another Cell in the same row, but not based on row number
        //Ex: let's find jon's email,jsmith@gmail.com, based on jon's name?--> we use text so that it is found dynamically

        String firstName="John";

        String xpath="//table[@id='table1']//td[.='"+firstName+"']/../td[3]"; //here td[3] cell based on john rows even if john's row changes

        WebElement johnEmail=driver.findElement(By.xpath(xpath));
        System.out.println(johnEmail.getText());
    }

    private int getNumberOfColumn() {
        List<WebElement>headers= driver.findElements(By.xpath("//table[@id='table1']//th"));
        return headers.size();
    }

    private int getNumberOfRow() {
        List<WebElement>allRowsWithoutHeader=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return allRowsWithoutHeader.size();
    }
}