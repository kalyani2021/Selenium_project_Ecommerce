package com.store.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.store.config.ConfigProperties;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass {
	public static WebDriver driver;
	public static WebDriverUtility utility = new WebDriverUtility();
	public static ExtentHtmlReporter htmlReporter = null;
	public static ExtentReports extent = null;
	public static ExtentTest logger = null;
	
	
	public String getScreenshot(WebDriver driver, String ScreenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String destination = System.getProperty("user.dir") + "/Screenshots/" + ScreenshotName + dateName + ".png";
		// added common-io jars
		FileUtils.copyFile(source, new File(destination));
		return destination;
	}

	@BeforeTest
	public void startReport() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/STMExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "HostName");
		extent.setSystemInfo("Environment", "Automation Testing");
		extent.setSystemInfo("User Name", "Nunna Likhitha");
		htmlReporter.config().setDocumentTitle("Apparel Store");
		htmlReporter.config().setReportName("Apparel Store Regression Test Suite");
		htmlReporter.config().setTheme(Theme.STANDARD);
	}

	@BeforeMethod
	@Parameters("browser")
	public void beforeMethod(String browser) {
		driver = utility.initializeDriver(browser, driver);
		driver.get(ConfigProperties.ConfigClass.storeUrl);
		driver.manage().window().maximize();
		utility.implicitDriverWait(driver);
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			// log the results
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed ", ExtentColor.RED));
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed ", ExtentColor.RED));
			logger.fail("Test Case Failed Snapshot is below - "
					+ logger.addScreenCaptureFromPath(getScreenshot(driver, result.getName())));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped ", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " - Test Case Passed ", ExtentColor.GREEN));
		}
		driver.quit();
	}
	
	@AfterTest
	public void stopTest(){
		extent.flush(); //at the end of all tests - it will append the test results to the htmlreport when flushed
	}
}
