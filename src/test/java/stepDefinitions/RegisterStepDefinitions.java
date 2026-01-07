package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginParabankTest;
import pages.RegisterPageTest;

public class RegisterStepDefinitions {

	BaseClass base;
	RegisterPageTest reigsterPage;

	@Before
	public void setUp() {
		base = new BaseClass();
		base.init();
		reigsterPage = new RegisterPageTest();
	}

	@Given("user landed to register page of parabank")
	public void user_landed_to_register_page_of_parabank() {

	}

	@When("enter all of the user's details to register {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void enter_all_of_the_user_s_details_to_register(String firstName, String lastName, String address,
			String city, String state, String zipcode, String phoneNumber, String ssnNumber, String userName,
			String password, String repeatPassword) {

		reigsterPage = new RegisterPageTest();

		reigsterPage.registerFunctions(firstName, lastName, address, city, state, zipcode, phoneNumber, ssnNumber,
				userName, password, repeatPassword);

	}

	@Then("user validated the function")
	public void user_validated_the_function() {

	}

	@After
	public void tearDown() {
		base.tearDown();
	}

}
