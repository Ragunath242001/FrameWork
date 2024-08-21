package TestScript;
import BaseTest.*;
import Page.LoginPageObject;
import org.testng.annotations.*;



import utility.CommonFunctions;

public class LoginPageTest  extends DriverSetUp {

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

        LoginPageObject obj = new LoginPageObject();
        obj.getLoginPageTitle(getDriver(),"wag Labs");
        obj.validateLoginPageHeading("Swag Labs");
        obj.validatePlaceholdervalue("Username","Password");

       
        
    }

    @Test(priority = 1,dataProvider = "testData" ,dataProviderClass = CommonFunctions.class)
    public void validateLoginPage_login(String username , String password){
        System.out.println(username+" "+password);

        LoginPageObject obj = new LoginPageObject();
        obj.Login(username,password);
        obj.ClickOnLoginButton();


    }

    @Test(priority = 2)
    public void validateLoginWithOutAnyValue(){
        LoginPageObject obj = new LoginPageObject();
        obj.ClickOnLoginButton();
        obj.loginEmptyUserNamePassword("Epic sadface: Username is required");

    }






}
