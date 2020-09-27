package com.flipkart.webautomation.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.flipkart.webautomation.config.BaseTest;
import com.flipkart.webautomation.config.Constants;
import com.flipkart.webautomation.config.DriverManager;

public class BaseTestCase extends BaseTest{
	
	@BeforeMethod
	public void setup() {
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().get(Constants.baseURL);
	}
	
	@AfterMethod
	public void teardown() {
		System.out.println("Test completed");
	}


}
