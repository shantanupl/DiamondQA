package PlanningUnitINFO;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;
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

//79,80 need to change on every run

public class ViewPageAfterSave {
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

	public ViewPageAfterSave() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Test
	public void testPlanningDetails() throws InterruptedException, RowsExceededException, WriteException, IOException {
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
		String q3= "CodeAA16";
		String q4 = "UnitCAA16";
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
		allPlanning.getUnitParentDropdown().click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='main-wrapper']/app-header/section/div/div/planningunit-subheader-tab/div[2]/app-new-planning-unit/kendo-dialog/div[2]/div/div/div[3]/tree-view-dropdown/div/div/div/kendo-treeview/ul/li/div/span[2]")).click();
		Thread.sleep(1000);
		String purposeString="Test";
		allPlanning.getUnitPurposeTextfield().sendKeys(purposeString);
		Thread.sleep(1000);
		allPlanning.clickSave();
		WebDriverWait wait7 = new WebDriverWait(driver,500);
		wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+q3+" - "+q4+"')]")));//
		Thread.sleep(6000);
		if(planningUnitDetails.getInfoButton().isEnabled()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		if(driver.findElement(By.xpath("//div[contains(text(),'Paul, Shantanu')]")).isDisplayed()&&driver.findElement(By.xpath("//div[contains(text(),'10Z9 - UnitZ29')]")).isDisplayed()&&
		driver.findElement(By.xpath("//p[contains(text(),'Test')]")).isDisplayed()&&
		driver.findElement(By.xpath("//span[contains(text(),'"+q3+" - "+q4+"')]")).isDisplayed()
		) {
			testcase1.add("Pass");

		}
		else {
			testcase1.add("Fail");
		}
		
		
		if(driver.findElement(By.xpath("//span[contains(text(),'"+q3+" - "+q4+"')]")).isDisplayed())
		{
			testcase1.add("Pass");

		}
		else {
			testcase1.add("Fail");
		}
		
		if(driver.findElement(By.xpath("//span[contains(text(),'"+q3+" - "+q4+"')]")).isDisplayed())
		{
			testcase1.add("Pass");

		}
		else {
			testcase1.add("Fail");
		}
		
		if(driver.findElement(By.xpath("//div[contains(text(),'Paul, Shantanu')]")).isDisplayed())
		{
			testcase1.add("Pass");

		}
		else {
			testcase1.add("Fail");
		}
		
		if(driver.findElement(By.xpath("//div[contains(text(),'10Z9 - UnitZ29')]")).isDisplayed())
		{
				testcase1.add("Pass");

		}
			else {
				testcase1.add("Fail");
		}
		
		if(driver.findElement(By.xpath("//p[contains(text(),'Test')]")).isDisplayed())
		{
				testcase1.add("Pass");

		}
			else {
				testcase1.add("Fail");
		}

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(3000);
		if(planningUnitDetails.getbudgetAccountTitle().isDisplayed()&&planningUnitDetails.getimpactingObjectivesTitle().isDisplayed()&&planningUnitDetails.getmembersTitle().isDisplayed())
		
		{
			testcase1.add("Pass");

	}
		else {
			testcase1.add("Fail");
	}
	
		if(planningUnitDetails.getAssignmentRecordText().isDisplayed()&&planningUnitDetails.getBudgetNoRecordText().isDisplayed()&&planningUnitDetails.getMembersNoRecordText().isDisplayed()&&planningUnitDetails.getObjectiveNoRecordText().isDisplayed()) {
			testcase1.add("Pass");

		}
		else {
			testcase1.add("Fail");
     	}	
		
	 	ExcelUtil.writeToFile(63, testcase1);
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

	@AfterClass
	public void afterSuite() {
		driver.close();
		driver.quit();
	}

}
