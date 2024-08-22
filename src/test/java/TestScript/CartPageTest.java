package TestScript;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseTest.DriverSetUp;
import Page.CartPageObject;
import Page.LoginPageObject;
import Page.ProductPageObject;
import utility.ExtentManager;

public class CartPageTest extends DriverSetUp {
	

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
	public void validateProductAddedToCart() throws InterruptedException {

		LoginPageObject loginobj = new LoginPageObject();
    	loginobj.Login("standard_user", "secret_sauce");
    	loginobj.ClickOnLoginButton();
     	ProductPageObject productobj = new ProductPageObject();
     	productobj.selectPrizeValue("Price (low to high)");
     	productobj.clickOnAddToCart();
     	CartPageObject clickOnCartIco = productobj.clickOnCartIcon();
     	clickOnCartIco.validateProdctAddedToCartInCartPage();
     	
	}
	
	@Test(priority = 1 , description = "validate check out after added product to the cart")
	public void ValidateCheckoutFunctionality() {
		
		LoginPageObject loginobj = new LoginPageObject();
    	loginobj.Login("standard_user", "secret_sauce");
    	loginobj.ClickOnLoginButton();
    	ProductPageObject productobj = new ProductPageObject();
     	productobj.selectPrizeValue("Price (low to high)");
     	productobj.clickOnAddToCart();
     	CartPageObject clickOnCartIco = productobj.clickOnCartIcon();
     	clickOnCartIco.clickOnCheckOut();
     	
		
	}
	
	
	@Test(priority = 2 , description = "validate continue shopping From cart page")
	public void validateContinueShoppingFunctionality() {
		
		LoginPageObject loginobj = new LoginPageObject();
    	loginobj.Login("standard_user", "secret_sauce");
    	loginobj.ClickOnLoginButton();
    	ProductPageObject productobj = new ProductPageObject();
     	productobj.selectPrizeValue("Price (low to high)");
     	productobj.clickOnAddToCart();
     	CartPageObject clickOnCartIco = productobj.clickOnCartIcon();
     	clickOnCartIco.ClickOnContinueShopping();
		
	}

}
