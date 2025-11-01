package tets;

import java.time.Duration;

import java.util.List;

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

public class GoogleComtest {

	
	WebDriver driver;
	
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--start-maximized");
		driver =new ChromeDriver(option);
	}
	@Test
	public void test() {
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("q")).sendKeys("Selenium");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='wM6W7d']//span")));

		List<WebElement> li=driver.findElements(By.xpath("//div[@class='wM6W7d']//span"));
		for(WebElement list : li) {
			String txt=list.getText();
			System.out.println(txt);
			//if(txt.toLowerCase().contains("python")) {
			if(txt.equals("selenium webdriver")) {
				list.click();
				System.out.println("Done click on button");
				break;
			}
		}
	}
}
