package com.flipkart.webautomation.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static void setDriver() {
		String browser = System.getProperty("browser");

		if (browser == null || browser.equals("chrome")) {
			driver.set(getChromeDriver());
		} else if (browser.equals("firefox")) {
			driver.set(getFirefoxDriver());
		} else if (browser.equals("ie")) {
			driver.set(getInternetExplorerDriver());
		}

	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void terminate() {
		driver.get().close();
		driver.get().quit();
		driver.remove();
	}

	private static ChromeDriver getChromeDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-popup-bloacking");
		option.addArguments("--start-maximized");
		option.addArguments("--incognito");
		DesiredCapabilities chrome = DesiredCapabilities.chrome();
		chrome.setJavascriptEnabled(true);
		option.setCapability(ChromeOptions.CAPABILITY, option);
		return new ChromeDriver(option);
	}

	private static FirefoxDriver getFirefoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}

	private static InternetExplorerDriver getInternetExplorerDriver() {
		WebDriverManager.iedriver().setup();
		return new InternetExplorerDriver();
	}

}
