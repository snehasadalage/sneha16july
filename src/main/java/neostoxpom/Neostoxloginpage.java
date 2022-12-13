package neostoxpom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class Neostoxloginpage 
{
	
	
	
	
	@FindBy(id="MainContent_signinsignup_txt_mobilenumber") private WebElement 
	mobileNumField;
	@FindBy(xpath = "(//a[text()='Sign In'])[2]") private WebElement signInButton;
	public Neostoxloginpage (WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	public void sendMobileNum(WebDriver driver,String mobNum)
	{
	UtilityNew.wait(driver, 1000);
	mobileNumField.sendKeys(mobNum);
	Reporter.log("Entering mobileNumber",true);
	}
	public void clickOnSignInButton(WebDriver driver)
	{
	UtilityNew.wait(driver, 1000);
	signInButton.click();
	Reporter.log("Clicking on SignIN Button",true);
	}


}
