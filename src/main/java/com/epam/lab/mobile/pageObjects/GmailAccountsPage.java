package com.epam.lab.mobile.pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class GmailAccountsPage extends GmailPageObject {
	@AndroidFindBy(id = "action_done")
	private MobileElement goToGmailButton;
	@AndroidFindBy(id = "owner")
	private MobileElement accountField;

	public GmailAccountsPage(AndroidDriver<? extends MobileElement> driver, int pageUpdateTimeOut) {
		super(driver, pageUpdateTimeOut);
	}

	public void tapGoToGmail() {
		waitUntilIsVisible(accountField);
		goToGmailButton.click();
	}

}
