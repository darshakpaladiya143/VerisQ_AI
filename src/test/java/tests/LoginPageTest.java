package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginPageTest extends BaseTest {
	
	
	@Test
	public void loginAddVednor() throws InterruptedException {
		
		LoginPage login = new LoginPage(driver,wait);
		
		login.loginEmail("darshak20250521162148@yopmail.com");
		login.loginPassword("Test@1234");
		login.submitLogin();
		
		login.getLoggedInUserName();
		
		login.sideMenuWrap();
		
		login.clickThirdPartyRisk();
		
		login.getLoggedInUserName();
		
		login.sideMenuWrap();
        
//		login.clickProfile();
		
		
	}

}
