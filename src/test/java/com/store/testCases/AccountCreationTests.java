package com.store.testCases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.store.config.ConfigProperties;
import com.store.pages.AccountsPage;
import com.store.pages.ApparelStorePage;
import com.store.pages.CreateAccountPage;
import com.store.pages.SignInPage;
import com.store.utils.BaseClass;
import com.store.utils.ExcelConfig;

public class AccountCreationTests extends BaseClass{
	@BeforeClass
	@DataProvider(name = "accountsData")
	public Object[][] getAccountCreationData() throws IOException{
		String filePath = ConfigProperties.ConfigClass.testDataPath;
		String sheetName = "AccountCreation";
		return ExcelConfig.readFromExcel(filePath, sheetName);
	}
	
	@Test(dataProvider = "accountsData", priority ='1')
	public void createAccountTest(Hashtable<String, String> userDetails) throws InterruptedException{
		logger = extent.createTest("Create a new account with Ethnic Store");
		ApparelStorePage apparelStore = new ApparelStorePage(driver);
		utility.waitTillClickableAndClick(driver, apparelStore.signInBtn);
		SignInPage signIn = new SignInPage(driver);
		signIn.verifyEmial(userDetails.get("email"));
		utility.implicitDriverWait(driver);
		Assert.assertFalse(signIn.alertMessage.isDisplayed());
		CreateAccountPage createAccount = new CreateAccountPage(driver);
		utility.implicitDriverWait(driver);
		Thread.sleep(3000);
		createAccount.registerUser(userDetails);
		utility.implicitDriverWait(driver);
		AccountsPage accountsPage = new AccountsPage(driver);
		boolean createAccountResult = accountsPage.userBtn.isDisplayed();
		Assert.assertEquals(createAccountResult, true);
	}

	@Test(dataProvider = "accountsData", priority ='0')
	public void createAccountCaseTest(Hashtable<String, String> userDetails) throws InterruptedException{
		logger = extent.createTest("Create a new account with Ethnic Store with invalid country");
		userDetails.put("country", "-");
		ApparelStorePage apparelStore = new ApparelStorePage(driver);
		utility.waitTillClickableAndClick(driver, apparelStore.signInBtn);
		SignInPage signIn = new SignInPage(driver);
		signIn.verifyEmial(userDetails.get("email"));
		utility.implicitDriverWait(driver);
		Assert.assertFalse(signIn.alertMessage.isDisplayed());
		CreateAccountPage createAccount = new CreateAccountPage(driver);
		utility.implicitDriverWait(driver);
		Thread.sleep(2000);
		createAccount.registerUser(userDetails);
		utility.implicitDriverWait(driver);
		boolean createAccountCaseResult = createAccount.alertMessage.isDisplayed();
		Assert.assertEquals(createAccountCaseResult, true);
	}
}
