package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class IntelyArcPage extends PageBase {
	
	@FindBy(xpath ="//input[@placeholder='First Name']")
    private WebElement firstName;
	
	@FindBy(xpath ="//button[normalize-space()='Search']")
    private WebElement searchBtn;

	public  IntelyArcPage(WebDriver driver) {
		setWebDriver(driver);
	}
	
	public void searchArc() {
		waitForElementToAppear(firstName);
		firstName.sendKeys("Test");
		searchBtn.click();
		
	}

}
