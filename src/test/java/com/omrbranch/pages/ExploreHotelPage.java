package com.omrbranch.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.utility.BaseClass;

public class ExploreHotelPage extends BaseClass{
	
	public ExploreHotelPage() {
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//a[contains(text(),'Welcome')]")
	private WebElement txtsuccessmsg;
															
	@FindBy(id="state")	
	private WebElement selectState;
	
	@FindBy(id="city")
	private WebElement selectCity;
	
	@FindBy(id="room_type")
	private WebElement selectRoomType;
	
	@FindBy(xpath="//input[@name='check_in']")
	private WebElement checkInDate;
	
	@FindBy(xpath="//input[@name='check_out']")
	private WebElement checkOutDate;
	
	@FindBy(id="no_rooms")
	private WebElement noOfRooms;
	
	@FindBy(id="no_adults")
	private WebElement noOfAdults;
	
	@FindBy(id="no_child")
	private WebElement noOfChilds;
	
	@FindBy(xpath="//iframe[@id='hotelsearch_iframe']")
	private WebElement searchFrame;
	
	@FindBy(id="searchBtn")
	private WebElement btnsearch;	
	
	@FindBy(id="invalid-state")
	private WebElement invalidstate;	
	
	@FindBy(id="invalid-city")
	private WebElement invalidcity;
	
	@FindBy(id="invalid-check_in")
	private WebElement invalidcheckin;
	
	@FindBy(id="invalid-check_out")
	private WebElement invalidcheckout;
	
	@FindBy(id="invalid-no_rooms")
	private WebElement invalidnoRooms;
	
	@FindBy(id="invalid-no_adults")
	private WebElement invalidnoadults;
	
	@FindBy(xpath="//h5[text()='Select Hotel']")
	private WebElement txtselecthotel;

	public WebElement getTxtsuccessmsg() {
		return txtsuccessmsg;
	}
	
	public WebElement getSelectState() {
		return selectState;
	}

	public WebElement getSelectCity() {
		return selectCity;
	}

	public WebElement getSelectRoomType() {
		return selectRoomType;
	}

	public WebElement getCheckInDate() {
		return checkInDate;
	}

	public WebElement getCheckOutDate() {
		return checkOutDate;
	}

	public WebElement getNoOfRooms() {
		return noOfRooms;
	}

	public WebElement getNoOfAdults() {
		return noOfAdults;
	}

	public WebElement getNoOfChilds() {
		return noOfChilds;
	}

	public WebElement getSearchFrame() {
		return searchFrame;
	}

	public WebElement getBtnsearch() {
		return btnsearch;
	}	
	
	public WebElement getInvalidstate() {
		return invalidstate;
	}

	public WebElement getInvalidcity() {
		return invalidcity;
	}

	public WebElement getInvalidcheckin() {
		return invalidcheckin;
	}

	public WebElement getInvalidcheckout() {
		return invalidcheckout;
	}

	public WebElement getInvalidnoRooms() {
		return invalidnoRooms;
	}

	public WebElement getInvalidnoadults() {
		return invalidnoadults;
	}
	public WebElement getTxtselecthotel() {
		return txtselecthotel;
	}
	

	public String getLoginSuccessMessageText() {
		String text=getTextElement(txtsuccessmsg);
		return text;
		
		}
	public void searchHotel(String state,String city,String roomType,String check_In_Date,String check_Out_Date,String no_Of_Room,String no_Of_Adults,String no_Of_Childs) {
		selectOptionByText(selectState, state);
		selectOptionByValue(selectCity, city);
		selectOptionByValue(selectRoomType, roomType);
		sendKeysElementJS(checkInDate, check_In_Date);
		sendKeysElementJS(checkOutDate, check_Out_Date);
		selectOptionByText(noOfRooms, no_Of_Room);
		selectOptionByText(noOfAdults, no_Of_Adults);
		sendKeysElement(noOfChilds, no_Of_Childs);
		driver.switchTo().frame(searchFrame);
		clickElement(btnsearch);
		driver.switchTo().defaultContent();		
	}
public void searchHotelWithMandatoryFields(String state, String city, String check_In_Date, String check_Out_Date, String no_Of_Room, String no_Of_Adults) {
	selectOptionByText(selectState, state);
	selectOptionByValue(selectCity, city);
	sendKeysElementJS(checkInDate, check_In_Date);
	sendKeysElementJS(checkOutDate, check_Out_Date);
	selectOptionByText(noOfRooms, no_Of_Room);
	selectOptionByText(noOfAdults, no_Of_Adults);
	driver.switchTo().frame(searchFrame);
	clickElement(btnsearch);
	driver.switchTo().defaultContent();
	}
public void clickSearchButton() {
	driver.switchTo().frame(searchFrame);
	clickElement(btnsearch);
	driver.switchTo().defaultContent();    
}
public List<String> verifyAfterSearchHotelErrorMessage() {
    List<String> errorMessages = new ArrayList<>();
    errorMessages.add(getTextElement(invalidstate));
    errorMessages.add(getTextElement(invalidcity));
    errorMessages.add(getTextElement(invalidcheckin));
    errorMessages.add(getTextElement(invalidcheckout));
    errorMessages.add(getTextElement(invalidnoRooms));
    errorMessages.add(getTextElement(invalidnoadults));
    return errorMessages;
}

//List<Integer> asList=new Array.asList(10,20,30);
//collections.sort(asList);
//collections.reverse(asList);	
public String getSearchHotelSuccessMessageText() {
	String text=getTextElement(txtselecthotel);
	return text;
}
		
}
