package com.epam.lab.mobile.pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class GmailViewMessagePage extends GmailMailPage {
	@AndroidFindBy(id = "subject_and_folder_view")
	private MobileElement subjectField;
	@AndroidFindBy(xpath = "//*[starts-with(@resource-id, 'm')]//*")
	private MobileElement messageField;

	public GmailViewMessagePage(AndroidDriver<? extends MobileElement> driver, int pageUpdateTimeOut) {
		super(driver, pageUpdateTimeOut);
	}

	public String getSubjectText() {
		String subject = subjectField.getText().trim();
		return subject.substring(0, subject.lastIndexOf(" "));
	}

	public String getMessageText() {
		return messageField.getText();
	}

}
