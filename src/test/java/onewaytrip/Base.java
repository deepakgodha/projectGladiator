package onewaytrip;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Base {
	public WebDriver driver;
	
	@Parameters("browser")
	 @BeforeTest 
	  public void beforeTest(String browser) {
		if(browser.equals("chrome")) {
		  System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
		  driver=new ChromeDriver(new ChromeOptions().addArguments("--disable-notifications"));
		  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		 }
		 else if(browser.equals("firefox"))
		 {
			 System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/geckodriver.exe");
			 driver=new FirefoxDriver();
			  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			  driver.manage().window().maximize();
			  driver.manage().deleteAllCookies();
		 }
		 else
		 {
			 System.out.println("Invalid browser");
		 }
	 }

	  @AfterTest
	  public void afterTest()throws Exception {
		  Thread.sleep(2000);
		  driver.quit();
	  }
}
