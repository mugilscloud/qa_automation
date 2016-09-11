package com.apex.ecommerce.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SandboxTestDemo {
	WebDriver driver = null;

	@BeforeTest
	public void setUp() {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.salesforce.com/form/signup/freetrial-force-lb.jsp");
	}

	@Test
	public void testLogin() throws InterruptedException {

		WebElement firstName = driver.findElement(By.id("UserFirstName"));
		firstName.sendKeys("TestFirstName");
//		WebElement lastName = driver.findElement(By.id("UserLastName"));
//		lastName.sendKeys("TestLastName");
//		WebElement email = driver.findElement(By.id("UserEmail"));
//		email.sendKeys("testemail@gmail.com");
//		WebElement userPhone = driver.findElement(By.id("UserPhone"));
//		userPhone.sendKeys("2222222222");
//		Select userTitle = new Select(driver.findElement(By.id("userTitle")));
//		userTitle.selectByVisibleText("Developer");
//		WebElement companyName = driver.findElement(By.id("CompanyName"));
//		companyName.sendKeys("My sample company name");
//		Select empNo = new Select(driver.findElement(By.id("CompanyEmployees")));
//		empNo.selectByVisibleText("1 - 5 employees");
//
//		Select country = new Select(driver.findElement(By.id("CompanyCountry")));
//		country.selectByVisibleText("United States");
//		Select language = new Select(driver.findElement(By
//				.id("CompanyLanguage")));
//		language.selectByVisibleText("English");
//
//		WebElement agreementCheckbox = driver.findElement(By
//				.id("SubscriptionAgreement"));
//		if (!agreementCheckbox.isSelected()) {
//			agreementCheckbox.click();
//		}
//
//		// for the CAPTCHA image, I will create all script. introduce wait time
//		// before and after CAPTCHA
//		// then enter the text and click on the "sign me up" button manually
//
//		Thread.sleep(5000);

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
