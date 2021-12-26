package com.SampleFramework.Utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.SampleFramework.testScripts.*;

public class ElementFetch {
	public static WebElement getWebElement(String type, String identifierValue) {
		switch (type) {
		case "ID":
			return BaseTest.driver.findElement(By.id(identifierValue));
		case "XPATH":
			return BaseTest.driver.findElement(By.xpath(identifierValue));
		case "NAME":
			return BaseTest.driver.findElement(By.name(identifierValue));
		case "LinkText":
			return BaseTest.driver.findElement(By.linkText(identifierValue));
		case "PartialLinkText":
			return BaseTest.driver.findElement(By.partialLinkText(identifierValue));
		case "CSS":
			return BaseTest.driver.findElement(By.cssSelector(identifierValue));
		case "tagName":
			return BaseTest.driver.findElement(By.tagName(identifierValue));
		case "ClassName":
			return BaseTest.driver.findElement(By.className(identifierValue));
		default:
			return null;
		}
	}

	public static List<WebElement> getWebElements(String type, String identifierValue) {
		switch (type) {
		case "ID":
			return BaseTest.driver.findElements(By.id(identifierValue));
		case "Xpath":
			return BaseTest.driver.findElements(By.xpath(identifierValue));
		case "NAME":
			return BaseTest.driver.findElements(By.name(identifierValue));
		case "LinkText":
			return BaseTest.driver.findElements(By.linkText(identifierValue));
		case "PartialLinkText":
			return BaseTest.driver.findElements(By.partialLinkText(identifierValue));
		case "CSS":
			return BaseTest.driver.findElements(By.cssSelector(identifierValue));
		case "tagName":
			return BaseTest.driver.findElements(By.tagName(identifierValue));
		case "ClassName":
			return BaseTest.driver.findElements(By.className(identifierValue));
		default:
			return null;
		}
	}

	public static void scrollInto(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) BaseTest.driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
