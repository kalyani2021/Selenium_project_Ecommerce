package com.store.testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.store.config.ConfigProperties;
import com.store.pages.AccountsPage;
import com.store.pages.ApparelStorePage;
import com.store.pages.ItemPage;
import com.store.pages.SignInPage;
import com.store.utils.BaseClass;

public class ReviewTest extends BaseClass {
	
	@Test
	public void writeReviewTest(){
		logger = extent.createTest("Verify review functionality for an item in Ethnic Store");
		ApparelStorePage apparelStore = new ApparelStorePage(driver);
		utility.waitTillClickableAndClick(driver, apparelStore.signInBtn);
		SignInPage signIn = new SignInPage(driver);
		driver = signIn.login(ConfigProperties.ConfigClass.loginEmail, ConfigProperties.ConfigClass.loginPassword);
		utility.implicitDriverWait(driver);
		AccountsPage accountsPage = new AccountsPage(driver);
		utility.waitTillClickableAndClick(driver, accountsPage.homeBtn);
		apparelStore.productContainer.get(0).click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
	
		ItemPage itemPage = new ItemPage(driver);
	    executor.executeScript("arguments[0].scrollIntoView(true);",itemPage.reviewBtn);
		utility.waitTillClickableAndClick(driver, itemPage.reviewBtn);
		itemPage.stars.get(4);		//3-star rating
		itemPage.commentTitle.sendKeys("Review");
		itemPage.commentContent.sendKeys("good");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		utility.waitTillClickableAndClick(driver, itemPage.commentSend);
		boolean commentError = itemPage.commentErrorMsg.isDisplayed();
		Assert.assertFalse(commentError);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		utility.waitTillClickableAndClick(driver, itemPage.commentOkBtn);
	}
}
