import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTestNGFile {
  @Test
  public void f() {
	//Create a new instance of the Firefox driver
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Chamodi\\Desktop\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			 driver = new FirefoxDriver();
			
			
			//It implicit 10 second waits before throwing exception on the page
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			//Maximize the window
			driver.manage().window().maximize();
			
			//Open Google Website
			driver.navigate().to("http://www.google.com");
			
		
			driver.findElement(By.name("q")).sendKeys("GMAIL");
			
			//driver.findElements(By.xpath(""))
			
		
			List<WebElement> list = driver
					.findElements(By.xpath("/html/body/div/div[2]/form/div[2]/div[1]/div[2]/div[2]/ul/li[2]"));
					//.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbct'] "));

					System.out.println("Total no of suggestions in search box:::====> " + list.size());

					for (int i = 0; i < list.size(); i++) {
						

					System.out.println(list.get(i).getText());

					if (list.get(i).getText().contains("gmail")) {

					list.get(i).click();

					break;

					}
					}
					
			driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[9]/div[1]/div[2]/div/div[2]/div[2]/div/div/div[1]/div/div/div[1]/a")).click();
			
			//driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			
			
				//finding the web element using name locator
			//WebElement elem = driver.findElement(By.name("q"));
			//Serach for the GMAIL in google website
			//elem.sendKeys(new String[]{"GMAIL"});
			//elem.submit();
			
			
			//Enter UserName
			driver.findElement(By.id("identifierId")).sendKeys("mailtochamodij@gmail.com");
			driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/span/span")).click();
			//driver.findElement(By.xpath("//*[@id=\'identifierNext\']/content/span")).click();;
			
			//Enter Password
			driver.findElement(By.name("password")).sendKeys("test");
//			driver.findElement(By.xpath("//*[@id=\'passwordNext\']/content/span")).click();;
	//
//			
//			System.out.println("Execution is completed");
		}
		
		@BeforeMethod
		 public void beforeMethod() {
			System.out.println("Starting Test On Firefox Browser");
		 }
		 
		 @AfterMethod
		 public void afterMethod() {
			 driver.close();
			 driver.quit();
			 System.out.println("Finished Test On Firefox Browser");
		 }
  
}
