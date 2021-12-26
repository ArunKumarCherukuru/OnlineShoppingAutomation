package com.SampleFramework.PageEvents;

import org.openqa.selenium.WebElement;

import com.SampleFramework.PageObjects.ProductCartSummaryPageObjects;
import com.SampleFramework.Utils.ElementFetch;
import com.SampleFramework.testScripts.BaseTest;

public class ProductCartSummaryPageEvents {
	public void clickProceedTocheckoutBtn() {
		WebElement element = ElementFetch.getWebElement("XPATH", ProductCartSummaryPageObjects.checkOutBtn_xpath);
		ElementFetch.scrollInto(element);
		element.click();
	}

	public String getName() {
		WebElement e = ElementFetch.getWebElement("XPATH", ProductCartSummaryPageObjects.deliveryAddressName);
		ElementFetch.scrollInto(e);
		String name = e.getText();
		return name;
	}

	public String getAddress() {
		String address = ElementFetch.getWebElement("XPATH", ProductCartSummaryPageObjects.deliveryAddress).getText();
		return address;
	}

	public String getCityStateAndPost() {
		String cityStateAndPost = ElementFetch
				.getWebElement("XPATH", ProductCartSummaryPageObjects.cityStatePostCode_xpath).getText();
		return cityStateAndPost;
	}

	public String getCountry() {
		String country = ElementFetch.getWebElement("XPATH", ProductCartSummaryPageObjects.country_xpath).getText();
		return country;
	}

	public String getMobile() {
		String mobile = ElementFetch.getWebElement("XPATH", ProductCartSummaryPageObjects.mobile_xpath).getText();
		return mobile;
	}

	public void ClickProceedBtnOnAddresstab() {
		BaseTest.logger.info("inside ClickProceedBtnOnAddresstab method");
		WebElement e = ElementFetch.getWebElement("XPATH",
				ProductCartSummaryPageObjects.address_processCheckOutBtn_xapth);
		ElementFetch.scrollInto(e);
		e.click();

	}

	public void ClickAgreementCheckbox() {
		BaseTest.logger.info("Selecting agreement Checkbox");
		WebElement e = ElementFetch.getWebElement("XPATH", ProductCartSummaryPageObjects.agreementCheckbox_xpath);
		ElementFetch.scrollInto(e);
		e.click();

	}

	public void ClickOnShippingCheckoutBtn() {
		BaseTest.logger.info("inside ClickOnShippingCheckoutBtn");
		WebElement e = ElementFetch.getWebElement("XPATH", ProductCartSummaryPageObjects.shippingCheckoutBtn_xpath);
		ElementFetch.scrollInto(e);
		e.click();

	}

	public void selectPayByBankWire() {
		BaseTest.logger.info("inside clickConfirmOrder");
		WebElement e = ElementFetch.getWebElement("XPATH", ProductCartSummaryPageObjects.payByBankWire_xpath);
		ElementFetch.scrollInto(e);
		e.click();

	}

	public void clickConfirmOrder() {
		BaseTest.logger.info("inside clickConfirmOrder");
		WebElement e = ElementFetch.getWebElement("XPATH", ProductCartSummaryPageObjects.orderConfirmationBtn);
		ElementFetch.scrollInto(e);
		e.click();

	}

	public String getOrderConfirmationWindowTitle() {
		return ElementFetch.getWebElement("XPATH", ProductCartSummaryPageObjects.orderConfirmationWindowHeader_xpath)
				.getText();

	}

}