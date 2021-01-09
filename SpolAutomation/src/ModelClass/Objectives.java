package ModelClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Objectives {
	WebDriver driver;

	public Objectives(WebDriver driver) {
		this.driver=driver;
	}
	
	
	By objectivesButton=By.xpath("//button[contains(text(),'Objectives')]");
	By objectivesTitle =By.xpath("//span[contains(text(),'Objectives')]");
	By plusButtonObjectives =By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[1]/planning-unit-details-home[1]/div[1]/app-plnning-unit-objectives[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/span[2]");
	By newObjectiveTitleInForm =By.xpath("//div[contains(text(),'New Objective')]");
	By objectiveTitleTextFieldInForm =By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[1]/planning-unit-details-home[1]/div[1]/app-plnning-unit-objectives[1]/new-objective[1]/kendo-dialog[1]/div[2]/div[1]/div[1]/form[1]/div[1]/input[1]");
	
	By objectivePurposeDropdownButton =By.xpath("//span[contains(text(),'Please select Objective Purpose')]");
	By objectiveStatusDropdownButton =By.xpath("//span[contains(text(),'Please select Objective Status')]");
	By objectiveDescriptionTextField=By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[1]/planning-unit-details-home[1]/div[1]/app-plnning-unit-objectives[1]/new-objective[1]/kendo-dialog[1]/div[2]/div[1]/div[1]/form[1]/div[4]/div[1]/kendo-editor[1]/div[1]/div[1]");
	By multiyearCheckbox =By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[1]/planning-unit-details-home[1]/div[1]/app-plnning-unit-objectives[1]/new-objective[1]/kendo-dialog[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[2]/div[1]/label[1]/input[1]");
	By objectiveCancelButton =By.xpath("//button[contains(text(),'Cancel')]");
	By objectiveSaveButton =By.xpath("//button[contains(text(),'Save')]");
	By planningUnitDropdownExisting =By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[1]/planning-unit-details-home[1]/div[1]/app-plnning-unit-objectives[1]/new-objective[1]/kendo-dialog[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/kendo-dropdownlist[1]");
	
	By crossButtonInNewObjectiveForm = By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[1]/planning-unit-details-home[1]/div[1]/app-plnning-unit-objectives[1]/new-objective[1]/kendo-dialog[1]/div[2]/kendo-dialog-titlebar[1]/div[2]/a[1]/span[1]");
	By approveNoteIcon =By.xpath("//app-objective-detail-header-tab/div[1]/div[1]/div[1]/span[1]/i[1]");
	By DRAFT_Button=By.xpath("//span[contains(text(),'-- DRAFT --')]");
	By approveObjectiveFromDropdown =By.xpath("//a[contains(text(),'Approve Objective')]");
	By viewApprovalHistoryFromDropdown =By.xpath("//a[contains(text(),'View Approval History')]");
	By approveNoteTitleFromPopup = By.xpath("//div[contains(text(),'Approval Notes')]");
	By approveButtonFromPopup =By.xpath("//button[contains(text(),'Approve')]");
	By cancelButtonFromPopup =By.xpath("//app-objective-detail-header-tab/kendo-dialog[1]/div[2]/div[1]/app-approval[1]/div[1]/div[1]/div[1]/form[1]/div[2]/button[1]");
	By approveNoteTextFieldFromPopup=By.xpath("//textarea[@id='approvalNote']");
	By removeAllApprovalsFromDropdown=By.xpath("//a[contains(text(),'Remove All Approvals')]");
	
	
	By objectiveDetailTitleRight=By.xpath("//h6[contains(text(),'Objective Detail')]");
	By objectiveTitleTextFieldRight =By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/app-objective[1]/merge-com[1]/div[1]/div[2]/app-objective-form[1]/div[1]/dynamic-form[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/input[1]");
	By descriptionTextFieldRight =By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/app-objective[1]/merge-com[1]/div[1]/div[2]/app-objective-form[1]/div[1]/dynamic-form[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[10]/kendo-textbox-container[1]/kendo-editor[1]/div[1]/div[1]");
	
	By institutionalGoalsTitle = By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/app-objective[1]/merge-com[1]/div[1]/div[1]/objective-detail-home[1]/div[1]/app-objective-inst-goal-info[1]/div[1]/div[1]/div[1]/div[2]");
	By institutionalGoalsTitleRight =By.xpath("//h6[contains(text(),'Institutional Goal')]");
	public WebElement getObjectivesButton() {
		return driver.findElement(objectivesButton);
	}
	public WebElement getObjectivesTitle() {
		return driver.findElement(objectivesTitle);
	}
	public WebElement getPlusButtonObjectives() {
		return driver.findElement(plusButtonObjectives);
	}
	public WebElement getNewObjectiveTitleInForm() {
		return driver.findElement(newObjectiveTitleInForm);
	}
	public WebElement getObjectiveTitleTextFieldInForm() {
		return driver.findElement(objectiveTitleTextFieldInForm);
	}
	public WebElement getObjectivePurposeDropdownButton() {
		return driver.findElement(objectivePurposeDropdownButton);
	}
	public WebElement getObjectiveStatusDropdownButton() {
		return driver.findElement(objectiveStatusDropdownButton);
	}
	public WebElement getObjectiveDescriptionTextField() {
		return driver.findElement(objectiveDescriptionTextField);
	}
	public WebElement getMultiyearCheckbox() {
		return driver.findElement(multiyearCheckbox);
	}
	public WebElement getObjectiveCancelButton() {
		return driver.findElement(objectiveCancelButton);
	}
	public WebElement getObjectiveSaveButton() {
		return driver.findElement(objectiveSaveButton);
	}
	public WebElement getCrossButtonInNewObjectiveForm() {
		return driver.findElement(crossButtonInNewObjectiveForm);
	}
	public WebElement getPlanningUnitDropdownExisting() {
		return driver.findElement(planningUnitDropdownExisting);
	}
	public WebElement getApproveNoteIcon() {
		return driver.findElement(approveNoteIcon);
	}
	public WebElement getDRAFT_Button() {
		return driver.findElement(DRAFT_Button);
	}
	public WebElement getApproveObjectiveFromDropdown() {
		return driver.findElement(approveObjectiveFromDropdown);
	}
	public WebElement getViewApprovalHistoryFromDropdown() {
		return driver.findElement(viewApprovalHistoryFromDropdown);
	}
	public WebElement getApproveNoteTitleFromPopup() {
		return driver.findElement(approveNoteTitleFromPopup);
	}
	public WebElement getCancelButtonFromPopup() {
		return driver.findElement(cancelButtonFromPopup);
	}
	public WebElement getApproveButtonFromPopup() {
		return driver.findElement(approveButtonFromPopup);
	}
	public WebElement getApproveNoteTextFieldFromPopup() {
		return driver.findElement(approveNoteTextFieldFromPopup);
	}
	public WebElement getRemoveAllApprovalsFromDropdown() {
		return driver.findElement(removeAllApprovalsFromDropdown);
	}
	public WebElement getObjectiveDetailTitleRight() {
		return driver.findElement(objectiveDetailTitleRight);
	}
	public WebElement getObjectiveTitleTextFieldRight() {
		return driver.findElement(objectiveTitleTextFieldRight);
	}
	public WebElement getDescriptionTextFieldRight() {
		return driver.findElement(descriptionTextFieldRight);
	}
	public WebElement getInstitutionalGoalsTitle() {
		return driver.findElement(institutionalGoalsTitle);
	}
	public WebElement getInstitutionalGoalsTitleRight() {
		return driver.findElement(institutionalGoalsTitleRight);
	}


	
	
	

}
