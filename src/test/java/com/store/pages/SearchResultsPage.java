package com.store.pages;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.store.objectMap.ObjectRepository;
public class SearchResultsPage {
	WebDriver driver = null;

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=ObjectRepository.Search.searchItemsContainer_xpath)
	public List<WebElement> searchItems;
	
	@FindBy(xpath=ObjectRepository.Search.searchItemsAlert_xpath)
	public WebElement searchAlert;
	
	@FindBy(xpath = ObjectRepository.Search.fashionManufacturer_xpath)
	public WebElement fashionManufacturer;
}
