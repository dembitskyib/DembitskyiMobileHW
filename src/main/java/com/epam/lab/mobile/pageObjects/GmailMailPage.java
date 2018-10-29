package com.epam.lab.mobile.pageObjects;

import java.util.List;

import com.epam.lab.mobile.utils.DateUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class GmailMailPage extends GmailPageObject {
	@AndroidFindBy(className = "android.widget.ImageButton")
	private MobileElement widgetButton;
	@AndroidFindBy(id = "compose_button")
	private MobileElement composeButton;
	@AndroidFindBy(xpath = "//*[@class='android.support.v7.widget.RecyclerView']/*[@class='android.view.View']/*[@index='0']")
	private List<MobileElement> messageList;

	private GmailSideBarWidget gmailSideBarWidget;

	public GmailMailPage(AndroidDriver<? extends MobileElement> driver, int pageUpdateTimeOut) {
		super(driver, pageUpdateTimeOut);
		gmailSideBarWidget = new GmailSideBarWidget(driver, pageUpdateTimeOut);
	}

	public void tapWidgetButton() {
		widgetButton.click();
	}

	public void tapComposeButton() {
		composeButton.click();
	}

	public void tapOnMessageByIndex(int messageIndex) {
		waitUntilNewMessage();
		messageList.get(messageIndex).click();
	}

	public void waitUntilNewMessage() {
		String sendingDate = DateUtil.getCurrentDate("HH:mm");
		String messageDate;
		do {
			swipe(messageList.get(0), composeButton);
			messageDate = messageList.get(0).getAttribute("contentDescription");
			messageDate = messageDate.substring(messageDate.lastIndexOf(" ") + 1);
		} while (messageDate.compareTo(sendingDate) < 0);

	}

	public void tapAccountChooseButton() {
		gmailSideBarWidget.tapAccountChooseButton();
	}

	public void tapAccount(String accountName) {
		gmailSideBarWidget.tapAccount(accountName);
	}
}
