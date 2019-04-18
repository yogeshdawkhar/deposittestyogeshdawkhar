package com.deposit.yogeshdawkhar.util;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;

public class AssertionUtil {
	public static void assertNotEquals(String feildText, String validationMessage, String errorMessage) throws IOException {
		if (feildText.equals(validationMessage)) {
			ExtentReportLog.testCaseFailWithImage(errorMessage);
		}
		Assertions.assertNotEquals(feildText, validationMessage);
	}

	public static void assertNotEquals(Long id, String errorMessage) throws IOException {
		if (id == null) {
			ExtentReportLog.testCaseFailWithImage(errorMessage);
		}
		Assertions.assertNotEquals(null,id);
	}

	public static void assertEquals(String feildText, String validationMessage, String infoMessage,
			String failMessage) throws IOException {
		if (feildText.equals(validationMessage)) {
			ExtentReportLog.testCaseInfoWithImage(infoMessage);
		} else {
			ExtentReportLog.testCaseFailWithImage(failMessage);
		}
		Assertions.assertEquals(feildText, validationMessage);
	}

	public static void assertEqualsWithOutImage(String actual, String expected, String infoMessage,
			String failMessage) {
		if (actual.equals(expected)) {
			ExtentReportLog.testCasePass(infoMessage);
		} else {
			ExtentReportLog.testCaseFail(failMessage);
		}
		Assertions.assertEquals(actual, expected);
	}

	public static void assertFail(String failMessage) throws IOException {
		ExtentReportLog.testCaseFailWithImage(failMessage);
		Assertions.fail(failMessage);
	}

	public static void assertEqualsWithOutImage(int statusCode, int validationCode, String infoMessage,
			String failMessage) {
		if (statusCode == validationCode) {
			ExtentReportLog.testCasePass(infoMessage);
		} else {
			ExtentReportLog.testCaseFail(failMessage);
		}
		Assertions.assertEquals(statusCode, validationCode);
	}
}
