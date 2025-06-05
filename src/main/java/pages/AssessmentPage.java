package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssessmentPage extends BasePage {
	
	
	private By templateCell  = By.xpath("//td[contains(@class, 'e-templatecell')]//div[contains(text(),'FlyingQA_20250604181540 Verisq TPRM-NIST-CSF-2-0 Autoscored')]");
	
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
	    Thread.sleep(2000);

	    WebElement input1Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input1Comment));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input1Comment);

	    if (comment1Count > 0) {
	        String existingComment = input1Comment.getText();
	        System.out.println("Existing Comment: " + existingComment);
	    } else {
	        String newComment = "Initial assessment comment for Narola Infotech";
	        input1Comment.sendKeys(newComment);
	        Thread.sleep(1000);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
	        System.out.println("Added new comment in section 1.1 : " + newComment);
	    }

	    WebElement input1Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input1Justification));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input1Justification);
	    	    	    
	    String justificationValue = (String) ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", input1Justification);
	    System.out.println("Justification (cleaned): '" + justificationValue + "'");


	    if (justificationValue == null || justificationValue.isEmpty()) {
	    	
	        String justification1Text = "Narola Infotech has demonstrated consistent expertise in delivering " +
	            "a wide range of technology services, including custom software development, " +
	            "mobile and web application solutions, and enterprise-grade systems.";

	        input1Justification.sendKeys(justification1Text);
		    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		    System.out.println("Added justification in section 1.1 : " + justification1Text);
	    }
	    
	    
	 // === SECTION 1.2 ===
	    
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

	    WebElement section1Label2 = wait.until(ExpectedConditions.elementToBeClickable(input2Label));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section1Label2);
	    Thread.sleep(1000);
	    section1Label2.click();
	    
	    WebElement input2Answer = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input2Answer));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input2Answer);
	    
	    String input2Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value || arguments[0].getAttribute('value');", input2Answer);
	    System.out.println("Extracted value: '" + input2Value + "'");
	    
	    if (input2Value == null || input2Value.trim().isEmpty()) {
	        input2Answer.sendKeys("Darshak");
	    }

	    WebElement comment2CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
	    		By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[5]")
	    		));
	    
	    int comment2Count = Integer.parseInt(comment2CountElement.getText().trim());
	    System.out.println(comment2Count);
	    Thread.sleep(2000);
	    
	    
	    WebElement input2Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input2Comment));
	    if (comment2Count > 0) {
	        System.out.println("Existing Comment: " + input2Comment.getText());
	    } else {
	        input2Comment.sendKeys("Comment for Section 1.2");
	        Thread.sleep(1000);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
	        System.out.println("Added new comment in section 1.2 : " + input2Comment);
	    }

	    WebElement input2Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input2Justification));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input2Justification);
	    
	    String justification2Value = (String) ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", input2Justification);
	    System.out.println("Justification (cleaned): '" + justification2Value + "'");

	   
	    if (justification2Value == null || justification2Value.isEmpty()) {
	    	String justification2Text = "Darshak Paladiya has in-depth knowledge...";
	        input2Justification.sendKeys(justification2Text);
		    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		    System.out.println("Added justification in section 1.2 : " + justification2Text);
	    }



	    // === SECTION 1.3 ===
	
    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(input3Label));
	    
	    WebElement section1Label3 = driver.findElement(input3Label);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section1Label3);
	    Thread.sleep(1000);
	    section1Label3.click();
	    
	    WebElement input3Answer = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input3Answer));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input3Answer);


	    String input3Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value || arguments[0].getAttribute('value');", input3Answer);
	    System.out.println("Extracted value: '" + input3Value + "'");
	    
	    if (input3Value == null || input3Value.trim().isEmpty()) {
	        input3Answer.sendKeys("darshak143@yopmail.com");
	    }

	    WebElement comment3CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[9]")
	    ));
	    
	    int comment3Count = Integer.parseInt(comment3CountElement.getText().trim());
	    System.out.println(comment3Count);
	    Thread.sleep(2000);
	    
	    
	    WebElement input3Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input3Comment));
	    if (comment3Count > 0) {
	        System.out.println("Existing Comment: " + input3Comment.getText());
	    } else {
	        input3Comment.sendKeys("Comment for Section 1.3");
	        Thread.sleep(2000);
		    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		    System.out.println("Added new comment in section 1.3 : " + input3Comment);
	    }

	    WebElement input3Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input3Justification));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input3Justification);
	    
	    String justification3Value = (String) ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", input3Justification);
	    System.out.println("Justification (cleaned): '" + justification3Value + "'");    
	
	    if (justification3Value == null || justification3Value.isEmpty()) {
	    	String justification3Text = "This email address ensures that....";
	        input3Justification.sendKeys(justification3Text);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
	        System.out.println("Added justification in section 1.3 : " + justification3Text);
	    }

	
	    
	    // === SECTION 1.4 ===
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(input4Label)); 
	    
	    WebElement section1Label4 = driver.findElement(input4Label);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section1Label4);
	    Thread.sleep(1000);
	    section1Label4.click();

	    WebElement input4Answer = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input4Answer));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input4Answer);

	    String input4Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value || arguments[0].getAttribute('value');", input4Answer);
	    System.out.println("Extracted value: '" + input4Value + "'");
	    

	    if (input4Value == null || input4Value.trim().isEmpty()) {
	        input4Answer.sendKeys("8866180955");
	    }

	    WebElement comment4CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[13]")
	    ));
	    
	    int comment4Count = Integer.parseInt(comment4CountElement.getText().trim());
	    System.out.println(comment4Count);
	    Thread.sleep(2000);
	    
	    WebElement input4Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input4Comment));
	    if (comment4Count > 0) {
	        System.out.println("Existing Comment: " + input4Comment.getText());
	    } else {
	        input4Comment.sendKeys("Comment for Section 1.4");
	        Thread.sleep(2000);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
	        System.out.println("Added new comment in section 1.4 : " + input4Comment);
	    }

	    WebElement input4Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input4Justification));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input4Justification);
	    
	    String justification4Value = (String) ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", input4Justification);
	    System.out.println("Justification (cleaned): '" + justification4Value + "'");    
	    	    
	    
	    if (justification4Value == null || justification4Value.isEmpty()) {
	    	String justification4Text = "The phone number 8866180955 is provided as...";
	        input4Justification.sendKeys(justification4Text);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
	        System.out.println("Added justification in section 1.4 : " + justification4Text);
	    }
	

	    // === SECTION 1.5 ===
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(input5Label));
	    
	    WebElement section1Label5 = driver.findElement(input5Label);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section1Label5);
	    Thread.sleep(1000);
	    section1Label5.click();

	    
	    WebElement input5Answer = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input5Answer));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input5Answer);

	    String input5Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value || arguments[0].getAttribute('value');", input5Answer);
	    System.out.println("Extracted value: '" + input5Value + "'");
	    
	    if (input5Value == null || input5Value.trim().isEmpty()) {
	        input5Answer.sendKeys("https://www.narolainfotech.com");
	    }

	    WebElement comment5CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[17]")
	    ));
	    
	    int comment5Count = Integer.parseInt(comment5CountElement.getText().trim());
	    System.out.println(comment5Count);
	    Thread.sleep(2000);
	    
	    WebElement input5Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input5Comment));
	    if (comment5Count > 0) {
	        System.out.println("Existing Comment: " + input5Comment.getText());
	    } else {
	        input5Comment.sendKeys("Comment for Section 1.5");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
	        System.out.println("Added new comment in section 1.5 : " + input5Comment);
	    }

	    WebElement input5Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input5Justification));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input5Justification);
	    
	    String justification5Value = (String) ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", input5Justification);
	    System.out.println("Justification (cleaned): '" + justification5Value + "'"); 
	    
	    
	    if (justification5Value == null || justification5Value.trim().isEmpty()) {
	    	String justification5Text = "This website serves as a verified source...";
	        input5Justification.sendKeys(justification5Text);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
	        System.out.println("Added justification in section 1.5 : " + justification5Text);
	    }
	

	    // === SECTION 1.6 ===
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(input6Label));
	    WebElement section1Label6 = driver.findElement(input6Label);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section1Label6);
	    Thread.sleep(1000);
	    section1Label6.click();

	    WebElement radioButton6 = wait.until(ExpectedConditions.elementToBeClickable(section1Input6Radio));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioButton6);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(loader));

	    WebElement comment6CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[21]")
	    ));
	    
	    int comment6Count = Integer.parseInt(comment6CountElement.getText().trim());
	    System.out.println(comment6Count);
	    Thread.sleep(2000);
	    
	    
	    WebElement input6Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input6Comment));
	    if (comment6Count > 0) {
	        System.out.println("Existing Comment: " + input6Comment.getText());
	    } else {
	        input6Comment.sendKeys("Comment for Section 1.6");
	        Thread.sleep(2000);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
	        System.out.println("Added new comment in section 1.6 : " + input6Comment);
	    }


	    WebElement input6Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input6Justification));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input6Justification);
	    
	    String justification6Value = (String) ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", input6Justification);
	    System.out.println("Justification (cleaned): '" + justification6Value + "'");   
	    
	    
	    if (justification6Value == null || justification6Value.isEmpty()) {
	    	String justification6Text = "The Education industry best represents...";
	        input6Justification.sendKeys(justification6Text);
		    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		    System.out.println("Added justification in section 1.6 : " + justification6Text);
	    }

	    // === SECTION 1.7 ===
    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(input7Label));
	   
	    WebElement section1Label7 = driver.findElement(input7Label);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section1Label7);
	    Thread.sleep(1000);
	    section1Label7.click();
	    
	    WebElement input7Answer = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input7Answer));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input7Answer);

	    String input7Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value || arguments[0].getAttribute('value');", input7Answer);
	    System.out.println("Extracted value: '" + input7Value + "'");
	    
	   
	    if (input7Value == null || input7Value.trim().isEmpty()) {
	        input7Answer.sendKeys("2");
	    }

	    WebElement comment7CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[25]")
	    ));
	    
	    int comment7Count = Integer.parseInt(comment7CountElement.getText().trim());
	    System.out.println(comment7Count);
	    Thread.sleep(2000);
	    
	    
	    WebElement input7Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input7Comment));
	    if (comment7Count > 0) {
	        System.out.println("Existing Comment: " + input7Comment.getText());
	    } else {
	        input7Comment.sendKeys("Comment for Section 1.7");
	        Thread.sleep(2000);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
	        System.out.println("Added new comment in section 1.4 : " + input7Comment);
	    }

        
	    WebElement input7Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input7Justification));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input7Justification);
	    
	    String justification7Value = (String) ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", input7Justification);
	    System.out.println("Justification (cleaned): '" + justification7Value + "'");    
	    	    
	    
	    
	    if (justification7Value == null || justification7Value.trim().isEmpty()) {
	    	String justification7Text = "This number reflects the current staffing...";
	        input7Justification.sendKeys(justification7Text);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
	        System.out.println("Added justification in section 1.7 : " + justification7Text);
	    }

	    // === SECTION 1.8 ===
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(input8Label));
	    WebElement section1Label8 = driver.findElement(input8Label);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section1Label8);
	    Thread.sleep(1000);
	    section1Label8.click();


	    WebElement input8Date = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input8Date));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input8Date);

	    String input8DateValue = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value || arguments[0].getAttribute('value');", input8Date);
	    System.out.println("Extracted value: '" + input8DateValue + "'");
	    
	    
	    
	    if (input8DateValue == null || input8DateValue.trim().isEmpty()) {
	        input8Date.sendKeys("12/31/2025");
	    }

	    WebElement comment8CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[29]")
	    ));
	    
	    int comment8Count = Integer.parseInt(comment8CountElement.getText().trim());
	    System.out.println(comment8Count);
	    Thread.sleep(2000);
	    
	    WebElement input8Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input8Comment));
	    if (comment8Count > 0) {
	        System.out.println("Existing Comment: " + input8Comment.getText());
	    } else {
	        input8Comment.sendKeys("Comment for Section 1.8");
	        Thread.sleep(2000);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
	        System.out.println("Added new comment in section 1.8 : " + input8Comment);
	    }


	    WebElement input8Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section1Input8Justification));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input8Justification);
	    
	    String justification8Value = (String) ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", input8Justification);
	    System.out.println("Justification (cleaned): '" + justification8Value + "'");   
	    
	    
	    if (justification8Value == null || justification8Value.trim().isEmpty()) {
	    	String justification8Text = "This date represent the assessment performance date...";
	        input8Justification.sendKeys(justification8Text);
		    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));   
	        System.out.println("Added justification in section 1.8 : " + justification8Text);
	    }
    
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