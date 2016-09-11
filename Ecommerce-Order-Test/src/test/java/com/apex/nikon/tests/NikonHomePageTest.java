package com.apex.nikon.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.apex.nikon.nikonconstants.NikonCommonConstants;
import com.apex.nikon.nikonconstants.NikonHomeConstants;

public class NikonHomePageTest extends BaseNikonTest implements
		NikonCommonConstants, NikonHomeConstants {

//	@Test(priority = 1)
	 @Test(enabled = false)
	public void NikonHomeLogo() throws InterruptedException {
		WebElement logo = driver.findElement(By.xpath(LOGO_LOCATOR));
		Assert.assertEquals(true, logo.isDisplayed());
		Thread.sleep(SLEEP_TIME_10000);

		// logo.click();
		// logo = driver.findElement(By.xpath(LOGO_LOCATOR));
		// Assert.assertEquals(true, logo.isDisplayed());
		// org.openqa.selenium.StaleElementReferenceException: Element not found
		// in the cache - perhaps the page has changed since it was looked up
		// Command duration or timeout: 18 milliseconds

		// WebElement logoClick = driver.findElement(By.xpath(LOGO_LOCATOR));
		// logoClick.click();
		// Assert.assertEquals(true, logoClick.isDisplayed());
		// Thread.sleep(SLEEP_TIME_1000);
	}

//	@Test(priority = 2)
	 @Test(enabled = false)
	public void NikonHomeGlobalTabTest() {
		WebElement homeTab = driver.findElement(By.xpath(HOME_TAB_LOCATOR));
		WebElement newsTab = driver.findElement(By.xpath(NEWS_TAB_LOCATOR));
		WebElement aboutTab = driver.findElement(By.xpath(ABOUT_TAB_LOCATOR));
		WebElement productsTab = driver.findElement(By
				.xpath(PRODUCTS_TAB_LOCATOR));

		Assert.assertEquals(true, homeTab.isDisplayed());
		Assert.assertEquals(true, newsTab.isDisplayed());
		Assert.assertEquals(true, aboutTab.isDisplayed());
		Assert.assertEquals(true, productsTab.isDisplayed());
	}

//	@Test(priority = 3)
	 @Test(enabled = false)
	public void NikonHomeGlobalLocationTest() {
		WebElement locationTab = driver.findElement(By
				.xpath(LOCATION_TAB_LOCATOR));
		WebElement americaLink = driver.findElement(By
				.xpath(AMERICA_LINK_LOCATOR));
		WebElement europeLink = driver.findElement(By
				.xpath(EUROPE_LINK_LOCATOR));
		WebElement asiaLink = driver.findElement(By.xpath(ASIA_LINK_LOCATOR));
		WebElement oceaniaLink = driver.findElement(By
				.xpath(OCEANIA_LINK_LOCATOR));
		WebElement middleEastLink = driver.findElement(By
				.xpath(MIDDLEEAST_LINK_LOCATOR));
		WebElement africaLink = driver.findElement(By
				.xpath(AFRICA_LINK_LOCATOR));
		WebElement movieAd = driver.findElement(By.xpath(MOVIE_AD_LOCATOR));

		Assert.assertEquals(true, locationTab.isDisplayed());
		Assert.assertEquals(true, americaLink.isDisplayed());
		Assert.assertEquals(true, europeLink.isDisplayed());
		Assert.assertEquals(true, asiaLink.isDisplayed());
		Assert.assertEquals(true, oceaniaLink.isDisplayed());
		Assert.assertEquals(true, middleEastLink.isDisplayed());
		Assert.assertEquals(true, africaLink.isDisplayed());
		Assert.assertEquals(true, movieAd.isDisplayed());
	}

	@Test(priority = 4)
	// @Test(enabled = false)
	public void NikonHomeNewsTabTest() throws Exception {
		WebElement newsLink = driver.findElement(By.xpath(NEWS_LINK_LOCATOR));
		Assert.assertEquals(true, newsLink.isDisplayed());
		System.out.println("After link locator");
		WebElement newsDate4Link = driver.findElement(By
				.xpath(NEWS_DATE4_LOCATOR));
		Assert.assertEquals(true, newsDate4Link.isDisplayed());
		System.out.println("After date4 locator");
		driver.findElement(By.xpath(NEWS_DATE4_PDF_LOCATOR)).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// test with sleep 10 millis
		System.out.println("After timeout");
		
		// SWITCH to a new window
		String windowHandleBefore = driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
			if (windowHandle.endsWith(".pdf")) {
				WebDriver driver1 = driver.switchTo().window(windowHandle);
				String pdfURL = driver1.getCurrentUrl();
				System.out.println("pdf URL: " +pdfURL);
				Assert.assertTrue(pdfURL.contains(".pdf"));
				driver1.close();
			}
		}
		driver.switchTo().window(windowHandleBefore);
	}

	// have to group priority 5 & 6 tests
//	@Test(priority = 5)
	 @Test(enabled = false)
	public void NikonHomeSearchTest() {
		WebElement searchLabel = driver.findElement(By.xpath(SEARCH_LOCATOR));
		Assert.assertEquals(true, searchLabel.isDisplayed());

		WebElement searchBox = driver.findElement(By.id(SEARCH_BOX_LOCATOR));
		Assert.assertEquals(true, searchBox.isDisplayed());

		WebElement searchBtn = driver.findElement(By.id(SEARCH_BTN_LOCATOR));
		Assert.assertEquals(true, searchBtn.isDisplayed());

		WebElement searchGlobalLabel = driver.findElement(By
				.linkText(SEARCH_GLOBAL_LOCATOR));
		Assert.assertEquals(true, searchGlobalLabel.isDisplayed());
	}

	// this test depends on NikonHomeSearchTest - task1
	// how to use condition false in assertEquals
//	@Test(priority = 6)
	 @Test(enabled = false)
	public void NikonHomeSearchBlankTest() {
		driver.findElement(By.id(SEARCH_BTN_LOCATOR)).click();
		WebElement searchResult = driver.findElement(By
				.xpath(SEARCH_RESULT_LOCATOR));
		Assert.assertEquals(true, searchResult.isDisplayed());
	}

	// this test depends on NikonHomeSearchTest
//	@Test(priority = 7)
	 @Test(enabled = false)
	public void NikonHomeSearchValidTest() throws Exception {
		WebElement searchBox = driver.findElement(By.id(SEARCH_BOX_LOCATOR));
		searchBox.sendKeys("nikon");
		Thread.sleep(SLEEP_TIME_3000);

		driver.findElement(By.id(SEARCH_BTN_LOCATOR)).click();
		WebElement resultPage = driver.findElement(By
				.xpath(RESULT_PAGE_LOCATOR));
		Assert.assertEquals(true, resultPage.isDisplayed());
	}

//	@Test(priority = 8)
	 @Test(enabled = false)
	public void NikonHomeSearchInValidTest1() throws Exception {
		WebElement searchBox = driver.findElement(By.id(SEARCH_BOX_LOCATOR));
		searchBox.sendKeys("nkn");
		Thread.sleep(SLEEP_TIME_3000);

		driver.findElement(By.id(SEARCH_BTN_LOCATOR)).click();
		Thread.sleep(SLEEP_TIME_1000);

		WebElement noResultPage = driver.findElement(By
				.xpath(NO_RESULT_PAGE_LOCATOR));
		Assert.assertEquals(true, noResultPage.isDisplayed());
		Thread.sleep(SLEEP_TIME_3000);

		String searchNoMatch = driver.getPageSource();
		Assert.assertTrue(searchNoMatch
				.contains("did not match any documents."));

	}

//	@Test(priority = 9)
	 @Test(enabled = false)
	public void NikonHomeSearchInValidTest2() throws Exception {
		WebElement searchBox = driver.findElement(By.id(SEARCH_BOX_LOCATOR));
		searchBox.sendKeys("@###");
		Thread.sleep(SLEEP_TIME_3000);

		driver.findElement(By.id(SEARCH_BTN_LOCATOR)).click();
		WebElement noResultPage = driver.findElement(By
				.xpath(NO_RESULT_PAGE_LOCATOR));
		Assert.assertEquals(true, noResultPage.isDisplayed());

		String searchNoMatch = driver.getPageSource();
		Assert.assertTrue(searchNoMatch
				.contains("did not match any documents."));
	}

//	@Test(priority = 10)
	 @Test(enabled = false)
	public void NikonHomeGlobalNetworkTest() throws Exception {
		WebElement globalNetworkLink = driver.findElement(By
				.xpath(GLOBAL_NETWORK_LINK_LOCATOR));
		globalNetworkLink.click();
		Thread.sleep(3000);

		WebElement globalNetworkLabel = driver.findElement(By
				.xpath(GLOBAL_NETWORK_LABEL_LOCATOR));
		WebElement globalCountryTab = driver.findElement(By
				.xpath(GLOBAL_COUNTRY_TAB_LOCATOR));
		WebElement globalNetwork = driver.findElement(By
				.xpath(GLOBAL_NETWORK_LOCATOR));
		WebElement imageProdLabel = driver.findElement(By
				.xpath(IMAGE_PROD_LABEL_LOCATOR));
		WebElement imageProd = driver.findElement(By.xpath(IMAGE_PROD_LOCATOR));
		WebElement imageProdNotFound = driver.findElement(By
				.xpath(IMAGE_PROD_NOT_FOUND_LOCATOR));
		WebElement backToTop1 = driver.findElement(By
				.xpath(IMAGE_PROD_BACK_LOCATOR));
		WebElement sportOptics = driver.findElement(By
				.xpath(SPORT_OPTICS_LOCATOR));
		WebElement sportOptics2 = driver.findElement(By
				.xpath(SPORT_OPTICS2_LOCATOR));
		WebElement sportOpticsNotFound = driver.findElement(By
				.xpath(SPORT_OPTICS_NOT_FOUND_LOCATOR));
		WebElement backToTop2 = driver.findElement(By
				.xpath(SPORT_OPTICS_BACK_LOCATOR));

		Assert.assertEquals(true, globalNetworkLabel.isDisplayed());
		Assert.assertEquals(true, globalCountryTab.isDisplayed());
		Assert.assertEquals(true, globalNetwork.isDisplayed());
		Assert.assertEquals(true, imageProdLabel.isDisplayed());
		Assert.assertEquals(true, imageProd.isDisplayed());
		Assert.assertEquals(true, imageProdNotFound.isDisplayed());
		Assert.assertEquals(true, backToTop1.isDisplayed());
		Assert.assertEquals(true, sportOptics.isDisplayed());
		Assert.assertEquals(true, sportOptics2.isDisplayed());
		Assert.assertEquals(true, sportOpticsNotFound.isDisplayed());
		Assert.assertEquals(true, backToTop2.isDisplayed());
	}
}
