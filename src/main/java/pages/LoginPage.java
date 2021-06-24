package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;
import utils.TestUtil;

public class LoginPage extends PageBase {
	
	@FindBy(xpath ="//span[@class='MuiButton-label']")
    private WebElement btnsignin;
	
	@FindBy(xpath = "//input[@id='password']")
    private WebElement txtpassword;
	
	@FindBy(xpath = "//input[@id='email']")
    private WebElement txtuserName;

	@FindBy(xpath = "//div[@role='alert']//div[1]")        
	private WebElement lblModalMessages;

	
	public LoginPage(WebDriver driver) {
		setWebDriver(driver);
		
	}
	
	public void enterUserName(String strUsername) throws Throwable {
		
		TestUtil.mouseHover(txtuserName);
		txtuserName.sendKeys(strUsername);
	}
	
	public void enterPassword(String strPassword) {
		txtpassword.sendKeys(strPassword);
	}
	
	public void clickOnbtnsignin() {
		btnsignin.click();
	}
	
	
	public HomePage intelyEDLogin(String userName, String password) throws Throwable {
		
		waitForPageLoaded();
		waitForElementToAppear(txtuserName);
		enterUserName(userName);
		enterPassword(password);
		clickOnbtnsignin();
		waitDriver();
		return new HomePage(pbDriver); 

	}
	
	public String loginValidation() {
		return pbDriver.getTitle();
	}

	public String getConfirmationMessage() {
		waitForElementToAppear(lblModalMessages);
		return lblModalMessages.getText();
	}
	
	
}

