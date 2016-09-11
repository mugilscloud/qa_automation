package com.apex.ecommerce.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonLoginTestNG {
	WebDriver driver = null;
	@BeforeTest
	public void setUpTest() {
		driver = new FirefoxDriver();
		driver.get("http://www.amazon.com");
	}
	
	@Test
	public void loginSuccess() throws Exception {
		WebElement email = driver.findElement(By.id("ap_email"));
		email.sendKeys("himani.g09@gmail.com");
		Thread.currentThread().sleep(10000);
		
		WebElement pwd = driver.findElement(By.id("ap_password"));
		pwd.sendKeys("himani123");
		Thread.currentThread().sleep(10000);
		
		
		WebElement nextBtn2 = driver.findElement(By.id("signInSubmit"));
		nextBtn2.click();
		Thread.currentThread().sleep(30000);
//		
//		String signIn = driver.getPageSource();
//		Assert.assertEquals(signIn.contains("Hello, Himani"), true);
	}
	
	@AfterTest
	public void cleanUp() {
		driver.close();
	}
		
}
