package com.deposit.yogeshdawkhar.page;

import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.hasItem;

import com.deposit.yogeshdawkhar.helper.HelperClass;
import com.deposit.yogeshdawkhar.util.ExtentReportLog;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllUserAPI extends HelperClass {

	public void verifyUserRecordInGetAllUsersAPI(String nameText, String emailtext, String passwordtext) {
		Response response = get(getAllUserUrlJson);
		ExtentReportLog.testCaseInfo("Response of Getalluserjson api: " + response.asString());
		response.then().body("name", hasItem(nameText)).body("email", hasItem(emailtext))
				.body("password", hasItem(passwordtext)).contentType(ContentType.JSON).statusCode(200);
	}
}
