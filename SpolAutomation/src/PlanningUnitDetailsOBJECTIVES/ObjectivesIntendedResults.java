package PlanningUnitDetailsOBJECTIVES;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
import org.sikuli.script.FindFailed;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ModelClass.AllPlanningPage;
import ModelClass.ExcelUtil;
import ModelClass.Goals;
import ModelClass.ObjectivesResults;
import ModelClass.ObjectivesTasks;
import ModelClass.PlanningUnitDetails;
import ModelClass.SpolLoginPage;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ObjectivesIntendedResults {
	WebDriver driver;
	AllPlanningPage homepage;
	SpolLoginPage loginpage;
	AllPlanningPage allPlanning;
	HSSFWorkbook workbook;
	PlanningUnitDetails planningUnitDetails;
	Goals goals;
	ObjectivesResults objectives;
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
	
	public ObjectivesIntendedResults() {
		// TODO Auto-generated constructor stub
	}
	
	@BeforeClass
	private void setup() throws BiffException,IOException,RowsExceededException,WriteException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/resources/drivers/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://diamondqa.strategicplanningonline.com/");
		//driver.get("https://diamondbeta.strategicplanningonline.com/");
	}
	
	@Test
	public void verifyAddTaskPage() throws InterruptedException, IOException, FindFailed {
		homepage= new AllPlanningPage(driver);
		loginpage= new SpolLoginPage(driver);
		allPlanning= new AllPlanningPage(driver);
		objectives=new ObjectivesResults(driver);
		loginpage.typeEmailId("spaul");
		//Thread.sleep(2000);
		loginpage.typePassword("spaul");
		//Thread.sleep(2000);
		loginpage.clickSignIn();
		WebDriverWait wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i.fas.fa-calendar-check")));
		
		//Click Planning SideMenu
		driver.findElement(By.cssSelector("i.fas.fa-calendar-check")).click();
		Thread.sleep(3000);
        //Click All Planning from SubMenu
		driver.findElement(By.xpath("//a[contains(text(),'All Planning')]")).click();
		WebDriverWait wait1 = new WebDriverWait(driver,100);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'AFavUnitA986')]")));
		Thread.sleep(3000); 
		//Click 75 - DRAFT - Objective Title for Edit
		driver.findElement(By.xpath("//a[contains(text(),'75 - DRAFT - Objective Title for Edit')]")).click();
		WebDriverWait wait2 = new WebDriverWait(driver,60);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.page-header2")));
		//Click Results
		driver.findElement(By.xpath("//button[contains(text(),'Results')]")).click();
		Thread.sleep(5000);
		//objectives.addIntendedResultData();
		//objectives.deleteIntendedResultsData();
		//Start Intended Results
		if(objectives.getObjectiveIntendedResultLink().isDisplayed()&&objectives.getObjectiveAssessmentMeasuresLink().isDisplayed()&&objectives.getObjectiveStatusReportsLink().isDisplayed()&&objectives.getObjectiveActualResultLink().isDisplayed()&&objectives.getObjectiveUseOfResultsLink().isDisplayed()&&objectives.getObjectiveGapAnalysisLink().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		
		if(objectives.getObjectiveIntendedResultPageHeaderText().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		if(objectives.getObjectiveIntendedResultDate().isDisplayed()&&objectives.getObjectiveIntendedResultPlaningYear().isDisplayed()&&objectives.getObjectiveIntendedResultDescription().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		
		if(objectives.getObjectivePastDateInDateField().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		
		if(objectives.getObjectiveFutureDateInDateField().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		
		if(objectives.getObjectiveSaveAllInfo().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		
		if(objectives.getObjectiveEditIntendedResultsPage().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		
		if(objectives.getObjectiveEditInfoSaveIntendedResultsPage().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		
		if(objectives.getObjectiveIntendedResultsPageClickThreeDot().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		
		if(objectives.getObjectiveIntendedResultsPageDeleteConfirmationPopup().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		
		if(objectives.getObjectiveIntendedResultsPageDeleteConfirmationDone().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		
		if(objectives.getObjectiveIntendedResultsPageNoContentDisplayAfterDeletion().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		
	    ExcelUtil.writeToFile(517, testcase1);		
	}
	
	@AfterClass
	public void afterSuite() {
		driver.close();
		driver.quit();
	}
}
