package stepDefinitions;

import java.time.Duration;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.MyAccountDashboardPage;


public class AccountcreationSteps {

	 WebDriver driver;
     HomePage hp;
     AccountRegistrationPage regpage;
     MyAccountDashboardPage dashboardPage;
     
	@Given("the user navigate to account creation page")
	public void user_navigate_to_account_creation_page() 
	{
	
		hp=new HomePage(BaseClass.getDriver());
    	hp.createanAccount();
                   
	}

	@When("the user enters personal information with")
	public void  user_enters_personal_information_with(DataTable dataTable) 
	{
		
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
	    
		regpage=new AccountRegistrationPage(BaseClass.getDriver());
		regpage.setFirstName(dataMap.get("firstName"));
		regpage.setLastName(dataMap.get("lastName"));
		regpage.setEmail(BaseClass.randomAlpha()+"@gmail.com");
	
		regpage.setPassword(dataMap.get("password"));
		regpage.setConfirmPassword(dataMap.get("password"));
		
	}
	@When("the user clicks on the Create an Account button")
	public void user_clicks_on_the_Create_an_Account_button() throws InterruptedException {
		regpage.clickCreateanAccount(); 
		
		WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("/customer/account/"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='logged-in'][contains(text(),'Welcome')]")));
	}
	@Then("the user should see the account dashboard ")
	public void user_should_see_the_account_dashboard()
	{
		
	    dashboardPage = new MyAccountDashboardPage(BaseClass.getDriver());
        boolean IsDashboardVisible = dashboardPage.IsMyAccountPageDisplayed();
	    Assert.assertTrue("The account dashboard is not displayed.", IsDashboardVisible);
	}
    
	@And("a success message should be displayed ")
	public void success_message_should_be_displayed() 
	{
		
     	dashboardPage =new MyAccountDashboardPage(BaseClass.getDriver());
		String confirmationMessage = dashboardPage.getConfirmationMsg();
	    Assert.assertEquals("The success message is incorrect or not displayed.","Thank you for registering with Main Website Store.",confirmationMessage);
	}
 }
