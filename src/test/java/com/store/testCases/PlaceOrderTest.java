package com.store.testCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.store.config.ConfigProperties;
import com.store.pages.AccountsPage;
import com.store.pages.ApparelStorePage;
import com.store.pages.CartPage;
import com.store.pages.ItemPage;
import com.store.pages.SignInPage;
import com.store.utils.BaseClass;

public class PlaceOrderTest extends BaseClass {
	
	@Test
	public void placeOrder() throws InterruptedException{
		logger = extent.createTest("Verify order placement for Ethnic Store");
		ApparelStorePage apparelStore = new ApparelStorePage(driver);
		utility.waitTillClickableAndClick(driver, apparelStore.signInBtn);
		SignInPage signIn = new SignInPage(driver);
		driver = signIn.login(ConfigProperties.ConfigClass.loginEmail, ConfigProperties.ConfigClass.loginPassword);
		utility.implicitDriverWait(driver);
		AccountsPage accountsPage = new AccountsPage(driver);
		utility.waitTillClickableAndClick(driver, accountsPage.homeBtn);
		for(int i = 0; i < 3; i++) {
			Thread.sleep(1000);
			utility.waitTillClickableAndClick(driver, apparelStore.productContainer.get(i));
			ItemPage itemPage = new ItemPage(driver);
			utility.waitTillClickableAndClick(driver, itemPage.addToCartBtn);
			utility.waitTillClickableAndClick(driver, itemPage.continueShoppingBtn_name);
			utility.waitTillClickableAndClick(driver, itemPage.homeBtn);
		}
		apparelStore.accessCart.click();
		CartPage cartPage = new CartPage(driver);
		utility.waitTillClickableAndClick(driver, cartPage.proceedChkOutBtn);
		utility.waitTillClickableAndClick(driver, cartPage.processAddress);
		utility.waitTillClickableAndClick(driver, cartPage.carrierTermsBtn);
		utility.waitTillClickableAndClick(driver, cartPage.processCarrier);
		utility.waitTillClickableAndClick(driver, cartPage.payByCheque);
		utility.waitTillClickableAndClick(driver, cartPage.confirmOrderBtn);
		boolean successAlert = cartPage.orderSuccessAlert.isDisplayed();
		assertEquals(successAlert, true);
		assertEquals(cartPage.orderSuccessAlert.getText(), cartPage.orderSucessAlertMessage);
	}
}
