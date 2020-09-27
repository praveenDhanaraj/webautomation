package com.flipkart.webautomation.pages;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.flipkart.webautomation.pageobjects.ProductsPageObjects;
import com.flipkart.webautomation.utils.StringUtilities;

public class ProductsPage extends ProductsPageObjects{

	public ProductsPage(WebDriver driver) {
		super(driver);
	}
	
	public ProductsPage dismissInitialPopup() {
		clickOnElement(button_closePopup);
		return this;
	}
	
	public ProductsPage searchItem(String searchString) {
		typeOnTextField(textbox_search, searchString);
		clickOnElement(button_search);
		return this;
	}
	
	public ProductsPage waitForSearchResult() {
		waitForElementToBeVisible(button_next, 10);
		return this;
	}
	
	
	public boolean isKeywordPresentInSearchResult(List<String> keywords) {
		List<WebElement> productList = driver.findElements(list_productsNames);
		
		for(WebElement product : productList) {
			String productName = product.getText();
			if(!containsKeyword(keywords, productName)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean containsKeyword(List<String> keywords,String word) {
		for(String keyword: keywords) {
			if(StringUtils.containsIgnoreCase(word, keyword)) return true;
		}
		
		return true;
	}
	
	public ProductsPage applyPriceFilter(String min,String max) {
		selectByValue(dropdown_minimumPrice, min);
		waitForFilterToBeApplied();
		selectByValue(dropdown_maximumPrice, max);
		return this;
	}
	
	public ProductsPage applyBrandFilter(String bandName) {
		typeOnTextField(textbox_brandName, bandName);
		List<WebElement> brands = driver.findElements(list_brandNames);
		for(WebElement element : brands) {
			if(element.getText().equalsIgnoreCase(bandName)) {
				clickOnElement(element);
			}
		}
		return this;
	}
	
	public boolean isBrandFilterApplied(String brandName) {
		List<WebElement> brandNamesInResultSet = driver.findElements(list_resultSetBrands);
		
		for(WebElement brand: brandNamesInResultSet) {
			if(!brand.getText().equalsIgnoreCase(brandName)) {
				System.out.println("Incorrect brand displayed:"+brand.getText());
				return false;
			}
		}
		return true;
	}
	
	public boolean isPriceFilterApplied(String minimumPrice,String maximumPrice) {
		List<WebElement> priceInResultSet = driver.findElements(list_resultSetPrices);
		int minPrice = StringUtilities.getIntegerFromString(minimumPrice);
		int maxPrice = StringUtilities.getIntegerFromString(maximumPrice);
		for(WebElement price: priceInResultSet) {
			String currentText = price.getText();
			String text;
			if(currentText.contains("+")) {
				text=currentText.substring(0, currentText.indexOf("+"));
			}else {
				text=currentText;
			}
			int currentPrice = StringUtilities.getIntegerFromString(text) ;
			if(currentPrice<minPrice || currentPrice>maxPrice) {
				System.out.println("Price is out of selected range:"+currentPrice);
				return false;
			}
		}
		return true;
	}
	
	public ProductsPage waitForFilterToBeApplied() {
		//To be updated with fluent wait
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public ProductDetailsPage selectRandomProductFromSearchResult() {
		List<WebElement> searchResult = driver.findElements(list_productsNames);
		Random random = new Random();
		clickOnElement(searchResult.get(random.nextInt(searchResult.size()-1)));
		return new ProductDetailsPage(driver);
	}
	
	public ProductsPage switchToProductWindow() {
		switchToLastWindow();
		return this;
	}
	
}
