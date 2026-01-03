package testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginParabankTest;

public class LoginTestCase {

	BaseClass base;
	LoginParabankTest login;

	@BeforeClass(groups = "smoke")
	public void openBrowser() {

		base = new BaseClass();
		base.init();
	}

	@Test(dataProvider = "logindata", dataProviderClass = dataproviderclasses.DataProviderClass.class)
	public void login(String userName, String password) {

		login = new LoginParabankTest();
		login.loginActions(userName, password);
		System.out.println();

	}

	@AfterClass(groups = "smoke")
	public void quitBrowser() {

		base.tearDown();
	}

}
