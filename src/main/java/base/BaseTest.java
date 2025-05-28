package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	protected WebDriver driver;
	protected WebDriverWait wait;
	
	@BeforeMethod
	public void setUp() {
		
        WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.setExperimentalOption("prefs", new java.util.HashMap<String, Object>());

        driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://uat.verisq.ai/login");
		wait = new WebDriverWait(driver, Duration.ofSeconds(60)); 
	}
	
	
	
	@AfterMethod
//    public void tearDown() {
//	if(driver!=null) {
//		driver.quit();
//	}
//    }
	
	
	public WebDriver getDriver() {
      return driver;
	   }
	
	
}