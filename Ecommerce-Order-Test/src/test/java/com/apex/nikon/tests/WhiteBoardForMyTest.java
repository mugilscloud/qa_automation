package com.apex.nikon.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

public class WhiteBoardForMyTest extends BaseNikonTest {
	@Test
	public void simpleTests() throws Exception {

		/* how to perform double click
		*Actions act = new Actions(driver);
		*act.doubleClick();

		* to perform alert operation
		*Alert alert = driver.switchTo().alert();
		*alert.accept();
        */
		//To set up new Profile
//		FirefoxProfile profile = new FirefoxProfile();
//		profile.setPreference("intl.accept_languages", "jp");
		WebDriver driver = new FirefoxDriver();
//		driver.get("http://www.google.com");
		driver.navigate().to("http://www.facebook.com");
		Thread.sleep(2000);
//		
//		WebElement button = driver.findElement(By.xpath(".//*[@id='gb_70']"));
//		button.sendKeys("what should");
//		Thread.sleep(2000);
//		List<WebElement> list1 = driver.findElements(By.xpath(".//*[@id='sbse0']/div[2]"));
//		list1.get(0).click();
//		driver.findElement(By.xpath(".//*[@id='sblsbb']")).click();
//		
//		driver.close();
		// 1.example for implicit wait - define TimeUnit
//		driver.manage().timeouts()
//				.implicitlyWait(SLEEP_TIME_1000, TimeUnit.SECONDS);
//		// 1.example for explicit wait
//		WebElement myDynamicElement = new WebDriverWait(driver, 10)
//				.until(ExpectedConditions.presenceOfElementLocated(By
//						.id("myElement")));
//		
//		List<WebElement> option = driver.findElements(By.xpath(NIKON_HOME_PAGE));
		
		driver.close();
		
	}
}
