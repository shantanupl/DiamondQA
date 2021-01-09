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
import org.testng.Assert;
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

//84,85,176,177,267,268 need to change on every run

public class PlanningUnitDeleteDeactivateEdit {
	WebDriver driver;
	AllPlanningPage homepage;
	SpolLoginPage loginpage;
	AllPlanningPage allPlanning;
	HSSFWorkbook workbook;
	PlanningUnitDetails planningUnitDetails;
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

	public PlanningUnitDeleteDeactivateEdit() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void testDeleteDeactivate() throws InterruptedException, IOException {
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
		String q3= "DeleteA15"; 
		String q4 = "DeleteUnitA15";
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

		planningUnitDetails.getUnitManagerTitle().click();
		Thread.sleep(2000);
		planningUnitDetails.getDot3ButtonRight().click();
		Thread.sleep(1000);

		if(planningUnitDetails.getEditErpButton().isDisplayed()&&planningUnitDetails.getDeleteButtonRight().isDisplayed()&&planningUnitDetails.getDeactiveButtonRight().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}	
		planningUnitDetails.getDeleteButtonRight().click();
		Thread.sleep(1000);

		if(planningUnitDetails.getCancelButtonFromDelete().isDisplayed()&&planningUnitDetails.getDeleteButtonFromDelete().isDisplayed()&&planningUnitDetails.getConfirmDeleteText().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}

		planningUnitDetails.getCancelButtonFromDelete().click();
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//span[contains(text(),'"+q3+" - "+q4+"')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		planningUnitDetails.getDot3ButtonRight().click();
		Thread.sleep(1000);
		planningUnitDetails.getDeleteButtonRight().click();
		Thread.sleep(2000);
		planningUnitDetails.getDeleteButtonFromDelete().click();

		WebDriverWait wait2 = new WebDriverWait(driver,500);

		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='dropdownMenuButton']")));//
		if(driver.findElement(By.xpath("//button[@id='dropdownMenuButton']")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		
		testcase1.add("Not executed");
		testcase1.add("Not executed");

		driver.findElement(By.xpath("//body/app-root[1]/div[1]/app-nav-menu[1]/aside[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]/i[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'All Planning')]")).click();
		WebDriverWait wt1 = new WebDriverWait(driver,100);
		wt1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='dropdownMenuButton']")));
		Thread.sleep(3000);

		allPlanning.clickEllipsisIcon();
		Thread.sleep(2000);
		allPlanning.clickNewPlan();
		Thread.sleep(2000);
		String st3= "Delete2A15"; 
		String st4 = "DeleteUnit2A15";
		allPlanning.getPlanningUnitCode().sendKeys(st3);
		allPlanning.getPlanningUnitTitle().sendKeys(st4);
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

		WebDriverWait wt7 = new WebDriverWait(driver,500);

		wt7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+st3+" - "+st4+"')]")));//
		Thread.sleep(6000);

		planningUnitDetails.getUnitManagerTitle().click();
		Thread.sleep(2000);
		planningUnitDetails.getDot3ButtonRight().click();
		Thread.sleep(1000);

		planningUnitDetails.getDeactiveButtonRight().click();
		Thread.sleep(2000);
		if(planningUnitDetails.getNoButtonFromDeactivate().isDisplayed()&&planningUnitDetails.getYesButtonFromDeactivate().isDisplayed()&&planningUnitDetails.getConfirmDeactivateText().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}

		planningUnitDetails.getNoButtonFromDeactivate().click();
		Thread.sleep(2000);

		if(driver.findElement(By.xpath("//span[contains(text(),'"+st3+" - "+st4+"')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}

		planningUnitDetails.getDot3ButtonRight().click();
		Thread.sleep(1000);

		planningUnitDetails.getDeactiveButtonRight().click();
		Thread.sleep(2000);
		planningUnitDetails.getYesButtonFromDeactivate().click();
		Thread.sleep(4000);
		//WebDriverWait wait3 = new WebDriverWait(driver,100);

		//wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='dropdownMenuButton']")));//
		if(driver.findElement(By.xpath("//button[@id='detailButton']")).isDisplayed()) {
			testcase1.add("Pass");      
		}
		else {
			testcase1.add("Fail");
		}


		testcase1.add("Not executed");


		driver.findElement(By.xpath("//body/app-root[1]/div[1]/app-nav-menu[1]/aside[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]/i[1]")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[contains(text(),'All Planning')]")).click();

		WebDriverWait wt2 = new WebDriverWait(driver,100);

		wt2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='dropdownMenuButton']")));
		Thread.sleep(3000);

		allPlanning.clickEllipsisIcon();
		Thread.sleep(2000);
		allPlanning.clickNewPlan();
		Thread.sleep(2000);
		String st1= "Delete3A15"; 
		String st2 = "DeleteUnit3A15";
		allPlanning.getPlanningUnitCode().sendKeys(st1);
		allPlanning.getPlanningUnitTitle().sendKeys(st2);
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

		WebDriverWait wt8 = new WebDriverWait(driver,500);

		wt8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+st1+" - "+st2+"')]")));//
		Thread.sleep(6000);

		planningUnitDetails.getUnitManagerTitle().click();
		Thread.sleep(2000);
		planningUnitDetails.getDot3ButtonRight().click();
		Thread.sleep(1000);

		planningUnitDetails.getEditErpButton().click();
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//label[contains(text(),'Erp Id')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}

		if(planningUnitDetails.getCancelButtonFromEditErp().isEnabled()&&(!planningUnitDetails.getSaveButtonFromEditErp().isEnabled())) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}

		planningUnitDetails.getCancelButtonFromEditErp().click();
		Thread.sleep(1000);
		try {
			Assert.assertFalse(planningUnitDetails.getEditErpTextField().isDisplayed());
			testcase1.add("Fail");

		} catch (Exception e) {
			testcase1.add("Pass");
		}
		planningUnitDetails.getDot3ButtonRight().click();
		Thread.sleep(1000);

		planningUnitDetails.getEditErpButton().click();
		Thread.sleep(1000);
		planningUnitDetails.getEditErpTextField().click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[contains(text(),'Erp Id')]")).click();
		Thread.sleep(1000);

		if(driver.findElement(By.xpath("//span[contains(text(),'Erp Id is required')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		planningUnitDetails.getEditErpTextField().click();
		Thread.sleep(1000);
		planningUnitDetails.getEditErpTextField().sendKeys("erp2");
		Thread.sleep(1000);

		if(planningUnitDetails.getSaveButtonFromEditErp().isEnabled()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}

		planningUnitDetails.getSaveButtonFromEditErp().click();
		Thread.sleep(5000);
		try {
			Assert.assertFalse(planningUnitDetails.getSaveButtonFromEditErp().isDisplayed());
			testcase1.add("Fail");

		} catch (Exception e) {
			testcase1.add("Pass");
		}

		String ed1 = st1+"1";
		String ed2 = st2+"1";
		planningUnitDetails.getUnitCodeRight().clear();
		planningUnitDetails.getUnitTitleRight().clear();
		Thread.sleep(1000);
		planningUnitDetails.getUnitCodeRight().sendKeys(ed1);
		Thread.sleep(1000);
		planningUnitDetails.getUnitTitleRight().sendKeys(ed2);
		Thread.sleep(1000);

		JavascriptExecutor jsp3 = (JavascriptExecutor)driver;
		jsp3.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);
		planningUnitDetails.getSaveButtonRight().click();
		Thread.sleep(2000);
		try {
			Assert.assertFalse(planningUnitDetails.getSaveButtonRight().isDisplayed());
			testcase1.add("Fail");

		} catch (Exception e) {
			testcase1.add("Pass");
		}
		JavascriptExecutor jsp1 = (JavascriptExecutor)driver;
		jsp1.executeScript("window.scrollBy(0,-1000)"); 
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//span[contains(text(),'"+ed1+" - "+ed2+"')]")).isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		ExcelUtil.writeToFile(113, testcase1);
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
