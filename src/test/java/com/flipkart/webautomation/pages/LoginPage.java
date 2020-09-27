package com.flipkart.webautomation.pages;

import org.openqa.selenium.WebDriver;

import com.flipkart.webautomation.pageobjects.LoginPageObjects;

public class LoginPage extends LoginPageObjects {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isLoginWindowDisplayed() {
		return isElementPresent(header_login, 10);
	}

}
