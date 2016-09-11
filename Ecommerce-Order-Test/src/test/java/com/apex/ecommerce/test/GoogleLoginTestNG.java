package com.apex.ecommerce.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleLoginTestNG {
	WebDriver driver = null;
	@BeforeTest
	public void setUpTest() {
		driver = new FirefoxDriver();
		driver.get("http://www.gmail.com");
	}
	
	@Test
	public void loginSuccess() throws Exception {
		WebElement email = driver.findElement(By.id("Email"));
		email.sendKeys("mugilthen@gmail.com");
		
		WebElement nextBtn1 = driver.findElement(By.id("next"));
		nextBtn1.click();
		Thread.currentThread().sleep(10000);
		
//		WebElement passwd = driver.findElement(By.id("Passwd"));
//		WebElement passwd = driver.findElement(By.cssSelector=input[name="Passwd"]);
//		passwd.sendKeys("mugil123market");
		Thread.currentThread().sleep(10000);
		
		WebElement nextBtn2 = driver.findElement(By.id("signIn"));
		nextBtn2.click();
		Thread.currentThread().sleep(10000);
		System.out.println("hi");
		
		String title = driver.getTitle();
		Assert.assertEquals(title.contains("Inbox"), true);
	}
	
	@AfterTest
	public void cleanUp() {
		driver.close();
	}
		
}
