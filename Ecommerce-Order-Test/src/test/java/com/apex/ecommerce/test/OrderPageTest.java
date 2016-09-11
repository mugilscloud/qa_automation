package com.apex.ecommerce.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrderPageTest extends BaseEcommerceTest {

	@Test(dependsOnMethods={"oneMoreTest"})
	public void OrderPageSuccessTest() throws Exception {
		WebElement myCart = driver.findElement(By.linkText("MY CART"));
		myCart.click();
		Thread.currentThread().sleep(10000);
		
		WebElement checkout = driver.findElement(By.linkText("Checkout"));
		if (checkout.isDisplayed()) {
			checkout.click();
			Thread.currentThread().sleep(30000);
		}
	}
	
	@Test
	public void oneMoreTest() {
		System.out.println("method without @Test annotation");
	}

	@AfterTest
	public void cleanUp() {
		driver.close();
	}
}
