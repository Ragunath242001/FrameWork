package Page;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import BaseTest.DriverSetUp;
import action.Action;
import utility.CommonFunctions;

public class LoginPageObject extends DriverSetUp {
	
	Action actionobj ;

   
    public LoginPageObject() {
    	actionobj = new Action();
    	PageFactory.initElements(getDriver(), this);

        //validate the Page title Constructor level
    	actionobj.validateCurrentPageTitle(getDriver(), "Swag Labs");

    }


    //locators

    @FindBy(xpath = "//div[@class=\"login_logo\"]")
    WebElement loginHeadingele;

    @FindBy(id="user-name")
    WebElement usernameele;

    @FindBy(id="password")
    WebElement passwordele;

    @FindBy(id="login-button")
    WebElement loginButtonele ;

    @FindBy(xpath = "//h3[@data-test=\"error\"]")
    WebElement errormessageele;



    //Action

    //Validate Login page Title
    public void getLoginPageTitle(String PageTitle ){
    	actionobj.equal(actionobj.getPageTitle(getDriver()), "Swag Labs");
    	
        

    }

    //validate LoginPage Header Title
    public void validateLoginPageHeading(String value){
    	
      String headingValue =   loginHeadingele.getText();
      actionobj.equal(headingValue, value);
     
    }

    //validate the Username and Password placeholder value
    public void validatePlaceholdervalue(String ExpectedusernameplaceHolder , String ExpectedPasswordPlacehoder){
    	
       String usernamepalceholder =  CommonFunctions.getAtrribute(usernameele);
       String passwordplaceholder =   CommonFunctions.getAtrribute(passwordele);

       Assert.assertEquals(usernamepalceholder,ExpectedusernameplaceHolder);
       Assert.assertEquals(passwordplaceholder,ExpectedPasswordPlacehoder);

    }

    //pass username and password
    public void Login(String username, String password){
    	
    	actionobj.typeText(usernameele, username);
    	actionobj.typeText(passwordele, password);
       

    }
    
    //Validate login Button is Displayed
    
    public void LoginButtonIsDisplayed(WebDriver driver) {
    	
    	System.out.println(driver.getCurrentUrl());
    	
    	boolean status = false ;
    	
    	try {
			WebElement ele = driver.findElement(By.id("login-button"));
			if(ele.isDisplayed()) {
				status=true;
			}
		} catch (Exception e) {
			
			status=false;
		}
    	
    	System.out.println(status);
    	
    	if(status) {
    		assertTrue(status , "Login Button is Displayed");
    		
    	}
    	else {
    		assertTrue(status , "Login Button is Not Displayed");
    	}
    	
    	//Assert.assertTrue(loginButtonele.isDisplayed());
    	
    	
    }

    //click on Login Button
    public void  ClickOnLoginButton(){
    	
    
    	
    	actionobj.clickEle(getDriver(), loginButtonele);	
 
    }
    
    
    
	public void validateLoginFunction() {

		boolean status = false;

		try {
			WebElement ele = getDriver().findElement(By.xpath("//h3[@data-test=\"error\"]"));
			if (ele.isDisplayed()) {
				status = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			status = false;
		}
		
		System.out.println(status);
		System.out.println(getDriver().getCurrentUrl());
		
		if(status) {
			String errormessage = errormessageele.getText();
			
			switch (errormessage) {
			case "Epic sadface: Username and password do not match any user in this service":
				wrongUserPassword("Epic sadface: Username and password do not match any user in this service");
				
				break;
			case "Epic sadface: Username is required":
				emptyuser("Epic sadface: Username is required");
				loginEmptyUserNamePassword("Epic sadface: Username is required");
				break;
			case "Epic sadface: Password is required":
				emptypassword("Epic sadface: Password is required");
				break;
			default:
				System.err.println("InValide Type");
				break;
			}
			
			
			
			
		}
		else {
			correctUserNameAndPassword();
		}
		
		

	}


    public void loginEmptyUserNamePassword(String Expectederror){
        String errorname = errormessageele.getText();
        Assert.assertEquals(errorname,Expectederror);

    }

    public void wrongUserPassword(String Expectederror){
        String errorname = errormessageele.getText();
        Assert.assertEquals(errorname,Expectederror);


    }

    public void emptyuser(String Expectederror){
        String errorname = errormessageele.getText();
        Assert.assertEquals(errorname,Expectederror);

    }

    public void emptypassword(String Expectederror){
        String errorname = errormessageele.getText();
        Assert.assertEquals(errorname,Expectederror);

    }

    public ProductPageObject correctUserNameAndPassword(){

        return new ProductPageObject();

    }










}
