package PlanningUnitDetailsOBJECTIVES;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.random.ISAACRandom;
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
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

//119,120 need to change on every run

public class CreateNewObjectives {
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
	public CreateNewObjectives() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Test
	public void testCreateNewObjectives() throws InterruptedException, IOException {
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
		driver.findElement(By.xpath("//span[@id='dropdownMenuButton']")).click();
		Thread.sleep(1000); 
		driver.findElement(By.xpath("//a[contains(text(),'New Objective')]")).click();
		Thread.sleep(5000); 
		if(objectives.getNewObjectiveTitleInForm().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");

		}
		if(driver.findElement(By.xpath("//planningunit-subheader-tab/div[2]/new-objective[1]/kendo-dialog[1]/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]")).isDisplayed()&&driver.findElement(By.xpath("//planningunit-subheader-tab/div[2]/new-objective[1]/kendo-dialog[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[2]/div[1]/label[1]/input[1]")).isDisplayed()
				&&objectives.getObjectivePurposeDropdownButton().isDisplayed()&&objectives.getObjectiveStatusDropdownButton().isDisplayed()
				&&driver.findElement(By.xpath("//planningunit-subheader-tab/div[2]/new-objective[1]/kendo-dialog[1]/div[2]/div[1]/div[1]/form[1]/div[4]/div[1]/kendo-editor[1]/div[1]/div[1]")).isDisplayed()&&driver.findElement(By.xpath("//span[contains(text(),'2018-2019')]")).isDisplayed()
				&&driver.findElement(By.xpath("//div[contains(text(),'Please select Planning Unit')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");

		}
		testcase1.add("Not executed");
		
		
		driver.findElement(By.xpath("//div[contains(text(),'Please select Planning Unit')]")).click();
		Thread.sleep(2000); 
		if(driver.findElement(By.xpath("//li/div/span[2]")).isDisplayed()&&driver.findElement(By.xpath("//li[2]/div/span[2]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		driver.findElement(By.xpath("//li[2]/div/span[2]")).click();
		Thread.sleep(1000); 
		
		String titleString="Test_ObjectiveTitle1";
		String desString="Test_Description1";
		driver.findElement(By.xpath("//planningunit-subheader-tab/div[2]/new-objective[1]/kendo-dialog[1]/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]")).sendKeys(titleString);
		Thread.sleep(1000); 
		objectives.getObjectivePurposeDropdownButton().click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//kendo-list/div/ul/li[2]")).click();
		Thread.sleep(1000);
		objectives.getObjectiveStatusDropdownButton().click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//kendo-list/div/ul/li[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//planningunit-subheader-tab/div[2]/new-objective[1]/kendo-dialog[1]/div[2]/div[1]/div[1]/form[1]/div[4]/div[1]/kendo-editor[1]/div[1]/div[1]")).sendKeys(desString);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//planningunit-subheader-tab/div[2]/new-objective[1]/kendo-dialog[1]/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]")).click();
		Thread.sleep(2000);
		if(objectives.getObjectiveSaveButton().isEnabled()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		
		objectives.getObjectiveSaveButton().click();
		WebDriverWait wait2 = new WebDriverWait(driver,900);

		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'"+desString+"')]")));
		Thread.sleep(4000);

		
		if(driver.findElement(By.xpath("//p[contains(text(),'"+desString+"')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		if(driver.findElement(By.xpath("//div[contains(text(),'New')]")).isDisplayed()&&driver.findElement(By.xpath("//div[contains(text(),'Test Objective Purpose1')]")).isDisplayed()
				&&driver.findElement(By.xpath("//p[contains(text(),'"+desString+"')]")).isDisplayed()&&driver.findElement(By.xpath("//div[contains(text(),'2018-2019')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		
		driver.findElement(By.xpath("//body/app-root[1]/div[1]/app-nav-menu[1]/aside[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]/i[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'All Planning')]")).click();
		
		WebDriverWait wait3 = new WebDriverWait(driver,100);
 
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='dropdownMenuButton']")));
		if(driver.findElement(By.cssSelector("body.ng-tns-0-2:nth-child(2) div.page-wrapper:nth-child(4) div.container-fluid all-planning-unit.ng-star-inserted:nth-child(3) app-planning-unit.ng-star-inserted:nth-child(2) div.ng-star-inserted div.planning-unit-container.card.pu-card-detail.ng-star-inserted div.card-block div.table-container div.table-body-container.ng-star-inserted div.parentRow.ng-star-inserted:nth-child(1) div.child-body.showElement.ng-star-inserted div.child-row-container.child-row.row.ng-star-inserted div.child-first-column.child-column-padding.planning-child-col-extra-padding.col-4:nth-child(1) > a.link-color.pu-title-overflow-wrap-detail")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
	    ExcelUtil.writeToFile(230, testcase1);	

		
		

		
		
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
