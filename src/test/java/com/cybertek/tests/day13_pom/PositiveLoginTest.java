package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    @Test
    public void LoginAsDriver() {

        LoginPage loginPage = new LoginPage();
        //1-
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        //2-
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.lognBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");
    }

    @Test
    public void LoginAsStoreManager() {
        //2- is gone to loginPage to make test case less touchable

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        loginPage.login(username, password);

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");

    }

    @Test
    public void LoginAsStoreManager2() {
        //1- and 2- are gone to loginPage to make test case less touchable, getting simpler:)

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsStoreManager();

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");

    }
}