package utility;

import BaseTest.DriverSetUp;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utility.*;
import BaseTest.DriverSetUp.*;

import java.io.IOException;
import java.sql.Driver;

public class Listeners  implements  ITestListener  {


    public   void onTestStart(ITestResult result) {
        System.out.println("Test Start");

        
    }

  
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Success");
       // System.out.println(driver.getCurrentUrl());
        
    }


    public  void onTestFailure(ITestResult result) {

       try {
            CommonFunctions.takeScreenShot();
        } catch (IOException e) {
            throw new RuntimeException(e);
       }

        System.out.println("Test Failure");


    }

    public void onTestSkipped(ITestResult result) {

    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }


    public void onTestFailedWithTimeout(ITestResult result) {

    }


    public void onStart(ITestContext context) {

        System.out.println("Test Start");

    }


    public void onFinish(ITestContext context) {
        System.out.println("Test Finish");

    }
}
