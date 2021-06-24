package base;





import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageBase {
	protected static WebDriver pbDriver;
	private WebDriverWait wait;
	private static final int iTimeOut = 10; //seconds
	private  static final int iPolling = 50; //milliseconds
	
	    
	public void setWebDriver(WebDriver driver) {
		PageBase.pbDriver = driver;
		wait = new WebDriverWait(pbDriver, iTimeOut, iPolling);
	    PageFactory.initElements(new AjaxElementLocatorFactory(PageBase.pbDriver, iTimeOut), this);
	}
	
	protected void waitForElementToAppear(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element)); // visibilityOfAllElements(element)
    }
	
	protected void waitForElementsToAppear(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
	
	public void waitDriver() throws Throwable {
		
		pbDriver.manage().timeouts().implicitlyWait(iPolling,TimeUnit.SECONDS);
		Thread.sleep(2000);
	}
    public void smallwaitDriver() throws Throwable {
		
		pbDriver.manage().timeouts().implicitlyWait(iTimeOut,TimeUnit.SECONDS);
		Thread.sleep(500);
	}
	
	 public void jsExecutorscrollIntoView(WebElement element){
	        ((JavascriptExecutor) pbDriver).executeScript("arguments[0].scrollIntoView();",element);
	    }
	 
	 public void jsExecutorClickOn(WebElement element){
	        ((JavascriptExecutor) pbDriver).executeScript("arguments[0].click();",element);
	    }
	
	public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver pbDriver) {
                        return ((JavascriptExecutor) pbDriver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(pbDriver, iTimeOut);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
	
	public void waitForElementToClickable(WebElement element) throws Throwable{
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	

	
}
