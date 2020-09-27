package com.flipkart.webautomation.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.flipkart.webautomation.pageobjects.ProductDetailsPageObjects;

public class ProductDetailsPage extends ProductDetailsPageObjects {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	public ProductDetailsPage selectFootwearSize(String size) {
		waitForElementsToBeVisible(list_footwearSize, 10);
		List<WebElement> sizeList = driver.findElements(list_footwearSize);
		if(size.isEmpty()) {
			clickOnElement(sizeList.get(0));
			return this;
		}
		
		for(WebElement s: sizeList) {
			if(s.getText().contains(size)) {
				clickOnElement(s);
			}
		}
		return this;
	}
	
	public ProductDetailsPage switchToProductWindow() {
		switchToLastWindow();
		return this;
	}

	public ProductDetailsPage clickBuyNow() {
		clickAction(button_buyNow);
		return this;
	}
}
