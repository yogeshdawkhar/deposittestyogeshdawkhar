package com.deposit.yogeshdawkhar.page;

import static io.restassured.RestAssured.get;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.deposit.yogeshdawkhar.helper.HelperClass;
import com.deposit.yogeshdawkhar.util.ExtentReportLog;
import com.deposit.yogeshdawkhar.util.UtililtyFunctions;

import io.restassured.response.Response;

public class AddNewUserPage extends HelperClass {
	@FindBy(how = How.ID, using = "name")
	public WebElement nameWebElement;
	@FindBy(how = How.ID, using = "email")
	public WebElement emailWebElement;
	@FindBy(how = How.ID, using = "password")
	public WebElement passwordWebElement;
	@FindBy(how = How.ID, using = "confirmationPassword")
	public WebElement confirmationPasswordWebElement;
	@FindBy(how = How.XPATH, using = "/html/body/div/div/div/form/fieldset/div[5]/button")
	public WebElement submitWebElement;
	@FindBy(how = How.ID, using = "user.name.error")
	public WebElement usernameerrorWebElement;
	@FindBy(how = How.ID, using = "user.email.error")
	public WebElement useremailerrorWebElement;
	@FindBy(how = How.ID, using = "user.password.error")
	public WebElement userpassworderrorWebElement;
	@FindBy(how = How.ID, using = "user.confirmationPassword.error")
	public WebElement userconfirmationPasswordErrorWebElement;
	@FindBy(how = How.LINK_TEXT, using = "New User")
	public WebElement newuserbuttonWebElement;
	@FindBy(how = How.CSS, using = "#name")
	public WebElement placeHolderNameWebElement;
	@FindBy(how = How.CSS, using = "#email")
	public WebElement placeHolderEmailWebElement;
	@FindBy(how = How.CSS, using = "#password")
	public WebElement placeHolderPasswordWebElement;
	@FindBy(how = How.CSS, using = "#confirmationPassword")
	public WebElement placeHolderConfirmationPasswordWebElement;
	@FindBy(how = How.LINK_TEXT, using ="All User")
	public WebElement allUserBtn;
	@FindBy(how = How.LINK_TEXT, using ="Submit")
	public WebElement submitBtn;
	
    public String placeHolder="placeholder";
	public AddNewUserPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterDetailsOnFormAndClickSubmit(String nametext, String emailtext, String passwordtext,
			String confirmpasswordtext) throws IOException {
		nameWebElement.clear();
		nameWebElement.sendKeys(nametext);
		ExtentReportLog.testCaseInfo("Entered Value in Name field" + nametext);
		
		emailWebElement.clear();
		emailWebElement.sendKeys(emailtext);
		ExtentReportLog.testCaseInfo("Entered Value in Email field" + emailtext);
		passwordWebElement.clear();
		passwordWebElement.sendKeys(passwordtext);
		ExtentReportLog.testCaseInfo("Entered Value in Password field" + passwordtext);
		confirmationPasswordWebElement.clear();
		confirmationPasswordWebElement.sendKeys(confirmpasswordtext);
		ExtentReportLog.testCaseInfo("Entered Value in Confirmation Password field" + confirmpasswordtext);
		submitWebElement.click();
		ExtentReportLog.testCaseInfoWithImage("Submit Button clicked");
	}

	public long GetrecordID(String findRecord) {
		Long id = null;
		Response response = get(getAllUserUrlJson);
		JSONArray ja = new JSONArray(response.asString());
		for (int i = 0; i < ja.length(); i++) {
			JSONObject jo = ja.getJSONObject(i);
			if (jo.getString("name").equals(findRecord)) {
				id = jo.getLong("id");
				break;
			}
		}
		return id;
	}
	
	/*
	 * public boolean isUserEmailErrorExists(){ return
	 * UtililtyFunctions.isElementExists(userEmailError); }
	 */
	
	public boolean isCurrentUrlSame(String url){
		return UtililtyFunctions.isCurrentUrlSame(url);
	}
	
	public boolean isCurrentUrlDiffrent(String url){
		return UtililtyFunctions.isCurrentUrlDiffrent(url);
	}
	
}
