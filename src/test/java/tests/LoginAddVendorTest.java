package tests;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.VendorPage;

public class LoginAddVendorTest extends BaseTest {
	
	
	@Test
	public void loginAddVednor() throws InterruptedException {
		
	
	    String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	    String domain = "flyingqa" + timestamp + ".com";
	    String vendorName = "FlyingQA_" + timestamp ;
	    String vendorEmail = "flyingqa" + timestamp + "@yopmail.com";
		
		
		LoginPage login = new LoginPage(driver,wait);
		VendorPage vendor = new VendorPage(driver,wait);
		
		login.loginEmail("darshak20250521162148@yopmail.com");
		login.loginPassword("Test@1234");
		login.submitLogin();
		
		login.getLoggedInUserName();
		login.sideMenuWrap();
		login.clickThirdPartyRisk();
		login.visibilityOfGraph();
		login.sideMenuWrap();
		
		login.clickManageVendor();
		
		// Form - Step : 1 
		
		vendor.clickAddVendor();
		vendor.enterVendorName(vendorName);
		vendor.enterVendorContantNo("8866180955");
		vendor.enterProductName("Browser Stack");	
		vendor.enterPrimaryDomainName(domain);
		vendor.dataShareWithVednor();
		vendor.enterProductUrl("https://www." + domain);
        vendor.enterProductDescription("Automation Testing Platform");
        vendor.selectServices();
        
        vendor.enterContactEmail(vendorEmail);
        vendor.enterContnactName("Darshak");        
        vendor.nextButton();
        
        // Form - Step : 2
        vendor.selectRadioButton("1.1", "Yes");  
        vendor.selectRadioButton("1.2", "No");  
        vendor.selectRadioButton("1.5", "Yes");
        vendor.selectRadioButton("1.6", "Yes");
        vendor.selectRadioButton("1.7", "No");
        vendor.scrollToQuestion("1.8");
        vendor.selectRadioButton("1.8", "No");
        vendor.saveBtn();
        vendor.getVendorNameFromTable();
        vendor.setVendorPassword(vendorEmail);
        
//		login.clickProfile();
		
	}

}