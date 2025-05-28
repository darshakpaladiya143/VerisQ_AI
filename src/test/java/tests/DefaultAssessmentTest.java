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
		
		assessment.section1Answer();
		
		assessment.nextBtn();
		
        // Section - 2 		
		
		assessment.section2GetHeader();
		assessment.section2Answer();
		assessment.nextBtn();
		
		// Section -3
		
//		assessment.section3GetHeader();
		
	}
	
}
