package com.SampleFramework.PageObjects;

public class ProductCartSummaryPageObjects {
	public static final String checkOutBtn_xpath = "//p/a[@title='Proceed to checkout']";
	public static final String deliveryAddressName = "//ul[@id='address_delivery']/li[@class='address_firstname address_lastname']";
	public static final String deliveryAddress = "//ul[@id='address_delivery']/li[@class='address_address1 address_address2']";
	public static final String cityStatePostCode_xpath = "//ul[@id='address_delivery']/li[@class='address_city address_state_name address_postcode']";
	public static final String country_xpath = "//ul[@id='address_delivery']/li[@class='address_country_name']";
	public static final String mobile_xpath = "//ul[@id='address_delivery']/li[@class='address_phone_mobile']";
	public static final String address_processCheckOutBtn_xapth = "//button[@name='processAddress']";
	public static final String shippingCheckoutBtn_xpath = "//button[@name='processCarrier']";
	public static final String agreementCheckbox_xpath = "//input[@type='checkbox']";
	public static final String payByBankWire_xpath = "//div[@id='HOOK_PAYMENT']/div/div/p/a[@title='Pay by bank wire']";
	public static final String orderConfirmationBtn = "//p[@id='cart_navigation']/button";
	public static final String orderConfirmationWindowHeader_xpath = "//h1";
}
