package PlanningUnitDetailsOBJECTIVES;

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
import ModelClass.Goals;
import ModelClass.Objectives;
import ModelClass.PlanningUnitDetails;
import ModelClass.SpolLoginPage;
import jxl.biff.drawing.ObjRecord;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ObjectiveApprovalAndNote {
	WebDriver driver;
	AllPlanningPage homepage;
	SpolLoginPage loginpage;
	AllPlanningPage allPlanning;
	HSSFWorkbook workbook;
	PlanningUnitDetails planningUnitDetails;
	Goals goals;
	Objectives objectives;
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

	public ObjectiveApprovalAndNote() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void testApprovalNote() throws InterruptedException, IOException {
		homepage= new AllPlanningPage(driver);
		loginpage= new SpolLoginPage(driver);
		allPlanning= new AllPlanningPage(driver);
		planningUnitDetails=new PlanningUnitDetails(driver);
		objectives=new Objectives(driver);
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
		Thread.sleep(6000); 
		
		driver.findElement(By.cssSelector("div.page-wrapper:nth-child(4) div.container-fluid div.planning-unit-container.card.pu-card-detail div.card-block div.table-container div.table-body-container div.parentRow:nth-child(1) div.title > span.planningUnit-Details.pu-title-overflow-wrap-detail")).click();
		Thread.sleep(3000); 
		String desString="Description for Approval";
		String titleString="Objective Title for Approval";
		objectives.getObjectivesButton().click();
		Thread.sleep(6000); 
		objectives.getObjectivesTitle().click();
		Thread.sleep(6000);
		objectives.getObjectiveTitleTextFieldInForm().sendKeys(titleString);
		objectives.getObjectivePurposeDropdownButton().click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//kendo-list/div/ul/li[2]")).click();
		Thread.sleep(1000);
		objectives.getObjectiveStatusDropdownButton().click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//kendo-list/div/ul/li[2]")).click();
		Thread.sleep(1000);
		objectives.getObjectiveDescriptionTextField().sendKeys(desString);
		Thread.sleep(1000);
		objectives.getObjectiveTitleTextFieldInForm().click();
		Thread.sleep(1000);
		objectives.getObjectiveSaveButton().click();
		
		WebDriverWait wait2 = new WebDriverWait(driver,2000);

		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'-- DRAFT --')]")));
		Thread.sleep(6000);
		if(driver.findElement(By.xpath("//span[contains(text(),'-- DRAFT --')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		if(driver.findElement(By.xpath("//app-objective-detail-header-tab/div[1]/div[2]/div[1]/button[1]/span[1]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		objectives.getApproveNoteIcon().click();
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//a[contains(text(),'No Note Options Available')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		objectives.getApproveNoteIcon().click();
		objectives.getDRAFT_Button().click();
		Thread.sleep(1000);
		if(objectives.getViewApprovalHistoryFromDropdown().isDisplayed()&&objectives.getApproveObjectiveFromDropdown().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		objectives.getApproveObjectiveFromDropdown().click();
		Thread.sleep(1000);
		if(objectives.getApproveNoteTitleFromPopup().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		if(objectives.getCancelButtonFromPopup().isDisplayed()&&objectives.getApproveButtonFromPopup().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		objectives.getCancelButtonFromPopup().click();
		Thread.sleep(1000);
		if(objectives.getDRAFT_Button().isDisplayed()) {
			testcase1.add("Pass");
			}
			else {
				testcase1.add("Fail");
			}
		objectives.getDRAFT_Button().click();
		Thread.sleep(1000);
		objectives.getApproveObjectiveFromDropdown().click();
		Thread.sleep(1000);
		objectives.getApproveButtonFromPopup().click();
		
		WebDriverWait wait3 = new WebDriverWait(driver,100);

		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Approved by Shantanu Paul')]")));
		if(driver.findElement(By.xpath("//span[contains(text(),'Approved by Shantanu Paul')]")).isDisplayed()
				&&driver.findElement(By.xpath("//app-objective-detail-header-tab/div[1]/div[1]/div[1]/span[1]/i[1]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		driver.findElement(By.xpath("//app-objective-detail-header-tab/div[1]/div[2]/div[1]/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Undo Approval')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		Thread.sleep(5000);
		
		
		
		objectives.getDRAFT_Button().click();
		Thread.sleep(1000);
		objectives.getApproveObjectiveFromDropdown().click();
		Thread.sleep(1000);
		String approvalString="USAID is currently undertaking several projects around the world, two of which Dr Shah spoke about in considerable detail. One of them is helping impoverished places in Africa, and elsewhere, to decrease the percentage of malnourished people, while aiming the situation";
		objectives.getApproveNoteTextFieldFromPopup().sendKeys(approvalString);
		if(objectives.getApproveNoteTextFieldFromPopup().getAttribute("value").equals(approvalString)) {
			testcase1.add("Fail");
		}
		else {
			testcase1.add("Pass");
		}
		objectives.getApproveNoteTextFieldFromPopup().clear();
		String approvalString2="Approve Note for test";
		objectives.getApproveNoteTextFieldFromPopup().sendKeys(approvalString2);
		objectives.getApproveButtonFromPopup().click();
		WebDriverWait wt3 = new WebDriverWait(driver,100);

		wt3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Approved by Shantanu Paul')]")));
		if(driver.findElement(By.xpath("//span[contains(text(),'Approved by Shantanu Paul')]")).isDisplayed()
				&&driver.findElement(By.xpath("//app-objective-detail-header-tab/div[1]/div[1]/div[1]/span[1]/i[2]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		driver.findElement(By.xpath("//app-objective-detail-header-tab/div[1]/div[2]/div[1]/button[1]")).click();
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//a[contains(text(),'Undo Approval')]")).isDisplayed()
				&&driver.findElement(By.xpath("//a[contains(text(),'Remove All Approvals')]")).isDisplayed()
				&&driver.findElement(By.xpath("//a[contains(text(),'View Approval History')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		driver.findElement(By.xpath("//app-objective-detail-header-tab/div[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//a[contains(text(),'View Approval Notes')]")).isDisplayed()
				&&driver.findElement(By.xpath("//a[contains(text(),'Edit Note')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		driver.findElement(By.xpath("//app-objective-detail-header-tab/div[1]/div[2]/div[1]/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Undo Approval')]")).click();
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//p[contains(text(),'Do you want to Undo this Objective Approval')]")).isDisplayed()
				&&driver.findElement(By.xpath("//button[contains(text(),'No')]")).isDisplayed()
				&&driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		if(driver.findElement(By.xpath("//p[contains(text(),'Do you want to Undo this Objective Approval')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		driver.findElement(By.xpath("//button[contains(text(),'No')]")).click();
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//span[contains(text(),'Approved by Shantanu Paul')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		driver.findElement(By.xpath("//app-objective-detail-header-tab/div[1]/div[2]/div[1]/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Undo Approval')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		Thread.sleep(1000);
		if(objectives.getDRAFT_Button().isDisplayed()&&driver.findElement(By.xpath("//app-objective-detail-header-tab/div[1]/div[1]/div[1]/span[1]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		driver.findElement(By.xpath("//app-objective-detail-header-tab/div[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//a[contains(text(),'No Note Options Available')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		if(driver.findElement(By.xpath("//app-objective-detail-header-tab/div[1]/div[1]/div[1]/span[1]/i[1]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		objectives.getDRAFT_Button().click();
		Thread.sleep(1000);
		objectives.getApproveObjectiveFromDropdown().click();
		Thread.sleep(1000);
		objectives.getApproveButtonFromPopup().click();
		WebDriverWait wait5 = new WebDriverWait(driver,100);

		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Approved by Shantanu Paul')]")));
		driver.findElement(By.xpath("//app-objective-detail-header-tab/div[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//a[contains(text(),'Add Note')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		if(driver.findElement(By.xpath("//a[contains(text(),'Add Note')]")).isEnabled()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		driver.findElement(By.xpath("//a[contains(text(),'Add Note')]")).click();
		Thread.sleep(1000);
		if(objectives.getApproveNoteTitleFromPopup().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();
		Thread.sleep(5000);
		
		
		
		
//		driver.findElement(By.xpath("//textarea[@id='approvalNote']")).sendKeys("Approve11");
//		driver.findElement(By.xpath("//app-objective-detail-header-tab/kendo-dialog[1]/div[2]/div[1]/app-approval[1]/div[1]/div[1]/div[1]/form[1]/div[2]/button[2]")).click();
//		WebDriverWait wait6 = new WebDriverWait(driver,100);
//
//		wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Approved by Shantanu Paul')]")));
		
	
		
//		if(driver.findElement(By.xpath("//app-objective-detail-header-tab/div[1]/div[1]/div[1]/span[1]/i[2]")).isDisplayed()) {
//			testcase1.add("Pass");
//		}
//		else {
//			testcase1.add("Fail");
//		}
		testcase1.add("Not executed");

		driver.findElement(By.xpath("//app-objective-detail-header-tab/div[1]/div[2]/div[1]/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Remove All Approvals')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		Thread.sleep(1000);
		WebDriverWait wait8 = new WebDriverWait(driver,100);

		wait8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'-- DRAFT --')]")));
		objectives.getDRAFT_Button().click();
		Thread.sleep(1000);
		objectives.getApproveObjectiveFromDropdown().click();
		Thread.sleep(1000);
		objectives.getApproveNoteTextFieldFromPopup().sendKeys(approvalString2);
		objectives.getApproveButtonFromPopup().click();
		WebDriverWait wait7 = new WebDriverWait(driver,100);

		wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Approved by Shantanu Paul')]")));
		driver.findElement(By.xpath("//app-objective-detail-header-tab/div[1]/div[1]/div[1]/span[1]/i[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'View Approval Notes')]")).click();
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//textarea[@id='approvalNote']")).getAttribute("value").equals(approvalString2)) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		driver.findElement(By.xpath("//textarea[@id='approvalNote']")).sendKeys("TEST");
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//textarea[@id='approvalNote']")).getAttribute("value").equals(approvalString2)) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		driver.findElement(By.xpath("//button[contains(text(),'Close')]")).click();
		Thread.sleep(2000);

		if(driver.findElement(By.xpath("//span[contains(text(),'Approved by Shantanu Paul')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
	    ExcelUtil.writeToFile(240, testcase1);	
	}
	
	
	
	@BeforeClass
	private void setup() throws BiffException,IOException,RowsExceededException,WriteException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/resources/drivers/chromedriver.exe");
		
		
		
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://diamondqa.strategicplanningonline.com/");
		homepage= new AllPlanningPage(driver);
		loginpage= new SpolLoginPage(driver);
		allPlanning= new AllPlanningPage(driver);
		planningUnitDetails=new PlanningUnitDetails(driver);
		goals=new Goals(driver);
	}

	@AfterClass
	public void afterSuite() {
		driver.close();
		driver.quit();
	}

}
