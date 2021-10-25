package com.store.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.objectMap.ObjectRepository;

public class ApparelStorePage {
	WebDriver driver = null;
	
	public ApparelStorePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className=ObjectRepository.MyStore.signinBtn_name)
	public WebElement signInBtn;
	
	@FindBy(id=ObjectRepository.MyStore.searchField_id)
	public WebElement searchField;
	
	@FindBy(className=ObjectRepository.MyStore.searchFieldBtn_name)
	public WebElement searchBtn;
	
	@FindBy(className = ObjectRepository.MyStore.productContainer_name)
	public List<WebElement> productContainer;
	
	@FindBy(xpath = ObjectRepository.MyStore.cartAccess_xpath)
	public WebElement accessCart;
}
