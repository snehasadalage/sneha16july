package neostoxpom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class NeoStoxPasswordPage 
{
	@FindBy(id = "txt_accesspin") private WebElement passWordField;
	@FindBy(xpath = "//a[text()='Submit']") private WebElement submitButton;
	public NeoStoxPasswordPage (WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	public void enterPassword(WebDriver driver,String pass)
	{
	UtilityNew.wait(driver, 3000);
	passWordField.sendKeys(pass);
	Reporter.log("Entering password", true);
	}
	public void clickOnSubmitButton(WebDriver driver)
	{
	UtilityNew.wait(driver, 3000);
	submitButton.click();
	Reporter.log("Clicking on submit Button", true);
	}

}
