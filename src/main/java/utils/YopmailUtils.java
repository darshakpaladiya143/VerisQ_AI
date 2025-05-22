package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class YopmailUtils {

    private WebDriver driver;
    private WebDriverWait wait;

    public YopmailUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void openInbox(String email) {
        driver.get("https://yopmail.com/en/");
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        input.clear();
        input.sendKeys(email);
        driver.findElement(By.xpath("//button[@title='Check Inbox @yopmail.com']")).click();
    }

    public void waitForEmailAndClickLink() throws InterruptedException {
        int retries = 0;
        while (retries < 12) {
            try {
                driver.switchTo().defaultContent();
                driver.switchTo().frame("ifinbox");

                WebElement email = new WebDriverWait(driver, Duration.ofSeconds(5))
                        .until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.m")));
                email.click();
                break;
            } catch (Exception e) {
                retries++;
                System.out.println("Retrying... " + retries);
                driver.switchTo().defaultContent();
                driver.findElement(By.id("refresh")).click();
                Thread.sleep(5000);
            }
        }

        driver.switchTo().defaultContent();
        driver.switchTo().frame("ifmail");

        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@href, 'EmailConfirmationToken')]")));
        String parent = driver.getWindowHandle();
        link.click();

        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(parent)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    public void loginVerifiedUser(String email) {
        driver.findElement(By.id("userName")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(Constants.TEST_PASSWORD);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }
}

