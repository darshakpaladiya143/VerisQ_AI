package utils;

import java.util.Locale;

import com.github.javafaker.Faker;

public class TestDataGenerator {
	
	// Initialize Faker Library 
	
    @SuppressWarnings("deprecation")
	private static final Faker faker = new Faker(new Locale("en-US"));

    public static String getFirstName() {
        return faker.name().firstName();
    }
    
    public static String getLastName() {
        return faker.name().lastName();
    }
    
    public static String getPhoneNumber() {
        return faker.phoneNumber().cellPhone()
                .replaceAll("[^0-9]", ""); // Removes non-numeric characters
    }
    
    public static String getCompanyName() {
        return faker.company().name();
    }
    
    
    public static String getDomainName() {
        return faker.internet().domainName();
    }
    
    public static String getProductName() {
        return faker.commerce().productName();
    }
    
    public static String getProductDescription() {
        return faker.lorem().paragraph();
    }
    
    // Unique identifiers
    
//    public static String getUniqueEmail() {
//        return "darshak_" + System.currentTimeMillis() + "@yopmail.com";
//    }
    
    
//    public static String getUniqueDomain() {
//        return "flyingqa" + System.currentTimeMillis() + ".com";
//    }
    
    
//    public static String getPassword() {
//        return faker.internet().password(8, 12, true, true, true);
//    }

}
