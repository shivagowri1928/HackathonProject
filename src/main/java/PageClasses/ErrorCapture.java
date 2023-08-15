package PageClasses;

import java.io.IOException;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.JavascriptExecutor;

import BasePage.BaseUI;
import org.openqa.selenium.support.ui.Select;
import utils.ExcelFunctionality;
import utils.ScreenshotFunctionality;

public class ErrorCapture extends BaseUI {

	By opt = By.xpath("//span[text()=' Businesses']");
	By campus = By.xpath("//span[text()=' Universities']");
	By contact = By.xpath("//div[@class='css-1rltwv6']/a ");
	By fname = By.id("FirstName");
	By lname = By.id("LastName");
	By email = By.id("Email");
	By phone = By.id("Phone");
	By instituteType = By.id("Institution_Type__c");
	By instituteName = By.id("Company");
	By jobRole = By.id("Title");
	By depart = By.id("Department");
	By need = By.id("What_the_lead_asked_for_on_the_website__c");
	By country = By.id("Country");
	By submit = By.xpath("//button[text()='Submit']");

	@SuppressWarnings("unused")
	public void errorReport() throws InterruptedException, IOException {
		exttest = report.createTest("Display error during invalid Email Address. ");
		wait(30, opt);
		driver.findElement(opt).click();
		wait(30, campus);
		driver.findElement(campus).click();
		exttest.log(Status.PASS, "Moved to For Campus Successfully");
		wait(30, contact);
		driver.findElement(contact).click();
		exttest.log(Status.PASS, "Moved to form Successfully");
		Thread.sleep(3000);
		driver.findElement(fname).sendKeys(ExcelFunctionality.getInput(12, 0));
		driver.findElement(lname).sendKeys(ExcelFunctionality.getInput(12, 1));
		driver.findElement(email).sendKeys(ExcelFunctionality.getInput(12, 2));
		driver.findElement(phone).sendKeys(ExcelFunctionality.getInput(12, 3));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");
		Select s2 = new Select(driver.findElement(instituteType));
		s2.selectByVisibleText(ExcelFunctionality.getInput(12, 4));
		driver.findElement(instituteName).sendKeys(ExcelFunctionality.getInput(12, 5));
		Select s3 = new Select(driver.findElement(jobRole));
		s2.selectByVisibleText(ExcelFunctionality.getInput(12, 6));
		Select s4 = new Select(driver.findElement(depart));
		js.executeScript("window.scrollBy(0,300)", "");
		s2.selectByVisibleText(ExcelFunctionality.getInput(12, 7));
		Select s5 = new Select(driver.findElement(need));
		s2.selectByVisibleText(ExcelFunctionality.getInput(12, 8));
		Select s6 = new Select(driver.findElement(country));
		s2.selectByVisibleText(ExcelFunctionality.getInput(12, 9));
		driver.findElement(submit).click();
		Thread.sleep(2000);
		exttest.log(Status.PASS, "Data entered and submitted");
		js.executeScript("window.scrollBy(0,-500)", "");
		ScreenshotFunctionality.takeScreenShotOnFailure();
		exttest.log(Status.PASS, "Screenshot taken Successfully");
		String errorMsg = driver.findElement(By.id("ValidMsgEmail")).getText();
		System.out.println("");
		System.out.println("Error Message :");
		System.out.println(errorMsg);
		System.out.println();
		System.out.println("Automation Completed Successfully");
		System.out.println("");
		
}
}