package com.store.pages;
import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.store.objectMap.ObjectRepository;
public class CreateAccountPage {
	WebDriver driver = null;

	public CreateAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id=ObjectRepository.createAccount.firstName_id)
	public WebElement firstName;
	
	@FindBy(id=ObjectRepository.createAccount.lastName_id)
	public WebElement lastName;
	
	@FindBy(id=ObjectRepository.createAccount.password_id)
	public WebElement password;
	
	@FindBy(id=ObjectRepository.createAccount.addressLine1_id)
	public WebElement addressLine1;
	
	@FindBy(id=ObjectRepository.createAccount.addressCity_id)
	public WebElement city;
	
	@FindBy(xpath=ObjectRepository.createAccount.dropDownStates_xpath)
	public WebElement state;
	
	@FindBy(id=ObjectRepository.createAccount.addressPostalCode_id)
	public WebElement postalCode;
	
	@FindBy(id=ObjectRepository.createAccount.dropDownCountry_id)
	public WebElement country;
	
	@FindBy(id=ObjectRepository.createAccount.mobilePhone_id)
	public WebElement phoneNumber;
	
	@FindBy(id=ObjectRepository.createAccount.registerBtn_id)
	public WebElement registerBtn;
	
	@FindBy(className=ObjectRepository.createAccount.alertMessage_name)
	public WebElement alertMessage;
	
	public WebDriver registerUser(Hashtable<String, String> userDetails) throws InterruptedException {
		Thread.sleep(2000);
		Select stateSelect = new Select(state);
		Select countrySelect = new Select(country);
		firstName.sendKeys(userDetails.get("firstName"));
		lastName.sendKeys(userDetails.get("lastName"));
		password.sendKeys(userDetails.get("password"));
		addressLine1.sendKeys(userDetails.get("addressLine1"));
		city.sendKeys(userDetails.get("city"));
		stateSelect.selectByVisibleText(userDetails.get("state"));
		postalCode.sendKeys(userDetails.get("postalCode"));
		if (!(userDetails.get("country").equalsIgnoreCase("United States")))
			countrySelect.selectByIndex(0);
		phoneNumber.sendKeys(userDetails.get("phoneNumber"));
		registerBtn.click();
		return driver;
	}

}
