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
	By findTaskDetailsLink=By.xpath("//a[contains(text(),'Task Details')]");
	By findBudgetLink=By.xpath("//a[contains(text(),'Budget')]");
	By findBudgeDetailHeaderText=By.xpath("//label[contains(text(),'Budget Detail')]");
	By findNewEnhanceBudgetHeaderText=By.cssSelector("div.k-window-title.k-dialog-title");
	By findBudgetAccountField=By.xpath("//label[contains(text(),'Budget Account:')]//following::input[1]");
	By findBudgetGLCodeField=By.xpath("//label[contains(text(),'Budget Account:')]//following::input[2]");
	By findBudgetAccountDropDown=By.xpath("//label[contains(text(),'Budget Account:')]//following::input[1]//following::span[2]");
	By findBudgetGLCodeDropDown=By.xpath("//label[contains(text(),'Budget Account:')]//following::input[1]//following::span[5]");
	By findNextButtonEnable=By.cssSelector("button.btn.btn-yellow.btn-system");
	By findFirstGLCodeRadioButton=By.xpath("//span[contains(@class,'k-link ng-star-inserted')]//following::input[2]");
	By findEnhancedForecastDetailsHeaderText=By.cssSelector("h6.float-left.ng-star-inserted");
	By findBudgetAmountRequiredAlertMessage=By.xpath("//span[contains(text(),'Budget Amount is required')]");
	By findNotFundedCheckBox=By.cssSelector("input.k-checkbox.ng-pristine.ng-valid.ng-touched");
	By findProposedAmountApproveButton=By.cssSelector("button.btn.btn-yellow.btn-system.approve-btn");
	By findAmountInputField=By.cssSelector("input.k-input.k-formatted-value");
	By findSaveButtonBudget=By.cssSelector("div.form-row.float-right button:last-of-type");
	
	
	By findRemarksLink=By.xpath("//a[contains(text(),'Remarks')]");
	By findRemarksPageHeaderTitle=By.xpath("//label[contains(text(),'Remarks')]");
	By findAssignmentsLink=By.xpath("//a[contains(text(),'Assignments')]");
	By findAssignmentsPageHeaderTitle=By.xpath("//label[contains(text(),'Assignments')]");
	By findRemarksPlusIcon=By.cssSelector("i.fal.fa-plus.add-remark");
	By findAssignmentNewFormHeaderTitle=By.xpath("//div[contains(text(),'New Task Assignment')]");
	By findAssignmentFilterByDropdown=By.cssSelector("span.k-icon.k-i-arrow-s");
	By findAssignmentsUserSearchField=By.xpath("//*[@id='main-wrapper']/div[1]/div/app-objective/merge-com/div/div[2]/app-obj-task-detail/div/div[2]/app-obj-task-assignment-form/kendo-dialog/div[2]/div/div/div[2]/div/div/kendo-grid/div/div/div/table/thead/tr[2]/td[2]/kendo-grid-string-filter-cell/kendo-grid-filter-wrapper-cell/input");
	By findAssignmentsEmailSearchField=By.xpath("//*[@id='main-wrapper']/div[1]/div/app-objective/merge-com/div/div[2]/app-obj-task-detail/div/div[2]/app-obj-task-assignment-form/kendo-dialog/div[2]/div/div/div[2]/div/div/kendo-grid/div/div/div/table/thead/tr[2]/td[3]/kendo-grid-string-filter-cell/kendo-grid-filter-wrapper-cell/input");
	By findAssignmentUserNumberSelection=By.cssSelector("input.k-checkbox.ng-star-inserted");
	By findAssignmentCheckBox=By.xpath("//td[contains(@class,'ng-star-inserted')]//following::input[6]");
	By findAssignmentCheckBoxSelected=By.cssSelector("input.k-checkbox.ng-star-inserted");
	By findAssignmentSaveButton=By.cssSelector("button.btn.btn-yellow");
	By findAssignmentCancelButton=By.cssSelector("button.btn.btn-light");
	By findAssignmentAddedAdmin=By.cssSelector("td.ng-star-inserted:first-of-type");
	By findAssignmentFirstNameDropDown=By.xpath("//input[contains(@formcontrolname,'firstName')]");
	By findAssignmentLastNameDropDown=By.xpath("//input[contains(@formcontrolname,'lastName')]");
	By findAssignmentEmailDropDown=By.xpath("//input[contains(@formcontrolname,'email')]");
	By findAssignmentFirstNameRequiredErrorMessage=By.xpath("//span[contains(text(),'Please Enter the First Name')]");
	By findAssignmentPlusButtonDisabled=By.cssSelector("button.k-button.k-state-disabled");
	By findAssignmentPlusButtonEnabled=By.xpath("//button[contains(@class,'k-button')][contains(@aria-disabled,'false')]");
	By findAssignmentFirstNameText=By.xpath("//label[contains(@spol-label,'lableFirstName')]");
	By findRemarksTitle=By.xpath("//div[contains(text(),'Remark')]");
	By findRemarksSaveButton=By.xpath("//button[contains(text(),'Save')]");
	By findDateTextRemarksSection=By.xpath("//div[contains(text(),'Date:')]");
	By findEnteredByTextRemarksSection=By.xpath("//div[contains(text(),'Entered By:')]");
	By findCloseButtonRemarksPage=By.xpath("//button[contains(@class,'close')]");
	By findRemarksEdit=By.cssSelector("div.table-row:nth-of-type(2)");
	By findRemarksDeleteButton=By.cssSelector("div.delete-icon.hide.far.fa-trash-alt.float-right.ng-star-inserted");
	By findRemarksDeletePopupHeader=By.cssSelector("div.col-12");
	By findRemarksDeletePopupDeleteButton=By.cssSelector("button.btn.btn-yellow.btn-system.ng-star-inserted");
	By findRemarksNoRecords=By.cssSelector("div.table-cell span:nth-of-type(1)");
	By findRemarksEditCalendar=By.cssSelector("span.k-icon.k-i-calendar");
	
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

	public WebElement getObjectiveTaskDetailsLink() {
		return driver.findElement(findTaskDetailsLink);
	}

	public WebElement getObjectiveRemarksLink() {
		return driver.findElement(findRemarksLink);
	}
	public WebElement getObjectiveBudgetLink() {
		return driver.findElement(findBudgetLink);
	}

	public WebElement getObjectiveAssignmentsLink() {
		return driver.findElement(findAssignmentsLink);
	}

	public WebElement getObjectiveTaskDetailPageHeaderText() {
		return driver.findElement(taskAddSectionHeaderText);
	}

//	public WebElement getObjectiveStatusDropDownValueEdited() throws InterruptedException {
//		Thread.sleep(2000);
//		//Select Status
//		driver.findElement(findStatusField).clear();
//		driver.findElement(findStatusField).sendKeys("In Progress");
//		return driver.findElement(findStatusField);
//	}
//
//	public WebElement getObjectiveCompletedDateDropDownValueEdited() throws InterruptedException {
//		//Select Completed Date
//		driver.findElement(findCompletedDateFieldCalendar).click();
//		List<WebElement> webele3=driver.findElements(findSelectDateFromDueDateCalendar);
//		webele3.get(13).click();
//		Thread.sleep(2000);
//		return webele3.get(13);
//	}

	public WebElement getObjectiveEditStatusAndCompletedDate() throws InterruptedException {
		Thread.sleep(2000);
		//Select Status
		driver.findElement(findStatusField).clear();
		driver.findElement(findStatusField).sendKeys("In Progress");
		//Select Completed Date
		driver.findElement(findCompletedDateFieldCalendar).click();
		List<WebElement> webele3=driver.findElements(findSelectDateFromDueDateCalendar);
		webele3.get(13).click();
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

	public WebElement getObjectiveClickRemarks() throws InterruptedException {
		driver.findElement(findHamburgerMenu).click();
		Thread.sleep(2000);
		//Scroll window
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		driver.findElement(findRemarksLink).click();
		return driver.findElement(findRemarksPageHeaderTitle);
	}

	public WebElement getObjectivePlusIconShow() throws InterruptedException {
		Thread.sleep(3000);
		return driver.findElement(findRemarksPlusIcon);
	}

	public WebElement getObjectiveClickPlusIconNewPopUpShow() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(findRemarksPlusIcon).click();
		return driver.findElement(findRemarksTitle);
	}

	public WebElement getObjectiveSaveButtonEnabled() throws InterruptedException, FindFailed {
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

		return driver.findElement(findRemarksSaveButton);
	}

	public WebElement getObjectiveNewRemarksAdded() throws InterruptedException {
		driver.findElement(findRemarksSaveButton).click();
		Thread.sleep(2000);
		return driver.findElement(findDateTextRemarksSection);
	}

	public WebElement getObjectiveDateTextRemarks() {
		return driver.findElement(findDateTextRemarksSection);
	}

	public WebElement getObjectiveEnteredByTextRemarks() {
		return driver.findElement(findEnteredByTextRemarksSection);
	}

	public WebElement getObjectiveRemarksClickCloseButton() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(findCloseButtonRemarksPage).click();
		return driver.findElement(findHamburgerMenu);
	}

	public WebElement getObjectiveRemarksBlueIcon() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(findHamburgerMenu).click();
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		driver.findElement(findRemarksLink).click();
		return driver.findElement(findRemarksPlusIcon);
	}

	public WebElement getObjectiveRemarksEditForm() throws InterruptedException, FindFailed {
		Thread.sleep(2000);
		driver.findElement(findRemarksEdit).click();
		return driver.findElement(findRemarksTitle);
	}

	public WebElement getObjectiveRemarksEditSave() throws InterruptedException, FindFailed {
		Thread.sleep(2000);
		driver.findElement(findRemarksEditCalendar).click();
		List<WebElement> webele3=driver.findElements(findSelectDateFromDueDateCalendar);
		webele3.get(15).click();
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
		driver.findElement(findRemarksSaveButton).click();
		Thread.sleep(2000);
		return driver.findElement(findHamburgerMenu);
	}

	public WebElement getObjectiveRemarksDeleteButtonVisible() throws InterruptedException {
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		WebElement btn = driver.findElement(findRemarksEdit);
		action.moveToElement(btn).perform();
		Thread.sleep(2000);
		return driver.findElement(findRemarksDeleteButton);
	}

	public WebElement getObjectiveClickRemarksDeleteButton() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(findRemarksDeleteButton).click();
		return driver.findElement(findRemarksDeletePopupHeader);
	}

	public WebElement getObjectiveDeleteRemarks() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(findRemarksDeletePopupDeleteButton).click();
		return driver.findElement(findRemarksNoRecords);
	}

	public WebElement getObjectiveClickAssignmentsLink() throws InterruptedException {
		driver.findElement(findHamburgerMenu).click();
		Thread.sleep(2000);
		//Scroll window
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		driver.findElement(findAssignmentsLink).click();
		return driver.findElement(findRemarksPlusIcon);
	}

	public WebElement getObjectiveClickPlusIconNewPopupDisplay() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(findRemarksPlusIcon).click();
		Thread.sleep(5000);
		return driver.findElement(findAssignmentNewFormHeaderTitle);
	}
	public WebElement getObjectiveFilterByDropdownDisplayByDefault() throws InterruptedException {
		Thread.sleep(2000);
		return driver.findElement(findAssignmentFilterByDropdown);
	}

	public List<WebElement> getObjectiveNumberOfUserDisplaySinglePage() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> lists=driver.findElements(findAssignmentUserNumberSelection);
		return lists;
	}

	public List<WebElement> getObjectiveUserSearchFilter() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(findAssignmentsUserSearchField).sendKeys("Admin");
		List<WebElement> lists=driver.findElements(findAssignmentUserNumberSelection);
		return lists;
	}

	public List<WebElement> getObjectiveEmailSearchFilter() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(findAssignmentsEmailSearchField).sendKeys("support@spol.com");
		List<WebElement> lists=driver.findElements(findAssignmentUserNumberSelection);
		return lists;
	}

	public List<WebElement> getObjectiveAssignmentsCheckBoxSelection() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(findAssignmentCancelButton).click();
		Thread.sleep(2000);
		driver.findElement(findRemarksPlusIcon).click();
		Thread.sleep(5000);
		List<WebElement> lists=driver.findElements(findAssignmentCheckBox);
		lists.get(0).click();
		Thread.sleep(2000);
		List<WebElement> lists1=driver.findElements(findAssignmentCheckBoxSelected);
		return lists1; 
	}

	public List<WebElement> getObjectiveAssignmentsSaveAllInfo() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(findAssignmentSaveButton).click();
		Thread.sleep(5000);
		List<WebElement> lists1=driver.findElements(findAssignmentAddedAdmin);
		return lists1;
	}

	public List<WebElement> getObjectiveAssignmentsValueDisplay() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(findRemarksPlusIcon).click();
		Thread.sleep(5000);
		List<WebElement> lists1=driver.findElements(findAssignmentCheckBoxSelected);
		return lists1; 
	}
	
	public List<WebElement> getObjectiveUserAssignmentsValueDisplay() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(findAssignmentCancelButton).click();
		Thread.sleep(2000);
		driver.findElement(findRemarksPlusIcon).click();
		Thread.sleep(5000);
		List<WebElement> lists1=driver.findElements(findAssignmentCheckBoxSelected);
		return lists1; 
	}

	public List<WebElement> getObjectiveAssignmentsPlaningUnitCheckBox() throws InterruptedException, FindFailed {
		Thread.sleep(2000);
		driver.findElement(findAssignmentCancelButton).click();
		Thread.sleep(2000);
		driver.findElement(findRemarksPlusIcon).click();
		Thread.sleep(3000);
		driver.findElement(findAssignmentFilterByDropdown).click();
		Thread.sleep(3000);
		Screen scrn=new Screen();
		//Pattern pattern1=new Pattern("D:\\Shantanu\\TestAutomation\\DiamondQA\\SpolAutomation\\src\\resources\\images\\quotation.jpg");
		Pattern pattern1=new Pattern(System.getProperty("user.dir")+"\\src\\resources\\images\\plainingunit.jpg");
		scrn.click(pattern1);
		
		//List<WebElement> lists=driver.findElements(findAssignmentCheckBox);
		//lists.get(0).click();
		Thread.sleep(2000);
		List<WebElement> lists1=driver.findElements(findAssignmentCheckBoxSelected);
		lists1.get(0).click();
		return lists1; 
	}

	public List<WebElement> getObjectiveAssignmentsPlaningUnitSaveAllInfo() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(findAssignmentSaveButton).click();
		return driver.findElements(findAssignmentAddedAdmin);
	}

	public WebElement getObjectiveAssignmentsExternalContributorsDropDownSelection() throws InterruptedException, FindFailed {
		Thread.sleep(2000);
		driver.findElement(findRemarksPlusIcon).click();
		Thread.sleep(3000);
		driver.findElement(findAssignmentFilterByDropdown).click();
		Thread.sleep(3000);
		Screen scrn=new Screen();
		//Pattern pattern1=new Pattern("D:\\Shantanu\\TestAutomation\\DiamondQA\\SpolAutomation\\src\\resources\\images\\quotation.jpg");
		Pattern pattern1=new Pattern(System.getProperty("user.dir")+"\\src\\resources\\images\\externalcontributor.jpg");
		scrn.click(pattern1);
		Thread.sleep(3000);
		return driver.findElement(findAssignmentEmailDropDown);
	}

	public WebElement getObjectiveAssignmentsExternalContributorDisabledPlusButton() {
		return driver.findElement(findAssignmentPlusButtonDisabled);
	}

	public WebElement getObjectiveAssignmentsExternalContributorFirstNameRequiredErrorMessage() throws InterruptedException {
		Thread.sleep(2000);
		//driver.findElement(findAssignmentFirstNameDropDown).clear();
		driver.findElement(findAssignmentFirstNameDropDown).click();
		driver.findElement(findAssignmentLastNameDropDown).click();
		//driver.findElement(findAssignmentFirstNameText).click();
		Thread.sleep(2000);
		return driver.findElement(findAssignmentFirstNameRequiredErrorMessage);
	}

	public WebElement getObjectiveAssignmentsExternalContributorThreeFieldFillupPlusIconEnabled() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(findAssignmentFirstNameDropDown).sendKeys("abc");
		driver.findElement(findAssignmentLastNameDropDown).sendKeys("cdf");
		driver.findElement(findAssignmentEmailDropDown).sendKeys("abc@gmail.com");
		Thread.sleep(2000);
		return driver.findElement(findAssignmentPlusButtonEnabled);
	}

	public List<WebElement> getObjectiveAssignmentsExternalContributorPlusIconSaveAllInfo() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(findAssignmentPlusButtonEnabled).click();
		Thread.sleep(5000);
		List<WebElement> lists1=driver.findElements(findAssignmentCheckBoxSelected);
		return lists1;
	}

	public List<WebElement> getObjectiveAssignmentsExternalContributorCheckAnyCheckBox() throws InterruptedException {
		Thread.sleep(5000);
		List<WebElement> lists1=driver.findElements(findAssignmentCheckBoxSelected);
		lists1.get(1).click();
		return lists1;
	}

	public List<WebElement> getObjectiveAssignmentsExternalContributorSaveAllInfo() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(findAssignmentSaveButton).click();
		Thread.sleep(5000);
		List<WebElement> lists1=driver.findElements(findAssignmentAddedAdmin);
		return lists1;
	}

	public WebElement getObjectiveClickBudgetLink() throws InterruptedException {
		driver.findElement(findHamburgerMenu).click();
		Thread.sleep(2000);
		//Scroll window
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		driver.findElement(findBudgetLink).click();
		return driver.findElement(findBudgeDetailHeaderText);
	}

	public WebElement getObjectiveYearDropDown() {
		return driver.findElement(findDescriptionDropdown);
	}

	public WebElement getObjectiveBudgetPlusIcon() {
		return driver.findElement(findRemarksPlusIcon);
	}

	public WebElement getObjectiveNoRecordsText() {
		return driver.findElement(findRemarksNoRecords);
	}

	public WebElement getObjectiveClickPlusIconNewEnhanceBudgetPopup() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(findRemarksPlusIcon).click();
		Thread.sleep(2000);
		return driver.findElement(findNewEnhanceBudgetHeaderText);
	}

	public WebElement getObjectiveBudgetAccountDropDownList() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(findBudgetAccountDropDown).click();
		Thread.sleep(2000);
		driver.findElement(findBudgetAccountDropDown).click();
		return driver.findElement(findBudgetAccountDropDown);
	}

	public WebElement getObjectiveBudgetGLCodeDropDownList() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(findBudgetGLCodeDropDown).click();
		Thread.sleep(2000);
		driver.findElement(findBudgetGLCodeDropDown).click();
		return driver.findElement(findBudgetGLCodeDropDown);
	}

	public WebElement getObjectiveNewButtonEnabledBothDropDownSelection() throws InterruptedException, FindFailed {
		Thread.sleep(3000);
		driver.findElement(findBudgetAccountDropDown).click();
		Thread.sleep(2000);
		Screen scrn=new Screen();
		Pattern pattern1=new Pattern(System.getProperty("user.dir")+"\\src\\resources\\images\\budgetaccountdropdownselect.jpg");
		scrn.click(pattern1);
		Thread.sleep(2000);
		driver.findElement(findBudgetGLCodeDropDown).click();
		Thread.sleep(2000);
		Screen scrn1=new Screen();
		Pattern pattern2=new Pattern(System.getProperty("user.dir")+"\\src\\resources\\images\\glcodeaddnew.jpg");
		scrn1.click(pattern2);
		Thread.sleep(3000);
		return driver.findElement(findNextButtonEnable);
	}

	public WebElement getObjectiveEnhancedForecastDetails() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(findFirstGLCodeRadioButton).click();
		Thread.sleep(2000);
		driver.findElement(findNextButtonEnable).click();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		return driver.findElement(findEnhancedForecastDetailsHeaderText);
	}

	public WebElement getObjectiveBudgetAmountRequiredAlertMessage() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> lists1=driver.findElements(findAmountInputField);
		lists1.get(0).click();
		Thread.sleep(2000);
		lists1.get(1).click();
		return driver.findElement(findBudgetAmountRequiredAlertMessage);
	}

	public WebElement getObjectiveNoValueApproveAmountFieldCheckBoxCheck() throws InterruptedException, FindFailed {
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(2000);
		Screen scrn=new Screen();
		Pattern pattern1=new Pattern(System.getProperty("user.dir")+"\\src\\resources\\images\\uncheckednotfunded.jpg");
		scrn.click(pattern1);
		Thread.sleep(3000);
		Screen scrn1=new Screen();
		Pattern pattern2=new Pattern(System.getProperty("user.dir")+"\\src\\resources\\images\\checkednotfunded.jpg");
		scrn1.click(pattern2);
		Thread.sleep(2000);
		List<WebElement> lists1=driver.findElements(findAmountInputField);
		return lists1.get(1);
	}

	public WebElement getObjectiveAddValueApproveAmountFieldCheckBoxCheck() throws InterruptedException, FindFailed {
		Thread.sleep(2000);
//		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
//		Thread.sleep(2000);
		List<WebElement> lists1=driver.findElements(findAmountInputField);
//		lists1.get(1).click();
//		lists1.get(1).clear();
//		 JavascriptExecutor jse = (JavascriptExecutor)driver;
//		 jse.executeScript("arguments[0].value='110';", lists1.get(1));
		lists1.get(1).sendKeys("110");
		Thread.sleep(3000);
		Screen scrn=new Screen();
		Pattern pattern1=new Pattern(System.getProperty("user.dir")+"\\src\\resources\\images\\uncheckednotfunded.jpg");
		scrn.click(pattern1);
		Thread.sleep(2000);
		return lists1.get(1);
	}

	public WebElement getObjectiveProposeAmountPopulatedApprovedAmountField() throws InterruptedException, FindFailed {
		Thread.sleep(3000);
		Screen scrn=new Screen();
		Pattern pattern1=new Pattern(System.getProperty("user.dir")+"\\src\\resources\\images\\checkednotfunded.jpg");
		scrn.click(pattern1);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		Thread.sleep(2000);
		List<WebElement> lists3=driver.findElements(findAmountInputField);
		lists3.get(0).sendKeys("110");
		Thread.sleep(2000);
		driver.findElement(findProposedAmountApproveButton).click();
		Thread.sleep(2000);
		return lists3.get(1);
	}

	public WebElement getObjectiveAmountShowInTaskPageAfterSave() throws InterruptedException {
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(2000);
		driver.findElement(findSaveButtonBudget).click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		return driver.findElement(findBudgeDetailHeaderText);
	}	
}
