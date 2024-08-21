package TestScript;
import BaseTest.*;
import Page.LoginPageObject;
import org.testng.annotations.*;



import utility.CommonFunctions;
import utility.ExtentManager;

public class LoginPageTest  extends DriverSetUp {

    @BeforeMethod
    public void setUp() {
        ExtentManager.setExtent();
        BrowsersetUp();
       
		
    }

    @AfterMethod
    public void tearDown() {
        ExtentManager.endReport();
    	
        browserQuit();
    }

    @Test(priority = 0)
    public void validateLoginPage_Labels(){

        LoginPageObject obj = new LoginPageObject();
        obj.getLoginPageTitle(getDriver(),"Swag Labs");
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

    @Test(priority = 3)
    public void validateLoginPage_Labelstemp(){

        LoginPageObject obj = new LoginPageObject();
        obj.getLoginPageTitle(getDriver(),"Swag Labs");
        obj.validateLoginPageHeading("Swag Labs");
        obj.validatePlaceholdervalue("Username","Password");



    }






}
