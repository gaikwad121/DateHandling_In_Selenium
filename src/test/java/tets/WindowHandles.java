package tets;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {
WebDriver driver;

@BeforeMethod

void setUp() {
WebDriverManager.chromedriver().setup();
ChromeOptions options=new ChromeOptions();
options.addArguments("-start-maximized");
driver=new ChromeDriver(options);
}
@Test
void test() throws InterruptedException {
	driver.get("https://www.amazon.in/");
	//String windId=driver.getWindowHandle();
	//System.out.println(windId+" "+driver.getTitle());
	/*driver.findElement(By.linkText("Online Trainings")).click();
	//String childWind=driver.getWindowHandle();
	//System.out.println(childWind+" "+driver.getTitle());
	Set<String> windows = driver.getWindowHandles();
   /* Iterator<String> it = windows.iterator();
    String parentWind=it.next();
    String childWind=it.next();
    System.out.println(parentWind);
    System.out.println(childWind);*/
/*	ArrayList<String> arr=new ArrayList<>(windows);
	
	for(String wind : arr) {
	String Title=driver.switchTo().window(wind).getTitle();
	if(Title.equals("SDET-QA")) {
		
		driver.close();*/
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

WebElement el=	driver.findElement(By.xpath("//div[@class='nav-search-field ']//input"));
	el.click();
	el.sendKeys("One-plus");
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	List<WebElement> li=driver.findElements(By.xpath("//div[@id='sac-autocomplete-results-container']//div//span"));
		for(WebElement listphone : li) {
			Thread.sleep(2000);
			//wait.until(ExpectedConditions.elementIfVisible(listphone))
String price=listphone.getText();
			System.out.println(listphone.getText());
			if(price.equals("oneplus 12")) {
				listphone.click();
			}
			List<WebElement> m=driver.findElements(By.xpath("//span[@class='a-price']//span//span[2]"));

	
}
			
		}
	}

