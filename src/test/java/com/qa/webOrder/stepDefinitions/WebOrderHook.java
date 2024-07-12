package com.qa.webOrder.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class WebOrderHook {
    public WebDriver driver;

    @Before
    public void setup(){
        driver= DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("webOrder_url"));
    }

    @After
    public void tearDown(Scenario scenario){
        BrowserUtils.getScreenShotCucumber(driver, scenario);
        driver.quit();
    }
}
