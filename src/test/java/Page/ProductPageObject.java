package Page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import BaseTest.DriverSetUp;
import TestScript.CartPageTest;
import action.Action;

public class ProductPageObject extends DriverSetUp{
	Action actionobj;
   
    public ProductPageObject() {
    	
    	 actionobj = new  Action();
       
    	PageFactory.initElements(getDriver(), this);

        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }

    //locators
    @FindBy(xpath = "//select[@class=\"product_sort_container\"]")
    WebElement selectele ;
    
    @FindBy(xpath = "//div[@class=\"inventory_list\"]/div")
    List<WebElement>  productDetails;
    
    @FindBy(xpath = "//button[.=\"Add to cart\"]")
    List<WebElement> addToCart;
    
    @FindBy(xpath = "//span[@class=\"shopping_cart_badge\"]")
    WebElement addToCartIconCount;
    
    
    @FindBy(xpath = "//a[@class=\"shopping_cart_link\"]")
    WebElement cartIcon;
    
    



    //Actions

    public void validateProductPageCurrentURL(String expectedURL){
        Assert.assertEquals(getDriver().getCurrentUrl(),expectedURL);
    }
    
    
    //select prize dropdown
    
    public void selectPrizeValue(String value) {
    	
    	actionobj.selectDropDown(getDriver(), selectele, value);
 
    }
    
    public void validateProductIsVisible() {
    	
    	int productcount = productDetails.size();
    	System.out.println(productcount);
    	if(productcount>0) {
    		Assert.assertTrue(true);
    	}
    	else {
    		Assert.assertTrue(false, "Product Not Displayed");
    	}
    	
    }
    
    public void  validateAddToCartAndProductCount() {
    	
    	int addtocartcount = addToCart.size();
    	int productcount = productDetails.size();
    	
    	Assert.assertEquals(addtocartcount, productcount);
    	
    }
    
    
    public void   clickOnAddToCart() {
    	
    	addToCart.get(0).click();
    	int text = Integer.parseInt( addToCartIconCount.getText());
    	
    	Assert.assertTrue(text>0 , "Unable to add product to cart ");
    	
	
    }
    
    public CartPageObject clickOnCartIcon() {
    	
    	actionobj.clickEle(getDriver(), cartIcon);
    	
    	return new CartPageObject();
    	
    	
    
    }

}
