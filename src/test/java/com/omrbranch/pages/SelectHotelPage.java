package com.omrbranch.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.utility.BaseClass;

public class SelectHotelPage  extends BaseClass{
		
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//label[text()='Price low to high']")
	private WebElement sortPriceLowToHigh;
	
	@FindBy(xpath="//label[text()='Name Descending']")
	private WebElement clicknamedescending;
	
	@FindBy(xpath="//div[@class='prize']/strong")
	private List<WebElement> priceList;
		
	@FindBy(xpath="//div[contains(@class,'hotel-suites')]/h5")
	private List<WebElement> hotelNameList;
	
	@FindBy(xpath="//label[text()='Suite']")
	private WebElement clicksuite;
	
	@FindBy(id="room_type")
	private WebElement roomType;	

	public WebElement getRoomType() {
		return roomType;
	}

	public List<WebElement> getHotelNameList() {
		return hotelNameList;
	}

	public WebElement getClickSuite() {
		return clicksuite;
	}

	public WebElement getClicknamedescending() {
		return clicknamedescending;
	}

	public List<WebElement> getPriceList() {
		return priceList;
	}

	public WebElement getSortPriceLowToHigh() {
		return sortPriceLowToHigh;
	}
	
	
	public void clickSortingFromLowToHigh() {
		
		clickElement(sortPriceLowToHigh);
		
	}
	public List<Integer> getHotelPriceList() {

	    List<Integer> actualPriceList = new ArrayList<>();
	    implicitWait(120);
	    for (WebElement price : priceList) {
	    	
	        String text = price.getText();
	    	//String text=getTextElement(price);
	    	System.out.println(text);
	        String numericPrice = text.replaceAll("[^0-9]", "");
	        actualPriceList.add(Integer.parseInt(numericPrice));
	    }

	    return actualPriceList;
	}
	public void clickNameDescending() {
		clickElement(clicknamedescending);
	}
	
	public List<String> getHotelNameDescendingOrder(){
	
		List<String> actualNameList = new ArrayList<>();
		
	    for (WebElement name : hotelNameList) {
	        String hotelName = name.getText().trim();
	        System.out.println(hotelName);
	        if (hotelName.toLowerCase().contains("suite")) {
	            actualNameList.add(hotelName);
	        }
	    }
	    
		return actualNameList;
		
	}

	public void clickSuite() {
		//clickElement(clicksuite);
	}
	public List<String> selectSuiteRoomType(){
		List<String> roomTypes = new ArrayList<>();
        for (WebElement suiteRoom : hotelNameList) {
            roomTypes.add(suiteRoom.getText().trim());
        }
        return roomTypes;
	}
	
	public String suiteHeader() {
		String text=getTextElement(roomType);
		return text;
	}
	
	public void userSavethelastHotelNameandHotelPrice() {
	    
	}
public void selectLastHotel() {
	    
	}



}
