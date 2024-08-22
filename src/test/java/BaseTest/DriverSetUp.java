package BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import utility.readPropertieFile;

public class DriverSetUp {

    //public   WebDriver driver ;
    
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	
	




    public void BrowsersetUp(){
    	
    	RemoteWebDriver remoteWebDriver = driver.get();

     String originaldriverType =    readPropertieFile.configProperties("driver");
     String driverType = originaldriverType.toLowerCase();

     switch (driverType){
         case "chrome":
             WebDriverManager.chromedriver().setup();
             driver.set(new ChromeDriver());
             break;
         case "firefox":
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());;
            break;
         case "IE":
             WebDriverManager.iedriver().setup();
             driver.set(new InternetExplorerDriver());
             break;
         default:
             System.err.println(driverType+" - Not a valid driver type");
     }
    
     
     
   //Maximize the screen
   		getDriver().manage().window().maximize();
   		
   		//Delete all the cookies
   		getDriver().manage().deleteAllCookies();
   		
   		//Launching the URL
   		getDriver().get(readPropertieFile.configProperties("url"));
   		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
   		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
   		
   		



    }


    public void browserQuit(){
    	getDriver().quit();
    }


	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}





}
