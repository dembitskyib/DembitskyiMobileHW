package com.epam.lab.mobile.factories;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.MobileCapabilityType;

public class CapabilitiesFactory {
	private static final String PLATFORM_NAME_CAPABILITY = "Android";
	private static final String DEVICE_NAME_CAPABILITY = "Redmi Note 3 Pro";
	private static final String UDID_CAPABILITY = "cecbf0e";
	private static final String APP_PACKAGE_CAPABILITY = "com.google.android.gm";
	private static final String APP_ACTIVITY_CAPABILITY = "com.google.android.gm.GmailActivity";
	private static final String COMMAND_TIME_OUT_CAPABILITY = "60";

	public static DesiredCapabilities getCapabilities() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME_CAPABILITY);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME_CAPABILITY);
		capabilities.setCapability(MobileCapabilityType.UDID, UDID_CAPABILITY);
		capabilities.setCapability("appPackage", APP_PACKAGE_CAPABILITY);
		capabilities.setCapability("appActivity", APP_ACTIVITY_CAPABILITY);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, COMMAND_TIME_OUT_CAPABILITY);
		return capabilities;
	}
}
