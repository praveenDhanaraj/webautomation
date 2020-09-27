package com.flipkart.webautomation.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.webautomation.config.Constants;



public class BasePage {
	protected WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public BasePage waitForElementToBeVisible(By by,int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(by)));
		return this;
	}
	
	public BasePage waitForElementsToBeVisible(By by,int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(driver.findElements(by))));
		return this;
	}
	
	public BasePage waitForElementToBeClickable(By by,int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(driver.findElement(by))));
		return this;
	}
	
	public BasePage waitForElementToBeClickable(WebElement element,int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
		return this;
	}
	
	public BasePage clickOnElement(By by) {
		waitForElementToBeClickable(by, Constants.timeOut);
		driver.findElement(by).click();
		return this;
	}
	
	public BasePage clickOnElement(WebElement element) {
		waitForElementToBeClickable(element, Constants.timeOut);
		element.click();
		return this;
	}
	
	public BasePage typeOnTextField(By by, String inputValue) {
		waitForElementToBeVisible(by, Constants.timeOut);
		driver.findElement(by).sendKeys(inputValue);
		
		return this;
	}
	
	public boolean isElementPresent(By by, int waitTime) {
		waitForElementToBeVisible(by, waitTime);
		return driver.findElement(by).isDisplayed();
	}
	
	public BasePage switchToLastWindow() {
		String parent = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();

		Iterator<String> handles = windowHandles.iterator();
		while (handles.hasNext()) {

			String child_window = handles.next();

			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
			}
		}
		return this;
	}
	
	public BasePage switchToFrame(WebElement frame) {
		driver.switchTo().frame(frame);
		return this;
	}
	
	public BasePage clickAction(By by) {
		Actions build = new Actions(driver);
		waitForElementToBeVisible(by, Constants.timeOut);
		build.click(driver.findElement(by)).build().perform();
		return this;
	}
	
	public BasePage selectByValue(By by,String value) {
		waitForElementToBeClickable(by, Constants.timeOut);
		Select dropdown = new Select(driver.findElement(by));
		dropdown.selectByValue(value);
		return this;
	}
	
}
