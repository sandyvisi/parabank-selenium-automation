package stepDefinitions;

import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginParabankTest;
import pages.RegisterPageTest;

public class LoginStepDefinitions {

	BaseClass base;
	LoginParabankTest loginPara;

	String expected = "ParaBank | Welcome | Online Banking";

	@Given("user enters the login page")
	public void goToLoginPage() {

		base = new BaseClass();
		base.init();
		loginPara = new LoginParabankTest();
		System.out.println("user landed to login page");

	}

	@When("user enters {string} {string}")
	public void enterCreds(String userName, String password) {

		loginPara.loginActions(userName, password);
	}

	@Then("user is able to login propery")
	public void loggedIn() {

		String actual = base.getCurrentUrl();
		Assert.assertEquals(actual, expected);

	}

}