package PlanningUnitDetailsOBJECTIVES;

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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ModelClass.AllPlanningPage;
import ModelClass.ExcelUtil;
import ModelClass.Goals;
import ModelClass.ObjectivesTasks;
import ModelClass.PlanningUnitDetails;
import ModelClass.SpolLoginPage;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ObjectivesTaskView {
	
	WebDriver driver;
	AllPlanningPage homepage;
	SpolLoginPage loginpage;
	AllPlanningPage allPlanning;
	HSSFWorkbook workbook;
	PlanningUnitDetails planningUnitDetails;
	Goals goals;
	ObjectivesTasks objectives;
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
	
	public ObjectivesTaskView() {
		// TODO Auto-generated constructor stub
	}
	
	@BeforeClass
	private void setup() throws BiffException,IOException,RowsExceededException,WriteException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/resources/drivers/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://diamondqa.strategicplanningonline.com/");
	}
	
	@Test
	public void verifyTaskPageWithEmptyRow() throws InterruptedException, IOException {
		homepage= new AllPlanningPage(driver);
		loginpage= new SpolLoginPage(driver);
		allPlanning= new AllPlanningPage(driver);
		objectives=new ObjectivesTasks(driver);
		loginpage.typeEmailId("spaul");
		//Thread.sleep(2000);
		loginpage.typePassword("sp123");
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
		//Click Tasks
		driver.findElement(By.xpath("//button[contains(text(),'Tasks')]")).click();
		//Mouse over on Tasks row
		//Actions action = new Actions(driver);
		//action.moveToElement(driver.findElement(By.cssSelector("i.fal.fa-plus.selected")));
		if(objectives.isTasksRowPlusButtonVisible().isEnabled()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		if(objectives.isTasksLinkTextDisplay().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		if(objectives.isTasksRowPlusButtonVisible().isEnabled()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("div.tasks-header")));
		if(objectives.isAddTaskNewFormDisplayClickWithoutPlusButton().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("i.fal.fa-plus.selected")));
		if(objectives.isAddTaskNewFormDisplayClickPlusButton().isDisplayed()) {
			testcase1.add("Pass");
		}
		else {
			testcase1.add("Fail");
		}
	    ExcelUtil.writeToFile(403, testcase1);
	    Thread.sleep(3000);
	}
	
	@AfterClass
	public void afterSuite() {
		driver.close();
		driver.quit();
	}
}
