package neostoxtest;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import neostoxbase.BaseNew;
import neostoxpom.NeoStoxHomePage;
import neostoxpom.NeoStoxPasswordPage;
import neostoxpom.Neostoxloginpage;
import neostoxpom.Neostoxsignuppage;
import neostoxpom.UtilityNew;



@Listeners(neostoxbase.Listener.class)
public class ValidateNeoStoxAccBalance2 extends BaseNew
{
	Neostoxloginpage login;
	NeoStoxPasswordPage password;
	NeoStoxHomePage home;
	Neostoxsignuppage signIn;
	
	
	@BeforeClass
	public void launchNeoStox() throws InterruptedException, IOException
	{
	launchBrowser();//form base class
	login= new Neostoxloginpage(driver);
	password= new NeoStoxPasswordPage(driver);
	home= new NeoStoxHomePage(driver);
	signIn= new Neostoxsignuppage(driver);
	}
	
	
	@BeforeMethod
	public void logintoNeoStox() throws EncryptedDocumentException, IOException, 
	InterruptedException
	{
	signIn.clickOnSignInButton(driver);
	Thread.sleep(1000);
	login.sendMobileNum(driver, UtilityNew.readdatafreomproperty("mobileno"));
	login.clickOnSignInButton(driver);
	UtilityNew.wait(driver, 1000);
	password.enterPassword(driver, UtilityNew.readdatafreomproperty("password"));
	Thread.sleep(1000);
	password.clickOnSubmitButton(driver);
	Thread.sleep(1000);
	home.handlePopUp(driver);
	}
	
	
	@Test
	 public void validateAccBalance() throws EncryptedDocumentException, IOException
	{
	Assert.assertNotNull(home.getAccBalance(driver),"TC failed Unable to fetch account Balance");
	Assert.fail();
	}
	
	@Test(priority = -1)
	 public void validateUserID() throws EncryptedDocumentException, IOException
	{
	Assert.assertEquals(home.getActualUserName(driver), 
	UtilityNew.readdatafreomproperty("username"),"TC is failed Actual and expected User Name are not matching");
	}
	
	
	@AfterMethod
	public void logOutFromNeoStox()
	{
	home.logOut(driver);
	}
	
	
	@AfterClass
	public void closeBrowser()
	{
	Reporter.log("closing browser", true);
	driver.close();

}
}
