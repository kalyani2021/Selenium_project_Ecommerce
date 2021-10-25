package com.store.testCases;

import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.store.config.ConfigProperties;
import com.store.pages.AccountsPage;
import com.store.pages.ApparelStorePage;
import com.store.pages.SignInPage;
import com.store.utils.BaseClass;

public class LoginLogOffTest extends BaseClass {
	@Test
	public void validLoginTest(){
		logger = extent.createTest("Verify valid Login for Ethnic Store");
		ApparelStorePage apparelStore = new ApparelStorePage(driver);
		utility.waitTillClickableAndClick(driver, apparelStore.signInBtn);
		SignInPage signIn = new SignInPage(driver);
		driver = signIn.login(ConfigProperties.ConfigClass.loginEmail, ConfigProperties.ConfigClass.loginPassword);
		utility.implicitDriverWait(driver);
		AccountsPage accountsPage = new AccountsPage(driver);
		boolean loginResult = accountsPage.userBtn.isDisplayed();
		Assert.assertEquals(loginResult, true);
	}
	
	@Test
	public void invalidLoginTest(){
		logger = extent.createTest("Verify invalid Login for Ethnic Store");
		ApparelStorePage apparelStore = new ApparelStorePage(driver);
		utility.waitTillClickableAndClick(driver, apparelStore.signInBtn);
		SignInPage signIn = new SignInPage(driver);
		driver = signIn.login(ConfigProperties.ConfigClass.loginEmail, "dfgsdg");
		utility.implicitDriverWait(driver);
		AccountsPage accountsPage = new AccountsPage(driver);
		boolean loginResult = accountsPage.alertMessage.isDisplayed();
		String alertBgColor = Color.fromString(accountsPage.alertMessage.getCssValue("background-color")).asHex();
		Assert.assertEquals(accountsPage.alertMsgBgColor, alertBgColor);
		Assert.assertEquals(loginResult, true);
	}
	
	@Test
	public void logOffTest() throws InterruptedException {
		logger = extent.createTest("Verify logoff for Ethnic Store");
		ApparelStorePage apparelStore = new ApparelStorePage(driver);
		utility.waitTillClickableAndClick(driver, apparelStore.signInBtn);
		SignInPage signIn = new SignInPage(driver);
		driver = signIn.login(ConfigProperties.ConfigClass.loginEmail, ConfigProperties.ConfigClass.loginPassword);
		utility.implicitDriverWait(driver);
		AccountsPage accountsPage = new AccountsPage(driver);
		boolean loginResult = accountsPage.userBtn.isDisplayed();
		Assert.assertEquals(loginResult, true);
		utility.waitTillClickableAndClick(driver, accountsPage.signOutBtn);
		boolean signOutResult = accountsPage.signInBtn.isDisplayed();
		Assert.assertEquals(signOutResult, true);
	}
}