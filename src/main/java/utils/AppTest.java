package utils;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePage.BaseUI;
import PageClasses.Courses;
import PageClasses.ErrorCapture;
import PageClasses.LangLearn;

public class AppTest extends BaseUI {

	@BeforeMethod
	public void invokeBrowser() {
		driverSetup();
		openUrl();
	}

	@Test(priority = 1)
	public void webDevelopmentTest() throws InterruptedException, IOException {
		Courses c = new Courses();
		c.find();

	}

	@Test(priority = 2)
	public void languageLearningTest() throws InterruptedException, IOException {
		LangLearn l = new LangLearn();
		l.learningLang();
	}

	@Test(priority = 3)
	public void readyToTransFormTest() throws InterruptedException, IOException {
		ErrorCapture r = new ErrorCapture();
		r.errorReport();
	}

	@AfterMethod
	public void closeBrowser() {
		quitBrowser();
	}

}