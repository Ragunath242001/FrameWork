package TestScript;

import BaseTest.*;
import Page.LoginPageObject;
import org.testng.annotations.*;

import utility.CommonFunctions;
import utility.ExtentManager;

public class LoginPageTest extends DriverSetUp {

	
	@BeforeMethod
	public void setUp() {
		//ExtentManager.setExtent();

		BrowsersetUp();

	}

	@AfterMethod
	public void tearDown() {
		//ExtentManager.endReport();

		browserQuit();
	}

	

	@Test(priority = 0)
	public void validateLoginPage_Labels() {

		LoginPageObject	loginobj = new LoginPageObject();
		loginobj.getLoginPageTitle("Swag Labs");
		loginobj.validateLoginPageHeading("Swag Labs");
		loginobj.validatePlaceholdervalue("Username", "Password");
		

	}

	@Test(priority = 1)
	public void validateLoginButtonIsDisplayed() {
		
		LoginPageObject loginobj = new LoginPageObject();
		loginobj.LoginButtonIsDisplayed(getDriver());
		
	
		

	}

	@Test(priority = 2, dataProvider = "testData", dataProviderClass = CommonFunctions.class)
	public void validateLoginPage_login(String username, String password) {
		System.out.println(username + " " + password);

		LoginPageObject loginobj = new LoginPageObject();
		loginobj.Login(username, password);
		loginobj.ClickOnLoginButton();
		loginobj.validateLoginFunction();

	}

}
