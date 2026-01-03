package testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.RegisterPage;

public class RegisterTestCase {

	BaseClass base;

	RegisterPage registerPage;

	@BeforeClass(groups = "smoke")
	public void openBrowser() {

		base = new BaseClass();
		base.init();
	}

	@Test(groups = "smoke", dataProvider = "registerData", dataProviderClass = dataproviderclasses.DataProviderClass.class)
	public void login(String firstName, String lastName, String address, String city, String state, String zipcode,
			String phoneNumber, String ssnNumber, String userName, String password, String repeatPassword) {

		registerPage = new RegisterPage();

		registerPage.registerFunctions(firstName, lastName, address, city, state, zipcode, phoneNumber, ssnNumber,
				userName, password, repeatPassword);

	}

	@AfterClass(groups = "smoke")
	public void quitBrowser() {

		base.tearDown();
	}

}
