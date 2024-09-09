package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Elements
	@FindBy(xpath = "//div[@class='panel header']//a[text()='Create an Account']")
	WebElement linkCreateAccount;

	
	
	@FindBy(xpath="//div[@class='panel header']//a[contains(text(),'Sign In')]")
	WebElement linkSignin;
	
	
		
	// Action Methods
	public void createanAccount() //For Create Account Link
	{
		linkCreateAccount.click();
	}

    public void clickSignin()  //For click sign in Link
	{
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));  // 20 seconds timeout
        wait.until(ExpectedConditions.elementToBeClickable(linkSignin));
		linkSignin.click(); 
	}

	

	
	
	
}
