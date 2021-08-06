package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionTests extends TestBase {
    /* VERIFY RADIO BUTTONS
    -Open chrome browser
    -Login as a driver
    -Go to Activities-> Calendar Events
    -Click on create calendar events
    -Click On Repeat
    -Verify that repeat everyday is checked
    -Verify that repeat weekday is NOT checked
     */

    @Test
    public void test1(){
        //-Login as a driver
        LoginPage loginPage =new LoginPage();

        loginPage.loginAsDriver();

        //-Go to Activities-> Calendar Events
        DashboardPage dashboardPage=new DashboardPage();

        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage =new CalendarEventsPage();

        //-Click on create calendar events
        //wait for loadermask(sayfanin yuklenmesi.
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();

        //-Click On Repeat
        CreateCalendarEventsPage createCalendarEventsPage =new CreateCalendarEventsPage();

        createCalendarEventsPage.repeat.click();

        //Verify that repeat everyday is checked
        Assert.assertTrue(createCalendarEventsPage.days.isSelected()," verify that repeat days is selected");

        //Verify that repeat weekday is NOT checked
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(),"verify that week is not selected");

    }
    /* VERIFY RADIO BUTTONS
    -Open chrome browser
    -Login as a driver
    -Go to Activities-> Calendar Events
    -Click on create calendar events button
    -Click On Repeat checkbox
    -Verify that repeat options are Daily, Weakly, Monthly, Yearly(in this order)
     */
    @Test
    public void test2(){
        //-Login as a driver
        LoginPage loginPage =new LoginPage();

        loginPage.loginAsDriver();

        //-Go to Activities-> Calendar Events
        DashboardPage dashboardPage=new DashboardPage();

        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage =new CalendarEventsPage();

        //-Click on create calendar events
        //wait for loadermask(sayfanin yuklenmesi.
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();

        //-Click On Repeat
        CreateCalendarEventsPage createCalendarEventsPage =new CreateCalendarEventsPage();

        createCalendarEventsPage.repeat.click();

        //-Verify that repeat options are Daily, Weakly, Monthly, Yearly(in this order)
        //create select object from select class so we use methods like getOptions();...etc
        Select repeatsDropdown= createCalendarEventsPage.repeatOptionsList();// =new Select(webElement); ,But it is ready in page object model

        //getOptions()--> returns all the available options from the dropdown
        List<WebElement>actualOptions=repeatsDropdown.getOptions();

       //Lets make an arrayList and add drop down elements/options to this list so that webElement list will be string list
        List<String> actualList =new ArrayList();

        for (WebElement option : actualOptions) {
            actualList.add(option.getText());
            //it gets text of each elements/option and adds to actualList
        }

        //make/prepare our expected List
        List<String>expectedList= Arrays.asList("Daily","Weekly","Monthly","Yearly");

        Assert.assertEquals(actualList,expectedList,"verify dropdown list");


        //We have ready method in BrowserUtils, for getting text of list of web elements
        List<String> actualList2 = BrowserUtils.getElementsText(actualOptions);
        System.out.println("actualList2 = " + actualList2);
    }

}
