package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AssessmentPage extends BasePage {
	
	
	private By firstTemplateCellLink = By.xpath("//td[contains(@class, 'e-templatecell')]//a");
	
	// Section 1 Label 
	
	private By input1Label = By.xpath("//button[text()='1.1 ']");
	private By input2Label = By.xpath("//button[text()='1.2 ']");
	private By input3Label = By.xpath("//button[text()='1.3 ']");
	private By input4Label = By.xpath("//button[text()='1.4 ']");
	private By input5Label = By.xpath("//button[text()='1.5 ']");
	private By input6Label = By.xpath("//button[text()='1.6 ']");
	private By input7Label = By.xpath("//button[text()='1.7 ']");
	private By input8Label = By.xpath("//button[text()='1.8 ']");
	
	// Section 1 Input Field
	
	private By  input1 = By.xpath("(//input[@placeholder='Enter your answer'])[1]");
	private By  input2 = By.xpath("(//input[@placeholder='Enter your answer'])[2]"); 
	private By  input3 = By.xpath("(//input[@placeholder='Enter your answer'])[3]");
	private By  input4 = By.xpath("(//input[@placeholder='Enter your answer'])[4]");
	private By  input5 = By.xpath("(//input[@placeholder='Enter your answer'])[5]");
	private By  input6 = By.xpath("//label[normalize-space()='Technology']");
	private By  input7 = By.xpath("//input[@placeholder='Enter number']");
	private By  input8 = By.xpath("//input[@placeholder='Select date']");
	
	// Section 2 Label
	
	private By section2Header      = By.xpath("//span[@class='e-label' and text()='02 - GOVERN (GV)']");
	private By section2Input1Label = By.xpath("//button[text()='2.1 ']");
	private By section2Input2Label = By.xpath("//button[text()='2.2 ']");
	private By section2Input3Label = By.xpath("//button[text()='2.3 ']");
	private By section2Input4Label = By.xpath("//button[text()='2.4 ']");
	private By section2Input5Label = By.xpath("//button[text()='2.5 ']");
	private By section2Input6Label = By.xpath("//button[text()='2.6 ']");
	private By section2Input7Label = By.xpath("//button[text()='2.7 ']");
	private By section2Input8Label = By.xpath("//button[text()='2.8 ']");
	
	// Section 2 Input Field
	
	private By  section2Input1 = By.xpath("//div[@id='question_15870_rte-editable']");
	private By  section2Input2 = By.xpath("//div[@id='question_15871_rte-editable']"); 
	private By  section2Input3 = By.xpath("//div[@id='question_15872_rte-editable']");
	private By  section2Input4 = By.xpath("//div[@id='question_15873_rte-editable']");
	
	private By  section2Input51 = By.xpath("(//div[@id='question_15874_rte-editable'])[1]");
	private By  section2Input52 = By.xpath("(//div[@id='question_15874_rte-editable'])[2]");
	
	private By  section2Input61 = By.xpath("(//div[@id='question_15875_rte-editable'])[1]");
	private By  section2Input62 = By.xpath("(//div[@id='question_15875_rte-editable'])[2]");
	
	private By  section2Input71 = By.xpath("(//div[@id='question_15876_rte-editable'])[1]");
	private By  section2Input72 = By.xpath("(//div[@id='question_15876_rte-editable'])[2]");
	
	private By  section2Input82 = By.xpath("//div[@id='question_15877_rte-editable']");
	
	// Section -3 Label
	
	private By section3Header = By.xpath("//span[@class='e-label' and text()='03 - IDENTIFY (ID)']");
	private By section3Input1Label = By.xpath("//button[text()='3.1 ']");
	private By section3Input2Label = By.xpath("//button[text()='3.2 ']");
	private By section3Input3Label = By.xpath("//button[text()='3.3 ']");
	private By section3Input4Label = By.xpath("//button[text()='3.4 ']");
	private By section3Input5Label = By.xpath("//button[text()='3.5 ']");
	private By section3Input6Label = By.xpath("//button[text()='3.6 ']");
	
	// Section 3 Input Field
	
	private By  section3Input1 = By.xpath("//div[@id='question_15878_rte-editable']");
	private By  section3Input2 = By.xpath("//div[@id='question_15879_rte-editable']");
	private By  section3CheckBox = By.xpath("//label[span[text()='By sensitivity level (Public Internal Confidential Restricted)']]/input[@type='checkbox']");
	private By  section3Input3 = By.xpath("//div[@id='question_15880_rte-editable']");
	private By  section3Input41 = By.xpath("(//div[@id='question_15881_rte-editable'])[1]");
    private By  section3Input42 = By.xpath("(//div[@id='question_15881_rte-editable'])[2]");
    private By  section3Input5 = By.xpath("//div[@id='question_15882_rte-editable']");
    private By  section3Input61 = By.xpath("(//div[@id='question_15883_rte-editable'])[1]");
    private By  section3Input62 = By.xpath("(//div[@id='question_15883_rte-editable'])[2]");
    
    
	// Section -4 Label
	
    private By section4Header = By.xpath("//span[@class='e-label' and text()='04 - PROTECT (PR)']");
    private By section4Input1Label = By.xpath("//button[text()='4.1 ']");
    private By section4Input2Label = By.xpath("//button[text()='4.2 ']");
    private By section4Input3Label = By.xpath("//button[text()='4.3 ']");
    private By section4Input4Label = By.xpath("//button[text()='4.4 ']");
    private By section4Input5Label = By.xpath("//button[text()='4.5 ']");
    private By section4Input6Label = By.xpath("//button[text()='4.6 ']");
    private By section4Input7Label = By.xpath("//button[text()='4.7 ']");
    private By section4Input8Label = By.xpath("//button[text()='4.8 ']");
    private By section4Input9Label = By.xpath("//button[text()='4.9 ']");
    private By section4Input10Label = By.xpath("//button[text()='4.10 ']");
    
	// Section 4 Input Field
	
	private By  section4Input1 = By.xpath("//div[@id='question_15884_rte-editable']");
	private By  section4Input2 = By.xpath("//div[@id='question_15885_rte-editable']");
	private By  section4Input3 = By.xpath("//div[@id='question_15886_rte-editable']");
	private By  section4Input4 = By.xpath("//div[@id='question_15887_rte-editable']");
	private By  section4Input51 = By.xpath("(//div[@id='question_15888_rte-editable'])[1]");
    private By  section4Input52 = By.xpath("(//div[@id='question_15888_rte-editable'])[2]");
    private By  section4Input6 = By.xpath("//div[@id='question_15889_rte-editable']");
    private By  section4Input7 = By.xpath("//div[@id='question_15890_rte-editable']");
    private By  section4Input8 = By.xpath("//div[@id='question_15891_rte-editable']");
    private By  section4Input9 = By.xpath("//div[@id='question_15892_rte-editable']");
    private By  section4Input101 = By.xpath("(//div[@id='question_15893_rte-editable'])[1]");
    private By  section4Input102 = By.xpath("(//div[@id='question_15893_rte-editable'])[2]");
    
    // Section 5 Label 
    
    private By section5Header = By.xpath("//span[@class='e-label' and text()='05 - DETECT (DE)']");
    private By section5Input1Label = By.xpath("//button[text()='5.1 ']");
    private By section5Input2Label = By.xpath("//button[text()='5.2 ']");
    private By section5Input3Label = By.xpath("//button[text()='5.3 ']");
    private By section5Input4Label = By.xpath("//button[text()='5.4 ']");
    private By section5Input5Label = By.xpath("//button[text()='5.5 ']");
    
    // Section 5 Input-field 
    
	private By  section5Input1 = By.xpath("//div[@id='question_15894_rte-editable']");
	private By  section5Input21 = By.xpath("(//div[@id='question_15895_rte-editable'])[1]");
	private By  section5Input22 = By.xpath("(//div[@id='question_15895_rte-editable'])[2]");
	private By  section5Input31 = By.xpath("(//div[@id='question_15896_rte-editable'])[1]");
	private By  section5Input32 = By.xpath("(//div[@id='question_15896_rte-editable'])[2]");
	private By  section5Input4 = By.xpath("//div[@id='question_15897_rte-editable']");
	private By  section5Input5 = By.xpath("//div[@id='question_15898_rte-editable']");
	
	
	// Section 6 Label 
	
	private By section6Header = By.xpath("//span[@class='e-label' and text()='06 - RESPOND (RS)']");
	private By section6Input1Label = By.xpath("//button[text()='6.1 ']");
	private By section6Input2Label = By.xpath("//button[text()='6.2 ']");  
	private By section6Input3Label = By.xpath("//button[text()='6.3 ']");  
	private By section6Input4Label = By.xpath("//button[text()='6.4 ']");
	private By section6Input5Label = By.xpath("//button[text()='6.5 ']");
	private By section6Input6Label = By.xpath("//button[text()='6.6 ']");
	private By section6Input7Label = By.xpath("//button[text()='6.7 ']");
	
	// Section 6 Input-field 
	
	private By section6Input1 = By.xpath("//div[@id='question_15899_rte-editable']");
	private By section6Input22 = By.xpath("//div[@id='question_15900_rte-editable']");
	private By section6Input3 = By.xpath("//div[@id='question_15901_rte-editable']");
	private By section6Input41 = By.xpath("(//div[@id='question_15902_rte-editable'])[1]");
	private By section6Input42 = By.xpath("(//div[@id='question_15902_rte-editable'])[2]");
	private By section6Input5 = By.xpath("//div[@id='question_15903_rte-editable']");
	private By section6Input61 = By.xpath("(//div[@id='question_15904_rte-editable'])[1]");
	private By section6Input62 = By.xpath("(//div[@id='question_15904_rte-editable'])[2]");
	private By section6Input7 = By.xpath("//div[@id='question_15905_rte-editable']");
	
	// Section 7 Label 
	
	private By section7Header = By.xpath("//span[@class='e-label' and text()='07 - RECOVER (RC)']");
	private By section7Input1Label = By.xpath("//button[text()='7.1 ']");
	private By section7Input2Label = By.xpath("//button[text()='7.2 ']");
	private By section7Input3Label = By.xpath("//button[text()='7.3 ']");
	private By section7Input4Label = By.xpath("//button[text()='7.4 ']");
	private By section7Input5Label = By.xpath("//button[text()='7.5 ']");
	
	
	// Section 7 Input-field 
	
	private By section7Input1 = By.xpath("//div[@id='question_15906_rte-editable']");
	private By section7Input2 = By.xpath("//div[@id='question_15907_rte-editable']");
	private By section7Input3 = By.xpath("//div[@id='question_15908_rte-editable']");
	private By section7Input41 = By.xpath("(//div[@id='question_15909_rte-editable'])[1]");
	private By section7Input42 = By.xpath("(//div[@id='question_15909_rte-editable'])[2]");
	private By section7Input51 = By.xpath("(//div[@id='question_15910_rte-editable'])[1]");
	private By section7Input52 = By.xpath("(//div[@id='question_15910_rte-editable'])[2]");
	
	// Section 8 Label 
	
	private By section8Header = By.xpath("//span[@class='e-label' and text()='08 - Assessment Decision']");
	private By completeButton = By.xpath("//button[text()='Complete']");
	
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
		
		WebElement stepLabel = driver.findElement(section2Header);
		String actualText = stepLabel.getText();
		String expectedText = "02 - GOVERN (GV)";
        Assert.assertEquals(actualText, expectedText);

	}
		
	
	// Section -2 
	
	private void clickLabel(By labelLocator) {
	    WebElement label = wait.until(ExpectedConditions.elementToBeClickable(labelLocator));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", label);
	    try {
	        label.click();
	    } catch (ElementClickInterceptedException e) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", label);
	    }
	}

//	private void clickRadio(String value) {
//	    WebElement radio = driver.findElement(By.xpath("//input[@type='radio' and contains(@value,'" + value + "')]"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radio);
//	}
//	
	
	private void clickRadio(String value) {
	    try {
	        // Try 1: Locate radio button input with value and click it via JS
	        WebElement radioInput = driver.findElement(By.xpath("//input[@type='radio' and contains(@value, '" + value + "')]"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioInput);
	        System.out.println("Clicked radio input with value: " + value);
	    } catch (Exception e1) {
	        try {
	            // Try 2: Locate label containing visible text and click it
	            WebElement label = driver.findElement(By.xpath("//label[span[contains(text(), '" + value + "')]]"));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", label);
	            System.out.println("Clicked label with value: " + value);
	        } catch (Exception e2) {
	            System.out.println("Unable to click radio button for value: " + value);
	            e2.printStackTrace();
	        }
	    }
	}

	
	

	private void enterText(By inputLocator, String text) throws InterruptedException {
	    WebElement input = wait.until(ExpectedConditions.elementToBeClickable(inputLocator));
	    input.sendKeys(text);
	    Thread.sleep(1000); // only if truly needed
	}

	private void enterTextWithScroll(By inputLocator, String text) throws InterruptedException {
	    WebElement input = wait.until(ExpectedConditions.elementToBeClickable(inputLocator));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", input);
	    input.sendKeys(text);
	    Thread.sleep(1000);
	}

	
	
	public void section2Answer() throws InterruptedException {

	    // 2.1
	    clickLabel(section2Input1Label);
	    clickRadio("No");
	    enterText(section2Input1, "Currently, our organization does not have a formally documented cybersecurity strategy that explicitly aligns with business objectives.");

	    // 2.2
	    clickLabel(section2Input2Label);
	    clickRadio("Annually");
	    enterText(section2Input2, "Ensure ongoing adherence to updated legal and compliance standards (e.g., GDPR, NIST, ISO 27001).");

	    // 2.3
	    clickLabel(section2Input3Label);
	    clickRadio("No");
	    enterText(section2Input3, "Currently, our organization does not have formal executive-level oversight dedicated to cybersecurity risks.");

	    // 2.4
	    clickLabel(section2Input4Label);
	    clickRadio("No");
	    enterText(section2Input4, "Due to recent organizational changes, our cybersecurity risk management processes are under development.");

	    // 2.5
	    clickLabel(section2Input5Label);
	    enterText(section2Input51, "Our organization determines cybersecurity risk tolerance through collaboration between senior leadership, IT, and business units.");
	    enterTextWithScroll(section2Input52, "While we follow a structured approach, we continuously refine our risk tolerance criteria to align with evolving threats and business goals.");

	    // 2.6
	    clickLabel(section2Input6Label);
	    enterText(section2Input61, "Findings are reviewed quarterly, with improvements prioritized based on risk severity and business impact.");
	    enterTextWithScroll(section2Input62, "This multi-layered approach ensures continuous evaluation of our security posture while aligning with business objectives.");

	    // 2.7
	    clickLabel(section2Input7Label);
	    enterText(section2Input71, "Our organization integrates cybersecurity into supply chain risk management (SCRM) and procurement processes through a multi-layered approach that ensures security is considered at every stage of supplier engagement and management.");
	    enterTextWithScroll(section2Input72, "This helps ensure we do not introduce vulnerabilities through insecure third-party products or services. Early-stage risk identification reduces the likelihood of downstream cybersecurity issues.");

	    // 2.8
	    clickLabel(section2Input8Label);
	    clickRadio("No");
	    enterTextWithScroll(section2Input82, "We incorporate cybersecurity clauses in contracts and service-level agreements (SLAs) to ensure suppliers adhere to our security standards.");
	}

	
	
	// Section -3 
	
	public void section3GetHeader() {
		WebElement stepLabel = driver.findElement(section3Header);
		String actualText = stepLabel.getText();
		String expectedText = "03 - IDENTIFY (ID)";
        Assert.assertEquals(actualText, expectedText);
	}
	
	
	public void section3Answer() throws InterruptedException {
		
	    // 3.1
	    clickLabel(section3Input1Label);
	    clickRadio("Yes");
	    enterText(section3Input1,"Includes multi-cloud assets (AWS/Azure/GCP) tracked via cloud management platforms.");
		
	    // 3.2
	    clickLabel(section3Input2Label);
	    clickRadio("Quarterly");
	    enterText(section3Input2,"Supplemented with real-time cloud asset discovery tools (AWS Config/Azure Inventory) for dynamic environments");
	    
	    //3.3 
	    clickLabel(section3Input3Label);
	    WebElement section3Checkbox = driver.findElement(By.xpath("//label[span[text()='By sensitivity level (Public Internal Confidential Restricted)']]/input[@type='checkbox']"));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", section3Checkbox);
	    enterText(section3Input3,"Restricted - Highly sensitive data requiring strict controls (e.g., trade secrets, health records.");
	    
	    //3.4
	    clickLabel(section3Input4Label);
	    enterText(section3Input41, "Automated Discovery Tools (e.g. ServiceNow CMDB, AWS Config, Azure Resource Graph)");
	    enterTextWithScroll(section3Input42, "Data flow diagrams (DFDs)"); 
	    
	    //3.5
	    clickLabel(section3Input5Label);
	    clickRadio("Monthly");
	    enterText(section3Input5,"Our organization conducts formal cybersecurity risk assessments on a monthly basis to ensure continuous identification and mitigation of emerging threats and vulnerabilities.");
	    
	    //3.6
	    clickLabel(section3Input6Label);
        enterText(section3Input61,"Our organization employs a multi-layered threat identification and analysis process that includes continuous monitoring of network activity, threat intelligence feeds, regular vulnerability assessments, and red team/blue team exercises.");	    
        enterTextWithScroll(section3Input62, "Threat intelligence integration."); 
	    
	}
	
	
	// Section - 4
	public void section4GetHeader() {
		WebElement stepLabel = driver.findElement(section4Header);
		String actualText = stepLabel.getText();
		String expectedText = "04 - PROTECT (PR)";
        Assert.assertEquals(actualText, expectedText);
	}
	
	
	public void section4Answer() throws InterruptedException  {
		
		//4.1 
	    clickLabel(section4Input1Label);
	    clickRadio("Yes");
	    enterText(section4Input1,"Validated annually through [HIPAA/PCI DSS] audits.");
		
		//4.2 
		clickLabel(section4Input2Label);
		clickRadio("No");
		enterText(section4Input2,"Cloud backups include integrity checks (AWS Backup/Azure Site Recovery)");
		
		//4.3 
		clickLabel(section4Input3Label);
	    WebElement section3Checkbox = driver.findElement(By.xpath("//label[span[text()='Web application firewall (WAF)']]/input"));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", section3Checkbox);
	    enterTextWithScroll(section4Input3, "API Protection – Secures REST/SOAP APIs from abusive requests and data scraping."); 
		
		//4.4 
		clickLabel(section4Input4Label);
	    WebElement section4Checkbox = driver.findElement(By.xpath("//label[span[text()='Single sign-on (SSO)']]/input"));
	    JavascriptExecutor js1 = (JavascriptExecutor) driver;
	    js1.executeScript("arguments[0].click();", section4Checkbox);
	    enterTextWithScroll(section4Input4, "Enforces MFA (Multi-Factor Authentication) uniformly across all applications"); 
		
		
		//4.5 
	    clickLabel(section4Input5Label);
	    enterText(section4Input51, "Our organization manages privileged account access through a structured and well-documented identity and access management (IAM) process");
	    enterTextWithScroll(section4Input52, "We follow a role-based access control (RBAC) model where privileged accounts are only granted to authorized personnel based on job roles and responsibilities");
		
		
		//4.6 
		clickLabel(section4Input6Label);
	    clickRadio("Monthly");
	    enterText(section4Input6,"We conduct user access reviews on a monthly basis to ensure timely identification and correction of any inappropriate or outdated access.");
		
		
		//4.7 
		clickLabel(section4Input7Label);
	    clickRadio("Upon hiring only");
	    enterText(section4Input7,"Our organization performs access rights reviews at the time of hiring to ensure that each new employee is granted access strictly based on their role and responsibilities.");
		
		//4.8 
		clickLabel(section4Input8Label);
	    clickRadio("No");
	    enterText(section4Input8,"Currently, our organization does not conduct phishing simulation exercises. However, we recognize the importance of such initiatives in strengthening our human firewall and increasing employee awareness of social engineering threats.");
		
		//4.9
		clickLabel(section4Input9Label);
	    WebElement section9Checkbox = driver.findElement(By.xpath("//label[span[text()='Data backup and recovery']]/input"));
	    JavascriptExecutor js2 = (JavascriptExecutor) driver;
	    js1.executeScript("arguments[0].click();", section9Checkbox);
	    enterTextWithScroll(section4Input9, "Frequency: Critical data backed up [daily/hourly], non-critical data [weekly]");
		
		//4.10
	    clickLabel(section4Input10Label);
	    enterText(section4Input101, "Our organization follows a formal, documented process for secure end-of-life data and equipment disposal to prevent data breaches and comply with regulatory requirements.");
	    enterTextWithScroll(section4Input102, "Use NIST 800-88-compliant tools (e.g., Blancco/DBAN) for cryptographic erasure or physical destruction.");
		
		
	}
	
	
	// Section -5 
	
	public void section5GetHeader() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section5Header));
		WebElement stepLabel = driver.findElement(section5Header);
		String actualText = stepLabel.getText();
		String expectedText = "05 - DETECT (DE)";
        Assert.assertEquals(actualText, expectedText);
	}
	
	
	public void section5Answer() throws InterruptedException {
		
		//5.1 
	    clickLabel(section5Input1Label);
	    clickRadio("Yes");
	    enterText(section5Input1,"Cloud Data: Cryptographic erasure with provider tools (AWS/Azure/GCP) + deletion audits.");
		
		//5.2
	    clickLabel(section5Input2Label);
	    enterText(section5Input21,"Our organization correlates security events across systems and networks using a combination of SIEM (Security Information and Event Management) tools, threat intelligence feeds, and rule-based analytics to detect and respond to multi-stage attacks.");
	    enterTextWithScroll(section5Input22,"Aggregates logs from endpoints, firewalls, IDS/IPS, cloud services, and applications.");
	
	
		//5.3
	    clickLabel(section5Input3Label);
	    enterText(section5Input31,"Our organization establishes baselines of normal activity through continuous monitoring, machine learning, and behavioral analysis to detect anomalies and potential threats effectively.");
	    enterTextWithScroll(section5Input32,"Network traffic logs, endpoint activities, authentication attempts, and application behaviors.");
		
	
		//5.4
	    clickLabel(section5Input4Label);
	    WebElement section5Checkbox4 = driver.findElement(By.xpath("//label[span[text()='Unauthorized mobile code detection']]/input"));
	    JavascriptExecutor js1 = (JavascriptExecutor) driver;
	    js1.executeScript("arguments[0].click();", section5Checkbox4);
	    enterText(section5Input4,"our organization implements unauthorized mobile code detection to mitigate risks from untrusted scripts, macros, or applets that could compromise systems.");
	
	    
		//5.5
	    clickLabel(section5Input5Label);
	    clickRadio("Annually");
	    enterText(section5Input5,"Blocks malicious mobile code (e.g., JavaScript, Flash, Java applets) from executing in unauthorized contexts.");
	    Thread.sleep(2000);
	    
	}
	
	
	public void section6GetHeader() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section6Header));
		WebElement stepLabel = driver.findElement(section6Header);
		String actualText = stepLabel.getText();
		String expectedText = "06 - RESPOND (RS)";
        Assert.assertEquals(actualText, expectedText);
		
		
	}
	
	public void section6Answer() throws InterruptedException {
		
		//6.1 
	    clickLabel(section6Input1Label);
	    clickRadio("Yes");
	    enterText(section6Input1,"Detects and blocks unauthorized mobile code (e.g., JavaScript, Java applets, Flash, or suspicious macros) that could exploit systems.");
	    
		//6.2 
	    clickLabel(section6Input2Label);
	    WebElement dateInput61 = driver.findElement(By.xpath("//input[@placeholder='Select date']"));
//	    dateInput61.clear();
	    dateInput61.sendKeys("06/15/2025");
	    enterText(section6Input22,"Reflects an upcoming audit, policy update, or system upgrade");
	    
		//6.3 
	    clickLabel(section6Input3Label);
	    clickRadio("Semi-annually");
	    enterText(section6Input3,"Our organization conducts semi-annual testing of the Incident Response (IR) Plan to maintain readiness, validate procedures, and adapt to evolving threats.");
	    
		//6.4 
	    clickLabel(section6Input4Label);
	    enterText(section6Input41,"Our organization follows a structured and well-documented incident response plan that includes coordination with both internal and external stakeholders.");
	    enterTextWithScroll(section6Input42,"This approach ensures that incident response is handled effectively and collaboratively, minimizing the impact on operations and reputation.");
	    
	    
		//6.5 
	    clickLabel(section6Input5Label);
	    WebElement section6Checkbox5 = driver.findElement(By.xpath("//label[span[text()='Root cause analysis']]/input"));
	    JavascriptExecutor js1 = (JavascriptExecutor) driver;
	    js1.executeScript("arguments[0].click();", section6Checkbox5);
	    enterText(section6Input5,"");
	    
		//6.6 
	    clickLabel(section6Input6Label);
	    enterText(section6Input61,"Our organization employs a proactive and structured vulnerability management process. Once a new vulnerability is identified—either through automated scanning tools, threat intelligence feeds, or responsible disclosures—it is logged and assessed based on severity, asset criticality, and potential impact.");
	    enterTextWithScroll(section6Input62,"This process ensures that vulnerabilities are systematically identified, prioritized based on risk, and resolved in a timely manner.");
	    
		//6.7 
	    clickLabel(section6Input7Label);
	    clickRadio("Yes");
	    enterText(section6Input7,"Our organization conducts thorough post-incident reviews after every significant security event.");
		
	}
	
	public void section7GetHeader() {
		WebElement stepLabel = driver.findElement(section7Header);
		String actualText = stepLabel.getText();
		String expectedText = "07 - RECOVER (RC)";
        Assert.assertEquals(actualText, expectedText);
		
	}
	
	public void section7Answer() throws InterruptedException {
		
		//7.1 
	    clickLabel(section7Input1Label);
	    clickRadio("Yes");
	    enterText(section7Input1,"Our organization has implemented a comprehensive risk management program to identify, assess, and mitigate security risks in alignment with industry best practices and compliance requirements");
	    
	    //7.2
	    clickLabel(section7Input2Label);
        clickRadio("Quarterly");
        enterText(section7Input2,"Our organization tests recovery plans on a quarterly basis to ensure their effectiveness and alignment with evolving business needs and threat landscapes.");
        
	    //7.3
	    clickLabel(section7Input3Label);
        clickRadio("Within 72 hours");
        enterText(section7Input3,"Our organization's Recovery Time Objective (RTO) for critical systems is set to within 72 hours to ensure a balance between operational continuity and resource allocation.");
        
	    //7.4
	    clickLabel(section7Input4Label);
        enterText(section7Input41,"Our organization actively incorporates lessons learned from previous incidents, recovery tests, and tabletop exercises into our recovery planning through a structured continuous improvement process");
        enterTextWithScroll(section7Input42,"Findings from these reviews are documented and tracked through an action plan, which is reviewed periodically by the risk management and IT continuity teams");
        
	    //7.5
	    clickLabel(section7Input5Label);
        enterText(section7Input51,"Our organization follows a structured public relations and communications strategy during the recovery phase of security incidents to maintain transparency, protect our reputation, and build stakeholder trust.");
        enterTextWithScroll(section7Input52,"We also conduct media training for key spokespersons and maintain pre-approved communication templates to enable rapid response.");
	   
		
	}
	
	public void section8GetHeader() {
		WebElement stepLabel = driver.findElement(section8Header);
		String actualText = stepLabel.getText();
		String expectedText = "08 - Assessment Decision";
        Assert.assertEquals(actualText, expectedText);		
	}
	
	public void completeAssessment() throws InterruptedException {
		WebElement completeButton = driver.findElement(By.xpath("//button[text()='Complete']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",completeButton);
		Thread.sleep(1000);
		completeButton.click();
	}
	
	
	
}
