package com.epam.lab.mobile.pageObjects;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public abstract class GmailPageObject {
	protected AndroidDriver<? extends MobileElement> driver;
	protected int pageUpdateTimeOut;

	public GmailPageObject(AndroidDriver<? extends MobileElement> driver, int pageUpdateTimeOut) {
		this.driver = driver;
		this.pageUpdateTimeOut = pageUpdateTimeOut;
		PageFactory.initElements(new AppiumFieldDecorator(driver, pageUpdateTimeOut, TimeUnit.SECONDS), this);
	}

	public boolean isCurrentActivityValid(String activityName) {
		return activityName.equals(driver.currentActivity());
	}

	protected void waitUntilIsVisible(WebElement webElement) {
		try {
			(new WebDriverWait(driver, pageUpdateTimeOut)).until(ExpectedConditions.visibilityOf(webElement));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected void waitUntilActivity(String activityName) {
		try {
			(new WebDriverWait(driver, pageUpdateTimeOut)).until(new Function<WebDriver, Boolean>() {
				@SuppressWarnings("unchecked")
				public Boolean apply(WebDriver driver) {
					return ((AndroidDriver<? extends MobileElement>) driver).currentActivity().equals(activityName);
				}
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	protected void swipe(WebElement fromElement, WebElement toElement) {
		TouchAction action = new TouchAction(driver);
		action.longPress(fromElement).moveTo(toElement).release().perform();
	}

}
