package utility;

import BaseTest.DriverSetUp;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


import utility.*;
import BaseTest.DriverSetUp.*;

import java.io.IOException;
import java.sql.Driver;

public class Listeners implements  ITestListener  {


    public   void onTestStart(ITestResult result) {
       
      

       // test = extent.createTest(result.getName());
    }

  
    public void onTestSuccess(ITestResult result) {
    	
    	System.out.println("Pass");
    }
    	
//  


    public  void onTestFailure(ITestResult result) {
    	
    	System.out.println("Test Failed");
    	
    	CommonFunctions.takeScreenShot(BaseTest.DriverSetUp.getDriver());
    

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
