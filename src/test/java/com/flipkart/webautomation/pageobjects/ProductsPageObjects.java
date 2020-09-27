package com.flipkart.webautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.flipkart.webautomation.pages.BasePage;

public class ProductsPageObjects extends BasePage{

	public ProductsPageObjects(WebDriver driver) {
		super(driver);
	}
	
	protected By button_closePopup = By.xpath("(//div[@tabindex='-1']//button)[1]");
	protected By textbox_search = By.xpath("//input[contains(@title,'Search')]");
	protected By button_search = By.xpath("//button[@type='submit']");
	protected By button_next = By.xpath("//span[text()='Next']");
	
	protected By list_productsNames = By.xpath("//a[@rel='noopener noreferrer']/following-sibling::div/a[1]");
	
	protected By dropdown_minimumPrice = By.xpath("//option[contains(text(),'Min')]/parent::select");
	protected By dropdown_maximumPrice = By.xpath("(//option[contains(text(),'Min')]/parent::select/parent::div/parent::div//select)[2]");
	protected By textbox_brandName = By.xpath("//input[@placeholder='Search Brand']");
	protected By list_brandNames = By.xpath("//input[@type='checkbox']/following-sibling::div");
	
	protected By list_resultSetPrices = By.xpath("//a[@rel='noopener noreferrer']/following-sibling::div/a[2]//div/div[1]");
	protected By list_resultSetBrands = By.xpath("//a[@rel='noopener noreferrer']/following-sibling::div/a[1]/preceding-sibling::div");
	
}
