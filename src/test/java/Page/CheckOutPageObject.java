package Page;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import BaseTest.DriverSetUp;
import action.Action;

public class CheckOutPageObject extends DriverSetUp {
	Action actionobj ;

	   
    public CheckOutPageObject() {
    	actionobj = new Action();
    	PageFactory.initElements(getDriver(), this);

        //validate the Page url Constructor level
    	Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");
    	

    }

}
