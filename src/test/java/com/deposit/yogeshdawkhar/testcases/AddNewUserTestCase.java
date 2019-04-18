package com.deposit.yogeshdawkhar.testcases;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import com.deposit.yogeshdawkhar.constants.ErrorMessageContants;
import com.deposit.yogeshdawkhar.constants.LoggingMessageContants;
import com.deposit.yogeshdawkhar.constants.ValidationMessageContants;
import com.deposit.yogeshdawkhar.helper.HelperClass;
import com.deposit.yogeshdawkhar.page.AddNewUserPage;
import com.deposit.yogeshdawkhar.page.User;
import com.deposit.yogeshdawkhar.util.AssertionUtil;
import com.deposit.yogeshdawkhar.util.ExtentReportLog;
import com.deposit.yogeshdawkhar.util.GenerateUserDetails;
import com.deposit.yogeshdawkhar.util.UtililtyFunctions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddNewUserTestCase extends HelperClass {

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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

	@Test
	public void addUserWithOutName() throws IOException {
		ExtentReportLog.testStart(UtililtyFunctions.getCurrentMethodName() + " On " + browser);

		driver.get(addUserUrl);
		ExtentReportLog.testCaseInfoWithImage(LoggingMessageContants.ENTERED_URL + addUserUrl);

		User user = new GenerateUserDetails().addUserWithOutName();
		String nametext = user.getName();
		String emailtext = user.getEmail();
		String passwordtext = user.getPassword();
		String confirmpasswordtext = user.getConfirmationPassword();
		AddNewUserPage pageObj = PageFactory.initElements(driver, AddNewUserPage.class);
		pageObj.enterDetailsOnFormAndClickSubmit(nametext, emailtext, passwordtext, confirmpasswordtext);
		if (driver.getCurrentUrl().equalsIgnoreCase(addUserUrl)) {
			AssertionUtil.assertEquals(pageObj.usernameerrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					ErrorMessageContants.REQUIRED_PRESENT,
					pageObj.usernameerrorWebElement.getText() + ErrorMessageContants.ERROR_PRESENT);
		} else {
			AssertionUtil.assertFail(Thread.currentThread().getStackTrace()[1].getMethodName()
					+ LoggingMessageContants.UESR_REDIRECTED_TO + driver.getCurrentUrl());
		}
	}

	@Test
	public void addUserWithOutEmail() throws IOException {
		ExtentReportLog.testStart(UtililtyFunctions.getCurrentMethodName() + " On " + browser);

		driver.get(addUserUrl);
		ExtentReportLog.testCaseInfoWithImage(LoggingMessageContants.ENTERED_URL + addUserUrl);
		User user = new GenerateUserDetails().addUserWithOutEmail();
		String nametext = user.getName();
		String emailtext = user.getEmail();
		String passwordtext = user.getPassword();
		String confirmpasswordtext = user.getConfirmationPassword();
		AddNewUserPage pageObj = PageFactory.initElements(driver, AddNewUserPage.class);
		pageObj.enterDetailsOnFormAndClickSubmit(nametext, emailtext, passwordtext, confirmpasswordtext);
		if (driver.getCurrentUrl().equalsIgnoreCase(addUserUrl)) {
			AssertionUtil.assertEquals(pageObj.useremailerrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					ErrorMessageContants.ERROR_PRESENT,
					ValidationMessageContants.REQUIRED + ErrorMessageContants.ERROR_NOT_PRESENT);
		} else {
			AssertionUtil.assertFail(Thread.currentThread().getStackTrace()[1].getMethodName()
					+ LoggingMessageContants.UESR_REDIRECTED_TO + driver.getCurrentUrl());
		}
	}

	@Test
	public void addUserWithOutPassword() throws IOException {
		ExtentReportLog.testStart(UtililtyFunctions.getCurrentMethodName() + " On " + browser);

		driver.get(addUserUrl);
		ExtentReportLog.testCaseInfoWithImage(LoggingMessageContants.ENTERED_URL + addUserUrl);
		User user = new GenerateUserDetails().addUserWithOutPassword();
		String nametext = user.getName();
		String emailtext = user.getEmail();
		String passwordtext = user.getPassword();
		String confirmpasswordtext = user.getConfirmationPassword();
		AddNewUserPage pageObj = PageFactory.initElements(driver, AddNewUserPage.class);
		pageObj.enterDetailsOnFormAndClickSubmit(nametext, emailtext, passwordtext, confirmpasswordtext);
		if (driver.getCurrentUrl().equalsIgnoreCase(addUserUrl)) {
			AssertionUtil.assertEquals(pageObj.userpassworderrorWebElement.getText(),
					ValidationMessageContants.REQUIRED, ErrorMessageContants.REQUIRED_PRESENT,
					ErrorMessageContants.REQUIRED_NOT_PRESENT);
		} else {
			AssertionUtil.assertFail(Thread.currentThread().getStackTrace()[1].getMethodName()
					+ LoggingMessageContants.UESR_REDIRECTED_TO + driver.getCurrentUrl());
		}
	}

	@Test
	public void addUserWithOutConfirmPassword() throws IOException {
		ExtentReportLog.testStart(UtililtyFunctions.getCurrentMethodName() + " On " + browser);

		driver.get(addUserUrl);
		ExtentReportLog.testCaseInfoWithImage(LoggingMessageContants.ENTERED_URL + addUserUrl);
		User user = new GenerateUserDetails().addUserWithOutConfirmPassword();
		String nametext = user.getName();
		String emailtext = user.getEmail();
		String passwordtext = user.getPassword();
		String confirmpasswordtext = user.getConfirmationPassword();
		AddNewUserPage pageObj = PageFactory.initElements(driver, AddNewUserPage.class);
		pageObj.enterDetailsOnFormAndClickSubmit(nametext, emailtext, passwordtext, confirmpasswordtext);
		if (driver.getCurrentUrl().equalsIgnoreCase(addUserUrl)) {
			AssertionUtil.assertEquals(pageObj.userconfirmationPasswordErrorWebElement.getText(),
					ValidationMessageContants.PASSWO_NOT_SAME, ErrorMessageContants.PASSWO_NOT_SAME_PRESENT,
					ErrorMessageContants.PASSWO_NOT_SAME_NOT_PRESENT);
		} else {
			AssertionUtil.assertFail(Thread.currentThread().getStackTrace()[1].getMethodName()
					+ LoggingMessageContants.UESR_REDIRECTED_TO + driver.getCurrentUrl());
		}
	}

	@Test
	public void addUserWithOutAnyValue() throws IOException {
		ExtentReportLog.testStart(UtililtyFunctions.getCurrentMethodName() + " On " + browser);

		driver.get(addUserUrl);
		ExtentReportLog.testCaseInfoWithImage(LoggingMessageContants.ENTERED_URL + addUserUrl);
		User user = new GenerateUserDetails().addUserWithOutAnyValue();
		String nametext = user.getName();
		String emailtext = user.getEmail();
		String passwordtext = user.getPassword();
		String confirmpasswordtext = user.getConfirmationPassword();
		AddNewUserPage pageObj = PageFactory.initElements(driver, AddNewUserPage.class);
		pageObj.enterDetailsOnFormAndClickSubmit(nametext, emailtext, passwordtext, confirmpasswordtext);
		if (driver.getCurrentUrl().equalsIgnoreCase(addUserUrl)) {
			AssertionUtil.assertEquals(pageObj.usernameerrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					ErrorMessageContants.REQUIRED_PRESENT, ErrorMessageContants.REQUIRED_NOT_PRESENT);
			AssertionUtil.assertEquals(pageObj.useremailerrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					ErrorMessageContants.REQUIRED_PRESENT, ErrorMessageContants.REQUIRED_NOT_PRESENT);
			AssertionUtil.assertEquals(pageObj.userpassworderrorWebElement.getText(),
					ValidationMessageContants.REQUIRED, ErrorMessageContants.REQUIRED_PRESENT,
					ErrorMessageContants.REQUIRED_NOT_PRESENT);
		} else {
			AssertionUtil.assertFail(LoggingMessageContants.UESR_REDIRECTED_TO + driver.getCurrentUrl());
		}
	}

	@Test
	public void addUserWithMinPassword() throws IOException {
		ExtentReportLog.testStart(UtililtyFunctions.getCurrentMethodName() + " On " + browser);

		driver.get(addUserUrl);
		ExtentReportLog.testCaseInfoWithImage(LoggingMessageContants.ENTERED_URL + addUserUrl);
		User user = new GenerateUserDetails().addUserWithMinPassword();
		String nametext = user.getName();
		String emailtext = user.getEmail();
		String passwordtext = user.getPassword();
		String confirmpasswordtext = user.getConfirmationPassword();
		AddNewUserPage pageObj = PageFactory.initElements(driver, AddNewUserPage.class);
		pageObj.enterDetailsOnFormAndClickSubmit(nametext, emailtext, passwordtext, confirmpasswordtext);
		if (driver.getCurrentUrl().equalsIgnoreCase(addUserUrl)) {
			AssertionUtil.assertEquals(pageObj.userpassworderrorWebElement.getText(),
					ValidationMessageContants.MIN_PASSWO_SIZE, ErrorMessageContants.MIN_PASSWO_SIZE_PRESENT,
					ErrorMessageContants.MIN_PASSWO_SIZE_NOT_PRESENT);
		} else {
			AssertionUtil.assertFail(LoggingMessageContants.UESR_REDIRECTED_TO + driver.getCurrentUrl());
		}
	}

	@Test
	public void addUserWithDiffrentConfirmPasswordWithOtherValues() throws IOException {
		ExtentReportLog.testStart(UtililtyFunctions.getCurrentMethodName() + " On " + browser);

		driver.get(addUserUrl);
		ExtentReportLog.testCaseInfoWithImage(LoggingMessageContants.ENTERED_URL + addUserUrl);
		User user = new GenerateUserDetails().addUserWithDiffrentConfirmPasswordWithOtherValues();
		String nametext = user.getName();
		String emailtext = user.getEmail();
		String passwordtext = user.getPassword();
		String confirmpasswordtext = user.getConfirmationPassword();
		AddNewUserPage pageObj = PageFactory.initElements(driver, AddNewUserPage.class);
		pageObj.enterDetailsOnFormAndClickSubmit(nametext, emailtext, passwordtext, confirmpasswordtext);
		if (driver.getCurrentUrl().equalsIgnoreCase(addUserUrl)) {
			AssertionUtil.assertEquals(pageObj.userconfirmationPasswordErrorWebElement.getText(),
					ValidationMessageContants.PASSWO_NOT_SAME, ErrorMessageContants.PASSWO_NOT_SAME_PRESENT,
					ErrorMessageContants.PASSWO_NOT_SAME_NOT_PRESENT);
		} else {
			AssertionUtil.assertFail(LoggingMessageContants.UESR_REDIRECTED_TO + driver.getCurrentUrl());
		}
	}

	@Test
	public void addUserWithDiffrentConfirmPasswordWithoutOtherValues() throws IOException {
		ExtentReportLog.testStart(UtililtyFunctions.getCurrentMethodName() + " On " + browser);

		driver.get(addUserUrl);
		ExtentReportLog.testCaseInfoWithImage(LoggingMessageContants.ENTERED_URL + addUserUrl);
		User user = new GenerateUserDetails().addUserWithDiffrentConfirmPasswordWithoutOtherValues();
		String nametext = user.getName();
		String emailtext = user.getEmail();
		String passwordtext = user.getPassword();
		String confirmpasswordtext = user.getConfirmationPassword();
		AddNewUserPage pageObj = PageFactory.initElements(driver, AddNewUserPage.class);
		pageObj.enterDetailsOnFormAndClickSubmit(nametext, emailtext, passwordtext, confirmpasswordtext);
		if (driver.getCurrentUrl().equalsIgnoreCase(addUserUrl)) {
			AssertionUtil.assertEquals(pageObj.usernameerrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					ErrorMessageContants.INVALID_USER_NAME_PRESENT, ErrorMessageContants.INVALID_USER_NAME_NOT_PRESENT);
			AssertionUtil.assertEquals(pageObj.useremailerrorWebElement.getText(), ValidationMessageContants.REQUIRED,
					ErrorMessageContants.INVALID_EMAIL_ID_PRESENT, ErrorMessageContants.INVALID_EMAIL_ID_NOT_PRESENT);
			AssertionUtil.assertEquals(pageObj.userconfirmationPasswordErrorWebElement.getText(),
					ValidationMessageContants.PASSWO_NOT_SAME, ErrorMessageContants.PASSWO_NOT_SAME_PRESENT,
					ErrorMessageContants.PASSWO_NOT_SAME_NOT_PRESENT);
		} else {
			AssertionUtil.assertFail(LoggingMessageContants.UESR_REDIRECTED_TO + driver.getCurrentUrl());
		}
	}

	@ParameterizedTest
	@MethodSource("com.deposit.yogeshdawkhar.util.GenerateUserDetails#getInvalidEmailId")
	public void addUserWithInvalidEmailID(String nametext, String emailtext, String passwordtext,
			String confirmpasswordtext) throws IOException {
		ExtentReportLog.testStart(
				this.getClass().getSimpleName() + " -> " + Thread.currentThread().getStackTrace()[1].getMethodName());
		driver.get(addUserUrl);
		ExtentReportLog.testCaseInfoWithImage(LoggingMessageContants.ENTERED_URL + addUserUrl);
		AddNewUserPage pageObj = PageFactory.initElements(driver, AddNewUserPage.class);
		pageObj.enterDetailsOnFormAndClickSubmit(nametext, emailtext, passwordtext, confirmpasswordtext);
		if (pageObj.useremailerrorWebElement.getText().equalsIgnoreCase(ValidationMessageContants.INVALID_EMAIL_ID)) {
			ExtentReportLog.testCasePassWithImage("Test Pass for this data : " + emailtext
					+ ". This error Message Was present " + pageObj.useremailerrorWebElement.getText());
		} else {
			ExtentReportLog.testCaseFailWithImage("Test Failed for this data : " + emailtext
					+ ". This error Message Was present : " + pageObj.useremailerrorWebElement.getText());
		}
	}

	@ParameterizedTest
	@MethodSource("com.deposit.yogeshdawkhar.util.GenerateUserDetails#getValidEmailId")
	public void addUserWithValidEmailID(String nametext, String emailtext, String passwordtext,
			String confirmpasswordtext) throws IOException {
		ExtentReportLog.testStart(
				this.getClass().getSimpleName() + " -> " + Thread.currentThread().getStackTrace()[1].getMethodName());
		driver.get(addUserUrl);
		ExtentReportLog.testCaseInfoWithImage(LoggingMessageContants.ENTERED_URL + addUserUrl);
		AddNewUserPage pageObj = PageFactory.initElements(driver, AddNewUserPage.class);
		pageObj.enterDetailsOnFormAndClickSubmit(nametext, emailtext, passwordtext, confirmpasswordtext);
		if (driver.getCurrentUrl().equalsIgnoreCase(addUserUrl)) {
			ExtentReportLog.testCaseFailWithImage("Test failed for this data->" + emailtext
					+ " This error Message Was present " + pageObj.useremailerrorWebElement.getText());
		} else {
			ExtentReportLog.testCasePassWithImage("Test Pass for this data : " + emailtext + ".");
		}
	}

	@Test
	public void verifyNamePlaceHolder() throws IOException {
		ExtentReportLog.testStart(UtililtyFunctions.getCurrentMethodName() + " On " + browser);

		driver.get(addUserUrl);
		ExtentReportLog.testCaseInfoWithImage(LoggingMessageContants.ENTERED_URL + addUserUrl);
		AddNewUserPage pageObj = PageFactory.initElements(driver, AddNewUserPage.class);
		AssertionUtil.assertEquals(pageObj.placeHolderNameWebElement.getAttribute(pageObj.placeHolder),
				ValidationMessageContants.PLACEHOLDER_NAME, ErrorMessageContants.PLACEHOLDER_NAME_MESSAGE_PRESENT,
				ErrorMessageContants.PLACEHOLDER_NAME_MESSAGE_NOT_PRESENT);

	}

	@Test
	public void verifyEmailPlaceHolder() throws IOException {
		ExtentReportLog.testStart(UtililtyFunctions.getCurrentMethodName() + " On " + browser);

		driver.get(addUserUrl);
		ExtentReportLog.testCaseInfoWithImage(LoggingMessageContants.ENTERED_URL + addUserUrl);
		AddNewUserPage pageObj = PageFactory.initElements(driver, AddNewUserPage.class);
		AssertionUtil.assertEquals(pageObj.placeHolderEmailWebElement.getAttribute(pageObj.placeHolder),
				ValidationMessageContants.PLACEHOLDER_EMAIL, ErrorMessageContants.PLACEHOLDER_EMAIL_MESSAGE_PRESENT,
				ErrorMessageContants.PLACEHOLDER_EMAIL_MESSAGE_NOT_PRESENT);
	}

	@Test
	public void verifyPasswordPlaceHolder() throws IOException {
		ExtentReportLog.testStart(UtililtyFunctions.getCurrentMethodName() + " On " + browser);

		driver.get(addUserUrl);
		ExtentReportLog.testCaseInfoWithImage(LoggingMessageContants.ENTERED_URL + addUserUrl);
		AddNewUserPage pageObj = PageFactory.initElements(driver, AddNewUserPage.class);
		AssertionUtil.assertEquals(pageObj.placeHolderPasswordWebElement.getAttribute(pageObj.placeHolder),
				ValidationMessageContants.PLACEHOLDER_PASSWO, ErrorMessageContants.PLACEHOLDER_PASSWO_MESSAGE_PRESENT,
				ErrorMessageContants.PLACEHOLDER_PASSWO_MESSAGE_NOT_PRESENT);
	}

	@Test
	public void verifyConfirmPasswordPlaceHolder() throws IOException {
		ExtentReportLog.testStart(UtililtyFunctions.getCurrentMethodName() + " On " + browser);

		driver.get(addUserUrl);
		ExtentReportLog.testCaseInfoWithImage(LoggingMessageContants.ENTERED_URL + addUserUrl);
		AddNewUserPage pageObj = PageFactory.initElements(driver, AddNewUserPage.class);
		AssertionUtil.assertEquals(pageObj.placeHolderConfirmationPasswordWebElement.getAttribute(pageObj.placeHolder),
				ValidationMessageContants.PLACEHOLDER_CONFIRM_PASSWO,
				ErrorMessageContants.PLACEHOLDER_CONFIRM_PASSWO_MESSAGE_PRESENT,
				ErrorMessageContants.PLACEHOLDER_CONFIRM_PASSWO_MESSAGE_NOT_PRESENT);
	}

	@Test
	public void addUserWithValidData() throws IOException {
		ExtentReportLog.testStart(UtililtyFunctions.getCurrentMethodName() + " On " + browser);

		driver.get(addUserUrl);
		ExtentReportLog.testCaseInfoWithImage(LoggingMessageContants.ENTERED_URL + addUserUrl);
		User user = new GenerateUserDetails().addUserWithValidData();
		String nametext = user.getName();
		String emailtext = user.getEmail();
		String passwordtext = user.getPassword();
		String confirmpasswordtext = user.getConfirmationPassword();
		AddNewUserPage pageObj = PageFactory.initElements(driver, AddNewUserPage.class);
		pageObj.enterDetailsOnFormAndClickSubmit(nametext, emailtext, passwordtext, confirmpasswordtext);
		if (driver.getCurrentUrl().equalsIgnoreCase(addUserUrl)) {
			ExtentReportLog.testCaseFailWithImage("Test Failed : ");
		} else {
			AssertionUtil.assertEqualsWithOutImage(driver.getCurrentUrl(), getAllUserUrl, "User added", "failMessage");

		}
	}

	@Test
	public void addSameUserWithValidData() throws IOException {
		ExtentReportLog.testStart(UtililtyFunctions.getCurrentMethodName() + " On " + browser);

		driver.get(addUserUrl);
		ExtentReportLog.testCaseInfoWithImage(LoggingMessageContants.ENTERED_URL + addUserUrl);
		User user = new GenerateUserDetails().addUserWithValidData();
		String nametext = user.getName();
		String emailtext = user.getEmail();
		String passwordtext = user.getPassword();
		String confirmpasswordtext = user.getConfirmationPassword();
		AddNewUserPage pageObj = PageFactory.initElements(driver, AddNewUserPage.class);
		driver.get(addUserUrl);
		pageObj.enterDetailsOnFormAndClickSubmit(nametext, emailtext, passwordtext, confirmpasswordtext);
		if (driver.getCurrentUrl().equalsIgnoreCase(addUserUrl)) {
			ExtentReportLog.testCaseFailWithImage("Test Failed : ");
		}
		pageObj.newuserbuttonWebElement.click();
		pageObj.enterDetailsOnFormAndClickSubmit(nametext, emailtext, passwordtext, confirmpasswordtext);
		AssertionUtil.assertEquals(driver.getCurrentUrl(), addUserUrl, "User is on correct URL" + addUserUrl,
				"User is on diffrent URL:" + driver.getCurrentUrl());
		AssertionUtil.assertEquals(pageObj.usernameerrorWebElement.getText(), ValidationMessageContants.MUST_BE_UNIQUE,
				ErrorMessageContants.MUST_BE_UNIQUE_PRESENT, ErrorMessageContants.MUST_BE_UNIQUE_NOT_PRESENT);
		AssertionUtil.assertEquals(pageObj.useremailerrorWebElement.getText(), ValidationMessageContants.MUST_BE_UNIQUE,
				ErrorMessageContants.MUST_BE_UNIQUE_PRESENT, ErrorMessageContants.MUST_BE_UNIQUE_NOT_PRESENT);
	}

	@Test
	public void verifyAddedUserOnUI() throws IOException {
		ExtentReportLog.testStart(
				this.getClass().getSimpleName() + " -> " + Thread.currentThread().getStackTrace()[1].getMethodName());
		driver.get(addUserUrl);
		ExtentReportLog.testCaseInfoWithImage(LoggingMessageContants.ENTERED_URL + addUserUrl);
		User user = new GenerateUserDetails().addUserWithValidData();
		String nametext = user.getName();
		String emailtext = user.getEmail();
		String passwordtext = user.getPassword();
		String confirmpasswordtext = user.getConfirmationPassword();
		AddNewUserPage pageObj = PageFactory.initElements(driver, AddNewUserPage.class);
		pageObj.enterDetailsOnFormAndClickSubmit(nametext, emailtext, passwordtext, confirmpasswordtext);

		Long id = pageObj.GetrecordID(nametext);
		driver.navigate().to(getAllUserUrl);
		List<WebElement> rowCount1 = driver.findElements(By.xpath("//tr[@id='" + id + "']/td"));
		AssertionUtil.assertEquals(rowCount1.get(0).getText(), nametext,
				LoggingMessageContants.EXPECTED_ELEMENT_PRESENT,
				LoggingMessageContants.EXPECTED_ELEMENT_NOT_PRESENT + nametext);
		AssertionUtil.assertEquals(rowCount1.get(1).getText(), emailtext,
				LoggingMessageContants.EXPECTED_ELEMENT_PRESENT,
				LoggingMessageContants.EXPECTED_ELEMENT_NOT_PRESENT + emailtext);
		AssertionUtil.assertEquals(rowCount1.get(2).getText(), passwordtext,
				LoggingMessageContants.EXPECTED_ELEMENT_PRESENT,
				LoggingMessageContants.EXPECTED_ELEMENT_NOT_PRESENT + passwordtext);
	}

	@Test
	public void verifyPageTitleGetAllUser() {
		ExtentReportLog.testStart(UtililtyFunctions.getCurrentMethodName() + " On " + browser);

		driver.get(getAllUserUrl);
		AssertionUtil.assertEqualsWithOutImage(driver.getTitle(), ValidationMessageContants.ALL_USER_PAGE_TITLE,
				driver.getTitle() + " Title present", driver.getTitle() + " Expected Title not present");
	}

	@Test
	public void VerifyPageTitleofAddNewUserPage() {
		ExtentReportLog.testStart(UtililtyFunctions.getCurrentMethodName() + " On " + browser);

		driver.get(addUserUrl);
		AssertionUtil.assertEqualsWithOutImage(driver.getTitle(), ValidationMessageContants.ADD_NEW_USER_PAGE_TITLE,
				driver.getTitle() + " Title present", driver.getTitle() + " Expected Title not present");
	}

	@Test
	public void VerifyAllUserButton() throws IOException {
		ExtentReportLog.testStart(UtililtyFunctions.getCurrentMethodName() + " On " + browser);

		driver.get(addUserUrl);
		AddNewUserPage pageObj = PageFactory.initElements(driver, AddNewUserPage.class);
		AssertionUtil.assertEquals(pageObj.allUserBtn.getText(), ValidationMessageContants.NEW_USER_BUTTON_ALL_USER,
				pageObj.allUserBtn.getText() + LoggingMessageContants.EXPECTED_BUTTON_PRESENT,
				pageObj.allUserBtn.getText() + LoggingMessageContants.EXPECTED_BUTTON_NOT_PRESENT);
	}

	@AfterEach
	public void closeBrowser() {
		extent.endTest(extentTest);
		extent.flush();
	}
}
