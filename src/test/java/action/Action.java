package action;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import BaseTest.DriverSetUp;

public class Action implements ActionInterface {

	@Override
	public void clickEle(WebDriver driver, WebElement ele) {

		ele.click();

	}

	@Override
	public void typeText(WebElement ele, String Value) {

		ele.click();

		ele.clear();
		ele.sendKeys(Value);

	}

	@Override
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	@Override
	public void equal(String value1, String value2) {
		Assert.assertEquals(value1, value2);
	}

	@Override
	public void validateCurrentPageTitle(WebDriver driver, String expectedvalue) {

		String actualtitle = getPageTitle(driver);
		equal(actualtitle, expectedvalue);
	}

	@Override
	public void selectDropDown(WebDriver driver, WebElement ele, String value) {
		
		Select sc = new Select(ele);
		List<WebElement> options = sc.getOptions();
		for (WebElement webElement : options) {
			String text = webElement.getText();
			if(text.equalsIgnoreCase(value)) {
				webElement.click();
				break;
			}
		}
		
		
	}

}
