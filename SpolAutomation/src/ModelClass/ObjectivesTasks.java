package ModelClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
	By findDescriptionText=By.xpath("//label[contains(text(),'Description:')]");
	By findDescriptionField=By.cssSelector("div.ProseMirror");
	By findCancelButton=By.xpath("//button[contains(text(),'Cancel')]");
	By findSaveButton=By.xpath("//button[contains(text(),'Save')]");
	By findStartDateGraterThanDueDate=By.xpath("//span[contains(text(), 'Start Date must be before the Due Date.')]");
	By findTaskTypeRequiredMessage=By.xpath("//span[contains(text(),' Task Type is required ')]");
	By findPriorityLevelRequiredMessage=By.xpath("//span[contains(text(),' Priority Level is required ')]");
	By findStatusRequiredMessage=By.xpath("//span[contains(text(),' Task Status is required ')]");
	
	public WebElement isTasksRowPlusButtonVisible() {
		return driver.findElement(tasksRowPlusButton);
	}
	
	public WebElement isTasksLinkTextDisplay() {
		return driver.findElement(linkTextTasks);
	}
	
	public WebElement isAddTaskNewFormDisplay() {
		return driver.findElement(linkTextTasks);
	}
	
	public WebElement isAddTaskNewFormDisplayClickWithoutPlusButton() {
		return driver.findElement(taskAddSectionHeaderText);
	}
	
	public WebElement isAddTaskNewFormDisplayClickPlusButton() {
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();", tasksRowPlusButton);
		return driver.findElement(taskAddSectionHeaderText);
	}
	//Add Task
	public WebElement getObjectiveTaskAddSectionHeaderText() {
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

	public WebElement getObjectiveDueDateCalendar() {
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
	
}
