package tets;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxSelection {
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
		driver.get("https://testautomationpractice.blogspot.com/?utm_source=chatgpt.com");
	List<WebElement> Days=	driver.findElements(By.xpath("//label[text()='Days:']/following-sibling::div//input"));
	System.out.println(Days.size());
	//for(WebElement day : Days) {
		//String txt=day.getAttribute("id");
		//if(txt.equalsIgnoreCase("monday") ||  (txt.equalsIgnoreCase("Friday"))){
			//day.click();
			//break;
		int days=Days.size();
		for(WebElement day : Days) {

		for(int i=days-2;i<days;i++) {
			Days.get(i).click();
		}
		for(int i=0;i<2;i++) {
			Days.get(i).click();
		}
	}
	}
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}
	}
	


