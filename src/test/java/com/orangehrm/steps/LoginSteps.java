package com.orangehrm.steps;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.google.common.collect.Maps;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.CommonMethods;
import com.orangehrm.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;


public class LoginSteps extends CommonMethods {
	LoginPage login; //made it global, --> use it in every method

	@Given("I see OrangeHrm logo")
	public void i_see_OrangeHrm_logo() {
		login=new LoginPage(); //creating an obj of the LoginPage class (object repository)
		boolean isDisplayed = login.logo.isDisplayed(); //verification
		Assert.assertTrue(isDisplayed);
	}

	@When("I enter valid username & password")
	public void i_enter_valid_username_password() {
	  sendText(login.name, ConfigsReader.getProperty("username"));
	  sendText(login.password, ConfigsReader.getProperty("password"));
	}

	@When("I click login button")
	public void i_click_login_button() {
		click(login.loginBtn);
	}

	@Then("I successfully logged in")
	public void i_successfully_logged_in() {
		HomePage home=new HomePage();
		Assert.assertTrue(home.dashboardText.isDisplayed());
	}
	
	@When("I enter invalid username & password")
	public void i_enter_invalid_username_password() {
		sendText(login.name, "test");
		sendText(login.password, "AQ5sx1X@nM");
	}

	@Then("I see error massage is displayed")
	public void i_see_error_massage_is_displayed() { //or -->
	   Assert.assertTrue(login.invalidLog.isDisplayed());
	   String errorText=  login.invalidLog.getText();
	   Assert.assertEquals("Invalid Credentials", errorText.trim()); //if it has a space, we can trim it
	}

	@When("I enter invalid username & password I see errorMessage")
	public void i_enter_invalid_username_password_I_see_errorMessage(DataTable wrongCredentials) {
		List<Map<String, String>>maps=wrongCredentials.asMaps();
		for(Map<String, String> map:maps) {
			//passing username & password from dataTable/map
			sendText(login.name, map.get("UserName"));
			sendText(login.password, map.get("Password"));
			click(login.loginBtn);
			//verifying text or errorMessage
			String actualError=login.invalidLog.getText().trim();
			String expectedError=map.get("ErrorMessage");
			Assert.assertEquals(expectedError, actualError);
			//printing values of each key
			System.out.println(map.get("UserName"));
			System.out.println(map.get("Password"));
			System.out.println(map.get("ErrorMessage"));
			System.out.println("---------------------");
		}
	}
}
