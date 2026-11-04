package com.omrbranch.stepdefinition;

import org.junit.Assert;

import com.omrbranch.pagemanger.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC001_LoginStep {
	PageObjectManager pom= new PageObjectManager();
	
	@Given("User is on the OMR Branch hotel page")
	public void user_is_on_the_omr_branch_hotel_page() {

	}
	
	@When("User enters {string} and {string}")
	public void user_enters_and(String emailId, String password) {
		
		pom.getLoginPage().loginWithoutEnterKey(emailId, password);

	}

	@Then("User should verify success message after login {string}")
	public void user_should_verify_success_message_after_login(String expFirstName) {
		String actLoginSuccessMessageText=pom.getExploreHotelPage().getLoginSuccessMessageText();
		Assert.assertEquals("Verify after Login", expFirstName, actLoginSuccessMessageText);
	}
	@When("User enters {string} and {string} with enter key")
	public void user_enters_and_with_enter_key(String emailId, String password) {
		pom.getLoginPage().loginEnterKey(emailId, password);

	}

	@Then("User should verify error message after login {string}")
	public void user_should_verify_error_message_after_login(String authenticationunsuccessful) {
		 String actLoginErrorMessageText = pom.getLoginPage().getLoginErrorMessageText();
		 
		 Assert.assertTrue("Verify Login Error Message " ,authenticationunsuccessful.contains(actLoginErrorMessageText));
		 System.out.println(authenticationunsuccessful);
	 
		
	}
	

}
