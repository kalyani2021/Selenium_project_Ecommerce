package com.store.pages;

import com.store.objectMap.ObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	WebDriver driver = null;
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id=ObjectRepository.SignIn.createAccountEmail_id)
	public WebElement createAccountEmail;
	
	@FindBy(id=ObjectRepository.SignIn.createAccountBtn_id)
	public WebElement createAccountBtn;
	
	@FindBy(id=ObjectRepository.SignIn.loginEmail_id)
	public WebElement loginEmail;
	
	@FindBy(id=ObjectRepository.SignIn.loginPassword_id)
	public WebElement loginPassword;
	
	@FindBy(id=ObjectRepository.SignIn.loginBtn_id)
	public WebElement loginBtn;
	
	@FindBy(className=ObjectRepository.Accounts.alertMessage_name)
	public WebElement alertMessage;
	
	public void verifyEmial(String email) {
		createAccountEmail.sendKeys(email);
		createAccountBtn.click();
	}
	
	public WebDriver login(String email, String password) {
		loginEmail.sendKeys(email);
		loginPassword.sendKeys(password);
		loginBtn.click();
		return driver;
	}

}
