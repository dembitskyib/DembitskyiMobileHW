package com.epam.lab.mobile.pageObjects;

import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class GmailSideBarWidget extends GmailPageObject {
	@AndroidFindBy(id = "conversation_tip_text")
	private MobileElement accountChooseButton;
	@AndroidFindBy(id = "account_address")
	private List<MobileElement> accountList;

	public GmailSideBarWidget(AndroidDriver<? extends MobileElement> driver, int pageUpdateTimeOut) {
		super(driver, pageUpdateTimeOut);
	}

	public void tapAccountChooseButton() {
		accountChooseButton.click();
	}

	public void tapAccount(String accountName) {
		accountList.forEach(account -> {
			if (account.getText().equals(accountName)) {
				account.click();
			}
		});
	}
}
