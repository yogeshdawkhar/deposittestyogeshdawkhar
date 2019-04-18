package com.deposit.yogeshdawkhar.util;

import java.io.IOException;

import com.deposit.yogeshdawkhar.helper.HelperClass;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportLog extends HelperClass {

	public static void testCaseFailWithImage(String logmessage) throws IOException {
		extentTest.log(LogStatus.FAIL, logmessage
				+ extentTest.addScreenCapture(extentReportImagePathForHTML + ScreenshotUtil.createimagename() + ".png"));
	}

	public static void testCaseFail(String logmessage) {
		extentTest.log(LogStatus.FAIL, logmessage);
	}

	public static void testCaseInfoWithImage(String logmessage) throws IOException {
		extentTest.log(LogStatus.INFO, logmessage
				+ extentTest.addScreenCapture(extentReportImagePathForHTML + ScreenshotUtil.createimagename() + ".png"));
	}

	public static void testCaseInfo(String logmessage) {
		extentTest.log(LogStatus.INFO, logmessage);
	}

	public static void testCasePassWithImage(String logmessage) throws IOException {
		extentTest.log(LogStatus.PASS, logmessage
				+ extentTest.addScreenCapture(extentReportImagePathForHTML + ScreenshotUtil.createimagename() + ".png"));
	}

	public static void testCasePass(String logmessage) {
		extentTest.log(LogStatus.PASS, logmessage);
	}

	public static void testCaseSkipWithImage(String logmessage) throws IOException {
		extentTest.log(LogStatus.SKIP, logmessage
				+ extentTest.addScreenCapture(extentReportImagePathForHTML + ScreenshotUtil.createimagename() + ".png"));
	}

	public static void testCaseSkip(String logmessage) {
		extentTest.log(LogStatus.SKIP, logmessage);
	}

	public static void testStart(String logmessage) {
		extentTest = extent.startTest(logmessage);
	}
}
