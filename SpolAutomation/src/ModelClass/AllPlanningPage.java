package ModelClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllPlanningPage {
	//Planning
	WebDriver driver;
	public AllPlanningPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By pageTitle = By.xpath("//button[@id='dropdownMenuButton']");
	By detailButtonPrimary = By.xpath("//button[@id='detailButton']");
	By detailButtonSecondary = By.xpath("//button[@id='laneButton']");
	By searchBar = By.xpath("//planningunit-subheader-tab/div[1]/span[1]/div[1]/input[1]");
	By unitManagerDropdown = By.xpath("//span[contains(text(),'Unit Manager')]");
	By allUnitsDropdown = By.xpath("//planningunit-subheader-tab/div[1]/span[3]/kendo-dropdownlist[1]/span[1]/span[1]");
	By viewAllUnitsCheckbox = By.xpath("//planningunit-subheader-tab/div[1]/div[1]/label[1]");
	By downloadIcon = By.xpath("//planningunit-subheader-tab/div[1]/div[2]/span[1]/i[1]");
	By ellipsisIcon = By.xpath("//span[@id='dropdownMenuButton']");
	By newPlanButton = By.xpath("//a[contains(text(),'New Planning Unit')]");
	By unitcodeTextfield = By.xpath("//planningunit-subheader-tab/div[2]/app-new-planning-unit[1]/kendo-dialog[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]");
	By unitTitleTextfield = By.xpath("//planningunit-subheader-tab/div[2]/app-new-planning-unit[1]/kendo-dialog[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]");
	By unitManagerNewBDropdown = By.xpath("//planningunit-subheader-tab/div[2]/app-new-planning-unit[1]/kendo-dialog[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/lazy-dropdown[1]/button[1]");
    By unitTypeDropdown = By.xpath("//planningunit-subheader-tab/div[2]/app-new-planning-unit[1]/kendo-dialog[1]/div[2]/div[1]/div[1]/div[2]/div[2]/kendo-dropdownlist[1]/span[1]/span[1]");
    By unitParentDropdown = By.xpath("//planningunit-subheader-tab/div[2]/app-new-planning-unit[1]/kendo-dialog[1]/div[2]/div[1]/div[1]/div[3]/tree-view-dropdown[1]/div[1]/button[1]");
    By unitPurposeTextfield = By.xpath("//planningunit-subheader-tab/div[2]/app-new-planning-unit[1]/kendo-dialog[1]/div[2]/div[1]/div[1]/div[4]/div[1]/kendo-editor[1]/div[1]/div[1]");
    By cancelButton = By.xpath("//button[contains(text(),'Cancel')]");
    By saveButton = By.xpath("//button[contains(text(),'Save')]");
    By objText = By.xpath("//span[contains(text(),'Objectives')]");
    By sampleUnitName = By.xpath("//span[contains(text(),'M_PU_001')]");
    By sampleUnitManagerName= By.xpath("//body/app-root[1]/div[1]/div[1]/div[1]/all-planning-unit[1]/app-planning-unit[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[2]");
    By unitCodeWarning = By.xpath("//span[contains(text(),'Planning Unit Code is required')]");
    By planningUnitManagerDropValidation = By.xpath("//span[contains(text(),'1-50 out of 11826')]");
    By unitTitleWarning = By.xpath("//span[contains(text(),'Planning Unit Title is required')]");
    By unitManagerNeWarning = By.xpath("//span[contains(text(),'Planning Unit Manager is required')]");
    
    By plannningUnitTypeValidation = By.cssSelector("body.ng-tns-0-1:nth-child(2) app-root:nth-child(1) > app-message:nth-child(2)");
    By planningUnitTypeWarning = By.xpath("//span[contains(text(),'Planning Unit Type is required')]");
    
    By unitManagerAbadia = By.xpath("//div[contains(text(),'Paul, Shantanu')]");
    
    By backButtonFromPlanningUnitDetails = By.xpath("//app-planning-unit-det-top-left-header/div[1]/span[1]/i[1]");
    public boolean pageTitleIsDisplayed() {
		return driver.findElement(pageTitle).isDisplayed();
	}
    public boolean detailButtonPrimaryIsDisplayed() {
		return driver.findElement(detailButtonPrimary).isDisplayed();
	}
    public boolean detailButtonSecondaryIsDisplayed() {
		return driver.findElement(detailButtonSecondary).isDisplayed();
	}
    public boolean searchBarIsDisplayed() {
		return driver.findElement(searchBar).isDisplayed();
	}
    public boolean unitManagerDropdownIsDisplayed() {
		return driver.findElement(unitManagerDropdown).isDisplayed();
	}
    public boolean allUnitsDropdownIsDisplayed() {
		return driver.findElement(allUnitsDropdown).isDisplayed();
	}
    public boolean allUnitsCheckboxIsDisplayed() {
		return driver.findElement(viewAllUnitsCheckbox).isDisplayed();
	}
    public boolean downloadIconIsDisplayed() {
		return driver.findElement(downloadIcon).isDisplayed();
	}
    public boolean ellipsisIconIsDisplayed() {
		return driver.findElement(ellipsisIcon).isDisplayed();
	}
    public boolean unitcodeTextfieldIsDisplayed() {
		return driver.findElement(unitcodeTextfield).isDisplayed();
	}
    public boolean unitTitleTextfieldIsDisplayed() {
		return driver.findElement(unitTitleTextfield).isDisplayed();
	}
    public boolean unitManagerNewBDropdownIsDisplayed() {
		return driver.findElement(unitManagerNewBDropdown).isDisplayed();
	}
    public boolean unitTypeDropdownIsDisplayed() {
  		return driver.findElement(unitTypeDropdown).isDisplayed();
  	}
    public boolean unitParentDropdownIsDisplayed() {
  		return driver.findElement(unitParentDropdown).isDisplayed();
  	}
    public boolean unitPurposeTextfieldIsDisplayed() {
  		return driver.findElement(unitPurposeTextfield).isDisplayed();
  	}
    public boolean cancelButtonIsDisplayed() {
  		return driver.findElement(cancelButton).isDisplayed();
  	}
    public boolean saveButtonIsDisplayed() {
  		return driver.findElement(saveButton).isDisplayed();
  	}
    public void clickEllipsisIcon() {
		driver.findElement(ellipsisIcon).click();
	}
    public void clickNewPlan() {
		driver.findElement(newPlanButton).click();
	}
    public boolean cancelIsEnable() {
		return driver.findElement(cancelButton).isEnabled();
	}
    public boolean saveIsEnable() {
		return driver.findElement(saveButton).isEnabled();
	}
    public void clickSave() {
  		driver.findElement(saveButton).click();
  	}
    public void clickCancel() {
  		driver.findElement(cancelButton).click();
  	}
    
    public boolean detailPrimarySelected() {
		return driver.findElement(detailButtonPrimary).isSelected();
	}
    
    public boolean detailSecondarySelected() {
		return driver.findElement(detailButtonSecondary).isSelected();
	}
    public boolean objIsDisplayed() {
		return driver.findElement(objText).isDisplayed();
	}
    
    public String searchEmpty() {
		return driver.findElement(searchBar).getAttribute("value");
	}
    public String getUnitText() {
		return driver.findElement(unitManagerDropdown).getText().trim();
	}
    public String getAllUnitDropText() {
  		return driver.findElement(allUnitsDropdown).getText().trim();
  	}
      
    public boolean viewAllUnitsCheckboxSelected() {
		return driver.findElement(viewAllUnitsCheckbox).isSelected();
	}
    
    public boolean sampleunitDisplay() {
		return driver.findElement(sampleUnitName).isDisplayed();
	}
    public boolean sampleunitManagerDisplay() {
		return driver.findElement(sampleUnitManagerName).isDisplayed();
	}
    
    public void clickUnitCodeTextField() {
		driver.findElement(unitcodeTextfield).click();
	}
    
    public boolean UnitCodeTextFieldIsSelected() {
		return driver.findElement(unitcodeTextfield).isSelected();
	}
    public void clickUnitTitleTextField() {
		driver.findElement(unitTitleTextfield).click();
	}
    
    public boolean unitCodeWarningIsDisplayed() {
		return driver.findElement(unitCodeWarning).isDisplayed();
	}
    
    public String getUnitcodeWarningMsg() {
		return driver.findElement(unitCodeWarning).getText().trim();
	}
    
    public boolean unitTitleWarningIsDisplayed() {
		return driver.findElement(unitTitleWarning).isDisplayed();
	}
    
    public String getUnitTitleWarningMsg() {
		return driver.findElement(unitTitleWarning).getText().trim();
	}
    
    public void clickUnitManagerNewDropdown() {
		driver.findElement(unitManagerNewBDropdown).click();
	}
   
    public boolean plannningUnitDropdownValIsDisplayed() {
		return driver.findElement(planningUnitManagerDropValidation).isDisplayed();
	} 
    
    
    public void sendKeyUnitCode(String a) {
		driver.findElement(unitcodeTextfield).sendKeys(a);
	}
    
    public void sendKeyUnitTitle(String a) {
		driver.findElement(unitTitleTextfield).sendKeys(a);
	}
    
    
    public boolean unitManagerNewWarningIsDisplayed() {
		return driver.findElement(unitManagerNeWarning).isDisplayed();
	}
    
    public String getUnitManagerNewWarningMsg() {
		return driver.findElement(unitManagerNeWarning).getText().trim();
	}
    
    
    public void clickPlanningUnitType() {
		driver.findElement(unitTypeDropdown).click();
	}
    
    public WebElement getPlanningUnitCode() {
		return driver.findElement(unitcodeTextfield);
	}
    public WebElement getPlanningUnitTitle() {
		return driver.findElement(unitTitleTextfield);
	}
    public void clearText(By s) {
		driver.findElement(s).clear();
	}
    public WebElement getPlannningUnitTypeDrop() {
		return driver.findElement(unitTypeDropdown);
	}
    
    
    
    public WebElement getplannningUnitTypeValidation() {
		return driver.findElement(plannningUnitTypeValidation);
	}
    
    public WebElement getPlanningUnitTypeWarning() {
		return driver.findElement(planningUnitTypeWarning);
	}
    
    public WebElement getUnitManagerAbadia() {
		return driver.findElement(unitManagerAbadia);
	}
    public WebElement getBackButtonFromPlanningUnitDetails() {
		return driver.findElement(backButtonFromPlanningUnitDetails);
	}
    public WebElement getUnitParentDropdown() {
  		return driver.findElement(unitParentDropdown);
  	}
    public WebElement getUnitPurposeTextfield() {
  		return driver.findElement(unitPurposeTextfield);
  	}
    
    
    
    
    
}
