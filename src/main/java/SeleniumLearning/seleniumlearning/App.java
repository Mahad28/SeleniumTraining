package SeleniumLearning.seleniumlearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver.exe");
    	
    	ChromeOptions options= new ChromeOptions();
    	options.addArguments("start-maximized");
		options.addArguments("disable-infobars");
		options.addArguments("--incognito");
		//options.addArguments("--ignore-certificate-errors");
        //options.addArguments("--disable-popup-blocking");
		
		WebDriver driver = new ChromeDriver(options);
	 
	    
	    driver.get("https://demo.opencart.com/index.php?route=account/login");
	    
	    //driver.manage().window().maximize();
	    Thread.sleep(2000);
	    WebElement username;
	    username = driver.findElement(By.xpath("//*[@class=\"form-control\"]"));
	    username.sendKeys("xirajmunir@gmail.com");
	    
	    Thread.sleep(2000);
	    
	    WebElement password;
	    password = driver.findElement(By.xpath("//*[@name=\"password\"]"));
	    password.sendKeys("siraj123");
	    
	    //login
	    driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
	    
	    
	    String actualpagetitle = "";
		String expectedTitle = "My Account";
		actualpagetitle  = driver.getTitle();
	
		System.out.println(actualpagetitle);
		
		
		
		if (actualpagetitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
		
		
		String url = "";
		url = driver.getCurrentUrl();
		System.out.println(url);
		
		if (actualpagetitle.contains("Account")){
            System.out.println("URL Test Passed!");
        } else {
            System.out.println("URL Test Failed");
        }
		
		
		
		Thread.sleep(2000);
		
		driver.close();

		Thread.sleep(2000);

		driver.quit();
	    
	   
	    
    }
}
