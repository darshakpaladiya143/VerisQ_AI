package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.AssessmentPage;
import pages.LoginPage;

public class DefaultAssessmentTest extends BaseTest {
	
	
    @BeforeMethod
    public void setUp() {
        launchUrl("vendorResponderUrl");
    }
	

	@Test
	public void performDefaultAssessment() throws InterruptedException {
		
		LoginPage login = new LoginPage(driver,wait);
		AssessmentPage assessment = new AssessmentPage(driver,wait);
		
		
		login.loginEmail("flyingqa20250604181540@yopmail.com");
		login.loginPassword("Test@1234");
		login.submitLogin();	
		login.getLoggedInUserName();

		assessment.clickOnDefaultAssessment();		
		assessment.getWaitForResponder();
		
		// Section - 1 
		
		assessment.section1Answer();
		assessment.nextBtn();
		assessment.section2Header();
		
		// Section - 2
		
		assessment.section2Answer();
//		assessment.nextBtn();
//		assessment.section3Header();
		
		
		
		
	}
	
	
	
	
	
	
	
//    @AfterMethod
//    public void tearDown() {
//        quitDriver();
//    }
	
	
}
