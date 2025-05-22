package tests;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.SignUpPage;

public class TenantRegistrationTest extends BaseTest{
	
	
	@Test
	public void createNewTenant() throws InterruptedException {

		SignUpPage signUp = new SignUpPage(driver, wait);
		
		
        // Generate timestamp-based unique identifier
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        // Dynamic email and domain
        String email = "darshak" + timestamp + "@yopmail.com";
        String domain = "flyingqa" + timestamp + ".com";
        
        
        signUp.registerLink();
		signUp.enterFirstName("Darshak");
		signUp.enterLastName("Paladiya");
		signUp.enterEmail(email);
		signUp.enterPhoneNo("9998887777"); 
		signUp.enterOrgName("Flying QA");
		signUp.enterDomainName(domain);
		signUp.selectCompanysize("51 - 250 Employees");
		signUp.selectVendorDropdownOption("51 - 250 Vendors");
		signUp.enterPassword("Test@1234");
		signUp.enterConfirmPassword("Test@1234");
		signUp.clickNext1();
		signUp.clickFreeTrial();
		signUp.clickStrip();
		signUp.cardDetails();
		signUp.clickProccedToPayment();
		Thread.sleep(5000);
		signUp.clickVerifyEmail();
	    signUp.verifyEmailAndLogin(email);

	}

}