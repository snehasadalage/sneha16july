package neostoxbase;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import neostoxpom.UtilityNew;

public class Listener extends BaseNew implements ITestListener
{
	
	public void onTestFailure(ITestResult result)
	
	{
		String TCname = result.getName();
		Reporter.log("TC "+TCname+ " failed plaese try again",true);
		try {
			UtilityNew.screenshot(driver, TCname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void onTestSuccess(ITestResult result)
	{
	  Reporter.log("TC "+result.getName()+" sucess...", true);
	}
	

	public void onTestSkipped(ITestResult result) 
	{

     Reporter.log("TC "+result.getName()+" skipped please check", true);
	}
	

	
	
}


