package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExtentReport;
import utils.TestUtil;
import utils.WebEventListener;

public class TestBase {
	protected static WebDriver driver;
	protected static PageBase basePage;
	public static Properties prop;
	public boolean checkBlnMethod;
	public boolean testStatus;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/"
					+ "config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@BeforeSuite
	public void extentFileCreation() throws IOException {
		ExtentReport.createReportFile(getClass().getSimpleName());
		
		
		
	}
	
	@BeforeClass
    public void launchApplication(ITestContext context) throws Throwable {
		
		ExtentReport.updateReportName(getClass().getSimpleName());
		/*ExcelLibraries.createExcel(getClass().getSimpleName());
		
		testStatus = ExcelLibraries.getTestStatus(getClass().getSimpleName());
		if(!testStatus) {
			ExtentReport.skipReport();
			throw new SkipException(getClass().getSimpleName()+" has been skipped");
		}
		*/
		setChromeDriverProperty();
		driver.get(prop.getProperty("AppUrl"));
	}

	
	public void reporting(String desc,String exp,String actual,String status) throws Throwable {
		
		if(status.equalsIgnoreCase("PASS")) {
			ExtentReport.Report("Pass", desc, actual, exp);
		}else {
			ExtentReport.Report("Fail", desc, actual, exp);
		}
	}
	
	
	@AfterClass
    public static void closeBrowser() throws Throwable {
        driver.close();
        driver.quit();
        driver = null;
    }
    
    private static void setChromeDriverProperty() throws Throwable{
    	String BrowserVersion = TestUtil.getBrowserVersion();	
		System.out.println("Browser Version- "+BrowserVersion);
		WebDriverManager.chromedriver().browserVersion(BrowserVersion).setup();
		driver = new ChromeDriver(); 
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
	
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
	}
}
