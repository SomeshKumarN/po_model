package com.framework.util;

import com.framework.base.ScriptHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventListener extends ScriptHelper implements WebDriverEventListener {

	public void beforeNavigateTo(String url, WebDriver driver) {
		Log.debug("Launching URL: '" + url + "'");
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		Log.debug("Browser successfully launched the URL:'" + url + "'");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		Log.debug("Value of the:" + element.toString() + " before any changes made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		Log.debug("Value of the:" + element.toString() + " before any changes made");
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		ScriptUtil.waitForElement(element);
		ScriptUtil.explicitWait(2);
		Log.debug("Trying to click on: " + element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		Log.debug("Successfully Clicked on: " + element.toString());
	}

	public void beforeNavigateBack(WebDriver driver) {
		Log.debug("Navigating back to previous page");
	}

	public void afterNavigateBack(WebDriver driver) {
		Log.debug("Navigated back to previous page");
	}

	public void beforeNavigateForward(WebDriver driver) {
		Log.debug("Navigating forward to next page");
	}

	public void afterNavigateForward(WebDriver driver) {
		Log.debug("Navigated forward to next page");
	}

	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception occured: " + error);
//		try {
//			ScriptUtil.takeScreenshotAtEndOfTest();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		Log.debug("Trying to find Element By : " + by.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		Log.debug("Found Element By : " + by.toString());
	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub
		
	}

	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}

	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

}