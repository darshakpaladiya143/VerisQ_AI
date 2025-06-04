package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssessmentPage extends BasePage {
	
	
	private By templateCell  = By.xpath("//td[contains(@class, 'e-templatecell')]//div[contains(text(),'FlyingQA_20250527144844 Verisq TPRM-NIST-CSF-2-0 Autoscored')]");
	
	// Section 1 Label 
	
	private By input1Label = By.xpath("(//label[text()='1.1 '])[1]");
	private By input2Label = By.xpath("(//label[text()='1.2 '])[1]");
	private By input3Label = By.xpath("(//label[text()='1.3 '])[1]");
	private By input4Label = By.xpath("(//label[text()='1.4 '])[1]");
	private By input5Label = By.xpath("(//label[text()='1.5 '])[1]");
	private By input6Label = By.xpath("(//label[text()='1.6 '])[1]");
	private By input7Label = By.xpath("(//label[text()='1.7 '])[1]");
	private By input8Label = By.xpath("(//label[text()='1.8 '])[1]");
	
	// Section 1 Input Field
	private By section1Input1Answer = By.xpath("//input[@name='question_15862']");
	private By section1Input1Comment = By.xpath("(//div[@id='question_15862_rte-editable'])[1]");
	private By section1Input1Justification = By.xpath("(//div[@id='question_15862_rte-editable'])[2]");
	
	private By section1Input2Answer =By.xpath("//input[@id='question_15863']");
	private By section1Input2Comment = By.xpath("(//div[@id='question_15863_rte-editable'])[1]");
	private By section1Input2Justification =By.xpath("(//div[@id='question_15863_rte-editable'])[2]");
	
	private By section1Input3Answer = By.xpath("//input[@id='question_15864']");
	private By section1Input3Comment = By.xpath("(//div[@id='question_15864_rte-editable'])[1]");
	private By section1Input3Justification =By.xpath("(//div[@id='question_15864_rte-editable'])[2]");
	
	private By section1Input4Answer = By.xpath("//input[@id='question_15865']");
	private By section1Input4Comment = By.xpath("(//div[@id='question_15865_rte-editable'])[1]");
	private By section1Input4Justification = By.xpath("(//div[@id='question_15865_rte-editable'])[2]");
	
	private By section1Input5Answer = By.xpath("//input[@id='question_15866']");
	private By section1Input5Comment = By.xpath("(//div[@id='question_15866_rte-editable'])[1]");
	private By section1Input5Justification =By.xpath("(//div[@id='question_15866_rte-editable'])[2]");
	
	private By section1Input6Radio = By.xpath("//label[span[normalize-space(text())='Education']]");
	private By section1Input6Comment = By.xpath("(//div[@id='question_15867_rte-editable'])[1]");
	private By section1Input6Justification =By.xpath("(//div[@id='question_15867_rte-editable'])[2]");
	
	private By section1Input7Answer = By.xpath("//input[@id='question_15868']");
	private By section1Input7Comment = By.xpath("(//div[@id='question_15868_rte-editable'])[1]");
	private By section1Input7Justification =By.xpath("(//div[@id='question_15868_rte-editable'])[2]");
	
	private By section1Input8Date = By.xpath("//input[@id='question_15869']");
	private By section1Input8Comment = By.xpath("(//div[@id='question_15869_rte-editable'])[1]");
	private By section1Input8Justification =By.xpath("(//div[@id='question_15869_rte-editable'])[2]");
	
	private By loader = By.cssSelector("div.loader-page-section");
	
	
	public AssessmentPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

      
		public void clickOnDefaultAssessment() {
			
		    WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(templateCell));

		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", linkElement);

		    try {
		        linkElement.click();
		    } catch (ElementClickInterceptedException e) {
		        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", linkElement);
		    }
		}

 
	 	
	
	public void getWaitForResponder() throws InterruptedException {
		WebElement state = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Waiting Responder']")));
		String stateName = state.getText();
		System.out.println(stateName);
		
	}
	
			
	public void section1Answer() throws InterruptedException {
	    // 1. Wait for section to load
	    wait.until(ExpectedConditions.visibilityOfElementLocated(input1Label));

	    // 2. Scroll and expand Section 1.1
	    WebElement section1Label1 = driver.findElement(input1Label);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section1Label1);
	    section1Label1.click();

	    // 3. Answer Field Handling
	    WebElement input1Answer = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input1Answer));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input1Answer);

	    String input1Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", input1Answer);

	    if (input1Value == null || input1Value.trim().isEmpty()) {
	        input1Answer.sendKeys("Narola Infotech");
	    }

	    // 4. Comment Field Handling
	    WebElement commentCountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("(//div[contains(@class,'button-list-right')]//span[contains(@class,'item-count-design')][1])[1]")
	    ));

	    int commentCount = Integer.parseInt(commentCountElement.getText().trim());

	    WebElement input1Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input1Comment));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input1Comment);

	    if (commentCount > 0) {
	        String existingComment = input1Comment.getText();
	        System.out.println("Existing Comment: " + existingComment);
	    } else {
	        String newComment = "Initial assessment comment for Narola Infotech";
	        input1Comment.sendKeys(newComment);
	        System.out.println("Added new comment: " + newComment);
	    }

	    // 5. Justification Field Handling
	    WebElement input1Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input1Justification));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input1Justification);

	    String justificationValue = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", input1Justification);

	    if (justificationValue == null || justificationValue.trim().isEmpty()) {
	        String justificationText = "Narola Infotech has demonstrated consistent expertise in delivering " +
	            "a wide range of technology services, including custom software development, " +
	            "mobile and web application solutions, and enterprise-grade systems.";

	        input1Justification.sendKeys(justificationText);
	    }

	    // 6. Final loader wait
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
	}
	    
	    
//        
//       // 1.2 
//	    
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(input2Label));
//
//	    WebElement section1Label2 = driver.findElement(input2Label);
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section1Label2);
//	    section1Label2.click();
//
//	    // Input Answer
//	    WebElement input2Answer = driver.findElement(section1Input2Answer);
////	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input2Answer);
//	    input2Answer.clear();
//	    Thread.sleep(2000);
//	    input2Answer.sendKeys("Darshak");
//
//	    // Comment
//	    WebElement input2Comment = driver.findElement(section1Input2Comment);
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input2Comment);
//
//        String section1Comment2 = input2Comment.getText();
//        Thread.sleep(2000);
//        System.out.println(section1Comment2);
//	    
//	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
//
//	    // Justification
//	    WebElement input2Justification = driver.findElement(section1Input2Justification);
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input2Justification);
//	    input2Justification.clear();
//	    Thread.sleep(2000);
//	    input2Justification.sendKeys("Darshak Patel has in-depth knowledge of the assessment objectives and is responsible for facilitating the required information, clarifications, and responses throughout the assessment process.");
//	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader)); 
//	    
//	    
//	     // 1.3
//		 wait.until(ExpectedConditions.visibilityOfElementLocated(input3Label));
//
//	     // Label
//		 WebElement section1Label3 = driver.findElement(input3Label);
//		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section1Label3);
//		 section1Label3.click();
//
//	     // Input Answer
//		  WebElement input3Answer = driver.findElement(section1Input3Answer);
////		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input3Answer);
//		  input3Answer.clear();
//		  Thread.sleep(2000);
//		  input3Answer.sendKeys("darshak143@yopmail.com");
//
//	     // Comment
//		  WebElement input3Comment = driver.findElement(section1Input3Comment);
//		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input3Comment);
//		  
//	      String section1Comment3 = input3Comment.getText();
//	      Thread.sleep(2000);
//	      System.out.println(section1Comment3);
//		  wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
//
//		 // Justification
//		  WebElement input3Justification = driver.findElement(section1Input3Justification);
//		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input3Justification);
//		  input3Justification.clear();
//		  Thread.sleep(2000);
//		  input3Justification.sendKeys("This email address ensures that all communications, updates, and clarifications related to the assessment are directed to the responsible individual, facilitating prompt responses and efficient coordination.");
//		  wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
//		  
//		  // 1.4
//		  wait.until(ExpectedConditions.visibilityOfElementLocated(input4Label));
//
//		  // Label
//	      WebElement section1Label4 = driver.findElement(input4Label);
//		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section1Label4);
//		  section1Label4.click();
//
//		  // Input Answer
//		  WebElement input4Answer = driver.findElement(section1Input4Answer);
////		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input4Answer);
//		  input4Answer.clear();
//		  Thread.sleep(2000);
//		  input4Answer.sendKeys("8866180955");
//
//		  // Comment
//		  WebElement input4Comment = driver.findElement(section1Input4Comment);
//		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input4Comment);
//		  
//	      String section1Comment4 = input4Comment.getText();
//	      Thread.sleep(2000);
//	      System.out.println(section1Comment4);
//		  wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
//
//		  // Justification
//		  WebElement input4Justification = driver.findElement(section1Input4Justification);
//		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input4Justification);
//		  input4Justification.clear();
//		  Thread.sleep(2000);
//		  input4Justification.sendKeys("The phone number 8866180955 is provided as the direct contact for the primary individual responsible for this assessment.");
//		  wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
//		  
//		  // 1.5
//		  wait.until(ExpectedConditions.visibilityOfElementLocated(input5Label));
//
//		  // Label
//	      WebElement section1Label5 = driver.findElement(input5Label);
//		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section1Label5);
//		  section1Label5.click();
//
//		  // Input Answer
//		  WebElement input5Answer = driver.findElement(section1Input5Answer);
////		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input5Answer);
//		  input5Answer.clear();
//		  Thread.sleep(2000);
//		  input5Answer.sendKeys("https://www.narolainfotech.com");
//
//		  // Comment
//		  WebElement input5Comment = driver.findElement(section1Input5Comment);
//		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input5Comment);
//	      String section1Comment5 = input5Comment.getText();
//	      Thread.sleep(2000);
//	      System.out.println(section1Comment5);
//		  wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
//
//		  // Justification
//		  WebElement input5Justification = driver.findElement(section1Input5Justification);
//		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input5Justification);
//		  input5Justification.clear();
//		  input5Justification.sendKeys("This website serves as a verified source of information about Narola Infotech's services, expertise, and contact details.");
//		  wait.until(ExpectedConditions.invisibilityOfElementLocated(loader)); 
//		  
//		  // 1.6
//		  wait.until(ExpectedConditions.visibilityOfElementLocated(input6Label));
//
//		  // Label
//	      WebElement section1Label6 = driver.findElement(input6Label);
//		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section1Label6);
//		  section1Label6.click();
//
//          // Input Radio
//		  wait.until(ExpectedConditions.elementToBeClickable(section1Input6Radio));
//		  WebElement radioButton6 = driver.findElement(section1Input6Radio);
//		  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioButton6);
//		  Thread.sleep(2000);
//		  
//		  
//		  // Comment
//		  WebElement input6Comment = driver.findElement(section1Input6Comment);
//		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input6Comment);
//	      String section1Comment6 = input6Comment.getText();
//	      Thread.sleep(2000);
//	      System.out.println(section1Comment6);
//		  wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
//
//		  // Justification
//		  WebElement input6Justification = driver.findElement(section1Input6Justification);
//		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input6Justification);
//		  input6Justification.clear();
//		  Thread.sleep(2000);
//		  input6Justification.sendKeys("The Education industry best represents our organization because our core operations, client base, and service offerings are focused on enhancing learning experiences, academic management, and educational technology.");
//		  wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
//		    
//		  // 1.7 
//		  wait.until(ExpectedConditions.visibilityOfElementLocated(input7Label));
//
//		  // Label
//	      WebElement section1Label7 = driver.findElement(input7Label);
//		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section1Label7);
//		  section1Label7.click();
//
//		  // Input Answer
//		  WebElement input7Answer = driver.findElement(section1Input7Answer);
////		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input7Answer);
//		  input7Answer.clear();
//		  Thread.sleep(2000);
//		  input7Answer.sendKeys("2");
//          
//		  // Comment
//		  WebElement input7Comment = driver.findElement(section1Input7Comment);
//		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input7Comment);
//	      String section1Comment7 = input7Comment.getText();
//	      Thread.sleep(2000);
//	      System.out.println(section1Comment7);
//		  wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
//
//		  // Justification
//		  WebElement input7Justification = driver.findElement(section1Input7Justification);
//		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input7Justification);
//		  input7Justification.clear();
//		  Thread.sleep(2000);
//		  input7Justification.sendKeys("This number reflects the current staffing level as a small team is sufficient for handling our focused range of services and client requirements.");
//		  wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
//		  
//		  // 1.8 
//		  wait.until(ExpectedConditions.visibilityOfElementLocated(input8Label));
//
//		  // Label
//	      WebElement section1Label8 = driver.findElement(input8Label);
//		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section1Label8);
//		  section1Label8.click();
//
//		  // Date Picker
//		  WebElement input8Date = driver.findElement(section1Input8Date);
//		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input8Date);
//		  input8Date.clear();
//		  Thread.sleep(2000);
//		  input8Date.sendKeys("12/31/2025");
//          
//		  
//		  // Comment
//		  WebElement input8Comment = driver.findElement(section1Input8Comment);
//		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input8Comment);
//
//	      String section1Comment8 = input8Comment.getText();
//	      Thread.sleep(2000);
//	      System.out.println(section1Comment8);
//		  wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
//
//		  // Justification
//		  WebElement input8Justification = driver.findElement(section1Input8Justification);
//		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", input8Justification);
//		  input8Justification.clear();
//		  Thread.sleep(2000);
//		  input8Justification.sendKeys("This number reflects the current staffing level as a small team is sufficient for handling our focused range of services and client requirements.");
//		  wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
//		  	 	    
//	}


	
	public void nextBtn() throws InterruptedException {
		
        WebElement nextButton = driver.findElement(By.id("nextStep"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);

        try {
            Thread.sleep(500); // wait 0.5 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        nextButton.click();
        Thread.sleep(2000);
	}
	
	
}