package tets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownSorting {
WebDriver driver;


@BeforeMethod
public void Setup() {
	WebDriverManager.chromedriver().setup();
	ChromeOptions option=new ChromeOptions();
	option.addArguments("--start-maximized");
	driver =new ChromeDriver(option);
}
@Test
public void Test() {
	driver.get("https://www.hdfcbank.com/");
	driver.findElement(By.xpath("(//div[@class='dropdown']//a)[1]")).click();
	List<WebElement> opt=driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']//li"));
	ArrayList<String> origin=new ArrayList<>();
	ArrayList<String> temp=new ArrayList<>();
	for(WebElement options :opt) {
		origin.add(options.getText());
		temp.add(options.getText());

	}
	System.out.println(origin);
	Collections.sort(temp);
	System.out.println(temp);
	if(origin.equals(temp)) {
		System.out.println("Arrray is sorted");
	}else {
		System.out.println("Arrray is not sorted");

	}

}
}
