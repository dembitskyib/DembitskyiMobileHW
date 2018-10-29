package com.epam.lab.mobile;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.lab.mobile.businessObjects.GmailBO;
import com.epam.lab.mobile.factories.CapabilitiesFactory;
import com.epam.lab.mobile.models.Message;
import com.epam.lab.mobile.utils.JAXBParser;
import com.epam.lab.mobile.utils.PropertyParser;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class GmailMobileTest {
	private final String PROPERTIES_PATH = "src/test/resources/com/epam/lab/mobile/config.properties";

	private final String DEVICE_URL_PROPERTY = "deviceURL";
	private final String IMPLICITLY_WAIT_PROPERTY = "implicitlyWait";
	private final String PAGE_UPDATE_TIMEOUT_PROPERTY = "pageUpdateTimeOut";
	private final String MESSAGE_URL_PROPERTY = "messagePath";

	private final String GMAIL_ACTIVITY_NAME = ".GmailActivity";

	private AndroidDriver<MobileElement> androidDriver;
	private GmailBO gmailBO;
	private Message message;

	@BeforeClass
	public void setupDriver() throws MalformedURLException {
		PropertyParser propertyParser = new PropertyParser(PROPERTIES_PATH);
		androidDriver = new AndroidDriver<>(new URL(propertyParser.getProperty(DEVICE_URL_PROPERTY)),
				CapabilitiesFactory.getCapabilities());
		androidDriver.manage().timeouts().implicitlyWait(propertyParser.getIntProperty(IMPLICITLY_WAIT_PROPERTY),
				TimeUnit.SECONDS);
		gmailBO = new GmailBO(androidDriver, propertyParser.getIntProperty(PAGE_UPDATE_TIMEOUT_PROPERTY));
		message = JAXBParser.getMessage(propertyParser.getProperty(MESSAGE_URL_PROPERTY));
	}

	@Test
	public void loginTest() {
		assertEquals(gmailBO.skipInitialPage(), GMAIL_ACTIVITY_NAME);
		assertEquals(gmailBO.navigateToAccount(message.getFrom()), GMAIL_ACTIVITY_NAME);
		assertEquals(gmailBO.sendMessage(message), GMAIL_ACTIVITY_NAME);
		assertEquals(gmailBO.navigateToAccount(message.getTo()), GMAIL_ACTIVITY_NAME);
		assertTrue(gmailBO.isMessageValid(message));
	}

	@AfterClass
	public void driverQuit() {
		androidDriver.closeApp();
	}
}
