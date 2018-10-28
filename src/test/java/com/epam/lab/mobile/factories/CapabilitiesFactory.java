package com.epam.lab.mobile.factories;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.MobileCapabilityType;

public class CapabilitiesFactory {
	public static DesiredCapabilities getCapabilities() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi Note 3 Pro");
		capabilities.setCapability(MobileCapabilityType.UDID, "cecbf0e");
		capabilities.setCapability("appPackage", "com.google.android.gm");
		capabilities.setCapability("appActivity", "com.google.android.gm.GmailActivity");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		return capabilities;
	}
}
