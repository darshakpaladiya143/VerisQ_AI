package pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VendorPage extends BasePage {

	// Form Step : 1 
	
	private By addVendorBtn =  By.xpath("//a[contains(@class, 'btn-add-list') and contains(text(), 'Add Vendor')]");
	private By inputVendorName = By.xpath("//input[@id='VendorName']");
	private By inputVendorContantNo = By.xpath("//input[@placeholder='Enter Contact Phone']");
	private By inputProductName = By.xpath("//input[@id='ProductName']");
	private By inputDomainName = By.xpath("//input[@id='DomainName']");	
	private By firstCheckboxDatastore = By.xpath("(//div[contains(@class, 'e-checkbox-wrapper')]//span[contains(@class, 'e-frame')])[1]");
	private By inputProductURL = By.xpath("//input[@id='ProductUrl']");
	private By inputProductDescription = By.xpath("//textarea[@id='ProductDescription']");
	private By dropdownSerives = By.xpath("//span[contains(@class,'e-ddl')]//span[contains(@class,'e-ddl-icon')]");
	private By inputContactEmail = By.xpath("//input[@id='ContactEmail']");
	private By inputContactName = By.xpath("//input[@id='ContactName']");
	private By dropDownCountry = By.xpath("//span[contains(@class,'e-ddl')]//span[contains(@class,'e-ddl-icon')]");
	private By desiredCountry = By.xpath("//li[text()='India']");
    private By loader = By.cssSelector(".loader-page-section");
	private By nextBtn = By.xpath("//button[text()='Next']");
	private By saveBtn = By.xpath("//button[text()='Save']");
	
	// Form Step : 2
	
	public VendorPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	
	public void clickAddVendor() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(addVendorBtn));
		driver.findElement(addVendorBtn).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		Thread.sleep(3000);

	}
	
	public void enterVendorName(String vendorName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(inputVendorName));
		driver.findElement(inputVendorName).sendKeys(vendorName);
		System.out.println("New added vendor name is " + vendorName);
	}
	
	
	public void enterVendorContantNo(String vendorNo) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
	    WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(inputVendorContantNo));
	    
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input')); arguments[0].dispatchEvent(new Event('change'));", inputField, vendorNo);
	}
	

	
	public void enterProductName(String productName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(inputProductName));
		driver.findElement(inputProductName).sendKeys(productName);
	}
	
	
	public void enterPrimaryDomainName(String domain) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(inputDomainName));
		driver.findElement(inputDomainName).sendKeys(domain);
		System.out.println(domain);
	}
	
	
	public void dataShareWithVednor() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstCheckboxDatastore));
		driver.findElement(firstCheckboxDatastore).click();
	}
	
	public void enterProductUrl(String productURL) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(inputProductURL));
		driver.findElement(inputProductURL).sendKeys(productURL);
	}
	
	
	public void enterProductDescription(String description) throws InterruptedException {
		driver.findElement(inputProductDescription).sendKeys(description);
		Thread.sleep(2000);

	}
	
	
	public void selectServices() {
		driver.findElement(dropdownSerives).click();
		WebElement optionToSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Software Development Outsourcing')]")));
		optionToSelect.click();
	}
	
	public void enterContactEmail(String contactEmail) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(inputContactEmail));
		driver.findElement(inputContactEmail).sendKeys(contactEmail);
		System.out.print("New added Vendor Contact Email is " + contactEmail);
	}
	
	public void enterContnactName(String contactName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(inputContactName));
		driver.findElement(inputContactName).sendKeys(contactName);
	}
	
	public void selectCountry() {
		driver.findElement(dropDownCountry).click();
		WebElement desiredOption = wait.until(ExpectedConditions.visibilityOfElementLocated(desiredCountry));
		desiredOption.click();
	}
	
	public void nextButton() throws InterruptedException {
		driver.findElement(nextBtn).click();
		Thread.sleep(2000);
	}
	
	
	// Form Step : 2 
		
	/**
	 * Selects a radio button by question number and value
	 * @param questionNumber - E.g., "1.1", "1.2", etc.
	 * @param value - "Yes" or "No"
	 */
	public void selectRadioButton(String questionNumber, String value) {
	    String xpath = String.format("//label[contains(text(), '%s')]/following-sibling::div//input[@type='radio' and @value='%s']",
	        questionNumber, 
	        value
	    );

	    WebElement radio = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	    
	    // Interaction sequence with fallbacks
	    try {
	        radio.click();
	    } catch (Exception e) {
	        ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].checked = true; " +
	            "arguments[0].dispatchEvent(new Event('change'));", 
	            radio
	        );
	    }
	}
	
	
	public void scrollToQuestion(String questionNumber) {
	    String xpath = String.format("//label[contains(text(), '%s')]", questionNumber);
	    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	    
	    ((JavascriptExecutor) driver).executeScript(
	        "arguments[0].scrollIntoView({"
	        + "behavior: 'smooth', "
	        + "block: 'center'"
	        + "});"
	        + "window.scrollBy(0, -100);", // Adjust for headers
	        element
	    );
	}
	
		
	
	public void saveBtn() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(saveBtn));
		driver.findElement(saveBtn).click();
		Thread.sleep(5000);
	}
	
	public void getVendorNameFromTable() {
		
	    WebElement vendorNameElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[contains(@class,'e-templatecell')]//button[contains(@class,'link-title-td')])[1]")));
	    
	    String actualVendorName =  vendorNameElement.getText();
	    System.out.println(actualVendorName);
	    
	    // Assertion 1 
	    
	    
	}
	
	
    public void setVendorPassword(String vendorEmail) throws InterruptedException {
    	
  	  driver.get("https://yopmail.com/en/");

  	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
  	    WebElement inputEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
  	    inputEmail.clear();
  	    inputEmail.sendKeys(vendorEmail);

  	    driver.findElement(By.xpath("//button[@title='Check Inbox @yopmail.com']")).click();

  	    boolean emailArrived = false;
  	    int maxRetries = 15; // Retry for about 75 seconds (15 * 5)
  	    int retryCount = 0;

  	    while (retryCount < maxRetries) {
  	        try {
  	            driver.switchTo().defaultContent();
  	            driver.switchTo().frame("ifinbox");

  	            WebElement emailRow = new WebDriverWait(driver, Duration.ofSeconds(5))
  	                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.m")));
  	            emailRow.click();

  	            emailArrived = true;
  	            break;
  	        } catch (Exception e) {
  	            retryCount++;
  	            System.out.println("Email not yet arrived. Retrying in 5 seconds... Attempt: " + retryCount);
  	            driver.switchTo().defaultContent();
  	            driver.findElement(By.id("refresh")).click();
  	            Thread.sleep(5000);
  	        }
  	    }

  	    if (!emailArrived) {
  	        System.out.println("Email did not arrive in expected time.");
  	        return;
  	    }

  	    driver.switchTo().defaultContent();
  	    driver.switchTo().frame("ifmail");

  	    
  	    String parentWindow = driver.getWindowHandle();
  	    
  	    WebElement resetPasswordLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'here') and contains(@href, 'vendorresponder/setpassword')]")));
  	    resetPasswordLink.click();
  	    
  	    Set<String> allWindows = driver.getWindowHandles();
  	    for (String window : allWindows) {
  	        if (!window.equals(parentWindow)) {
  	            driver.switchTo().window(window);
  	            break;
  	        }
  	    }
	    
  	    
  	      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
          driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Test@1234");
          
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ConfirmPassword']")));
          driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("Test@1234");
          
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Save']")));
          driver.findElement(By.xpath("//button[text()='Save']")).click();
          
          // Assertion 2 
          
          driver.switchTo().window(parentWindow);
          driver.close();
  	
  }
		
}	


