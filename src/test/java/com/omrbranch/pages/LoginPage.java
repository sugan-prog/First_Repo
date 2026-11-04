package com.omrbranch.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.utility.BaseClass;

public class LoginPage extends BaseClass{
	public LoginPage() {

		PageFactory.initElements(driver, this);

		}
	@FindBy(id = "email")
	private WebElement txtEmailId;
	
	@FindBy(id = "pass")
	private WebElement txtPassword;

	@FindBy(xpath = "//button[@value='login']")
	private WebElement btnLogin;	
	
	@FindBy(id="errorMessage")
	private WebElement LoginErrorMessageText;
	
		public WebElement getTxtEmailId() {
		return txtEmailId;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}
	
	public void loginWithoutEnterKey(String emailId, String password) {
		sendKeysElement(txtEmailId, emailId);
		sendKeysElement(txtPassword, password);
		clickElement(btnLogin);	
		
	}
	public void loginEnterKey(String emailId, String password) {
		sendKeysElement(txtEmailId, emailId);
		sendKeysElementEnter(txtPassword, password);
		 
		}
	
	
	public String getLoginErrorMessageText() {
			String text=getTextElement(LoginErrorMessageText);
			return text;	
		}

	
}
