package tets;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoCode {
WebDriver driver;
	
	@BeforeMethod
public void setUp() {
	WebDriverManager.chromedriver().setup();
	ChromeOptions option=new ChromeOptions();
	option.addArguments("--start-maximized");
	driver=new ChromeDriver(option);
	
	
	}
	@Test
	public void test() {
		driver.get("https://www.redbus.in/");
		((JavascriptExecutor) driver).executeScript("window.open('https://google.com', '_blank');");
		String parentWnd=driver.getWindowHandle();
		Set<String> list=driver.getWindowHandles();
		ArrayList<String> li=new ArrayList<String>(list);
		for(String l: li) {
			if(!parentWnd.equals(li)) {
				driver.switchTo().window(parentWnd);
				System.out.println(driver.getTitle());
			}
		}
	}
	}