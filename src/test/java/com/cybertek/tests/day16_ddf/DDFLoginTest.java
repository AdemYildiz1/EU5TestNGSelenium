package com.cybertek.tests.day16_ddf;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {

    //Here, our test case is the same for each test(repeating) we use login and verify the user full name in the excel

    @DataProvider
    public Object[][] userData(){
        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");

        String [][]dataArray=qa3short.getDataArrayWithoutFirstRow();

        return dataArray;
    }
    //it is executed 13 times because data provider provides 13 sets(rows) of data/excel
    //basically it runs for each of rows that comes dataProvider one by one
    @Test(dataProvider ="userData")
    public void test1(String userName, String password, String firstName, String lastName){

        extentLogger=report.createTest("Test"+firstName+" "+lastName);
        LoginPage loginPage =new LoginPage();

        loginPage.login(userName,password);

        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();

        String actualFullName=dashboardPage.getUserName();
        String expectedFullName=firstName+" "+lastName;

        Assert.assertEquals(actualFullName,expectedFullName,"Verify full name");
        extentLogger.pass("PASSED");

    }
}
