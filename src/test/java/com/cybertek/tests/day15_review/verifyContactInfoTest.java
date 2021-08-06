package com.cybertek.tests.day15_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyContactInfoTest extends TestBase {

    /* Test Case
  -open the chrome
  -go to qa1.vytrack
  -login as a sales manager
  -navigate to customers ->contacts
  -click on email mbrackstone9@example.com
  -verify that full name is Mariam Brackstone
  -verify that email is mbrackstone9@example.com
  -verify that phone number is +18982323434
     */
@Test
    public void contactDetailsTest() throws InterruptedException {
    extentLogger=report.createTest("Contact Info Verification");
    LoginPage loginPage =new LoginPage();

    extentLogger.info("Login as sales manager");
    loginPage.loginAsSalesManager();

    extentLogger.info("Navigate to --> customers  > contacts module");
    DashboardPage dashboardPage=new DashboardPage();

    dashboardPage.waitUntilLoaderScreenDisappear();
    dashboardPage.navigateToModule("Customers","Contacts");

    extentLogger.info("Click the contact email->mbrackstone9@example.com ");
    ContactsPage contactsPage=new ContactsPage();
    contactsPage.waitUntilLoaderScreenDisappear();
    contactsPage.getContactEmail("mbrackstone9@example.com").click();

    ContactInfoPage contactInfoPage=new ContactInfoPage();

    String actualFullName=contactInfoPage.fullName.getText();
    String expectedFullName="Mariam Brackstone";

    extentLogger.info("Verify full name->"+expectedFullName);
    Assert.assertEquals(actualFullName,expectedFullName,"Verify Full name");

    //lazy ways
    extentLogger.info("Verify email-> mbrackstone9@example.com");
    Assert.assertEquals(contactInfoPage.email.getText(),"mbrackstone9@example.com","verify email");

    extentLogger.info("verify phone number->+18982323434");
    Assert.assertEquals(contactInfoPage.phone.getText(),"+18982323434","Verify phone number");
    extentLogger.pass("PASS");

  }
}
