package utility;
import BaseTest.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonFunctions  {


    public static String getAtrribute(WebElement ele){
       return  ele.getAttribute("placeholder");
    }



    @DataProvider(name = "testData")
    public  Object[][] passData() throws IOException {
       Object[][] data =  readPropertieFile.readExcelFile();
       return data;

    }

    public static String getDate(){

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
        String dateString = formatter.format(date);
        System.out.println(dateString);
        return dateString;

        
    }

    public static String takeScreenShot(WebDriver driver)   {
    	
    	String screenShotPath  = System.getProperty("user.dir")+"\\ScreenShot\\"+getDate()+".png";
    	System.out.println(screenShotPath);
    	
    	
    	

        File decloc = new File(screenShotPath);
        System.out.println(decloc);
        TakesScreenshot ts = (TakesScreenshot)driver;
       File srcfileloc =  ts.getScreenshotAs(OutputType.FILE);
        try {
			FileUtils.copyFile(srcfileloc, decloc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return screenShotPath;

    }
    



}
