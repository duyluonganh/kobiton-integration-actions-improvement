package com.kms.katalon.core.mobile.keyword.internal;

import java.util.concurrent.TimeUnit

import org.openqa.selenium.Dimension
import org.openqa.selenium.Point
import org.openqa.selenium.WebDriverException
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.touch.TouchActions

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.keyword.internal.AbstractKeyword
import com.kms.katalon.core.keyword.internal.SupportLevel
import com.kms.katalon.core.mobile.constants.StringConstants
import com.kms.katalon.core.testobject.TestObject

import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver

public abstract class MobileAbstractKeyword  extends AbstractKeyword {

	private static final int FIND_ELEMENT_TIMEOUT_IN_MILLIS = 50

	@Override
	public SupportLevel getSupportLevel(Object ...params) {
		return SupportLevel.NOT_SUPPORT;
	}

	protected AppiumDriver getAnyAppiumDriver() {
		AppiumDriver<?> driver = null;
		try {
			driver = MobileDriverFactory.getDriver();
		} catch (StepFailedException e) {
			// Native app not running, so get from driver store
			for (Object driverObject : RunConfiguration.getStoredDrivers()) {
				if (driverObject instanceof AppiumDriver<?>) {
					driver = (AppiumDriver) driverObject;
				}
			}
		}
		if (driver == null) {
			throw new StepFailedException(StringConstants.KW_MSG_UNABLE_FIND_DRIVER);
		}
		return driver;
	}

	protected boolean internalSwitchToNativeContext(AppiumDriver driver) {
		return internalSwitchToContext(driver, "NATIVE");
	}

	protected boolean internalSwitchToContext(AppiumDriver driver, String contextName) {
		try {
			for (String context : driver.getContextHandles()) {
				if (context.contains(contextName)) {
					driver.context(context);
					return true;
				}
			}
		} catch (WebDriverException e) {
			// Appium will raise WebDriverException error when driver.getContextHandles() is called but ios-webkit-debug-proxy is not started.
			// Catch it here and ignore
		}
		return false;
	}

	protected boolean internalSwitchToWebViewContext(AppiumDriver driver) {
		return internalSwitchToContext(driver, "WEBVIEW");
	}

	protected WebElement findElement(TestObject to, int timeOut) throws Exception {
		Date startTime = new Date();
		Date endTime;
		long span = 0;
		WebElement webElement = null;
		Point elementLocation = null;
		AppiumDriver<?> driver = MobileDriverFactory.getDriver();
		MobileSearchEngine searchEngine = new MobileSearchEngine(driver, to);
		webElement = searchEngine.findWebElement(false);
		return webElement;
	}

}

