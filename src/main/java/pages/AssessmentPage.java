package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	private By section3Input3CheckBox = By.xpath("//label[span[@class='e-label' and normalize-space(text())='By business impact']]/input[@type='checkbox']");
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
	
	private By section4Input4Checkbox = By.xpath("//label[span[@class='e-label' and normalize-space(text())='Mandatory access control (MAC)']]");
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
	
	private By section4Input9Checkbox = By.xpath("//label[.//span[@class='e-label' and normalize-space(text())='Database activity monitoring']]");
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
	    	    	    
	    String justificationValue = (String) ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", input1Justification);
	    System.out.println("Justification (cleaned): '" + justificationValue + "'");


	    if (justificationValue == null || justificationValue.isEmpty()) {
	        String justification1Text = "Our organization has developed a comprehensive cybersecurity strategy that is formally documented and reviewed regularly.";
	        input1Justification.sendKeys(justification1Text);		   
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
	    Thread.sleep(1000);
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
	    	    	    
	    String justification2Value = (String) ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", input2Justification);
	    System.out.println("Justification (cleaned): '" + justification2Value + "'");


	    if (justification2Value == null || justification2Value.isEmpty()) {
	    	
	        String justification2Text = "Annual ensures consistent evaluation while meeting compliance standards (ISO 27001, NIST CSF) and adapting to emerging threats.";
	        input2Justification.sendKeys(justification2Text);
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
	    	    	    
	    String justification3Value = (String) ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", input3Justification);
	    System.out.println("Justification (cleaned): '" + justification3Value + "'");


	    if (justification3Value == null || justification3Value.isEmpty()) {
	    		    	
	        String justification3Text = "Currently, there is no dedicated executive role overseeing cybersecurity risks";

	        input3Justification.sendKeys(justification3Text);
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
	    	    	    
	    String justification4Value = (String) ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", input4Justification);
	    System.out.println("Justification (cleaned): '" + justification4Value + "'");


	    if (justification4Value == null || justification4Value.isEmpty()) {
	    	    	
	        String justification4Text = "The program involves periodic risk assessments, asset classification, threat modeling, and controls evaluation.";
	        input4Justification.sendKeys(justification4Text);
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
	    
	    String justification5Value = (String) ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", input5Justification);
	    System.out.println("Justification (cleaned): '" + justification5Value + "'");    
	    	    
	    
	    
	    if (justification5Value == null || justification5Value.isEmpty()) {
	    	String justification5Text = "Risk tolerance is established by evaluating the potential impact of cybersecurity threats.";
	    	input5Justification.sendKeys(justification5Text);
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
    System.out.println(comment5Count);
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
    
    String justification6Value = (String) ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", input6Justification);
    System.out.println("Justification (cleaned): '" + justification6Value + "'");    
    	    
    
    
    if (justification6Value == null || justification6Value.isEmpty()) {
    	String justification6Text = "The effectiveness assessment methodology aligns with regulatory requirements and industry best practices.";
    	input6Justification.sendKeys(justification6Text);
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
    
    String justification7Value = (String) ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", input7Justification);
    System.out.println("Justification (cleaned): '" + justification7Value + "'");    
    	    
    
    
    if (justification7Value == null || justification7Value.isEmpty()) {
    	String justification7Text = "The effectiveness assessment methodology aligns with regulatory requirements and industry best practices.";
    	input7Justification.sendKeys(justification7Text);
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
    
    String justification8Value = (String) ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", input8Justification);
    System.out.println("Justification (cleaned): '" + justification8Value + "'");    
    	    
    
    
    if (justification8Value == null || justification8Value.isEmpty()) {
    	String justification8Text = "Our organization maintains formal agreements with all critical suppliers that include explicit cybersecurity requirements aligned with [ISO 27001/NIST CSF/PCI DSS].";
    	input8Justification.sendKeys(justification8Text);
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
	    	    	    
	    String justificationValue = (String) ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", input1Justification);
	    System.out.println("Justification (cleaned): '" + justificationValue + "'");


	    if (justificationValue == null || justificationValue.isEmpty()) {
	        String justification1Text = " Business units document assets under their control through spreadsheets and procurement records.";
	        input1Justification.sendKeys(justification1Text);		   
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		    System.out.println("Added justification in section 3.1 : " + justification1Text);
	    }
	    
	    
		// === SECTION 3.2 ===
	    
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(section3input2Label));
	    WebElement section3Label2 = driver.findElement(section3input2Label);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", section3Label2);
	    section3Label2.click();
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(section3Input1Radio));
	    
	    WebElement radio2Element = driver.findElement(section3Input1Radio);
	    JavascriptExecutor js1 = (JavascriptExecutor) driver;
	    js1.executeScript("arguments[0].scrollIntoView({block: 'center'});", radio1Element);
	    js1.executeScript("arguments[0].click();", radio1Element);
	    
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

	    WebElement comment2CountElement = wait.until(ExpectedConditions.presenceOfElementLocated(
	        By.xpath("(//div[@class='button-list-right']//span[@class='item-count-design'])[1]")
	    ));

	    int comment2Count = Integer.parseInt(comment2CountElement.getText().trim());
	    System.out.println(comment2Count);
	    Thread.sleep(2000);
	    
	    WebElement input2Comment = wait.until(ExpectedConditions.visibilityOfElementLocated(section3Input2Comment));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input2Comment);
	    
	    if (comment2Count > 0) {
	        String existingComment = input1Comment.getText();
	        System.out.println("Existing Comment: " + existingComment);
	    } else {
	        String newComment = "Our IT asset inventory is formally updated on an annual basis, aligned with our fiscal year-end audit process.";
	        input2Comment.sendKeys(newComment);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
	        System.out.println("Added new comment in section 3.2 : " + newComment);
	    }
	    
	    
	    WebElement input2Justification = wait.until(ExpectedConditions.visibilityOfElementLocated(section3Input2Justification));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input2Justification);
	    	    	    
	    String justification2Value = (String) ((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '';", input2Justification);
	    System.out.println("Justification (cleaned): '" + justification2Value + "'");


	    if (justification2Value == null || justification2Value.isEmpty()) {
	        String justification2Text = "Changes to these systems require change advisory board (CAB) approval, which triggers manual inventory updates";
	        input2Justification.sendKeys(justification2Text);		   
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		    System.out.println("Added justification in section 3.2 : " + justification2Text);
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	}	
}