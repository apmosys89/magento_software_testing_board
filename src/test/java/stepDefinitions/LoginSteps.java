package stepDefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataReader;

public class LoginSteps {
     WebDriver driver;
     HomePage hp;
     LoginPage lp;
     MyAccountPage macc;
  
     List<HashMap<String, String>> datamap; //Data driven
     
   
    @Given("the user navigates to login page")
    public void user_navigate_to_login_page() 
    {
    	
    	BaseClass.getLogger().info("Goto my account-->Click on Login.. ");
    	
    	hp=new HomePage(BaseClass.getDriver());
    }
    	
    @When("user click to sign in link")
	public void user_click_to_sign_in_link() 
	{
		hp.clickSignin();
	}	

    @When("user enters email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String email, String pwd) 
    {
    	hp.clickSignin();
    	BaseClass.getLogger().info("Entering email and password.. ");
    	
    	lp=new LoginPage(BaseClass.getDriver());
       	lp.setEmail(email);
        lp.setPassword(pwd);
        }

    @When("the user clicks on the Login button")
    public void click_on_login_button() {
        lp.clickLogin();
        BaseClass.getLogger().info("clicked on login button...");
    	
        
    }


    @Then("the user should be redirected to the MyAccount Page")
    public void user_navigates_to_my_account_page() {
    	macc=new MyAccountPage(BaseClass.getDriver());
		boolean targetpage=macc.isMyAccountPageExists();
				
		Assert.assertEquals(targetpage, true);
        
       }
    //*******   Data Driven test **************
    @Then("the user should be redirected to the MyAccount Page by passing email and password with excel row {string}")
    public void check_user_navigates_to_my_account_page_by_passing_email_and_password_with_excel_data(String rows)
    {
        try {
			datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\Magento_LoginData.xlsx", "Sheet1");
		} 
        catch (IOException e) 
        {
			e.printStackTrace();
		}
    
        int index=Integer.parseInt(rows)-1;
        String email= datamap.get(index).get("username");
        String pwd= datamap.get(index).get("password");
        String exp_res= datamap.get(index).get("res");

        lp=new LoginPage(BaseClass.getDriver());
        lp.setEmail(email);
        lp.setPassword(pwd);

        lp.clickLogin();
        macc=new MyAccountPage(BaseClass.getDriver());
        try
        {
            boolean targetpage=macc.isMyAccountPageExists();
            System.out.println("target page: "+ targetpage);
            if(exp_res.equalsIgnoreCase("Valid"))
            {
                if(targetpage==true)
                {
                    MyAccountPage myaccpage=new MyAccountPage(BaseClass.getDriver());
                    myaccpage.clickbutton();
                    myaccpage.clicksignout();
                    Assert.assertTrue(true);
                }
                else
                {
                    Assert.assertTrue(false);
                }
            }

            if(exp_res.equalsIgnoreCase("Invalid"))
            {
                if(targetpage==true)
                {
                	macc.clickbutton();
                    macc.clicksignout();
                    Assert.assertTrue(false);
                }
                else
                {
                    Assert.assertTrue(true);
                }
            }


        }
        catch(Exception e)
        {

            Assert.assertTrue(false);
        }
      }
 
    
      }
 

