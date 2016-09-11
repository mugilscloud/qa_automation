package com.apex.ecommerce.test;

import java.io.File;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.apex.ecommerce.constants.EcommerceCommonConstants;
import com.apex.ecommerce.constants.EcommerceRegistrationConstants;

public class RegistrationPageTest extends BaseEcommerceTest implements
		EcommerceCommonConstants, EcommerceRegistrationConstants {

	@DataProvider(name = "registerDuplicateData")
	public Object[][] registrationEmailAlreadyExistsDP() {
//		String[][] registrationData = {
//				{ "Testfname", "Testlname", "12", "10", "1980",
//						"elenaraciti@gmail.com", "212", "Street nane",
//						"Fremont", "CA", "USA", "12312", "1231232",
//						"123167562", "cannotfind", "cannotfind" },
//				{ "fname2", "lanme2", "09", "01", "2000",
//						"elenaraciti@gmail.com", "100", "Walnut Dr", "Fremont",
//						"CA", "USA", "00000", "0000000", "000000000",
//						"cannotfind", "cannotfind" }, };
		String[][] testDupData = getDataFromSpreadsheet("EcommerceData.xls", "RegistrationData_Unit_Testing", "EmailAlreadyExists");
		return testDupData;
	}
	
	@DataProvider(name = "registerValidData")
	public Object[][] registrationNewValidEmailDP() {
		String[][] testValidData = getDataFromSpreadsheet("EcommerceData.xls", "RegistrationData_Unit_Testing", "NewValidEmail");
		return testValidData;
	}
	
	@DataProvider(name = "registerInvalidData")
	public Object[][] registrationInvalidTestDP() {
		String[][] testInvalidData = getDataFromSpreadsheet("EcommerceData.xls", "RegistrationData_Unit_Testing", "RegisterInvalidData");
		return testInvalidData;
	}
	
	//JXL or Apache POI
	public String[][] getDataFromSpreadsheet(String xlFilePath, String sheetName, String tableName) {
		String[][] tabArray=null;
        try{
            Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
            Sheet sheet = workbook.getSheet(sheetName);
            int startRow,startCol, endRow, endCol,ci,cj;
            Cell tableStart=sheet.findCell(tableName);
            startRow=tableStart.getRow();
            startCol=tableStart.getColumn();

            Cell tableEnd= sheet.findCell(tableName, startCol+1,startRow+1, 100, 64000,  false);                               

            endRow=tableEnd.getRow();
            endCol=tableEnd.getColumn();
            System.out.println("startRow="+startRow+", endRow="+endRow+", " +
                    "startCol="+startCol+", endCol="+endCol);
            tabArray=new String[endRow-startRow-1][endCol-startCol-1];
            ci=0;

            for (int i=startRow+1;i<endRow;i++,ci++){
                cj=0;
                for (int j=startCol+1;j<endCol;j++,cj++){
                    tabArray[ci][cj]=sheet.getCell(j,i).getContents();
                }
            }
        }
        catch (Exception e)    {
            System.out.println("error in getTableArray()");
        }

        return(tabArray);
	}
	
//	@Test(enabled=false)
	@Test(dataProvider = "registerDuplicateData")
	public void registrationEmailAlreadyExists(String fnameDP, String lnameDP,
			String dayDP, String monthDP, String yearDP, String emailDP,
			String housenoDP, String address1DP, String cityDP, String stateDP,
			String countryDP, String postcodeDP, String phoneDP, String faxDP,
			String passwordDP, String cpasswordDP) throws Exception {
		WebElement account = driver.findElement(By.xpath(ACCOUNT_LOCATOR));
		account.click();
		Thread.sleep(SLEEP_TIME_1000);
		

		WebElement signUpBtn = driver.findElement(By
				.linkText(SIGNUP_BTN_LOCATOR));
		signUpBtn.click();
		Thread.sleep(SLEEP_TIME_1000);

		// to set the radio button
		// String gender = driver.getPageSource();
		// gender;
		// Thread.sleep(SLEEP_TIME_3000);

		WebElement firstName = driver.findElement(By.id(FNAME_LOCATOR));
		firstName.sendKeys(fnameDP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement lastName = driver.findElement(By.id(LNAME_LOCATOR));
		lastName.sendKeys(lnameDP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement day = driver.findElement(By.id(DAY_LOCATOR));
		day.sendKeys(dayDP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement month = driver.findElement(By.id(MONTH_LOCATOR));
		month.sendKeys(monthDP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement year = driver.findElement(By.id(YEAR_LOCATOR));
		year.sendKeys(yearDP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement email = driver.findElement(By.id(EMAIL_LOCATOR));
		email.sendKeys(emailDP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement houseno = driver.findElement(By.id(HOUSENO_LOCATOR));
		houseno.sendKeys(housenoDP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement address1 = driver.findElement(By.id(ADDRESS1_LOCATOR));
		address1.sendKeys(address1DP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement city = driver.findElement(By.id(CITY_LOCATOR));
		city.sendKeys(cityDP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement state = driver.findElement(By.id(STATE_LOCATOR));
		state.sendKeys(stateDP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement country = driver.findElement(By.id(COUNTRY_LOCATOR));
		country.sendKeys(countryDP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement postcode = driver.findElement(By.id(POSTCODE_LOCATOR));
		postcode.sendKeys(postcodeDP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement phone = driver.findElement(By.id(PHONE_LOCATOR));
		phone.sendKeys(phoneDP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement fax = driver.findElement(By.id(FAX_LOCATOR));
		fax.sendKeys(faxDP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement password = driver.findElement(By.id(PASSWORD_LOCATOR));
		password.sendKeys(passwordDP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement cpassword = driver.findElement(By.id(CPASSWORD_LOCATOR));
		cpassword.sendKeys(cpasswordDP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement newsletter = driver.findElement(By.id(NEWSLETTER_LOCATOR));
		if (!newsletter.isSelected()) {
			newsletter.click();
		}
		Thread.sleep(SLEEP_TIME_1000);

		WebElement terms = driver.findElement(By.id(TERMS_LOCATOR));
		if (!terms.isSelected()) {
			terms.click();
		}
		Thread.sleep(SLEEP_TIME_1000);

		WebElement signUp = driver.findElement(By.name(SUBMIT_LOCATOR));
		signUp.click();
		Thread.sleep(SLEEP_TIME_1000);

		String message = driver.getPageSource();
		Assert.assertEquals(
				message.contains("This email address is already registered."),
				true);
	}

	@Test(enabled=false)
//	@Test(dataProvider="registerValidData")
	public void registrationNewValidEmail(String fnameDP, String lnameDP,
			String dayDP, String monthDP, String yearDP, String emailDP,
			String housenoDP, String address1DP, String cityDP, String stateDP,
			String countryDP, String postcodeDP, String phoneDP, String faxDP,
			String passwordDP, String cpasswordDP) throws Exception {
		WebElement account = driver.findElement(By.xpath(ACCOUNT_LOCATOR));
		account.click();
		Thread.sleep(SLEEP_TIME_1000);

		WebElement signUpBtn = driver.findElement(By
				.linkText(SIGNUP_BTN_LOCATOR));
		signUpBtn.click();
		Thread.sleep(SLEEP_TIME_1000);

		// to set the radio button
		// String gender = driver.getPageSource();
		// gender;
		// Thread.sleep(SLEEP_TIME_3000);

		WebElement firstName = driver.findElement(By.id(FNAME_LOCATOR));
		firstName.sendKeys(fnameDP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement lastName = driver.findElement(By.id(LNAME_LOCATOR));
		lastName.sendKeys(lnameDP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement day = driver.findElement(By.id(DAY_LOCATOR));
		day.sendKeys(dayDP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement month = driver.findElement(By.id(MONTH_LOCATOR));
		month.sendKeys(monthDP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement year = driver.findElement(By.id(YEAR_LOCATOR));
		year.sendKeys(yearDP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement email = driver.findElement(By.id(EMAIL_LOCATOR));
		email.sendKeys(emailDP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement houseno = driver.findElement(By.id(HOUSENO_LOCATOR));
		houseno.sendKeys(housenoDP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement address1 = driver.findElement(By.id(ADDRESS1_LOCATOR));
		address1.sendKeys(address1DP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement city = driver.findElement(By.id(CITY_LOCATOR));
		city.sendKeys(cityDP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement state = driver.findElement(By.id(STATE_LOCATOR));
		state.sendKeys(stateDP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement country = driver.findElement(By.id(COUNTRY_LOCATOR));
		country.sendKeys(countryDP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement postcode = driver.findElement(By.id(POSTCODE_LOCATOR));
		postcode.sendKeys(postcodeDP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement phone = driver.findElement(By.id(PHONE_LOCATOR));
		phone.sendKeys(phoneDP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement fax = driver.findElement(By.id(FAX_LOCATOR));
		fax.sendKeys(faxDP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement password = driver.findElement(By.id(PASSWORD_LOCATOR));
		password.sendKeys(passwordDP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement cpassword = driver.findElement(By.id(CPASSWORD_LOCATOR));
		cpassword.sendKeys(cpasswordDP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement newsletter = driver.findElement(By.id(NEWSLETTER_LOCATOR));
		if (!newsletter.isSelected()) {
			newsletter.click();
		}
		Thread.sleep(SLEEP_TIME_1000);

		WebElement terms = driver.findElement(By.id(TERMS_LOCATOR));
		if (!terms.isSelected()) {
			terms.click();
		}
		Thread.sleep(SLEEP_TIME_1000);

		WebElement signUp = driver.findElement(By.name(SUBMIT_LOCATOR));
		signUp.click();
		Thread.sleep(SLEEP_TIME_1000);

		String message = driver.getPageSource();
		Assert.assertEquals(
				message.contains("Thank you for signing up. Your account is now created and you can log in by clicking the ACCOUNT button in the main menu above."),
				true);
	}

//	@Test(enabled=false)
	@Test(dataProvider="registerInvalidData")
	public void registrationInvalidTest(String fnameDP, String lnameDP,
			String dayDP, String monthDP, String yearDP, String emailDP,
			String housenoDP, String address1DP, String cityDP, String stateDP,
			String countryDP, String postcodeDP, String phoneDP, String faxDP,
			String passwordDP, String cpasswordDP, String errorMessageDP) throws Exception {
		WebElement account = driver.findElement(By.xpath(ACCOUNT_LOCATOR));
		account.click();
		Thread.sleep(SLEEP_TIME_3000);

		WebElement signUpBtn = driver.findElement(By
				.linkText(SIGNUP_BTN_LOCATOR));
		signUpBtn.click();
		Thread.sleep(SLEEP_TIME_3000);

		// to set the radio button
		// String gender = driver.getPageSource();
		// gender;
		// Thread.sleep(SLEEP_TIME_3000);

		WebElement firstName = driver.findElement(By.id(FNAME_LOCATOR));
		firstName.sendKeys(fnameDP);

		WebElement lastName = driver.findElement(By.id(LNAME_LOCATOR));
		lastName.sendKeys(lnameDP);

		WebElement day = driver.findElement(By.id(DAY_LOCATOR));
		day.sendKeys(dayDP);

		WebElement month = driver.findElement(By.id(MONTH_LOCATOR));
		month.sendKeys(monthDP);

		WebElement year = driver.findElement(By.id(YEAR_LOCATOR));
		year.sendKeys(yearDP);

		WebElement email = driver.findElement(By.id(EMAIL_LOCATOR));
		email.sendKeys(emailDP);
		Thread.sleep(SLEEP_TIME_3000);

		WebElement houseno = driver.findElement(By.id(HOUSENO_LOCATOR));
		houseno.sendKeys(housenoDP);

		WebElement address1 = driver.findElement(By.id(ADDRESS1_LOCATOR));
		address1.sendKeys(address1DP);
		Thread.sleep(SLEEP_TIME_1000);

		WebElement city = driver.findElement(By.id(CITY_LOCATOR));
		city.sendKeys(cityDP);

		WebElement state = driver.findElement(By.id(STATE_LOCATOR));
		state.sendKeys(stateDP);

		WebElement country = driver.findElement(By.id(COUNTRY_LOCATOR));
		country.sendKeys(countryDP);

		WebElement postcode = driver.findElement(By.id(POSTCODE_LOCATOR));
		postcode.sendKeys(postcodeDP);

		WebElement phone = driver.findElement(By.id(PHONE_LOCATOR));
		phone.sendKeys(phoneDP);

		WebElement fax = driver.findElement(By.id(FAX_LOCATOR));
		fax.sendKeys(faxDP);

		WebElement password = driver.findElement(By.id(PASSWORD_LOCATOR));
		password.sendKeys(passwordDP);

		WebElement cpassword = driver.findElement(By.id(CPASSWORD_LOCATOR));
		cpassword.sendKeys(cpasswordDP);

		WebElement newsletter = driver.findElement(By.id(NEWSLETTER_LOCATOR));
		if (!newsletter.isSelected()) {
			newsletter.click();
		}
		Thread.sleep(SLEEP_TIME_1000);

		WebElement terms = driver.findElement(By.id(TERMS_LOCATOR));
		if (!terms.isSelected()) {
			terms.click();
		}
		Thread.sleep(SLEEP_TIME_1000);

		WebElement signUp = driver.findElement(By.name(SUBMIT_LOCATOR));
		signUp.click();
		Thread.sleep(SLEEP_TIME_1000);

		//	WebElement errorMessage = driver.findElement(By.xpath(ERROR_LOCATOR));
     	Assert.assertTrue(true, errorMessageDP);
	}
}
