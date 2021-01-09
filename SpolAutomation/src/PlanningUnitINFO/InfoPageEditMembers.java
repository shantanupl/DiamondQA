package PlanningUnitINFO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.analysis.function.Divide;
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

import com.google.common.base.Verify;

import ModelClass.AllPlanningPage;
import ModelClass.ExcelUtil;
import ModelClass.PlanningUnitDetails;
import ModelClass.SpolLoginPage;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class InfoPageEditMembers {

	//85,86 need to change every time during run

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

	public InfoPageEditMembers() {
		// TODO Auto-generated constructor stub
	}
	@Test
	public void testInfoPageEditMembers() throws InterruptedException, IOException {
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
		String q3= "MemberA22"; 
		String q4 = "MemberUnitA22";
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

		planningUnitDetails.getmembersTitle().click();
		Thread.sleep(2000);
		if(planningUnitDetails.getMemberTitleRight().isDisplayed()) {
			testcase1.add("Pass");//93

		}
		else {
			testcase1.add("Fail");
		}
		Thread.sleep(1000);

		if(planningUnitDetails.getMemberSearchBarRight().isDisplayed()&&planningUnitDetails.getAdminSystemRight().isDisplayed()
				&&planningUnitDetails.getMemberSecondRight().isDisplayed()&&planningUnitDetails.getSupportRight().isDisplayed()&&planningUnitDetails.getTestUserRight().isDisplayed()
				) {
			testcase1.add("Pass");//94
		}
		else {
			testcase1.add("Fail");
		}


		if(planningUnitDetails.getPaginationButtonRight().isDisplayed()&&planningUnitDetails.getCancelButtonRight().isDisplayed()&&planningUnitDetails.getSaveButtonRight().isDisplayed()) {
			testcase1.add("Pass");//95
		}
		else {
			testcase1.add("Fail");
		}
		
		planningUnitDetails.getMemberSearchBarRight().click();
		Thread.sleep(1000);

		String bbString=planningUnitDetails.getMemberSearchBarRight().getAttribute("value");
		System.out.println(bbString);

		System.out.println(planningUnitDetails.getMemberSearchBarRight().getAttribute("value"));
		if(bbString.equals(null)||bbString.length()==0) {
			testcase1.add("Pass");//96
		}
		else {
			testcase1.add("Fail");
		}
		Thread.sleep(2000);


		//			if(driver.findElement(By.cssSelector("#k-grid3-checkbox0")).isDisplayed()) {
		//			
		//			testcase1.add("Pass");
		//		}
		//		else {
		//			testcase1.add("Fail");
		//		}
		JavascriptExecutor jv13 = (JavascriptExecutor)driver;
		jv13.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);
		try {
			Assert.assertFalse(driver.findElement(By.xpath("//input[@id='k-grid0-checkbox0']")).isSelected());
			testcase1.add("Pass");
		} catch (Exception e) {
			testcase1.add("Fail"); 
		}
		if(planningUnitDetails.getPaginationButtonRight().isDisplayed()&&planningUnitDetails.getCancelButtonRight().isEnabled()
				&&planningUnitDetails.getSaveButtonRight().isEnabled()) {
			testcase1.add("Pass");//98
		}
		else {
			testcase1.add("Fail");
		}

		planningUnitDetails.getCancelButtonRight().click();
		Thread.sleep(1000);
		try {
			Verify.verify(driver.findElement(By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[1]/planning-unit-details-home[1]/div[1]/planning-unit-members[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]")).isDisplayed());
			//Assert.assertFalse(planningUnitDetails.getCancelButtonRight().isDisplayed());
			testcase1.add("Pass");//99 

		} catch (Exception e) {
			testcase1.add("Fail");
		}

		planningUnitDetails.getmembersTitle().click();
		Thread.sleep(2000);

		planningUnitDetails.getSaveButtonRight().click();
		Thread.sleep(3000);
		try {
			Verify.verify(driver.findElement(By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[1]/planning-unit-details-home[1]/div[1]/planning-unit-members[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]")).isDisplayed());
			testcase1.add("Pass");//100

		} catch (Exception e) {
			testcase1.add("Fail");
		}
		JavascriptExecutor jv1 = (JavascriptExecutor)driver;
		jv1.executeScript("window.scrollBy(0,-1000)"); 
		Thread.sleep(2000);
		planningUnitDetails.getmembersTitle().click();
		Thread.sleep(2000);

		planningUnitDetails.getMemberSearchBarRight().sendKeys("Test");
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//td[contains(text(),'Test, User1')]")).isDisplayed()) {
			testcase1.add("Pass");//101
		} 
		else {
			testcase1.add("Fail");
		}
		planningUnitDetails.getMemberSearchBarRight().clear();
		Thread.sleep(2000);
		planningUnitDetails.getMemberSearchBarRight().sendKeys("Admin");
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//td[contains(text(),'Admin, System')]")).isDisplayed()) {
			testcase1.add("Pass");//102
		} 
		else {
			testcase1.add("Fail");
		}
		planningUnitDetails.getMemberSearchBarRight().clear();
		Thread.sleep(3000);

		planningUnitDetails.getCrossButtonRight().click();
		Thread.sleep(1000);
		planningUnitDetails.getmembersTitle().click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='k-grid3-checkbox0']")).click();
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//input[@id='k-grid3-checkbox0']")).isSelected()) {
			testcase1.add("Pass");//103
		} 
		else {
			testcase1.add("Fail");
		}
		driver.findElement(By.xpath("//input[@id='k-grid3-checkbox0']")).click();
		Thread.sleep(2000);
		planningUnitDetails.getMemberSearchBarRight().sendKeys("Admin");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='k-grid3-checkbox0']")).click();
		Thread.sleep(2000);

		JavascriptExecutor jv2 = (JavascriptExecutor)driver;
		jv2.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);
		planningUnitDetails.getSaveButtonRight().click();
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//div[contains(text(),'Admin, System')]")).isDisplayed()) {
			testcase1.add("Pass");//104
		} 
		else {
			testcase1.add("Fail");
		}
		JavascriptExecutor jv3 = (JavascriptExecutor)driver;
		jv3.executeScript("window.scrollBy(0,-1000)"); 
		Thread.sleep(2000);
		planningUnitDetails.getmembersTitle().click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='k-grid4-checkbox1']")).click();

		JavascriptExecutor jv4 = (JavascriptExecutor)driver;
		jv4.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);
		planningUnitDetails.getSaveButtonRight().click();
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//div[contains(text(),'Real, Sanaullah Al')]")).isDisplayed()) {
			testcase1.add("Pass");//105
		} 
		else {
			testcase1.add("Fail");
		}
		JavascriptExecutor jv5 = (JavascriptExecutor)driver;
		jv5.executeScript("window.scrollBy(0,-1000)"); 
		Thread.sleep(2000);
		planningUnitDetails.getmembersTitle().click();
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//input[@id='k-grid5-checkbox0']")).isSelected()&&driver.findElement(By.xpath("//input[@id='k-grid5-checkbox1']")).isSelected()) {
			testcase1.add("Pass");//106
		} 
		else {
			testcase1.add("Fail");
		}

		driver.findElement(By.xpath("//input[@id='k-grid5-checkbox2']")).click();
		Thread.sleep(2000);

		JavascriptExecutor jv6 = (JavascriptExecutor)driver;
		jv6.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);
		planningUnitDetails.getSaveButtonRight().click();
		Thread.sleep(2000);
		JavascriptExecutor jv7 = (JavascriptExecutor)driver;
		jv7.executeScript("window.scrollBy(0,-1000)"); 
		Thread.sleep(2000);
		planningUnitDetails.getmembersTitle().click();
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//input[@id='k-grid6-checkbox0']")).isSelected()&&driver.findElement(By.xpath("//input[@id='k-grid6-checkbox1']")).isSelected()&&driver.findElement(By.xpath("//input[@id='k-grid6-checkbox2']")).isSelected()) {
			testcase1.add("Pass");//107
		} 
		else {
			testcase1.add("Fail");
		}
		driver.findElement(By.xpath("//input[@id='k-grid6-checkbox0']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='k-grid6-checkbox1']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='k-grid6-checkbox2']")).click();
		Thread.sleep(1000);

		planningUnitDetails.getMemberSearchBarRight().sendKeys("tes");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='k-grid6-checkbox0']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='k-grid6-checkbox1']")).click();
		Thread.sleep(1000);
		JavascriptExecutor jv8 = (JavascriptExecutor)driver;
		jv8.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);
		planningUnitDetails.getSaveButtonRight().click();
		Thread.sleep(2000);
		JavascriptExecutor jv9 = (JavascriptExecutor)driver;
		jv9.executeScript("window.scrollBy(0,-1000)"); 
		Thread.sleep(2000);
		planningUnitDetails.getmembersTitle().click();
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//input[@id='k-grid7-checkbox0']")).isSelected()&&driver.findElement(By.xpath("//input[@id='k-grid7-checkbox1']")).isSelected()) {
			testcase1.add("Pass");//108
		} 
		else {
			testcase1.add("Fail");
		}
		driver.findElement(By.xpath("//input[@id='k-grid7-checkbox0']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='k-grid7-checkbox1']")).click();
		Thread.sleep(1000);
		JavascriptExecutor jsr1 = (JavascriptExecutor)driver;
		jsr1.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);
		planningUnitDetails.getSaveButtonRight().click();
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[1]/planning-unit-details-home[1]/div[1]/planning-unit-members[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]")).isDisplayed()) {
			testcase1.add("Pass");//109
		} 
		else {
			testcase1.add("Fail");
		}
		JavascriptExecutor jsp1 = (JavascriptExecutor)driver;
		jsp1.executeScript("window.scrollBy(0,-1000)"); 
		Thread.sleep(2000);		
		planningUnitDetails.getmembersTitle().click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='k-grid8-checkbox0']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='k-grid8-checkbox1']")).click();
		Thread.sleep(1000);
		JavascriptExecutor jsr2 = (JavascriptExecutor)driver;
		jsr2.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);
		planningUnitDetails.getSaveButtonRight().click();
		Thread.sleep(2000);
		JavascriptExecutor jsp2 = (JavascriptExecutor)driver;
		jsp2.executeScript("window.scrollBy(0,-1000)"); 
		Thread.sleep(2000);
		planningUnitDetails.getmembersTitle().click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='k-grid9-checkbox1']")).click();
		Thread.sleep(1000);
		JavascriptExecutor jsr3 = (JavascriptExecutor)driver;
		jsr3.executeScript("window.scrollBy(0,1000)"); 
		Thread.sleep(2000);
		planningUnitDetails.getSaveButtonRight().click();
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//div[contains(text(),'Admin, System')]")).isDisplayed()) {
			testcase1.add("Pass");//111
		} 
		else {
			testcase1.add("Fail");
		}
		JavascriptExecutor jsp3 = (JavascriptExecutor)driver;
		jsp3.executeScript("window.scrollBy(0,-1000)"); 
		Thread.sleep(2000);
		planningUnitDetails.getmembersTitle().click();
		Thread.sleep(2000);
		if(!driver.findElement(By.xpath("//input[@id='k-grid10-checkbox1']")).isSelected()) {
			testcase1.add("Pass");//112
		} 
		else {
			testcase1.add("Fail");
		}
	    ExcelUtil.writeToFile(94, testcase1);
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
	//Edit
	@AfterClass
	public void after() throws IOException {
		//driver.close();
		driver.quit();
	}


}
