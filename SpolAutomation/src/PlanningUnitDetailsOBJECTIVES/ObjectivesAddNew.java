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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ModelClass.AllPlanningPage;
import ModelClass.ExcelUtil;
import ModelClass.Goals;
import ModelClass.Objectives;
import ModelClass.PlanningUnitDetails;
import ModelClass.SpolLoginPage;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ObjectivesAddNew {

	public ObjectivesAddNew() {
		// TODO Auto-generated constructor stub
	}
	
	
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
	
	@Test
	public void testObjectivesAddNew() throws InterruptedException, IOException {
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
		Thread.sleep(3000); 
		
		driver.findElement(By.cssSelector("div.page-wrapper:nth-child(4) div.container-fluid div.planning-unit-container.card.pu-card-detail div.card-block div.table-container div.table-body-container div.parentRow:nth-child(1) div.title > span.planningUnit-Details.pu-title-overflow-wrap-detail")).click();
		Thread.sleep(3000); 
	
		objectives.getObjectivesButton().click();
		Thread.sleep(3000); 
		objectives.getObjectivesTitle().click();
		Thread.sleep(6000);
		if(objectives.getNewObjectiveTitleInForm().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");

		}
		if(objectives.getObjectiveTitleTextFieldInForm().isDisplayed()&&objectives.getMultiyearCheckbox().isDisplayed()
				&&objectives.getObjectiveStatusDropdownButton().isDisplayed()&&objectives.getObjectiveStatusDropdownButton().isDisplayed()
				&&objectives.getObjectiveDescriptionTextField().isDisplayed()&&driver.findElement(By.xpath("//span[contains(text(),'2018-2019')]")).isDisplayed()
				&&objectives.getPlanningUnitDropdownExisting().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");

		}
		
		String titleString=objectives.getObjectiveTitleTextFieldInForm().getAttribute("value");
		String desString=objectives.getObjectiveDescriptionTextField().getAttribute("value");
//		if(objectives.getObjectivePurposeDropdownButton().isDisplayed()&&
//				objectives.getObjectiveStatusDropdownButton().isDisplayed()&&(!objectives.getMultiyearCheckbox().isSelected())&&
//				driver.findElement(By.xpath("//span[contains(text(),'2018-2019')]")).isDisplayed()&&objectives.getPlanningUnitDropdownExisting().isDisplayed()) {
//			testcase1.add("Pass");
//		}
//		else {
//			testcase1.add("Fail");
//
//		}
		
		
		
		testcase1.add("Not executed");
		
		
		if(objectives.getObjectiveSaveButton().isDisplayed()&&objectives.getObjectiveCancelButton().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");

		}
		
		if((!objectives.getObjectiveSaveButton().isEnabled())&&objectives.getObjectiveCancelButton().isEnabled()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");

		}
		 
		objectives.getObjectiveTitleTextFieldInForm().click();
		Thread.sleep(1000); 
		objectives.getObjectiveDescriptionTextField().click();		
		Thread.sleep(1000); 
		if(driver.findElement(By.xpath("//span[contains(text(),'Objective Title is required')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		String titleValString=driver.findElement(By.xpath("//span[contains(text(),'Objective Title is required')]")).getText().trim();
		if(titleValString.equals("Objective Title is required")) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		objectives.getObjectiveTitleTextFieldInForm().sendKeys("!@#$%^&*()?/><}]");
		Thread.sleep(1000); 
		if(objectives.getObjectiveTitleTextFieldInForm().getAttribute("value").equals("!@#$%^&*()?/><}]")) {
			testcase1.add("Fail");
		}
		else {
			testcase1.add("Pass");
		}
		String titleInputString="USAID is currently undertaking several projects around the world, two of which Dr Shah spoke about in considerable detail. One of them is helping impoverished places in Africa, and elsewhere, to decrease the percentage of malnourished people, while aiming the";
		objectives.getObjectiveTitleTextFieldInForm().sendKeys(titleInputString);
		String actualString =objectives.getObjectiveTitleTextFieldInForm().getAttribute("value");
		String expectedString="USAID is currently undertaking several projects around the world, two of which Dr Shah spoke about in considerable detail. One of them is helping impoverished places in Africa, and elsewhere, to decrease the percentage of malnourished people, while aiming";
		if(actualString.equals(expectedString)) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		objectives.getObjectiveTitleTextFieldInForm().clear();
		if(driver.findElement(By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[1]/planning-unit-details-home[1]/div[1]/app-plnning-unit-objectives[1]/new-objective[1]/kendo-dialog[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/kendo-dropdownlist[1]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		
		driver.findElement(By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[1]/planning-unit-details-home[1]/div[1]/app-plnning-unit-objectives[1]/new-objective[1]/kendo-dialog[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/kendo-dropdownlist[1]")).click();
		Thread.sleep(1000); 
		try {
			
			Assert.assertFalse(driver.findElement(By.xpath("//kendo-list/div/ul/li")).isDisplayed());
			testcase1.add("Fail");

		} catch (Exception e) {
			testcase1.add("Pass");
		}
		
		driver.findElement(By.xpath("//span[contains(text(),'2018-2019')]")).click();
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//kendo-list/div/ul/li")).isDisplayed()&&driver.findElement(By.xpath("//kendo-list/div/ul/li[2]")).isDisplayed()
				&&driver.findElement(By.xpath("//kendo-list/div/ul/li[3]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		driver.findElement(By.xpath("//span[contains(text(),'2018-2019')]")).click();
		Thread.sleep(2000);
		objectives.getMultiyearCheckbox().click();
		Thread.sleep(2000);
		if(objectives.getMultiyearCheckbox().isSelected()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		
		if(driver.findElement(By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[1]/planning-unit-details-home[1]/div[1]/app-plnning-unit-objectives[1]/new-objective[1]/kendo-dialog[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[3]/div[1]/kendo-multiselect[1]/div[1]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		
		driver.findElement(By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[1]/planning-unit-details-home[1]/div[1]/app-plnning-unit-objectives[1]/new-objective[1]/kendo-dialog[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[3]/div[1]/kendo-multiselect[1]/div[1]")).click();
		Thread.sleep(2000);

		if(driver.findElement(By.xpath("//kendo-list/div/ul/li")).isDisplayed()&&driver.findElement(By.xpath("//kendo-list/div/ul/li[2]")).isDisplayed()
				&&driver.findElement(By.xpath("//kendo-list/div/ul/li[3]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		driver.findElement(By.xpath("//kendo-list/div/ul/li[2]")).click();
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//span[contains(text(),'2018-2019')]")).isDisplayed()&&driver.findElement(By.xpath("//span[contains(text(),'2019-2020')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		objectives.getMultiyearCheckbox().click();
		Thread.sleep(2000);
		
		
		try {
			Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'2018-2019')]")).isDisplayed());
 			testcase1.add("Pass");

		} catch (Exception e) {
			testcase1.add("Fail");
		}
		
		
		objectives.getObjectivePurposeDropdownButton().click();
		Thread.sleep(2000);
		

		driver.findElement(By.xpath("//kendo-list/div/ul/li[2]")).click();
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//span[contains(text(),'Test Objective Purpose1')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
	    
		objectives.getObjectiveStatusDropdownButton().click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//kendo-list/div/ul/li[2]")).click();
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//span[contains(text(),'New')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		objectives.getObjectiveDescriptionTextField().click();
		Thread.sleep(1000);
		objectives.getObjectiveTitleTextFieldInForm().click();
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//span[contains(text(),'Objective Description is required')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		if(driver.findElement(By.xpath("//span[contains(text(),'Objective Description is required')]")).getText().trim().
				equals("Objective Description is required")){
					testcase1.add("Pass");
				}
				else {
					testcase1.add("Fail");
				}
		
		objectives.getObjectiveCancelButton().click();
		Thread.sleep(2000);
		try {
			Assert.assertFalse(objectives.getNewObjectiveTitleInForm().isDisplayed());
			testcase1.add("Fail");

		} catch (Exception e) {
			testcase1.add("Pass");
		}
		
		objectives.getObjectivesTitle().click();
		Thread.sleep(5000);
		
		objectives.getObjectiveTitleTextFieldInForm().sendKeys("Objective Title");
		objectives.getMultiyearCheckbox().click();
		objectives.getObjectivePurposeDropdownButton().click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//kendo-list/div/ul/li[2]")).click();
		Thread.sleep(1000);
		objectives.getObjectiveStatusDropdownButton().click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//kendo-list/div/ul/li[2]")).click();
		Thread.sleep(1000);
		objectives.getObjectiveDescriptionTextField().sendKeys("Description");
		Thread.sleep(1000);
		objectives.getObjectiveTitleTextFieldInForm().click();
		Thread.sleep(2000);
		if(objectives.getObjectiveSaveButton().isEnabled()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		objectives.getObjectiveCancelButton().click();
		Thread.sleep(2000);
		objectives.getObjectivesTitle().click();
		Thread.sleep(5000);
		objectives.getObjectiveTitleTextFieldInForm().sendKeys("Objective Title2");
		objectives.getObjectivePurposeDropdownButton().click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//kendo-list/div/ul/li[2]")).click();
		Thread.sleep(1000);
		objectives.getObjectiveStatusDropdownButton().click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//kendo-list/div/ul/li[2]")).click();
		Thread.sleep(1000);
		objectives.getObjectiveDescriptionTextField().sendKeys("Description");
		Thread.sleep(1000);
		objectives.getObjectiveTitleTextFieldInForm().click();
		Thread.sleep(2000);
		if(objectives.getObjectiveSaveButton().isEnabled()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		
	    ExcelUtil.writeToFile(206, testcase1);	
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
