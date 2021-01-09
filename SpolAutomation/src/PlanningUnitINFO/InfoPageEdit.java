package PlanningUnitINFO;

import java.awt.Desktop.Action;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ModelClass.AllPlanningPage;
import ModelClass.ExcelUtil;
import ModelClass.PlanningUnitDetails;
import ModelClass.SpolLoginPage;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/*
 change in 95,96,299,318,335,348,454,455 every time run

*/

public class InfoPageEdit {
	WebDriver driver;

	AllPlanningPage homepage;
	SpolLoginPage loginpage;
	AllPlanningPage allPlanning;
	PlanningUnitDetails planningUnitDetails;
	
	
	HSSFWorkbook workbook;
	//define an Excel Work sheet
	HSSFSheet sheet;
	//define a test result data object
	Map<String, Object[]> testresultdata;
	public String Testcase; 
	public WritableSheet writablesh; 
	public WritableWorkbook workbookcopy;

	public ArrayList<String> testcase1 = new ArrayList<String>();

	public InfoPageEdit() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	@Test
	public void testInfoPageEdit()throws InterruptedException, RowsExceededException, WriteException, IOException {
		homepage= new AllPlanningPage(driver);
		loginpage= new SpolLoginPage(driver);
		allPlanning= new AllPlanningPage(driver);
		planningUnitDetails=new PlanningUnitDetails(driver);
		loginpage.typeEmailId("spaul");
		Thread.sleep(2000);
		loginpage.typePassword("sp123");
		Thread.sleep(2000);
		loginpage.clickSignIn();
		WebDriverWait wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/app-root[1]/div[1]/app-nav-menu[1]/aside[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]/i[1]")));
		driver.findElement(By.xpath("//body/app-root[1]/div[1]/app-nav-menu[1]/aside[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]/i[1]")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[contains(text(),'All Planning')]")).click();

		WebDriverWait wait1 = new WebDriverWait(driver,100);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='dropdownMenuButton']")));
		Thread.sleep(3000);

		allPlanning.clickEllipsisIcon();
		Thread.sleep(2000);
		allPlanning.clickNewPlan();
		Thread.sleep(2000);
		String q3= "CodeA26"; 
		String q4 = "UnitA26";
		allPlanning.getPlanningUnitCode().sendKeys(q3);

		allPlanning.getPlanningUnitTitle().sendKeys(q4);
		Thread.sleep(1000);

		allPlanning.clickUnitManagerNewDropdown();
		Thread.sleep(1000); 
		allPlanning.getUnitManagerAbadia().click();
		Thread.sleep(1000);
		allPlanning.clickPlanningUnitType();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//kendo-list/div/ul/li[2]")).click();
		Thread.sleep(1000);
//		allPlanning.getUnitParentDropdown().click();
//		Thread.sleep(1000);
//
//		driver.findElement(By.xpath("//planningunit-subheader-tab/div[2]/app-new-planning-unit[1]/kendo-dialog[1]/div[2]/div[1]/div[1]/div[3]/tree-view-dropdown[1]/div[1]/div[1]/div[1]/kendo-treeview[1]/ul[1]/li[1]/div[1]/span[2]")).click();
//		Thread.sleep(1000);
//		String purposeString="Test purpose";
//		
//		allPlanning.getUnitPurposeTextfield().sendKeys(purposeString);
//		Thread.sleep(1000);

		
		allPlanning.clickSave();

		

		WebDriverWait wait7 = new WebDriverWait(driver,500);

		wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+q3+" - "+q4+"')]")));//
		Thread.sleep(6000);
		
		planningUnitDetails.getUnitManagerTitle().click();
		Thread.sleep(1000);
		if(planningUnitDetails.getUnitDetailsRight().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		
		
		Actions builder = new Actions(driver);
		builder.moveToElement(planningUnitDetails.getUnitCodeRight()).release();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);
		
		
		
		if(planningUnitDetails.getUnitCodeRight().getAttribute("value").equals(q3) && planningUnitDetails.getUnitTitleRight().getAttribute("value").equals(q4)
				&& driver.findElement(By.xpath("//div[contains(text(),'Paul, Shantanu')]")).isDisplayed()
				&& driver.findElement(By.xpath("//span[contains(text(),'Committee')]")).isDisplayed())
				//&& driver.findElement(By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[2]/app-planning-unit-info-edit[1]/div[1]/dynamic-form[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[6]/div[1]/tree-view-dropdownlist[1]/span[1]/span[1]/span[1]")).isDisplayed())
		{
			testcase1.add("Pass");

		}
		else {
			testcase1.add("Fail");
		}
		
		
		
		if(driver.findElement(By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[2]/app-planning-unit-info-edit[1]/div[1]/dynamic-form[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[6]/div[1]/tree-view-dropdownlist[1]/span[1]/span[1]/span[1]")).isDisplayed()) {
			testcase1.add("Pass");

		}
		else {
			testcase1.add("Fail");
		}
		String aString=planningUnitDetails.getUnitPurposeRight().getAttribute("value");
		System.out.println(aString);
		if(aString==null)
		{
			testcase1.add("Pass");

		}
		else {
			testcase1.add("Fail");
		}
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,-1000)"); 
		Thread.sleep(2000);
		
//		planningUnitDetails.getUnitTitleRight().click();
//		Thread.sleep(1000);
//		planningUnitDetails.getUnitCodeRight().click();
//		Thread.sleep(1000);
//
//		planningUnitDetails.getUnitCodeRight().clear();
//		Thread.sleep(1000);
//
//		planningUnitDetails.getUnitCodeRight().click();

		
//		Thread.sleep(1000);
//		if(driver.findElement(By.xpath("//span[contains(text(),'Planning Unit Code is required')]")).isDisplayed()) {
//			testcase1.add("Pass");
//		}
//		else {
//			testcase1.add("Fail");
//		}
		testcase1.add("Not executed");
//		
//		JavascriptExecutor js2 = (JavascriptExecutor)driver;
//		js2.executeScript("window.scrollBy(0,1000)"); 
//		Thread.sleep(2000);
//		
//		
//		planningUnitDetails.getSaveButtonRight().click();
//		if(planningUnitDetails.getCancelButtonRight().isDisplayed()) {
//			testcase1.add("Pass");
//		}
//		else {
//			testcase1.add("Fail");
//		}
//		JavascriptExecutor js3 = (JavascriptExecutor)driver;
//		js3.executeScript("window.scrollBy(0,-1000)"); 
//		Thread.sleep(2000);
//		planningUnitDetails.getUnitTitleRight().clear();
//		Thread.sleep(1000);
//		planningUnitDetails.getUnitCodeRight().click();
//		Thread.sleep(1000);
		testcase1.add("Not executed");

		
//		if(driver.findElement(By.xpath("//span[contains(text(),'Planning Unit Title is required')]")).isDisplayed()) {
//			testcase1.add("Pass");
//		}
//		else {
//			testcase1.add("Fail");
//		}
		testcase1.add("Not executed");

//		JavascriptExecutor js4 = (JavascriptExecutor)driver;
//		js4.executeScript("window.scrollBy(0,1000)"); 
//		Thread.sleep(2000);
//		planningUnitDetails.getSaveButtonRight().click();
//		if(planningUnitDetails.getCancelButtonRight().isDisplayed()) {
//			testcase1.add("Pass");
//		}
//		else {
//			testcase1.add("Fail");
//		}
//	
		testcase1.add("Not executed");
//		JavascriptExecutor js5 = (JavascriptExecutor)driver;
//		js5.executeScript("window.scrollBy(0,-1000)"); 
//		Thread.sleep(2000);
		
		planningUnitDetails.getUnitCodeRight().clear();
		Thread.sleep(1000);
		planningUnitDetails.getUnitCodeRight().sendKeys("CodeA20");
		//planningUnitDetails.getUnitTitleRight().sendKeys(q4);
		JavascriptExecutor js5 = (JavascriptExecutor)driver;
		js5.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);
		
		planningUnitDetails.getSaveButtonRight().click();
		Thread.sleep(1000);
		
		if(driver.findElement(By.xpath("//div[contains(text(),'Same planning code already exists')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		
		driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
		Thread.sleep(2000);
		JavascriptExecutor js6 = (JavascriptExecutor)driver;
		js6.executeScript("window.scrollBy(0,-1000)"); 
		Thread.sleep(2000);
		planningUnitDetails.getUnitCodeRight().clear();
		Thread.sleep(1000);

		planningUnitDetails.getUnitTitleRight().clear();
		Thread.sleep(1000);

		planningUnitDetails.getUnitCodeRight().sendKeys(q3);
		Thread.sleep(1000);
		String title = "UnitCA20";
		planningUnitDetails.getUnitTitleRight().sendKeys(title);
		Thread.sleep(1000);
		JavascriptExecutor js7 = (JavascriptExecutor)driver;
		js7.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);

		planningUnitDetails.getSaveButtonRight().click();
		Thread.sleep(6000);
		JavascriptExecutor js8 = (JavascriptExecutor)driver;
		js8.executeScript("window.scrollBy(0,-1000)"); 
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//span[contains(text(),'"+q3+" - "+title+"')]")).isDisplayed()) {
			testcase1.add("Fail");
		}
		else {
			testcase1.add("Pass");
		}
		
		String vString = "DAcccccccccccccccc99ADG";
		planningUnitDetails.getUnitManagerTitle().click();
		Thread.sleep(2000);
		
		planningUnitDetails.getUnitCodeRight().clear();
		Thread.sleep(1000);
		planningUnitDetails.getUnitCodeRight().sendKeys(vString);
		Thread.sleep(1000);
		JavascriptExecutor js9 = (JavascriptExecutor)driver;
		js9.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);
		planningUnitDetails.getSaveButtonRight().click();
		Thread.sleep(3000);
		JavascriptExecutor jz1 = (JavascriptExecutor)driver;
		jz1.executeScript("window.scrollBy(0,-1000)"); 
		Thread.sleep(2000);
		planningUnitDetails.getUnitManagerTitle().click();
		Thread.sleep(1000);
		
		if(planningUnitDetails.getUnitCodeRight().getAttribute("value").equals("DAcccccccccccccccc99")) {
			testcase1.add("Pass");
		}
		else { 
			testcase1.add("Fail");
		}
		
		
		
		planningUnitDetails.getCrossButtonRight().click();
		Thread.sleep(1000);

		planningUnitDetails.getUnitManagerTitle().click();
		Thread.sleep(1000);
		planningUnitDetails.getUnitCodeRight().clear();
		Thread.sleep(1000);
		
		planningUnitDetails.getUnitCodeRight().sendKeys("(&^%!@/()))");
		Thread.sleep(1000);
		JavascriptExecutor jv1 = (JavascriptExecutor)driver;
		jv1.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);
		planningUnitDetails.getSaveButtonRight().click();
		Thread.sleep(3000);
		JavascriptExecutor jz2 = (JavascriptExecutor)driver;
		jz2.executeScript("window.scrollBy(0,-1000)"); 
		Thread.sleep(2000);
		planningUnitDetails.getUnitManagerTitle().click();
		Thread.sleep(1000);
		
		if(planningUnitDetails.getUnitCodeRight().getAttribute("value").equals("(&^%!@/()))")) {
			testcase1.add("Fail");
		}
		testcase1.add("Not executed");
		testcase1.add("Not executed");

		
		planningUnitDetails.getUnitCodeRight().clear();
		planningUnitDetails.getUnitCodeRight().sendKeys(q3);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'Committee')]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//kendo-list/div/ul/li[3]")).click();
		Thread.sleep(1000);
		JavascriptExecutor jz3 = (JavascriptExecutor)driver;
		jz3.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);
		planningUnitDetails.getSaveButtonRight().click();
		Thread.sleep(3000);
		JavascriptExecutor sc1 = (JavascriptExecutor)driver;
		sc1.executeScript("window.scrollBy(0,-1000)"); 
		Thread.sleep(2000);
		planningUnitDetails.getUnitManagerTitle().click();
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//span[contains(text(),'Support')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else { 
			testcase1.add("Fail");
		}
		
		planningUnitDetails.getUnitTitleRight().clear();
		Thread.sleep(1000);
		planningUnitDetails.getUnitTitleRight().sendKeys(q4);
		Thread.sleep(1000);

		
		
		
		planningUnitDetails.getCrossButtonRemoveParent().click();
		Thread.sleep(1000);
		
		
		JavascriptExecutor jv11 = (JavascriptExecutor)driver;
		jv11.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);
		planningUnitDetails.getSaveButtonRight().click();
		Thread.sleep(2000);
		JavascriptExecutor jz21 = (JavascriptExecutor)driver;
		jz21.executeScript("window.scrollBy(0,-1000)"); 
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//span[contains(text(),'"+q3+" - "+q4+"')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		
		planningUnitDetails.getUnitManagerTitle().click();
		Thread.sleep(1000);
		
		planningUnitDetails.getParentPlanningUnitDropdownButton().click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'CodeA1 - UnitA2')]")).click();
		Thread.sleep(1000);
		JavascriptExecutor jv12 = (JavascriptExecutor)driver;
		jv12.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);
		planningUnitDetails.getSaveButtonRight().click();
		Thread.sleep(2000);
		JavascriptExecutor jz22 = (JavascriptExecutor)driver;
		jz22.executeScript("window.scrollBy(0,-1000)"); 
		Thread.sleep(2000);
		
		planningUnitDetails.getUnitManagerTitle().click();
		Thread.sleep(1000);
		
		if(driver.findElement(By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[2]/app-planning-unit-info-edit[1]/div[1]/dynamic-form[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[6]/div[1]/tree-view-dropdownlist[1]/span[1]/span[1]/span[1]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		
		
		
		
		//		Verify that user can save the form by removing the "Unit Purpose" value

		
		driver.findElement(By.xpath("//body/app-root[1]/div[1]/app-nav-menu[1]/aside[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]/i[1]")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[contains(text(),'All Planning')]")).click();

		WebDriverWait wwt1 = new WebDriverWait(driver,100);

		wwt1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='dropdownMenuButton']")));
		Thread.sleep(3000);

		allPlanning.clickEllipsisIcon();
		Thread.sleep(2000);
		allPlanning.clickNewPlan();
		Thread.sleep(2000);
		String s3= "CodeMA4";
		String s4 = "UnitMA4";
		allPlanning.getPlanningUnitCode().sendKeys(s3);

		allPlanning.getPlanningUnitTitle().sendKeys(s4);
		Thread.sleep(1000);

		allPlanning.clickUnitManagerNewDropdown();
		Thread.sleep(1000); 
		allPlanning.getUnitManagerAbadia().click();
		Thread.sleep(1000);
		allPlanning.clickPlanningUnitType();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//kendo-list/div/ul/li[2]")).click();
		Thread.sleep(1000);
//		allPlanning.getUnitParentDropdown().click();
//		Thread.sleep(1000);
//
//		driver.findElement(By.xpath("//planningunit-subheader-tab/div[2]/app-new-planning-unit[1]/kendo-dialog[1]/div[2]/div[1]/div[1]/div[3]/tree-view-dropdown[1]/div[1]/div[1]/div[1]/kendo-treeview[1]/ul[1]/li[1]/div[1]/span[2]")).click();
//		Thread.sleep(1000);
		String purposeString="Test purpose";
		
		allPlanning.getUnitPurposeTextfield().sendKeys(purposeString);
		Thread.sleep(1000);

		
		allPlanning.clickSave();

		

		WebDriverWait wt1 = new WebDriverWait(driver,500);

		wt1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+s3+" - "+s4+"')]")));//
		Thread.sleep(6000);
		
	
		planningUnitDetails.getUnitManagerTitle().click();
		Thread.sleep(1000);
		
		
		
		planningUnitDetails.getUnitCodeRight().click();
		Thread.sleep(1000);
		JavascriptExecutor jv13 = (JavascriptExecutor)driver;
		jv13.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);
		
		planningUnitDetails.getUnitPurposeRight().clear();
		Thread.sleep(2000);
		
		planningUnitDetails.getUnitPurposeRight().click();
		Thread.sleep(1000);

		planningUnitDetails.getSaveButtonRight().click();
		Thread.sleep(3000);
		JavascriptExecutor sc2 = (JavascriptExecutor)driver;
		sc2.executeScript("window.scrollBy(0,-1000)"); 
		Thread.sleep(2000);
		planningUnitDetails.getUnitManagerTitle().click();
		Thread.sleep(1000);
		planningUnitDetails.getUnitCodeRight().click();
		Thread.sleep(1000);
		JavascriptExecutor sc3 = (JavascriptExecutor)driver;
		sc3.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);
		
		if(planningUnitDetails.getUnitPurposeRight().getAttribute("value")==null) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		
		String nString="New Value";
		planningUnitDetails.getUnitPurposeRight().clear();
		Thread.sleep(1000);

		planningUnitDetails.getUnitPurposeRight().sendKeys(nString);
		Thread.sleep(1000);
		planningUnitDetails.getSaveButtonRight().click();
		Thread.sleep(3000);
		JavascriptExecutor sc = (JavascriptExecutor)driver;
		sc.executeScript("window.scrollBy(0,-1000)"); 
		Thread.sleep(2000);
		
		if(driver.findElement(By.xpath("//p[contains(text(),'New Value')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		
		planningUnitDetails.getUnitManagerTitle().click();
		Thread.sleep(1000);
		planningUnitDetails.getUnitCodeRight().click();
		Thread.sleep(1000);
		JavascriptExecutor sc4 = (JavascriptExecutor)driver;
		sc4.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);
		planningUnitDetails.getCancelButtonRight().click();
		
		Thread.sleep(1000);

		JavascriptExecutor sc5 = (JavascriptExecutor)driver;
		sc5.executeScript("window.scrollBy(0,-1000)"); 
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//span[contains(text(),'"+s3+" - "+s4+"')]")).isDisplayed()&&driver.findElement(By.xpath("//p[contains(text(),'New Value')]")).isDisplayed()
				&& driver.findElement(By.xpath("//div[contains(text(),'Paul, Shantanu')]")).isDisplayed()) {
			testcase1.add("Pass");

		}
		else {
			testcase1.add("Fail");
		}
		
		planningUnitDetails.getUnitManagerTitle().click();
		Thread.sleep(1000);
		
		if(planningUnitDetails.getCrossButtonRight().isDisplayed()) {
			testcase1.add("Pass");

		}
		else {
			testcase1.add("Fail");
		}
		
		planningUnitDetails.getCrossButtonRight().click();
		Thread.sleep(1000);
		try {
			Assert.assertFalse(planningUnitDetails.getCrossButtonRight().isDisplayed());
			testcase1.add("Fail");

		} catch (Exception e) {
			testcase1.add("Pass");
		}
		
		
		
		
		
		
	 	ExcelUtil.writeToFile(72, testcase1);

	}
	@BeforeClass
	private void setup() throws BiffException,IOException,RowsExceededException,WriteException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\Web automation\\chromedriver_win32\\chromedriver.exe");
			
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://diamondqa.strategicplanningonline.com/");
		homepage= new AllPlanningPage(driver);
		loginpage= new SpolLoginPage(driver);
		allPlanning= new AllPlanningPage(driver);
		planningUnitDetails=new PlanningUnitDetails(driver);
	}
	//Info
	@AfterClass
	public void after() throws IOException {
		//driver.close();
		driver.quit();
	}
}
