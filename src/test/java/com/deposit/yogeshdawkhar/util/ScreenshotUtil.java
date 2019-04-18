package com.deposit.yogeshdawkhar.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.deposit.yogeshdawkhar.helper.HelperClass;

public class ScreenshotUtil extends HelperClass {

	public static void takeScreenshot(final String name) throws IOException {
		String screenshotDirectory = extentReportPathForStoringImage;
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, (new File(screenshotDirectory, String.format("%s.png", name))));
	}

	public static String createimagename() throws IOException {
		String imagename = new SimpleDateFormat("dd_MMM_yy_HH_mm_ss_SSS").format(new Date());
		takeScreenshot(imagename);
		return imagename;
	}
}
