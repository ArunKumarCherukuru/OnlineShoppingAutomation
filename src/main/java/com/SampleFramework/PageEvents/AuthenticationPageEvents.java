package com.SampleFramework.PageEvents;

import org.openqa.selenium.support.ui.Select;

import com.SampleFramework.PageObjects.AuthenticationPageObjects;
import com.SampleFramework.Utils.ElementFetch;
import com.SampleFramework.testScripts.BaseTest;

public class AuthenticationPageEvents {

	public void enterEmailAddress(String emailId) {
		ElementFetch.getWebElement("ID", AuthenticationPageObjects.email_id).clear();
		ElementFetch.getWebElement("ID", AuthenticationPageObjects.email_id).sendKeys(emailId);
	}

	public void clickCreateAccountBtn() {
		ElementFetch.getWebElement("ID", AuthenticationPageObjects.createAccountBtn_id).click();
	}

	public void selectTitle(String gender) {
		if (gender.contains("Mr."))
			ElementFetch.getWebElement("ID", AuthenticationPageObjects.titleMrRadioBtn).click();
		else
			ElementFetch.getWebElement("ID", AuthenticationPageObjects.titleMrsRadioBtn).click();
	}

	public void selectEnterFirstName(String firstName) {
		ElementFetch.getWebElement("NAME", AuthenticationPageObjects.firstName_name).sendKeys(firstName);
	}

	public void selectEnterLasttName(String lastName) {
		ElementFetch.getWebElement("ID", AuthenticationPageObjects.lastName_id).sendKeys(lastName);
	}

	public void selectEnterPassword(String password) {
		ElementFetch.getWebElement("ID", AuthenticationPageObjects.password_id).sendKeys(password);
	}

	public void selectDateofBirth(String date, String month, String year) {
		Select selectDt = new Select(ElementFetch.getWebElement("XPATH", AuthenticationPageObjects.dateDD_xpath));
		selectDt.selectByValue(date);

		Select selectMonth = new Select(ElementFetch.getWebElement("XPATH", AuthenticationPageObjects.monthsDD_xpath));
		selectMonth.selectByValue(month);

		Select selectYear = new Select(ElementFetch.getWebElement("XPATH", AuthenticationPageObjects.yearDD_xpath));
		selectYear.selectByValue(year);
	}

	public void enterFirstInAdress(String firstName) {
		ElementFetch.scrollInto(ElementFetch.getWebElement("ID", AuthenticationPageObjects.firstNameInAddress_id));
		ElementFetch.getWebElement("ID", AuthenticationPageObjects.firstNameInAddress_id).sendKeys(firstName);
	}

	public void enterLasttInAdress(String lastName) {
		ElementFetch.getWebElement("ID", AuthenticationPageObjects.lastNameInAddress_id).sendKeys(lastName);
	}

	public void enterAdress(String address) {
		ElementFetch.getWebElement("ID", AuthenticationPageObjects.address_id).sendKeys(address);
	}

	public void selectState(String state) {
		Select selectState = new Select(ElementFetch.getWebElement("ID", AuthenticationPageObjects.stateDD_id));
		selectState.selectByVisibleText(state);
	}

	public void enterZipCode(int code) {
		ElementFetch.getWebElement("ID", AuthenticationPageObjects.zipCode_id).sendKeys(Integer.toString(code));
	}

	public void enterMobileNumber(int number) {
		ElementFetch.getWebElement("ID", AuthenticationPageObjects.mobileNumber_id).sendKeys(Integer.toString(number));
	}

	public void clickRegisterBtn() {
		ElementFetch.getWebElement("ID", AuthenticationPageObjects.registerBtn_ID).click();
	}

	public void enterCity(String city) {
		ElementFetch.getWebElement("ID", AuthenticationPageObjects.city_id).sendKeys(city);
	}

	public void enterLoginEmailId(String id) {
		BaseTest.logger.info("Entering Email Address");
		ElementFetch.getWebElement("XPATH", AuthenticationPageObjects.loginEmail_xpath).sendKeys(id);
	}

	public void enterLoginPassword(String pwd) {
		BaseTest.logger.info("Entering Password");
		ElementFetch.getWebElement("XPATH", AuthenticationPageObjects.loginPassword_xpath).sendKeys(pwd);
	}

	public void clickSignInBtn() {
		ElementFetch.getWebElement("XPATH", AuthenticationPageObjects.signInBtn_xpath).click();
	}

	public void dummyMethod() {
		//This is dummy method added to check git local branching concepts
	}
}