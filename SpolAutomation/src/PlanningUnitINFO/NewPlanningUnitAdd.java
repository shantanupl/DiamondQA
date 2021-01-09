package PlanningUnitINFO;

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

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
// import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

//654,655,430,431,374,375 need to change on every run

public class NewPlanningUnitAdd {
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
	public WritableWorkbook workbookcopy;

	public ArrayList<String> testcase1 = new ArrayList<String>();



	@Test
	public void testNewPlanningUnit() throws InterruptedException, RowsExceededException, WriteException, IOException {
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
		try {
			Verify.verify(allPlanning.unitcodeTextfieldIsDisplayed());
			testcase1.add("Pass");

		} catch (Exception e) {
			testcase1.add("Fail");  

		}
		try {
			Verify.verify(allPlanning.unitcodeTextfieldIsDisplayed());
			testcase1.add("Pass");

		} catch (Exception e) {
			testcase1.add("Fail");  

		}


		try {
			Verify.verify(allPlanning.unitTitleTextfieldIsDisplayed());
			testcase1.add("Pass");

		} catch (Exception e) {
			testcase1.add("Fail");  

		}
		try {
			Verify.verify(allPlanning.unitManagerNewBDropdownIsDisplayed());
			testcase1.add("Pass");

		} catch (Exception e) {
			testcase1.add("Fail");  

		}
		try {
			Verify.verify(allPlanning.unitTypeDropdownIsDisplayed());
			testcase1.add("Pass");

		} catch (Exception e) {
			testcase1.add("Fail");  

		}
		try {
			Verify.verify(allPlanning.unitParentDropdownIsDisplayed());
			testcase1.add("Pass");
		} catch (Exception e) {
			testcase1.add("Fail");  
		}

		try {
			Verify.verify(allPlanning.unitPurposeTextfieldIsDisplayed());
			testcase1.add("Pass");
		} catch (Exception e) {
			testcase1.add("Fail");  
		}
		try {
			Verify.verify(allPlanning.saveButtonIsDisplayed());
			testcase1.add("Pass");
		} catch (Exception e) {
			testcase1.add("Fail");  
		}
		try {
			Verify.verify(allPlanning.cancelButtonIsDisplayed());
			testcase1.add("Pass");
		} catch (Exception e) {
			testcase1.add("Fail");  
		}

		try {
			Verify.verify(!allPlanning.saveIsEnable());
			testcase1.add("Pass");
		} catch (Exception e) {
			testcase1.add("Fail");  
		}

		try {
			Verify.verify(allPlanning.cancelIsEnable());
			testcase1.add("Pass");
		} catch (Exception e) {
			testcase1.add("Fail");  
		}

		allPlanning.clickSave();
		Thread.sleep(1000);

		try {
			Verify.verify(!allPlanning.saveIsEnable());
			testcase1.add("Pass");
		} catch (Exception e) {
			testcase1.add("Fail");  
		}
		Thread.sleep(1000);

		allPlanning.clickCancel();
		Thread.sleep(2000);

		try {
			Verify.verify(allPlanning.unitManagerDropdownIsDisplayed());
			testcase1.add("Pass");
		} catch (Exception e) {
			testcase1.add("Fail");  
		}

		allPlanning.clickEllipsisIcon();
		Thread.sleep(2000);
		allPlanning.clickNewPlan();
		Thread.sleep(2000);

		try {
			//Verify.verify(!allPlanning.UnitCodeTextFieldIsSelected());     //
			testcase1.add("Not executed");
		} catch (Exception e) {
			testcase1.add("Fail");  
		}

		allPlanning.clickUnitCodeTextField();
		Thread.sleep(1000);
		try {
			//Verify.verify(allPlanning.UnitCodeTextFieldIsSelected());
			testcase1.add("Not executed");
		} catch (Exception e) {
			testcase1.add("Fail");  
		}

		allPlanning.clickUnitTitleTextField();;
		Thread.sleep(1000);
		try {
			Verify.verify(allPlanning.unitCodeWarningIsDisplayed());
			testcase1.add("Pass");
		} catch (Exception e) {
			testcase1.add("Fail");  
		}

		try {
			SoftAssert softAssert1 = new SoftAssert();
			softAssert1.assertEquals(allPlanning.getUnitcodeWarningMsg(), "Planning Unit Code is required");

			testcase1.add("Pass");
		} catch (Exception e) {
			testcase1.add("Fail");  
		}



		allPlanning.clickUnitCodeTextField();
		Thread.sleep(1000);


		try {
			Verify.verify(allPlanning.unitTitleWarningIsDisplayed());
			testcase1.add("Pass");
		} catch (Exception e) {
			testcase1.add("Fail");  
		}

		try {
			SoftAssert softAssert1 = new SoftAssert();
			softAssert1.assertEquals(allPlanning.getUnitTitleWarningMsg(), "Planning Unit Code is required");

			testcase1.add("Pass");
		} catch (Exception e) {
			testcase1.add("Fail");  
		}

		allPlanning.clickUnitManagerNewDropdown();
		Thread.sleep(2000);
		try {
			Verify.verify(allPlanning.plannningUnitDropdownValIsDisplayed());
			testcase1.add("Pass");
		} catch (Exception e) {
			testcase1.add("Fail");  
		}

		allPlanning.sendKeyUnitCode("14A");
		Thread.sleep(2000);

		allPlanning.sendKeyUnitTitle("Title1");

		Thread.sleep(2000);

		Thread.sleep(2000);
		try {
			Verify.verify(allPlanning.plannningUnitDropdownValIsDisplayed());
			testcase1.add("Pass");
		} catch (Exception e) {
			testcase1.add("Fail");  
		}

		allPlanning.clickPlanningUnitType();
		Thread.sleep(1000);
		try {
			Verify.verify(allPlanning.unitManagerNewWarningIsDisplayed());
			testcase1.add("Pass");
		} catch (Exception e) {
			testcase1.add("Fail");  
		}

		try {
			SoftAssert softAssert1 = new SoftAssert();
			softAssert1.assertEquals(allPlanning.getUnitManagerNewWarningMsg(), "Planning Unit Manager is required");

			testcase1.add("Pass");
		} catch (Exception e) {
			testcase1.add("Fail");  
		}
		try {
			Verify.verify(driver.findElement(By.xpath("//kendo-list/div/ul/li[2]")).isDisplayed());

			testcase1.add("Pass");
		} catch (Exception e) {
			testcase1.add("Fail");  
		}
		
		allPlanning.getPlanningUnitCode().clear();
		allPlanning.getPlanningUnitTitle().clear();
		allPlanning.getPlannningUnitTypeDrop().click();
		Thread.sleep(1000);
		try {
			Verify.verify(driver.findElement(By.xpath("//kendo-list/div/ul/li[2]")).isDisplayed());

			testcase1.add("Pass");
		} catch (Exception e) {
			testcase1.add("Fail");  
		}
		
		String uc = "11B";
		String ut ="UnitB";
		allPlanning.getPlanningUnitCode().sendKeys(uc);
		Thread.sleep(1000);
		allPlanning.getPlanningUnitTitle().sendKeys(ut);
		Thread.sleep(1000);
		allPlanning.clickPlanningUnitType();
		Thread.sleep(1000);
		try {
			Verify.verify(driver.findElement(By.xpath("//kendo-list/div/ul/li[2]")).isDisplayed());
			testcase1.add("Pass");
		} catch (Exception e) {
			testcase1.add("Fail");  
		}

		testcase1.add("Not executed");

		allPlanning.clickCancel();
		Thread.sleep(2000);

		allPlanning.clickEllipsisIcon();
		Thread.sleep(2000);
		allPlanning.clickNewPlan();
		Thread.sleep(2000);
		allPlanning.clickPlanningUnitType();
		Thread.sleep(1000);
		allPlanning.clickUnitManagerNewDropdown();
		Thread.sleep(1000);


		try {
			Verify.verify(allPlanning.getPlanningUnitTypeWarning().isDisplayed());
			testcase1.add("Pass");
		} catch (Exception e) {
			testcase1.add("Fail");  
		}

		try {
			SoftAssert softAssert1 = new SoftAssert();
			softAssert1.assertEquals(allPlanning.getPlanningUnitTypeWarning().getText().trim(), "Planning Unit Type is required");

			testcase1.add("Pass");
		} catch (Exception e) {
			testcase1.add("Fail");  
		}
		testcase1.add("Not executed");//48
		testcase1.add("Not executed");//49
		allPlanning.clickUnitManagerNewDropdown();
		Thread.sleep(1000);
		//Need to change every time before run
		String s1="10Z9";
		String s2="UnitZ29";
		//Need to change every time before run

		allPlanning.getPlanningUnitCode().sendKeys(s1);

		allPlanning.getPlanningUnitTitle().sendKeys(s2);
		Thread.sleep(1000);

		allPlanning.clickUnitManagerNewDropdown();
		Thread.sleep(1000);
		allPlanning.getUnitManagerAbadia().click();
		Thread.sleep(1000);
		allPlanning.clickPlanningUnitType();
		Thread.sleep(2000);
//		
		//Select sel = new Select(allPlanning.getPlannningUnitTypeDrop());
//		sel.selectByVisibleText("Support");
		//allPlanning.getplannningUnitTypeValidation().click();
		//List <WebElement> options = sel.getOptions();
		//options.get(1).click();
		
		//driver.switchTo().frame(arg0)
		
		//driver.findElement(By.xpath("//span[contains(@class,'k-dropdown-wrap k-state-default') and contains(text(),'Support')]")).click();
		driver.findElement(By.xpath("//kendo-list/div/ul/li[2]")).click();
		//driver.findElement(By.className("k-dropdown-wrap k-state-default"));
		//driver.findElement(By.tagName("app-message")).findElement(By.tagName("_ngcontent-ng-cli-universal-c0")).click();
		//driver.findElements(By.tagName("span")).get(1).click();
		
		//driver.findElement(By.xpath("//planningunit-subheader-tab/div[2]/app-new-planning-unit[1]/kendo-dialog[1]/div[2]/div[1]/div[1]/div[2]/div[2]/kendo-dropdownlist[1]"));
		Thread.sleep(2000);
		allPlanning.clickSave();

		WebDriverWait wait2 = new WebDriverWait(driver,500);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+s1+" - "+s2+"')]")));//

		try {
				driver.findElement(By.xpath("//span[contains(text(),'"+s1+" - "+s2+"')]")).isDisplayed();
				testcase1.add("Pass");  

		} catch (Exception e) {
			testcase1.add("Fail");  
		}
		allPlanning.getBackButtonFromPlanningUnitDetails().click();
		WebDriverWait wait3 = new WebDriverWait(driver,100);

		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='dropdownMenuButton']")));
		Thread.sleep(3000);

		allPlanning.clickEllipsisIcon();
		Thread.sleep(2000);
		allPlanning.clickNewPlan();
		Thread.sleep(2000);
		
		//Need to change every time before run
		String s3= "22Z9";
		String s4 = "UnitCZ9";
		//Need to change every time before run

		allPlanning.getPlanningUnitCode().sendKeys(s3);

		allPlanning.getPlanningUnitTitle().sendKeys(s4);
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
		Thread.sleep(1000);
		driver.findElement(By.xpath("//planningunit-subheader-tab/div[2]/app-new-planning-unit[1]/kendo-dialog[1]/div[2]/div[1]/div[1]/div[3]/tree-view-dropdown[1]/div[1]/div[1]/div[1]/kendo-treeview[1]/ul[1]/li[1]/div[1]/span[2]"));
		Thread.sleep(1000);
		
		allPlanning.getUnitPurposeTextfield().sendKeys("Test purpose");
		allPlanning.clickSave();
		WebDriverWait wait4 = new WebDriverWait(driver,500);

		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+s3+" - "+s4+"')]")));//
		try {
			driver.findElement(By.xpath("//span[contains(text(),'"+s3+" - "+s4+"')]")).isDisplayed();
			testcase1.add("Pass");  

		} catch (Exception e) {
		testcase1.add("Fail");  

		}

		allPlanning.getBackButtonFromPlanningUnitDetails().click();
		WebDriverWait wait5 = new WebDriverWait(driver,100);

		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='dropdownMenuButton']")));
		Thread.sleep(3000);
		allPlanning.clickEllipsisIcon();
		Thread.sleep(2000);
		allPlanning.clickNewPlan();
		Thread.sleep(2000);

		try {
			allPlanning.getPlanningUnitCode().sendKeys("Hello_this123_EC11AA");//1. Planning unit code: ""
			String valString = allPlanning.getPlanningUnitCode().getAttribute("value");
			//Thread.sleep(4000);
			Assert.assertEquals(valString, "Hello_this123_EC11AA");

			testcase1.add("Pass");
		} catch (Exception e) {
			testcase1.add("Fail");
		}
		allPlanning.getPlanningUnitCode().clear();
		
		try {
			allPlanning.getPlanningUnitCode().sendKeys("helloworld_helloworld_hello");//1. Planning unit code: ""
			Thread.sleep(1000);
			String dString = allPlanning.getPlanningUnitCode().getAttribute("value");
			Assert.assertEquals(dString, "helloworld_helloworl");
			testcase1.add("Pass");
		} catch (Exception e) {
			testcase1.add("Fail");  
		}
		allPlanning.getPlanningUnitCode().clear();
		allPlanning.getPlanningUnitCode().sendKeys("~!@#$%^&*()-_+={}[]|");
		Thread.sleep(3000);
			String spString = allPlanning.getPlanningUnitCode().getAttribute("value");
			int sz = spString.length();
			if(sz>1) {
			testcase1.add("Fail");  
			}
			else {
				testcase1.add("Pass");

			}
		
		allPlanning.getPlanningUnitCode().clear();

		
		String d1 = "PL_001";
		String d2 = "PL1";
		allPlanning.getPlanningUnitCode().sendKeys(d1);
		allPlanning.getPlanningUnitTitle().sendKeys(d2);
		allPlanning.clickUnitManagerNewDropdown();
		Thread.sleep(1000);
		allPlanning.getUnitManagerAbadia().click();
		Thread.sleep(1000);
		allPlanning.clickPlanningUnitType();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//kendo-list/div/ul/li[2]")).click();
		Thread.sleep(1000);
		allPlanning.clickSave();
		//WebDriverWait wait7 = new WebDriverWait(driver,500);

		//wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+d1+" - "+d2+"')]")));//
		Thread.sleep(6000);

		try {
			driver.findElement(By.xpath("//span[contains(text(),'"+d1+" - "+d2+"')]")).isDisplayed();
			testcase1.add("Fail");  

		} catch (Exception e) {
		testcase1.add("Pass");  

		}

		allPlanning.getBackButtonFromPlanningUnitDetails().click();
		WebDriverWait wait6 = new WebDriverWait(driver,100);

		wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='dropdownMenuButton']")));
		Thread.sleep(3000);
		allPlanning.clickEllipsisIcon();
		Thread.sleep(2000);
		allPlanning.clickNewPlan();
		Thread.sleep(2000);

		testcase1.add("Not executed");
		try {
			allPlanning.getPlanningUnitCode().sendKeys("Hello_this123_EC11AA");
			Thread.sleep(1000);

			allPlanning.getPlanningUnitTitle().sendKeys("Hello_this123_EC11BB");
			Thread.sleep(1000);
			String gString = allPlanning.getPlanningUnitTitle().getAttribute("value");
			Assert.assertEquals(gString, "Hello_this123_EC11BB");
			testcase1.add("Pass");
		} catch (Exception e) {
			testcase1.add("Fail");
		}
		
		allPlanning.getPlanningUnitTitle().clear();
		
		allPlanning.getPlanningUnitTitle().sendKeys("Hello_this123_EC11AAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaacccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccckkkasdfghasdfasasasadxqa");
		Thread.sleep(1000);

		try {
			Assert.assertEquals(allPlanning.getPlanningUnitTitle().getAttribute("value"), "Hello_this123_EC11AAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaacccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccckkkasdfghasdfasasasadx");
			testcase1.add("Pass");
		} catch (Exception e) {
			testcase1.add("Fail");
		}
		
		
		allPlanning.clickCancel();
		Thread.sleep(2000);
		
		
		allPlanning.clickEllipsisIcon();
		Thread.sleep(2000);
		allPlanning.clickNewPlan();
		Thread.sleep(2000);
		String e3= "PL_001";
		String e4 = "PL1";
		allPlanning.getPlanningUnitCode().sendKeys(e3);

		allPlanning.getPlanningUnitTitle().sendKeys(e4);
		Thread.sleep(1000);

		allPlanning.clickUnitManagerNewDropdown();
		Thread.sleep(1000);
		allPlanning.getUnitManagerAbadia().click();
		Thread.sleep(1000);
		allPlanning.clickPlanningUnitType();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//kendo-list/div/ul/li[2]")).click();
		Thread.sleep(1000);
		allPlanning.clickSave();

		//WebDriverWait wait7 = new WebDriverWait(driver,500);

		//wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+d1+" - "+d2+"')]")));//
		Thread.sleep(6000);

		try {
			driver.findElement(By.xpath("//span[contains(text(),'"+e3+" - "+e4+"')]")).isDisplayed();
			testcase1.add("Fail");  

		} catch (Exception e) {
		testcase1.add("Pass");  

		}

		allPlanning.getBackButtonFromPlanningUnitDetails().click();
		WebDriverWait wait9 = new WebDriverWait(driver,100);

		wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='dropdownMenuButton']")));
		Thread.sleep(3000);
		allPlanning.clickEllipsisIcon();
		Thread.sleep(2000);
		allPlanning.clickNewPlan();
		Thread.sleep(2000);
		
		
		String cxString="Hello_this123_EC11AAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaacccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccckkkasdfghasdfasasasadxqa";
		allPlanning.getUnitPurposeTextfield().sendKeys(cxString);
		Thread.sleep(3000);
		
		//allPlanning.getPlanningUnitCode().click();
		String purString = allPlanning.getUnitPurposeTextfield().getAttribute("value");
		System.out.println(purString);
		Thread.sleep(1000);
//		try {
//			Assert.assertEquals(allPlanning.getUnitPurposeTextfield().getAttribute("value"), "Hello_this123_EC11AAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaacccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccckkkasdfghasdfasasasadxqa");
//			testcase1.add("Pass");
//		} catch (Exception e) {
//			testcase1.add("Fail");
//		}
		
		if(purString==cxString) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		
		allPlanning.getUnitPurposeTextfield().clear();
		Thread.sleep(1000);
		
		//Need to change every time before run
		String q3= "CodeA5";
		String q4 = "UnitCA5";
		//Need to change every time before run

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
		allPlanning.clickSave();
		WebDriverWait wait7 = new WebDriverWait(driver,500);

		wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+q3+" - "+q4+"')]")));//
		Thread.sleep(6000);

		try {
			driver.findElement(By.xpath("//span[contains(text(),'"+q3+" - "+q4+"')]")).isDisplayed();
			testcase1.add("Pass");  

		} catch (Exception e) {
		testcase1.add("Fail");  

		}
		
		Thread.sleep(1000);				
		System.out.println(testcase1.size());
		ExcelUtil.writeToFile(20, testcase1);
		Thread.sleep(2000);	 
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
	}
	
	//planning

	@AfterClass
	public void afterSuite() {
		driver.close();
		driver.quit();
	}

}
