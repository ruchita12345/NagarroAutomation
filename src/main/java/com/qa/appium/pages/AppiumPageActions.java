package com.qa.appium.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.appium.base.AppiumBasePage;
import com.qa.web.pages.PageActions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppiumPageActions extends AppiumBasePage {

	public AppiumPageActions(AndroidDriver driver) {
		super(driver);
	}

	public String getTitle() {
		String title = driver
				.findElementByAndroidUIAutomator(
						"UiSelector().className(\"android.widget.FrameLayout\").className(\"android.widget.TextView\").index(0)")
				.getText();
		return title;
	}

	public void clickENButton() {
		driver.findElement(By.id("io.selendroid.testapp:id/buttonTest")).click();
	}

	public void clickNoNo() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/button2")));
		driver.findElement(By.id("android:id/button2")).click();
	}

	public boolean isHomePageDisplayed() {
		List<WebElement> element = driver.findElements(By.id("android:id/title"));
		if (element.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	public void clickChromeLogo() {
		driver.findElement(By.id("io.selendroid.testapp:id/buttonStartWebview")).click();
	}

	public String verifyTextOnChromeWindow() throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//android.view.View[contains(@text='Hello, can you please tell me your name?')]")));
		return driver
				.findElement(
						By.xpath("//android.view.View[contains(@text='Hello, can you please tell me your name?')]"))
				.getText();
	}

	public void enterName() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Enter your name here!']"))
				.sendKeys("Ruchita");
	}

	public void selectPrefferedCar() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Spinner[@index='2']")));
		driver.findElement(By.xpath("//android.widget.Spinner[@index='2']")).click();
		Thread.sleep(5000);
		List<WebElement> li = driver.findElements(By.id("android:id/text1"));
		for (WebElement el : li) {
			if (el.getText().equalsIgnoreCase("Mercedes")) {
				el.click();
				break;
			}
		}
	}

	public void clickSendMeYourName() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.widget.Button[contains(@text,'Send me your name!')]")));
		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'Send me your name!')]")).click();
	}

	public boolean verifyTextOnHelloDemoScreen() {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//android.view.View[contains(@text, 'This is my way of saying hello')]")));

		String txtHeadingActual = driver
				.findElement(By.xpath("//android.view.View[contains(@text, 'This is my way of saying hello')]"))
				.getText();
		if (txtHeadingActual.contains("This is my way of saying hello")) {
			return true;
		} else {
			return false;
		}
	}

	public void clickOnHere() throws InterruptedException {
		driver.navigate().back();
		Thread.sleep(2000);
	}

	// File Register
	public void clickOnFileLogoCTA() {
		driver.findElement(By.id("io.selendroid.testapp:id/startUserRegistration")).click();
	}

	public String verifyTextVisibleOnRegisterPage() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView")));
		return driver.findElement(By.xpath("//android.widget.TextView")).getAttribute("text");
	}

	public String getNameOnRegisterPage() throws InterruptedException {
		Thread.sleep(20000);
		driver.navigate().back();
		Thread.sleep(2000);
		return driver.findElement(By.id("io.selendroid.testapp:id/inputName")).getAttribute("text");

	}

	public String getSelectedProgrammingLanguage() {
		return driver.findElement(By.id("android:id/text1")).getAttribute("text");
	}

	public void enterUsernameEmailPassword() {
		driver.findElement(By.id("io.selendroid.testapp:id/inputUsername")).sendKeys("ruchita12345");
		driver.findElement(By.id("io.selendroid.testapp:id/inputEmail")).sendKeys("test@gmail.com");
		driver.findElement(By.id("io.selendroid.testapp:id/inputPassword")).sendKeys("ruchsol");
		driver.findElement(By.id("io.selendroid.testapp:id/inputName")).clear();
		driver.findElement(By.id("io.selendroid.testapp:id/inputName")).sendKeys("Ruchita");
	}

	public void checkIAcceptAdds() {
		driver.findElement(By.id("io.selendroid.testapp:id/input_adds")).click();
	}

	public void clickRegisterUser() throws Throwable {
		driver.findElement(By.id("io.selendroid.testapp:id/btnRegisterUser")).click();
	}

	public String verifyLabelName() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("io.selendroid.testapp:id/label_name_data")));
		return driver.findElement(By.id("io.selendroid.testapp:id/label_name_data")).getAttribute("text");
	}

	public String verifyUsername() {
		return driver.findElement(By.id("io.selendroid.testapp:id/label_username_data")).getAttribute("text");
	}

	public String verifyPassword() {
		return driver.findElement(By.id("io.selendroid.testapp:id/label_password_data")).getAttribute("text");
	}

	public String verifyEmail() {
		return driver.findElement(By.id("io.selendroid.testapp:id/label_email_data")).getAttribute("text");
	}

	public String verifyAcceptAdds() {
		return driver.findElement(By.id("io.selendroid.testapp:id/label_acceptAdds_data")).getAttribute("text");
	}

	public void clickRegisterNow() {
		driver.findElement(By.id("io.selendroid.testapp:id/buttonRegisterUser")).click();
	}

	public String isHomepageAvailable() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView")));

		return driver.findElement(By.xpath("//android.widget.TextView")).getAttribute("text");
	}

	// Show Progress Bar for a while
	public void clickOnShowProgressBarForAWhile() {
		driver.findElement(By.id("io.selendroid.testapp:id/waitingButtonTest")).click();
	}

	// Press to throw unhandled exception
	public void clickOnPressToThrowTnhandledException() throws Throwable {
		driver.findElement(By.id("io.selendroid.testapp:id/exceptionTestButton")).click();
		Thread.sleep(5000);
	}

	public boolean userNavigatesToHomepageException() throws Throwable {
		List<WebElement> element = driver.findElements(By.id("io.selendroid.testapp:id/exceptionTestButton"));
		if (element.isEmpty()) {
			return false;
		} else {
			return false;
		}
	}
}