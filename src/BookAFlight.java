import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BookAFlight {

	public static WebDriver bDriver =null;
	
	
	public void bookFlight() 
	{
		String baseDir = System.getProperty("user.dir");
		System.out.println("Project Base Directory :"+ baseDir);
		System.setProperty("webdriver.chrome.driver", "./input/chromedriver_235.exe");
				
		ChromeOptions options = new ChromeOptions();		
		options.addArguments("--start-maximized");
		options.addArguments("disable-infobars");
		
		try 
		{
			bDriver = new ChromeDriver(options);			
			bDriver.get("http://newtours.demoaut.com/");
			
			// Page 1
			WebDriverWait wait = new WebDriverWait(bDriver, 10);
			WebElement uName = wait.until(
			        ExpectedConditions.visibilityOfElementLocated(By.name("userName")));
			if (uName !=null)
			{
				uName.sendKeys("mercury");
			}
			WebElement uPass = bDriver.findElement(By.name("password")); 
			if (uPass !=null){
				uPass.sendKeys("mercury");
			}
			bDriver.findElement(By.name("login")).click();	
			
			// Page 2 - FLIGHT FINDER 
			WebElement btnfindFlight = wait.until(
			        ExpectedConditions.visibilityOfElementLocated(By.name("findFlights")));
			if (btnfindFlight !=null){
				btnfindFlight.click();
			}
			
			// Page 3 - SELECT A FLIGHT 
			WebElement btnReserveFlight = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.name("reserveFlights")));
			if (btnReserveFlight !=null){
				btnReserveFlight.click();
			}
			
			// Page 4 - BOOK A FLIGHT 
			WebElement btnBuyFlights = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.name("buyFlights")));
			bDriver.findElement(By.name("passFirst0")).sendKeys("Anne");
			bDriver.findElement(By.name("passLast0")).sendKeys("Joseph");
			bDriver.findElement(By.name("creditnumber")).sendKeys("12345");
			
			if (btnBuyFlights !=null){
				btnBuyFlights.click();
			}
			
			// Page 5 - FLIGHT CONFIRMATION
			WebElement btnPrinterImage = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src,'/images/printit.gif')]"))); 
			if (btnPrinterImage !=null){
				System.out.println("Flight Confirmation SUCCESSFUL");;
			}
			
			Thread.sleep(2000);
			bDriver.close();
			bDriver.quit();
		}
		catch(Exception e)
		{
			System.out.println("Exception in Code : " + e.getMessage());
		}
		
	
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		BookAFlight obj = new BookAFlight();
		obj.bookFlight();
	}
}
