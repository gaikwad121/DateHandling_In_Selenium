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

public class BootStrampDropDown {
WebDriver driver;

@BeforeMethod
void setup() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");
    driver = new ChromeDriver(options);
}
@Test
void test() {
	driver.get("https://www.hdfcbank.com/");
	
	WebElement Dropclk=driver.findElement(By.xpath("(//div[@class='dropdown']//a)[1]"));
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(Dropclk));
	Dropclk.click();
	List<WebElement> li=driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']//li"));
	System.out.println(li.size());
	for(WebElement list : li) {
		String option=list.getText();
		if(option.equals("Deposits")) {
			list.click();
			break;
		}
	}
}
}
