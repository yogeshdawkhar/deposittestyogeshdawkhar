package com.deposit.yogeshdawkhar.testcases;

import static io.restassured.RestAssured.get;

import java.io.IOException;
import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import com.deposit.yogeshdawkhar.constants.ErrorMessageContants;
import com.deposit.yogeshdawkhar.helper.HelperClass;
import com.deposit.yogeshdawkhar.page.AddNewUserPage;
import com.deposit.yogeshdawkhar.page.User;
import com.deposit.yogeshdawkhar.util.AssertionUtil;
import com.deposit.yogeshdawkhar.util.ExtentReportLog;
import com.deposit.yogeshdawkhar.util.GenerateUserDetails;
import com.deposit.yogeshdawkhar.util.UtililtyFunctions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;

public class GetUserTestCase extends HelperClass {
	@BeforeAll
	public static void setUp() {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200",
					"--ignore-certificate-errors");
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else {
			ExtentReportLog.testCaseSkip("Driver not initialised");
			System.exit(1);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

	@Test
	public void verifyAddedUserInAPIResponse() throws IOException {
		ExtentReportLog.testStart(UtililtyFunctions.getCurrentMethodName() + " On " + browser);
		driver.get(addUserUrl);
		ExtentReportLog.testCaseInfoWithImage("Entered URL: " + addUserUrl);
		User user = new GenerateUserDetails().addUserWithValidData();
		String nametext = user.getName();
		String emailtext = user.getEmail();
		String passwordtext = user.getPassword();
		String confirmpasswordtext = user.getConfirmationPassword();
		AddNewUserPage pageObj = PageFactory.initElements(driver, AddNewUserPage.class);
		pageObj.enterDetailsOnFormAndClickSubmit(nametext, emailtext, passwordtext, confirmpasswordtext);
		Response response = get(getAllUserUrlJson);
		ExtentReportLog.testCaseInfo("Response of Getalluserjson api: " + response.asString());

		AssertionUtil.assertEqualsWithOutImage(response.getContentType(), "application/json; charset=utf-8",
				ErrorMessageContants.GET_ALL_USER_API_CONTENT_TYPE_JSON_PRESENT,
				ErrorMessageContants.GET_ALL_USER_CONTENT_TYPE_JSON_NOT_PRESENT + response.getContentType());
		AssertionUtil.assertEqualsWithOutImage(response.getStatusCode(), 200,
				ErrorMessageContants.GET_ALL_USER_API_STATUS_CODE_200_PRESENT,
				ErrorMessageContants.GET_ALL_USER_API_STATUS_CODE_200_NOT_PRESENT + response.getStatusCode());

		/*
		 * AssertionUtil.assertEqualsWithOutImage(response.then().body("name",
		 * hasItem(nametext)).toString(), nametext,
		 * ErrorMessageContants.GET_ALL_USER_API_CONTENT_TYPE_JSON_PRESENT,
		 * ErrorMessageContants.GET_ALL_USER_CONTENT_TYPE_JSON_NOT_PRESENT +
		 * response.getContentType()); GetAllUserAPI apiobj =
		 * PageFactory.initElements(driver, GetAllUserAPI.class);
		 * 
		 * apiobj.verifyUserRecordInGetAllUsersAPI(nametext, emailtext, passwordtext);
		 */
	}

	@Test
	public void validateContentTypeandStatusCodeofgetAllUserAPI() {
		ExtentReportLog.testStart(UtililtyFunctions.getCurrentMethodName());
		Response response = get(getAllUserUrlJson);
		ExtentReportLog.testCaseInfo("Get all userjson API called. URL: " + getAllUserUrlJson);
		ExtentReportLog.testCaseInfo("Response of get all userjson API: " + response.asString());
		AssertionUtil.assertEqualsWithOutImage(response.getContentType(), "application/json; charset=utf-8",
				ErrorMessageContants.GET_ALL_USER_API_CONTENT_TYPE_JSON_PRESENT,
				ErrorMessageContants.GET_ALL_USER_CONTENT_TYPE_JSON_NOT_PRESENT);
		AssertionUtil.assertEqualsWithOutImage(response.getStatusCode(), 200,
				ErrorMessageContants.GET_ALL_USER_API_STATUS_CODE_200_PRESENT,
				ErrorMessageContants.GET_ALL_USER_API_STATUS_CODE_200_NOT_PRESENT);
	}

	@Test
	public void getHealthGetAllUserAPI() {
		ExtentReportLog.testStart(UtililtyFunctions.getCurrentMethodName());
		Response response = get(getAllUserUrlJson);
		ExtentReportLog.testCaseInfo("Get all userjson API called. URL: " + getAllUserUrlJson);
		AssertionUtil.assertEqualsWithOutImage(response.getStatusCode(), 200,
				ErrorMessageContants.GET_ALL_USER_API_STATUS_CODE_200_PRESENT,
				ErrorMessageContants.GET_ALL_USER_API_STATUS_CODE_200_NOT_PRESENT);
	}

	@AfterEach
	public void closeBrowser() {
		extent.endTest(extentTest);
		extent.flush();
	}
}
