package com.qa.android.test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.appium.pages.AppiumPageActions;
import com.qa.appium.utils.AppiumBaseUtility;
import com.qa.web.pages.PageActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumTest {
	AndroidDriver driver;
	AppiumPageActions pageActions;

	@BeforeTest
	public void AppiumTest() {
		driver = AppiumBaseUtility.openApplication();
		pageActions = new AppiumPageActions(driver);
	}

	@Test(priority = 0)
	public void verifyTitle() {
		Assert.assertEquals(pageActions.getTitle(), "selendroid-test-app");
	}

	@Test(priority = 1)
	public void verifyEnCTAFunctionality() {
		pageActions.clickENButton();
		pageActions.clickNoNo();
		Assert.assertTrue(pageActions.isHomePageDisplayed());
	}

	@Test(priority = 2)
	public void verifyRegisterFunctionality() throws Throwable {
		pageActions.clickOnFileLogoCTA();
		Assert.assertEquals(pageActions.getNameOnRegisterPage(), "Mr. Burns");
		Assert.assertEquals(pageActions.getSelectedProgrammingLanguage(), "Ruby");

		pageActions.enterUsernameEmailPassword();
		pageActions.checkIAcceptAdds();
		pageActions.clickRegisterUser();

		Assert.assertEquals(pageActions.verifyLabelName(), "Ruchita");
		Assert.assertEquals(pageActions.verifyUsername(), "ruchita12345");
		Assert.assertEquals(pageActions.verifyPassword(), "ruchsol");
		Assert.assertEquals(pageActions.verifyEmail(), "test@gmail.com");
		Assert.assertEquals(pageActions.verifyAcceptAdds(), "true");

		pageActions.clickRegisterNow();
		Assert.assertEquals(pageActions.isHomepageAvailable(), "selendroid-test-app");
	}

	@Test(priority = 3)
	public void verifyChromeLogoCTAFunctionality() throws Throwable {
		pageActions.clickChromeLogo();
		pageActions.selectPrefferedCar();
		pageActions.clickSendMeYourName();

		Assert.assertTrue(pageActions.verifyTextOnHelloDemoScreen());
		pageActions.clickOnHere();
	}

	@Test(priority = 4)
	public void verifyShowProgressBarFunctionality() throws Throwable {
		pageActions.clickOnShowProgressBarForAWhile();
		Assert.assertEquals(pageActions.getNameOnRegisterPage(), "Mr. Burns");
		Assert.assertEquals(pageActions.getSelectedProgrammingLanguage(), "Ruby");

		pageActions.clickRegisterUser();
		pageActions.clickRegisterNow();
	}

	@Test(priority = 5)
	public void unhandelledExceptionFail() throws Throwable {
		pageActions.clickOnPressToThrowTnhandledException();
		Assert.assertTrue(false, "Homepage not available");
	}

	@AfterTest
	public void quit() {
		AppiumBaseUtility.closeApplication();
	}
}
