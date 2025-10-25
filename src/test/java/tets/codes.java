package tets;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class codes {

    WebDriver driver;

    @BeforeMethod
    void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @Test
    void selectDateOnRedbus() throws InterruptedException {
        driver.get("https://www.redbus.in/");
        Thread.sleep(2000);

        String targetYear = "2026";
        String targetMonth = "January";
        String targetDay = "10";

        // Open calendar
        driver.findElement(By.xpath("//div[contains(@class,'dateInputWrapper')]")).click();
        Thread.sleep(2000);

        while (true) {
            // Get visible month and year
            WebElement monthYearElement = driver.findElement(By.xpath("//p[@class='monthYear___d72513']"));
            String monthYearText = monthYearElement.getText(); // e.g., "October 2025"
            System.out.println("Currently showing: " + monthYearText);

            String[] parts = monthYearText.split(" ");
            String currentMonth = parts[0];
            String currentYear = parts[1];

            // Check if desired month and year reached
            if (currentMonth.equalsIgnoreCase(targetMonth) && currentYear.equals(targetYear)) {
                break;
            } else {
                // Click next arrow
                driver.findElement(By.xpath("(//*[@class='monthHolidays___9bdbd5']/following::i)[1]")).click();
                Thread.sleep(800);
            }
        }

        // Select the day
        String xpath = "//span[text()='" + targetDay + "']";
        System.out.println("Using XPath: " + xpath);

        WebElement w = driver.findElement(By.xpath(xpath));
        System.out.println("Found element text: " + w.getText());
        w.click();


        Thread.sleep(2000);
    }
@Test
void test2() {
	driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
	driver.findElement(By.id("dob")).click();
	WebElement li=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
	//Select s=new Select(li);
//s.selectByVisibleText("Apr");
	selDate(li,"Apr");
	WebElement year=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
	selDate(year,"2002");
	//WebElement Day=driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td//a"));
	//selDate(Day,"14");
    	 List<WebElement> Day=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td//a"));
    	 for(WebElement D : Day) {
    		 String DayExpected="14";
    		 String op=D.getText();
    		 if(op.equalsIgnoreCase(DayExpected)) {
    			 D.click();
    			 break;
    		 }
    	 }
     }
    	
		public void selDate(WebElement web,String value) {
			//WebElement li=driver.findElement(By.xpath("web"));
			Select s=new Select(web);
		s.selectByVisibleText(value);
		}
	
	

    @AfterMethod
    void teardown() {
        if (driver != null) {
            //driver.quit();
        }
    }
}
