package utility;


import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;

public class Listeners extends ExtentManager implements ITestListener {
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Pass Test case is: " + result.getName());
        }
    }
    public void onTestFailure(ITestResult result) {

        test.log(Status.FAIL,
                MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
        test.log(Status.FAIL,
                MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

        //test.fail("Filed", MediaEntityBuilder.createScreenCaptureFromPath())

    }
    public void onTestSkipped(ITestResult result) {


    }
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {



    }
    public void onStart(ITestResult context) {


    }
    public void onFinish(ITestContext context) {


    }



}
