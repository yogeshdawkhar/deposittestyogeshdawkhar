package com.deposit.yogeshdawkhar.helper;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class HelperClass {
	public static WebDriver driver;
	protected static String browser = "chrome";
	protected static String baseURL="http://85.93.17.135:9000";
	protected static String addUserUrl = baseURL+"/user/new";
	protected static String getAllUserUrl = baseURL+"/users/all";
	protected static String getAllUserUrlJson = baseURL+"/user/all/json";
	protected static String deleteAllUserUrl = baseURL+"/user/all";
	/*
	 * protected static String randomNumber = new
	 * SimpleDateFormat("dd_MMM_yy_HHmmssSSS").format(new Date()); protected static
	 * String fileSeprator = File.separator; protected static String
	 * extentReportImagePath = System.getProperty("user.dir") + fileSeprator + "src"
	 * + fileSeprator + "ExtentReports" + fileSeprator + randomNumber +
	 * fileSeprator; protected static Path path =
	 * FileSystems.getDefault().getPath("").toAbsolutePath(); protected static
	 * String extentReportFilename = extentReportImagePath + "extentReportFile" +
	 * ".html"; protected static ExtentReports extent = new
	 * ExtentReports(extentReportFilename, false); protected static ExtentTest
	 * extentTest;
	 */
	protected static String randomNumber = new SimpleDateFormat("dd_MMM_yy_HH_mm_ss_SSS").format(new Date());
	protected static String fileSeprator = File.separator;

	protected static Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
	protected static String extentReportFilePath = System.getProperty("user.dir") + fileSeprator + "src" + fileSeprator
			+ "ExtentReports" + fileSeprator + randomNumber + fileSeprator;
	protected static String extentReportFilename = extentReportFilePath + "extentReportFile" + ".html";
	protected static String extentReportPathForStoringImage = extentReportFilePath + "images" + fileSeprator;

	protected static String extentReportImagePathForHTML = ".." + fileSeprator + randomNumber + fileSeprator + "images"
			+ fileSeprator;
	protected static ExtentReports extent = new ExtentReports(extentReportFilename, false);
	protected static ExtentTest extentTest;
	
	/*
	 * @AfterClass public static void endReport() { extent.flush(); if (driver !=
	 * null) { driver.quit(); } }
	 */
}
