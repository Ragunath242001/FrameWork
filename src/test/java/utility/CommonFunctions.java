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
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dateString = formatter.format(date);
        return dateString;

    }

    public static void takeScreenShot(WebDriver driver) throws IOException {

        File decloc = new File("./src/test/java/Resource/ScreenShot/"+getDate()+".png");
        TakesScreenshot ts = (TakesScreenshot)driver;
       File srcfileloc =  ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcfileloc, decloc);

    }


}
