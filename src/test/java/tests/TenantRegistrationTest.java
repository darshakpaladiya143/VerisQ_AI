package tests;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.SignUpPage;
import utils.TestDataGenerator;

public class TenantRegistrationTest extends BaseTest {
	
    @BeforeMethod
    public void setUp() {
        launchUrl("mainAppUrl");
    }
	
	
	@Test
	public void createNewTenant() throws InterruptedException {

		SignUpPage signUp = new SignUpPage(driver, wait);
		
		
        // Generate timestamp-based unique identifier
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        // Dynamic email and domain
        String email = "darshak" + timestamp + "@yopmail.com";
        String domain = "flyingqa" + timestamp + ".com";
        
        
        signUp.registerLink();
        
		signUp.enterFirstName(TestDataGenerator.getLastName());
		signUp.enterLastName(TestDataGenerator.getLastName());
		
		signUp.enterEmail(email);
		signUp.enterPhoneNo(TestDataGenerator.getPhoneNumber()); 
		signUp.enterOrgName(TestDataGenerator.getCompanyName());
		
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
	
	
    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
	

}