package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import BaseTest.DriverSetUp;

public class ProductPageObject extends DriverSetUp{

   
    public ProductPageObject() {
       
    	PageFactory.initElements(getDriver(), this);

        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }

    //locators



    //Actions

    public void validateProductPageCurrentURL(String expectedURL){
        Assert.assertEquals(getDriver().getCurrentUrl(),expectedURL);
    }

}
