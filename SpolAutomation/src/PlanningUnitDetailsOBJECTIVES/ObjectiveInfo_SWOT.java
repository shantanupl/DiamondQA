package PlanningUnitDetailsOBJECTIVES;

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

public class ObjectiveInfo_SWOT {
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
	public ObjectiveInfo_SWOT() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void testObjectiveInfo_SWOT() throws InterruptedException, IOException {
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
		String planningUnitString = driver.findElement(By.cssSelector("div.page-wrapper:nth-child(4) div.container-fluid div.planning-unit-container.card.pu-card-detail div.card-block div.table-container div.table-body-container div.parentRow:nth-child(1) div.title > span.planningUnit-Details.pu-title-overflow-wrap-detail")).getText().trim();

		driver.findElement(By.cssSelector("div.page-wrapper:nth-child(4) div.container-fluid div.planning-unit-container.card.pu-card-detail div.card-block div.table-container div.table-body-container div.parentRow:nth-child(1) div.title > span.planningUnit-Details.pu-title-overflow-wrap-detail")).click();
		Thread.sleep(3000); 
		String desString="Description for Edit";
		String titleString="Objective Title for Edit";
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
		objectives.getMultiyearCheckbox().click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[1]/planning-unit-details-home[1]/div[1]/app-plnning-unit-objectives[1]/new-objective[1]/kendo-dialog[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[3]/div[1]/kendo-multiselect[1]/div[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//kendo-list/div/ul/li[2]")).click();
		Thread.sleep(1000);
		objectives.getObjectiveTitleTextFieldInForm().click();
		Thread.sleep(1000);
		objectives.getObjectiveSaveButton().click();
		
		WebDriverWait wait2 = new WebDriverWait(driver,2000);

		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'-- DRAFT --')]")));
		JavascriptExecutor jr1 = (JavascriptExecutor)driver;
		jr1.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(2000);
		JavascriptExecutor jx1 = (JavascriptExecutor)driver;
		jx1.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(2000);

		if(driver.findElement(By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/app-objective[1]/merge-com[1]/div[1]/div[1]/objective-detail-home[1]/div[1]/app-objective-swot-info[1]/div[1]/div[1]/div[2]/div[1]/div[1]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		
		else {
			testcase1.add("Fail");
		}
		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'SWOT')]"))).perform();
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/app-objective[1]/merge-com[1]/div[1]/div[1]/objective-detail-home[1]/div[1]/app-objective-swot-info[1]/div[1]/div[1]/div[1]/div[1]/div[2]/span[1]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		driver.findElement(By.xpath("//span[contains(text(),'SWOT')]")).click();
		Thread.sleep(2000);
		JavascriptExecutor jr2 = (JavascriptExecutor)driver;
		jr2.executeScript("window.scrollBy(0,-2000)");
		if(driver.findElement(By.xpath("//span[contains(text(),'Objective SWOT')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		driver.findElement(By.xpath("//span[contains(text(),'�')]")).click();
		Thread.sleep(1000);
		JavascriptExecutor jr3 = (JavascriptExecutor)driver;
		jr3.executeScript("window.scrollBy(0,2000)");
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'SWOT')]"))).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/app-objective[1]/merge-com[1]/div[1]/div[1]/objective-detail-home[1]/div[1]/app-objective-swot-info[1]/div[1]/div[1]/div[1]/div[1]/div[2]/span[1]")).click();
		Thread.sleep(2000);
		JavascriptExecutor jr4 = (JavascriptExecutor)driver;
		jr4.executeScript("window.scrollBy(0,-2000)");
		if(driver.findElement(By.xpath("//span[contains(text(),'Objective SWOT')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		String titleString2 = driver.findElement(By.xpath("//span[contains(text(),'Objective SWOT')]")).getText().trim();
		if((titleString2).equals("Objective SWOT")){
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		testcase1.add("Not executed");
		testcase1.add("Not executed");
		driver.findElement(By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/app-objective[1]/merge-com[1]/div[1]/div[2]/app-objective-swot-form[1]/div[1]/dynamic-form[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[6]/kendo-textbox-container[1]/kendo-editor[1]/div[1]/div[1]")).click();
		JavascriptExecutor jr5 = (JavascriptExecutor)driver;
		jr5.executeScript("window.scrollBy(0,2000)");
		if(driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).isDisplayed()
				&&driver.findElement(By.xpath("//button[contains(text(),'Save')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
	    ExcelUtil.writeToFile(379, testcase1);				

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
