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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bootstramp {

	
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
	driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/?utm_source=chatgpt.com#google_vignette");
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	WebElement Drop = driver.findElement(By.xpath("//input[@id=\"justAnInputBox\"]"));
	wait.until(ExpectedConditions.elementToBeClickable(Drop));
	Drop.click();
//List<WebElement>choiceList=	driver.findElements(By.xpath("//div[@class='comboTreeDropDownContainer']//li"));
//for(WebElement li :choiceList) {
	//System.out.println(li.getText());
	//System.out.println(li.getSize());
	//SelectionOfDropDown(driver, "choice 1","choice 2","choice 2 1","choice 2 2","choice 2 3");
	SelectionOfDropDown(driver, "all");

}
		 @AfterMethod
		    public void tearDown() {
			 driver.close();		    	
		    }
		
public void SelectionOfDropDown(WebDriver ele,String ... value) {
	 
	List<WebElement>choiceList=	driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
    if (!value[0].equalsIgnoreCase("all")) {

  for(WebElement li :choiceList ) {
	  String txt=li.getText();
		  for(String val: value) {
			  if(txt.equals(val))
			
			  li.click();
			  break;
	 
			 }
	    }
    }
		  else {
			 for(WebElement opt :choiceList ) {
				 try {
				 opt.click();
				 }catch(Exception  e) {
					 
				 }
		  }
	  }
   
  }
}}

