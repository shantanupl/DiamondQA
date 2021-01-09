package ModelClass;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlanningUnitDetails {
	//Object
	WebDriver driver;
	public PlanningUnitDetails(WebDriver driver) {
		this.driver=driver;
	}
	
	By infoButton = By.xpath("//button[contains(text(),'Info')]");
	By membersTitle = By.xpath("//div[contains(text(),'Members')]");
	By budgetAccountTitle = By.xpath("//div[contains(text(),'Budget Accounts')]");
	By impactingObjectivesTitle = By.xpath("//div[contains(text(),'Impacting Objectives')]");
	
	By membersNoRecordText = By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[1]/planning-unit-details-home[1]/div[1]/planning-unit-members[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]");
	By budgetNoRecordText = By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[1]/planning-unit-details-home[1]/div[1]/associated-budget-accounts[1]/div[1]/div[1]/div[2]/no-data[1]/div[1]/div[1]/div[1]/span[1]");
	By assignmentRecordText = By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[1]/planning-unit-details-home[1]/div[1]/associated-budget-accounts[1]/div[1]/div[1]/div[2]/no-data[1]/div[1]/div[1]/div[1]/span[1]");
	By objectiveNoRecordText = By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[1]/planning-unit-details-home[1]/div[1]/impacted-objectives[1]/div[1]/div[2]/span[1]");
	
	By unitManagerTitle = By.xpath("//div[contains(text(),'Unit Manager')]");
	By unitDetailsRight = By.xpath("//h6[contains(text(),'Planning Unit Details')]");
	
	By unitCodeRight = By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[2]/app-planning-unit-info-edit[1]/div[1]/dynamic-form[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/input[1]");
	By unitTitleRight = By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[2]/app-planning-unit-info-edit[1]/div[1]/dynamic-form[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/input[1]");
	By unitPurposeRight = By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[2]/app-planning-unit-info-edit[1]/div[1]/dynamic-form[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[7]/kendo-textbox-container[1]/kendo-editor[1]/div[1]/div[1]");
	
	By saveButtonRight = By.xpath("//button[contains(text(),'Save')]");
	By cancelButtonRight = By.xpath("//button[contains(text(),'Cancel')]");
	
	By crossButtonRight =By.xpath("//span[contains(text(),'×')]");	
	
	By crossButtonRemoveParent =By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[2]/app-planning-unit-info-edit[1]/div[1]/dynamic-form[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[6]/div[1]/tree-view-dropdownlist[1]/span[1]/span[1]/span[1]/span[1]");
	By parentPlanningUnitDropdownButton = By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[2]/app-planning-unit-info-edit[1]/div[1]/dynamic-form[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[6]/div[1]/tree-view-dropdownlist[1]/span[1]/span[1]/span[2]/span[1]");
	
	By memberTitleRight = By.xpath("//h6[contains(text(),'Planning Unit Members')]");
	By paginationButtonRight =By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[2]/app-planning-unit-members-edit[1]/div[1]/div[3]/div[1]/kendo-grid[1]/kendo-pager[1]/kendo-pager-numeric-buttons[1]/ul[1]/li[1]/a[1]");
	By memberSearchBarRight =By.xpath("//thead/tr[2]/td[2]/kendo-grid-string-filter-cell[1]/kendo-grid-filter-wrapper-cell[1]/input[1]");
	
	By adminSystemRight = By.xpath("//td[contains(text(),'Admin, System')]");
	By memberSecondRight =By.xpath("//td[contains(text(),'Real, Sanaullah Al')]");
	By supportRight =By.xpath("//td[contains(text(),'Support, TES')]");
	By testUserRight =By.xpath("//td[contains(text(),'Test, User1')]");
	
	By memberCheckbox1= By.xpath("//input[@id='k-grid3-checkbox0']");
	
	
	By dot3ButtonRight =By.xpath("//span[@id='dropdownMenuButton']");
	By deleteButtonRight = By.xpath("//a[contains(text(),'Delete')]");
	By deactiveButtonRight =By.xpath("//a[contains(text(),'Deactivate')]");
	By editErpButton =By.xpath("//a[contains(text(),'Edit ERP ID')]");
	
	By confirmDeleteText =By.xpath("//div[contains(text(),'Are you sure you want to delete this Planning Unit')]");
	By cancelButtonFromDelete = By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[2]/app-planning-unit-info-edit[1]/app-confirmation[1]/kendo-dialog[1]/div[2]/div[1]/div[1]/div[2]/button[1]");
	By deleteButtonFromDelete =By.xpath("//button[contains(text(),'Delete')]");
	
	
	By confirmDeactivateText = By.xpath("//p[contains(text(),'Are you sure you want to deactivate this record?')]");
	By noButtonFromDeactivate = By.xpath("//button[contains(text(),'No')]");
	By yesButtonFromDeactivate =By.xpath("//button[contains(text(),'Yes')]");
	
	
	
	By cancelButtonFromEditErp =By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[2]/app-planning-unit-info-edit[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/app-edit-erp[1]/form[1]/div[2]/button[1]");
	By saveButtonFromEditErp =By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[2]/app-planning-unit-info-edit[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/app-edit-erp[1]/form[1]/div[2]/button[2]");
	By editErpTextField =By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[2]/app-planning-unit-info-edit[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/app-edit-erp[1]/form[1]/div[1]/input[1]");
	
	
	
	By favoriteIcon =By.xpath("//planning-unit-detail-header-tab/div[1]/div[1]/span[1]/i[1]");
	
	By goalButton = By.xpath("//button[contains(text(),'Goals')]");
	By planningUnitGoalsTitleButton =By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[1]/planning-unit-details-home[1]/div[1]/app-plnning-unit-goal-info[1]/div[1]/div[1]/div[1]/div[1]/div[1]");
	By planningUnitSWOTTitleButton =By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[1]/planning-unit-details-home[1]/div[1]/plnning-unit-sowt-info[1]/div[1]/div[1]/div[1]/div[1]/div[1]");
	
	
	
	
	By planningUnitGoalTitleRight= By.xpath("//h6[contains(text(),'Planning Unit Goal')]");
	
	
	public WebElement getInfoButton() {
		return driver.findElement(infoButton);
	}
	
	public WebElement getmembersTitle() {
		return driver.findElement(membersTitle);
	}
	public WebElement getbudgetAccountTitle() {
		return driver.findElement(budgetAccountTitle);
	}
	public WebElement getimpactingObjectivesTitle() {
		return driver.findElement(impactingObjectivesTitle);
	}
	
	public WebElement getMembersNoRecordText() {
		return driver.findElement(membersNoRecordText);
	}
	public WebElement getAssignmentRecordText() {
		return driver.findElement(assignmentRecordText);
	}
	public WebElement getObjectiveNoRecordText() {
		return driver.findElement(objectiveNoRecordText);
	}
	
	public WebElement getBudgetNoRecordText() {
		return driver.findElement(budgetNoRecordText);
	}
	
	public WebElement getUnitManagerTitle() {
		return driver.findElement(unitManagerTitle);
	}
	public WebElement getUnitDetailsRight() {
		return driver.findElement(unitDetailsRight);
	}
	public WebElement getUnitCodeRight() {
		return driver.findElement(unitCodeRight);
	}
	public WebElement getUnitTitleRight() {
		return driver.findElement(unitTitleRight);
	}
	public WebElement getUnitPurposeRight() {
		return driver.findElement(unitPurposeRight);
	}
	public WebElement getSaveButtonRight() {
		return driver.findElement(saveButtonRight);
	}
	public WebElement getCancelButtonRight() {
		return driver.findElement(cancelButtonRight);
	}
	
	public WebElement getCrossButtonRight() {
		return driver.findElement(crossButtonRight);
	}
	public WebElement getCrossButtonRemoveParent() {
		return driver.findElement(crossButtonRemoveParent);
	}
	public WebElement getParentPlanningUnitDropdownButton() {
		return driver.findElement(parentPlanningUnitDropdownButton);
	}
	
	public WebElement getMemberTitleRight() {
		return driver.findElement(memberTitleRight);
	}
	public WebElement getPaginationButtonRight() {
		return driver.findElement(paginationButtonRight);
	}
	public WebElement getMemberSearchBarRight() {
		return driver.findElement(memberSearchBarRight);
	}
	public WebElement getAdminSystemRight() {
		return driver.findElement(adminSystemRight);
	}
	public WebElement getMemberSecondRight() {
		return driver.findElement(memberSecondRight);
	}
	public WebElement getSupportRight() {
		return driver.findElement(supportRight);
	}
	
	public WebElement getTestUserRight() {
		return driver.findElement(testUserRight);
	}
	
	public WebElement getMemberCheckbox1() {
		return driver.findElement(memberCheckbox1);
	}
	
	
	public WebElement getDot3ButtonRight() {
		return driver.findElement(dot3ButtonRight);
	}
	public WebElement getDeleteButtonRight() {
		return driver.findElement(deleteButtonRight);
	}
	public WebElement getDeactiveButtonRight() {
		return driver.findElement(deactiveButtonRight);
	}
	public WebElement getEditErpButton() {
		return driver.findElement(editErpButton);
	}
	public WebElement getCancelButtonFromDelete() {
		return driver.findElement(cancelButtonFromDelete);
	}
	public WebElement getConfirmDeleteText() {
		return driver.findElement(confirmDeleteText);
	}
	public WebElement getDeleteButtonFromDelete() {
		return driver.findElement(deleteButtonFromDelete);
	}
	public WebElement getConfirmDeactivateText() {
		return driver.findElement(confirmDeactivateText);
	}
	public WebElement getNoButtonFromDeactivate() {
		return driver.findElement(noButtonFromDeactivate);
	}
	public WebElement getYesButtonFromDeactivate() {
		return driver.findElement(yesButtonFromDeactivate);
	}
	public WebElement getCancelButtonFromEditErp() {
		return driver.findElement(cancelButtonFromEditErp);
	}
	public WebElement getSaveButtonFromEditErp() {
		return driver.findElement(saveButtonFromEditErp);
	}
	public WebElement getEditErpTextField() {
		return driver.findElement(editErpTextField);
	}
	public WebElement getFavoriteIcon() {
		return driver.findElement(favoriteIcon);
	}
	public WebElement getGoalButton() {
		return driver.findElement(goalButton);
	}
	public WebElement getPlanningUnitGoalsTitleButton() {
		return driver.findElement(planningUnitGoalsTitleButton);
	}
	public WebElement getPlanningUnitSWOTTitleButton() {
		return driver.findElement(planningUnitSWOTTitleButton);
	}
	public WebElement getPlanningUnitGoalTitleRight() {
		return driver.findElement(planningUnitGoalTitleRight);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
