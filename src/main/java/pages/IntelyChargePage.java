package pages;


import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageBase;
import utils.TestUtil;

public class IntelyChargePage extends PageBase {

	@FindBy(xpath ="//input[contains(@placeholder,'Last Name')]")
	private WebElement txtSearchLastName;

	@FindBy(xpath ="//input[@placeholder='First Name']")
	private WebElement txtSearchFirstName;

	@FindBy(xpath ="//input[@placeholder='MRN']")
	private WebElement txtSearchMrn;

	@FindBy(xpath ="//input[@placeholder='FIN']")
	private WebElement txtSearchFin;

	@FindBy(xpath ="//input[@placeholder='Date of Birth']")
	private WebElement txtSearchDob;

	@FindBy(xpath ="//button[normalize-space()='Search']")
	private WebElement btnSearch;

	@FindBy(xpath ="//button[normalize-space()='Reset']")
	private WebElement btnReset;

	@FindBy(xpath ="//button[@class='addencounterbtn btn btn-primary']")
	private WebElement btnAddEncounter;

	@FindBy(xpath ="//input[@id='modalmrn']")
	private WebElement mrn;

	@FindBy(xpath ="//input[@id='modallastname']")
	private WebElement txtLastName;

	@FindBy(xpath ="//input[@id='modalfirstname']")
	private WebElement txtFirstName;

	@FindBy(xpath ="//input[@id='modalencounter']")
	private WebElement encounter;

	@FindBy(xpath ="//div[@class='encountermdaltxtbox']//input[1]")  //"//input[@id='modaldob']")
	private WebElement txtDob;

	@FindBy(xpath ="//div[@class='encountermdaltxtbox']//i[@class='fal fa-calendar-alt']")
	private WebElement btnDobCalender;

	@FindBy(xpath ="//select[@id='modalvaccine']")
	private WebElement vaccine;

	@FindBy(xpath ="//select[@id='modaldose']")
	private WebElement dose;

	@FindBy(xpath ="//input[@placeholder='#000']")
	private WebElement lotNo;

	@FindBy(xpath ="//input[@placeholder='mm/dd/yyyy']")
	private WebElement expireDate;

	@FindBy(xpath ="//button[@class='encountermodaladdbtn btn btn-primary']")
	private WebElement btnAdd;

	@FindBy(xpath ="//button[@class='encountermodalcancelbtn btn btn-primary']")
	private WebElement btnCancel;

	@FindBy(xpath ="//div[@class='Toastify__toast-body']")   
	private WebElement confirmationElement;

	@FindBy(xpath ="//img[@alt='LOGO']")
	private WebElement dashboardLink;

	@FindBy(xpath = "//div[@class='modal-dialog modal-dialog-centered']//div[@class='modal-body']")                                   
	private WebElement modalPopUp;

	@FindBy(xpath = "//div[@class='modal-body']//div")        
	private WebElement lblModalErrorMessages;

	@FindBy(xpath ="//button[normalize-space()='Ok']")
	private WebElement modalPopUpOkbutton;

	@FindBy(xpath ="//button[normalize-space()='Continue']")
	private WebElement modalPopUpCotinueButton;

	@FindBy(xpath ="//div[1]/button[normalize-space()='Cancel']")
	private WebElement modalPopUpCancelButton;

	@FindBy(xpath ="//div[@class='react-datepicker__year-read-view']")
	private WebElement lblCurrentYear;

	@FindBy(xpath ="//body//div[@role='dialog']//div//div//div//div//div//div//div//div//span[1]")
	private WebElement btnDobCurrentYear;

	@FindBy(xpath ="//a[@class='react-datepicker__navigation react-datepicker__navigation--years react-datepicker__navigation--years-previous']")
	private WebElement btnDobPreviousYear;

	@FindBy(xpath ="//button[normalize-space()='Previous Month']")
	private WebElement btnDobPreviousMonth;

	@FindBy(xpath ="//button[normalize-space()='Next Month']")
	private WebElement btnDobNextMonth;

	@FindBy(xpath ="//div[@class='react-datepicker__current-month react-datepicker__current-month--hasYearDropdown']")
	private WebElement lblMonth;

	@FindBy(xpath ="//div[@class='card']//tbody/tr/td")
	private List<WebElement>  tblPendingList;

	@FindBy(xpath ="//table[@id='completelisttable']/tbody/tr/td")
	private List<WebElement>  tblCompletedList;

	public IntelyChargePage(WebDriver driver) {
		setWebDriver(driver);
	}

	public void enterLastNameForSearch(String lastname) {
		waitForElementToAppear(txtSearchLastName);
		txtSearchLastName.sendKeys(lastname);
		txtSearchLastName.sendKeys(Keys.TAB);
	}

	public void enterFirstNameForSearch(String firstname) {
		waitForElementToAppear(txtSearchFirstName);
		txtSearchFirstName.sendKeys(firstname);
		txtSearchFirstName.sendKeys(Keys.TAB);
	}

	public void enterMrnNumberForSearch(String mrn) {
		waitForElementToAppear(txtSearchMrn);
		txtSearchMrn.sendKeys(mrn);
		txtSearchMrn.sendKeys(Keys.TAB);
	}

	public void enterFinForSearch(String fin) {
		waitForElementToAppear(txtSearchFin);
		txtSearchFin.sendKeys(fin);
		txtSearchFin.sendKeys(Keys.TAB);
	}

	public void enterDobForSearch(String dob) throws RuntimeException, Throwable {

		waitForElementToAppear(txtSearchDob);
		txtSearchDob.click();
		selectDobFromDatePicker(dob);
		txtSearchDob.sendKeys(Keys.TAB);


	}
	public void clickOnSearchButton() throws Throwable {
		waitForElementToAppear(btnSearch);
		btnSearch.click();
		smallwaitDriver();
	}

	public void clickOnAddButton() throws Throwable {
		waitForElementToClickable(btnAdd);
		btnAdd.click();
	}

	public void clickOnCancelButton() throws Throwable {
		waitForElementToClickable(btnCancel);
		btnCancel.click();
	}

	public String getDobCurrentYear() throws Throwable {

		waitForElementToAppear(lblCurrentYear);
		smallwaitDriver();
		return lblCurrentYear.getText();
	}

	public String getDobCurrentMonth() throws Throwable {

		waitForElementToAppear(lblMonth);
		smallwaitDriver();
		return lblMonth.getText();
	}

	public void clickOnDobCurrentYear()  {

		waitForElementToAppear(btnDobCurrentYear);
		btnDobCurrentYear.click();	

	}

	public void clickOnDobPreviousYear()  {

		waitForElementToAppear(btnDobPreviousYear);
		btnDobPreviousYear.click();	

	}

	public void clickOnDobPreviousMonth()  {

		waitForElementToAppear(btnDobPreviousMonth);
		btnDobPreviousMonth.click();	

	}

	public void clickOnDobNextMonth()  {

		waitForElementToAppear(btnDobNextMonth);
		btnDobNextMonth.click();	

	}

	public void selectDobFromDatePicker(String pdate) throws NumberFormatException, Throwable {
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
		//String strDay = Integer.toString(iday);
		if(iYear < calYear) {
			NoOfclicks = calYear - iYear ;
			NoOfclicks = NoOfclicks - 4 ;
			clickOnDobCurrentYear();
			smallwaitDriver();

			//Click on Down arrow
			for(int i = 1; i < NoOfclicks; i++) {
				clickOnDobPreviousYear();
			}
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
			switch(iday)
			{

			//Tuesday, June 6th, 2017
			//div[@aria-label='Choose Tuesday, June 6th, 2017']
			case 1: xPathforDay = searchDayFirstPart + dayOfWeek +", " + month + " " + iday + "st, " + Integer.toString(iYear) + searchDayLastpart;
					break;
					
			case 2: xPathforDay = searchDayFirstPart + dayOfWeek +", " + month + " " + iday + "nd, " + Integer.toString(iYear) + searchDayLastpart;
					break;
					
			case 3: xPathforDay = searchDayFirstPart + dayOfWeek +", " + month + " " + iday + "rd, " + Integer.toString(iYear) + searchDayLastpart;
					break;
					
			default: xPathforDay = searchDayFirstPart + dayOfWeek +", " + month + " " + iday + "th, " + Integer.toString(iYear) + searchDayLastpart;
					break;
			}

			try {

				pbDriver.findElement(By.xpath(xPathforDay)).click();
			}catch(NoSuchElementException e) {
				System.out.println(e.getLocalizedMessage());	
			}


		}
	}



	public String getConfirmationMessage() throws Throwable {

		waitForElementToAppear(confirmationElement);
		return confirmationElement.getText();
	}

	public void clickOnDobCalender() {
		waitForElementToAppear(btnDobCalender);
		btnDobCalender.click();
	}

	public DashboardPage clickOnDashboarPage() {
		//dashboardLink.click();
		jsExecutorClickOn(dashboardLink);
		waitForPageLoaded();
		return new DashboardPage(pbDriver);
	}

	public String getModalErrorMessages() throws Throwable {

		waitForElementToAppear(lblModalErrorMessages);
		smallwaitDriver();
		return lblModalErrorMessages.getText();
	}

	public String getModalMessage() throws Throwable {
		//waitForElementToAppear(modalPopUp);
		waitDriver();
		return modalPopUp.getText();
	}

	public void clickOnPopUpOkbutton() {
		waitForElementToAppear(modalPopUpOkbutton);
		modalPopUpOkbutton.click();		
	}

	public void clickOnPopUpContinueButton() throws Throwable {
		if(modalPopUpCotinueButton.isDisplayed()) {
			waitForElementToAppear(modalPopUpCotinueButton);
			modalPopUpCotinueButton.click();
			waitForPageLoaded();
			waitDriver();
		}else {
			throw new Error ("Validate add encounter failure error message ");
		}
		
	}

	public void clickOnPopUpCancelbutton() throws Throwable {
		waitForElementToAppear(modalPopUpCancelButton);
		modalPopUpCancelButton.click();	
		waitForPageLoaded();
		waitDriver();
	}

	public void clickOnAddEncounterButton() {
		waitForElementToAppear(btnAddEncounter);
		jsExecutorscrollIntoView(btnAddEncounter);
		btnAddEncounter.click();
	}

	public void enterMrnNumber(String Mrn) {
		waitForElementToAppear(mrn);
		mrn.sendKeys(Mrn);
		mrn.sendKeys(Keys.TAB);
	}

	public void enterLastName(String LastName) {
		waitForElementToAppear(txtLastName);
		jsExecutorClickOn(txtLastName);
		txtLastName.sendKeys(LastName);
	}

	public String getLastName() throws Throwable {
		waitForElementToAppear(txtLastName);
		return txtLastName.getAttribute("value");
	}

	public void enterFirstName(String FirstName) {
		waitForElementToAppear(txtFirstName);
		jsExecutorClickOn(txtFirstName);
		txtFirstName.sendKeys(FirstName);
	}

	public String getFirstName() throws Throwable {
		waitForElementToAppear(txtFirstName);
		return txtFirstName.getAttribute("value");
	}

	public void enterDob(String Dob) throws Throwable {
		clickOnDobCalender();
		smallwaitDriver();
		selectDobFromDatePicker(Dob);
	}

	public String getDob() throws Throwable {
		waitForElementToAppear(txtDob);
		return txtDob.getAttribute("placeholder");
	}

	// Add encounter to complete list
	public void addEncounter(String pMrn,String pFirstName, String pLastName, String pEncounterNo, String pDob, String pVaccine, String pDose, String pLotNo, String pExpiryDate ) throws Throwable {
		waitDriver();
		clickOnAddEncounterButton();
		enterMrnNumber(pMrn);
		smallwaitDriver();
		encounter.sendKeys(pEncounterNo);
		smallwaitDriver();
		if (pVaccine.length()> 0) {
			//waitForElementToClickable(vaccine);
			//TestUtil.selectItem(vaccine, Integer.parseInt(pVaccine));
			enterVaccine(pVaccine);
		}

		smallwaitDriver();
		if(pDose.length() > 0) {
			//waitForElementToAppear(dose);
			//TestUtil.selectItem(dose, Integer.parseInt(pDose));
			enterDose(pDose);
			smallwaitDriver();
			lotNo.sendKeys(pLotNo);
			smallwaitDriver();
			expireDate.sendKeys(pExpiryDate);
			expireDate.sendKeys(Keys.ENTER);
		}


		smallwaitDriver();
		//first name and last name
		if(getLastName().isEmpty()) {
			enterLastName(pLastName);
		}else if(getLastName().equalsIgnoreCase(pLastName)) {
			//Skip the step
		}else {
			throw new Exception("Last name already exist as " + getLastName() + "and Input last name is " + pLastName);
		}

		smallwaitDriver();

		if(getFirstName().isEmpty()) {
			enterFirstName(pFirstName);
		}else if(getFirstName().equalsIgnoreCase(pFirstName)) {
			//Skip the step
		}else {
			throw new Exception("First name already exist as " + getFirstName() + "and Input First name is " + pFirstName );
		}

		smallwaitDriver();

		if(getDob().equalsIgnoreCase("Date of Birth *")) {
			enterDob(pDob);
		}else if(getDob().equalsIgnoreCase(pDob)) {
			//Skip the step
		}else {
			throw new Exception("DOB already exis as " + getDob() + "and Input Dob is " + pDob);
		}
		smallwaitDriver();
		clickOnAddButton();
		waitForPageLoaded();
		smallwaitDriver();
	}


	public void addEncounterWithoutValue() throws Throwable {

		clickOnAddEncounterButton();
		waitDriver();
		clickOnAddButton();
		waitForPageLoaded();
		waitDriver();

	}

	public void addEncounterWithMrnValue(String pMrn) throws Throwable {

		clickOnAddEncounterButton();
		waitDriver();
		enterMrnNumber(pMrn);
		clickOnAddButton();
		waitForPageLoaded();
		waitDriver();

	}

	public void addEncounterWithExistingMrnValue(String pMrn) throws Throwable {

		clickOnAddEncounterButton();
		waitDriver();
		enterMrnNumber(pMrn);
		waitDriver();


	}

	public List<WebElement> validatePendingTableData() throws Throwable{

		waitDriver();
		waitForElementToAppear(tblPendingList.get(0));
		return tblPendingList;

		
	}

	public List<WebElement> validateCompletedTableData() throws Throwable{

		waitDriver();
		waitForElementToAppear(tblCompletedList.get(0));
		return tblCompletedList;
	}

	public void searchBy(String pMrn,String pFirstName, String pLastName, String pFin, String pDob) throws Exception, Throwable {

		waitDriver();
		
		if  (!(pLastName.isEmpty())) {
			enterLastNameForSearch(pLastName);
		}
		if  (!(pFirstName.isEmpty())) {
			enterFirstNameForSearch(pFirstName);
		}
		if  (!(pMrn.isEmpty())) {
			enterMrnNumberForSearch(pMrn);
		}
		if  (!(pFin.isEmpty())) {
			enterFinForSearch(pFin);
		}
		if  (!(pDob.isEmpty())) {
			enterDobForSearch(pDob);
		}
		clickOnSearchButton();
		waitDriver();

	}
	
	//25 May 2021 Adding functionality for edit encounter complete list edit
	
	@FindBy(xpath ="li[normalize-space()='Completed List']")
	private List<WebElement>  columnCompletedList;


	// 20 May 2021
	@FindBy(xpath ="//tbody/tr[1]/td[7]/button[1]")
	private WebElement btnEdit;
	
	//Completed List
	@FindBy(xpath ="//li[normalize-space()='Completed List']") 
   	WebElement tabCompletedList;
    
	@FindBy(xpath ="//li[normalize-space()='Pending List']") 
   	WebElement tabPendingList;
    
	@FindBy(xpath ="//li[normalize-space()='Reports']") 
   	WebElement tabReportList;
    
	@FindBy(xpath ="//div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/select[contains(.,'Pfizer')]")
	private WebElement liEditVaccine;
					
	@FindBy(xpath ="//div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/select[contains(.,'First')]")
	private WebElement liEditDose;

	@FindBy(xpath ="//div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/input[1]")
	private WebElement txtEditLotNo;

	@FindBy(xpath ="//div[4]//div[1]/div[1]/input[1]")
	private WebElement dpEditExpiryDate;

	@FindBy(xpath ="//button[normalize-space()='Save Changes']")
	private WebElement btnSaveChanges;
    
    

	public void clickOnbtnSaveChanges() throws Throwable {
		waitForElementToAppear(btnSaveChanges);
		btnSaveChanges.click();
		smallwaitDriver();
	}
	
	
	 public void clickOnCompletedListTab() throws Throwable{
		   tabCompletedList.click(); 
		   waitDriver();
	}
	 
	 public void clickOnPendingListTab() throws Throwable{
		   tabPendingList.click(); 
		   waitDriver();
	}
	
	/*public void clickOnEditButton() throws Throwable {
		waitForElementToAppear(btnEdit);
		btnEdit.click();
		smallwaitDriver();
	}*/

	 public void enterVaccine(String strVaccine) throws Throwable{
		 //waitForElementToAppear(liEditVaccine);
		 waitForElementToClickable(liEditVaccine);
		 smallwaitDriver();
		 String vaccineName = TestUtil.getSelectItem(liEditVaccine);
		 if(!(vaccineName.equalsIgnoreCase(strVaccine))) {
			 TestUtil.selectItemByVisibleText(liEditVaccine, strVaccine); 
		 }
		 
		 //TestUtil.selectItem(liEditVaccine, Integer.parseInt(strVaccine));
		 smallwaitDriver();
	}
	 
	 public void enterDose(String strDose) throws Throwable{
		 //waitForElementToAppear(liEditDose);
		 smallwaitDriver();
		 String doseNumber = TestUtil.getSelectItem(liEditDose);
		 if(!(doseNumber.equalsIgnoreCase(strDose))) {
			 TestUtil.selectItemByVisibleText(liEditDose, strDose); 
		 }
		 smallwaitDriver();
	}
	 
	 public void enterLotNumber(String strLotNumber) throws Throwable{
		 waitForElementToClickable(txtEditLotNo);
		 txtEditLotNo.clear();
		 txtEditLotNo.sendKeys(strLotNumber);
		 smallwaitDriver();
	}
	 
	 public void enterExpiryDate(String strExpiryDate) throws Throwable{
		 dpEditExpiryDate.sendKeys(strExpiryDate);
		 dpEditExpiryDate.sendKeys(Keys.ENTER);
		 smallwaitDriver();
	}


// 21 May 
	// Edit Add encounter to complete list
		public void editEncounter( String pVaccine, String pDose, String pLotNo, String pExpiryDate ) throws Throwable {
			waitDriver();
			if (pVaccine.length()> 0) {
				enterVaccine(pVaccine);
			}
			smallwaitDriver();
			
			if(pDose.length() > 0) {
				enterDose(pDose);
				smallwaitDriver();
				enterLotNumber(pLotNo);
				smallwaitDriver();
				enterExpiryDate(pExpiryDate);
			}
			clickOnbtnSaveChanges();

			waitDriver();
		}


}
