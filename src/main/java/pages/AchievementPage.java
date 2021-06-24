package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;
import utils.TestUtil;

public class AchievementPage extends PageBase {
	
	@FindBy(xpath ="//span[normalize-space()='Create Achievement']")
    private WebElement btnCreateAchievement;
	
	@FindBy(xpath ="//div[@id='demo-simple-select-outlined']")
	private WebElement liTeam;

	@FindBy(xpath ="//input[@placeholder='MM/DD/YYYY']")
	private WebElement txtDate;

	@FindBy(xpath ="//div[4]//div[1]//div[2]//div[1]//div[1]//input[1]")
	private WebElement txtTitle;

	@FindBy(xpath ="//textarea[@id='outlined-multiline-static']")
	private WebElement txtDescription;
	
	@FindBy(xpath ="//span[normalize-space()='Add']")
    private WebElement btnAdd;
	
	@FindBy(xpath ="//span[normalize-space()='Cancel']")
    private WebElement btnCancel;
	
	
	//17th June
	
	@FindBy(xpath ="//input[@placeholder='MM/DD/YYYY']")
	private WebElement btnDobCalender;

	@FindBy(xpath ="//div[@class='react-datepicker__current-month']")
	private WebElement lblMonthCurrentYear;
	
	//dob previous year
	
	@FindBy(xpath ="//div[@class='react-datepicker__current-month']")
	private WebElement btnDobCurrentYear;
	
	@FindBy(xpath ="//button[@aria-label='Previous Month']")
	private WebElement btnDobPreviousMonth;
	
	@FindBy(xpath ="//button[normalize-space()='Next Month']]")
	private WebElement btnDobNextMonth;
	
	public  AchievementPage(WebDriver driver) {
		setWebDriver(driver);
	}
	
	public void clickOnbtnCreateAchievement() {
		btnCreateAchievement.click();
	}
	
	/*public HomePage clickOnbtnCreateAchievement() {
		waitForElementToAppear(btnCreateAchievement);
		jsExecutorscrollIntoView(btnCreateAchievement);
		btnCreateAchievement.click();
		return null;
	}
	*/
	
	public void selectTeam(String strTeam) {
		waitForElementToAppear(liTeam);	
		TestUtil.selectItemByVisibleText(liTeam, strTeam);
	}
	
	public void clickandSelectTeam(String strTeam) throws Throwable {
		waitForElementToAppear(liTeam);	
		liTeam.click();
		smallwaitDriver();
		String xPathforTeam = "//li[normalize-space()='" + strTeam + "']";
		try {
			
			pbDriver.findElement(By.xpath(xPathforTeam)).click();
		}catch(NoSuchElementException e) {
			System.out.println(e.getLocalizedMessage());	
		}
	}
	
	public void enterDate(String strDate) throws Throwable, Throwable {
		txtDate.click();
		txtDate.sendKeys(strDate);
		txtDate.sendKeys(Keys.ENTER);
	}
	
	public void enterTitle(String strTitle) {
		txtTitle.clear();
		txtTitle.sendKeys(strTitle);
	}
	
	public void enterDescription(String strDescription) {
		txtDescription.clear();
		txtDescription.sendKeys(strDescription);
	}
	
	public void clickOnbtnAdd() throws Throwable {
		waitForElementToAppear(btnAdd);
		btnAdd.click();
		smallwaitDriver();
	}
	
	public void clickOnbtnCancel() throws Throwable {
		waitForElementToAppear(btnCancel);
		btnCancel.click();
		smallwaitDriver();
	}

	
	// Add achievement
	
	public void addAchievement(String pTeam,String pDate, String pTitle, String pDescription ) throws Throwable {
		waitDriver();
		clickOnbtnCreateAchievement();
		clickandSelectTeam(pTeam);
		smallwaitDriver();
		enterDate(pDate);
		smallwaitDriver();
		enterTitle(pTitle);
		smallwaitDriver();
		enterDescription(pDescription);
		
		clickOnbtnAdd();
}
	public void addAchievementWithoutInputValues() throws Throwable {
		waitDriver();
		clickOnbtnCreateAchievement();
		waitDriver();		
		clickOnbtnAdd();
}

	public String getConfirmationMessage() {
		// TODO Auto-generated method stub
		return null;
	}
		
	public void clickOnDobCalender() {
		waitForElementToAppear(btnDobCalender);
		btnDobCalender.click();
	}
	
	public String getDobCurrentYear() throws Throwable {

		waitForElementToAppear(lblMonthCurrentYear);
		smallwaitDriver();
		return lblMonthCurrentYear.getText();
	}
	
	public void clickOnDobPreviousMonth()  {

		waitForElementToAppear(btnDobPreviousMonth);
		btnDobPreviousMonth.click();	

	}
	public void clickOnDobNextMonth()  {

		waitForElementToAppear(btnDobNextMonth);
		btnDobNextMonth.click();	

	}
	
	public void clickOnDobCurrentYear()  {

		waitForElementToAppear(btnDobCurrentYear);
		btnDobCurrentYear.click();	

	}
	public void selectDateFromDatePicker(String pdate) throws NumberFormatException, Throwable {
		int iYear = TestUtil.getYear(pdate);
		int calYear = Integer.parseInt(getDobCurrentYear());
		int NoOfclicks;
		String searchYearFirstPart = "//div[normalize-space()='", searchYearLastpart = "']";
		String searchDayFirstPart = "//div[@aria-label='Choose ", searchDayLastpart = "']";
		String xPathForYear =  searchYearFirstPart + Integer.toString(iYear) + searchYearLastpart;
		String xPathforDay;
		String month = TestUtil.getMonth(pdate).toString();
		month = month.toLowerCase();
		month = TestUtil.capitalize(month);
		String dayOfWeek = TestUtil.getDay(pdate).toString();
		dayOfWeek = dayOfWeek.toLowerCase();
		dayOfWeek = TestUtil.capitalize(dayOfWeek);
		System.out.println(dayOfWeek);
		int iday = TestUtil.getNumericDay(pdate);
		/*if(iYear < calYear) {
			NoOfclicks = calYear - iYear ;
			NoOfclicks = NoOfclicks - 4 ;
			clickOnDobCurrentYear();
			smallwaitDriver();

			//Click on Down arrow
			for(int i = 1; i < NoOfclicks; i++) {
				clickOnDobPreviousYear();
			}
			*/
			smallwaitDriver();
			try {
				//dynamicElement = pbDriver.findElement(By.xpath(xPathForYear));
				pbDriver.findElement(By.xpath(xPathForYear)).click();
			}catch(NoSuchElementException e) {
				System.out.println(e.getLocalizedMessage());	
			}					
			smallwaitDriver();
			//Assert.assertEquals(getDobCurrentMonth().toUpperCase(), "JANUARY " + Integer.toString(iYear));
			//while ((getDobCurrentMonth().toUpperCase().replace("\\s", "")) != ("JANUARY " + Integer.toString(iYear)).replace("\\s", ""))
			while(!(getDobCurrentMonth().toUpperCase().equalsIgnoreCase(("JANUARY " + Integer.toString(iYear)))))
			{
				clickOnDobPreviousMonth();
			}



			while ( !(getDobCurrentMonth().toUpperCase().equalsIgnoreCase(month +" " + Integer.toString(iYear))))
			{
				clickOnDobNextMonth();
			}


			//Search for Day on the calender
			switch(Integer.toString(iday))
			{

			//Tuesday, June 6th, 2017
			//div[@aria-label='Choose Tuesday, June 6th, 2017']
			case "1": xPathforDay = searchDayFirstPart + dayOfWeek +", " + month + " " + iday + "st, " + Integer.toString(iYear) + searchDayLastpart;

			case "2": xPathforDay = searchDayFirstPart + dayOfWeek +", " + month + " " + iday + "nd, " + Integer.toString(iYear) + searchDayLastpart;

			case "3": xPathforDay = searchDayFirstPart + dayOfWeek +", " + month + " " + iday + "rd, " + Integer.toString(iYear) + searchDayLastpart;

			default : xPathforDay = searchDayFirstPart + dayOfWeek +", " + month + " " + iday + "th, " + Integer.toString(iYear) + searchDayLastpart;

			}

			try {

				pbDriver.findElement(By.xpath(xPathforDay)).click();
			}catch(NoSuchElementException e) {
				System.out.println(e.getLocalizedMessage());	
			}


		//}
	}

	private String getDobCurrentMonth() {
		// TODO Auto-generated method stub
		return null;
	}

	private void clickOnDobPreviousYear() {
		// TODO Auto-generated method stub
		
	}
	
	//22-06-2021
	@FindBy(xpath ="//div[2]/div[3]/div[2]/div[1]/div[1]/div[1]")
    private WebElement lblTeamMandatory;
	
	@FindBy(xpath ="//div[2]/div[3]/div[2]/div[1]/div[1]/div[1]")
    private WebElement lblDateMandatory;
	
	@FindBy(xpath ="//div[2]/div[3]/div[2]/div[1]/div[1]/div[1]")
    private WebElement lblTitleMandatory;
	
	@FindBy(xpath ="//div[2]/div[3]/div[2]/div[1]/div[1]/div[1]")
    private WebElement lblDescMandatory;
	
	public String getTextforTeamField() {
		waitForElementToAppear(lblTeamMandatory);
		return lblTeamMandatory.getText();
	}
	
	public String getTextforDateField() {
		waitForElementToAppear(lblTeamMandatory);
		return lblTeamMandatory.getText();
	}
	
	public String getTextforTitleField() {
		waitForElementToAppear(lblTeamMandatory);
		return lblTeamMandatory.getText();
	}
	
	public String getTextforDescField() {
		waitForElementToAppear(lblTeamMandatory);
		return lblTeamMandatory.getText();
	}

}
