package com.apex.nikon.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.apex.nikon.nikonconstants.NikonCommonConstants;

public class BaseNikonTest implements NikonCommonConstants {

	WebDriver driver = null;

	public BaseNikonTest() {
		super();
	}

	@BeforeTest
	public void setUpDriver() {
		driver = new FirefoxDriver();
		driver.get(NIKON_HOME_PAGE);
	}

	@AfterTest
	public void cleanUp() {
	driver.close();
	}
}