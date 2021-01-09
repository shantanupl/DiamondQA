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

// 87,88 need to change on every run

public class GoalsAdd {

	public GoalsAdd() {
		// TODO Auto-generated constructor stub
	}
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
	
	@Test
	public void testGoalView() throws InterruptedException, IOException {
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
		String q3= "GoalAddA26"; 
		String q4 = "GoalAddUnitA26"; 
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
		if(planningUnitDetails.getPlanningUnitGoalsTitleButton().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");  
		}
		
		planningUnitDetails.getPlanningUnitGoalsTitleButton().click();
		Thread.sleep(2000);
		if(planningUnitDetails.getPlanningUnitGoalTitleRight().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");  
		}
		
		goals.getCrossButtonPlanningUnitGoalRightBy().click();
		Thread.sleep(2000);
		
		Actions action = new Actions(driver);
		
		action.moveToElement(planningUnitDetails.getPlanningUnitGoalsTitleButton()).perform();
		Thread.sleep(1000);

		action.moveToElement(goals.getPlanningUnitGoalPlusButton()).perform();
		Thread.sleep(1000);

		goals.getPlanningUnitGoalPlusButton().click();
		Thread.sleep(2000);
		if(planningUnitDetails.getPlanningUnitGoalTitleRight().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");  
		}
		if(planningUnitDetails.getPlanningUnitGoalTitleRight().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");  
		}
		
		
		if(goals.getGoalNumberTitleRight().isDisplayed()&&goals.getGoalDescriptionTextField().isDisplayed()&&goals.getPlanningYearCurrentRight().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");  
		}
		String a =goals.getGoalNumberTextFieldRight().getAttribute("value");
		String b =goals.getGoalTitleTextFieldRight().getAttribute("value");
		if((a.equals("1"))&&(b.length()==0)&&(goals.getPlanningYearCurrentRight().isDisplayed())) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");  
		}
		goals.getGoalTitleTextFieldRight().click();
		
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);
		if(goals.getSaveButtonRight().isDisplayed()&&goals.getCancelButton().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");  
		}
		try {
			Assert.assertTrue(goals.getCancelButton().isEnabled());
			Assert.assertFalse(goals.getSaveButtonRight().isEnabled());
			testcase1.add("Pass");

		} catch (Exception e) {
			testcase1.add("Fail");  
		}
		JavascriptExecutor js2 = (JavascriptExecutor)driver;
		js2.executeScript("window.scrollBy(0,-1000)"); 
		Thread.sleep(2000);
		
		goals.getGoalNumberTextFieldRight().clear();
		goals.getGoalTitleTextFieldRight().click();
		Thread.sleep(1000);

		if(driver.findElement(By.xpath("//span[contains(text(),'Goal Number is required')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");  
		} 
		
		String vString=driver.findElement(By.xpath("//span[contains(text(),'Goal Number is required')]")).getText().trim();
		if(vString.equals("Goal Number is required")) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");  
		}
		String c1="12345";
		String c2="Title3";
		goals.getGoalNumberTextFieldRight().clear();
		goals.getGoalNumberTextFieldRight().sendKeys("12345");
		goals.getGoalNumberTextFieldRight().click();
		goals.getGoalTitleTextFieldRight().sendKeys("Title3");
		goals.getGoalTitleTextFieldRight().click();;
		Thread.sleep(1000);

		goals.getPlanningYearCurrentRight().click();
		Thread.sleep(2000);
		goals.getPlanningYearCurrentRight().click();
		Thread.sleep(1000);
		JavascriptExecutor js3 = (JavascriptExecutor)driver;
		js3.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(1000);
		
		goals.getGoalDescriptionTextField().sendKeys("Description2");
		Thread.sleep(1000);
		goals.getGoalDescriptionTextField().click();;
		Thread.sleep(1000);
		
		JavascriptExecutor js5 = (JavascriptExecutor)driver;
		js5.executeScript("window.scrollBy(0,-1000)"); 
		Thread.sleep(2000);
		
		goals.getGoalPlanningYearRightTextField().click();
		Thread.sleep(1000);
		JavascriptExecutor js6 = (JavascriptExecutor)driver;
		js6.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);

		goals.getSaveButtonRight().click();
		Thread.sleep(2000);
		JavascriptExecutor js4 = (JavascriptExecutor)driver;
		js4.executeScript("window.scrollBy(0,-1000)"); 
		Thread.sleep(2000);
		
		if(driver.findElement(By.xpath("//div[contains(text(),'"+c1+" - "+c2+"')]")).isDisplayed()) {
			testcase1.add("Fail");
		}
		else {
			testcase1.add("Pass");

		}
		
		planningUnitDetails.getPlanningUnitGoalsTitleButton().click();
		Thread.sleep(3000);
//		String goString=goals.getGoalNumberTextFieldRight().getAttribute("value");
//		if(goString.equals("12345")) {
//			testcase1.add("Fail");
//		}
//		else {
//			testcase1.add("Pass");  
//		}
		
		
		
		goals.getGoalNumberTextFieldRight().clear();

		goals.getGoalNumberTextFieldRight().sendKeys("abc");
		Thread.sleep(2000);

		
//		if(goals.getGoalNumberTextFieldRight().getAttribute("value")==null) {
//			testcase1.add("Pass");
//		}
//		else {
//			testcase1.add("Fail");  
//		}
		
		
		String titlevalString =goals.getGoalNumberTextFieldRight().getAttribute("value");
		if(titlevalString.length()==0) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");  
		}
		
		goals.getGoalTitleTextFieldRight().click();
		goals.getGoalNumberTextFieldRight().click();
		Thread.sleep(2000);

		if(driver.findElement(By.xpath("//span[contains(text(),'Goal Title is required')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");  
		} 
		String tlString =driver.findElement(By.xpath("//span[contains(text(),'Goal Title is required')]")).getText().trim();
		if(tlString.equals("Goal Title is required")) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");  
		}
		String inString="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

		goals.getGoalTitleTextFieldRight().sendKeys(inString);
		int ln = goals.getGoalTitleTextFieldRight().getAttribute("value").length();
		if(ln>255) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");  
		}
		
		goals.getGoalPlanningYearRightTextField().click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//kendo-list/div/ul/li")).click();
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//span[contains(text(),'2020-2021')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");  
		}
		

		testcase1.add("Not executed");
				
		JavascriptExecutor js7 = (JavascriptExecutor)driver;
		js7.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);
		
		goals.getGoalDescriptionTextField().click();

		JavascriptExecutor js8 = (JavascriptExecutor)driver;
		js8.executeScript("window.scrollBy(0,-1000)"); 
		Thread.sleep(2000);
		
		goals.getGoalTitleTextFieldRight().click();
		
		JavascriptExecutor js9 = (JavascriptExecutor)driver;
		js9.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//span[contains(text(),'Goal Description is required')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");  
		}
		
		String desvString=driver.findElement(By.xpath("//span[contains(text(),'Goal Description is required')]")).getText().trim();
		if(desvString.equals("Goal Description is required")) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");  
		}
		
		try {
			Assert.assertFalse(goals.getSaveButtonRight().isEnabled());
			testcase1.add("Pass");

		} catch (Exception e) {
			testcase1.add("Fail");  
		}
		
	    ExcelUtil.writeToFile(143, testcase1);

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
