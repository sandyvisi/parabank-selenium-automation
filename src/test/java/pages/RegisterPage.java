package pages;

import org.openqa.selenium.By;

import base.BaseClass;

public class RegisterPage extends BaseClass {

	private By registerLinkLocator = By.xpath("//a[text()='Register']");

	private By submitButtonLocator = By.xpath("//form[@id='customerForm']//input[@type='submit']");

	private String formLocatosXpath = "//form[@id='customerForm']/child::table/tbody/tr/td/child::input[@id='%s']";

	private void clickRegisterLink(By locator) {

		click(locator);
	}

	private void clickSubmitButton(By locator) {

		click(locator);
	}

	private By formLocator(String dynamicXpath, String fieldValue) {

		return By.xpath(String.format(dynamicXpath, fieldValue));

	}

	private void formActions(String fieldAttributeValue, String firstName) {

		enterText(formLocator(formLocatosXpath, fieldAttributeValue), firstName);
	}

	public void registerFunctions(String firstName, String lastName, String address, String city, String state,
			String zipcode, String phoneNumber, String ssnNumber, String userName, String password,
			String repeatPassword) {

		clickRegisterLink(registerLinkLocator);
		formActions("customer.firstName", firstName);
		formActions("customer.lastName", lastName);
		formActions("customer.address.street", address);
		formActions("customer.address.city", city);
		formActions("customer.address.state", state);
		formActions("customer.address.zipCode", zipcode);
		formActions("customer.phoneNumber", phoneNumber);
		formActions("customer.ssn", ssnNumber);
		formActions("customer.username", userName);
		formActions("customer.password", password);
		formActions("repeatedPassword", repeatPassword);
		clickSubmitButton(submitButtonLocator);

	}

}
