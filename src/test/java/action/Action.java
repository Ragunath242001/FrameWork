package action;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import BaseTest.DriverSetUp;

public class Action implements ActionInterface {

	
	//click on element
	@Override
	public void clickEle(WebDriver driver, WebElement ele) {
		ele.click();
	}

	
	/*
	 * 1.Click on the field
	 * 2.clear the text if exist
	 * 3.pass the value to field
	 */
	@Override
	public void typeText(WebElement ele, String Value) {
		ele.click();
		ele.clear();
		ele.sendKeys(Value);

	}

	//To get current page tilte
	@Override
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	//To validate actual and Expected values are  Equal 
	@Override
	public void equal(String value1, String value2) {
		Assert.assertEquals(value1, value2);
	}

	/*
	 * 1.To fetch the current page tile
	 * 2.To compare actual and Expected value
	 */
	@Override
	public void validateCurrentPageTitle(WebDriver driver, String expectedvalue) {

		String actualtitle = getPageTitle(driver);
		equal(actualtitle, expectedvalue);
	}

	
	/*
	 * Handling DropDown
	 * 
	 * 1.Created object For select 
	 * 2.fetch all the dropdown 
	 * 3.To check expected value is present in the List
	 * 4.If value match then need to click ele
	 */
	@Override
	public void selectDropDown(WebDriver driver, WebElement ele, String value) {

		Select sc = new Select(ele);
		List<WebElement> options = sc.getOptions();
		for (WebElement webElement : options) {
			String text = webElement.getText();
			if (text.equalsIgnoreCase(value)) {
				webElement.click();
				break;
			}
		}

	}

}
