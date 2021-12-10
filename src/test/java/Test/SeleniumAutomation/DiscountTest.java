package Test.SeleniumAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DiscountTest {
	public WebDriver driver;
	public HomePage homePage;
  @Test
  public void f() {
	  homePage=new HomePage(driver);
	  homePage.userSignIn();
	  homePage.searchItem("mobiles under 10000");
	  
	  List<WebElement> mobileList=driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//h2/a/span"));
	  List<WebElement> discountList=driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//div/a/following-sibling::span[2]"));
	  
	  for(int i=0;i<mobileList.size();i++)
	  {
		  String mobileName=mobileList.get(i).getText();
		  System.out.println("mobile:"+mobileName);
		  String discount=discountList.get(i).getText();
		  
		  String formattedText=discount.split("\\(")[1].replace("%)","");
		 // String formattedText=discount.split("\\(")[0].replaceAll("^[a-zA-Z]", "");
		  //for(String str:formattedText)
		  System.out.println("discount:"+formattedText);
	  }
	
	  
	
  }
  @BeforeSuite
  public void beforeSuite() {
	  
	  System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_96\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.amazon.in/");
	  driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
  }

  @AfterSuite
  public void afterSuite() {
	 driver.quit();
  }

}
