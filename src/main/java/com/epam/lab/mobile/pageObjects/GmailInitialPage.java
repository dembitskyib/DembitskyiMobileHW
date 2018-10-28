package com.epam.lab.mobile.pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class GmailInitialPage extends GmailPageObject {
	@AndroidFindBy(id = "welcome_tour_got_it")
	private MobileElement okButton;

	public GmailInitialPage(AndroidDriver<? extends MobileElement> driver, int pageUpdateTimeOut) {
		super(driver, pageUpdateTimeOut);
	}

	public void tapOk() {
		okButton.click();
	}

}
