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
import org.openqa.selenium.WebElement;
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
import ModelClass.PlanningUnitDetails;
import ModelClass.SpolLoginPage;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;



/*
 
       2020-2021   //kendo-list/div/ul/li
       2019-2020   //kendo-list/div/ul/li[2] 
 	   2018-2019(Current)   //kendo-list/div/ul/li[3]
 
 */

//100,101 need to change on every run

public class GoalsAddSWOT {
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
	
	String currentDate = "12/16/2020";// today's date
	String inputDateString="12/13/2020";//has to be less than current date, need to change accordingly.
	public GoalsAddSWOT() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Test
	public void testGoalsAddSWOT() throws InterruptedException, IOException {
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

		Thread.sleep( 3000);

		driver.findElement(By.xpath("//a[contains(text(),'All Planning')]")).click();

		WebDriverWait wait1 = new WebDriverWait(driver,100);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='dropdownMenuButton']")));
		Thread.sleep(3000); 

		allPlanning.clickEllipsisIcon();
		Thread.sleep(2000);
		allPlanning.clickNewPlan();
		Thread.sleep(2000); 
		String q3= "GoalSWOTA45"; 
		String q4 = "GoalSWOTUnitA45";   
		allPlanning.getPlanningUnitCode().sendKeys(q3);

		allPlanning.getPlanningUnitTitle().sendKeys(q4);
		Thread.sleep(1000   );

		allPlanning.clickUnitManagerNewDropdown();
		Thread.sleep(1000); 
		allPlanning.getUnitManagerAbadia( ).click();
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

		action.moveToElement(planningUnitDetails.getPlanningUnitSWOTTitleButton()).perform();
		Thread.sleep(1000);

		action.moveToElement(goals.getPlanningUnitSWOTPlusButton()).perform();
		Thread.sleep(1000);
		if(goals.getPlanningUnitSWOTPlusButton().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		goals.getPlanningUnitSWOTTitleButton().click();
		Thread.sleep(3000);
		
		if(goals.getPlanningUnitSWOTTitleRight().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		if(goals.getPlanningUnitSWOTTitleRight().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		Actions action1 = new Actions(driver);

		action1.moveToElement(goals.getPlanningYearCurrentSWOTRight()).perform();
		Thread.sleep(1000);
		int fl=0;
		if(goals.getDateFieldSWOTRight().isDisplayed()&&goals.getPlanningYearCurrentSWOTRight().isDisplayed()&&goals.getDescriptionTextFieldSWOTRight().isDisplayed()) {
		}
		else {
			fl=1;
 		}

		JavascriptExecutor jr1 = (JavascriptExecutor)driver;
		jr1.executeScript("window.scrollBy(0,100)"); 
		Thread.sleep(2000);
		
		if(!goals.getAchievementsTextFieldSWOTRight().isDisplayed()) {
			fl=1;
		}
		if(!goals.getStrengthsTextFieldSWOTRight().isDisplayed()) {
			fl=1;
		}
		JavascriptExecutor jr2 = (JavascriptExecutor)driver;
		jr2.executeScript("window.scrollBy(0,100)"); 
		Thread.sleep(2000);
		if(!goals.getWeaknessTextFieldSWOTRight().isDisplayed()) {
			fl=1;
		}
		JavascriptExecutor jr3 = (JavascriptExecutor)driver;
		jr3.executeScript("window.scrollBy(0,100)"); 
		Thread.sleep(2000);
		if(!goals.getOpportunitiesTextFieldSWOTRight().isDisplayed()) {
			fl=1;
		}
		JavascriptExecutor jr4 = (JavascriptExecutor)driver;
		jr4.executeScript("window.scrollBy(0,100)"); 
		Thread.sleep(2000);
		if(!goals.getThreatsTextFieldSWOTRight().isDisplayed()) {
			fl=1;
		}
		
		Thread.sleep(5000);

		System.out.println(fl);
		if(fl==0) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		JavascriptExecutor jr5 = (JavascriptExecutor)driver;
		jr5.executeScript("window.scrollBy(0,-1000)"); 
		Thread.sleep(2000);
		String dateString=goals.getDateFieldSWOTRight().getText().trim();
		int fl1=0;
		if(!dateString.equals(currentDate)) {
			fl1=1;
		}
		
		if(goals.getPlanningYearCurrentSWOTRight().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		
		String desString=goals.getDescriptionTextFieldSWOTRight().getAttribute("value");
		
//		if(desString.length()==0) {
//			fl1=0;
//		}
//		else {
//			fl1=1;
//		}
		JavascriptExecutor jr6 = (JavascriptExecutor)driver;
		jr6.executeScript("window.scrollBy(0,300)"); 
		Thread.sleep(2000);
		
		String acString=goals.getAchievementsTextFieldSWOTRight().getAttribute("value");
//		if(acString.length()==0) {
//			fl1=0;
//		}
//		else {
//			fl1=1;
//		}
		JavascriptExecutor jr7 = (JavascriptExecutor)driver;
		jr7.executeScript("window.scrollBy(0,300)"); 
		Thread.sleep(2000);
		String strString=goals.getStrengthsTextFieldSWOTRight().getAttribute("value");
//		if(strString.length()!=0) {
//			fl1=1;
//		}
//		else {
//			fl1=0;
//		}
		
		JavascriptExecutor jr8 = (JavascriptExecutor)driver;
		jr8.executeScript("window.scrollBy(0,300)"); 
		Thread.sleep(2000);
		String weakString=goals.getWeaknessTextFieldSWOTRight().getAttribute("value");
//		if(weakString.length()!=0) {
//			fl1=1;
//		}
//		else {
//			fl1=0;
//		}
//		
		JavascriptExecutor jr9 = (JavascriptExecutor)driver;
		jr9.executeScript("window.scrollBy(0,300)"); 
		Thread.sleep(2000);
		String oppString=goals.getOpportunitiesTextFieldSWOTRight().getAttribute("value");
//		if(oppString.length()!=0) {
//			fl1=1;
//		}
//		else {
//			fl1=0;
//		}
//		
		JavascriptExecutor jr10 = (JavascriptExecutor)driver;
		jr10.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);
		String thrtString=goals.getThreatsTextFieldSWOTRight().getAttribute("value");
//		if(thrtString.length()!=0) {
//			fl1=1;
//		}
//		else {
//			fl1=0;
//		}
		
		
		//Not executed
		if(fl1==0) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		
		
		if(goals.getSaveButtonSWOTRight().isDisplayed()&&goals.getCancelButtonSWOTRight().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		if(!goals.getSaveButtonSWOTRight().isEnabled()&&goals.getCancelButtonSWOTRight().isEnabled()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}

		JavascriptExecutor jr11 = (JavascriptExecutor)driver;
		jr11.executeScript("window.scrollBy(0,-5000)"); 
		Thread.sleep(2000);
        
		String dtString=goals.getDateFieldSWOTRight().getText().trim();
		if(dtString.equals(currentDate)) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		
		goals.getInputDateSWOTRight().click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//tbody[1]/tr[4]/td[1]/span[1]")).click();// need to change according to current date.
		Thread.sleep(2000);
		if(goals.getDateFieldSWOTRight().getText().trim().equals(inputDateString)) {
			testcase1.add("Fail");
		}
		else {
			testcase1.add("Pass");
		}
		
		
		goals.getPlanningYearCurrentSWOTRight().click();
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//kendo-list/div/ul/li")).isDisplayed()&&driver.findElement(By.xpath("//kendo-list/div/ul/li[2]")).isDisplayed()
				&&driver.findElement(By.xpath("//kendo-list/div/ul/li[3]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		goals.getPlanningYearCurrentSWOTRight().click();
		Thread.sleep(2000);
		goals.getDescriptionTextFieldSWOTRight().click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(text(),'Description:')]")).click();
		Thread.sleep(2000);

		if(driver.findElement(By.xpath("//span[contains(text(),'Description is required')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		
		
		
		String valString=driver.findElement(By.xpath("//span[contains(text(),'Description is required')]")).getText().trim();
		if(valString.equals("Description is required")) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		
		//WebElement element = driver.findElement(By.xpath(""));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[contains(text(),'Achievements:')]")));
		
		Thread.sleep(3000);
		goals.getAchievementsTextFieldSWOTRight().click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[2]/app-plnning-unit-swot-edit[1]/div[1]")).click();
		//driver.findElement(By.xpath("//div[contains(text(),'Achievements:')]")).click();
		driver.findElement(By.xpath("//planning-unit-detail-header-tab/div[1]/div[1]/span[3]/span[1]/i[1]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//planning-unit-detail-header-tab/div[1]/div[1]/span[3]/span[1]/i[1]")).click();

		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//span[contains(text(),'Achievements is required')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		String achieveValString=driver.findElement(By.xpath("//span[contains(text(),'Achievements is required')]")).getText().trim();
		
		if(achieveValString.equals("Achievements is required")) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
//		JavascriptExecutor sc = (JavascriptExecutor)driver;
//		sc.executeScript("window.scrollBy(0,550)"); 
//		Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[contains(text(),'Strengths:')]")));
        
		
		Thread.sleep(2000);
		goals.getStrengthsTextFieldSWOTRight().click();
		Thread.sleep(1000);
       // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[contains(text(),'Strengths:')] ")));

		//Thread.sleep(2000);

		//driver.findElement(By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[2]/app-plnning-unit-swot-edit[1]/div[1]")).click();
		//driver.findElement(By.xpath("//div[contains(text(),'Strengths:')]")).click();
		driver.findElement(By.xpath("//planning-unit-detail-header-tab/div[1]/div[1]/span[3]/span[1]/i[1]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//planning-unit-detail-header-tab/div[1]/div[1]/span[3]/span[1]/i[1]")).click();

		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//span[contains(text(),'Strengths is required')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		String strengthValString=driver.findElement(By.xpath("//span[contains(text(),'Strengths is required')]")).getText().trim();
		
		if(achieveValString.equals("Strengths is required")) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[contains(text(),'Strengths:')] ")));
		
		Thread.sleep(1000);
//		goals.getWeaknessTextFieldSWOTRight().click();
//		Thread.sleep(2000);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[contains(text(),'Opportunities:')]")));
//
//		Thread.sleep(2000);
//
//		//driver.findElement(By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[2]/app-plnning-unit-swot-edit[1]/div[1]")).click();
//		//driver.findElement(By.xpath("//div[contains(text(),'Weaknesses:')]")).click();
//		driver.findElement(By.xpath("//planning-unit-detail-header-tab/div[1]/div[1]/span[3]/span[1]/i[1]")).click();
//		Thread.sleep(1000);
//
//		driver.findElement(By.xpath("//planning-unit-detail-header-tab/div[1]/div[1]/span[3]/span[1]/i[1]")).click();
//
//		Thread.sleep(2000);
//		if(driver.findElement(By.xpath("//span[contains(text(),'Weaknesses is required')]")).isDisplayed()) {
//			testcase1.add("Pass");
//		}
//		else {
//			testcase1.add("Fail");
//		}
//		String weakValString=driver.findElement(By.xpath("//span[contains(text(),'Weaknesses is required')]")).getText().trim();
//		
//		if(achieveValString.equals("Weaknesses is required")) {
//			testcase1.add("Pass");
//		}
//		else {
//			testcase1.add("Fail");
//		}
//		
//        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[contains(text(),'Opportunities:')]")));
//		
//		Thread.sleep(1000);
//		goals.getOpportunitiesTextFieldSWOTRight().click();
//		Thread.sleep(2000);
//		
//		//driver.findElement(By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[2]/app-plnning-unit-swot-edit[1]/div[1]")).click();
//		//driver.findElement(By.xpath("//div[contains(text(),'Opportunities:')]")).click();
//		driver.findElement(By.xpath("//planning-unit-detail-header-tab/div[1]/div[1]/span[3]/span[1]/i[1]")).click();
//		Thread.sleep(1000);
//
//		driver.findElement(By.xpath("//planning-unit-detail-header-tab/div[1]/div[1]/span[3]/span[1]/i[1]")).click();
//
//		Thread.sleep(2000);
//		if(driver.findElement(By.xpath("//span[contains(text(),'Opportunities is required')]")).isDisplayed()) {
//			testcase1.add("Pass");
//		}
//		else {
//			testcase1.add("Fail");
//		}
//		String oppValString=driver.findElement(By.xpath("//span[contains(text(),'Opportunities is required')]")).getText().trim();
//		
//		if(achieveValString.equals("Opportunities is required")) {
//			testcase1.add("Pass");
//		}
//		else {
//			testcase1.add("Fail");
//		}
//		
//		
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//div[contains(text(),'Threats:')]")));
//		
//		Thread.sleep(1000);
//		goals.getThreatsTextFieldSWOTRight().click();
//		Thread.sleep(2000);
//		
//		//driver.findElement(By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[2]/app-plnning-unit-swot-edit[1]/div[1]")).click();
//		//driver.findElement(By.xpath("//div[contains(text(),'Threats:')]")).click();
//		driver.findElement(By.xpath("//planning-unit-detail-header-tab/div[1]/div[1]/span[3]/span[1]/i[1]")).click();
//		Thread.sleep(1000);
//
//		driver.findElement(By.xpath("//planning-unit-detail-header-tab/div[1]/div[1]/span[3]/span[1]/i[1]")).click();
//
//		Thread.sleep(2000);
//		if(driver.findElement(By.xpath("//span[contains(text(),'Threats is required')]")).isDisplayed()) {
//			testcase1.add("Pass");
//		}
//		else {
//			testcase1.add("Fail");
//		}
//		String threatValString=driver.findElement(By.xpath("//span[contains(text(),'Threats is required')]")).getText().trim();
//		
//		if(achieveValString.equals("Threats is required")) {
//			testcase1.add("Pass");
//		}
//		else {
//			testcase1.add("Fail");
//		}
//		
//		
//		
		
	    ExcelUtil.writeToFile(172, testcase1);
		
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
