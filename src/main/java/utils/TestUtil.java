package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;


public class TestUtil extends TestBase{
	static String rootdir = System.getProperty("user.dir");
	public static String brow;
	//public static String reportFolderPath = prop.getProperty("reportingFolderName");
	public static String reportFolderPath = rootdir + "\\target\\"  + prop.getProperty("reportingFolderName") + "\\";

	public static String getBrowserVersion() throws IOException {
		
		try {
			Runtime rt = Runtime.getRuntime();
			try {
				//rootdir = System.getProperty("user.dir");
				rt.exec("cmd  /K \"dir /B/AD \"C:/Program Files/Google/Chrome/Application/\"|findstr /R /C:\"^[0-9].*\\..*[0-9]$\" > "+ rootdir +"\\version.txt\"");
				brow = getVersion();
			} 
			catch (IOException e) {
				//rootdir = System.getProperty("user.dir");
				rt.exec("cmd  /K \"dir /B/AD \"C:/Program Files/Google/Chrome/Application/\"|findstr /R /C:\"^[0-9].*\\..*[0-9]$\" > "+ rootdir +"\\version.txt\"");
				brow = getVersion();
				e.printStackTrace();
			}
			return brow.substring(0, brow.length() - 4);
		}
		catch(Exception e){
			brow = e.toString();
			return brow;
		}
	}

//--------------------Return Stored value of Chrome Browser Version----------------------------
	public static String getVersion() {
		 String data = "";
		try {
		  File myObj = new File(rootdir+"/version.txt");
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	         data = myReader.nextLine();
	         break;
	      }
	      myReader.close();
	      return data;
	    } catch (FileNotFoundException e) {
	    	System.out.println("An error occurred.");
	    	e.printStackTrace();
	    }
		return null;
	}
	
	public static String getCurrentDate()
	{
		Date date = new Date();  
	    SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");  
	    String strDate = dateformat.format(date); 
	    return strDate;
	}
	
	public static String getTimeStamp()
	{
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss");
		String time = dateFormat.format(now);
		return time.replace("-", "");
	}
	
	
	
	//---------------------------------------Select Item--------------------------------------------
	public static void selectItem(WebElement element,int index) {
		Select list = new Select(element);
		list.selectByIndex(index);
	}
	
	public static void selectItemByVisibleText(WebElement element,String visibleText) {
		Select list = new Select(element);
		list.selectByVisibleText(visibleText);
	}
	
	public static String getSelectItem(WebElement element) {
		
		Select list = new Select(element);
		String selectedValue = list.getFirstSelectedOption().getText();
		return selectedValue;
	}
	
	//------------------------get date by format---------------------------------------------------
	public static LocalDate getDateFormated(String dateFormat)
	{
		LocalDate currentDate  = LocalDate.parse(dateFormat);  
	    return currentDate;
	}
	
	
	public static int getYear(String date) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
		LocalDate currentDate  = LocalDate.parse(date, dateFormat );
	
	     // Get year from date
	     int year = currentDate.getYear();
	
	     return year;
	     
	}
	
	public static int getNumericDay(String date) {

		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
		LocalDate currentDate  = LocalDate.parse(date, dateFormat );	
		
	     // Get day from date
	     int day = currentDate.getDayOfMonth();

	     return day;
	     
	}
	
	public static DayOfWeek getDay(String date) {

		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
		LocalDate currentDate  = LocalDate.parse(date, dateFormat );
		
	     // Get day from date
	     DayOfWeek day = currentDate.getDayOfWeek();

	     return day;
	     
	}
	
	public static Month getMonth(String date) {

		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
		LocalDate currentDate  = LocalDate.parse(date, dateFormat );
		
	     // Get month from date
	     Month month = currentDate.getMonth();
	
	     return month;
	     
	}
	
	
	public static String capitalize(String str)	{
		
	    if(str == null) return str;
	    return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
	
	
	
	
	
	
	
	
	
	//------------------------get date by format---------------------------------------------------
		public static String addDayToDate(String dateFormat ,int addToDate)
		{
		    Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, addToDate);
		    SimpleDateFormat dateformat = new SimpleDateFormat(dateFormat);  
		    String strDate = dateformat.format( cal.getTime()); 
		    return strDate;
		}
	
	public static void mouseHover(WebElement element) throws Throwable {
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(element).click().build().perform();
	}
	
	public static double getRandomIntegerBetweenRange(double min, double max){
	    double x = (int)(Math.random()*((max-min)+1))+min;
	    return x;
	}
	
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
}
	
