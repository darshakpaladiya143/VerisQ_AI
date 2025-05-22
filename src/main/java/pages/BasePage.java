package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
		
	// Horizontal Nav bar 
	
	private By profileDiv = By.xpath("//div[@class='user cursor-pointer']");
    private By userNameLocater = By.cssSelector("div.u-name.ms-2");
    private By loader = By.cssSelector(".loader-page-section");
    private By toggleBtn = By.cssSelector("button.btn-toggle");
    private By thirdPartyMenu = By.xpath("//span[@class='nav-menu-title' and text()='Third-Party Risk Management']");
	
	public BasePage(WebDriver driver , WebDriverWait wait) {
		this.driver= driver;
		this.wait = wait;
	}	
	
	
	public void getLoggedInUserName() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(userNameLocater));
		WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameLocater));
		String userName = usernameElement.getText();
		System.out.println(userName);
	}
	
	public void sideMenuWrap() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		WebElement toggleButton = wait.until(ExpectedConditions.elementToBeClickable(toggleBtn));
		toggleButton.click();

	}
	
	public void clickThirdPartyRisk() {
	    WebElement thirdPartyButton = wait.until(ExpectedConditions.visibilityOfElementLocated(thirdPartyMenu));
	    thirdPartyButton.click();   
	}
	
	
	public void clickProfile() {
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(profileDiv));
		driver.findElement(profileDiv).click();
	}
	
	
	
}