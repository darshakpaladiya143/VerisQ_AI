package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	protected WebDriver driver;
	
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
		driver.get("http://clientapp.narola.online:1196/login");
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
