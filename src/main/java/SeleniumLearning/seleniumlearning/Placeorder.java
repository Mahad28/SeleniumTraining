package SeleniumLearning.seleniumlearning;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Placeorder {

	public static void main(String[] args) throws InterruptedException {
		
System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver.exe");
    	
    	ChromeOptions options= new ChromeOptions();
    	options.addArguments("start-maximized");
		options.addArguments("disable-infobars");
		options.addArguments("--incognito");
		//options.addArguments("--ignore-certificate-errors");
        //options.addArguments("--disable-popup-blocking");
		
		WebDriver driver = new ChromeDriver(options);
	 
	    
	    driver.get("https://demo.opencart.com/index.php?route=account/login");
	    
	    driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("xirajmunir@gmail.com");
	    driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("siraj123");
	    
	    driver.findElement(By.xpath(" //*[@id=\"content\"]/div/div[2]/div/form/input")).click();
	    
	    driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("HP LP3065");
	    driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
	  
	    WebElement openfilter4  = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[1]/h4/a"));
	    JavascriptExecutor jse1 = (JavascriptExecutor)driver;
	 	jse1.executeScript("arguments[0].scrollIntoView()", openfilter4);
	 	Thread.sleep(2000);
	 	openfilter4.click();
	 
	    
	    //driver.manage().window().maximize();
	    Thread.sleep(3000);
	    
	    WebElement openfilter  = driver.findElement(By.xpath("//*[@id=\"button-cart\"]"));
		
	    JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()", openfilter);
		Thread.sleep(2000);
	    openfilter.click();
	    
	    
	    
	    //WebDriverWait wait2 = new WebDriverWait(driver,20);
	    //wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\\\"cart\\\"]/button")));
	    
	    WebElement openfilter1  = driver.findElement(By.xpath("//*[@id=\"cart\"]/button"));
	    
	   
	    openfilter1.click();
	    
	    Thread.sleep(3000);
	    
	    driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]/strong")).click();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.xpath("//*[@id=\"button-payment-address\"]")).click();
	    Thread.sleep(3000);
	  
	    driver.findElement(By.xpath("//*[@id=\"button-shipping-address\"]")).click();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.xpath("//*[@id=\"button-shipping-method\"]")).click();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.xpath("//*[@id=\"collapse-payment-method\"]/div/div[2]/div/input[1]")).click();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.xpath("//*[@id=\"button-payment-method\"]")).click();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.xpath("//*[@id=\"button-confirm\"]")).click();
	    Thread.sleep(10000);
	    
	    String actualpagetitle2 = "";
		String expectedTitle2 = "Your order has been placed!";
		actualpagetitle2  = driver.getTitle();
	
		
		
		System.out.println(actualpagetitle2);
		
		
		
		if (actualpagetitle2.contentEquals(expectedTitle2))
		{
            System.out.println("Test Passed!");
        } 
		else 
        {
            System.out.println("Test Failed");
        }
		
	    
	    driver.close();
	    driver.quit();
	    
	  
	}

}
