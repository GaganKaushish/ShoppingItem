package stepDefination;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.*;


public class hooks {
	

	public static WebDriver driver;
	public static WebDriverWait wait;
	
	
	@Before
	public static void initilization(){
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notification");
		
		 driver = new ChromeDriver(options);
		  
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   wait = new WebDriverWait(driver,20);
		   
		   driver.get("https://demo.midtrans.com/");
		
		
	}
	
	@After
	public void killBrowser(){
		driver.quit();
	}
	
	public static WebDriver getDriver(){
		return driver;
	}
	
	public static WebDriverWait getWait(){
	
		return wait;
	}
}
