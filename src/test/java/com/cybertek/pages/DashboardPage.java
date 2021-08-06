package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage {
    //We create this because we want to reach BasePage(abstract class) that has common webElements

    //no need to explicitly write constructor(below)because it uses its parents constructor
    /*     public DashboardPage(){
                 PageFactory.initElements(Driver.get(), this);
          }
     */
    //Actually, just login page does not extend Base page because it does not common web elements or locator so it needs the init cons
    //Any classes of page object model do NOT need cons
    //because they already extend BasePage that has cons with init method
}

