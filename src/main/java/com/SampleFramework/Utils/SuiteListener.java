package com.SampleFramework.Utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.SampleFramework.testScripts.BaseTest;

public class SuiteListener implements ITestListener, IAnnotationTransformer {

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		String fileName = System.getProperty("user.dir") + File.separator + "screenshot" + File.separator
				+ iTestResult.getMethod().getMethodName();
		File f = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(f, new File(fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor aConstructor, Method method) {
		iTestAnnotation.setRetryAnalyzer(RetryAnalyser.class);
	}

}
