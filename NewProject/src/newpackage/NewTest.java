package newpackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest {
static WebDriver driver ;
	
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
			
			//Wait 20s in window
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//Send keys to tab
			driver.findElement(By.name("q")).sendKeys("GMAIL");
			
			//Select one of the appropriate search result
			List<WebElement> list = driver
					.findElements(By.xpath("/html/body/div/div[2]/form/div[2]/div[1]/div[2]/div[2]/ul/li[1]/div/div[2]"));
					
					System.out.println("Total no of suggestions in search box:::====> " + list.size());

					for (int i = 0; i < list.size(); i++) {
						

					System.out.println(list.get(i).getText());

					if (list.get(i).getText().contains("gmail")) {

					list.get(i).click();

					break;

					}
					}
					
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//click the search result and go to relevant website
			driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[9]/div[1]/div[2]/div/div[2]/div[2]/div/div/div[1]/div/div[1]/a/h3")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			//Go to the "https://www.gmail.com website
			String url = "https://accounts.google.com/signin";

            driver.get(url);
            //Enter Username
            driver.findElement(By.id("identifierId")).sendKeys("seleniumtesting1996@gmail.com");
            
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);                 
            //Click Next Button
            driver.findElement(By.id("identifierNext")).click();
            
      
            //Enter password
            WebElement password = driver.findElement(By.xpath("//input[@name='password']"));

            WebDriverWait wait = new WebDriverWait(driver, 20);
            	
            wait.until(ExpectedConditions.elementToBeClickable(password));
            //Click Next Button
            password.sendKeys("seleniumtesting199608");

            driver.findElement(By.id("passwordNext")).click();
            
          
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            //Verify Username tab
            driver.findElement(By.cssSelector(".gb_Ia")).click();		
          
            WebElement element = driver.findElement(By.className("gb_tb"));
            String user=element.getText();
            System.out.println(user);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    		if(user.equals("seleniumtesting1996@gmail.com")){
    			System.out.println("Verify Username");
    		}else {
			System.out.println("Fail");
    			}
    		driver.close();

         

  }
  
  	@BeforeMethod
  	public void beforeMethod() {
	  System.out.println("Starting Test On Firefox Browser");
  	}
	 
	 @AfterMethod
	 public void afterMethod() {
		System.out.println("Finished Test On Firefox Browser");
	 }
}
