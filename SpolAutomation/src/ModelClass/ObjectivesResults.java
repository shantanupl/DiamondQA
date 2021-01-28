package ModelClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class ObjectivesResults {
	WebDriver driver;

	public ObjectivesResults(WebDriver driver) {
		this.driver=driver;
	}
	
	By findIntendedResultLink=By.xpath("//span[contains(text(),'Intended Results')]");
	By findResultPageHeaderText=By.cssSelector("label.float-left.system-detail-header");
	By findAssessmentMeasuresLink=By.xpath("//span[contains(text(),'Assessment Measures')]");
	By findStatusReportsLink=By.xpath("//span[contains(text(),'Status Reports')]");
	By findActualResultLink=By.xpath("//span[contains(text(),'Actual Results')]");
	By findUseOfResultsLink=By.xpath("//span[contains(text(),'Use of Results')]");
	By findGapAnalysisLink=By.xpath("//span[contains(text(),'Gap Analysis')]");
	By findDateField=By.cssSelector("input.k-input");
	By findDatePicker=By.cssSelector("span.k-icon.k-i-calendar");
	By findSelectDateFromDateCalendar=By.cssSelector("span.k-link");
	By findDropdown=By.cssSelector("span.k-icon.k-i-arrow-s");
	By findDateText=By.xpath("//span[contains(text(),'Date')]");
	By findPlaningYearText=By.xpath("//span[contains(text(),'Planning Year')]");
	By findDescriptionText=By.xpath("//div[contains(text(),'Description')]");
	By findExistingOrNoItem=By.cssSelector("div.table-cell.obj-dtl-item:nth-of-type(1)");
	By findThreeDotOption=By.cssSelector("i.fas.fa-ellipsis-h");
	By findDeleteOption=By.xpath("//a[contains(text(),'Delete')]");
	By findDeleteConfirmationHeader=By.xpath("//div[contains(text(),'Are you sure you want to delete this Record?')]");
	By findDeleteButtonFromPopup=By.xpath("//button[contains(text(),'Delete')]");
	By findSaveButton=By.xpath("//button[contains(text(),'Save')]");
	
	public WebElement getObjectiveIntendedResultLink() {
		return driver.findElement(findIntendedResultLink);
	}

	public WebElement getObjectiveAssessmentMeasuresLink() {
		return driver.findElement(findAssessmentMeasuresLink);
	}

	public WebElement getObjectiveStatusReportsLink() {
		return driver.findElement(findStatusReportsLink);
	}

	public WebElement getObjectiveActualResultLink() {
		return driver.findElement(findActualResultLink);
	}

	public WebElement getObjectiveUseOfResultsLink() {
		return driver.findElement(findUseOfResultsLink);
	}

	public WebElement getObjectiveGapAnalysisLink() {
		return driver.findElement(findGapAnalysisLink);
	}

	public WebElement getObjectiveIntendedResultPageHeaderText() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(findIntendedResultLink).click();
		Thread.sleep(2000);
		//Scroll window
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		return driver.findElement(findResultPageHeaderText);
	}

	public WebElement getObjectiveIntendedResultDate() throws InterruptedException {
		Thread.sleep(2000);
		return driver.findElement(findDateText);
	}

	public WebElement getObjectiveIntendedResultPlaningYear() throws InterruptedException {
		return driver.findElement(findPlaningYearText);
	}

	public WebElement getObjectiveIntendedResultDescription() throws InterruptedException {
		return driver.findElement(findDescriptionText);
	}

	public WebElement getObjectivePastDateInDateField() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		WebElement ele1=driver.findElement(findDateField);
		jse1.executeScript("arguments[0].value='1/8/2021';", ele1);
		Thread.sleep(2000);
		return driver.findElement(findDateField);
	}

	public WebElement getObjectiveFutureDateInDateField() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		WebElement ele1=driver.findElement(findDateField);
		jse1.executeScript("arguments[0].value='2/25/2021';", ele1);
		Thread.sleep(2000);
		return driver.findElement(findDateField);
	}

	public WebElement getObjectiveSaveAllInfo() throws InterruptedException, FindFailed {
		Thread.sleep(2000);
		//Scroll window
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		List<WebElement> descriptionDropdown = driver.findElements(findDropdown);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", descriptionDropdown.get(1));
		Thread.sleep(5000);
		Screen scrn=new Screen();
		Pattern pattern1=new Pattern(System.getProperty("user.dir")+"\\src\\resources\\images\\quotationsmall.jpg");
		scrn.click(pattern1);
		Thread.sleep(2000);
		driver.findElement(findSaveButton).click();
		Thread.sleep(2000);
		List<WebElement> existingElement = driver.findElements(findExistingOrNoItem);
		return existingElement.get(0);
	}

	public WebElement getObjectiveEditIntendedResultsPage() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> existingElement = driver.findElements(findExistingOrNoItem);
		existingElement.get(0).click();
		Thread.sleep(2000);
		return driver.findElement(findResultPageHeaderText);
	}

	public WebElement getObjectiveEditInfoSaveIntendedResultsPage() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		WebElement ele1=driver.findElement(findDateField);
		jse1.executeScript("arguments[0].value='1/25/2021';", ele1);
		Thread.sleep(2000);
		//Scroll window
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		driver.findElement(findSaveButton).click();
		Thread.sleep(2000);
		List<WebElement> existingElement = driver.findElements(findExistingOrNoItem);
		return existingElement.get(0);
	}

	public WebElement getObjectiveIntendedResultsPageClickThreeDot() throws InterruptedException {
		Thread.sleep(2000);
		//Scroll window
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		List<WebElement> existingElement = driver.findElements(findExistingOrNoItem);
		existingElement.get(0).click();
		Thread.sleep(2000);
		//Scroll window
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		driver.findElement(findThreeDotOption).click();
		Thread.sleep(2000);
		return driver.findElement(findDeleteOption);
	}

	public WebElement getObjectiveIntendedResultsPageDeleteConfirmationPopup() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(findDeleteOption).click();
		Thread.sleep(2000);
		return driver.findElement(findDeleteConfirmationHeader);
	}

	public WebElement getObjectiveIntendedResultsPageDeleteConfirmationDone() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(findDeleteButtonFromPopup).click();
		Thread.sleep(5000);
		List<WebElement> existingElement = driver.findElements(findExistingOrNoItem);
		return existingElement.get(0);
	}

	public WebElement getObjectiveIntendedResultsPageNoContentDisplayAfterDeletion() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> existingElement = driver.findElements(findExistingOrNoItem);
		return existingElement.get(0);
	}
}
