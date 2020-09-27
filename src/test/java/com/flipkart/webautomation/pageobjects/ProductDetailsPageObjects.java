package com.flipkart.webautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.flipkart.webautomation.pages.BasePage;

public class ProductDetailsPageObjects extends BasePage{

	public ProductDetailsPageObjects(WebDriver driver) {
		super(driver);
	}
	
	protected By list_footwearSize = By.xpath("//li[contains(@id,'size')]/a");
	protected By button_buyNow = By.xpath("//button[text()='BUY NOW']");

}
