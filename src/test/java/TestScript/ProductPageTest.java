package TestScript;

import BaseTest.DriverSetUp;
import Page.LoginPageObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductPageTest extends DriverSetUp {

    @BeforeMethod
    public void setUp() {
        BrowsersetUp();
    }

    @AfterMethod
    public void tearDown() {
        browserQuit();
    }

    @Test(priority = 0)
    public void validateLoginPage_Labels(){

        LoginPageObject obj = new LoginPageObject(driver);
        obj.getLoginPageTitle("Swag Labs");
        obj.validateLoginPageHeading("Swag Labs");
        obj.validatePlaceholdervalue("Username","Password");

    }
}
