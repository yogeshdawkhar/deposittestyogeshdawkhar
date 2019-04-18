package com.deposit.yogeshdawkhar.testcases;

import static io.restassured.RestAssured.delete;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.deposit.yogeshdawkhar.constants.ErrorMessageContants;
import com.deposit.yogeshdawkhar.helper.HelperClass;
import com.deposit.yogeshdawkhar.util.AssertionUtil;
import com.deposit.yogeshdawkhar.util.ExtentReportLog;
import com.deposit.yogeshdawkhar.util.UtililtyFunctions;

import io.restassured.response.Response;

public class DeleteUserTestCase extends HelperClass {

	@Test
	public void validateContentTypeandStatusCodeofdeleteAllUserAPI() {
		ExtentReportLog.testStart(UtililtyFunctions.getCurrentMethodName());
				
		Response response = delete(deleteAllUserUrl);
		ExtentReportLog.testCaseInfo("Delete all user API called. URL: " + deleteAllUserUrl);
		AssertionUtil.assertEqualsWithOutImage(response.asString(), "",
				ErrorMessageContants.DELETE_API_EMPTY_RESPONSE_PRESENT,
				ErrorMessageContants.DELETE_API_EMPTY_RESPONSE_NOT_PRESENT + response.asString());
		AssertionUtil.assertEqualsWithOutImage(response.getContentType(), "text/plain; charset=utf-8",	
				ErrorMessageContants.DELETE_API_CONTENT_TYPE_TEXT_PLAIN_PRESENT,
				ErrorMessageContants.DELETE_API_CONTENT_TYPE_TEXT_PLAIN_NOT_PRESENT + response.getContentType());
		AssertionUtil.assertEqualsWithOutImage(response.getStatusCode(), 200,
				ErrorMessageContants.DELETE_API_STATUS_CODE_200_PRESENT,
				ErrorMessageContants.DELETE_API_STATUS_CODE_200_NOT_PRESENT + response.getStatusCode());
	}

	@Test
	public void getHealthDeleteAllUserAPI() {
		ExtentReportLog.testStart(UtililtyFunctions.getCurrentMethodName());
				
		Response response = delete(deleteAllUserUrl);
		ExtentReportLog.testCaseInfo("Delete all user API called. URL: " + deleteAllUserUrl);
		ExtentReportLog.testCaseInfo("Status Code of delete all user API is : " + response.getStatusCode());
		AssertionUtil.assertEqualsWithOutImage(response.getStatusCode(), 200,
				ErrorMessageContants.DELETE_API_STATUS_CODE_200_PRESENT,
				ErrorMessageContants.DELETE_API_STATUS_CODE_200_NOT_PRESENT + response.getStatusCode());
	}

	@AfterEach
	public void endTest() {
		extent.endTest(extentTest);
		extent.flush();
	}
}
