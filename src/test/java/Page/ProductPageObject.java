package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductPageObject{

    public WebDriver driver;

    public ProductPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }

    //locators



    //Actions

    public void validateProductPageCurrentURL(String expectedURL){
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
    }

}
