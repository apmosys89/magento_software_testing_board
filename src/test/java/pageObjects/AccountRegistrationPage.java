package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}

	// Elements
		@FindBy(id = "firstname")
		WebElement txtFirstname;

		@FindBy(id = "lastname")
		WebElement txtLasttname;

		@FindBy(id = "email_address")
		WebElement txtEmail;


		@FindBy(id = "password")
		WebElement txtPassword;

		@FindBy(id = "password-confirmation")
		WebElement txtConfirmPassword;

        @FindBy(xpath = "//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")
		WebElement btnCreateanAccount;
        
		public void setFirstName(String fname) 
		{
			txtFirstname.sendKeys(fname);

		}

		public void setLastName(String lname) {
			txtLasttname.sendKeys(lname);

		}

		public void setEmail(String email) {
			txtEmail.sendKeys(email);

		}

	   public void setPassword(String pwd) {
			txtPassword.sendKeys(pwd);

		}

		public void setConfirmPassword(String pwd) {
			txtConfirmPassword.sendKeys(pwd);

		}

		

		public void clickCreateanAccount() {
			btnCreateanAccount.click();

		}

		
		
		

		
}