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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import utility.ExtentManager;
import utility.readPropertieFile;

public class DriverSetUp {

	// public WebDriver driver ;

	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	
	//To trigger Report  
	@BeforeSuite
	public void  loadConfig() {
		ExtentManager.setExtent();	
	}
	
	
	//Push all result to Report
	@AfterSuite
	public void terminateconfig() {
		ExtentManager.endReport();
		
	}

	
	//Driver setup 
	public void BrowsersetUp() {

		//To fetch driver type 
		String originaldriverType = readPropertieFile.configProperties("driver");
		String driverType = originaldriverType.toLowerCase();

		//Based on user value , it will assign browser instance 
		switch (driverType) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
			;
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			driver.set(new InternetExplorerDriver());
			break;
		default:
			System.err.println(driverType + " - Not a valid driver type");
		}

		// Maximize the screen
		getDriver().manage().window().maximize();

		// Delete all the cookies
		getDriver().manage().deleteAllCookies();

		// Launching the URL
		getDriver().get(readPropertieFile.configProperties("url"));
		
		//Wait for all webelement and elements
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//To wait for page load
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));

	}

	
	//TO Close all Browser instance
	public void browserQuit() {
		getDriver().quit();

	}

	// Get Driver from threadLocalmap
	public static WebDriver getDriver() {
		return driver.get();
	}

}
