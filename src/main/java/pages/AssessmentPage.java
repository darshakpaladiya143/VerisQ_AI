package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssessmentPage extends BasePage {
	
	
	private By templateCell  = By.xpath("//td[contains(@class, 'e-templatecell')]//div[contains(text(),'FlyingQA_20250604170519 Verisq TPRM-NIST-CSF-2-0 Autoscored')]");
	
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
		
		// === SECTION 1.1 ===
	  
	    wait.until(ExpectedConditions.visibilityOfElementLocated(input1Label));

	    WebElement section1Label1 = driver.findElement(input1Label);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section1Label1);
	    section1Label1.click();

	    WebElement input1Answer = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input1Answer));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input1Answer);

	    
	    String input1Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value || arguments[0].getAttribute('value');", input1Answer);
	    System.out.println("Extracted value: '" + input1Value + "'");
	    

	    if (input1Value == null || input1Value.trim().isEmpty()) {
	        input1Answer.sendKeys("Narola Infotech");
	    }

	    WebElement comment1CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[1]")
	    ));

	    int comment1Count = Integer.parseInt(comment1CountElement.getText().trim());
	    
	    System.out.println(comment1Count);

	    WebElement input1Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input1Comment));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input1Comment);

	    if (comment1Count > 0) {
	        String existingComment = input1Comment.getText();
	        System.out.println("Existing Comment: " + existingComment);
	    } else {
	        String newComment = "Initial assessment comment for Narola Infotech";
	        input1Comment.sendKeys(newComment);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
	        System.out.println("Added new comment: " + newComment);
	    }

	    WebElement input1Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input1Justification));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input1Justification);

	    String justificationValue = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value || arguments[0].getAttribute('value');", input1Justification);
	    System.out.println(justificationValue);

	    if (justificationValue == null || justificationValue.trim().isEmpty()) {
	        String justificationText = "Narola Infotech has demonstrated consistent expertise in delivering " +
	            "a wide range of technology services, including custom software development, " +
	            "mobile and web application solutions, and enterprise-grade systems.";

	        input1Justification.sendKeys(justificationText);
	    }

	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
	    
	    
	 // === SECTION 1.2 ===
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(input2Label));
	    WebElement section1Label2 = driver.findElement(input2Label);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section1Label2);
	    section1Label2.click();

	    WebElement input2Answer = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input2Answer));
	    String input2Value = input2Answer.getAttribute("value");
	    if (input2Value == null || input2Value.trim().isEmpty()) {
	        input2Answer.sendKeys("Darshak");
	    }

	    WebElement comment2CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[5]")));
	    
	    int comment2Count = Integer.parseInt(comment2CountElement.getText().trim());
	    WebElement input2Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input2Comment));
	    if (comment2Count > 0) {
	        System.out.println("Existing Comment: " + input2Comment.getText());
	    } else {
	        input2Comment.sendKeys("Comment for Section 1.2");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
	    }

	    WebElement input2Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input2Justification));
	    String justification2Value = input2Justification.getAttribute("value");
	    if (justification2Value == null || justification2Value.trim().isEmpty()) {
	        input2Justification.sendKeys("Darshak Patel has in-depth knowledge...");
	    }
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));


	    // === SECTION 1.3 ===
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(input3Label));
	    WebElement section1Label3 = driver.findElement(input3Label);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section1Label3);
	    section1Label3.click();

	    WebElement input3Answer = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input3Answer));
	    String input3Value = input3Answer.getAttribute("value");
	    if (input3Value == null || input3Value.trim().isEmpty()) {
	        input3Answer.sendKeys("darshak143@yopmail.com");
	    }

	    WebElement comment3CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[9]")
	    ));
	    int comment3Count = Integer.parseInt(comment3CountElement.getText().trim());
	    WebElement input3Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input3Comment));
	    if (comment3Count > 0) {
	        System.out.println("Existing Comment: " + input3Comment.getText());
	    } else {
	        input3Comment.sendKeys("Comment for Section 1.3");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
	    }

	    WebElement input3Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input3Justification));
	    String justification3Value = input3Justification.getAttribute("value");
	    if (justification3Value == null || justification3Value.trim().isEmpty()) {
	        input3Justification.sendKeys("This email address ensures that...");
	    }
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));


	    // === SECTION 1.4 ===
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(input4Label));
	    WebElement section1Label4 = driver.findElement(input4Label);
	    section1Label4.click();

	    WebElement input4Answer = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input4Answer));
	    String input4Value = input4Answer.getAttribute("value");
	    if (input4Value == null || input4Value.trim().isEmpty()) {
	        input4Answer.sendKeys("8866180955");
	    }

	    WebElement comment4CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[13]")
	    ));
	    int comment4Count = Integer.parseInt(comment4CountElement.getText().trim());
	    WebElement input4Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input4Comment));
	    if (comment4Count > 0) {
	        System.out.println("Existing Comment: " + input4Comment.getText());
	    } else {
	        input4Comment.sendKeys("Comment for Section 1.4");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
	    }

	    WebElement input4Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input4Justification));
	    String justification4Value = input4Justification.getAttribute("value");
	    if (justification4Value == null || justification4Value.trim().isEmpty()) {
	        input4Justification.sendKeys("The phone number 8866180955 is provided as...");
	    }
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));


	    // === SECTION 1.5 ===
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(input5Label));
	    WebElement section1Label5 = driver.findElement(input5Label);
	    section1Label5.click();

	    WebElement input5Answer = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input5Answer));
	    String input5Value = input5Answer.getAttribute("value");
	    if (input5Value == null || input5Value.trim().isEmpty()) {
	        input5Answer.sendKeys("https://www.narolainfotech.com");
	    }

	    WebElement comment5CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[17]")
	    ));
	    int comment5Count = Integer.parseInt(comment5CountElement.getText().trim());
	    WebElement input5Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input5Comment));
	    if (comment5Count > 0) {
	        System.out.println("Existing Comment: " + input5Comment.getText());
	    } else {
	        input5Comment.sendKeys("Comment for Section 1.5");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
	    }

	    WebElement input5Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input5Justification));
	    String justification5Value = input5Justification.getAttribute("value");
	    if (justification5Value == null || justification5Value.trim().isEmpty()) {
	        input5Justification.sendKeys("This website serves as a verified source...");
	    }
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));


	    // === SECTION 1.6 ===
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(input6Label));
	    WebElement section1Label6 = driver.findElement(input6Label);
	    section1Label6.click();

	    WebElement radioButton6 = wait.until(ExpectedConditions.elementToBeClickable(section1Input6Radio));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioButton6);

	    WebElement comment6CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[21]")
	    ));
	    int comment6Count = Integer.parseInt(comment6CountElement.getText().trim());
	    WebElement input6Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input6Comment));
	    if (comment6Count > 0) {
	        System.out.println("Existing Comment: " + input6Comment.getText());
	    } else {
	        input6Comment.sendKeys("Comment for Section 1.6");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
	    }

	    WebElement input6Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input6Justification));
	    String justification6Value = input6Justification.getAttribute("value");
	    if (justification6Value == null || justification6Value.trim().isEmpty()) {
	        input6Justification.sendKeys("The Education industry best represents...");
	    }
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));


	    // === SECTION 1.7 ===
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(input7Label));
	    WebElement section1Label7 = driver.findElement(input7Label);
	    section1Label7.click();

	    WebElement input7Answer = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input7Answer));
	    String input7Value = input7Answer.getAttribute("value");
	    if (input7Value == null || input7Value.trim().isEmpty()) {
	        input7Answer.sendKeys("2");
	    }

	    WebElement comment7CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[25]")
	    ));
	    int comment7Count = Integer.parseInt(comment7CountElement.getText().trim());
	    WebElement input7Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input7Comment));
	    if (comment7Count > 0) {
	        System.out.println("Existing Comment: " + input7Comment.getText());
	    } else {
	        input7Comment.sendKeys("Comment for Section 1.7");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
	    }

	    WebElement input7Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input7Justification));
	    String justification7Value = input7Justification.getAttribute("value");
	    if (justification7Value == null || justification7Value.trim().isEmpty()) {
	        input7Justification.sendKeys("This number reflects the current staffing...");
	    }
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));


	    // === SECTION 1.8 ===
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(input8Label));
	    WebElement section1Label8 = driver.findElement(input8Label);
	    section1Label8.click();

	    WebElement input8Date = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input8Date));
	    String input8DateValue = input8Date.getAttribute("value");
	    if (input8DateValue == null || input8DateValue.trim().isEmpty()) {
	        input8Date.sendKeys("12/31/2025");
	    }

	    WebElement comment8CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[29]")
	    ));
	    int comment8Count = Integer.parseInt(comment8CountElement.getText().trim());
	    WebElement input8Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input8Comment));
	    if (comment8Count > 0) {
	        System.out.println("Existing Comment: " + input8Comment.getText());
	    } else {
	        input8Comment.sendKeys("Comment for Section 1.8");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
	    }

	    WebElement input8Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input8Justification));
	    String justification8Value = input8Justification.getAttribute("value");
	    if (justification8Value == null || justification8Value.trim().isEmpty()) {
	        input8Justification.sendKeys("This number reflects the current staffing...");
	    }
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));    
	    
	}
	
	
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