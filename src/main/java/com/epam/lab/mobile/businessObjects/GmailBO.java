package com.epam.lab.mobile.businessObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.lab.mobile.models.Message;
import com.epam.lab.mobile.pageObjects.GmailAccountsPage;
import com.epam.lab.mobile.pageObjects.GmailComposePage;
import com.epam.lab.mobile.pageObjects.GmailInitialPage;
import com.epam.lab.mobile.pageObjects.GmailMailPage;
import com.epam.lab.mobile.pageObjects.GmailViewMessagePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class GmailBO {
	private static final Logger LOGGER = LogManager.getLogger(GmailBO.class);

	private GmailAccountsPage gmailAccountsPage;
	private GmailComposePage gmailComposePage;
	private GmailInitialPage gmailInitialPage;
	private GmailMailPage gmailMailPage;
	private GmailViewMessagePage gmailViewMessagePage;

	private final String LOG_TAP_MESSAGE = "Tapping %s";
	private final String LOG_FILL_FIELD_MESSAGE = "Filling '%s' field with: %s";
	private final String INCORRECT_FIELD_MESSAGE = "%s field with value '%s' is incorrect";

	public GmailBO(AndroidDriver<? extends MobileElement> driver, int pageUpdateTimeOut) {
		gmailAccountsPage = new GmailAccountsPage(driver, pageUpdateTimeOut);
		gmailComposePage = new GmailComposePage(driver, pageUpdateTimeOut);
		gmailInitialPage = new GmailInitialPage(driver, pageUpdateTimeOut);
		gmailMailPage = new GmailMailPage(driver, pageUpdateTimeOut);
		gmailViewMessagePage = new GmailViewMessagePage(driver, pageUpdateTimeOut);
	}

	public void skipInitialPage() {
		LOGGER.info(String.format(LOG_TAP_MESSAGE, "ok on initial page"));
		gmailInitialPage.tapOk();
		LOGGER.info(String.format(LOG_TAP_MESSAGE, "ok on accounts page"));
		gmailAccountsPage.tapGoToGmail();
	}

	public void navigateToAccount(String accountName) {
		LOGGER.info(String.format(LOG_TAP_MESSAGE, "widget button"));
		gmailMailPage.tapWidgetButton();
		LOGGER.info(String.format(LOG_TAP_MESSAGE, "choose account button"));
		gmailMailPage.tapAccountChooseButton();
		LOGGER.info(String.format("Tapping on '%s' account name", accountName));
		gmailMailPage.tapAccount(accountName);
	}

	public void sendMessage(Message message) {
		LOGGER.info(String.format(LOG_TAP_MESSAGE, "compose button"));
		gmailMailPage.tapComposeButton();
		LOGGER.info(String.format(LOG_FILL_FIELD_MESSAGE, "subject", message.getSubject()));
		gmailComposePage.fillSubjectField(message.getSubject());
		LOGGER.info(String.format(LOG_FILL_FIELD_MESSAGE, "message", message.getText()));
		gmailComposePage.fillMessageField(message.getText());
		LOGGER.info(String.format(LOG_FILL_FIELD_MESSAGE, "to", message.getTo()));
		gmailComposePage.fillToField(message.getTo());
		LOGGER.info(String.format(LOG_TAP_MESSAGE, "send button"));
		gmailComposePage.tapSendButton();
	}

	public boolean isMessageValid(Message message) {
		LOGGER.info(String.format("Checking if message with subject: %s and text: %s", message.getSubject(),
				message.getText()));
		LOGGER.info("Waiting new message to appear");
		gmailMailPage.tapOnMessageByIndex(0);
		boolean isValid = true;
		if (!message.getSubject().equals(gmailViewMessagePage.getSubjectText())) {
			LOGGER.info(String.format(INCORRECT_FIELD_MESSAGE, "Subject", gmailViewMessagePage.getSubjectText()));
			isValid = false;
		}
		if (!message.getText().equals(gmailViewMessagePage.getMessageText())) {
			LOGGER.info(String.format(INCORRECT_FIELD_MESSAGE, "Message", gmailViewMessagePage.getMessageText()));
			isValid = false;
		}
		return isValid;
	}
}
