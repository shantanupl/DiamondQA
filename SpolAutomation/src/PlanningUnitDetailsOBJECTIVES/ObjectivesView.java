package PlanningUnitDetailsOBJECTIVES;

import java.io.IOException;
import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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

public class ObjectivesView {
	
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
	
	public ObjectivesView() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void testObjectivesView() throws InterruptedException, IOException {
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
		if(objectives.getObjectivesButton().isSelected()) {
			testcase1.add("Fail");
		}
		else {
			testcase1.add("Pass");
		}
		
		objectives.getObjectivesButton().click();
		Thread.sleep(3000); 
//		if(objectives.getObjectivesButton().isSelected()) {
//			testcase1.add("Pass");
//		}
//		else {
//			testcase1.add("Fail");
//
//		}
		
		
		testcase1.add("Not executed");
		
		
		if(objectives.getObjectivesTitle().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");

		}
		
		Actions action = new Actions(driver);

		action.moveToElement(objectives.getObjectivesTitle()).perform();
		Thread.sleep(1000);
		
		if(objectives.getPlusButtonObjectives().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");

		}
		objectives.getObjectivesTitle().click();
		Thread.sleep(1000);
		if(objectives.getNewObjectiveTitleInForm().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");

		}
		
		objectives.getCrossButtonInNewObjectiveForm().click();
		Thread.sleep(2000);
		action.moveToElement(objectives.getObjectivesTitle()).perform();
		Thread.sleep(1000);
		
		objectives.getPlusButtonObjectives().click();
		Thread.sleep(1000);
		if(objectives.getNewObjectiveTitleInForm().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");

		}
	    ExcelUtil.writeToFile(200, testcase1);		
	}

	@BeforeClass
	private void setup() throws BiffException,IOException,RowsExceededException,WriteException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/resources/drivers/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://diamondqa.strategicplanningonline.com/");
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
