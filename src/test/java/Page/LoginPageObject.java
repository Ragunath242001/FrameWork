package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utility.CommonFunctions;

public class LoginPageObject  {

    WebDriver driver;
    public LoginPageObject(WebDriver driver) {

        //intilize the drive to ele
        this.driver = driver;
        PageFactory.initElements(driver, this);

        //validate the Page title Constructor level
        Assert.assertEquals(driver.getTitle(),"Swag Labs");

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
        Assert.assertEquals(driver.getTitle(),PageTitle);

    }

    //validate LoginPage Header Title
    public void validateLoginPageHeading(String value){
      String headingValue =   loginHeadingele.getText();
      Assert.assertEquals(headingValue,value);

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
        usernameele.sendKeys(username);
        passwordele.sendKeys(password);

    }

    //click on Login Button
    public void ClickOnLoginButton(){
        loginButtonele.click();
        System.out.println(driver.getCurrentUrl());

    }


    public void loginEmptyUserNamePassword(String Expectederror){
        String errorname = errormessageele.getText();
        Assert.assertEquals(errorname,Expectederror);

    }

    public void correctUsernameWrongPassword(String Expectederror){
        String errorname = errormessageele.getText();
        Assert.assertEquals(errorname,Expectederror);


    }

    public void wrongUsernameCorrectPassword(String Expectederror){
        String errorname = errormessageele.getText();
        Assert.assertEquals(errorname,Expectederror);

    }

    public void wrongUsernamePassword(String Expectederror){
        String errorname = errormessageele.getText();
        Assert.assertEquals(errorname,Expectederror);

    }

    public ProductPageObject correctUserNameAndPassword(){

        return new ProductPageObject(driver);

    }










}
