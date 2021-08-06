package com.cybertek.tests.day2_webdriwer_basic;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {

    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("firefox");

        driver.get("https://google.com");

        String title = driver.getTitle();
        System.out.println("title = " + title);
    }

}
