package com.apex.ecommerce.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.apex.ecommerce.constants.CommonConstants;
import com.apex.ecommerce.constants.EcommerceCommonConstants;
import com.apex.ecommerce.constants.EcommerceLoginConstants;

public class EcommerceLoginPage extends BaseEcommerceTest implements EcommerceCommonConstants, EcommerceLoginConstants {
	
	@Test
	public void loginTestSuccess() throws Exception {
		WebElement account = driver.findElement(By.linkText(ACCOUNT_LOCATOR));
		account.click();
		Thread.currentThread().sleep(SLEEP_TIME_1000);
		
		WebElement email = driver.findElement(By.id(EMAIL_ID_LOCATOR));
		email.sendKeys(TEST_EMAIL_ID);
		Thread.currentThread().sleep(SLEEP_TIME_3000);
		
		WebElement password = driver.findElement(By.id(PASSWORD_LOCATOR));
		password.sendKeys(TEST_PASSWORD);
		Thread.currentThread().sleep(SLEEP_TIME_3000);
		
		WebElement loginbtn = driver.findElement(By.linkText(LOGIN_BTN_LOCATOR));
		loginbtn.click();
		Thread.currentThread().sleep(SLEEP_TIME_1000);
		
		String contents = driver.getPageSource();
		Assert.assertEquals(contents.contains("You have Logged In successfully."), true);
	}
	
	@Test
	public void forgotPassword() throws Exception {
		WebElement account = driver.findElement(By.linkText(ACCOUNT_LOCATOR));
		account.click();
		Thread.currentThread().sleep(SLEEP_TIME_1000);
		
		WebElement lostPassword = driver.findElement(By.linkText(LOST_PASSWORD_LOCATOR));
		lostPassword.click();
		Thread.currentThread().sleep(SLEEP_TIME_1000);
		
		String lostPasswordMsg = driver.getPageSource();
		Assert.assertEquals(lostPasswordMsg.contains(LOST_PASSWORD_LOCATOR), true);
	}
	
	@Test
	public void blankLogin() throws Exception {
		WebElement account = driver.findElement(By.linkText(ACCOUNT_LOCATOR));
		account.click();
		Thread.currentThread().sleep(SLEEP_TIME_1000);
		
		WebElement email = driver.findElement(By.id(EMAIL_ID_LOCATOR));
		email.sendKeys("    ");
		Thread.currentThread().sleep(SLEEP_TIME_3000);
		
		WebElement password = driver.findElement(By.id(PASSWORD_LOCATOR));
		password.sendKeys("    ");
		Thread.currentThread().sleep(SLEEP_TIME_3000);
		
		WebElement loginbtn = driver.findElement(By.linkText(LOGIN_BTN_LOCATOR));
		loginbtn.click();
		Thread.currentThread().sleep(SLEEP_TIME_1000);
		
		String message = driver.getPageSource();
		Assert.assertEquals(message.contains("Invalid Username / Password!"), true);
	}
}
