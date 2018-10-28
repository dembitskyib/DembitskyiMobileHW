package com.epam.lab.mobile.pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class GmailComposePage extends GmailPageObject {
	@AndroidFindBy(id = "to")
	private MobileElement toField;
	@AndroidFindBy(id = "subject")
	private MobileElement subjectField;
	@AndroidFindBy(id = "body_wrapper")
	private MobileElement messageField;
	@AndroidFindBy(id = "send")
	private MobileElement sendButton;

	public GmailComposePage(AndroidDriver<? extends MobileElement> driver, int pageUpdateTimeOut) {
		super(driver, pageUpdateTimeOut);
	}

	public void fillToField(String receiver) {
		toField.sendKeys(receiver);
	}

	public void fillSubjectField(String subject) {
		subjectField.sendKeys(subject);
	}

	public void fillMessageField(String message) {
		messageField.sendKeys(message);
	}

	public void tapSendButton() {
		sendButton.click();
		waitUntilActivity(".GmailActivity");
	}
}
