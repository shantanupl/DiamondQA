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

public class ObjectivesGapAnalysis {
	WebDriver driver;

	public ObjectivesGapAnalysis(WebDriver driver) {
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
	By findSaveButtonGapAnalysis=By.cssSelector("div.mt-2 button:last-of-type");
	
	By findSelectResultLink=By.xpath("//label[contains(text(),'Select Results')]");
	By findGapAnalysisSubLink=By.xpath("//label[contains(text(),'Gap Analysis')]//following::label[2]");
	By findPlaningYearTextGapAnalysis=By.xpath("//span[contains(text(),'Gap Analysis')]//following::span[5]");
	By findPlaningYearFiledGapAnalysis=By.xpath("//span[contains(text(),'Gap Analysis')]//following::span[6]");
	By findIntendedResultsTextGapAnalysis=By.xpath("//span[contains(text(),'Gap Analysis')]//following::span[10]");
	By findActualResultsTextGapAnalysis=By.xpath("//span[contains(text(),'Gap Analysis')]//following::span[11]");
	By findUseOfResultsTextGapAnalysis=By.xpath("//span[contains(text(),'Gap Analysis')]//following::span[12]");
	By findPlusButtonGapAnalysis=By.cssSelector("div.table-cell.ng-star-inserted span");
	By findSelectResultHeaderTextGapAnalysis=By.cssSelector("div.k-window-title.k-dialog-title");
	By findSaveButtonDisableGapAnalysis=By.cssSelector("button.btn.btn-yellow.btn-system.ng-star-inserted");
	By findSaveButtonEnableGapAnalysis=By.cssSelector("div.form-row.float-right.ng-star-inserted button:last-of-type");
	By findCancelButtonGapAnalysis=By.cssSelector("div.form-row.float-right.ng-star-inserted button:first-of-type");
	By findCancelButtonParentGapAnalysis=By.cssSelector("button.btn.btn-light.btn-system");
	By findCheckBoxGapAnalysis=By.cssSelector("div.table-cell.obj-dtl-item input");
	
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
		//Scroll window
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		driver.findElement(findGapAnalysisLink).click();
		Thread.sleep(2000);
		//Scroll window
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		return driver.findElement(findResultPageHeaderText);
	}

	public WebElement getObjectiveIntendedResultDate() throws InterruptedException {
		Thread.sleep(2000);
		return driver.findElement(findSelectResultLink);
	}

	public WebElement getObjectiveIntendedResultPlaningYear() throws InterruptedException {
		return driver.findElement(findGapAnalysisSubLink);
	}

	public WebElement getObjectiveIntendedResultDescription() throws InterruptedException {
		return driver.findElement(findPlaningYearTextGapAnalysis);
	}
	
	public WebElement getObjectiveIntendedResultText() throws InterruptedException {
		return driver.findElement(findIntendedResultsTextGapAnalysis);
	}
	public WebElement getObjectiveActualResultText() throws InterruptedException {
		return driver.findElement(findActualResultsTextGapAnalysis);
	}
	public WebElement getObjectiveUseOfResultText() throws InterruptedException {
		return driver.findElement(findUseOfResultsTextGapAnalysis);
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
	
	public WebElement getObjectivePlusIconVisible() throws InterruptedException, FindFailed {
		Thread.sleep(2000);
		//Scroll window
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		WebElement planingDropDown = driver.findElement(findPlaningYearFiledGapAnalysis);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", planingDropDown);
		Thread.sleep(5000);
		Screen scrn=new Screen();
		Pattern pattern1=new Pattern(System.getProperty("user.dir")+"\\src\\resources\\images\\yearselection.jpg");
		scrn.click(pattern1);
		Thread.sleep(2000);
		return driver.findElement(findPlusButtonGapAnalysis);
	}

	public WebElement getObjectiveSelectResultFormOpen() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(findPlusButtonGapAnalysis).click();
		Thread.sleep(2000);
		return driver.findElement(findSelectResultHeaderTextGapAnalysis);
	}

	public WebElement getObjectiveSaveButtonDisable() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(findCancelButtonGapAnalysis).click();
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(2000);
		driver.findElement(findCancelButtonParentGapAnalysis).click();
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		return driver.findElement(findIntendedResultLink);
	}
	
	public WebElement getObjectiveThreeColumnsValueAvailable() throws FindFailed, InterruptedException {
		getObjectiveIntendedResultPageHeaderText();
		getObjectivePlusIconVisible();
		getObjectiveSelectResultFormOpen();
		return driver.findElements(findCheckBoxGapAnalysis).get(2);
	}

	public WebElement getObjectiveSaveButtonEnable() throws InterruptedException {
		Thread.sleep(2000);
		return driver.findElement(findSaveButtonEnableGapAnalysis);
	}

	public WebElement getObjectiveSelectResultSaveValueDispaly() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElements(findCheckBoxGapAnalysis).get(0).click();
		Thread.sleep(2000);
		driver.findElements(findCheckBoxGapAnalysis).get(1).click();
		Thread.sleep(2000);
		driver.findElements(findCheckBoxGapAnalysis).get(2).click();
		Thread.sleep(2000);
		driver.findElement(findSaveButtonEnableGapAnalysis).click();
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		return driver.findElement(findResultPageHeaderText);
	}

	public WebElement getObjectiveClickGapAnalysisLinkOpenNewForm() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(findGapAnalysisSubLink).click();
		Thread.sleep(5000);
		return driver.findElement(findResultPageHeaderText);
	}
	public WebElement getObjectiveSaveAllInfo() throws InterruptedException, FindFailed {
		Thread.sleep(2000);
		//Scroll window
		//((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		List<WebElement> descriptionDropdown = driver.findElements(findDropdown);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", descriptionDropdown.get(0));
		Thread.sleep(5000);
		Screen scrn=new Screen();
		Pattern pattern1=new Pattern(System.getProperty("user.dir")+"\\src\\resources\\images\\quotationsmall.jpg");
		scrn.click(pattern1);
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(2000);
		driver.findElement(findSaveButtonGapAnalysis).click();
		Thread.sleep(2000);
		//Scroll window
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		List<WebElement> existingElement = driver.findElements(findExistingOrNoItem);
		return existingElement.get(5);
	}
	public WebElement getObjectiveDisplayExistingData() throws InterruptedException {
		Thread.sleep(2000);
		//Scroll window
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		List<WebElement> existingElement = driver.findElements(findExistingOrNoItem);
		return existingElement.get(5);
	}
	
	public WebElement getObjectiveEditIntendedResultsPage() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> existingElement = driver.findElements(findExistingOrNoItem);
		existingElement.get(5).click();
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		return driver.findElement(findResultPageHeaderText);
	}
	
	public WebElement getObjectiveEditInfoSaveIntendedResultsPage() throws InterruptedException, FindFailed {
		Thread.sleep(2000);
		//getObjectiveThreeColumnsValueAvailable();
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		Thread.sleep(2000);
		driver.findElement(findPlusButtonGapAnalysis).click();
		Thread.sleep(2000);
		driver.findElements(findCheckBoxGapAnalysis).get(0).click();
		Thread.sleep(2000);
		driver.findElements(findCheckBoxGapAnalysis).get(1).click();
		Thread.sleep(2000);
		driver.findElements(findCheckBoxGapAnalysis).get(2).click();
		Thread.sleep(2000);
		driver.findElement(findSaveButtonEnableGapAnalysis).click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(5000);
		driver.findElement(findSaveButtonGapAnalysis).click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		List<WebElement> existingElement = driver.findElements(findExistingOrNoItem);
		return existingElement.get(5);
	}

	public WebElement getObjectiveEditInfoSaveGapAnalysisPage() throws InterruptedException, FindFailed {
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		List<WebElement> existingElement = driver.findElements(findExistingOrNoItem);
		return existingElement.get(5);
	}
	public WebElement getObjectiveIntendedResultsPageClickThreeDot() throws InterruptedException {
		Thread.sleep(2000);
		//Scroll window
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		List<WebElement> existingElement = driver.findElements(findExistingOrNoItem);
		existingElement.get(5).click();
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
		//Scroll window
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		List<WebElement> existingElement = driver.findElements(findExistingOrNoItem);
		return existingElement.get(5);
	}
	public WebElement getObjectiveIntendedResultsPageNoContentDisplayAfterDeletion() throws InterruptedException {
		Thread.sleep(2000);
		//Scroll window
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		List<WebElement> existingElement = driver.findElements(findExistingOrNoItem);
		return existingElement.get(5);
	}

	public WebElement getObjectiveIntendedResultsPageNoContentDisplay() throws InterruptedException {
		Thread.sleep(2000);
		//Scroll window
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		List<WebElement> existingElement = driver.findElements(findExistingOrNoItem);
		return existingElement.get(5);
	}

}
