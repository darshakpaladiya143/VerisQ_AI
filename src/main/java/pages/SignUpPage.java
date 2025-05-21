package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasePage {

    private WebDriverWait wait;

    private By registerLink = By.linkText("Register For Free");
    private By inputFirstName = By.xpath("//input[@aria-label='textbox' and @placeholder='First Name']");
    private By inputLastName = By.xpath("//input[@aria-label='textbox' and @placeholder='Last Name']");
    private By inputEmailName = By.xpath("//input[@aria-label='textbox' and @placeholder='Email']");
    private By inputPhoneNo = By.xpath("//input[@placeholder='Phone Number']");
    private By inputOrgName = By.xpath("//input[@aria-label='textbox' and @placeholder='Organization Name']");
    private By inputDomainName = By.xpath("//input[@placeholder='Primary Domain' and @aria-label='textbox']");

    private By inputPassword = By.xpath("//input[@type='password' and @placeholder='Password']");
    private By inputConfirmPassword = By.xpath("//input[@type='password' and @placeholder='Confirm Password']");
    private By btnNext = By.xpath("//button[contains(text(),'Next')]");
    
    private By freeTrialBtn = By.xpath("//button[text()='Start Free Trial']");
    private By stripeLabel = By.xpath("//label[span[text()='Stripe']]");
    
    private By proccedToPaymentBtn = By.xpath("//button[text()='Proceed To Payment']");
    
    private By verifyEmailButton = By.xpath("//button[text()=\"I've Verified My Email\"]");

    

    public SignUpPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void registerLink() {
        wait.until(ExpectedConditions.elementToBeClickable(registerLink)).click();
    }

    public void enterFirstName(String fName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputFirstName)).sendKeys(fName);
    }

    public void enterLastName(String lName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputLastName)).sendKeys(lName);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputEmailName)).sendKeys(email);
        System.out.println(email);
    }

    public void enterPhoneNo(String phoneNo) {
        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(inputPhoneNo));
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input'));",
            phoneInput, phoneNo);
    }

    public void enterOrgName(String OrgName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputOrgName)).sendKeys(OrgName);
    }

    public void enterDomainName(String domain) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputDomainName)).sendKeys(domain);
        System.out.println(domain);
    }

    public void selectCompanysize(String sizeText) {
    	
        WebElement dropdownIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.e-input-group-icon.e-ddl-icon")));
        dropdownIcon.click();

  
        String xpath = String.format("//li[contains(text(),'%s') and @class='e-list-item']", sizeText);
        WebElement desiredOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        desiredOption.click();
        
    }
    
    
    public void selectVendorDropdownOption(String optionText) {

 
        WebElement dropdownIcon = wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("input[placeholder='Select number of third party vendors'] + span.e-input-group-icon")));
        dropdownIcon.click();

  
        String xpath = String.format("//li[@class='e-list-item' and normalize-space(text())='%s']", optionText);
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        option.click();
    }
    

    public void enterPassword(String pwd) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPassword)).sendKeys(pwd);
    }

    public void enterConfirmPassword(String pwd) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputConfirmPassword)).sendKeys(pwd);
    }

    public void clickNext1() throws InterruptedException {

        WebElement nextButton1 = driver.findElement(btnNext);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton1);
        Thread.sleep(500); // 500 milliseconds pause, adjust as necessary
        nextButton1.click();
        
    }
    
    public void clickFreeTrial() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(freeTrialBtn));
    	driver.findElement(freeTrialBtn).click();
    }
    
    public void clickStrip() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(stripeLabel));
    	driver.findElement(stripeLabel).click();
    }
    
    public void cardDetails() throws InterruptedException {
  
        WebElement cardFrame = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#card-element iframe")));
        
        driver.switchTo().frame(cardFrame);


        WebElement cardInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='cardnumber']")));

   
        cardInput.sendKeys("4242 4242 4242 4242");


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='exp-date']")));
        WebElement expInput = driver.findElement(By.cssSelector("input[name='exp-date']"));
        expInput.sendKeys("12/34");
        
      
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='cvc']")));
        WebElement cvcInput = driver.findElement(By.cssSelector("input[name='cvc']"));
        cvcInput.sendKeys("123");
        
       
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='postal']")));
        WebElement ZipInput = driver.findElement(By.cssSelector("input[name='postal']"));
        ZipInput.sendKeys("12345");


        driver.switchTo().defaultContent();
    } 
    
    public void clickProccedToPayment() throws InterruptedException {
    
      wait.until(ExpectedConditions.visibilityOfElementLocated(proccedToPaymentBtn));
      driver.findElement(proccedToPaymentBtn).click();
      Thread.sleep(3000);
    
    }
    
    public void clickVerifyEmail() {
      wait.until(ExpectedConditions.visibilityOfElementLocated(verifyEmailButton));
      driver.findElement(verifyEmailButton).click();
    }
    
    
    public void verifyEmailAndLogin(String email) throws InterruptedException {
    	
    	  driver.get("https://yopmail.com/en/");

    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	    WebElement inputEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
    	    inputEmail.clear();
    	    inputEmail.sendKeys(email);

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
    	    
    	    WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Login') and contains(@href, 'EmailConfirmationToken')]")));
    	    loginLink.click();
    	    
    	    Set<String> allWindows = driver.getWindowHandles();
    	    for (String window : allWindows) {
    	        if (!window.equals(parentWindow)) {
    	            driver.switchTo().window(window);
    	            break;
    	        }
    	    }

    	    new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("Login")); // Adjust as per expected title
    	    
    	    driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(email);
    	    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Test@1234");
    	    driver.findElement(By.xpath("//button[normalize-space()='Login']")).click(); // Update locator
    	    
    	    
            System.out.println("New created user verfiy and login successfully");
            
            driver.switchTo().window(parentWindow);
            driver.close();
    	
    }
    
    
}