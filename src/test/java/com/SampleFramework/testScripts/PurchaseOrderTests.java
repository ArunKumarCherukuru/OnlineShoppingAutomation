package com.SampleFramework.testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SampleFramework.PageEvents.AuthenticationPageEvents;
import com.SampleFramework.PageEvents.HomePageEvents;
import com.SampleFramework.PageEvents.MyAccountPageEvents;
import com.SampleFramework.PageEvents.ProductCartSummaryPageEvents;
import com.SampleFramework.PageEvents.ProductSelectionPageEvents;
import com.SampleFramework.Utils.Constants;
import com.SampleFramework.Utils.ExcelUtils;

public class PurchaseOrderTests extends BaseTest {
	HomePageEvents home = new HomePageEvents();
	AuthenticationPageEvents user = new AuthenticationPageEvents();
	ExcelUtils testData = new ExcelUtils();
	ProductCartSummaryPageEvents summary = new ProductCartSummaryPageEvents();

	MyAccountPageEvents myAccount = new MyAccountPageEvents();
	ProductSelectionPageEvents productSelection = new ProductSelectionPageEvents();

	@Test(dependsOnMethods = { "com.SampleFramework.testScripts.LoginTests.TC001VerifyLoginWithValidCredentials" })
	public void TC001_verifyUserselectTheRequiredProduct() {
		try {
			testData.setExcelFile(Constants.testDataFilePath, "Product Selection");
			home.clickSignBtn();
			user.enterLoginEmailId(testData.getCellData(1, 1));
			user.enterLoginPassword(testData.getCellData(1, 2));
			user.clickSignInBtn();
			productSelection.selectProductCategory(testData.getCellData(1, 3));
			productSelection.selectProdcut(testData.getCellData(1, 4));
			productSelection.clickAddToCartBtn();
			String expectedMessage = "successfully added to your shopping cart";
			String actualMessage = productSelection.getProdcutAddSuccessmessage();
			boolean flag = actualMessage.contains(expectedMessage);
			Assert.assertTrue(flag);

		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void TC002_VerifyDeliveryAddress() {
		try {
			testData.setExcelFile(Constants.testDataFilePath, "Product Selection");
			home.clickSignBtn();
			user.enterLoginEmailId(testData.getCellData(1, 1));
			user.enterLoginPassword(testData.getCellData(1, 2));
			user.clickSignInBtn();
			productSelection.selectProductCategory(testData.getCellData(1, 3));
			productSelection.selectProdcut(testData.getCellData(1, 4));
			productSelection.clickAddToCartBtn();
			productSelection.clickProceedTocheckoutBtn();
			summary.clickProceedTocheckoutBtn();
			Thread.sleep(2000);
			testData.setExcelFile(Constants.testDataFilePath, "Registration");
			String expectedName = testData.getCellData(1, 7) + testData.getCellData(1, 7) + " "
					+ testData.getCellData(1, 8) + testData.getCellData(1, 8);
			String expectedAddress = testData.getCellData(1, 9);
			String expectedCityStateAndPost = testData.getCellData(1, 10) + "," + " " + testData.getCellData(1, 11)
					+ " " + Integer.toString(testData.getCellDataNumericValue(1, 12));
			;
			String expectedCountry = testData.getCellData(1, 14);
			String expectedMobile = Integer.toString(testData.getCellDataNumericValue(1, 13));

			String actualName = summary.getName();
			String actualAddress = summary.getAddress();
			String actualCityStateAndPost = summary.getCityStateAndPost();
			String actualCountry = summary.getCountry();
			String actualMobile = summary.getMobile();

			Assert.assertEquals(actualName, expectedName);
			Assert.assertEquals(actualAddress, expectedAddress);
			Assert.assertEquals(actualCityStateAndPost, expectedCityStateAndPost);
			Assert.assertEquals(actualCountry, expectedCountry);
			Assert.assertEquals(actualMobile, expectedMobile);
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	public void TC003_VerifyPurchaseOrder() {
		try {
			testData.setExcelFile(Constants.testDataFilePath, "Product Selection");
			home.clickSignBtn();
			user.enterLoginEmailId(testData.getCellData(1, 1));
			user.enterLoginPassword(testData.getCellData(1, 2));
			user.clickSignInBtn();
			productSelection.selectProductCategory(testData.getCellData(1, 3));
			productSelection.selectProdcut(testData.getCellData(1, 4));
			productSelection.clickAddToCartBtn();
			productSelection.clickProceedTocheckoutBtn();
			summary.clickProceedTocheckoutBtn();
			summary.ClickProceedBtnOnAddresstab();
			summary.ClickAgreementCheckbox();
			summary.ClickOnShippingCheckoutBtn();
			summary.selectPayByBankWire();
			summary.clickConfirmOrder();
			System.out.println("##### Title of the window" + summary.getOrderConfirmationWindowTitle());
			Assert.assertEquals(summary.getOrderConfirmationWindowTitle(), "ORDER CONFIRMATION");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
