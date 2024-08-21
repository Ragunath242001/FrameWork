package BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import utility.readPropertieFile;

public class DriverSetUp {

    public  WebDriver driver = null;


    public void BrowsersetUp(){

     String originaldriverType =    readPropertieFile.configProperties("driver");
     String driverType = originaldriverType.toLowerCase();

     switch (driverType){
         case "chrome":
             WebDriverManager.chromedriver().setup();
             driver = new ChromeDriver();
             break;
         case "firefox":
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            break;
         case "IE":
             WebDriverManager.iedriver().setup();
             driver = new InternetExplorerDriver();
             break;
         default:
             System.err.println(driverType+" - Not a valid driver type");
     }
     driver.get(readPropertieFile.configProperties("url"));
     driver.manage().window().maximize();



    }


    public void browserQuit(){
        driver.quit();
    }


    public   WebDriver returnDriver(){
        return driver;

    }




}
