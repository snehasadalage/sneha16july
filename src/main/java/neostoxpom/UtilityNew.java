package neostoxpom;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class UtilityNew {

	
	
	public static String readdatafreomproperty(String key) throws IOException 
	{
		//cretae object of properties class in java
		
		Properties prop=new Properties();
		
		//create object of file input stream and pass property file path as a parameter
		 FileInputStream myfile=new FileInputStream("C:\\Users\\sourabh\\eclipse-workspace\\NewMavenProject\\NeoStox.properties");
		 prop.load(myfile);
		 String value = prop.getProperty(key);
		 
		 Reporter.log("reading "+key+" from property file" ,true);
		 return value;
		 
	}
	//commonly used method
		//screenshot wait scrolling excel reading
		public static String readDataFromExcel(int row, int cell) throws EncryptedDocumentException, IOException
		{
		File myFile= new File("D:\\selenium notes\\collection\\New folder excel\\Excel Worksheet.xlsx");
		String value = 
		WorkbookFactory.create(myFile).getSheet("Sheet2").getRow(row).getCell(cell).getStringCellValue();
		Reporter.log("reading data from excel",true);
		return value;
		}
		
		
		public static void screenshot(WebDriver driver, String screenShotName) throws 
		IOException
		{
		wait(driver, 500);
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest= new File("D:\\selenium notes\\screenshot"+screenShotName+".png");
		FileHandler.copy(src, dest);
		Reporter.log("taking screenshot", true);
		}
		
		public static void scrollIntoView(WebDriver driver, WebElement element)
		{
		wait(driver, 500);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		Reporter.log("SCrolling into view",true);
		}
		
		
		public static void wait(WebDriver driver, int waitTime)
		{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
		Reporter.log("Waiting for "+waitTime+"ms",true);
		}

}
