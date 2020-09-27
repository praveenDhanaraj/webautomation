package com.flipkart.webautomation.tests;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.flipkart.webautomation.config.DriverManager;
import com.flipkart.webautomation.pages.LoginPage;
import com.flipkart.webautomation.pages.ProductsPage;
import com.flipkart.webautomation.utils.StringUtilities;
import com.flipkart.webautomation.utils.TestDataUtils;

public class ProductsTest extends BaseTestCase {

	Map<String, String> dataTable;

	@BeforeClass
	public void dataSetup() {
		dataTable = TestDataUtils.getPropertiesFileAsMap("productsTestData");
	}

	@Test(groups= {"sanity","regression"})
	public void verifySearchResult() {

		List<String> keywords = StringUtilities.getList(dataTable.get("searchKeywords"), ",");

		ProductsPage product = new ProductsPage(DriverManager.getDriver());
		Assert.assertTrue(
				product.dismissInitialPopup().searchItem(dataTable.get("searchString")).waitForSearchResult()
						.isKeywordPresentInSearchResult(keywords),
				"Verify whether shoes keyword is present in search result");

	}

	@Test(groups= {"regression"})
	public void verifyFilters() throws InterruptedException {

		ProductsPage product = new ProductsPage(DriverManager.getDriver());
		product.dismissInitialPopup().searchItem(dataTable.get("searchString")).waitForSearchResult()
				.applyPriceFilter(dataTable.get("filterMinPrice"), dataTable.get("filterMaxPrice"))
				.waitForFilterToBeApplied().applyBrandFilter(dataTable.get("filterBrand")).waitForFilterToBeApplied();

		Assert.assertTrue(
				product.isBrandFilterApplied(dataTable.get("filterBrand")) && product
						.isPriceFilterApplied(dataTable.get("filterMinPrice"), dataTable.get("filterMaxPrice")),
				"Validate brand and price filters");
	}

	@Test(groups= {"sanity","regression"})
	public void verifyBuyNow() throws InterruptedException {
		ProductsPage product = new ProductsPage(DriverManager.getDriver());

		product.dismissInitialPopup().searchItem(dataTable.get("searchString")).waitForSearchResult().selectRandomProductFromSearchResult()
				.switchToProductWindow().selectFootwearSize("").clickBuyNow();

		LoginPage login = new LoginPage(DriverManager.getDriver());
		Assert.assertTrue(login.isLoginWindowDisplayed(),
				"Verify whether login window is displayed on clicking buy now");
	}
}
