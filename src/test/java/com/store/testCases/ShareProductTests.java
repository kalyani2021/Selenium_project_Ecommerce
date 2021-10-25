package com.store.testCases;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.store.pages.ApparelStorePage;
import com.store.pages.ItemPage;
import com.store.utils.BaseClass;

public class ShareProductTests extends BaseClass {
	
	@Test
	public void shareProductTest() throws InterruptedException{
		logger = extent.createTest("Verify share product buttons for an item in Ethnic Store");
		ApparelStorePage apparelStore = new ApparelStorePage(driver);
		apparelStore.productContainer.get(0).click();
		utility.implicitDriverWait(driver);
		String parentHandle = driver.getWindowHandle();
		ItemPage itemPage = new ItemPage(driver);
		List<WebElement> shareBtns = new ArrayList<WebElement>();
		shareBtns.add(itemPage.pinterestBtn);
		shareBtns.add(itemPage.googlePlusBtn);
		shareBtns.add(itemPage.facebookShareBtn);
		for(WebElement shareBtn: shareBtns) {
			utility.waitTillClickableAndClick(driver, shareBtn);
			Set<String> winHandles = driver.getWindowHandles();
			Iterator<String> iterator = winHandles.iterator();
			while(iterator.hasNext()) {
				String childHandle = iterator.next();
				if(!parentHandle.equals(childHandle)) {
					driver.switchTo().window(childHandle);
					utility.implicitDriverWait(driver);
					driver.close();
					driver.switchTo().window(parentHandle);
					assertTrue(shareBtn.equals(driver.switchTo().activeElement()));
					Thread.sleep(1000);
					break;
				}
			}
		}
		
		Thread.sleep(2000);
		itemPage.homeBtn.click();
	}
}
