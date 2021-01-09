package PlanningUnitDetailsOBJECTIVES;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class ObjectiveEdit {
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
	public ObjectiveEdit() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void testEdit() throws InterruptedException, IOException {
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
		driver.findElement(By.xpath("//div[contains(text(),'Unit Manager')]")).click();
		Thread.sleep(5000);
		if(objectives.getObjectiveDetailTitleRight().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		String titleRightString=objectives.getObjectiveTitleTextFieldRight().getAttribute("value");
		
		//String plString =driver.findElement(By.cssSelector("body.ng-tns-0-2:nth-child(2) div.page-wrapper:nth-child(4) div.container-fluid app-objective.ng-star-inserted:nth-child(3) div.custom-row div.right-section.col-4.animated app-objective-form.ng-star-inserted div.rightbar.o-card.ng-star-inserted div.row div.col-12.ng-star-inserted div.card-block form.k-form.ng-valid.ng-star-inserted.ng-touched.ng-dirty div.ng-star-inserted:nth-child(4) div.k-form-field.ng-star-inserted kendo-dropdownlist.k-widget.k-dropdown.k-header.ng-untouched.ng-pristine.ng-valid:nth-child(2) span.k-dropdown-wrap.k-state-default.k-state-focused > span.k-input")).getText().trim();
		if(titleRightString.equals(titleString)&&driver.findElement(By.xpath("//span[contains(text(),'2018-2019')]")).isDisplayed()
				&&driver.findElement(By.xpath("//span[contains(text(),'Test Objective Purpose1')]")).isDisplayed()
				&&driver.findElement(By.xpath("//span[contains(text(),'New')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		objectives.getObjectiveTitleTextFieldRight().clear();
		objectives.getObjectiveTitleTextFieldRight().click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("//span[contains(text(),'2018-2019')]")).click();
//		Thread.sleep(2000);
//		if(driver.findElement(By.xpath("//span[contains(text(),'Objective Title is required')]")).isDisplayed()) {
//			testcase1.add("Pass");
//		}
//		else {
//			testcase1.add("Fail");
//		}
		
		
		
		testcase1.add("Not executed");

		
		
		JavascriptExecutor jr = (JavascriptExecutor)driver;
		jr.executeScript("window.scrollBy(0,5000)"); 
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
//		Thread.sleep(2000);
//	try {
//		Assert.assertFalse(driver.findElement(By.xpath("//button[contains(text(),'Save')]")).isEnabled());
//		testcase1.add("Fail");
//
//	} catch (Exception e) {
//		testcase1.add("Pass");
//	}
		
//		if(driver.findElement(By.xpath("//button[contains(text(),'Save')]")).isDisplayed()) {
//			testcase1.add("Pass");
//		}
//		else {
//			testcase1.add("Fail");
//		}
//		
		
		testcase1.add("Not executed");

	JavascriptExecutor jr1 = (JavascriptExecutor)driver;
	jr1.executeScript("window.scrollBy(0,-1000)");

	String title2="USAID is currently undertaking several projects around the world, two of which Dr Shah spoke about in considerable detail. One of them is helping impoverished places in Africa, and elsewhere, to decrease the percentage of malnourished people, while aiming the situation";
	objectives.getObjectiveTitleTextFieldRight().sendKeys(title2);
	Thread.sleep(2000);
	if(driver.findElement(By.xpath("//span[contains(text(),'Objective Title cannot exceed 250 characters lengt')]")).isDisplayed()) {
		testcase1.add("Pass");
	}
	else {
		testcase1.add("Fail");
	}
	
	String actualString=objectives.getObjectiveTitleTextFieldRight().getAttribute("value");
	String expectedString="USAID is currently undertaking several projects around the world, two of which Dr Shah spoke about in considerable detail. One of them is helping impoverished places in Africa, and elsewhere, to decrease the percentage of malnourished people, while aiming";

	objectives.getObjectiveTitleTextFieldRight().clear();
	objectives.getObjectiveTitleTextFieldRight().sendKeys(titleString);
	//String planningString=driver.findElement(By.cssSelector("body.ng-tns-0-1:nth-child(2) div.page-wrapper:nth-child(4) div.container-fluid app-objective.ng-star-inserted:nth-child(3) div.custom-row div.right-section.col-4.animated app-objective-form.ng-star-inserted div.rightbar.o-card.ng-star-inserted div.row div.col-12.ng-star-inserted div.card-block form.k-form.ng-untouched.ng-pristine.ng-valid.ng-star-inserted div.ng-star-inserted:nth-child(4) div.k-form-field.ng-star-inserted kendo-dropdownlist.k-widget.k-dropdown.k-header.ng-untouched.ng-pristine.ng-valid:nth-child(2) span.k-dropdown-wrap.k-state-default.k-state-focused > span.k-input")).getText().trim();
	if(driver.findElement(By.xpath("//span[contains(text(),'AFavUnitA986')]")).isDisplayed()) {
		testcase1.add("Pass");
	}
	else {
		testcase1.add("Fail");
	}
	
	//driver.findElement(By.cssSelector("body.ng-tns-0-1:nth-child(2) div.page-wrapper:nth-child(4) div.container-fluid app-objective.ng-star-inserted:nth-child(3) div.custom-row div.right-section.col-4.animated app-objective-form.ng-star-inserted div.rightbar.o-card.ng-star-inserted div.row div.col-12.ng-star-inserted div.card-block form.k-form.ng-untouched.ng-pristine.ng-valid.ng-star-inserted div.ng-star-inserted:nth-child(4) div.k-form-field.ng-star-inserted kendo-dropdownlist.k-widget.k-dropdown.k-header.ng-untouched.ng-pristine.ng-valid:nth-child(2) span.k-dropdown-wrap.k-state-default.k-state-focused > span.k-input")).click();
	driver.findElement(By.xpath("//span[contains(text(),'AFavUnitA986')]")).click();
	Thread.sleep(1000);				   
	driver.findElement(By.xpath("//kendo-list/div/ul/li[2]")).click();
	Thread.sleep(1000);
	JavascriptExecutor jr4 = (JavascriptExecutor)driver;
	jr4.executeScript("window.scrollBy(0,1000)"); 
	Thread.sleep(1000); 
	if(driver.findElement(By.xpath("//button[contains(text(),'Save')]")).isEnabled()) {
		testcase1.add("Pass");
	}
	else {
		testcase1.add("Fail");
	}
	
	driver.findElement(By.xpath("//input[@id='multiYear']")).click();
	Thread.sleep(2000);
	if(driver.findElement(By.xpath("//span[contains(text(),'2018-2019')]")).isDisplayed()) {
		testcase1.add("Pass");
	}
	else {
		testcase1.add("Fail");
	}
	driver.findElement(By.xpath("//input[@id='multiYear']")).click();
	Thread.sleep(2000);
	if(driver.findElement(By.xpath("//span[contains(text(),'2018-2019')]")).isDisplayed()&&driver.findElement(By.xpath("//span[contains(text(),'2019-2020')]")).isDisplayed()) {
		testcase1.add("Pass");
	}
	else {
		testcase1.add("Fail");
	}
	driver.findElement(By.xpath("//span[contains(text(),'Test Objective Purpose1')]")).click();
	Thread.sleep(1000);

	driver.findElement(By.xpath("//kendo-list/div/ul/li")).click();
	Thread.sleep(1000);
	JavascriptExecutor jr5 = (JavascriptExecutor)driver;
	jr5.executeScript("window.scrollBy(0,1000)"); 
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	Thread.sleep(4000);
	JavascriptExecutor jr6 = (JavascriptExecutor)driver;
	jr6.executeScript("window.scrollBy(0,-1000)"); 
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[contains(text(),'Unit Manager')]")).click();
	Thread.sleep(5000);
	if(driver.findElement(By.xpath("//span[contains(text(),'Test Objective Purpose2')]")).isDisplayed()) {
		testcase1.add("Pass");
	}
	else {
		testcase1.add("Fail");
	}
	driver.findElement(By.xpath("//span[contains(text(),'New')]")).click();
	Thread.sleep(2000);

	driver.findElement(By.xpath("//kendo-list/div/ul/li")).click();
	Thread.sleep(2000);
	JavascriptExecutor jr7 = (JavascriptExecutor)driver;
	jr7.executeScript("window.scrollBy(0,1000)"); 
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	Thread.sleep(4000);
	JavascriptExecutor jr8 = (JavascriptExecutor)driver;
	jr8.executeScript("window.scrollBy(0,-1000)"); 
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[contains(text(),'Unit Manager')]")).click();
	Thread.sleep(5000);
	if(driver.findElement(By.xpath("//span[contains(text(),'Completed')]")).isDisplayed()) {
		testcase1.add("Pass");
	}
	else {
		testcase1.add("Fail");
	}
	JavascriptExecutor jr9 = (JavascriptExecutor)driver;
	jr9.executeScript("window.scrollBy(0,1000)"); 
	Thread.sleep(1000);
	objectives.getDescriptionTextFieldRight().clear();
	objectives.getDescriptionTextFieldRight().click();;
	try {
		Assert.assertFalse(driver.findElement(By.xpath("//span[contains(text(),'Objective Title is required')]")).isDisplayed());
		testcase1.add("Pass");

	} catch (Exception e) {
		testcase1.add("Fail");
	}
	
	driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();
	Thread.sleep(4000);
	JavascriptExecutor jr10 = (JavascriptExecutor)driver;
	jr10.executeScript("window.scrollBy(0,-1000)"); 
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[contains(text(),'Unit Manager')]")).click();
	Thread.sleep(5000);
	if(driver.findElement(By.xpath("//span[contains(text(),'Completed')]")).isDisplayed()&&driver.findElement(By.xpath("//span[contains(text(),'Test Objective Purpose2')]")).isDisplayed()
			&&driver.findElement(By.xpath("//span[contains(text(),'2018-2019')]")).isDisplayed()&&driver.findElement(By.xpath("//span[contains(text(),'2019-2020')]")).isDisplayed()) {
		testcase1.add("Pass");
	}
	else {
		testcase1.add("Fail");
	}
	if(driver.findElement(By.xpath("//span[contains(text(),'×')]")).isDisplayed()) {
		testcase1.add("Pass");
	}
	else {
		testcase1.add("Fail");
	}
	driver.findElement(By.xpath("//span[contains(text(),'×')]")).click();
	
	try {
		Assert.assertFalse(objectives.getObjectiveDetailTitleRight().isDisplayed());
		testcase1.add("Fail");

	} catch (Exception e) {
		testcase1.add("Pass");

	}

    ExcelUtil.writeToFile(276, testcase1);	


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
