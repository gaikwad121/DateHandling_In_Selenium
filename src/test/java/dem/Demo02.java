package dem;
//File: LeadTests.java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class Demo02 {
 private WebDriver driver;
 // 👉 Replace this with the actual CRM URL shared in your assignment
 private String baseUrl = "";

 @BeforeClass
 public void setUp() {
     // You can add WebDriverManager if you want automatic driver setup
     // Example: WebDriverManager.chromedriver().setup();
     driver = new ChromeDriver();
     driver.manage().window().maximize();
 }

 @AfterClass
 public void tearDown() {
     if (driver != null) driver.quit();
 }

 @Test(priority = 1)
 public void testLogin() throws InterruptedException {
     // Navigate to login page
     driver.get("https://demo.peppercloud.com/login");

     // 🔒 Replace the locators below with your actual field IDs or CSS selectors
     
     WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
     WebElement password = driver.findElement(By.id("password"));
     WebElement loginBtn  = driver.findElement(By.cssSelector("button[type='submit']"));

     // 🚫 No credentials here — fill them in locally before running
     username.sendKeys("your-username-here");
     password.sendKeys("your-password-here");
     loginBtn.click();

     // Wait briefly and check if the Leads page is shown
     Thread.sleep(3000);
     assertTrue(driver.getCurrentUrl().contains("/leads"),
             "Expected to land on the Leads page after login");
 }

 @Test(priority = 2, dependsOnMethods = "testLogin")
 public void testCreateNewLead() throws InterruptedException {
     // Click the Create New button
     WebElement createBtn = driver.findElement(By.id("createLeadBtn"));
     createBtn.click();

     // Fill in the Lead form (example locators)
     driver.findElement(By.id("lead_name")).sendKeys("Automation Lead");
     driver.findElement(By.id("lead_email")).sendKeys("auto.lead+" + System.currentTimeMillis() + "@example.com");
     driver.findElement(By.id("lead_phone")).sendKeys("9876543210");

     // Submit
     driver.findElement(By.id("saveLeadBtn")).click();

     // Verify success message or that new record appears
     Thread.sleep(2000);
     WebElement toast = driver.findElement(By.cssSelector(".toast-success"));
     assertTrue(toast.isDisplayed(), "Success toast should be visible after creating a lead");
 }
}
