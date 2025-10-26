package tets;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.javadoc.internal.doclets.formats.html.markup.Text;

public class towPlugs {
WebDriver driver;


@BeforeMethod
public void SetUp() throws InterruptedException {

WebDriverManager.chromedriver().setup();
ChromeOptions option=new ChromeOptions();
option.addArguments("--start-maximized");
driver=new ChromeDriver(option);
}
@Test
public void test() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

driver.get("https://developers.google.com/s/results/maps/documentation/javascript?q=sele");
WebElement el=driver.findElement(By.name("q"));
el.clear();
String text;
Thread.sleep(3000);

el.sendKeys("Newsletter");
do {
	Thread.sleep(3000);
	el.sendKeys(Keys.ARROW_DOWN);
	Thread.sleep(3000);

	text=el.getAttribute("value");
	Thread.sleep(3000);

	if(text.equalsIgnoreCase("Newsletter - April")) 
		Thread.sleep(3000);

		el.sendKeys(Keys.ENTER);
		break;

	
}while(!text.isEmpty()) ;
}
}
