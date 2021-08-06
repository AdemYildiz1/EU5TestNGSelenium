package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    //here we test by using "page object model" that is designed in login class in pages package for our app
    //it helps being more dynamic
    // REMEMBER FRAMEWORKS like "Page Object Model" helps write test cases easier and maintain test cases

    @Test
    public void wrongPasswordTest(){

        LoginPage loginPage=new LoginPage();

        loginPage.usernameInput.sendKeys("user1");
        loginPage.passwordInput.sendKeys("somepassword");
        loginPage.lognBtn.click();

        //verify: if current url does not change, means invalid username and password
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

    }
    @Test
    public void wrongUsernameTest() {
        LoginPage loginPage=new LoginPage();

        loginPage.usernameInput.sendKeys("someusername");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.lognBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

    }
}
