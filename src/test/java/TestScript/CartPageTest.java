package TestScript;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseTest.DriverSetUp;
import Page.CartPageObject;
import Page.LoginPageObject;
import Page.ProductPageObject;

public class CartPageTest extends DriverSetUp {
	

	@BeforeMethod
	public void setUp() {

		BrowsersetUp();

	}

	@AfterMethod
	public void tearDown() {

		browserQuit();
	}
	
	LoginPageObject loginobj ;
	ProductPageObject productobj;
	CartPageObject clickOnCartIco;

	@Test(priority = 0)
	public void validateLoginPage_Labels() throws InterruptedException {

		loginobj = new LoginPageObject();
    	loginobj.Login("standard_user", "secret_sauce");
    	loginobj.ClickOnLoginButton();
     	productobj = new ProductPageObject();
     	productobj.selectPrizeValue("Price (low to high)");
     	productobj.clickOnAddToCart();
     	clickOnCartIco = productobj.clickOnCartIcon();
     	clickOnCartIco.validateProdctAddedToCartInCartPage();
     	
	}
	
	@Test(priority = 1 , description = "validate check out after added product to the cart")
	public void ValidateCheckoutFunctionality() {
		
		loginobj = new LoginPageObject();
    	loginobj.Login("standard_user", "secret_sauce");
    	loginobj.ClickOnLoginButton();
     	productobj = new ProductPageObject();
     	productobj.selectPrizeValue("Price (low to high)");
     	productobj.clickOnAddToCart();
     	clickOnCartIco = productobj.clickOnCartIcon();
     	clickOnCartIco.clickOnCheckOut();
     	
		
	}
	
	
	@Test(priority = 2 , description = "validate continue shopping From cart page")
	public void validateContinueShoppingFunctionality() {
		
		loginobj = new LoginPageObject();
    	loginobj.Login("standard_user", "secret_sauce");
    	loginobj.ClickOnLoginButton();
     	productobj = new ProductPageObject();
     	productobj.selectPrizeValue("Price (low to high)");
     	productobj.clickOnAddToCart();
     	clickOnCartIco = productobj.clickOnCartIcon();
     	clickOnCartIco.ClickOnContinueShopping();
		
	}

}
