package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AssessmentPage extends BasePage {
	
    private By templateCell = By.xpath("//td[contains(@class, 'e-templatecell')]//div[contains(text(),'FlyingQA_20250610104322 Verisq TPRM-NIST-CSF-2-0 Autoscored')]");
    private By loader = By.cssSelector("div.loader-page-section");
    
    // Section 1 Locators
    
    private By[] inputLabels = {
        By.xpath("(//label[text()='1.1 '])[1]"),
        By.xpath("(//label[text()='1.2 '])[1]"),
        By.xpath("(//label[text()='1.3 '])[1]"),
        By.xpath("(//label[text()='1.4 '])[1]"),
        By.xpath("(//label[text()='1.5 '])[1]"),
        By.xpath("(//label[text()='1.6 '])[1]"),
        By.xpath("(//label[text()='1.7 '])[1]"),
        By.xpath("(//label[text()='1.8 '])[1]")
    };
    
    private By[] answerFields = {
        By.xpath("(//input[@aria-label='textbox' and @placeholder='Enter your answer'])[1]"),
        By.xpath("(//input[@aria-label='textbox' and @placeholder='Enter your answer'])[2]"),
        By.xpath("(//input[@aria-label='textbox' and @placeholder='Enter your answer'])[3]"),
        By.xpath("(//input[@aria-label='textbox' and @placeholder='Enter your answer'])[4]"),
        By.xpath("(//input[@aria-label='textbox' and @placeholder='Enter your answer'])[5]"),
        By.xpath("//label[span[normalize-space(text())='Education']]"), // Radio button
        By.xpath("//input[@class='e-control e-numerictextbox e-lib e-input' and @placeholder='Enter number']"),
        By.xpath("//input[@class='e-control e-datepicker e-lib e-input e-keyboard' and @placeholder='Select date']")
    };
    
    private By[] commentFields = {
        By.xpath("(//div[@class='e-content' and @contenteditable='true'])[1]"),
        By.xpath("(//div[@class='e-content' and @contenteditable='true'])[3]"),
        By.xpath("(//div[@class='e-content' and @contenteditable='true'])[5]"),
        By.xpath("(//div[@class='e-content' and @contenteditable='true'])[7]"),
        By.xpath("(//div[@class='e-content' and @contenteditable='true'])[9]"),
        By.xpath("(//div[@class='e-content' and @contenteditable='true'])[11]"),
        By.xpath("(//div[@class='e-content' and @contenteditable='true'])[13]"),
        By.xpath("(//div[@class='e-content' and @contenteditable='true'])[15]")
    };
    
    private By[] justificationFields = {
        By.xpath("(//div[@class='e-content' and @contenteditable='true'])[2]"),
        By.xpath("(//div[@class='e-content' and @contenteditable='true'])[4]"),
        By.xpath("(//div[@class='e-content' and @contenteditable='true'])[6]"),
        By.xpath("(//div[@class='e-content' and @contenteditable='true'])[8]"),
        By.xpath("(//div[@class='e-content' and @contenteditable='true'])[10]"),
        By.xpath("(//div[@class='e-content' and @contenteditable='true'])[12]"),
        By.xpath("(//div[@class='e-content' and @contenteditable='true'])[14]"),
        By.xpath("(//div[@class='e-content' and @contenteditable='true'])[16]")
    };
    
    private int[] commentCountXpathIndices = {1, 5, 9, 13, 17, 21, 25, 29};
    
    private String[] defaultAnswers = {
        "Narola Infotech",
        "Darshak",
        "darshak143@yopmail.com",
        "8866180955",
        "https://www.narolainfotech.com",
        null, // Radio button - handled differently
        "2",
        "12/31/2025"
    };
    
    private String[] defaultComments = {
        "Initial assessment comment for Narola Infotech",
        "Comment for Section 1.2",
        "Comment for Section 1.3",
        "Comment for Section 1.4",
        "Comment for Section 1.5",
        "Comment for Section 1.6",
        "Comment for Section 1.7",
        "Comment for Section 1.8"
    };
    
    private String[] defaultJustifications = {
        "Narola Infotech has demonstrated consistent expertise in delivering a wide range of technology services, including custom software development, mobile and web application solutions, and enterprise-grade systems.",
        "Darshak Paladiya has in-depth knowledge...",
        "This email address ensures that....",
        "The phone number 8866180955 is provided as...",
        "This website serves as a verified source...",
        "The Education industry best represents...",
        "This number reflects the current staffing...",
        "This date represent the assessment performance date..."
    };
	
    
	
	// Section 2 Label
	
	private By section2Header = By.xpath("//span[@class='e-label' and text()='GOVERN (GV)']");
	private By section2input1Label =By.xpath("(//label[text()='2.1 '])[1]") ;
	private By section2input2Label =By.xpath("(//label[text()='2.2 '])[1]") ;
	private By section2input3Label =By.xpath("(//label[text()='2.3 '])[1]") ;
	private By section2input4Label =By.xpath("(//label[text()='2.4 '])[1]") ;
	private By section2input5Label =By.xpath("(//label[text()='2.5 '])[1]") ;
	private By section2input6Label =By.xpath("(//label[text()='2.6 '])[1]") ;
	private By section2input7Label =By.xpath("(//label[text()='2.7 '])[1]") ;
	private By section2input8Label =By.xpath("(//label[text()='2.8 '])[1]") ;
	
	// Section 2 Input
	
	private By section2Input1Radio = By.xpath("(//label[span[text()='No']])[1]");
	private By section2Input1Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[1]");
	private By section2Input1Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[2]");
	
	private By section2Input2Radio = By.xpath("//span[normalize-space(text())='Annually']");
	private By section2Input2Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[3]");
	private By section2Input2Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[4]");

	private By section2Input3Radio = By.xpath("(//label[span[text()='No']])[2]");
	private By section2Input3Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[5]");
	private By section2Input3Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[6]");

	private By section2Input4Radio = By.xpath("(//label[span[text()='No']])[3]");
	private By section2Input4Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[7]");
	private By section2Input4Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[8]");
	
	private By section2Input5Answer = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[9]");
	private By section2Input5Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[10]");
	private By section2Input5Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[11]");

	private By section2Input6Answer = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[12]");
	private By section2Input6Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[13]");
	private By section2Input6Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[14]");

	private By section2Input7Answer = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[15]");
	private By section2Input7Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[16]");
	private By section2Input7Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[17]");

	private By section2Input8Radio = By.xpath("(//label[span[text()='No']])[4]");
	private By section2Input8Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[18]");
	private By section2Input8Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[19]");
	
	// Section 3 Label
	
	private By section3Header = By.xpath("//span[@class='e-label' and text()='IDENTIFY (ID)']");
	private By section3input1Label =By.xpath("(//label[text()='3.1 '])[1]") ;
	private By section3input2Label =By.xpath("(//label[text()='3.2 '])[1]") ;
	private By section3input3Label =By.xpath("(//label[text()='3.3 '])[1]") ;
	private By section3input4Label =By.xpath("(//label[text()='3.4 '])[1]") ;
	private By section3input5Label =By.xpath("(//label[text()='3.5 '])[1]") ;
	private By section3input6Label =By.xpath("(//label[text()='3.6 '])[1]") ;
	
	// Section 3 Input
	
	private By section3Input1Radio = By.xpath("(//label[span[text()='No']])[1]");
	private By section3Input1Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[1]");
	private By section3Input1Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[2]");
	
	private By section3Input2Radio = By.xpath("(//label[normalize-space(.)='Annually' ])[1]");
	private By section3Input2Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[3]");
	private By section3Input2Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[4]");

	private By section3Input3CheckBox = By.xpath("//label[span[normalize-space(text())='By business impact']]/span[contains(@class, 'e-frame')]");
	private By section3Input3Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[5]");
	private By section3Input3Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[6]");
	
	private By section3Input4Answer = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[7]");
	private By section3Input4Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[8]");
	private By section3Input4Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[9]");
	
	private By section3Input5Radio = By.xpath("(//label[normalize-space(.)='Annually' ])[2]");
	private By section3Input5Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[10]");
	private By section3Input5Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[11]");
	
	private By section3Input6Answer = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[12]");
	private By section3Input6Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[13]");
	private By section3Input6Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[14]");
	
	// Section 4 Label
	
	private By section4Header = By.xpath("//span[@class='e-label' and text()='PROTECT (PR)']");
	private By section4input1Label =By.xpath("(//label[text()='4.1 '])[1]") ;
	private By section4input2Label =By.xpath("(//label[text()='4.2 '])[1]") ;
	private By section4input3Label =By.xpath("(//label[text()='4.3 '])[1]") ;
	private By section4input4Label =By.xpath("(//label[text()='4.4 '])[1]") ;
	private By section4input5Label =By.xpath("(//label[text()='4.5 '])[1]") ;
	private By section4input6Label =By.xpath("(//label[text()='4.6 '])[1]") ;
	private By section4input7Label =By.xpath("(//label[text()='4.7 '])[1]") ;
	private By section4input8Label =By.xpath("(//label[text()='4.8 '])[1]") ;
	private By section4input9Label =By.xpath("(//label[text()='4.9 '])[1]") ;
	private By section4input10Label =By.xpath("(//label[text()='4.10 '])[1]") ;
		
	// Section 4 Input
	
	private By section4Input1Radio = By.xpath("(//label[span[text()='Yes']])[1]");
	private By section4Input1Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[1]");
	private By section4Input1Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[2]");
	
	private By section4Input2Radio = By.xpath("(//label[normalize-space(.)='Annually' ])[1]");
	private By section4Input2Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[3]");
	private By section4Input2Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[4]");
	
	private By section4Input3CheckBox = By.xpath("//label[span[@class='e-label' and normalize-space(text())='Web application firewall (WAF)']]");
	private By section4Input3Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[5]");
	private By section4Input3Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[6]");
	
	private By section4Input4CheckBox = By.xpath("//label[span[@class='e-label' and normalize-space(text())='Mandatory access control (MAC)']]");
	private By section4Input4Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[7]");
	private By section4Input4Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[8]");
	
	private By section4Input5Answer = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[9]");
	private By section4Input5Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[10]");
	private By section4Input5Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[11]");
	
	private By section4Input6Radio = By.xpath("(//label[normalize-space(.)='Annually' ])[2]");
	private By section4Input6Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[12]");
	private By section4Input6Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[13]");
	
	private By section4Input7Radio = By.xpath("(//label[normalize-space(.)='Monthly'])[3]");
	private By section4Input7Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[14]");
	private By section4Input7Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[15]");
	
	private By section4Input8Radio = By.xpath("(//label[span[text()='Yes']])[2]");
	private By section4Input8Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[16]");
	private By section4Input8Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[17]");
	
	private By section4Input9CheckBox = By.xpath("//label[span[@class='e-label' and normalize-space(text())='Database activity monitoring']]");
	private By section4Input9Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[18]");
	private By section4Input9Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[19]");
	
	private By section4Input10Answer = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[20]");
	private By section4Input10Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[21]");
	private By section4Input10Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[22]");
	
	// Section 5 Label
	
	private By section5Header = By.xpath("//span[@class='e-label' and text()='DETECT (DE)']");
	private By section5input1Label =By.xpath("(//label[text()='5.1 '])[1]") ;
	private By section5input2Label =By.xpath("(//label[text()='5.2 '])[1]") ;
	private By section5input3Label =By.xpath("(//label[text()='5.3 '])[1]") ;
	private By section5input4Label =By.xpath("(//label[text()='5.4 '])[1]") ;
	private By section5input5Label =By.xpath("(//label[text()='5.5 '])[1]") ;
	
	// Section 5 Input
	
	private By section5Input1Radio = By.xpath("(//label[span[text()='Yes']])[1]");
	private By section5Input1Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[1]");
	private By section5Input1Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[2]");

	private By section5Input2Answer = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[3]");
	private By section5Input2Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[4]");
	private By section5Input2Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[5]");
	
	private By section5Input3Answer = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[6]");
	private By section5Input3Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[7]");
	private By section5Input3Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[8]");
	
	private By section5Input4CheckBox = By.xpath("//label[.//span[@class='e-label' and normalize-space(text())='Malicious code detection']]");
	private By section5Input4Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[9]");
	private By section5Input4Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[10]");
	
	private By section5Input5Radio = By.xpath("//label[normalize-space(.)='Annually' ]");
	private By section5Input5Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[11]");
	private By section5Input5Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[12]");
	
	// Section 6 Label
	
	private By section6Header = By.xpath("//span[@class='e-label' and text()='RESPOND (RS)']");
	private By section6input1Label =By.xpath("(//label[text()='6.1 '])[1]") ;
	private By section6input2Label =By.xpath("(//label[text()='6.2 '])[1]") ;
	private By section6input3Label =By.xpath("(//label[text()='6.3 '])[1]") ;
	private By section6input4Label =By.xpath("(//label[text()='6.4 '])[1]") ;
	private By section6input5Label =By.xpath("(//label[text()='6.5 '])[1]") ;
	private By section6input6Label =By.xpath("(//label[text()='6.6 '])[1]") ;
	private By section6input7Label =By.xpath("(//label[text()='6.7 '])[1]") ;
	
	// Section 6 Input 
	
	private By section6Input1Radio = By.xpath("(//label[span[text()='Yes']])[1]");
	private By section6Input1Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[1]");
	private By section6Input1Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[2]");
	
	private By section6Input2DatePicker = By.xpath("//input[@placeholder='Select date' and @aria-label='datepicker']");
	private By section6Input2Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[3]");
	private By section6Input2Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[4]");
	
	private By section6Input3Radio = By.xpath("//label[normalize-space(.)='Annually' ]");
	private By section6Input3Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[5]");
	private By section6Input3Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[6]");
	
	private By section6Input4Answer = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[7]");
	private By section6Input4Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[8]");
	private By section6Input4Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[9]");
	
	private By section6Input5CheckBox = By.xpath("//label[span[@class='e-label' and normalize-space(text())='Threat intelligence integration']]");
	private By section6Input5Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[10]");
	private By section6Input5Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[11]");
	
	private By section6Input6Answer = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[12]");
	private By section6Input6Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[13]");
	private By section6Input6Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[14]");
	
	private By section6Input7Radio = By.xpath("(//label[span[text()='No']])[2]");
	private By section6Input7Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[15]");
	private By section6Input7Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[16]");
	
	// Section 7 Label
	
	private By section7Header = By.xpath("//span[@class='e-label' and text()='RECOVER (RC)']");
	private By section7input1Label =By.xpath("(//label[text()='7.1 '])[1]") ;
	private By section7input2Label =By.xpath("(//label[text()='7.2 '])[1]") ;
	private By section7input3Label =By.xpath("(//label[text()='7.3 '])[1]") ;
	private By section7input4Label =By.xpath("(//label[text()='7.4 '])[1]") ;
	private By section7input5Label =By.xpath("(//label[text()='7.5 '])[1]") ;
	
	// Section 7 Input 
	
	private By section7Input1Radio = By.xpath("(//label[span[text()='Yes']])[1]");
	private By section7Input1Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[1]");
	private By section7Input1Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[2]");

	private By section7Input2Radio = By.xpath("//label[normalize-space(.)='Quarterly' ]");
	private By section7Input2Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[3]");
	private By section7Input2Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[4]");

	private By section7Input3Radio = By.xpath("//label[normalize-space(.)='Within 24 hours' ]");
	private By section7Input3Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[5]");
	private By section7Input3Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[6]");
	
	private By section7Input4Answer = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[7]");
	private By section7Input4Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[8]");
	private By section7Input4Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[9]");
	
	private By section7Input5Answer = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[10]");
	private By section7Input5Comment = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[11]");
	private By section7Input5Justification = By.xpath("(//div[@class='e-content' and @contenteditable='true'])[12]");
	
	// Section -8 
	
	private By section8Header = By.xpath("//span[@class='e-label' and text()='Assessment Decision']");
	
	
	public AssessmentPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
			
	 public void clickOnDefaultAssessment() {
	        WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(templateCell));
	        scrollAndClick(linkElement);
	    }

	    public void getWaitForResponder() throws InterruptedException {
	        WebElement state = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Waiting Responder']")));
	        System.out.println(state.getText());
	    }
	    
	    public void section1Answer() throws InterruptedException {
	        for (int i = 0; i < inputLabels.length; i++) {
	            fillSection(
	                i + 1, 
	                inputLabels[i], 
	                answerFields[i], 
	                commentFields[i], 
	                justificationFields[i], 
	                commentCountXpathIndices[i],
	                defaultAnswers[i],
	                defaultComments[i],
	                defaultJustifications[i],
	                i == 5 // isRadioButton
	            );
	        }
	    }
	    
	    private void fillSection(
	        int sectionNumber,
	        By labelLocator,
	        By answerLocator,
	        By commentLocator,
	        By justificationLocator,
	        int commentCountIndex,
	        String defaultAnswer,
	        String defaultComment,
	        String defaultJustification,
	        boolean isRadioButton
	    ) throws InterruptedException {
	        // Click the section label
	        WebElement label = wait.until(ExpectedConditions.elementToBeClickable(labelLocator));
	        scrollAndClick(label);
	        Thread.sleep(1000);
	        
	        // Handle answer field
	        if (!isRadioButton) {
	            handleInputField(answerLocator, defaultAnswer);
	        } else {
	            // Special handling for radio button
	            WebElement radioButton = wait.until(ExpectedConditions.elementToBeClickable(answerLocator));
	            scrollAndClick(radioButton);
	            wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
	        }
	        
	        // Handle comment
	        handleCommentField(commentLocator, commentCountIndex, defaultComment,sectionNumber);
	        
	        // Handle justification
	        handleJustificationField(justificationLocator, defaultJustification,sectionNumber);
	        
	        System.out.println("✔ Completed section 1." + sectionNumber);
	    }
	    
	    private void handleInputField(By locator, String defaultValue) throws InterruptedException {
	        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	        scrollIntoView(field);
	        
	        String currentValue = (String) ((JavascriptExecutor) driver).executeScript(
	            "return arguments[0].value || arguments[0].getAttribute('value');", 
	            field
	        );
	        
	        if (currentValue == null || currentValue.trim().isEmpty()) {
	            field.sendKeys(defaultValue);
	            Thread.sleep(500);
	        }
	    }
	    
	    private void handleCommentField(By locator, int commentCountIndex, String defaultComment ,int sectionNumber) throws InterruptedException {
	        By commentCountLocator = By.xpath(
	            "(//div[@class='button-list-right']//span[@class='item-count-design'])[" + commentCountIndex + "]"
	        );
	        
	        WebElement commentCountElement = wait.until(ExpectedConditions.presenceOfElementLocated(commentCountLocator));
	        int commentCount = getCommentCount(commentCountElement);
	        
	        WebElement commentField = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	        scrollIntoView(commentField);
	        
	        String currentComment = commentField.getText().trim();
	        System.out.println("Section 1." + sectionNumber + " - Comment Count: " + commentCount);

	        if (!currentComment.isEmpty()) {
	            System.out.println("Section 1." + sectionNumber + " - Existing Comment: " + currentComment);
	        } else {
	            commentField.sendKeys(defaultComment);
	            System.out.println("Section 1." + sectionNumber + " - New Comment Added: " + defaultComment);
	            Thread.sleep(1000);
	            wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
	        }
	        
	    }
	    
	    private void handleJustificationField(By locator, String defaultValue,int sectionNumber) throws InterruptedException {
	        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	        scrollIntoView(field);
	        
	        String existingValue = (String) ((JavascriptExecutor) driver).executeScript(
	                "return arguments[0].innerText;", field);
	        
	        existingValue = existingValue == null ? "" : existingValue.trim();

	        if (!existingValue.isEmpty()) {
	            System.out.println("Section 1." + sectionNumber + " - Existing Justification (trimmed): " + existingValue);
	            ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = '';", field);
	            Thread.sleep(1000); // Wait after clearing

	        }
	        field.sendKeys(defaultValue);
	        System.out.println("Section 1." + sectionNumber + " - New Justification Added: " + defaultValue);

	        Thread.sleep(1000); // Wait after sending input
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
	        
	    }
	    
	    private int getCommentCount(WebElement element) {
	        try {
	            String countText = element.getText().trim();
	            return countText.isEmpty() ? 0 : Integer.parseInt(countText);
	        } catch (NumberFormatException e) {
	            return 0;
	        }
	    }
	    
	    private void scrollIntoView(WebElement element) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	    }
	    
	    private void scrollAndClick(WebElement element) {
	        scrollIntoView(element);
	        try {
	            element.click();
	        } catch (ElementClickInterceptedException e) {
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	        }
	    }
	
		

	
	public void nextBtn() throws InterruptedException {
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
        WebElement nextButton = driver.findElement(By.id("nextStep"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);

        try {
            Thread.sleep(500); // wait 0.5 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        nextButton.click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
	}
	
	public void section2Header() {
		String expectedHeader = "GOVERN (GV)";
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section2Header));
		String actualHeader = driver.findElement(section2Header).getText();
		System.out.println(actualHeader);
		Assert.assertEquals(actualHeader,expectedHeader);
	}
	
	public void section2Answer() throws InterruptedException {
		
		// === SECTION 2.1 ===
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section2input1Label));
	    WebElement section2Label1 = driver.findElement(section2input1Label);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section2Label1);
	    section2Label1.click();
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(section2Input1Radio));
	    
	    WebElement radio1Element = driver.findElement(section2Input1Radio);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView({block: 'center'});", radio1Element);
	    js.executeScript("arguments[0].click();", radio1Element);
	    
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

	    WebElement comment1CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[1]")
	    ));

	    int comment1Count = Integer.parseInt(comment1CountElement.getText().trim());
	    System.out.println(comment1Count);
	    Thread.sleep(2000);
	    
	    WebElement input1Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section2Input1Comment));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input1Comment);
	    
	    if (comment1Count > 0) {
	        String existingComment = input1Comment.getText();
	        System.out.println("Existing Comment: " + existingComment);
	    } else {
	        String newComment = "Our cybersecurity strategy is formally documented and closely aligned with our business goals.";
	        input1Comment.sendKeys(newComment);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
	        System.out.println("Added new comment in section 2.1 : " + newComment);
	    }
	    
	    
	    WebElement input1Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section2Input1Justification));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input1Justification);
	    	    	    
	    String justificationValue = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim();", input1Justification);
	    System.out.println("Justification (cleaned): '" + justificationValue + "'");


	    if (justificationValue == null || justificationValue.isEmpty()) {
	        String justification1Text = "Our organization has developed a comprehensive cybersecurity strategy that is formally documented and reviewed regularly.";
	        
	        ((JavascriptExecutor) driver).executeScript(
	                "arguments[0].innerText = arguments[1];", input1Justification, justification1Text);	   
	        
	        
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		    System.out.println("Added justification in section 2.1 : " + justification1Text);
	    }
	    
	    
		// === SECTION 2.2 ===
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section2input2Label));
	    WebElement section2Label2 = driver.findElement(section2input2Label);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section2Label2);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section2Label2);
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(section2Input2Radio));
	    
	    WebElement radio2Element = driver.findElement(section2Input2Radio);
	    JavascriptExecutor js2 = (JavascriptExecutor) driver;
	    js2.executeScript("arguments[0].scrollIntoView({block: 'center'});", radio2Element);
	    js2.executeScript("arguments[0].click();", radio2Element);
	    
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

	    WebElement comment2CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[5]")
	    ));

	    int comment2Count = Integer.parseInt(comment2CountElement.getText().trim());
	    System.out.println(comment2Count);
	    Thread.sleep(2000);
	    
	    WebElement input2Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section2Input2Comment));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input2Comment);
	    
	    if (comment2Count > 0) {
	        String existingComment = input2Comment.getText();
	        System.out.println("Existing Comment: " + existingComment);
	    } else {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(section2Input2Comment));
	        String newComment = "Annual review aligns with industry best practices and regulatory requirements.";
	        input2Comment.sendKeys(newComment);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
	        System.out.println("Added new comment in section 2.2 : " + newComment);
	    }
	    
	    
	    WebElement input2Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section2Input2Justification));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input2Justification);
	    	    	    
	    String justification2Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim();", input2Justification);
	    System.out.println("Justification (cleaned): '" + justification2Value + "'");


	    if (justification2Value == null || justification2Value.isEmpty()) {
	    	
	        String justification2Text = "Annual ensures consistent evaluation while meeting compliance standards (ISO 27001, NIST CSF) and adapting to emerging threats.";
	        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input2Justification, justification2Text);
		    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		    
		    System.out.println("Added justification in section 2.2 : " + justification2Text);
	    }
	    
	   
		// === SECTION 2.3 ===
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section2input3Label));
	    WebElement section2Label3 = driver.findElement(section2input3Label);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section2Label3);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section2Label3);
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(section2Input3Radio));
	    
	    WebElement radio3Element = driver.findElement(section2Input3Radio);
	    JavascriptExecutor js3 = (JavascriptExecutor) driver;
	    js3.executeScript("arguments[0].scrollIntoView({block: 'center'});", radio3Element);
	    js3.executeScript("arguments[0].click();", radio3Element);
	    
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

	    WebElement comment3CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[9]")
	    ));

	    int comment3Count = Integer.parseInt(comment3CountElement.getText().trim());
	    System.out.println(comment3Count);
	    Thread.sleep(2000);
	    
	    WebElement input3Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section2Input3Comment));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input3Comment);
	    
	    if (comment3Count > 0) {
	        String existingComment = input3Comment.getText();
	        System.out.println("Existing Comment: " + existingComment);
	    } else {	    	
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(section2Input3Comment));
	        String newComment = "At present, the organization has not established executive-level oversight for cybersecurity.";
	        input3Comment.sendKeys(newComment);
	        Thread.sleep(1000);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
	        System.out.println("Added new comment in section 2.3 : " + newComment);
	    }
	    
	    
	    WebElement input3Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section2Input3Justification));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input3Justification);
	    	    	    
	    String justification3Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim();", input3Justification);
	    System.out.println("Justification (cleaned): '" + justification3Value + "'");


	    if (justification3Value == null || justification3Value.isEmpty()) {
	    		    	
	        String justification3Text = "Currently, there is no dedicated executive role overseeing cybersecurity risks.";
	        
	        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input3Justification, justification3Text);
	        
		    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		    System.out.println("Added justification in section 2.3 : " + justification3Text);
	    }
	    
	    
		// === SECTION 2.4 ===
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section2input4Label));
	    WebElement section2Label4 = driver.findElement(section2input4Label);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section2Label4);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section2Label4);

	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(section2Input4Radio));
	    
	    WebElement radio4Element = driver.findElement(section2Input4Radio);
	    JavascriptExecutor js4 = (JavascriptExecutor) driver;
	    js4.executeScript("arguments[0].scrollIntoView({block: 'center'});", radio4Element);
	    js4.executeScript("arguments[0].click();", radio4Element);
	    
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

	    WebElement comment4CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[13]")
	    ));

	    int comment4Count = Integer.parseInt(comment4CountElement.getText().trim());
	    System.out.println(comment4Count);
	    Thread.sleep(2000);
	    
	    WebElement input4Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section2Input4Comment));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input4Comment);
	    
	    if (comment4Count > 0) {
	        String existingComment = input4Comment.getText();
	        System.out.println("Existing Comment: " + existingComment);
	    } else {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(section2Input4Comment));
	        String newComment = "A structured approach allows for consistent identification, assessment, mitigation, and monitoring of cybersecurity risks across all business units.";
	        input4Comment.sendKeys(newComment);
	        Thread.sleep(1000);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
	        System.out.println("Added new comment in section 2.4 : " + newComment);
	    }
	    
	    
	    WebElement input4Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section2Input4Justification));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input4Justification);
	    	    	    
	    String justification4Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim();", input4Justification);
	    System.out.println("Justification (cleaned): '" + justification4Value + "'");


	    if (justification4Value == null || justification4Value.isEmpty()) {
	    	    	
	        String justification4Text = "The program involves periodic risk assessments, asset classification, threat modeling, and controls evaluation.";
	        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input4Justification, justification4Text);
		    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		    System.out.println("Added justification in section 2.4 : " + justification4Text);
	    }
	    
		// === SECTION 2.5 ===
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section2input5Label));
	    WebElement section2Label5 = driver.findElement(section2input5Label);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section2Label5);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section2Label5);

	    
	    WebElement input5Answer = wait.until(ExpectedConditions.visibilityOfElementLocated(section2Input5Answer));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input5Answer);
	    

	    String input5Value = (String) ((JavascriptExecutor) driver).executeScript( "return arguments[0].innerText || arguments[0].textContent;", input5Answer);    
	    System.out.println(input5Value);
	    
	    if (input5Value != null) {
	    	input5Value = input5Value.replaceAll("\\u00A0", " ").trim();
	    	Thread.sleep(3000);
	    }
    
	   
	    if (input5Value == null || input5Value.isEmpty()) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", input5Answer);
	        String answerText = "Our organization determines cybersecurity risk tolerances through a combination of business impact assessments, regulatory requirements, and executive input.";
	        input5Answer.sendKeys(answerText);
	        System.out.println("Input set in Section 2.5 Answer: " + answerText);
	    } else {
	        System.out.println("Field already contains meaningful input, skipping.");
	    }

	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
	    
	    WebElement comment5CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[17]")
	    ));
	    
	    int comment5Count = Integer.parseInt(comment5CountElement.getText().trim());
	    System.out.println(comment5Count);
	    Thread.sleep(2000);
	    
	    
	    WebElement input5Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section2Input5Comment));
	    if (comment5Count > 0) {
	        System.out.println("Existing Comment: " + input5Comment.getText());
	    } else {
	    	input5Comment.sendKeys("Comment for Section 2.5");
	        Thread.sleep(2000);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
	        System.out.println("Added new comment in section 2.5 : " + input5Comment);
	    }

        
	    WebElement input5Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section2Input5Justification));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input5Justification);
	    
	    String justification5Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim();", input5Justification);
	    System.out.println("Justification (cleaned): '" + justification5Value + "'");    
	    	    
	    
	    
	    if (justification5Value == null || justification5Value.isEmpty()) {
	    	
	    	String justification5Text = "Risk tolerance is established by evaluating the potential impact of cybersecurity threats.";
	        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input5Justification, justification5Text);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
	        System.out.println("Added justification in section 2.5 : " + justification5Text);
	    }

	
	// === SECTION 2.6 ===
	
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section2input6Label));
    WebElement section2Label6 = driver.findElement(section2input6Label);
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section2Label6);
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section2Label6);

    
    WebElement input6Answer = wait.until(ExpectedConditions.visibilityOfElementLocated(section2Input6Answer));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input6Answer);

    String input6Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText || arguments[0].textContent;", input6Answer);    
    
    if (input6Value != null) {
     	input6Value = input6Value.replaceAll("\\u00A0", " ").trim();
    	Thread.sleep(3000);	
    }

   
    	if (input6Value == null || input6Value.isEmpty()) {
    		((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", input6Answer);
    	    String answerText = "We assess effectiveness through regular audits, incident tracking, and performance metrics aligned with our cybersecurity goals.";
    	    input6Answer.sendKeys(answerText);
    	    System.out.println("Input set in Section 2.6 Answer: " + answerText);
    	}
    	
    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

    	
    WebElement comment6CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[21]")
    ));
    
    int comment6Count = Integer.parseInt(comment6CountElement.getText().trim());
    System.out.println(comment6Count);
    Thread.sleep(2000);
    
    
    WebElement input6Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section2Input6Comment));
    if (comment6Count > 0) {
        System.out.println("Existing Comment: " + input6Comment.getText());
    } else {
    	input6Comment.sendKeys("Comment for Section 2.6");
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
        System.out.println("Added new comment in section 2.6 : " + input6Comment);
    }

    
    WebElement input6Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section2Input6Justification));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input6Justification);
    
    String justification6Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim();", input6Justification);
    System.out.println("Justification (cleaned): '" + justification6Value + "'");    
    	    
    
    
    if (justification6Value == null || justification6Value.isEmpty()) {
    	String justification6Text = "The effectiveness assessment methodology aligns with regulatory requirements and industry best practices.";
    	
    	input6Justification.sendKeys(justification6Text);
        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input6Justification, justification6Text);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
        System.out.println("Added justification in section 2.6 : " + justification6Text);
    }

	
	// === SECTION 2.7 ===
	
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section2input7Label));
    WebElement section2Label7 = driver.findElement(section2input7Label);
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section2Label7);
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section2Label7);

    
    WebElement input7Answer = wait.until(ExpectedConditions.visibilityOfElementLocated(section2Input7Answer));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input7Answer);

    String input7Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText || arguments[0].textContent;", input7Answer);    
    
    if (input7Value != null) {
    	input7Value = input7Value.replaceAll("\\u00A0", " ").trim();
    	Thread.sleep(3000);
    }
   
   
	if (input7Value == null || input7Value.isEmpty()) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", input7Answer);
	    String answerText = "We assess effectiveness through regular audits, incident tracking, and performance metrics aligned with our cybersecurity goals.";
	    input7Answer.sendKeys(answerText);
	    System.out.println("Input set in Section 2.7 Answer: " + answerText);
	}

    WebElement comment7CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[25]")
    ));
    
    int comment7Count = Integer.parseInt(comment7CountElement.getText().trim());
    System.out.println(comment7Count);
    Thread.sleep(2000);
    
    
    WebElement input7Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section2Input7Comment));
    if (comment7Count > 0) {
        System.out.println("Existing Comment: " + input7Comment.getText());
    } else {
    	input7Comment.sendKeys("Comment for Section 2.7");
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
        System.out.println("Added new comment in section 2.7 : " + input7Comment);
    }

    
    WebElement input7Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section2Input7Justification));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input7Justification);
    
    String justification7Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim();", input7Justification);
    System.out.println("Justification (cleaned): '" + justification7Value + "'");    
    	    
    
    
    if (justification7Value == null || justification7Value.isEmpty()) {
    	String justification7Text = "Third-party risk assessments for vendors handling sensitive data (aligned with NIST 800-161)";
        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input7Justification, justification7Text);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
        System.out.println("Added justification in section 2.7 : " + justification7Text);
    }

 
	
	// === SECTION 2.8 ===
	
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section2input8Label));
    WebElement section2Label8 = driver.findElement(section2input8Label);
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section2Label8);
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section2Label8);


    wait.until(ExpectedConditions.visibilityOfElementLocated(section2Input8Radio));
    
    WebElement radio8Element = driver.findElement(section2Input8Radio);
    JavascriptExecutor js5 = (JavascriptExecutor) driver;
    js5.executeScript("arguments[0].scrollIntoView({block: 'center'});", radio8Element);
    js5.executeScript("arguments[0].click();", radio8Element);
    
    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
    
    WebElement comment8CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[29]")
    ));
    
    int comment8Count = Integer.parseInt(comment8CountElement.getText().trim());
    System.out.println(comment8Count);
    Thread.sleep(2000);
    
    
    WebElement input8Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section2Input8Comment));
    if (comment8Count > 0) {
        System.out.println("Existing Comment: " + input8Comment.getText());
    } else {
    	input8Comment.sendKeys("Comment for Section 2.8");
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
        System.out.println("Added new comment in section 2.8 : " + input8Comment);
    }

    
    WebElement input8Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section2Input8Justification));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input8Justification);
    
    String justification8Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim();", input8Justification);
    System.out.println("Justification (cleaned): '" + justification8Value + "'");    
    	    
    
    
    if (justification8Value == null || justification8Value.isEmpty()) {
    	String justification8Text = "Our organization maintains formal agreements with all critical suppliers that include explicit cybersecurity requirements aligned with [ISO 27001/NIST CSF/PCI DSS].";
        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input8Justification, justification8Text);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
        System.out.println("Added justification in section 2.8 : " + justification8Text);
    }
    
	}
	
	
	
	public void section3Header() {
		String expectedHeader = "IDENTIFY (ID)";
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section3Header));
		String actualHeader = driver.findElement(section3Header).getText();
		System.out.println(actualHeader);
		Assert.assertEquals(actualHeader,expectedHeader);
		
	}
	
	

	
	public void section3Answer() throws InterruptedException {
		
		// === SECTION 3.1 ===
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section3input1Label));
	    WebElement section3Label1 = driver.findElement(section3input1Label);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section3Label1);
	    section3Label1.click();
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(section3Input1Radio));
	    
	    WebElement radio1Element = driver.findElement(section3Input1Radio);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView({block: 'center'});", radio1Element);
	    js.executeScript("arguments[0].click();", radio1Element);
	    
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

	    WebElement comment1CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[1]")
	    ));

	    int comment1Count = Integer.parseInt(comment1CountElement.getText().trim());
	    System.out.println(comment1Count);
	    Thread.sleep(2000);
	    
	    WebElement input1Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section3Input1Comment));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input1Comment);
	    
	    if (comment1Count > 0) {
	        String existingComment = input1Comment.getText();
	        System.out.println("Existing Comment: " + existingComment);
	    } else {
	        String newComment = "Currently, our organization does not maintain a comprehensive, centralized inventory of IT assets.";
	        input1Comment.sendKeys(newComment);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
	        System.out.println("Added new comment in section 3.1 : " + newComment);
	    }
	    
	    
	    WebElement input1Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section3Input1Justification));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input1Justification);
	    	    	    
	    String justificationValue = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim();", input1Justification);
	    System.out.println("Justification (cleaned): '" + justificationValue + "'");


	    if (justificationValue == null || justificationValue.isEmpty()) {
	        String justification1Text = " Business units document assets under their control through spreadsheets and procurement records.";		   
	        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input1Justification, justification1Text);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		    System.out.println("Added justification in section 3.1 : " + justification1Text);
	    }
	    
	    
		// === SECTION 3.2 ===
	    
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section3input2Label));
	    WebElement section3Label2 = driver.findElement(section3input2Label);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section3Label2);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section3Label2);	    
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(section3Input2Radio));
	    
	    WebElement radio2Element = driver.findElement(section3Input2Radio);
	    JavascriptExecutor js1 = (JavascriptExecutor) driver;
	    js1.executeScript("arguments[0].scrollIntoView({block: 'center'});", radio2Element);
	    js1.executeScript("arguments[0].click();", radio2Element);
	    
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

	    WebElement comment2CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[5]")
	    ));

	    int comment2Count = Integer.parseInt(comment2CountElement.getText().trim());
	    System.out.println(comment2Count);
	    Thread.sleep(2000);
	    
	    WebElement input2Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section3Input2Comment));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input2Comment);
	    
	    if (comment2Count > 0) {
	        String existingComment = input2Comment.getText();
	        System.out.println("Existing Comment: " + existingComment);
	    } else {
	        String newComment = "Our IT asset inventory is formally updated on an annual basis, aligned with our fiscal year-end audit process.";
	        input2Comment.sendKeys(newComment);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
	        System.out.println("Added new comment in section 3.2 : " + newComment);
	    }
	    
	    
	    WebElement input2Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section3Input2Justification));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input2Justification);
	    	    	    
	    String justification2Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim();", input2Justification);
	    System.out.println("Justification (cleaned): '" + justification2Value + "'");


	    if (justification2Value == null || justification2Value.isEmpty()) {
	        String justification2Text = "Changes to these systems require change advisory board (CAB) approval, which triggers manual inventory updates";	   
	        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input2Justification, justification2Text);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		    System.out.println("Added justification in section 3.2 : " + justification2Text);
	    }
	    
	    
		// === SECTION 3.3 == // 
	    
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section3input3Label));
	    WebElement section3Label3 = driver.findElement(section3input3Label);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section3Label3);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section3Label3);
	    
	    wait.until(ExpectedConditions.elementToBeClickable(section3Input3CheckBox));
	    
	    WebElement checkboxElement = driver.findElement(section3Input3CheckBox);

	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", checkboxElement);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkboxElement);
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

	    WebElement comment3CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[9]")
	    ));

	    int comment3Count = Integer.parseInt(comment3CountElement.getText().trim());
	    System.out.println(comment3Count);
	    Thread.sleep(2000);
	    
	    WebElement input3Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section3Input3Comment));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input3Comment);
	    
	    if (comment3Count > 0) {
	        String existingComment = input3Comment.getText();
	        System.out.println("Existing Comment: " + existingComment);
	    } else {
	        String newComment = "Aligns with fiscal year-end audits to ensure financial and regulatory accuracy ";
	        input3Comment.sendKeys(newComment);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
	        System.out.println("Added new comment in section 3.3 : " + newComment);
	    }
	    
	    
	    WebElement input3Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section3Input3Justification));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input3Justification);
	    	    	    
	    String justification3Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim();", input3Justification);
	    System.out.println("Justification (cleaned): '" + justification3Value + "'");


	    if (justification3Value == null || justification3Value.isEmpty()) {
	        String justification3Text = "Changes to these systems require change advisory board (CAB) approval, which triggers manual inventory updates";	   
	        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input3Justification, justification3Text);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		    System.out.println("Added justification in section 3.3 : " + justification3Text);
	    }
	    
	    // Section 3.4 
	    
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section3input4Label));
	    WebElement section3Label4 = driver.findElement(section3input4Label);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section3Label4);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section3Label4);

	    
	    WebElement input4Answer = wait.until(ExpectedConditions.visibilityOfElementLocated(section3Input4Answer));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input4Answer);

	    String input4Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText || arguments[0].textContent;", input4Answer);    
	    
	    if (input4Value != null) {
	    	input4Value = input4Value.replaceAll("\\u00A0", " ").trim();
	    	Thread.sleep(3000);
	    }
	   
	   
		if (input4Value == null || input4Value.isEmpty()) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", input4Answer);
		    String answerText = "Visio/Lucidchart for diagrams, ServiceNow for dependency tracking, automated discovery via network traffic analysis.";
		    input4Answer.sendKeys(answerText);
		    System.out.println("Input set in Section 3.4 Answer: " + answerText);
		}

	    WebElement comment4CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[13]")
	    ));
	    
	    int comment4Count = Integer.parseInt(comment4CountElement.getText().trim());
	    System.out.println(comment4Count);
	    Thread.sleep(2000);
	    
	    
	    WebElement input4Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section3Input4Comment));
	    if (comment4Count > 0) {
	        System.out.println("Existing Comment: " + input4Comment.getText());
	    } else {
	    	input4Comment.sendKeys("Comment for Section 3.4");
	        Thread.sleep(2000);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
	        System.out.println("Added new comment in section 3.4 : " + input4Comment);
	    }

	    
	    WebElement input4Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section3Input4Justification));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input4Justification);
	    
	    String justification4Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim()", input4Justification);
	    System.out.println("Justification (cleaned): '" + justification4Value + "'");    
	    	    
	    
	    
	    if (justification4Value == null || justification4Value.isEmpty()) {
	    	String justification4Text = "Documented via DFDs and dependency matrices, validated quarterly and during changes.";
	        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input4Justification, justification4Text);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
	        System.out.println("Added justification in section 3.4 : " + justification4Text);
	    }
	    
		// === SECTION 3.5 === // 
	    
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section3input5Label));
	    WebElement section3Label5 = driver.findElement(section3input5Label);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section3Label5);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section3Label5);	    
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(section3Input5Radio));
	    
	    WebElement radio5Element = driver.findElement(section3Input5Radio);
	    JavascriptExecutor js3 = (JavascriptExecutor) driver;
	    js3.executeScript("arguments[0].scrollIntoView({block: 'center'});", radio5Element);
	    js3.executeScript("arguments[0].click();", radio5Element);
	    
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

	    WebElement comment5CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[17]")
	    ));

	    int comment5Count = Integer.parseInt(comment5CountElement.getText().trim());
	    System.out.println(comment5Count);
	    Thread.sleep(2000);
	    
	    WebElement input5Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section3Input5Comment));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input5Comment);
	    
	    if (comment5Count > 0) {
	        String existingComment = input5Comment.getText();
	        System.out.println("Existing Comment: " + existingComment);
	    } else {
	        String newComment = "Our IT asset inventory is formally updated on an annual basis, aligned with our fiscal year-end audit process.";
	        input5Comment.sendKeys(newComment);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
	        System.out.println("Added new comment in section 3.5 : " + newComment);
	    }
	    
	    
	    WebElement input5Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section3Input5Justification));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input5Justification);
	    	    	    
	    String justification5Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim()", input5Justification);
	    System.out.println("Justification (cleaned): '" + justification5Value + "'");


	    if (justification5Value == null || justification5Value.isEmpty()) {
	        String justification5Text = "Informing budget allocations for IT refreshes and cloud migrations.";

	        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input5Justification, justification5Text);
	        
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		    System.out.println("Added justification in section 3.5 : " + justification5Text);
	    }
	    
		// === SECTION 3.6 === // 
	    
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section3input6Label));
	    WebElement section3Label6 = driver.findElement(section3input6Label);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section3Label6);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section3Label6);

	    
	    WebElement input6Answer = wait.until(ExpectedConditions.visibilityOfElementLocated(section3Input6Answer));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input6Answer);

	    String input6Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText || arguments[0].textContent;", input6Answer);    
	    
	    if (input6Value != null) {
	    	input6Value = input6Value.replaceAll("\\u00A0", " ").trim();
	    	Thread.sleep(3000);
	    }
	   
	   
		if (input6Value == null || input6Value.isEmpty()) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", input6Answer);
		    String answerText = "Visio/Lucidchart for diagrams, ServiceNow for dependency tracking, automated discovery via network traffic analysis.";
		    input6Answer.sendKeys(answerText);
		    System.out.println("Input set in Section 3.6 Answer: " + answerText);
		}

	    WebElement comment6CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[21]")
	    ));
	    
	    int comment6Count = Integer.parseInt(comment6CountElement.getText().trim());
	    System.out.println(comment6Count);
	    Thread.sleep(2000);
	    
	    
	    WebElement input6Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section3Input6Comment));
	    if (comment6Count > 0) {
	        System.out.println("Existing Comment: " + input6Comment.getText());
	    } else {
	    	input6Comment.sendKeys("Comment for Section 3.6");
	        Thread.sleep(2000);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
	        System.out.println("Added new comment in section 3.6 : " + input6Comment);
	    }

	    
	    WebElement input6Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section3Input6Justification));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input6Justification);
	    
	    String justification6Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim()", input6Justification);
	    System.out.println("Justification (cleaned): '" + justification6Value + "'");    
	    	    
	    
	    
	    if (justification6Value == null || justification6Value.isEmpty()) {
	    	String justification6Text = "Documented via DFDs and dependency matrices, validated quarterly and during changes.";
//	    	input6Justification.sendKeys(justification6Text);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input6Justification, justification6Text);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
	        System.out.println("Added justification in section 3.6 : " + justification6Text);
	    }
	   	    
	}	
	
	public void section4Header() {
		
		String expectedHeader = "PROTECT (PR)";
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section4Header));
		String actualHeader = driver.findElement(section4Header).getText();
		System.out.println(actualHeader);
		Assert.assertEquals(actualHeader,expectedHeader);
		
	}
	

	public void section4Answer() throws InterruptedException {
		
		// === SECTION 4.1 === // 
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section4input1Label));
	    WebElement section4Label1 = driver.findElement(section4input1Label);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section4Label1);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section4Label1);	    
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(section4Input1Radio));
	    
	    WebElement radio1Element = driver.findElement(section4Input1Radio);
	    JavascriptExecutor js1 = (JavascriptExecutor) driver;
	    js1.executeScript("arguments[0].scrollIntoView({block: 'center'});", radio1Element);
	    js1.executeScript("arguments[0].click();", radio1Element);
	    
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

	    WebElement comment1CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[1]")
	    ));

	    int comment1Count = Integer.parseInt(comment1CountElement.getText().trim());
	    System.out.println(comment1Count);
	    Thread.sleep(2000);
	    
	    WebElement input1Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section4Input1Comment));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input1Comment);
	    
	    if (comment1Count > 0) {
	        String existingComment = input1Comment.getText();
	        System.out.println("Existing Comment: " + existingComment);
	    } else {
	        String newComment = "We follow a documented IT change management process aligned with ITIL framework";
	        input1Comment.sendKeys(newComment);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
	        System.out.println("Added new comment in section 4.1 : " + newComment);
	    }
	    
	    
	    WebElement input1Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section4Input1Justification));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input1Justification);
	    	    	    
	    String justification1Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim()", input1Justification);
	    System.out.println("Justification (cleaned): '" + justification1Value + "'");


	    if (justification1Value == null || justification1Value.isEmpty()) {
	        String justification1Text = "Formal ITIL-based process with risk assessment, approval workflows, and rollback plans.";		   
	        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input1Justification, justification1Text);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		    System.out.println("Added justification in section 4.1 : " + justification1Text);
	    }
	    
	    
	 // === SECTION 4.2 === // 
	    
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section4input2Label));
	    WebElement section4Label2 = driver.findElement(section4input2Label);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section4Label2);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section4Label2);	    
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(section4Input2Radio));
	    
	    WebElement radio2Element = driver.findElement(section4Input2Radio);
	    JavascriptExecutor js2 = (JavascriptExecutor) driver;
	    js2.executeScript("arguments[0].scrollIntoView({block: 'center'});", radio2Element);
	    js2.executeScript("arguments[0].click();", radio2Element);
	    
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

	    WebElement comment2CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[5]")
	    ));

	    int comment2Count = Integer.parseInt(comment2CountElement.getText().trim());
	    System.out.println(comment2Count);
	    Thread.sleep(2000);
	    
	    WebElement input2Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section4Input2Comment));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input2Comment);
	    
	    if (comment2Count > 0) {
	        String existingComment = input2Comment.getText();
	        System.out.println("Existing Comment: " + existingComment);
	    } else {
	        String newComment = "Backup and recovery procedures are tested annually during our business continuity planning cycle.";
	        input2Comment.sendKeys(newComment);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
	        System.out.println("Added new comment in section 4.2 : " + newComment);
	    }
	    
	    
	    WebElement input2Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section4Input2Justification));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input2Justification);
	    	    	    
	    String justification2Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim()", input2Justification);
	    System.out.println("Justification (cleaned): '" + justification2Value + "'");


	    if (justification2Value == null || justification2Value.isEmpty()) {
	        String justification2Text = "Annual testing ensures : Verification of backup integrity.";		   
	        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input2Justification, justification2Text);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		    System.out.println("Added justification in section 4.2 : " + justification2Text);
	    }
	    
		 // === SECTION 4.3 === // 
	    
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section4input3Label));
		    WebElement section4Label3 = driver.findElement(section4input3Label);
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section4Label3);
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section4Label3);	    
		    
		    wait.until(ExpectedConditions.presenceOfElementLocated(section4Input3CheckBox));

		    WebElement checkbox3Element = driver.findElement(section4Input3CheckBox);
		    JavascriptExecutor js3 = (JavascriptExecutor) driver;
		    js3.executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", checkbox3Element);
		    js3.executeScript("arguments[0].click();", checkbox3Element);
		    
		    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

		    WebElement comment3CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
		        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[9]")
		    ));

		    int comment3Count = Integer.parseInt(comment3CountElement.getText().trim());
		    System.out.println(comment3Count);
		    
		    WebElement input3Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section4Input3Comment));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input3Comment);
		    
		    if (comment3Count > 0) {
		        String existingComment = input3Comment.getText();
		        System.out.println("Existing Comment: " + existingComment);
		    } else {
		        String newComment = "We deploy a web application firewall (WAF) to protect against OWASP Top 10 threats like SQLi and XSS.";
		        input3Comment.sendKeys(newComment);
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		        System.out.println("Added new comment in section 4.3 : " + newComment);
		    }
		    
		    
		    WebElement input3Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section4Input3Justification));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input3Justification);
		    	    	    
		    String justification3Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim()", input3Justification);
		    System.out.println("Justification (cleaned): '" + justification3Value + "'");


		    if (justification3Value == null || justification3Value.isEmpty()) {
		        String justification3Text = "Our WAF provides real time attack blocking.";	   
		        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input3Justification, justification3Text);
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
			    System.out.println("Added justification in section 4.3 : " + justification3Text);
		    }
		    
		    
			 // === SECTION 4.4 === // 
		    
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section4input4Label));
			    WebElement section4Label4 = driver.findElement(section4input4Label);
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section4Label4);
			    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section4Label4);	    
			    Thread.sleep(2000);
			    
			    wait.until(ExpectedConditions.presenceOfElementLocated(section4Input4CheckBox));

			    WebElement checkbox4Element = driver.findElement(section4Input4CheckBox);
			    JavascriptExecutor js4 = (JavascriptExecutor) driver;
			    js4.executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", checkbox4Element);
			    js4.executeScript("arguments[0].click();", checkbox4Element);
			    	    
			    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

			    WebElement comment4CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
			        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[13]")
			    ));

			    int comment4Count = Integer.parseInt(comment4CountElement.getText().trim());
			    System.out.println(comment4Count);
			    Thread.sleep(2000);
			    
			    WebElement input4Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section4Input4Comment));
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input4Comment);
			    
			    if (comment4Count > 0) {
			        String existingComment = input4Comment.getText();
			        System.out.println("Existing Comment: " + existingComment);
			    } else {
			        String newComment = "We deploy a web application firewall (WAF) to protect against OWASP Top 10 threats like SQLi and XSS.";
			        input4Comment.sendKeys(newComment);
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
			        System.out.println("Added new comment in section 4.4 : " + newComment);
			    }
			    
			    
			    WebElement input4Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section4Input4Justification));
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input4Justification);
			    	    	    
			    String justification4Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim()", input4Justification);
			    System.out.println("Justification (cleaned): '" + justification4Value + "'");


			    if (justification4Value == null || justification4Value.isEmpty()) {
			        String justification4Text = "Our WAF provides real time attack blocking.";
//			        input4Justification.sendKeys(justification4Text);		   
			        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input4Justification, justification4Text);
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
				    System.out.println("Added justification in section 4.4 : " + justification4Text);
			    }
			    
				 // === SECTION 4.5 === // 
			    
			    
			    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section4input5Label));
			    WebElement section4Label5 = driver.findElement(section4input5Label);
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section4Label5);
			    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section4Label5);

			    
			    WebElement input5Answer = wait.until(ExpectedConditions.visibilityOfElementLocated(section4Input5Answer));
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input5Answer);

			    String input5Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText || arguments[0].textContent;", input5Answer);    
			    
			    if (input5Value != null) {
			    	input5Value = input5Value.replaceAll("\\u00A0", " ").trim();
			    	Thread.sleep(3000);	
			    }

			   
			    	if (input5Value == null || input5Value.isEmpty()) {
			    		((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", input5Answer);
			    	    String answerText = "We assess effectiveness through regular audits, incident tracking, and performance metrics aligned with our cybersecurity goals.";
			    	    input5Answer.sendKeys(answerText);
			    	    System.out.println("Input set in Section 4.5 Answer: " + answerText);
			    	}
			    	
			    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

			    	
			    WebElement comment5CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
			        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[17]")
			    ));
			    
			    int comment5Count = Integer.parseInt(comment5CountElement.getText().trim());
			    System.out.println(comment5Count);
			    Thread.sleep(2000);
			    
			    
			    WebElement input5Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section4Input5Comment));
			    if (comment5Count > 0) {
			        System.out.println("Existing Comment: " + input5Comment.getText());
			    } else {
			    	input5Comment.sendKeys("Comment for Section 4.5");
			        Thread.sleep(2000);
			        wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
			        System.out.println("Added new comment in section 4.5 : " + input5Comment);
			    }

			    
			    WebElement input5Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section4Input5Justification));
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input5Justification);
			    
			    String justification5Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim()", input5Justification);
			    System.out.println("Justification (cleaned): '" + justification5Value + "'");    
			    	    
			    
			    
			    if (justification5Value == null || justification5Value.isEmpty()) {
			    	String justification5Text = "The effectiveness assessment methodology aligns with regulatory requirements and industry best practices.";
			        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input5Justification, justification5Text);
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
			        System.out.println("Added justification in section 4.5 : " + justification5Text);
			    }

		    
				 // === SECTION 4.6 === // 
			    
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section4input6Label));
			    WebElement section4Label6 = driver.findElement(section4input6Label);
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section4Label6);
			    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section4Label6);	    
			    
			    wait.until(ExpectedConditions.visibilityOfElementLocated(section4Input6Radio));
			    
			    WebElement radio6Element = driver.findElement(section4Input6Radio);
			    JavascriptExecutor js5 = (JavascriptExecutor) driver;
			    js5.executeScript("arguments[0].scrollIntoView({block: 'center'});", radio6Element);
			    js5.executeScript("arguments[0].click();", radio6Element);
			    
			    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

			    WebElement comment6CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
			        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[21]")
			    ));

			    int comment6Count = Integer.parseInt(comment6CountElement.getText().trim());
			    System.out.println(comment6Count);
			    Thread.sleep(2000);
			    
			    WebElement input6Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section4Input6Comment));
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input6Comment);
			    
			    if (comment6Count > 0) {
			        String existingComment = input6Comment.getText();
			        System.out.println("Existing Comment: " + existingComment);
			    } else {
			        String newComment = "User access rights are reviewed on an annual basis to ensure alignment with role responsibilities and to maintain access hygiene across all departments.";
			        input6Comment.sendKeys(newComment);
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
			        System.out.println("Added new comment in section 4.6 : " + newComment);
			    }
			    
			    
			    WebElement input6Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section4Input6Justification));
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input6Justification);
			    	    	    
			    String justification6Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim()", input6Justification);
			    System.out.println("Justification (cleaned): '" + justification6Value + "'");


			    if (justification6Value == null || justification6Value.isEmpty()) {
			        String justification6Text = "An annual review schedule aligns with our organization’s risk management and compliance policies.";
//			        input6Justification.sendKeys(justification6Text);		   
			        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input6Justification, justification6Text);
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
				    System.out.println("Added justification in section 4.6 : " + justification6Text);
			    }
			    
			    
				 // === SECTION 4.7 === // 
			    
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section4input7Label));
			    WebElement section4Label7 = driver.findElement(section4input7Label);
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section4Label7);
			    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section4Label7);	    
			    
			    wait.until(ExpectedConditions.visibilityOfElementLocated(section4Input7Radio));
			    
			    WebElement radio7Element = driver.findElement(section4Input7Radio);
			    JavascriptExecutor js6 = (JavascriptExecutor) driver;
			    js6.executeScript("arguments[0].scrollIntoView({block: 'center'});", radio7Element);
			    js6.executeScript("arguments[0].click();", radio7Element);
			    
			    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

			    WebElement comment7CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
			        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[25]")
			    ));

			    int comment7Count = Integer.parseInt(comment7CountElement.getText().trim());
			    System.out.println(comment7Count);
			    Thread.sleep(2000);
			    
			    WebElement input7Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section4Input7Comment));
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input7Comment);
			    
			    if (comment7Count > 0) {
			        String existingComment = input7Comment.getText();
			        System.out.println("Existing Comment: " + existingComment);
			    } else {
			        String newComment = "User access rights are reviewed on an annual basis to ensure alignment with role responsibilities and to maintain access hygiene across all departments.";
			        input7Comment.sendKeys(newComment);
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
			        System.out.println("Added new comment in section 4.7 : " + newComment);
			    }
			    
			    
			    WebElement input7Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section4Input7Justification));
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input7Justification);
			    	    	    
			    String justification7Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim()", input7Justification);
			    System.out.println("Justification (cleaned): '" + justification7Value + "'");


			    if (justification7Value == null || justification7Value.isEmpty()) {
			        String justification7Text = "An annual review schedule aligns with our organization’s risk management and compliance policies.";
//			        input7Justification.sendKeys(justification7Text);		   
			        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input7Justification, justification7Text);
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
				    System.out.println("Added justification in section 4.7 : " + justification7Text);
			    }
			    
				 // === SECTION 4.8 === // 
			    
			    
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section4input8Label));
			    WebElement section4Label8 = driver.findElement(section4input8Label);
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section4Label8);
			    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section4Label8);	    
			    
			    wait.until(ExpectedConditions.visibilityOfElementLocated(section4Input8Radio));
			    
			    WebElement radio8Element = driver.findElement(section4Input8Radio);
			    JavascriptExecutor js7 = (JavascriptExecutor) driver;
			    js7.executeScript("arguments[0].scrollIntoView({block: 'center'});", radio8Element);
			    js7.executeScript("arguments[0].click();", radio8Element);
			    
			    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

			    WebElement comment8CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
			        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[29]")
			    ));

			    int comment8Count = Integer.parseInt(comment8CountElement.getText().trim());
			    System.out.println(comment8Count);
			    Thread.sleep(2000);
			    
			    WebElement input8Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section4Input8Comment));
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input8Comment);
			    
			    if (comment8Count > 0) {
			        String existingComment = input8Comment.getText();
			        System.out.println("Existing Comment: " + existingComment);
			    } else {
			        String newComment = "Yes, phishing simulation exercises are conducted periodically to assess employee awareness and response to phishing threats.";
			        input8Comment.sendKeys(newComment);
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
			        System.out.println("Added new comment in section 4.8 : " + newComment);
			    }
			    
			    
			    WebElement input8Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section4Input8Justification));
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input8Justification);
			    	    	    
			    String justification8Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim()", input8Justification);
			    System.out.println("Justification (cleaned): '" + justification8Value + "'");


			    if (justification8Value == null || justification8Value.isEmpty()) {
			        String justification8Text = "Phishing remains one of the most common attack vectors in cybersecurity.";
//			        input8Justification.sendKeys(justification8Text);		   
			        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input8Justification, justification8Text);
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
				    System.out.println("Added justification in section 4.8 : " + justification8Text);
			    }
			    
			    
				 // === SECTION 4.9 === // 
			    
			    
			    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section4input9Label));
			    WebElement section4Label9 = driver.findElement(section4input9Label);
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section4Label9);
			    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section4Label9);	    
			    Thread.sleep(2000);
			    
			    wait.until(ExpectedConditions.presenceOfElementLocated(section4Input9CheckBox));

			    WebElement checkbox9Element = driver.findElement(section4Input9CheckBox);
			    JavascriptExecutor js8 = (JavascriptExecutor) driver;
			    js8.executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", checkbox9Element);
			    js8.executeScript("arguments[0].click();", checkbox9Element);
			    	    
			    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

			    WebElement comment9CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
			        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[33]")
			    ));

			    int comment9Count = Integer.parseInt(comment9CountElement.getText().trim());
			    System.out.println(comment9Count);
			    Thread.sleep(2000);
			    
			    WebElement input9Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section4Input9Comment));
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input9Comment);
			    
			    if (comment9Count > 0) {
			        String existingComment = input9Comment.getText();
			        System.out.println("Existing Comment: " + existingComment);
			    } else {
			        String newComment = "Database Activity Monitoring (DAM) is implemented to track, analyze, and report database activity in real-time for security and compliance purposes.";
			        input9Comment.sendKeys(newComment);
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
			        System.out.println("Added new comment in section 4.9 : " + newComment);
			    }
			    
			    
			    WebElement input9Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section4Input9Justification));
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input9Justification);
			    	    	    
			    String justification9Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim()", input9Justification);
			    System.out.println("Justification (cleaned): '" + justification9Value + "'");


			    if (justification9Value == null || justification9Value.isEmpty()) {
			        String justification9Text = "Implementing Database Activity Monitoring helps ensure the security and integrity of sensitive data by detecting unauthorized access, anomalous behavior, and policy violations within database environments.";
//			        input9Justification.sendKeys(justification9Text);		   
			        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input9Justification, justification9Text);
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
				    System.out.println("Added justification in section 4.9 : " + justification9Text);
			    }
			    
				 // === SECTION 4.10 === // 
			    
			    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section4input10Label));
			    WebElement section4Label10 = driver.findElement(section4input10Label);
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section4Label10);
			    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section4Label10);
			    Thread.sleep(2000);

			    
			    WebElement input10Answer = wait.until(ExpectedConditions.visibilityOfElementLocated(section4Input10Answer));
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input10Answer);

			    String input10Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText || arguments[0].textContent;", input10Answer);    
			    
			    if (input10Value != null) {
			    	input10Value = input10Value.replaceAll("\\u00A0", " ").trim();
			    	Thread.sleep(3000);	
			    }

			   
			    	if (input10Value == null || input10Value.isEmpty()) {
			    		((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", input10Answer);
			    	    String answerText = "We follow a secure disposal process that includes data wiping using industry-standard tools, physical destruction of storage devices, and disposal of equipment through certified e-waste vendors.";
			    	    input10Answer.sendKeys(answerText);
			    	    System.out.println("Input set in Section 4.10 Answer: " + answerText);
			    	}
			    	
			    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

			    	
			    WebElement comment10CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
			        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[37]")
			    ));
			    
			    int comment10Count = Integer.parseInt(comment10CountElement.getText().trim());
			    System.out.println(comment10Count);
			    Thread.sleep(2000);
			    
			    
			    WebElement input10Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section4Input10Comment));
			    if (comment10Count > 0) {
			        System.out.println("Existing Comment: " + input10Comment.getText());
			    } else {
			    	input10Comment.sendKeys("We also engage certified vendors for responsible disposal of hardware.");
			        Thread.sleep(2000);
			        wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
			        System.out.println("Added new comment in section 4.10 : " + input10Comment);
			    }

			    
			    WebElement input10Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section4Input10Justification));
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input10Justification);
			    
			    String justification10Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim()", input10Justification);
			    System.out.println("Justification (cleaned): '" + justification10Value + "'");    
			    	    
			    
			    
			    if (justification10Value == null || justification10Value.isEmpty()) {
			    	String justification10Text = "Ensuring secure disposal of data and equipment at end-of-life is critical to preventing data leakage and protecting sensitive information.";
//			    	input10Justification.sendKeys(justification10Text);
			        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input10Justification, justification10Text);
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
			        System.out.println("Added justification in section 4.10 : " + justification10Text);
			    }	
		
	}
	
              public void section5Header() {
    	
          		String expectedHeader = "DETECT (DE)";
        		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section5Header));
        		String actualHeader = driver.findElement(section5Header).getText();
        		System.out.println(actualHeader);
        		Assert.assertEquals(actualHeader,expectedHeader);
            	    
              }
              
              
              public void section5Answer() throws InterruptedException {
            	  
                // === SECTION 5.1 === // 
            	  
          		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section5input1Label));
          	    WebElement section5Label1 = driver.findElement(section5input1Label);
          	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section5Label1);
          	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section5Label1);	    
          	    
          	    wait.until(ExpectedConditions.visibilityOfElementLocated(section5Input1Radio));
          	    
          	    WebElement radio1Element = driver.findElement(section5Input1Radio);
          	    JavascriptExecutor js1 = (JavascriptExecutor) driver;
          	    js1.executeScript("arguments[0].scrollIntoView({block: 'center'});", radio1Element);
          	    js1.executeScript("arguments[0].click();", radio1Element);
          	    
          	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

          	    WebElement comment1CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
          	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[1]")
          	    ));

          	    int comment1Count = Integer.parseInt(comment1CountElement.getText().trim());
          	    System.out.println(comment1Count);
          	    Thread.sleep(2000);
          	    
          	    WebElement input1Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section5Input1Comment));
          	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input1Comment);
          	    
          	    if (comment1Count > 0) {
          	        String existingComment = input1Comment.getText();
          	        System.out.println("Existing Comment: " + existingComment);
          	    } else {
          	        String newComment = "We maintain centralized logging via SIEM (Splunk/QRadar) with 24/7 monitoring.";
          	        input1Comment.sendKeys(newComment);
          	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
          	        System.out.println("Added new comment in section 5.1 : " + newComment);
          	    }
          	    
          	    
          	    WebElement input1Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section5Input1Justification));
          	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input1Justification);
          	    	    	    
          	    String justification1Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim()", input1Justification);
          	    System.out.println("Justification (cleaned): '" + justification1Value + "'");


          	    if (justification1Value == null || justification1Value.isEmpty()) {
          	        String justification1Text = "Our implementation inculdes : Logs from all critical systems.(network, servers, apps)";		   
          	       ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input1Justification, justification1Text);
          	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
          		    System.out.println("Added justification in section 5.1 : " + justification1Text);
          	    }
          	    
          	    
                // === SECTION 5.2 === // 
          	    
          	   wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section5input2Label));
			    WebElement section5Label2 = driver.findElement(section5input2Label);
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section5Label2);
			    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section5Label2);
			    Thread.sleep(2000);

			    
			    WebElement input2Answer = wait.until(ExpectedConditions.visibilityOfElementLocated(section5Input2Answer));
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input2Answer);

			    String input2Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText || arguments[0].textContent;", input2Answer);    
			    
			    if (input2Value != null) {
			    	input2Value = input2Value.replaceAll("\\u00A0", " ").trim();
			    	Thread.sleep(3000);	
			    }

			   
			    	if (input2Value == null || input2Value.isEmpty()) {
			    		((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", input2Value);
			    	    String answerText = "Yes, our organization has implemented a centralized log collection and monitoring system.";
			    	    input2Answer.sendKeys(answerText);
			    	    System.out.println("Input set in Section 5.2 Answer: " + answerText);
			    	}
			    	
			    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

			    	
			    WebElement comment2CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
			        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[5]")
			    ));
			    
			    int comment2Count = Integer.parseInt(comment2CountElement.getText().trim());
			    System.out.println(comment2Count);
			    Thread.sleep(2000);
			    
			    
			    WebElement input2Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section5Input2Comment));
			    if (comment2Count > 0) {
			        System.out.println("Existing Comment: " + input2Comment.getText());
			    } else {
			    	input2Comment.sendKeys("Our organization has implemented centralized log collection and monitoring to detect and respond to security events effectively.");
			        Thread.sleep(2000);
			        wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
			        System.out.println("Added new comment in section 5.2 : " + input2Comment);
			    }

			    
			    WebElement input2Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section5Input2Justification));
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input2Justification);
			    
			    String justification2Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim()", input2Justification);
			    System.out.println("Justification (cleaned): '" + justification2Value + "'");    
			    
          	    if (justification2Value == null || justification2Value.isEmpty()) {
          	        String justification2Text = "Real-time visibility into security events across systems (e.g., failed logins, suspicious API calls).";		   
          	       ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input2Justification, justification2Text);
          	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
          		    System.out.println("Added justification in section 5.1 : " + justification2Text);
          	    }
			    	    
			    
			    
                // === SECTION 5.3 === // 
          	    
          	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section5input3Label));
			    WebElement section5Label3 = driver.findElement(section5input3Label);
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section5Label3);
			    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section5Label3);
			    Thread.sleep(2000);

			    
			    WebElement input3Answer = wait.until(ExpectedConditions.visibilityOfElementLocated(section5Input3Answer));
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input3Answer);

			    String input3Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText || arguments[0].textContent;", input3Answer);    
			    
			    if (input3Value != null) {
			    	input3Value = input3Value.replaceAll("\\u00A0", " ").trim();
			    	Thread.sleep(3000);	
			    }

			   
			    	if (input3Value == null || input3Value.isEmpty()) {
			    		((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", input3Value);
			    	    String answerText = "We establish baselines of normal activity for networks and systems by collecting and analyzing logs, traffic patterns, and system behavior over a defined period.";
			    	    input3Answer.sendKeys(answerText);
			    	    System.out.println("Input set in Section 5.3 Answer: " + answerText);
			    	}
			    	
			    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

			    	
			    WebElement comment3CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
			        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[9]")
			    ));
			    
			    int comment3Count = Integer.parseInt(comment3CountElement.getText().trim());
			    System.out.println(comment3Count);
			    Thread.sleep(2000);
			    
			    
			    WebElement input3Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section5Input3Comment));
			    if (comment3Count > 0) {
			        System.out.println("Existing Comment: " + input3Comment.getText());
			    } else {
			    	input3Comment.sendKeys("Baseline activities are determined by observing normal system behavior over time and using tools to define thresholds and anomaly patterns.");
			        Thread.sleep(2000);
			        wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
			        System.out.println("Added new comment in section 5.3 : " + input3Comment);
			    }

			    
			    WebElement input3Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section5Input3Justification));
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input3Justification);
			    
			    String justification3Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim()", input3Justification);
			    System.out.println("Justification (cleaned): '" + justification3Value + "'");    
			    	    
			    
			    
			    if (justification3Value == null || justification3Value.isEmpty()) {
			    	String justification3Text = "Establishing baselines is essential for detecting anomalies and responding to potential security incidents.";
			        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input3Justification, justification3Text);
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
			        System.out.println("Added justification in section 5.3 : " + justification3Text);
			    }	
          	    
          	    
			       // === SECTION 5.4 === // 
			    
			    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section5input4Label));
			    WebElement section5Label4 = driver.findElement(section5input4Label);
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section5Label4);
			    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section5Label4);	    
			    Thread.sleep(2000);
			    
			    wait.until(ExpectedConditions.presenceOfElementLocated(section5Input4CheckBox));

			    WebElement checkbox4Element = driver.findElement(section5Input4CheckBox);
			    JavascriptExecutor js2 = (JavascriptExecutor) driver;
			    js2.executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", checkbox4Element);
			    js2.executeScript("arguments[0].click();", checkbox4Element);
			    Thread.sleep(2000);
			    	    
			    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

			    WebElement comment4CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
			        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[13]")
			    ));

			    int comment4Count = Integer.parseInt(comment4CountElement.getText().trim());
			    System.out.println(comment4Count);
			    Thread.sleep(2000);
			    
			    WebElement input4Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section5Input4Comment));
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input4Comment);
			    
			    if (comment4Count > 0) {
			        String existingComment = input4Comment.getText();
			        System.out.println("Existing Comment: " + existingComment);
			    } else {
			        String newComment = "Malicious code detection mechanisms are in place across endpoints, servers, and network layers to identify and respond to known and unknown threats in real-time.";
			        input4Comment.sendKeys(newComment);
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
			        System.out.println("Added new comment in section 5.4 : " + newComment);
			    }
			    
			    
			    WebElement input4Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section5Input4Justification));
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input4Justification);
			    	    	    
			    String justification4Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim()", input4Justification);
			    System.out.println("Justification (cleaned): '" + justification4Value + "'");


			    if (justification4Value == null || justification4Value.isEmpty()) {
			        String justification4Text = "Our organization uses advanced malware detection tools, including antivirus, EDR (Endpoint Detection and Response), and intrusion detection systems, to monitor and detect malicious code.";	   
			        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input4Justification, justification4Text);
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
				    System.out.println("Added justification in section 5.4 : " + justification4Text);
			    }
			    
			    
			       // === SECTION 5.5 === // 
			    
			    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section5input5Label));
			    WebElement section5Label5 = driver.findElement(section5input5Label);
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section5Label5);
			    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section5Label5);	    
			    Thread.sleep(2000);
			    
			    wait.until(ExpectedConditions.presenceOfElementLocated(section5Input5Radio));

			    WebElement checkbox5Element = driver.findElement(section5Input5Radio);
			    JavascriptExecutor js3 = (JavascriptExecutor) driver;
			    js3.executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", checkbox5Element);
			    js3.executeScript("arguments[0].click();", checkbox5Element);
			    Thread.sleep(2000);
			    	    
			    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

			    WebElement comment5CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
			        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[17]")
			    ));

			    int comment5Count = Integer.parseInt(comment5CountElement.getText().trim());
			    System.out.println(comment5Count);
			    Thread.sleep(2000);
			    
			    WebElement input5Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section5Input5Comment));
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input5Comment);
			    
			    if (comment5Count > 0) {
			        String existingComment = input5Comment.getText();
			        System.out.println("Existing Comment: " + existingComment);
			    } else {
			        String newComment = "Vulnerability scans are conducted annually as part of our organization's risk assessment and compliance program.";
			        input5Comment.sendKeys(newComment);
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
			        System.out.println("Added new comment in section 5.5 : " + newComment);
			    }
			    
			    
			    WebElement input5Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section5Input5Justification));
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input5Justification);
			    	    	    
			    String justification5Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim()", input5Justification);
			    System.out.println("Justification (cleaned): '" + justification5Value + "'");


			    if (justification5Value == null || justification5Value.isEmpty()) {
			        String justification5Text = "Annual vulnerability scanning is performed to identify security weaknesses in our systems, networks, and applications.";		   
			        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input5Justification, justification5Text);
			        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
				    System.out.println("Added justification in section 5.5 : " + justification5Text);
			    }
          	    	  
            	  
              }
              
              public void section6Header() {
            	  
            		String expectedHeader = "RESPOND (RS)";
            		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section6Header));
            		String actualHeader = driver.findElement(section6Header).getText();
            		System.out.println(actualHeader);
            		Assert.assertEquals(actualHeader,expectedHeader);
            	  
              }
              
              
              public void section6Answer() throws InterruptedException {
            	  
                  // === SECTION 6.1 === // 
            	  
            		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section6input1Label));
            	    WebElement section6Label1 = driver.findElement(section6input1Label);
            	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section6Label1);
            	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section6Label1);	    
            	    
            	    wait.until(ExpectedConditions.visibilityOfElementLocated(section6Input1Radio));
            	    
            	    WebElement radio1Element = driver.findElement(section6Input1Radio);
            	    JavascriptExecutor js1 = (JavascriptExecutor) driver;
            	    js1.executeScript("arguments[0].scrollIntoView({block: 'center'});", radio1Element);
            	    js1.executeScript("arguments[0].click();", radio1Element);
            	    
            	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

            	    WebElement comment1CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
            	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[1]")
            	    ));

            	    int comment1Count = Integer.parseInt(comment1CountElement.getText().trim());
            	    System.out.println(comment1Count);
            	    Thread.sleep(2000);
            	    
            	    WebElement input1Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section6Input1Comment));
            	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input1Comment);
            	    
            	    if (comment1Count > 0) {
            	        String existingComment = input1Comment.getText();
            	        System.out.println("Existing Comment: " + existingComment);
            	    } else {
            	        String newComment = "We maintain a comprehensive incident response plan aligned with NIST SP 800-61 guidelines.";
            	        input1Comment.sendKeys(newComment);
            	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
            	        System.out.println("Added new comment in section 6.1 : " + newComment);
            	    }
            	    
            	    
            	    WebElement input1Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section6Input1Justification));
            	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input1Justification);
            	    	    	    
            	    String justification1Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim()", input1Justification);
            	    System.out.println("Justification (cleaned): '" + justification1Value + "'");


            	    if (justification1Value == null || justification1Value.isEmpty()) {
            	        String justification1Text = "Documented procedures for identification, containment, eradication, and recovery.";	   
            	        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input1Justification, justification1Text);
            	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
            		    System.out.println("Added justification in section 6.1 : " + justification1Text);
            	    }
            	    
                    // === SECTION 6.2 === // 
              	  
              		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section6input2Label));
              	    WebElement section6Label2 = driver.findElement(section6input2Label);
              	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section6Label2);
              	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section6Label2);	    
              	     
              	    wait.until(ExpectedConditions.elementToBeClickable(section6Input2DatePicker));
              	    WebElement datePickerInput = driver.findElement(section6Input2DatePicker);
              	    
              	   ((JavascriptExecutor) driver).executeScript("arguments[0].click();", datePickerInput);
              	    
           	        JavascriptExecutor js2 = (JavascriptExecutor) driver;
              	    js2.executeScript("arguments[0].value = '';", datePickerInput);
              	    datePickerInput.sendKeys("05/31/2025");
              	    
              	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

              	    WebElement comment2CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
              	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[5]")
              	    ));

              	    int comment2Count = Integer.parseInt(comment2CountElement.getText().trim());
              	    System.out.println(comment2Count);
              	    Thread.sleep(2000);
              	    
              	    WebElement input2Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section6Input2Comment));
              	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input2Comment);
              	    
              	    if (comment2Count > 0) {
              	        String existingComment = input2Comment.getText();
              	        System.out.println("Existing Comment: " + existingComment);
              	    } else {
              	        String newComment = "The incident response plan was last updated on 31 May 2025.";
              	        input2Comment.sendKeys(newComment);
              	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
              	        System.out.println("Added new comment in section 6.2 : " + newComment);
              	    }
              	    
              	    
              	    WebElement input2Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section6Input2Justification));
              	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input2Justification);
              	    	    	    
              	    String justification2Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim()", input2Justification);
              	    System.out.println("Justification (cleaned): '" + justification2Value + "'");


              	    if (justification2Value == null || justification2Value.isEmpty()) {
              	        String justification2Text = "Mergers, IT infrastructure updates, or process changes necessitate plan revisions to maintain relevance.";
//              	        input2Justification.sendKeys(justification2Text);		   
              	        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input2Justification, justification2Text);
              	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
              		    System.out.println("Added justification in section 6.2 : " + justification2Text);
              	    }
              	    
                    // === SECTION 6.3 === // 
              	  
              		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section6input3Label));
              	    WebElement section6Label3 = driver.findElement(section6input3Label);
              	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section6Label3);
              	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section6Label3);	    
              	    
              	    wait.until(ExpectedConditions.visibilityOfElementLocated(section6Input3Radio));
              	    
              	    WebElement radio3Element = driver.findElement(section6Input3Radio);
              	    JavascriptExecutor js3 = (JavascriptExecutor) driver;
              	    js3.executeScript("arguments[0].scrollIntoView({block: 'center'});", radio3Element);
              	    js3.executeScript("arguments[0].click();", radio3Element);
     
              	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

              	    WebElement comment3CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
              	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[9]")
              	    ));

              	    int comment3Count = Integer.parseInt(comment3CountElement.getText().trim());
              	    System.out.println(comment3Count);
              	    Thread.sleep(2000);
              	    
              	    WebElement input3Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section6Input3Comment));
              	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input3Comment);
              	    
              	    if (comment3Count > 0) {
              	        String existingComment = input3Comment.getText();
              	        System.out.println("Existing Comment: " + existingComment);
              	    } else {
              	        String newComment = "We test our incident response plan at least annually, with additional scenario-based drills conducted after major updates or significant changes to our IT environment.";
              	        input3Comment.sendKeys(newComment);
              	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
              	        System.out.println("Added new comment in section 6.3 : " + newComment);
              	    }
              	    
              	    
              	    WebElement input3Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section6Input3Justification));
              	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input3Justification);
              	    	    	    
              	    String justification3Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim()", input3Justification);
              	    System.out.println("Justification (cleaned): '" + justification3Value + "'");


              	    if (justification3Value == null || justification3Value.isEmpty()) {
              	        String justification3Text = "Frameworks like NIST CSF, ISO 27001, and PCI DSS recommend annual testing as a minimum requirement to ensure preparedness.";
//              	        input3Justification.sendKeys(justification3Text);		   
              	        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input3Justification, justification3Text);
              	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
              		    System.out.println("Added justification in section 6.3 : " + justification3Text);
              	    }
            	    
              	     // === SECTION 6.4 === // 
            	    
            		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section6input4Label));
            	    WebElement section6Label4 = driver.findElement(section6input4Label);
            	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section6Label4);
            	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section6Label4);

            	    
            	    WebElement input4Answer = wait.until(ExpectedConditions.visibilityOfElementLocated(section6Input4Answer));
            	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input4Answer);

            	    String input4Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText || arguments[0].textContent;", input4Answer);    
            	    
            	    if (input4Value != null) {
            	    	input4Value = input4Value.replaceAll("\\u00A0", " ").trim();
            	    	Thread.sleep(3000);
            	    }
            	   
            	   
            		if (input4Value == null || input4Value.isEmpty()) {
            	        ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", input4Answer);
            		    String answerText = "We coordinate incident response activities through a structured communication framework, predefined escalation paths, and role-based stakeholder engagement.";
            		    input4Answer.sendKeys(answerText);
            		    Thread.sleep(1000);
            		    System.out.println("Input set in Section 6.4 Answer: " + answerText);
            		}

            	    WebElement comment4CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
            	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[13]")
            	    ));
            	                	    
            	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", comment4CountElement);

            	    int comment4Count = Integer.parseInt(comment4CountElement.getText().trim());
            	    System.out.println(comment4Count);
            	    Thread.sleep(2000);
            	    
            	    
            	    WebElement input4Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section6Input4Comment));
            	    if (comment4Count > 0) {
            	        System.out.println("Existing Comment: " + input4Comment.getText());
            	    } else {
            	    	input4Comment.sendKeys("Comment for Section 6.4");
            	        Thread.sleep(2000);
            	        wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
            	        System.out.println("Added new comment in section 6.4 : " + input4Comment);
            	    }

            	    
            	    WebElement input4Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section6Input4Justification));
            	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input4Justification);
            	    
            	    String justification4Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim()", input4Justification);
            	    System.out.println("Justification (cleaned): '" + justification4Value + "'");    
            	    	    
            	    
            	    if (justification4Value == null || justification4Value.isEmpty()) {
            	    	String justification4Text = "Cross-functional team (IT, Security, Legal, HR) activated via automated alerts (e.g., SIEM, EDR tools).";
//            	    	input4Justification.sendKeys(justification4Text);
            	        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input4Justification, justification4Text);
            	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
            	        System.out.println("Added justification in section 6.4 : " + justification4Text);
            	    }
            	  
            	      
             	     // === SECTION 6.5 === // 
            	    
    			    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section6input5Label));
    			    WebElement section6Label5 = driver.findElement(section6input5Label);
    			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section6Label5);
    			    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section6Label5);	    
    			    Thread.sleep(2000);
    			    
    			    wait.until(ExpectedConditions.presenceOfElementLocated(section6Input5CheckBox));

    			    WebElement checkbox5Element = driver.findElement(section6Input5CheckBox);
    			    JavascriptExecutor js5 = (JavascriptExecutor) driver;
    			    js5.executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", checkbox5Element);
    			    js5.executeScript("arguments[0].click();", checkbox5Element);
    			    	    
    			    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

    			    WebElement comment5CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
    			        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[17]")
    			    ));

    			    int comment5Count = Integer.parseInt(comment5CountElement.getText().trim());
    			    System.out.println(comment5Count);
    			    Thread.sleep(2000);
    			    
    			    WebElement input5Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section6Input5Comment));
    			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input5Comment);
    			    
    			    if (comment5Count > 0) {
    			        String existingComment = input5Comment.getText();
    			        System.out.println("Existing Comment: " + existingComment);
    			    } else {
    			        String newComment ="We integrate threat intelligence feeds into our security operations to proactively identify emerging threats, prioritize vulnerabilities, and automate response actions.";
    			        input5Comment.sendKeys(newComment);
    			        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
    			        System.out.println("Added new comment in section 6.5 : " + newComment);
    			    }
    			    
    			    
    			    WebElement input5Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section6Input5Justification));
    			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input5Justification);
    			    	    	    
    			    String justification5Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim()", input5Justification);
    			    System.out.println("Justification (cleaned): '" + justification5Value + "'");


    			    if (justification5Value == null || justification5Value.isEmpty()) {
    			        String justification5Text = "Feeds are reviewed quarterly for relevance and accuracy.";
//    			        input5Justification.sendKeys(justification5Text);		   
    		 	        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input5Justification, justification5Text);
    			        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
    				    System.out.println("Added justification in section 6.5 : " + justification5Text);
    			    }
    			    
            	 // === SECTION 6.6 === // 
            	    
   			    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section6input6Label));
   			    WebElement section6Label6 = driver.findElement(section6input6Label);
   			    JavascriptExecutor js6 = (JavascriptExecutor) driver;
   			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section6Label6);
   			    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section6Label6);	    
   			    Thread.sleep(2000);
   			    
        	    WebElement input6Answer = wait.until(ExpectedConditions.visibilityOfElementLocated(section6Input6Answer));
        	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input6Answer);

        	    String input6Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText || arguments[0].textContent;", input6Answer);    
        	    
        	    if (input6Value != null) {
        	    	input6Value = input6Value.replaceAll("\\u00A0", " ").trim();
        	    	Thread.sleep(3000);
        	    }
        	   
        	   
        		if (input6Value == null || input6Value.isEmpty()) {
        	        ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", input6Value);
        		    String answerText = "We mitigate newly identified vulnerabilities through a risk-based approach that includes immediate containment, prioritization via CVSS scoring, and remediation via patching.";
        		    input6Answer.sendKeys(answerText);
        		    System.out.println("Input set in Section 6.6 Answer: " + answerText);
        		}
   			

   			    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

   			    WebElement comment6CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
   			        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[21]")
   			    ));

   			    int comment6Count = Integer.parseInt(comment6CountElement.getText().trim());
   			    System.out.println(comment6Count);
   			    Thread.sleep(2000);
   			    
   			    WebElement input6Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section6Input6Comment));
   			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input6Comment);
   			    
   			    if (comment6Count > 0) {
   			        String existingComment = input6Comment.getText();
   			        System.out.println("Existing Comment: " + existingComment);
   			    } else {
   			        String newComment ="Our process ensures critical vulnerabilities are addressed within 48 hours, while lower-risk issues follow scheduled remediation cycles.";
   			        input6Comment.sendKeys(newComment);
   			        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
   			        System.out.println("Added new comment in section 6.6 : " + newComment);
   			    }
   			    
   			    
   			    WebElement input6Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section6Input6Justification));
   			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input6Justification);
   			    	    	    
   			    String justification6Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim()", input6Justification);
   			    System.out.println("Justification (cleaned): '" + justification6Value + "'");


   			    if (justification6Value == null || justification6Value.isEmpty()) {
   			        String justification6Text = "Feeds are reviewed quarterly for relevance and accuracy.";
//   			        input6Justification.sendKeys(justification6Text);		   
   			      ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input6Justification, justification6Text);
   			        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
   				    System.out.println("Added justification in section 6.6 : " + justification6Text);
   			    }
   			    
           	 // === SECTION 6.7 === // 
   			    
        		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section6input7Label));
        	    WebElement section6Label7 = driver.findElement(section6input7Label);
        	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section6Label7);
        	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section6Label7);	    
        	    
        	    wait.until(ExpectedConditions.visibilityOfElementLocated(section6Input7Radio));
        	    
        	    WebElement radio7Element = driver.findElement(section6Input7Radio);
        	    JavascriptExecutor js7 = (JavascriptExecutor) driver;
        	    js7.executeScript("arguments[0].scrollIntoView({block: 'center'});", radio7Element);
        	    js7.executeScript("arguments[0].click();", radio7Element);
        	    
        	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

        	    WebElement comment7CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
        	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[25]")
        	    ));

        	    int comment7Count = Integer.parseInt(comment7CountElement.getText().trim());
        	    System.out.println(comment7Count);
        	    Thread.sleep(2000);
        	    
        	    WebElement input7Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section6Input7Comment));
        	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input7Comment);
        	    
        	    if (comment7Count > 0) {
        	        String existingComment = input7Comment.getText();
        	        System.out.println("Existing Comment: " + existingComment);
        	    } else {
        	        String newComment = "We conduct formal post-incident reviews (PIRs) for all major security incidents and periodic reviews for minor events to identify root causes and improve our response processes.";
        	        input7Comment.sendKeys(newComment);
        	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
        	        System.out.println("Added new comment in section 6.7 : " + newComment);
        	    }
        	    
        	    
        	    WebElement input7Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section6Input7Justification));
        	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input7Justification);
        	    	    	    
        	    String justification7Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim()", input7Justification);
        	    System.out.println("Justification (cleaned): '" + justification7Value + "'");


        	    if (justification7Value == null || justification7Value.isEmpty()) {
        	        String justification7Text = "Post-incident reviews are documented, action-oriented, and shared with relevant stakeholders to ensure continuous improvement in our security posture.";
//        	        input7Justification.sendKeys(justification7Text);		   
        	        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input7Justification, justification7Text);
        	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
        		    System.out.println("Added justification in section 6.7 : " + justification7Text);
        	    }
            	        
              }
              
              
              public void section7Header() {
            	  
          		String expectedHeader = "RECOVER (RC)";
          		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section7Header));
          		String actualHeader = driver.findElement(section7Header).getText();
          		System.out.println(actualHeader);
          		Assert.assertEquals(actualHeader,expectedHeader);
            	  
              }
              
              public void section7Answer() throws InterruptedException {
            	  
                // === SECTION 7.1  === // 
            	  
          		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section7input1Label));
        	    WebElement section7Label1 = driver.findElement(section7input1Label);
        	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section7Label1);
        	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section7Label1);	    
        	    
        	    wait.until(ExpectedConditions.visibilityOfElementLocated(section7Input1Radio));
        	    
        	    WebElement radio1Element = driver.findElement(section7Input1Radio);
        	    JavascriptExecutor js1 = (JavascriptExecutor) driver;
        	    js1.executeScript("arguments[0].scrollIntoView({block: 'center'});", radio1Element);
        	    js1.executeScript("arguments[0].click();", radio1Element);
        	    
        	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

        	    WebElement comment1CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
        	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[1]")
        	    ));

        	    int comment1Count = Integer.parseInt(comment1CountElement.getText().trim());
        	    System.out.println(comment1Count);
        	    Thread.sleep(2000);
        	    
        	    WebElement input1Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section7Input1Comment));
        	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input1Comment);
        	    
        	    if (comment1Count > 0) {
        	        String existingComment = input1Comment.getText();
        	        System.out.println("Existing Comment: " + existingComment);
        	    } else {
        	        String newComment = "Our organization maintains documented recovery plans that are regularly reviewed and updated to ensure alignment with current business operations and evolving risk scenarios.";
        	        input1Comment.sendKeys(newComment);
        	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
        	        System.out.println("Added new comment in section 7.1 : " + newComment);
        	    }
        	    
        	    
        	    WebElement input1Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section7Input1Justification));
        	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input1Justification);
        	    	    	    
        	    String justification1Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim()", input1Justification);
        	    System.out.println("Justification (cleaned): '" + justification1Value + "'");


        	    if (justification1Value == null || justification1Value.isEmpty()) {
        	        String justification1Text = "Documented recovery plans are essential for ensuring business continuity during unexpected disruptions.";		   
        	        ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input1Justification, justification1Text);
        	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
        		    System.out.println("Added justification in section 7.1 : " + justification1Text);
        	    }
        	    
        	    
        	 // === SECTION 7.2 === // 
        	      
        	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section7input2Label));
      	    WebElement section7Label2 = driver.findElement(section7input2Label);
      	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section7Label2);
      	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section7Label2);	    
      	    
      	    wait.until(ExpectedConditions.visibilityOfElementLocated(section7Input2Radio));
      	    
      	    WebElement radio2Element = driver.findElement(section7Input2Radio);
      	    JavascriptExecutor js2 = (JavascriptExecutor) driver;
      	    js2.executeScript("arguments[0].scrollIntoView({block: 'center'});", radio2Element);
      	    js2.executeScript("arguments[0].click();", radio1Element);
      	    
      	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

      	    WebElement comment2CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
      	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[5]")
      	    ));

      	    int comment2Count = Integer.parseInt(comment2CountElement.getText().trim());
      	    System.out.println(comment2Count);
      	    Thread.sleep(2000);
      	    
      	    WebElement input2Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section7Input2Comment));
      	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input2Comment);
      	    
      	    if (comment2Count > 0) {
      	        String existingComment = input2Comment.getText();
      	        System.out.println("Existing Comment: " + existingComment);
      	    } else {
      	        String newComment = "Quarterly testing ensures our recovery procedures remain effective, up-to-date, and aligned with evolving threats and business needs.";
      	        input2Comment.sendKeys(newComment);
      	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
      	        System.out.println("Added new comment in section 7.2 : " + newComment);
      	    }
      	    
      	    
      	    WebElement input2Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section7Input2Justification));
      	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input2Justification);
      	    	    	    
      	    String justification2Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim()", input2Justification);
      	    System.out.println("Justification (cleaned): '" + justification2Value + "'");


      	    if (justification2Value == null || justification2Value.isEmpty()) {
      	        String justification2Text = "Identifies gaps e.g., backup failures, misconfigured failover systems before real incidents occur.";		   
      	       ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input2Justification, justification2Text);
      	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
      		    System.out.println("Added justification in section 7.2 : " + justification2Text);
      	    }
      	    
      	  	 // === SECTION 7.3 === // 
            	  
      	    
        	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section7input3Label));
      	    WebElement section7Label3 = driver.findElement(section7input3Label);
      	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section7Label3);
      	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section7Label3);	    
      	    
      	    wait.until(ExpectedConditions.visibilityOfElementLocated(section7Input3Radio));
      	    
      	    WebElement radio3Element = driver.findElement(section7Input3Radio);
      	    JavascriptExecutor js3 = (JavascriptExecutor) driver;
      	    js3.executeScript("arguments[0].scrollIntoView({block: 'center'});", radio3Element);
      	    js3.executeScript("arguments[0].click();", radio3Element);
      	    
      	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

      	    WebElement comment3CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
      	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[9]")
      	    ));

      	    int comment3Count = Integer.parseInt(comment3CountElement.getText().trim());
      	    System.out.println(comment3Count);
      	    Thread.sleep(2000);
      	    
      	    WebElement input3Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section7Input3Comment));
      	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input3Comment);
      	    
      	    if (comment3Count > 0) {
      	        String existingComment = input3Comment.getText();
      	        System.out.println("Existing Comment: " + existingComment);
      	    } else {
      	        String newComment = "This RTO balances operational resilience with practical recovery capabilities, ensuring minimal disruption to business continuity.";
      	        input3Comment.sendKeys(newComment);
      	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
      	        System.out.println("Added new comment in section 7.3 : " + newComment);
      	    }
      	    
      	    
      	    WebElement input3Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section7Input3Justification));
      	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input3Justification);
      	    	    	    
      	    String justification3Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim()", input3Justification);
      	    System.out.println("Justification (cleaned): '" + justification3Value + "'");


      	    if (justification3Value == null || justification3Value.isEmpty()) {
      	        String justification3Text = "E-commerce platforms restore within 12 hours, while internal HR systems may follow a 48-hour RTO.";
//      	        input3Justification.sendKeys(justification3Text);		   
       	       ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input3Justification, justification3Text);
      	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
      		    System.out.println("Added justification in section 7.3 : " + justification3Text);
      	    }
      	    
      	    
      	 	 // === SECTION 7.4 === // 
      	    
    	    
      	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section7input4Label));
		    WebElement section7Label4 = driver.findElement(section7input4Label);
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section7Label4);
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section7Label4);
		    Thread.sleep(2000);

		    
		    WebElement input4Answer = wait.until(ExpectedConditions.visibilityOfElementLocated(section7Input4Answer));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input4Answer);

		    String input4Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText || arguments[0].textContent;", input4Answer);    
		    
		    if (input4Value != null) {
		    	input4Value = input4Value.replaceAll("\\u00A0", " ").trim();
		    	Thread.sleep(3000);	
		    }

		   
		    	if (input4Value == null || input4Value.isEmpty()) {
		    		((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", input4Value);
		    	    String answerText = "Lessons learned are incorporated into our recovery planning through structured post-incident reviews and continuous improvement cycles.";
		    	    input4Answer.sendKeys(answerText);
		    	    System.out.println("Input set in Section 7.4 Answer: " + answerText);
		    	}
		    	
		    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

		    	
		    WebElement comment4CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
		        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[13]")
		    ));
		    
		    int comment4Count = Integer.parseInt(comment4CountElement.getText().trim());
		    System.out.println(comment4Count);
		    Thread.sleep(2000);
		    
		    
		    WebElement input4Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section7Input4Comment));
		    if (comment4Count > 0) {
		        System.out.println("Existing Comment: " + input4Comment.getText());
		    } else {
		    	input4Comment.sendKeys("After every incident response or recovery exercise, we conduct a root cause analysis and document the findings in a lessons-learned report.");
		        Thread.sleep(2000);
		        wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
		        System.out.println("Added new comment in section 7.4 : " + input4Comment);
		    }

		    
		    WebElement input4Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section7Input4Justification));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input4Justification);
		    
		    String justification4Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim()", input4Justification);
		    System.out.println("Justification (cleaned): '" + justification4Value + "'");    
		    	    
		    
		    
		    if (justification4Value == null || justification4Value.isEmpty()) {
		    	String justification4Text = "Integrating lessons learned into recovery planning ensures that the organization evolves and improves its preparedness over time.";
//		    	input4Justification.sendKeys(justification4Text);
	      	    ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input4Justification, justification4Text);
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		        System.out.println("Added justification in section 7.4 : " + justification4Text);
		    }	
      	    

		    
      	    
      	 	 // === SECTION 7.5 === // 
      	    
    	    
      	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section7input5Label));
		    WebElement section7Label5 = driver.findElement(section7input5Label);
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section7Label5);
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", section7Label5);
		    Thread.sleep(2000);

		    
		    WebElement input5Answer = wait.until(ExpectedConditions.visibilityOfElementLocated(section7Input5Answer));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input5Answer);

		    String input5Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText || arguments[0].textContent;", input5Answer);    
		    
		    if (input5Value != null) {
		    	input5Value = input5Value.replaceAll("\\u00A0", " ").trim();
		    	Thread.sleep(3000);	
		    }

		   
		    	if (input5Value == null || input5Value.isEmpty()) {
		    		((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", input5Value);
		    	    String answerText = "We manage public relations during security incident recovery through a coordinated communication strategy led by our Corporate Communications team.";
		    	    input5Answer.sendKeys(answerText);
		    	    System.out.println("Input set in Section 7.4 Answer: " + answerText);
		    	}
		    	
		    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

		    	
		    WebElement comment5CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
		        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[17]")
		    ));
		    
		    int comment5Count = Integer.parseInt(comment5CountElement.getText().trim());
		    System.out.println(comment5Count);
		    Thread.sleep(2000);
		    
		    
		    WebElement input5Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section7Input5Comment));
		    if (comment5Count > 0) {
		        System.out.println("Existing Comment: " + input5Comment.getText());
		    } else {
		    	input5Comment.sendKeys("A predefined crisis communication plan is in place, which outlines how and when to communicate with the public, media, customers, and partners.");
		        Thread.sleep(2000);
		        wait.until(ExpectedConditions.visibilityOfElementLocated(loader));
		        System.out.println("Added new comment in section 7.4 : " + input4Comment);
		    }

		    
		    WebElement input5Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section7Input5Justification));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input5Justification);
		    
		    String justification5Value = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText.trim()", input5Justification);
		    System.out.println("Justification (cleaned): '" + justification5Value + "'");    
		    	    
		    
		    
		    if (justification5Value == null || justification5Value.isEmpty()) {
		    	String justification5Text = "Effective public relations management is critical during recovery to uphold the organization’s reputation and prevent misinformation.";
//		    	input5Justification.sendKeys(justification5Text);
		   	    ((JavascriptExecutor) driver).executeScript("arguments[0].innerText = arguments[1];", input5Justification, justification5Text);
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		        System.out.println("Added justification in section 7.5 : " + justification5Text);
		    }	
      	     	  
           }
              
              public void section8Header() {
           		String expectedHeader = "Assessment Decision";
          		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section8Header));
          		String actualHeader = driver.findElement(section8Header).getText();
          		System.out.println(actualHeader);
          		Assert.assertEquals(actualHeader,expectedHeader);
            	  
              }
	
}