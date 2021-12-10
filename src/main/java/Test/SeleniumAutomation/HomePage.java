package Test.SeleniumAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	Actions action;
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy(id="nav-search-submit-button")
	WebElement searchButton;
	
	@FindBy(id="ap_email")
	WebElement username;
	
	
	@FindBy(id="continue")
	WebElement continueButton;
	
	@FindBy(id="ap_password")
	WebElement password;
	
	@FindBy(id="signInSubmit")
	WebElement signIn;
	
	@FindBy(css="span#nav-link-accountList-nav-line-1")
	WebElement  accountButton;
	
	@FindBy(css="div#nav-flyout-ya-signin > a > span")
	WebElement signInButton;
	
	
	
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		action=new Actions(driver);
		
	}
	
	public void userSignIn()
	{
		action.moveToElement(accountButton).build().perform();
		signInButton.click();
		username.sendKeys("priyanka.naikare@gmail.com");
		continueButton.click();
		password.sendKeys("Pr!0212$hree");
		signIn.click();
		
	}
	
	public void searchItem(String item)
	{
		searchBox.sendKeys("mobiles under 10000+");
		searchButton.click();
		
		
	}
	
	
	

}
