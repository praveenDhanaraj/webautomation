package com.flipkart.webautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.flipkart.webautomation.pages.BasePage;

public class LoginPageObjects extends BasePage{

	public LoginPageObjects(WebDriver driver) {
		super(driver);
	}
	
	protected By header_login = By.xpath("//h3/span[contains(text(),'Login or Signup')]");

}
