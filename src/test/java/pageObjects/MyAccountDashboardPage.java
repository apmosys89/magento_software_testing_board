package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountDashboardPage extends BasePage
{
  public MyAccountDashboardPage(WebDriver driver)
  {
	  super(driver);
  }
  
  @FindBy(xpath = "//div[@class='panel header']//span[@class='logged-in'][contains(text(),'Welcome')]") // After Account Creation MyAccount Page heading
  private WebElement Msgheading;
  
  @FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
  private WebElement successMessage;
  
  @FindBy(xpath = "//span[@class='base']") // MyAccount Page heading
	WebElement msgHeading;

  
  public boolean IsMyAccountPageDisplayed()
  {
	  try
		{
			return (Msgheading.isDisplayed());
		} 
		catch (Exception e)
		{
			return false;
		}
  }
  
  public String getConfirmationMsg() 
  {
      try 
      {
          return successMessage.getText();
       } 
         catch (Exception e) 
         {
          return null; 
      }
  }

	}
  

