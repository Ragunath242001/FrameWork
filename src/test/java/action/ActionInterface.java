package action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ActionInterface {
	
	//Click element 
	public void clickEle(WebDriver driver,WebElement ele);
	
	//SendKey 
	public void typeText(WebElement ele , String Value);
	
	//getCurrent Page Title 
	public String getPageTitle(WebDriver driver);
	
	//Validate Two Values
	public void  equal(String value1 , String value2);
	
	
	//Validate Current and Expected Page Title
	public void validateCurrentPageTitle(WebDriver driver,String expectedvalue);
	
	//select DropDown value 
	public void selectDropDown(WebDriver driver , WebElement ele , String value);
	
	

}
