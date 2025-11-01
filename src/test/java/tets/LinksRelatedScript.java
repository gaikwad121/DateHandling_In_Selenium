package tets;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksRelatedScript {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--start-maximized");
        driver = new ChromeDriver(option);
    }

    @Test
    public void testS() throws InterruptedException {
        driver.get("https://www.redbus.in/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Click on "From" label
        driver.findElement(By.xpath("//*[@class='labelCityWrapper___fd5744']//div[text()='From']")).click();

        Thread.sleep(3000);
        WebElement w=driver.switchTo().activeElement();
        w.sendKeys("Mumbai");
        Thread.sleep(5000);
       List<WebElement> li=driver.findElements(By.xpath("//div[@class='searchCategory___993266']//div[1]//div//div[@role=\"heading\"]"));
       for(WebElement a : li) {
    	   Thread.sleep(5000);
    	   String txt=a.getText();    	      
System.out.println(txt);
    	   
    	 if(a.equals("Mumbai")) {
        	   Thread.sleep(5000);
              List <WebElement> w1=driver.switchTo().activeElement().findElements(By.xpath("//div[@class='searchCategory___993266']//div[1]//div//div[@role=\"heading\"]"));
              for(WebElement a1 : w1) {
           	   Thread.sleep(5000);
           	   String a2=a.getText();    	      
       //System.out.println(txt);
           	   
           	 if(a2.equals("Mumbai")) {
                // WebElement w3=driver.switchTo().activeElement();
  //Thread.sleep(5000);
    	//	   w3.click();
           		JavascriptExecutor js = (JavascriptExecutor) driver;
           		js.executeScript("arguments[0].click();", a2);

           		 
    		   System.out.println("Its clicked on WebElement");
    		   a1.sendKeys(Keys.TAB);
    		   break;
    		   //Thread.sleep(3000);
    		 // a1.sendKeys(Keys.TAB);
    	   }
           	 driver.findElement(By.xpath("//button[@class='primaryButton___3262c2 searchButtonWrapper___90670b ']")).click();
       }}

    	 /*  WebElement l2=driver.findElement(By.xpath("//div[@class='suggestionInputWrapper___1a7994']//div//div"));
    	List  <WebElement> list=driver.findElements(By.xpath("//div[@class='searchSuggestionWrapper___ec1e8c']//div//div//div[1]"));
    	   for(WebElement a2 : list) {
    		   String b=a2.getText();
    		   if(b.equals("pune")) {
    			   driver.switchTo().frame(0);
    			   a2.click();
        		   Thread.sleep(3000);
    		   }
    	   }
       }*/
        // Locate the actual input box
     /*  WebElement from = driver.findElement(By.id("src"));

        from.clear();
         Thread.sleep(5000);
        // JavaScript click (optional)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", from);*/

        

       }
    }
}
