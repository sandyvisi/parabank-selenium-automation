package pages;

import org.openqa.selenium.By;

import base.BaseClass;

public class LoginParabank extends BaseClass {
	private By userNameLocator = By.xpath("//input[@name='username']");
	private By passwordLocator = By.xpath("//input[@name='password']");
	private By submitLocator = By.xpath("//input[@class='button']");

	private void enterUserName(By locator, String userName) {

		enterText(locator, userName);

	}

	private void enterPassword(By locator, String password) {

		enterText(locator, password);

	}

	private void clickSubmit(By locator) {

		click(locator);

	}

	public void loginActions(String userName, String password) {

		enterUserName(userNameLocator, userName);
		enterPassword(passwordLocator, password);
		clickSubmit(submitLocator);

	}

}
