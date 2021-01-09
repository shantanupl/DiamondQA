package PlanningUnitINFO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Verify;

import ModelClass.AllPlanningPage;
import ModelClass.ExcelUtil;
import ModelClass.SpolLoginPage;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class InitialViewPage {
	//Initial
	WebDriver driver;
	AllPlanningPage homepage;
	SpolLoginPage loginpage;
	AllPlanningPage allPlanning;
	HSSFWorkbook workbook;
	//define an Excel Work sheet
	HSSFSheet sheet;
	//define a test result data object
	Map<String, Object[]> testresultdata;
	public String Testcase; 
	public WritableSheet writablesh; 
	//public WritableSheet writablesh1;

	public WritableWorkbook workbookcopy;
	//public Workbook workbookcopy1;
	public ArrayList<String> testcase = new ArrayList<String>();


	public InitialViewPage() {
		// TODO Auto-generated constructor stub
	}
	@BeforeClass
	private void setup() throws BiffException,IOException,RowsExceededException,WriteException, InterruptedException{
		System.setProperty("webdriver.chrome.driver","E:\\Web automation\\chromedriver_win32\\chromedriver.exe");

		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://diamondbetaauth.strategicplanningonline.com/Account/Login?returnUrl=http%3A%2F%2Fdiamondbeta.strategicplanningonline.com%2F");
		homepage= new AllPlanningPage(driver);
		loginpage= new SpolLoginPage(driver);
		allPlanning= new AllPlanningPage(driver);
	}

	@Test(priority = 1)
	public void testLogin() throws InterruptedException {

		loginpage.typeEmailId("spaul");
		Thread.sleep(2000);
		loginpage.typePassword("sp123");
		Thread.sleep(2000);
		loginpage.clickSignIn();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/app-root[1]/div[1]/app-nav-menu[1]/aside[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]/i[1]")));
		try {
			Assert.assertTrue(driver.findElement(By.xpath("//body/app-root[1]/div[1]/app-nav-menu[1]/aside[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]/i[1]")).isDisplayed());
			//testresultdata.put("2", new Object[] {1d, "Check Login", "Login Success","Pass"});

		} catch (Exception e) {
			//testresultdata.put("2", new Object[] {1d, "Check Login", "Login Success","Fail"});
		}
	}
	
	@Test(priority = 2)
	public void testInitialViewPage() throws InterruptedException, RowsExceededException, WriteException, IOException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body/app-root[1]/div[1]/app-nav-menu[1]/aside[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]/i[1]")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'All Planning')]")).click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='dropdownMenuButton']")));
		Thread.sleep(3000);
		SoftAssert softAssert =new SoftAssert();

		//Verify.verify(allPlanning.pageTitleIsDisplayed());
		try {
			softAssert.assertTrue(allPlanning.pageTitleIsDisplayed());
			testcase.add("Pass");

		} catch (Exception e) {
			testcase.add("Fail");

		}
		//		  Label l3=new Label(10,2,Testcase);
		//		  writablesh.addCell(l3);
		try {
			Verify.verify(allPlanning.detailButtonPrimaryIsDisplayed());
			testcase.add("Pass");


		} catch (Exception e) {
			testcase.add("Fail");


		}


		try {
			Verify.verify(allPlanning.detailButtonSecondaryIsDisplayed());
			Testcase = "PASS";
			testcase.add("Pass");


		} catch (Exception e) {
			Testcase = "Fail";
			testcase.add("Fail");


		}
		//		  Label l7=new Label(10,6,Testcase);
		//		  writablesh.addCell(l7);

		try {
			Verify.verify(allPlanning.searchBarIsDisplayed());
			Testcase = "PASS";
			testcase.add("Pass");


		} catch (Exception e) {
			Testcase = "Fail";
			testcase.add("Fail");


		}
		//		  Label l8=new Label(10,7,Testcase);
		//		  writablesh.addCell(l8);

		try {
			Verify.verify(allPlanning.unitManagerDropdownIsDisplayed());
			testcase.add("Pass");


		} catch (Exception e) {
			testcase.add("Fail");


		}
		try {
			Verify.verify(allPlanning.allUnitsDropdownIsDisplayed());
			testcase.add("Pass");
		} catch (Exception e) {
			testcase.add("Fail");
		}
		try {
			Verify.verify(allPlanning.allUnitsCheckboxIsDisplayed());
			testcase.add("Pass");
		} catch (Exception e) {
			testcase.add("Fail");
		}

		try {
			Verify.verify(allPlanning.downloadIconIsDisplayed());
			testcase.add("Pass");
		} catch (Exception e) {
			testcase.add("Fail");
		}
		try {
			Verify.verify(allPlanning.ellipsisIconIsDisplayed());
			testcase.add("Pass");
		} catch (Exception e) {
			testcase.add("Fail");  
		}
		try {
			Verify.verify(allPlanning.objIsDisplayed());
			testcase.add("Pass");

		} catch (Exception e) {
			testcase.add("Fail");  
		}
		
		try {
			Verify.verify(allPlanning.searchEmpty().isEmpty());
			testcase.add("Pass");
		} catch (Exception e) {
			testcase.add("Fail");
		}
		try {
			softAssert.assertEquals(allPlanning.getUnitText(), "Unit Manager");
			testcase.add("Pass");

		} catch (Exception e) {
			testcase.add("Fail");
		}
		
		try {
			softAssert.assertEquals(allPlanning.getAllUnitDropText(), "All Units");
			testcase.add("Pass");

		} catch (Exception e) {
			testcase.add("Fail");
		}
		
		try {
               Verify.verify(!allPlanning.viewAllUnitsCheckboxSelected());			
               testcase.add("Pass");

		} catch (Exception e) {
			testcase.add("Fail");
		}
		
		
		testcase.add("Not executed");//test case 15
		testcase.add("Not executed");//test case 16
		testcase.add("Not executed");//test case 17
		
		try {
            Verify.verify(allPlanning.sampleunitDisplay());
            Verify.verify(allPlanning.sampleunitManagerDisplay());			

            testcase.add("Pass");

		} catch (Exception e) {
			testcase.add("Fail");
		}
        	
		Thread.sleep(3000);
	    ExcelUtil.writeToFile(2, testcase);
	}
	
	@AfterClass
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
