package com.flipkart.webautomation.config;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

	@BeforeSuite
	public void setPath() {
		System.setProperty("wdm.cachePath", "src/test/java/com/flipkart/webautomation/config");
	}

	@BeforeMethod(alwaysRun = true)
	public void setupDriverInstance() {
		DriverManager.setDriver();
	}

	@AfterMethod(alwaysRun = true)
	public void quitDriver() {
		DriverManager.terminate();
	}

}
