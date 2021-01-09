package PlanningUnitDetailsGoals;

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
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ModelClass.AllPlanningPage;
import ModelClass.ExcelUtil;
import ModelClass.Goals;
import ModelClass.PlanningUnitDetails;
import ModelClass.SpolLoginPage;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

//87,88 need to change on every run

public class GoalsDetails {
	WebDriver driver;
	AllPlanningPage homepage;
	SpolLoginPage loginpage;
	AllPlanningPage allPlanning;
	HSSFWorkbook workbook;
	PlanningUnitDetails planningUnitDetails;
	Goals goals;
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
	
	public GoalsDetails() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void testGoalsDetails() throws InterruptedException, IOException {
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
		String q3= "GoalDetailA1"; 
		String q4 = "GoalDetailUnitA1"; 
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
		
		planningUnitDetails.getGoalButton().click();
		Thread.sleep(4000);
		Actions action = new Actions(driver);

		action.moveToElement(planningUnitDetails.getPlanningUnitGoalsTitleButton()).perform();
		Thread.sleep(1000);

		action.moveToElement(goals.getPlanningUnitGoalPlusButton()).perform();
		Thread.sleep(1000);

		goals.getPlanningUnitGoalPlusButton().click();
		Thread.sleep(2000);
		
		String numberString="001";
		String titleString ="Test Goal";
		String desString="Test Description";
		goals.getGoalNumberTextFieldRight().sendKeys(numberString);
		goals.getGoalTitleTextFieldRight().sendKeys(titleString);
		goals.getGoalDescriptionTextField().clear();
		JavascriptExecutor jr1 = (JavascriptExecutor)driver;
		jr1.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);
		goals.getGoalDescriptionTextField().sendKeys(desString);
		JavascriptExecutor jr3 = (JavascriptExecutor)driver;
		jr3.executeScript("window.scrollBy(0,-1000)"); 
		Thread.sleep(2000);
		goals.getGoalPlanningYearRightTextField().click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("//kendo-list/div/ul/li")).click();
//		Thread.sleep(1000);
		goals.getGoalPlanningYearRightTextField().click();
		Thread.sleep(1000);
		JavascriptExecutor jr4 = (JavascriptExecutor)driver;
		jr4.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);
		goals.getSaveButtonRight().click();
		Thread.sleep(2000);
		JavascriptExecutor jr5 = (JavascriptExecutor)driver;
		jr5.executeScript("window.scrollBy(0,-1000)"); 
		Thread.sleep(2000);
		try {
			Assert.assertFalse(planningUnitDetails.getPlanningUnitGoalTitleRight().isDisplayed());
			testcase1.add("Fail");
		} catch (Exception e) {
			testcase1.add("Pass");  
		}
		//span[contains(text(),'"+q3+" - "+q4+"')]
		if(driver.findElement(By.xpath("//div[contains(text(),'"+numberString+" - "+titleString+"')]")).isDisplayed()&&
				driver.findElement(By.xpath("//p[contains(text(),'"+desString+"')]")).isDisplayed()) {
			testcase1.add("Pass");
		} 
		else {
			testcase1.add("Fail");  
		}
		
		planningUnitDetails.getPlanningUnitGoalsTitleButton().click();
		Thread.sleep(3000);
		String numberString1="002";
		String titleString1 ="Test Goal2";
		String desString1="Test Description2";
		goals.getGoalNumberTextFieldRight().clear();
		goals.getGoalTitleTextFieldRight().clear();
		goals.getGoalNumberTextFieldRight().sendKeys(numberString1);
		goals.getGoalTitleTextFieldRight().sendKeys(titleString1);
		goals.getGoalDescriptionTextField().clear();
		JavascriptExecutor jr11 = (JavascriptExecutor)driver;
		jr11.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);
		goals.getGoalDescriptionTextField().sendKeys(desString1);
		JavascriptExecutor jr31 = (JavascriptExecutor)driver;
		jr31.executeScript("window.scrollBy(0,-1000)"); 
		Thread.sleep(2000);
		goals.getGoalPlanningYearRightTextField().click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//kendo-list/div/ul/li")).click();
		Thread.sleep(1000);
		
		JavascriptExecutor jr41 = (JavascriptExecutor)driver;
		jr41.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);
		goals.getSaveButtonRight().click();
		Thread.sleep(2000);
		JavascriptExecutor jr51 = (JavascriptExecutor)driver;
		jr51.executeScript("window.scrollBy(0,-1000)"); 
		Thread.sleep(2000);
		try {
			Assert.assertFalse(planningUnitDetails.getPlanningUnitGoalTitleRight().isDisplayed());
			testcase1.add("Fail");
		} catch (Exception e) {
			testcase1.add("Pass");  
		}
		if(driver.findElement(By.xpath("//div[contains(text(),'"+numberString1+" - "+titleString1+"')]")).isDisplayed()&&
				driver.findElement(By.xpath("//p[contains(text(),'"+desString1+"')]")).isDisplayed()) {
			testcase1.add("Pass");
		} 
		else {
			testcase1.add("Fail");  
		}
		
		

		
		
	    ExcelUtil.writeToFile(163, testcase1);

		


		
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
		goals=new Goals(driver);
	}

	@AfterClass
	public void afterSuite() {
		driver.close();
		driver.quit();
	}
	
	

}
