package neostoxbase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import neostoxpom.UtilityNew;

public class BaseNew 
{
	protected static WebDriver driver;
	public void launchBrowser() throws InterruptedException, IOException
	{
	System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(UtilityNew.readdatafreomproperty("url"));
	Reporter.log("Launching browser", true);
	Thread.sleep(1000);
	}


}
