package com.stepdefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.utils.Browser;
import com.utils.BrowserProvider;
import com.utils.ExtentManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Hooks {
    private static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;

    public static WebDriver getDriver(){
        return driver;
    }
    
    @Before
    public void setUp(Scenario scenario) {
        driver = BrowserProvider.createDriver(Browser.CHROME);
        driver.manage().window().maximize();
        extent = ExtentManager.getInstance();
        test = extent.createTest(scenario.getName(), scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        extent.flush();
        driver.quit();
    }

    public static void takeScreenshot(String status, String step){
        try{
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);
            String screenshotPath = "screenshots/"+System.currentTimeMillis()+".png";
            FileUtils.writeByteArrayToFile(new File(screenshotPath), screenshotBytes);
            if(status.equals("pass")){
                Hooks.test.pass(step, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } else {
                Hooks.test.fail(step, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

