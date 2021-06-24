package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class PLCminutesPage extends PageBase {
	
	@FindBy(xpath ="//span[normalize-space()='New Minutes']")
    private WebElement btnNewMinutes;
	
	@FindBy(xpath ="//body/div[@id='root']/div/div/div/div/div/div/div/ul/div[2]")
    private WebElement lnkMyTeams;
	
	@FindBy(xpath ="//body//div[@id='root']//div//div//div//div//div//div//ul//div//div[3]")
    private WebElement lnkPLCminutes;
	
	@FindBy(xpath ="//body/div[@role='presentation']/div/div/div[2]/div[1]/button[1]/p[1]")
    private WebElement btnAddEditMembers;
	
	@FindBy(xpath ="//p[normalize-space()='Add Topic']")
    private WebElement btnAddTopic;
	
	@FindBy(xpath ="//div[8]//div[1]//button[1]//p[1]")
    private WebElement btnAddTask;
	
	@FindBy(xpath ="//button[@type='button']//span//p")
    private WebElement btnSaveChanges;
	
	@FindBy(xpath ="//body/div[@role='presentation']/div/div/div/div/div//*[local-name()='svg']")
    private WebElement btnBackArrow;
	
	@FindBy(xpath ="//body/div[@role='presentation']/div/div/div/div/div[@aria-label='rdw-wrapper']/div[2]")
    private WebElement txtNotes;
	
	@FindBy(xpath ="//div[8]//div[1]//button[1]//p[1]")
    private WebElement txtTask;
	
	@FindBy(xpath ="//div[9]//div[1]//div[1]//div[2]//div[1]//div[1]//input[1]")
    private WebElement selectDueDate;
	
	@FindBy(xpath ="//div[@role='presentation']//div//div//div//div//div//div//button[@type='button']//p")
    private WebElement btnViewOwner;
	
	@FindBy(xpath ="//p[normalize-space()='Save for Later']")
    private WebElement btnSaveForLater;
	
	@FindBy(xpath ="//button[@type='button']//span//p")
    private WebElement btnSave;
	
	@FindBy(xpath ="//button[@type='button']//span//p")
    private WebElement btnCancel;
	
	public  PLCminutesPage(WebDriver driver) {
		setWebDriver(driver);
	}
	
	public void clickOnbtnNewMinutes() {
		btnNewMinutes.click();
	}
	
	public void clickOnlnklnkMyTeams() {
		lnkMyTeams.click();
	}
	
	public PLCminutesPage clickOnlnkPLCminutes() {
		lnkPLCminutes.click();
		return new PLCminutesPage(pbDriver);
		
	}
	
	public void clickOnbtnAddEditMembers() {
		btnAddEditMembers.click();
	}
	
	public void clickOnbtnAddTopic() {
		btnAddTopic.click();
	}
	
	public void clickOnbtnAddTask() {
		btnAddTask.click();
	}
	
	public void clickOnbtnSaveChanges() {
		btnSaveChanges.click();
	}
	
	public void clickOnbtnBackArrow() {
		btnBackArrow.click();
	}
	
	public void enterNotes(String strNotes) {
		txtNotes.clear();
		txtNotes.sendKeys(strNotes);
	}
	
	public void enterTask(String strTask) {
		txtTask.clear();
		txtTask.sendKeys(strTask);
	}
	
	public void clickOnbtnViewOwner() {
		btnViewOwner.click();
	}
	//select due date
	
	
	
	
	public void clickOnbtnSaveForLater() {
		btnSaveForLater.click();
	}
	
	public void clickOnbtnSave() {
		btnSave.click();
	}
	
	public void clickOnbtnCancel() {
		btnCancel.click();
	}
	
}
