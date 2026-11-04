package com.omrbranch.stepdefinition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;

import com.omrbranch.pagemanger.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC003_SelectHotelStep {
	
	PageObjectManager pom= new PageObjectManager();
	
	
	
	@When("User click sort from low to high")
	public void user_click_sort_from_low_to_high() {
		pom.getSelectHotelPage().clickSortingFromLowToHigh();
	}
	@Then("User should verify after sorting that prices are listed from low to high")
	public void user_should_verify_after_sorting_that_prices_are_listed_from_low_to_high() {		
	    List<Integer> actualPrices =pom.getSelectHotelPage().getHotelPriceList();
	    List<Integer> sortedPrices = new ArrayList<>(actualPrices);
	    Collections.sort(sortedPrices);
	    Assert.assertEquals(sortedPrices,actualPrices);     
	    }	
	@When("User click sort from descending order")
	public void user_click_sort_from_descending_order() {
	   pom.getSelectHotelPage().clickNameDescending();
	}
	@Then("User should verify after sorting that names are listed in descending order")
	public void user_should_verify_after_sorting_that_names_are_listed_in_descending_order() {		
		List<String> actualNames =pom.getSelectHotelPage().getHotelNameDescendingOrder();		
		List<String> sortedNames = new ArrayList<>(actualNames);		
		Collections.sort(sortedNames, Collections.reverseOrder());
		Assert.assertEquals(sortedNames, actualNames);
	}
	
	

	@When("User click Suite room type")
	public void user_click_suite_room_type() {
		pom.getSelectHotelPage().clickSuite();
	   
	}
	@Then("User should verify after filtering that Suite room type is listed")
	public void user_should_verify_after_filtering_that_suite_room_type_is_listed() {
		 List<String> actualRoomTypes =pom.getSelectHotelPage().selectSuiteRoomType();	 
	         for (String roomType : actualRoomTypes) {
	            Assert.assertTrue(roomType.toLowerCase().contains("suite"));
	        }
	    
	}
	
	
	@Then("User should verify the header contains {string}")
	public void user_should_verify_the_header_contains(String expectedRoomType) {
		String actualHeader=pom.getSelectHotelPage().suiteHeader();
		Assert.assertTrue(actualHeader.toLowerCase().contains(expectedRoomType.toLowerCase()));
	    
	}

	
	@When("User save the last hotel name and hotel price")
	public void user_save_the_last_hotel_name_and_hotel_price() {
	    
	}
	@When("User select the last hotel and accept the alert")
	public void user_select_the_last_hotel_and_accept_the_alert() {
	    
	}
	@Then("User should verify after select success message {string}")
	public void user_should_verify_after_select_success_message(String string) {
	    
	}
	

	@When("User save the second from last hotel name and hotel price")
	public void user_save_the_second_from_last_hotel_name_and_hotel_price() {
	    
	}
	@When("User select the second from last hotel and accept the alert")
	public void user_select_the_second_from_last_hotel_and_accept_the_alert() {
	    
	}
	
	@When("User save the second hotel name and hotel price")
	public void user_save_the_second_hotel_name_and_hotel_price() {
	    
	}
	@When("User select the second hotel and dismiss the alert")
	public void user_select_the_second_hotel_and_dismiss_the_alert() {
	    
	}	

}
