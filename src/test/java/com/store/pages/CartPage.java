package com.store.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.objectMap.ObjectRepository;

public class CartPage {
WebDriver driver = null;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = ObjectRepository.Cart.proceedChkOutBtn_linkText)
	public WebElement proceedChkOutBtn;
	
	@FindBy(name = ObjectRepository.Cart.processAddress_tagName)
	public WebElement processAddress;
	
	@FindBy(name = ObjectRepository.Cart.processCarrier_tagName)
	public WebElement processCarrier;
	
	@FindBy(id = ObjectRepository.Cart.termsChkBox_id)
	public WebElement carrierTermsBtn;
	
	@FindBy(className = ObjectRepository.Cart.PayByBankWire_name)
	public WebElement payByBankWire;
	
	@FindBy(className = ObjectRepository.Cart.PayByCheque_name)
	public WebElement payByCheque;
	
	@FindBy(xpath = ObjectRepository.Cart.confirmOrderBtn_xpath)
	public WebElement confirmOrderBtn;
	
	@FindBy(className = ObjectRepository.Cart.successAlert_name)
	public WebElement orderSuccessAlert;
	
	public final String orderSucessAlertMessage = "Your order on My Store is complete.";
}
