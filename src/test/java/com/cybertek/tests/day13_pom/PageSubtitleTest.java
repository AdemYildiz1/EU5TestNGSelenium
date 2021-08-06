package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

    /* TEST CASE
    -open chrome browser
    -login as a Driver
    -verify that page subtitle is Quick Launchpad
    -Go to Activities-->Calender Events
    -verify that page subtitle is Calender Events
    */

    @Test
    public void test1(){
        LoginPage loginPage=new LoginPage(); //cons goes to LoginPage object model class and initialized login page locators to prepare login page

        loginPage.loginAsDriver();

        DashboardPage dashboardPage= new DashboardPage();

        String actualSubtitle= dashboardPage.getPageSubTitle();

        String expectedTitle= "Quick Launchpad";

        Assert.assertEquals(actualSubtitle,expectedTitle,"Verify subtitle");

        //for 2nd verify
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();

        BrowserUtils.waitFor(2);

        Assert.assertEquals(calendarEventsPage.getPageSubTitle(),"Calendar Events","Verify subtitle Calendar Events");

    }
}
