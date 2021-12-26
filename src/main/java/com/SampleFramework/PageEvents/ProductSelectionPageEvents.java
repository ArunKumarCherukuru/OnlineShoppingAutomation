package com.SampleFramework.PageEvents;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SampleFramework.PageObjects.ProductSelectionPageObject;
import com.SampleFramework.Utils.ElementFetch;
import com.SampleFramework.testScripts.BaseTest;

public class ProductSelectionPageEvents {
	public void selectProductCategory(String category) {
		BaseTest.logger.info("Selecting Product Categoty");
		ElementFetch.getWebElement("XPATH", ProductSelectionPageObject.productCategory_xpath.replace("var", category))
				.click();
	}

	public void selectProdcut(String productName) {
		WebElement product = ElementFetch.getWebElement("XPATH",
				ProductSelectionPageObject.productImage_xpath.replace("var", productName));
		BaseTest.logger.info("Selecting Product");
		Actions action = new Actions(BaseTest.driver);
		action.moveToElement(product).perform();

	}

	public void clickAddToCartBtn() {
		BaseTest.logger.info("Clicked on Add to Cart button");
		WebDriverWait wait = new WebDriverWait(BaseTest.driver, 20);
		wait.until(ExpectedConditions
				.visibilityOf(ElementFetch.getWebElement("XPATH", ProductSelectionPageObject.addToCartBtn_xpath)));
		ElementFetch.getWebElement("XPATH", ProductSelectionPageObject.addToCartBtn_xpath).click();
	}

	public String getProdcutAddSuccessmessage() {
		WebDriverWait wait = new WebDriverWait(BaseTest.driver, 20);
		wait.until(ExpectedConditions
				.visibilityOf(ElementFetch.getWebElement("XPATH", ProductSelectionPageObject.SuccessMsg_xpath)));
		String msg = ElementFetch.getWebElement("XPATH", ProductSelectionPageObject.SuccessMsg_xpath).getText();
		return msg;
	}

	public void clickProceedTocheckoutBtn() {
		ElementFetch.getWebElement("XPATH", ProductSelectionPageObject.proceedtoCheckoutBtn_xpath).click();
	}
}