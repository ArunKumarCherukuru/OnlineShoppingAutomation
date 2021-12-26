package com.SampleFramework.testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SampleFramework.PageEvents.AuthenticationPageEvents;
import com.SampleFramework.PageEvents.HomePageEvents;
import com.SampleFramework.PageEvents.MyAccountPageEvents;
import com.SampleFramework.Utils.Constants;
import com.SampleFramework.Utils.ExcelUtils;

public class LoginTests extends BaseTest {
	HomePageEvents home = new HomePageEvents();
	AuthenticationPageEvents user = new AuthenticationPageEvents();
	ExcelUtils testData = new ExcelUtils();
	MyAccountPageEvents myAccount = new MyAccountPageEvents();

	@Test
	public void TC001VerifyLoginWithValidCredentials() {
		try {
			testData.setExcelFile(Constants.testDataFilePath, "Login");
			home.clickSignBtn();
			user.enterLoginEmailId(testData.getCellData(1, 1));
			user.enterLoginPassword(testData.getCellData(1, 2));
			user.clickSignInBtn();
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
