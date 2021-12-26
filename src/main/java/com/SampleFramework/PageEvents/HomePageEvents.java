package com.SampleFramework.PageEvents;

import com.SampleFramework.PageObjects.HomePageObjects;
import com.SampleFramework.Utils.ElementFetch;

public class HomePageEvents {

	public void clickSignBtn() {
		try {
			ElementFetch.getWebElement("XPATH", HomePageObjects.signIn_xpath).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
