package com.SampleFramework.PageEvents;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SampleFramework.PageObjects.MyAccountPageObjects;
import com.SampleFramework.Utils.ElementFetch;
import com.SampleFramework.testScripts.BaseTest;

public class MyAccountPageEvents {
	public String getPageHeader() {
		WebDriverWait wait = new WebDriverWait(BaseTest.driver, 20);
		wait.until(ExpectedConditions
				.visibilityOf(ElementFetch.getWebElement("XPATH", MyAccountPageObjects.pageHeader_xpath)));
		return ElementFetch.getWebElement("XPATH", MyAccountPageObjects.pageHeader_xpath).getText();
	}
}