package com.apex.ecommerce.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.apex.ecommerce.constants.EcommerceCommonConstants;

public class BaseEcommerceTest implements EcommerceCommonConstants{

	protected WebDriver driver = null;

	public BaseEcommerceTest() {
		super();
	}

	@BeforeTest
	public void setUpTest() {
		driver = new FirefoxDriver(); 
		driver.get("http://saipratap.net/ecommerce/");
	}

	@AfterTest
	public void cleanUp() {
		driver.close();
	}

}