package com.apex.ecommerce.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.apex.ecommerce.constants.EcommerceRegistrationConstants;
import com.apex.ecommerce.page.RegistrationPage;

//public class RegistrationPagePOM extends BaseEcommerceTest  {
public class RegistrationPagePOM extends BaseEcommerceTest  {
	@Test(priority = 1)
	public void registrationNewValidEmail() {
		// create the page
		RegistrationPage registrationPage = new RegistrationPage(driver);
		// set the data
		registrationPage.setRegistrationData("Testfname",
				"Testlname", "12", "10", "1980", "tst6fti@gmail.com",
				"212", "Street nane", "Fremont", "CA", "USA", "12312",
				"1231232", "123167562", "ishfijsdf", "ishfijsdf");
		// perform actions
		registrationPage.clickOnSubmit();
		// validate - here a new Page Object is created
		registrationPage.checkSuccessMessage();
	}
	
	@Test(enabled=false)
	public void registrationInvalidTest() {
		RegistrationPage registrationPage = new RegistrationPage(driver);
		registrationPage.setRegistrationData(" ",
				" ", " ", " ", " ", "thgf@gmail.com",
				" ", " ", " ", " ", "UK", " ",
				" ", " ", " ", " ");
		registrationPage.clickOnSubmit();
		registrationPage.checkFailureMessage();
	}
	
	@Test(priority = 3)
	public void registrationAlreadyExistsTest() {
		RegistrationPage registrationPage = new RegistrationPage(driver);
		registrationPage.setRegistrationData("Testfname",
				"Testlname", "12", "10", "1980", "tst6fti@gmail.com",
				"212", "Street nane", "Fremont", "CA", "USA", "12312",
				"1231232", "123167562", "ishfijsdf", "ishfijsdf");
		registrationPage.clickOnSubmit();
		registrationPage.checkAlreadyMessage();
	}
}
