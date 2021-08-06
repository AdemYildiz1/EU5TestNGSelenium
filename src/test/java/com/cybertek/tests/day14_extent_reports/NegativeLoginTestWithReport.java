package com.cybertek.tests.day14_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {

    @Test
    public void wrongPasswordTest(){

        //name of the test
        extentLogger=report.createTest("Wrong password test");

        LoginPage loginPage=new LoginPage();

        loginPage.usernameInput.sendKeys("user1");
        extentLogger.info("Enter user name: user1");

        loginPage.passwordInput.sendKeys("somepassword");
        extentLogger.info("Enter password: somepassword");

        loginPage.lognBtn.click();
        extentLogger.info("Click Login button");

        extentLogger.info("Verify page URL");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

        extentLogger.pass("Wrong password test is passed"); //if it passes this wil be reported

    }
    @Test
    public void wrongUsernameTest() {
        //name of the test
        extentLogger=report.createTest("Wrong username test");
        LoginPage loginPage=new LoginPage();

        extentLogger.info("Enter user name: someusername");
        loginPage.usernameInput.sendKeys("someusername");

        extentLogger.info("Enter password UserUser123");
        loginPage.passwordInput.sendKeys("UserUser123");

        extentLogger.info("Click login button");
        loginPage.lognBtn.click();

        extentLogger.info("verify page url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

        extentLogger.pass("PASSED");
    }
}
