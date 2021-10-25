package com.store.pages;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.store.objectMap.ObjectRepository;
public class ItemPage {
WebDriver driver = null;
	
	public ItemPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = ObjectRepository.Item.reviewItem_xpath)
	public WebElement reviewBtn;
	
	@FindBy(xpath = ObjectRepository.Item.addToCartBtn_xpath)
	public WebElement addToCartBtn;
	
	@FindBy(className = ObjectRepository.Item.continueShoppingBtn_name)
	public WebElement continueShoppingBtn_name;
	
	@FindBy(className = ObjectRepository.Item.stars_name)
	public List<WebElement> stars;
	
	@FindBy(id = ObjectRepository.Item.commentTitle_id)
	public WebElement commentTitle;
	
	@FindBy(id = ObjectRepository.Item.commentContent_id)
	public WebElement commentContent;
	
	@FindBy(id = ObjectRepository.Item.commentSendBtn_id)
	public WebElement commentSend;

	
	@FindBy(xpath = ObjectRepository.Item.commentCheck_xpath)
	public WebElement commentCheckText;
	
	@FindBy(xpath = ObjectRepository.Item.commentOkBtn_xpath)
	public WebElement commentOkBtn;
	
	@FindBy(id = ObjectRepository.Item.commentErrorMsg_id)
	public WebElement commentErrorMsg;
	
	@FindBy(className = ObjectRepository.Item.homeBtn_name)
	public WebElement homeBtn;
	
	@FindBy(xpath = ObjectRepository.Item.pinterestBtn_xpath)
	public WebElement pinterestBtn;
	
	@FindBy(xpath = ObjectRepository.Item.googlePlusBtn_xpath)
	public WebElement googlePlusBtn;
	
	@FindBy(xpath = ObjectRepository.Item.facebookShareBtn_xpath)
	public WebElement facebookShareBtn;
}
