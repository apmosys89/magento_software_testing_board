package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, chandan kumar!']") // MyAccount Page heading
	WebElement msgHeading;
	
	 @FindBy(xpath = "//div[@class='panel header']//button[@type='button']")
	 WebElement button;	
		
	  @FindBy(xpath = " //div[@aria-hidden='false']//a[normalize-space()='Sign Out']")
	WebElement signOut;
	

	public boolean isMyAccountPageExists()   // MyAccount Page heading display status
	{
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}
   
	public void clickbutton()
	{
		button.click();
	}
	public void clicksignout() 
	{
		signOut.click();

	}
	
}
