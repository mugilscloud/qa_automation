package com.apex.ecommerce.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.apex.ecommerce.constants.EcommerceRegistrationConstants;

/* Code to identify the elements, set the data and perform actions 
 */

public class RegistrationPage implements EcommerceRegistrationConstants {
	

//	public RegistrationPage(WebDriver driver, WebElement account,
//			WebElement signUpBtn, WebElement firstName, WebElement lastName,
//			WebElement day, WebElement month, WebElement year,
//			WebElement email, WebElement houseno, WebElement address1,
//			WebElement city, WebElement state, WebElement country,
//			WebElement postcode, WebElement phone, WebElement fax,
//			WebElement password, WebElement cpassword, WebElement newsletter,
//			WebElement terms, WebElement signUp) {
//		super();
//		this.driver = driver;
//		this.account = account;
//		this.signUpBtn = signUpBtn;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.day = day;
//		this.month = month;
//		this.year = year;
//		this.email = email;
//		this.houseno = houseno;
//		this.address1 = address1;
//		this.city = city;
//		this.state = state;
//		this.country = country;
//		this.postcode = postcode;
//		this.phone = phone;
//		this.fax = fax;
//		this.password = password;
//		this.cpassword = cpassword;
//		this.newsletter = newsletter;
//		this.terms = terms;
//		this.signUp = signUp;
//	}

	private WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, xpath = ACCOUNT_LOCATOR)
	private WebElement account;

	@FindBy(how = How.LINK_TEXT, linkText = SIGNUP_BTN_LOCATOR)
	private WebElement signUpBtn;

	@FindBy(how = How.ID, id = FNAME_LOCATOR)
	private WebElement firstName;

	@FindBy(how = How.ID, id = LNAME_LOCATOR)
	private WebElement lastName;

	@FindBy(how = How.ID, id = DAY_LOCATOR)
	private WebElement day;

	@FindBy(how = How.ID, id = MONTH_LOCATOR)
	private WebElement month;

	@FindBy(how = How.ID, id = YEAR_LOCATOR)
	private WebElement year;

	@FindBy(how = How.ID, id = EMAIL_LOCATOR)
	private WebElement email;

	@FindBy(how = How.ID, id = HOUSENO_LOCATOR)
	private WebElement houseno;

	@FindBy(how = How.ID, id = ADDRESS1_LOCATOR)
	private WebElement address1;

	@FindBy(how = How.ID, id = CITY_LOCATOR)
	private WebElement city;

	@FindBy(how = How.ID, id = STATE_LOCATOR)
	private WebElement state;

	@FindBy(how = How.ID, id = COUNTRY_LOCATOR)
	private WebElement country;

	@FindBy(how = How.ID, id = POSTCODE_LOCATOR)
	private WebElement postcode;

	@FindBy(how = How.ID, id = PHONE_LOCATOR)
	private WebElement phone;

	@FindBy(how = How.ID, id = FAX_LOCATOR)
	private WebElement fax;

	@FindBy(how = How.ID, id = PASSWORD_LOCATOR)
	private WebElement password;

	@FindBy(how = How.ID, id = CPASSWORD_LOCATOR)
	private WebElement cpassword;

	@FindBy(how = How.ID, id = NEWSLETTER_LOCATOR)
	private WebElement newsletter;

	@FindBy(how = How.ID, id = TERMS_LOCATOR)
	private WebElement terms;

	@FindBy(how = How.NAME, name = SUBMIT_LOCATOR)
	private WebElement signUp;
	

	@FindBy(how = How.XPATH, xpath = "html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/div")
	private WebElement successMsg;
	
	@FindBy(how = How.XPATH, xpath = "html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td/span")
	private WebElement failureMsg;
	
	@FindBy(how = How.XPATH, xpath = "html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/form/table/tbody/tr[2]/td/span")
	private WebElement alreadyMsg;
	
	public void setRegistrationData(String fnameDP, String lnameDP,
			String dayDP, String monthDP, String yearDP, String emailDP,
			String housenoDP, String address1DP, String cityDP, String stateDP,
			String countryDP, String postcodeDP, String phoneDP, String faxDP,
			String passwordDP, String cpasswordDP) {
		account.click();
		signUpBtn.click();
		firstName.sendKeys(fnameDP);
		lastName.sendKeys(lnameDP);
		day.sendKeys(dayDP);
		month.sendKeys(monthDP);
		year.sendKeys(yearDP);
		email.sendKeys(emailDP);
		houseno.sendKeys(housenoDP);
		address1.sendKeys(address1DP);
		city.sendKeys(cityDP);
		state.sendKeys(stateDP);
		country.sendKeys(countryDP);
		postcode.sendKeys(postcodeDP);
		phone.sendKeys(phoneDP);
		fax.sendKeys(faxDP);
		password.sendKeys(passwordDP);
		cpassword.sendKeys(cpasswordDP);
		
		if (!newsletter.isSelected()) {
			newsletter.click();
		}
		if (!terms.isSelected()) {
			terms.click();
		}
	}

	public void clickOnSubmit() {
		
		signUp.click();
		String abc = signUp.getAttribute("value");
	}
	
	public void checkSuccessMessage() {
		Assert.assertEquals(true, successMsg.isDisplayed());
	}

	public void checkFailureMessage() {
		Assert.assertEquals(true, failureMsg.isDisplayed());		
	}

	public void checkAlreadyMessage() {
		Assert.assertEquals(true, alreadyMsg.isDisplayed());		
	}

}
