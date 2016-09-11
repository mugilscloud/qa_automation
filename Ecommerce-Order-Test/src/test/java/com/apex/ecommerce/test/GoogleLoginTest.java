package com.apex.ecommerce.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleLoginTest {
	public static void main(String args[]) throws Exception {
		WebDriver driver = new FirefoxDriver();
		//open the browser
		driver.get("http://www.gmail.com");
		
		//enter the email url
		WebElement email = driver.findElement(By.id("Email"));
		email.sendKeys("mugilthen@gmail.com");
		
		WebElement nextBtn1 = driver.findElement(By.id("next"));
		nextBtn1.click();
		
		WebElement passwd = driver.findElement(By.id("Passwd"));
		passwd.sendKeys("mugil123market");
		
		WebElement nextBtn2 = driver.findElement(By.id("signIn"));
		nextBtn2.click();
		//set the user id and pwd
		
		//click on the button
		//verify if the inbox is opened
		String title = driver.getTitle();
		if (title.contains("Inbox")) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}
		//close the browser
		driver.close();
	}
}
