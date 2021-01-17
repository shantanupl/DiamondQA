package ModelClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class ObjectivesTasks {
	WebDriver driver;

	public ObjectivesTasks(WebDriver driver) {
		this.driver=driver;
	}
	By tasksRowPlusButton=By.cssSelector("i.fal.fa-plus.selected");
	By tasksRowWithoutPlusButton=By.cssSelector("div.tasks-header");
	By linkTextTasks=By.xpath("//h6[contains(text(),'Tasks')]");
	By taskAddSectionHeaderText=By.xpath("//label[contains(text(),'Task Details')]");
	By findCloseButton=By.cssSelector("button.close");
	By findStartDateText=By.xpath("//label[contains(text(),'Start Date:')]");
	By findStartDateField=By.xpath("//label[contains(text(),'Start Date:')]//following::input[1]");
	By findStartDateFieldCalendar=By.xpath("//label[contains(text(),'Start Date:')]//following::span[3]");
	By findDueDateText=By.xpath("//label[contains(text(),'Due Date:')]");
	By findDueDateField=By.xpath("//label[contains(text(),'Due Date:')]//following::input[1]");
	By findDueDateFieldCalendar=By.xpath("//label[contains(text(),'Due Date:')]//following::span[3]");
	By findSelectDateFromDueDateCalendar=By.cssSelector("span.k-link");
	By findTaskTypeText=By.xpath("//label[contains(text(),'Task Type:')]");
	By findTaskTypeField=By.xpath("//label[contains(text(),'Task Type:')]//following::input[1]");
	By findTaskTypeDropdown=By.cssSelector("span.k-icon.k-i-arrow-s");
	By findPriorityLevelText=By.xpath("//label[contains(text(),'Priority Level:')]");
	By findPriorityLevelField=By.xpath("//label[contains(text(),'Priority Level:')]//following::input[1]");
	By findStatusText=By.xpath("//label[contains(text(),'Status:')]");
	By findStatusField=By.xpath("//label[contains(text(),'Status:')]//following::input[1]");
	By findCompletedDateText=By.xpath("//label[contains(text(),'Completed Date:')]");
	By findCompletedDateField=By.xpath("//label[contains(text(),'Completed Date:')]//following::input[1]");
	By findCompletedDateFieldCalendar=By.xpath("//label[contains(text(),'Completed Date:')]//following::span[3]");
	By findDescriptionText=By.xpath("//label[contains(text(),'Description:')]");
	By findDescriptionField=By.cssSelector("div.ProseMirror");
	By findDescriptionDropdown=By.cssSelector("span.k-input");
	By findDescriptionRequiredMessage=By.xpath("//span[contains(text(),'Task Description is required')]");
	By findCancelButton=By.xpath("//button[contains(text(),'Cancel')]");
	By findSaveButton=By.xpath("//button[contains(text(),'Save')]");
	By findStartDateGraterThanDueDate=By.xpath("//span[contains(text(), 'Start Date must be before the Due Date.')]");
	By findTaskTypeRequiredMessage=By.xpath("//span[contains(text(),' Task Type is required ')]");
	By findPriorityLevelRequiredMessage=By.xpath("//span[contains(text(),' Priority Level is required ')]");
	By findStatusRequiredMessage=By.xpath("//span[contains(text(),' Task Status is required ')]");
	By findCompletedDateValidationErrorMessage=By.xpath("//span[contains(text(), 'Start Date must be before the Completed Date.')]");
	By findHamburgerMenu=By.cssSelector("i.fas.fa-bars.fa-1x");
	By findStartDateTaskDetail=By.xpath("//div[contains(text(),' Start Date ')]");
	By findDueDateTaskDetail=By.xpath("//div[contains(text(),' Due Date ')]");
	By findTypeTaskDetail=By.xpath("//div[contains(text(),'Type')]");
	By findPriorityTaskDetail=By.xpath("//div[contains(text(),'Priority')]");
	By findStatusTaskDetail=By.xpath("//div[contains(text(),'Status')]");
	By findBudgetRequestTaskDetail=By.xpath("//div[contains(text(),'Budget Request')]");
	By findApprovedTaskDetail=By.xpath("//div[contains(text(),'Approved')]");
	By findStartDateFieldTaskDetail=By.xpath("//div[contains(@spol-label,'otlStartDate')]//following::div[1]");
	By findDueDateFieldTaskDetail=By.xpath("//div[contains(@spol-label,'otlStartDate')]//following::div[4]");
	By findTypeFieldTaskDetail=By.xpath("//div[contains(@spol-label,'otlStartDate')]//following::div[7]");
	By findPriorityFieldTaskDetail=By.xpath("//div[contains(@spol-label,'otlStartDate')]//following::div[10]");
	By findStatusFieldTaskDetail=By.xpath("//div[contains(@spol-label,'otlStartDate')]//following::div[13]");
	By findBudgetRequestFieldTaskDetail=By.xpath("//div[contains(@spol-label,'otlStartDate')]//following::div[16]");
	By findApprovedFieldTaskDetail=By.xpath("//div[contains(@spol-label,'otlStartDate')]//following::div[19]");
	By findHeaderStatusDateTaskDetail=By.cssSelector("div.task-completion-status");
	
	public WebElement isTasksRowPlusButtonVisible() {
		return driver.findElement(tasksRowPlusButton);
	}
	
	public WebElement isTasksLinkTextDisplay() {
		return driver.findElement(linkTextTasks);
	}
	
	public WebElement isAddTaskNewFormDisplay() throws InterruptedException {
		Thread.sleep(2000);
		return driver.findElement(linkTextTasks);
	}
	
	public WebElement isAddTaskNewFormDisplayClickWithoutPlusButton() {
		return driver.findElement(taskAddSectionHeaderText);
	}
	
	public WebElement isAddTaskNewFormDisplayClickPlusButton() throws InterruptedException {
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();", tasksRowPlusButton);
		Thread.sleep(2000);
		return driver.findElement(taskAddSectionHeaderText);
	}
	//Add Task
	public WebElement getObjectiveTaskAddSectionHeaderText() throws InterruptedException {
		Thread.sleep(2000);
		return driver.findElement(taskAddSectionHeaderText);
	}
	
	public WebElement getObjectiveStartDateText() {
		return driver.findElement(findStartDateText);
	}

	public WebElement getObjectiveDueDateText() {
		return driver.findElement(findDueDateText);
	}

	public WebElement getObjectiveTaskTypeText() {
		return driver.findElement(findTaskTypeText);
	}

	public WebElement getObjectivePriorityLevelText() {
		return driver.findElement(findPriorityLevelText);
	}

	public WebElement getObjectiveStatusText() {
		return driver.findElement(findStatusText);
	}

	public WebElement getObjectiveCompletedDateText() {
		return driver.findElement(findCompletedDateText);
	}

	public WebElement getObjectiveDescriptionText() {
		return driver.findElement(findDescriptionText);
	}

	public WebElement getObjectiveStartDateCalendar() {
		return driver.findElement(findDescriptionField);
	}

	public WebElement getObjectiveDueDateFieldText() {
		return driver.findElement(findDueDateField);
	}

	public WebElement getObjectiveTaskTypeDropDown() {
		return driver.findElement(findTaskTypeField);
	}

	public WebElement getObjectivePriorityLevelDropDown() {
		return driver.findElement(findPriorityLevelField);
	}

	public WebElement getObjectiveStatusDropDown() {
		return driver.findElement(findStatusField);
	}

	public WebElement getObjectiveCompletedDateDropDown() {
		return driver.findElement(findCompletedDateField);
	}

	public WebElement getObjectiveDescriptionField() {
		return driver.findElement(findDescriptionField);
	}

	public WebElement getObjectiveCancelButtonAvailable() {
		return driver.findElement(findCancelButton);
	}

	public WebElement getObjectiveSaveButtonAvailable() {
		return driver.findElement(findSaveButton);
	}

	public WebElement getObjectiveCancelButtonEnabled() {
		return driver.findElement(findCancelButton);
	}

	public WebElement getObjectiveSaveButtonDisabled() {
		return driver.findElement(findSaveButton);
	}

	public WebElement getObjectiveStartDateFieldText() {
		return driver.findElement(findStartDateField);	
	}

	public WebElement getObjectiveErrorValidationStartDateNotBeforeEndDate() throws InterruptedException {
		//Start Date calendar
		driver.findElement(findStartDateFieldCalendar).click();
		List<WebElement> webele1=driver.findElements(findSelectDateFromDueDateCalendar);
		webele1.get(10).click();
		Thread.sleep(2000);
		//Due Date calendar
		driver.findElement(findDueDateFieldCalendar).click();
		List<WebElement> webele=driver.findElements(findSelectDateFromDueDateCalendar);
		webele.get(0).click();
		Thread.sleep(2000);
//		JavascriptExecutor jse1 = (JavascriptExecutor)driver;
//		WebElement ele1=driver.findElement(findStartDateField);
//		jse1.executeScript("arguments[0].value='1/8/2021';", ele1);
//		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
//		WebElement ele2=driver.findElement(findDueDateField);
//		jse2.executeScript("arguments[0].value='1/1/2021';", ele2);
		return driver.findElement(findStartDateGraterThanDueDate);
	}

	public boolean getObjectiveNoErrorStartDateBeforeEndDate() throws InterruptedException {
		//Start Date calendar
		driver.findElement(findStartDateFieldCalendar).click();
		List<WebElement> webele1=driver.findElements(findSelectDateFromDueDateCalendar);
		webele1.get(0).click();
		Thread.sleep(2000);
		//Due Date calendar
		driver.findElement(findDueDateFieldCalendar).click();
		List<WebElement> webele=driver.findElements(findSelectDateFromDueDateCalendar);
		webele.get(10).click();
		Thread.sleep(2000);
        return true;
	}

	public boolean getObjectiveNoErrorMoveToOtherFieldWithoutValueDueDateField() {
		//Start Date calendar
		driver.findElement(findStartDateFieldCalendar).click();
		List<WebElement> webele1=driver.findElements(findSelectDateFromDueDateCalendar);
		webele1.get(0).click();
        return true;
	}

//	public WebElement getObjectiveStartDateFieldWrongFormat() {
//		JavascriptExecutor jse1 = (JavascriptExecutor)driver;
//		WebElement ele1=driver.findElement(findStartDateField);
//		jse1.executeScript("arguments[0].value='1-8-2021';", ele1);
//		return null;
//	}

//	public WebElement getObjectiveDueDateFieldWrongFormat() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public WebElement getObjectiveMoveOtherFieldWithoutSelectTaskType() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(findTaskTypeField).sendKeys("TaskType1");
		driver.findElement(findTaskTypeField).clear();
		return driver.findElement(findTaskTypeRequiredMessage);
	}

	public WebElement getObjectiveCountExistingTaskClickTaskTypeDropdown() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> wele=driver.findElements(findTaskTypeDropdown);
		WebElement wele1=wele.get(0);
		wele.get(0).click();
		return wele1;
	}

	public WebElement getObjectiveMatchWithAdminPanelTaskClickTaskTypeDropdown() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> wele1=driver.findElements(findTaskTypeDropdown);
		WebElement wele2=wele1.get(0);
		wele1.get(0).click();
		return wele2;
	}

	public WebElement getObjectiveSelectValueFromTaskTypeDropdown() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(findTaskTypeField).sendKeys("TaskType1");
		return driver.findElement(findTaskTypeField);
	}

	public WebElement getObjectiveMoveOtherFieldWithoutSelectPriorityLevel() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(findPriorityLevelField).sendKeys("PriorityLevel1");
		driver.findElement(findPriorityLevelField).clear();
		return driver.findElement(findPriorityLevelRequiredMessage);
	}

	public WebElement getObjectiveCountExistingPriorityLevelClickPriorityLevelDropdown() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> wele1=driver.findElements(findTaskTypeDropdown);
		WebElement wele2=wele1.get(1);
		wele1.get(1).click();
		return wele2;
	}

	public WebElement getObjectiveSelectValueFromPriorityLevelDropdown() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(findPriorityLevelField).sendKeys("PriorityLevel1");
		return driver.findElement(findPriorityLevelField);
	}

	public WebElement getObjectiveMoveOtherFieldWithoutSelectStatusDropdown() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(findStatusField).sendKeys("In Progress");
		driver.findElement(findStatusField).clear();
		return driver.findElement(findStatusRequiredMessage);
	}

	public WebElement getObjectiveCountExistingStatusClickStatusDropdown() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> wele1=driver.findElements(findTaskTypeDropdown);
		WebElement wele2=wele1.get(2);
		wele1.get(2).click();
		return wele2;
	}

	public WebElement getObjectiveSelectValueFromStatusDropdown() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(findStatusField).sendKeys("Pending");
		return driver.findElement(findStatusField);
	}

	public WebElement getObjectiveRemoveValueFromCompletedDateField() {
		JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		WebElement ele1=driver.findElement(findCompletedDateField);
		jse1.executeScript("arguments[0].value='month/day/year';", ele1);
		return driver.findElement(findCompletedDateField);
	}

	public WebElement getObjectiveErrorValidationCompletionDate() throws InterruptedException {
		//Start Date calendar
		Thread.sleep(2000);
		driver.findElement(findStartDateFieldCalendar).click();
		List<WebElement> webele1=driver.findElements(findSelectDateFromDueDateCalendar);
		webele1.get(10).click();
		Thread.sleep(2000);
		//Due Date calendar
		driver.findElement(findDueDateFieldCalendar).click();
		List<WebElement> webele=driver.findElements(findSelectDateFromDueDateCalendar);
		webele.get(12).click();
		Thread.sleep(2000);
		//Completed Date calendar
		driver.findElement(findCompletedDateFieldCalendar).click();
		List<WebElement> webele2=driver.findElements(findSelectDateFromDueDateCalendar);
		webele2.get(8).click();
		Thread.sleep(2000);
		return driver.findElement(findCompletedDateValidationErrorMessage);
	}

	public WebElement getObjectiveErrorValidationDescriptionField() throws InterruptedException, FindFailed {
		Thread.sleep(2000);
		WebElement userNameTxt = driver.findElement(findDescriptionDropdown);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", userNameTxt);
		Thread.sleep(2000);
		Screen scrn=new Screen();
		//Pattern pattern1=new Pattern(System.getProperty("user.dir")+"/src/resources/images/quotation.PNG");
		//Pattern pattern1=new Pattern("D:\\Shantanu\\TestAutomation\\DiamondQA\\SpolAutomation\\src\\resources\\images\\quotation.jpg");
		Pattern pattern1=new Pattern(System.getProperty("user.dir")+"\\src\\resources\\images\\quotation.jpg");
		scrn.click(pattern1);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", userNameTxt);
		//Pattern pattern2=new Pattern("D:\\Shantanu\\TestAutomation\\DiamondQA\\SpolAutomation\\src\\resources\\images\\paragraph.jpg");
		Pattern pattern2=new Pattern(System.getProperty("user.dir")+"\\src\\resources\\images\\paragraph.jpg");
		scrn.click(pattern2);
		//By selectDropdownText=By.linkText("Quotation");
		//driver.findElement(selectDropdownText).click();
		//js.executeScript("arguments[0].value='Quotation';", userNameTxt);
		//userNameTxt.click();
		//JavascriptExecutor jsExecutor = (JavascriptExecutor) driver; 
		// set the text
		//jsExecutor.executeScript("arguments[0].value='Quotation'", userNameTxt); 
//		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
//		WebElement ele2=driver.findElement(findDescriptionDropdown);
//		jse2.executeScript("arguments[0].value='Quotation';", ele2);
//		//driver.findElement(findDescriptionDropdown).sendKeys("Quotation");
//		Thread.sleep(2000);
//		JavascriptExecutor jse3 = (JavascriptExecutor)driver;
//		WebElement ele3=driver.findElement(findDescriptionDropdown);
//		jse3.executeScript("arguments[0].value='Paragraph';", ele3);
//		//driver.findElement(findDescriptionDropdown).sendKeys("Paragraph");
		Thread.sleep(2000);
		return driver.findElement(findDescriptionRequiredMessage);
	}

	public WebElement getObjectiveSaveAllInformation() throws InterruptedException, FindFailed {
		//Start Date calendar
		driver.findElement(findStartDateFieldCalendar).click();
		List<WebElement> webele1=driver.findElements(findSelectDateFromDueDateCalendar);
		webele1.get(0).click();
		Thread.sleep(2000);
		//Due Date calendar
		driver.findElement(findDueDateFieldCalendar).click();
		List<WebElement> webele=driver.findElements(findSelectDateFromDueDateCalendar);
		webele.get(10).click();
		Thread.sleep(2000);
		//Select Task Type
		driver.findElement(findTaskTypeField).clear();
		driver.findElement(findTaskTypeField).sendKeys("TaskType1");
		Thread.sleep(2000);
		//Select Priority Level
		driver.findElement(findPriorityLevelField).clear();
		driver.findElement(findPriorityLevelField).sendKeys("PriorityLevel1");
		Thread.sleep(2000);
		//Select Status
		driver.findElement(findStatusField).clear();
		driver.findElement(findStatusField).sendKeys("Pending");
		Thread.sleep(2000);
		//Select Completed Date
		driver.findElement(findCompletedDateFieldCalendar).click();
		List<WebElement> webele3=driver.findElements(findSelectDateFromDueDateCalendar);
		webele3.get(12).click();
		Thread.sleep(2000);
		//Completed Date calendar
		driver.findElement(findCompletedDateFieldCalendar).click();
		List<WebElement> webele2=driver.findElements(findSelectDateFromDueDateCalendar);
		webele2.get(8).click();
		Thread.sleep(2000);
		//Description field
		WebElement userNameTxt = driver.findElement(findDescriptionDropdown);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", userNameTxt);
		Thread.sleep(2000);
		Screen scrn=new Screen();
		//Pattern pattern1=new Pattern("D:\\Shantanu\\TestAutomation\\DiamondQA\\SpolAutomation\\src\\resources\\images\\quotation.jpg");
		Pattern pattern1=new Pattern(System.getProperty("user.dir")+"\\src\\resources\\images\\quotation.jpg");
		scrn.click(pattern1);
		Thread.sleep(2000);
		//Scroll window
		WebElement scrollElemt = driver.findElement(findSaveButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollElemt);
		Thread.sleep(500);
		//Click Save button
		driver.findElement(findSaveButton).click();
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver,100);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(findHamburgerMenu));
		return driver.findElement(findHamburgerMenu);
	}

	public WebElement getObjectiveStartDateTaskDetails() {
		return driver.findElement(findStartDateTaskDetail);
	}

	public WebElement getObjectiveDueDateTaskDetails() {
		return driver.findElement(findDueDateTaskDetail);
	}

	public WebElement getObjectiveTaskTypeTaskDetails() {
		return driver.findElement(findTypeTaskDetail);
	}

	public WebElement getObjectivePriorityTaskDetails() {
		return driver.findElement(findPriorityTaskDetail);
	}

	public WebElement getObjectiveStatusTaskDetails() {
		return driver.findElement(findStatusTaskDetail);
	}

	public WebElement getObjectiveBudgetRequestTaskDetails() {
		return driver.findElement(findBudgetRequestTaskDetail);
	}

	public WebElement getObjectiveApprovedTaskDetails() {
		return driver.findElement(findApprovedTaskDetail);
	}

	public WebElement getObjectiveHeaderStatusDateTaskDetails() {
		return driver.findElement(findHeaderStatusDateTaskDetail);
	}

	public WebElement getObjectiveStartDateFieldTaskDetails() {
		return driver.findElement(findStartDateFieldTaskDetail);
	}

	public WebElement getObjectiveDueDateFieldTaskDetails() {
		return driver.findElement(findDueDateFieldTaskDetail);
	}

	public WebElement getObjectiveTaskTypeFieldTaskDetails() {
		return driver.findElement(findTypeFieldTaskDetail);
	}

	public WebElement getObjectivePriorityFieldTaskDetails() {
		return driver.findElement(findPriorityFieldTaskDetail);
	}

	public WebElement getObjectiveStatusFieldTaskDetails() {
		return driver.findElement(findStatusFieldTaskDetail);
	}

	public WebElement getObjectiveBudgetRequestFieldTaskDetails() {
		return driver.findElement(findBudgetRequestFieldTaskDetail);
	}

	public WebElement getObjectiveApprovedFieldTaskDetails() {
		return driver.findElement(findApprovedFieldTaskDetail);
	}
	
}
