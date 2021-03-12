package selenium.Seleniumdemo;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.standard.MediaSize.JIS;

import org.apache.bcel.generic.JSR;
import org.eclipse.jetty.util.ajax.JSON;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import com.thoughtworks.selenium.webdriven.commands.Click;

public class HomePage {
	ChromeDriver driver ;
	@BeforeTest
	public void openwebsite()
	{
		
			System.setProperty("WebDriver.chrome.driver","/Seleniumdemo/Source/chromedriver.exe");
			driver = new ChromeDriver(); 
			driver.navigate().to("https://arielkiell.wixsite.com/interview");	
	}
  @Test(priority = 0)
  public void selectproductfromshop() throws InterruptedException {
	  driver.manage().window().maximize();
	  driver.findElement(By.id("comp-iy4cwgmq1label")).click();//click on shop
	Actions action = new Actions(driver);
	WebElement myElement = driver.findElement(By.xpath("//*[@id=\"TPASection_j4ci4xl4\"]/div/div/div/div/section/div/ul/li[4]/div/a/div[2]/h3"));
	action.moveToElement(myElement).click().build().perform(); //click on the fourth product
	 
  }
  @Test(priority = 1)
  public void addproducttocart() throws InterruptedException{
	  Actions action2 = new Actions(driver);
	  WebElement Radiobutton=  driver.findElement(By.xpath("//*[@id=\"TPAMultiSection_j4ci4xqb\"]/div/div/article/div[1]/div/article/section[2]/div[7]/div[1]/div/div[1]/section/div[2]/div/div/ul/li[2]/label/span"));
	  Thread.sleep(2000);
	  action2.moveToElement(Radiobutton).click().build().perform();//click on color
	  Thread.sleep(3000);

	  Actions action1 = new Actions(driver);
	  for(int i=0;i<2;i++)
	  {
		  WebElement we = driver.findElementByClassName("_11lkb");
		  Thread.sleep(2000);
		  action1.moveToElement(we).click().build().perform();
		  Thread.sleep(200);
	  }
	  driver.findElementByClassName("buttonnext3536768744__content").click();
      }
  @Test(priority = 2)
  public void viewcart() throws InterruptedException
  {
	  Actions action4= new Actions(driver);
	  WebElement we = driver.findElementByXPath("//*[@id=\"widget-view-cart-button\"]");
	  Thread.sleep(2000);
	  action4.moveToElement(we).click().build().perform();
	  Thread.sleep(200);
	   
   
     

  }
  @Test(priority = 3)
  public void checkcart()
  {
	  Actions action4 = new Actions(driver);
	 WebElement webElement = driver.findElementByXPath("//*[@id=\"root\"]/div/div/div/div[1]/div[2]/section/div[2]/div/div/button");
	 driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS); 
	 driver.findElementById("widget-view-cart-button").click();
		driver.findElementByClassName("_36c9s").click();
		
  }
  @Test(priority = 4)
  public void checktotal_price(){
	  WebElement total_price=driver.findElement(By.id("total-sum"));
		String value=total_price.getText();
		String expected="465";
		Assert.assertEquals(value, expected);
  }
  
}
