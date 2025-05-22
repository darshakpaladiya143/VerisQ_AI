package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
	
	private By inputEamil = By.xpath("//input[@id='userName']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By btnLogin = By.xpath("//button[normalize-space()='Login']");  
    
    public LoginPage (WebDriver driver , WebDriverWait wait) {
	   super(driver, wait);
	}
	
	
	public void loginEmail(String email) throws InterruptedException {
	   wait.until(ExpectedConditions.visibilityOfElementLocated(inputEamil));
	   driver.findElement(inputEamil).sendKeys(email);	
	   Thread.sleep(2000);
	}
	
	
	public void loginPassword(String password) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(inputPassword));
		driver.findElement(inputPassword).sendKeys(password);
		Thread.sleep(2000);
	}
	
	public void submitLogin() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(btnLogin));
		driver.findElement(btnLogin).click();
		Thread.sleep(2000);
	}
	
		
}
