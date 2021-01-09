package ModelClass;

import java.nio.Buffer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Goals {
	WebDriver driver;

	public Goals(WebDriver driver) {
		this.driver=driver;
	}
	
	By planningUnitGoalPlusButton =By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[1]/planning-unit-details-home[1]/div[1]/app-plnning-unit-goal-info[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]");
	By crossButtonPlanningUnitGoalRightBy=By.xpath("//span[contains(text(),'×')]");
	By goalNumberTextFieldRight =By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[2]/app-plnning-unit-goal-edit[1]/div[1]/div[3]/dynamic-form[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/kendo-numerictextbox[1]/span[1]/input[1]");
	By goalTitleTextFieldRight =By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[2]/app-plnning-unit-goal-edit[1]/div[1]/div[3]/dynamic-form[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[4]/div[1]/input[1]");
	By planningYearRight =By.xpath("//span[contains(text(),'2018-2019 (Current)')]");
	By goalDescriptionTextField =By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[2]/app-plnning-unit-goal-edit[1]/div[1]/div[3]/dynamic-form[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[6]/kendo-textbox-container[1]/kendo-editor[1]/div[1]/div[1]");
	By saveButtonRight = By.xpath("//button[contains(text(),'Save')]");
	By cancelButton =By.xpath("//button[contains(text(),'Cancel')]"); 
	By goalNumberTitleRight =By.xpath("//span[contains(text(),'Goal Number')]");
	By goalPlanningYearRightTextField =By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[2]/app-plnning-unit-goal-edit[1]/div[1]/div[3]/dynamic-form[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/div[1]/kendo-multiselect[1]/div[1]");
	
	By planningUnitSWOTTitleButton =By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[1]/planning-unit-details-home[1]/div[1]/plnning-unit-sowt-info[1]/div[1]/div[1]/div[1]/div[1]/div[1]");
	By planningUnitSWOTPlusButton =By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[1]/planning-unit-details-home[1]/div[1]/plnning-unit-sowt-info[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]");
	By planningUnitSWOTTitleRight =By.xpath("//h6[contains(text(),'Planning Unit SWOT')]");
	
	By dateFieldSWOTRight =By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[2]/app-plnning-unit-swot-edit[1]/div[1]/div[3]/dynamic-form[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/kendo-datepicker[1]/span[1]/kendo-dateinput[1]/span[1]/input[1]");
	By planningYearCurrentSWOTRight =  By.xpath("//span[contains(text(),'2018-2019 (Current)')]");
	By descriptionTextFieldSWOTRight = By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[2]/app-plnning-unit-swot-edit[1]/div[1]/div[3]/dynamic-form[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/kendo-textbox-container[1]/kendo-editor[1]/div[1]/div[1]");
	By achievementsTextFieldSWOTRight =By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[2]/app-plnning-unit-swot-edit[1]/div[1]/div[3]/dynamic-form[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[6]/kendo-textbox-container[1]/kendo-editor[1]/div[1]/div[1]");
	By strengthsTextFieldSWOTRight =   By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[2]/app-plnning-unit-swot-edit[1]/div[1]/div[3]/dynamic-form[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[7]/kendo-textbox-container[1]/kendo-editor[1]/div[1]/div[1]");
	By weaknessTextFieldSWOTRight =    By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[2]/app-plnning-unit-swot-edit[1]/div[1]/div[3]/dynamic-form[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[8]/kendo-textbox-container[1]/kendo-editor[1]/div[1]/div[1]");
	By opportunitiesTextFieldSWOTRight=By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[2]/app-plnning-unit-swot-edit[1]/div[1]/div[3]/dynamic-form[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[9]/kendo-textbox-container[1]/kendo-editor[1]/div[1]/div[1]");
	By threatsTextFieldSWOTRight =By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[2]/app-plnning-unit-swot-edit[1]/div[1]/div[3]/dynamic-form[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[10]/kendo-textbox-container[1]/kendo-editor[1]/div[1]/div[1]");
	By cancelButtonSWOTRight =By.xpath("//button[contains(text(),'Cancel')]");
	By saveButtonSWOTRight =By.xpath("//button[contains(text(),'Save')]");
	
	By inputDateSWOTRight = By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/planning-unit-details[1]/merge-com[1]/div[1]/div[2]/app-plnning-unit-swot-edit[1]/div[1]/div[3]/dynamic-form[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/kendo-datepicker[1]/span[1]/span[1]/span[1]");
	
	
	public WebElement getPlanningUnitGoalPlusButton() {
		return driver.findElement(planningUnitGoalPlusButton); 
	}
	public WebElement getCrossButtonPlanningUnitGoalRightBy() {
		return driver.findElement(crossButtonPlanningUnitGoalRightBy);
	}
	public WebElement getGoalNumberTextFieldRight() {
		return driver.findElement(goalNumberTextFieldRight);
	}
	public WebElement getGoalTitleTextFieldRight() {
		return driver.findElement(goalTitleTextFieldRight);
	}
	public WebElement getPlanningYearCurrentRight() {
		return driver.findElement(planningYearRight);
	}
	public WebElement getGoalDescriptionTextField() {
		return driver.findElement(goalDescriptionTextField);
	}
	public WebElement getSaveButtonRight() {
		return driver.findElement(saveButtonRight);
	}
	public WebElement getCancelButton() {
		return driver.findElement(cancelButton);
	}
	public WebElement getGoalNumberTitleRight() {
		return driver.findElement(goalNumberTitleRight);
	}
	public WebElement getGoalPlanningYearRightTextField() {
		return driver.findElement(goalPlanningYearRightTextField);
	}
	public WebElement getPlanningUnitSWOTTitleButton() {
		return driver.findElement(planningUnitSWOTTitleButton);
	}
	public WebElement getPlanningUnitSWOTPlusButton() {
		return driver.findElement(planningUnitSWOTPlusButton);
	}
	public WebElement getPlanningUnitSWOTTitleRight() {
		return driver.findElement(planningUnitSWOTTitleRight);
	}
	public WebElement getDateFieldSWOTRight() {
		return driver.findElement(dateFieldSWOTRight);
	}
	public WebElement getPlanningYearCurrentSWOTRight() {
		return driver.findElement(planningYearCurrentSWOTRight);
	}
	public WebElement getDescriptionTextFieldSWOTRight() {
		return driver.findElement(descriptionTextFieldSWOTRight);
	}
	public WebElement getAchievementsTextFieldSWOTRight() {
		return driver.findElement(achievementsTextFieldSWOTRight);
	}
	public WebElement getStrengthsTextFieldSWOTRight() {
		return driver.findElement(strengthsTextFieldSWOTRight);
	}
	public WebElement getWeaknessTextFieldSWOTRight() {
		return driver.findElement(weaknessTextFieldSWOTRight);
	}
	public WebElement getOpportunitiesTextFieldSWOTRight() {
		return driver.findElement(opportunitiesTextFieldSWOTRight);
	}
	public WebElement getThreatsTextFieldSWOTRight() {
		return driver.findElement(threatsTextFieldSWOTRight);
	}
	public WebElement getCancelButtonSWOTRight() {
		return driver.findElement(cancelButtonSWOTRight);
	}
	public WebElement getSaveButtonSWOTRight() {
		return driver.findElement(saveButtonSWOTRight);
	}
	public WebElement getInputDateSWOTRight() {
		return driver.findElement(inputDateSWOTRight);
	}
	
	
	
	
	
	
	
	
}
