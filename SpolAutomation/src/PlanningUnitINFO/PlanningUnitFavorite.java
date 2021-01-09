package PlanningUnitINFO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
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

//83,84 need to change on every run

public class PlanningUnitFavorite {

	public PlanningUnitFavorite() {
		// TODO Auto-generated constructor stub
	}
	WebDriver driver;
	AllPlanningPage homepage;
	SpolLoginPage loginpage;
	AllPlanningPage allPlanning;
	HSSFWorkbook workbook;
	PlanningUnitDetails planningUnitDetails;
	//define an Excel Work sheet
	HSSFSheet sheet;
	//define a test result data object
	Map<String, Object[]> testresultdata;
	public String Testcase; 
	public WritableSheet writablesh; 
	//public WritableSheet writablesh1;

	public WritableWorkbook workbookcopy;
	//public Workbook workbookcopy1;
	public ArrayList<String> testcase1 = new ArrayList<String>();


	@Test
	public void testFavorite() throws InterruptedException, IOException {
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

		Thread.sleep(4000);

		driver.findElement(By.xpath("//a[contains(text(),'All Planning')]")).click();

		WebDriverWait wait1 = new WebDriverWait(driver,100);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='dropdownMenuButton']")));
		Thread.sleep(3000); 

		allPlanning.clickEllipsisIcon();
		Thread.sleep(2000);
		allPlanning.clickNewPlan();
		Thread.sleep(2000);
		String q3= "AFavA985"; 
		String q4 = "AFavUnitA985";
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

		if(planningUnitDetails.getFavoriteIcon().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		planningUnitDetails.getFavoriteIcon().click();
		//		if(driver.findElement(By.xpath("//div[contains(text(),'Added to favourite successfully.')]")).isDisplayed()) {
		//			testcase1.add("Pass");
		//		}
		Thread.sleep(3000);

		if(driver.findElement(By.cssSelector("body.ng-tns-0-2:nth-child(2) section.page-header div.row.subheader div.col planning-unit-detail-header-tab.ng-star-inserted div:nth-child(1) div.action-container.float-right:nth-child(2) span.icon-box:nth-child(1) > i.fas.fa-star.favourite")).isDisplayed())
		{	testcase1.add("Pass");      
		}
		else {
			testcase1.add("Fail");
		}
		driver.findElement(By.xpath("//body/app-root[1]/div[1]/app-nav-menu[1]/aside[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]/i[1]")).click();
		Thread.sleep(5000);
		if(driver.findElement(By.cssSelector("body.ng-tns-0-2:nth-child(2) aside.sub-nav.ng-star-inserted:nth-child(2) div.scroll-sidebar div.sub-nav-bar-toggler div.sub-nav-body div.row:nth-child(4) div.col-12 div.sub-nav-tree kendo-treeview.k-widget.k-treeview ul.k-treeview-lines.ng-tns-c16-3.k-group li.k-item.k-treeview-item.ng-tns-c16-3.ng-star-inserted:nth-child(1) div.k-mid span.k-in div.cursor-pointer.ng-star-inserted > span.fas.fa-star.favourite-icon")).isDisplayed()) {
			testcase1.add("Pass");             
		}
		else {
			testcase1.add("Fail");
		}
		driver.findElement(By.xpath("//body/app-root[1]/div[1]/app-nav-menu[1]/aside[2]/div[1]/div[1]/div[1]/app-sub-menu[1]/div[1]/div[1]/span[2]/i[1]")).click();
		Thread.sleep(2000);
		planningUnitDetails.getFavoriteIcon().click();
		//		if(driver.findElement(By.xpath("//div[contains(text(),'Removed from favourite successfully.')]")).isDisplayed()) {
		//			testcase1.add("Pass");
		//		}
		Thread.sleep(3000);

		if(driver.findElement(By.cssSelector("body.ng-tns-0-2:nth-child(2) section.page-header div.row.subheader div.col planning-unit-detail-header-tab.ng-star-inserted div:nth-child(1) div.action-container.float-right:nth-child(2) span.icon-box:nth-child(1) > i.fas.fa-star")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
	    driver.findElement(By.xpath("//body/app-root[1]/div[1]/app-nav-menu[1]/aside[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]/i[1]")).click();
		Thread.sleep(5000);
		
		if(driver.findElement(By.cssSelector("body.ng-tns-0-2:nth-child(2) aside.sub-nav.ng-star-inserted:nth-child(2) div.scroll-sidebar div.sub-nav-bar-toggler div.sub-nav-body div.row:nth-child(4) div.col-12 div.sub-nav-tree kendo-treeview.k-widget.k-treeview ul.k-treeview-lines.ng-tns-c16-4.k-group li.k-item.k-treeview-item.ng-tns-c16-4.ng-star-inserted:nth-child(1) div.k-mid span.k-in div.cursor-pointer.ng-star-inserted > span.fal.fa-star.fav-icon")).isDisplayed()) {
			testcase1.add("Pass");
		}
		
		else { 
			testcase1.add("Fail");
		}

		ExcelUtil.writeToFile(131, testcase1);
	}



	//body/app-root[1]/div[1]/app-nav-menu[1]/aside[2]/div[1]/div[1]/div[1]/app-sub-menu[1]/div[2]/div[4]/div[1]/div[1]/kendo-treeview[1]/ul[1]/li[1]/div[1]/span[1]/div[1]/span[2]	
	//body/app-root[1]/div[1]/app-nav-menu[1]/aside[2]/div[1]/div[1]/div[1]/app-sub-menu[1]/div[2]/div[4]/div[1]/div[1]/kendo-treeview[1]/ul[1]/li[2]/div[1]/span[1]/div[1]/span[2]




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

	@AfterClass
	public void afterSuite() {
		driver.close();
		driver.quit();
	}


}
