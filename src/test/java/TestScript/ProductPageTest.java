package TestScript;

import BaseTest.DriverSetUp;
import Page.LoginPageObject;
import Page.ProductPageObject;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.ExtentManager;

public class ProductPageTest extends DriverSetUp {

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

	
	

	@Test(priority = 0, description = "Validating Currect page url ")
	public void ProductPageValidation() {

		LoginPageObject loginobj = new LoginPageObject();
		loginobj.Login("standard_user", "secret_sauce");
		loginobj.ClickOnLoginButton();
		loginobj.validateLoginFunction();
		ProductPageObject productobj = new ProductPageObject();
		productobj.validateProductPageCurrentURL("https://www.saucedemo.com/inventory.html");

	}

	@Test(priority = 1, description = "validate prize Dropdown")
	public void validatePrizeSection() {
		LoginPageObject loginobj = new LoginPageObject();
		loginobj.Login("standard_user", "secret_sauce");
		loginobj.ClickOnLoginButton();
		ProductPageObject productobj = new ProductPageObject();
		productobj.selectPrizeValue("Price (low to high)");

	}

	@Test(priority = 2, description = "validate product is  Displayed or not")
	public void validateISProductDisplayed() {
		LoginPageObject loginobj = new LoginPageObject();
		loginobj.Login("standard_user", "secret_sauce");
		loginobj.ClickOnLoginButton();
		ProductPageObject productobj = new ProductPageObject();
		productobj.validateProductIsVisible();

	}

	@Test(priority = 3)
	public void validateAddToCart() {
		LoginPageObject loginobj = new LoginPageObject();
		loginobj.Login("standard_user", "secret_sauce");
		loginobj.ClickOnLoginButton();
		ProductPageObject productobj = new ProductPageObject();
		productobj.validateProductIsVisible();
		productobj.validateAddToCartAndProductCount();

	}

	@Test(priority = 4, description = "Add product To Cart")
	public void addProductToCart() {
		LoginPageObject loginobj = new LoginPageObject();
		loginobj.Login("standard_user", "secret_sauce");
		loginobj.ClickOnLoginButton();
		ProductPageObject	productobj = new ProductPageObject();
		productobj.selectPrizeValue("Price (low to high)");
		productobj.clickOnAddToCart();

	}
}
