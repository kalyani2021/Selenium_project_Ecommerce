package com.store.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.store.objectMap.ObjectRepository;

public class AccountsPage {
WebDriver driver = null;
	
	public AccountsPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=ObjectRepository.Accounts.userBtn_xpath)
	public WebElement userBtn;
	
	@FindBy(className=ObjectRepository.Accounts.alertMessage_name)
	public WebElement alertMessage;
	
	@FindBy(linkText=ObjectRepository.Accounts.signOutBtn_linkText)
	public WebElement signOutBtn;
	
	@FindBy(className=ObjectRepository.Accounts.signinBtn_name)
	public WebElement signInBtn;
	
	@FindBy(linkText = ObjectRepository.Accounts.homeBtn_linkText)
	public WebElement homeBtn;
	
	public String alertMsgBgColor = "#f3515c";

}
