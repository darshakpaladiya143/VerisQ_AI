package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssessmentPage extends BasePage {
	
	
	private By firstTemplateCellLink = By.xpath("//td[contains(@class, 'e-templatecell')]//a");
	
	// Section 1 
	
	private By input1Label = By.xpath("//button[text()='1.1 ']");
	private By input2Label = By.xpath("//button[text()='1.2 ']");
	private By input3Label = By.xpath("//button[text()='1.3 ']");
	private By input4Label = By.xpath("//button[text()='1.4 ']");
	private By input5Label = By.xpath("//button[text()='1.5 ']");
	private By input6Label = By.xpath("//button[text()='1.6 ']");
	private By input7Label = By.xpath("//button[text()='1.7 ']");
	private By input8Label = By.xpath("//button[text()='1.8 ']");
	
	private By  input1 = By.xpath("(//input[@placeholder='Enter your answer'])[1]");
	private By  input2 = By.xpath("(//input[@placeholder='Enter your answer'])[2]"); 
	private By  input3 = By.xpath("(//input[@placeholder='Enter your answer'])[3]");
	private By  input4 = By.xpath("(//input[@placeholder='Enter your answer'])[4]");
	private By  input5 = By.xpath("(//input[@placeholder='Enter your answer'])[5]");
	private By  input6 = By.xpath("//label[normalize-space()='Technology']");
	private By  input7 = By.xpath("//input[@placeholder='Enter number']");
	private By  input8 = By.xpath("//input[@placeholder='Select date']");
	
	
	// Section-2 
	
	private By section2Input1Label = By.xpath("//button[text()='2.1 ']");
	private By section2Input2Label = By.xpath("//button[text()='2.2 ']");
	private By section2Input3Label = By.xpath("//button[text()='2.3 ']");
	private By section2Input4Label = By.xpath("//button[text()='2.4 ']");
	private By section2Input5Label = By.xpath("//button[text()='2.5 ']");
	private By section2Input6Label = By.xpath("//button[text()='2.6 ']");
	private By section2Input7Label = By.xpath("//button[text()='2.7 ']");
	private By section2Input8Label = By.xpath("//button[text()='2.8 ']");
	
	private By  sectionRadio1 = By.xpath("(//input[@type='radio' and @value='No'])[1]");
	private By  section2Input1 = By.xpath("//div[@id='question_15870_rte-editable']");

	private By  sectionRadio2 = By.xpath("//input[@type='radio' and @value='No'])[2]");
	private By  section2Input2 = By.xpath("//div[@id='question_15871_rte-editable']"); 
	
	private By  sectionRadio3 = By.xpath("(//input[@type='radio' and @value='No'])[3]");
	private By  section2Input3 = By.xpath("//div[@id='question_15872_rte-editable']");
	
	
	private By  sectionRadio4 = By.xpath("(//input[@placeholder='Enter your answer'])[4]");
	private By  section2Input4 = By.xpath("//div[@id='question_15873_rte-editable']");
	
	private By  section2Input51 = By.xpath("(//div[@id='question_15874_rte-editable'])[1]");
	private By  section2Input52 = By.xpath("(//div[@id='question_15874_rte-editable'])[2]");
	
	private By  section2Input61 = By.xpath("(//div[@id='question_15875_rte-editable'])[1]");
	private By  section2Input62 = By.xpath("(//div[@id='question_15875_rte-editable'])[2]");
	
	
	private By  section2Input71 = By.xpath("(//div[@id='question_15876_rte-editable'])[1]");
	private By  section2Input72 = By.xpath("(//div[@id='question_15876_rte-editable'])[2]");
	
	
	private By  section2Input81 = By.xpath("");
	private By  section2Input82 = By.xpath("");
	
	private By section2Header = By.xpath("//div[contains(@class,'d-flex') and contains(@class,'gap-3') and contains(@class,'align-items-center')]/h1");
	
	public AssessmentPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

      
		public void scrollUpToLatestAssessment() {
			
		    WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(firstTemplateCellLink));

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
	


	private void fillField(By buttonLocator, By inputLocator, String value, boolean useJSForInput) throws InterruptedException {
	    WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(buttonLocator));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", btn);

	    wait.until(ExpectedConditions.elementToBeClickable(buttonLocator));
	    try {
	        btn.click();
	    } catch (ElementClickInterceptedException ignored) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
	    }

	    WebElement input = wait.until(ExpectedConditions.elementToBeClickable(inputLocator));

	    if (useJSForInput) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", input);
	    } else {
	        input.sendKeys(value);
	    }

	    Thread.sleep(1000);
	}

	
	public void section1Answer() throws InterruptedException {
	    fillField(input1Label, input1, "Narola Infotech", false);
	    fillField(input2Label, input2, "Darshak Paladiya", false);
	    fillField(input3Label, input3, "darshak143@yopmail.com", false);
	    fillField(input4Label, input4, "8866180955", false);
	    fillField(input5Label, input5, "https://www.narolainfotech.com", false);
	    fillField(input6Label, input6, "Technology", true); // JS click only
	    fillField(input7Label, input7, "2", false);
	    fillField(input8Label, input8, "12/31/2025", false);
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
	
	
	public void section2GetHeader() {
		
		WebElement h1Element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.d-flex.gap-3.align-items-center > h1")));
		wait.until(driver -> !h1Element.getText().trim().isEmpty());

		String h1Text = h1Element.getText();
		System.out.println("H1 Text for section : " + h1Text);
	}
	
	public void section2Answer() throws InterruptedException {
		
		
		// 2.1 
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(section2Input1Label));
		driver.findElement(section2Input1Label).click();    	
		
        WebElement radioButton1 = driver.findElement(By.xpath("//input[@type='radio' and @value='No']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", radioButton1);
        Thread.sleep(1000);
        driver.findElement(section2Input1).sendKeys("Currently, our organization does not have a formally documented cybersecurity strategy that explicitly aligns with business objectives.");
        Thread.sleep(1000);
        
        // 2.2        
        
        WebElement label22 = wait.until(ExpectedConditions.elementToBeClickable(section2Input2Label));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", label22);
        try {
            label22.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", label22);
        }
        
        
        WebElement radioButton2 = driver.findElement(By.xpath("//input[@type='radio' and contains(@value, 'Annually')]"));
        js.executeScript("arguments[0].click();", radioButton2);

        WebElement input22 = wait.until(ExpectedConditions.elementToBeClickable(section2Input2));
        input22.sendKeys("Ensure ongoing adherence to updated legal and compliance standards (e.g., GDPR, NIST, ISO 27001).");
        Thread.sleep(1000);
       
        
        
        // 2.3 
        
        WebElement label23 = wait.until(ExpectedConditions.elementToBeClickable(section2Input3Label));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", label23);
        try {
            label23.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", label23);
        }
        
        WebElement radioButton3 = driver.findElement(By.xpath("//input[@type='radio' and contains(@value,'No')]"));
        js.executeScript("arguments[0].click();", radioButton3);

        WebElement input23 = wait.until(ExpectedConditions.elementToBeClickable(section2Input3));
        input23.sendKeys("Currently, our organization does not have formal executive-level oversight dedicated to cybersecurity risks.");
        Thread.sleep(1000);
       
       
        
        // 2.4 
        
        WebElement label24 = wait.until(ExpectedConditions.elementToBeClickable(section2Input4Label));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", label24);
        try {
        	label24.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", label24);
        }
        
        
        WebElement radioButton4 = driver.findElement(By.xpath("//input[@type='radio' and contains(@value,'No')]"));
        js.executeScript("arguments[0].click();", radioButton4);

        WebElement input24 = wait.until(ExpectedConditions.elementToBeClickable(section2Input4));
        input24.sendKeys("Due to recent organizational changes, our cybersecurity risk management processes are under development.");
        Thread.sleep(1000);
        
        
        
        // 2.5
        
        WebElement label25 = wait.until(ExpectedConditions.elementToBeClickable(section2Input5Label));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", label25);
        try {
        	label25.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", label25);
        }
        
        WebElement input251 = wait.until(ExpectedConditions.elementToBeClickable(section2Input51));
        input251.sendKeys("Our organization determines cybersecurity risk tolerance through collaboration between senior leadership, IT, and business units.");
        Thread.sleep(1000);
        
        WebElement section2Input52 = driver.findElement(By.xpath("(//div[@id='question_15874_rte-editable'])[2]"));

        
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", section2Input52);

        
        WebElement input252 = wait.until(ExpectedConditions.elementToBeClickable(section2Input52));
        input252.sendKeys("While we follow a structured approach, we continuously refine our risk tolerance criteria to align with evolving threats and business goals.");
        Thread.sleep(1000);
        
        
        // 2.6 
        
        WebElement label26 = wait.until(ExpectedConditions.elementToBeClickable(section2Input6Label));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", label26);
        try {
        	label26.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", label26);
        }
        
        WebElement input261 = wait.until(ExpectedConditions.elementToBeClickable(section2Input61));
        input261.sendKeys("Findings are reviewed quarterly, with improvements prioritized based on risk severity and business impact.");
        Thread.sleep(1000);
        
        WebElement section2Input61 = driver.findElement(By.xpath("(//div[@id='question_15874_rte-editable'])[2]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", section2Input61);

        WebElement input262 = wait.until(ExpectedConditions.elementToBeClickable(section2Input62));
        input262.sendKeys("This multi-layered approach ensures continuous evaluation of our security posture while aligning with business objectives.");
        Thread.sleep(1000);
        
        
        
        // 2.7 
        
        WebElement label27 = wait.until(ExpectedConditions.elementToBeClickable(section2Input7Label));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", label27);
        try {
        	label27.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", label27);
        }
        
        WebElement input271 = wait.until(ExpectedConditions.elementToBeClickable(section2Input71));
        input271.sendKeys("Our organization integrates cybersecurity into supply chain risk management (SCRM) and procurement processes through a multi-layered approach that ensures security is considered at every stage of supplier engagement and management.");
        Thread.sleep(1000);
        
        WebElement section2Input72 = driver.findElement(By.xpath("(//div[@id='question_15876_rte-editable'])[2]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", section2Input72);

        
        WebElement input272 = wait.until(ExpectedConditions.elementToBeClickable(section2Input72));
        input272.sendKeys("This helps ensure we do not introduce vulnerabilities through insecure third-party products or services. Early-stage risk identification reduces the likelihood of downstream cybersecurity issues.");
        Thread.sleep(2000);
        
        
        
        //2.8 
        
        WebElement label28 = wait.until(ExpectedConditions.elementToBeClickable(section2Input8Label));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", label28);
        try {
        	label28.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", label28);
        }

        WebElement section2Input82 = driver.findElement(By.xpath("//div[@id='question_15877_rte-editable']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", section2Input82);

        
        WebElement input282 = wait.until(ExpectedConditions.elementToBeClickable(section2Input82));
        input282.sendKeys("We incorporate cybersecurity clauses in contracts and service-level agreements (SLAs) to ensure suppliers adhere to our security standards.");
        Thread.sleep(1000);
        
        
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Section -2 
	
	
	
	
}
