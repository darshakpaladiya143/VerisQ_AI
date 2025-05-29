package tests;

import org.testng.annotations.Test;
import base.BaseTest;
import pages.AssessmentPage;
import pages.LoginPage;

public class DefaultAssessmentTest extends BaseTest {

	@Test
	public void performDefaultAssessment() throws InterruptedException {
		
		LoginPage login = new LoginPage(driver,wait);
		AssessmentPage assessment = new AssessmentPage(driver,wait);
		
		
		login.loginEmail("flyingqa20250527144844@yopmail.com");
		login.loginPassword("Test@1234");
		login.submitLogin();
		
		login.getLoggedInUserName();
		login.sideMenuWrap();
		login.clickThirdPartyRisk();
		login.visibilityOfGraph();
		login.sideMenuWrap();
		login.clickAssResponseMenu();
		
		assessment.scrollUpToLatestAssessment();		
		assessment.getWaitForResponder();
		
		// Section -1 
		
		assessment.section1Answer();
		assessment.nextBtn();
		
        // Section - 2 		
	
		assessment.section2GetHeader();
		assessment.section2Answer();
		assessment.nextBtn();
		
		
		// Section -3 
		
		assessment.section3GetHeader();
		assessment.section3Answer();
		assessment.nextBtn();
		
		// Section - 4 
		
		assessment.section4GetHeader();
		assessment.section4Answer();
		assessment.nextBtn();
		
		// Section - 5 
		
		assessment.section5GetHeader();
		assessment.section5Answer();
		assessment.nextBtn();
		
		// Section - 6
		
		assessment.section6GetHeader();
		assessment.section6Answer();
		assessment.nextBtn();
		
		// Section -7 
		
		assessment.section7GetHeader();
		assessment.section7Answer();
		assessment.nextBtn();
		
		// Section -8 
		
		assessment.section8GetHeader();
		assessment.completeAssessment();
			
		
	}
	
}
