package com.SampleFramework.testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SampleFramework.PageEvents.AuthenticationPageEvents;
import com.SampleFramework.PageEvents.HomePageEvents;
import com.SampleFramework.PageEvents.MyAccountPageEvents;
import com.SampleFramework.Utils.Constants;
import com.SampleFramework.Utils.ExcelUtils;

public class RegistrationTests extends BaseTest {
	HomePageEvents home = new HomePageEvents();
	AuthenticationPageEvents user = new AuthenticationPageEvents();
	ExcelUtils testData = new ExcelUtils();
	MyAccountPageEvents myAccount = new MyAccountPageEvents();

	@Test(priority = 1)
	public void TC001VerifyUserRegistration() {
		try {
			testData.setExcelFile(Constants.testDataFilePath, "Registration");
			home.clickSignBtn();
			user.enterEmailAddress(testData.getCellData(1, 1));
			user.clickCreateAccountBtn();
			String title = testData.getCellData(1, 2);

			user.selectTitle(title);
			user.selectEnterFirstName(testData.getCellData(1, 3));
			user.selectEnterLasttName(testData.getCellData(1, 4));
			user.selectEnterPassword(testData.getCellData(1, 5));
			String dob = testData.getCellData(1, 6);
			String a[] = dob.split("/");
			user.selectDateofBirth(a[0], a[1], a[2]);
			Thread.sleep(10000);
			user.enterFirstInAdress(testData.getCellData(1, 7));
			user.enterLasttInAdress(testData.getCellData(1, 8));
			user.enterAdress(testData.getCellData(1, 9));
			user.enterCity(testData.getCellData(1, 10));
			user.selectState(testData.getCellData(1, 11));
			user.enterZipCode(testData.getCellDataNumericValue(1, 12));
			user.enterMobileNumber(testData.getCellDataNumericValue(1, 13));
			Thread.sleep(10000);
			user.clickRegisterBtn();
			Thread.sleep(20000);
			boolean flag = myAccount.getPageHeader().equalsIgnoreCase("My Account");
			Assert.assertTrue(flag);
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
