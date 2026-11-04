package com.omrbranch.stepdefinition;

import java.util.Arrays;

import java.util.List;

import org.junit.Assert;

import com.omrbranch.pagemanger.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC002_ExploreHotelStep {

	PageObjectManager pom= new PageObjectManager();

	@When("User search hotel {string}, {string}, {string}, {string}, {string}, {string}, {string} and {string}")
	public void user_search_hotel_and(String state, String city, String roomType, String checkInDate, String checkOutDate, String noOfRoom, String noOfAdults, String noOfChilds) {
		pom.getExploreHotelPage().searchHotel(state, city, roomType, checkInDate, checkOutDate, noOfRoom, noOfAdults, noOfChilds);
		
	}
	@Then("User should verify after search hotel success message {string}")
	public void user_should_verify_after_search_hotel_success_message(String txtselecthotel) {
		String actSearchHotelSuccessMessageText=pom.getExploreHotelPage().getSearchHotelSuccessMessageText();
		Assert.assertEquals("Verify after Login", txtselecthotel, actSearchHotelSuccessMessageText);
	    
	}
	
	
	@When("User search hotel {string}, {string}, {string}, {string}, {string} and {string}")
	public void user_search_hotel_and(String state, String city, String checkInDate, String checkOutDate, String noOfRoom, String noOfAdults) {
	    pom.getExploreHotelPage().searchHotelWithMandatoryFields(state, city, checkInDate, checkOutDate, noOfRoom, noOfAdults);
	}
	
	
	@When("User click Search button")
	public void user_click_search_button() {
	    pom.getExploreHotelPage().clickSearchButton();
	}
	@Then("User should verify after search hotel error message {string}, {string}, {string}, {string}, {string} and {string}")
	public void user_should_verify_after_search_hotel_error_message_and(String state, String city, String checkInDate, String checkOutDate, String noOfRoom, String noOfAdults) {
	    List<String> actaftersearchHotelErrorMeassage=pom.getExploreHotelPage().verifyAfterSearchHotelErrorMessage();
	    List<String> expectedMessages = Arrays.asList(state,city,checkInDate,checkOutDate,noOfRoom,noOfAdults);
	    Assert.assertEquals(expectedMessages,actaftersearchHotelErrorMeassage);
	}
	
	
	
}
