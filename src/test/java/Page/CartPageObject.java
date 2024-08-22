package Page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import BaseTest.DriverSetUp;
import action.Action;

public class CartPageObject  extends DriverSetUp{
	
	Action actionobj ;

	   
    public CartPageObject() {
    	actionobj = new Action();
    	PageFactory.initElements(getDriver(), this);

        //validate the Page title Constructor level
    	
    	Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/cart.html");
    	

    }
    
    
    @FindBy(xpath =  "//div[@class=\"cart_list\"]/div[@class=\"cart_item\"]")
    List<WebElement> cartprodut ;
    
    @FindBy(xpath = "//button[.=\"Checkout\"]")
    WebElement checkoututton;
    
    @FindBy(xpath = "//button[@id=\"continue-shopping\"]")
    WebElement continueShoppingButton;
    
    
    public void validateProdctAddedToCartInCartPage() {
    	int countprodutc = cartprodut.size();
    	System.out.println(countprodutc);
    	
    	Assert.assertTrue(countprodutc>0 , "Product Not Added to list");
    	
    }
    
    public CheckOutPageObject clickOnCheckOut() {
    	checkoututton.click();
    	return new CheckOutPageObject();
    	
    	
    	
    	
    }
    
    public ProductPageObject ClickOnContinueShopping() {
    	
    	continueShoppingButton.click();
    	return new 	ProductPageObject();
    	
    }
    
    
    
    
    


}
