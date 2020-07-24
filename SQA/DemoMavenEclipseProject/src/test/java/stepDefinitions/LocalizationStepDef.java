package stepDefinitions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LocalizationStepDef {
	WebDriver driver;

	@Given("^User on the Welcome Page of \"([^\"]*)\"$")
	public void user_on_the_Welcome_Page_of(String arg1) throws Throwable {
//		System.out.println("On Welcome page");
		System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		driver = new ChromeDriver();
	    driver.get(arg1);
	    driver.manage().window().maximize();
	}

	@When("^User click on \"([^\"]*)\"$")
	public void user_click_on(String arg1) throws Throwable {
	//	System.out.println("Click on Sinhala");
		driver.findElement(By.xpath("//*[@id=\"body-container\"]/div/div[1]/div[3]/div/ul/li[1]/a")).click();
	}

	@Then("^User should navigate to home page successfully with correct \"([^\"]*)\"$")
	public void user_should_navigate_to_home_page_successfully_with_correct(String lang) throws Throwable {
		String actual=driver.findElement(By.xpath("//*[@id=\"body-container\"]/div/div[1]/div[3]/div/ul/li[1]/a]")).getAttribute("href");
		String before ="/wrapper/wordpress/CMSWrapper/content/contactus?gen_from=abt&appcode=cp&lang=";
		String expected=before+lang.substring(0,2);
		AssertJUnit.assertEquals(actual.substring((18)), expected);
//			System.out.println("");
	}
	
	@Then("^Should close the browser$")
	public void should_close_the_browser() throws Throwable{
		driver.quit();
	}
}
