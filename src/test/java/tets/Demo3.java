package tets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo3 {
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
		driver.get("https://the-internet.herokuapp.com");
		
		driver.switchTo().frame("Frames");
		
}
}
