package selenium_Java_day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoCompleteGooglePlacesDropdowns {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(ch);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
		driver.get("https://www.twoplugs.com/");
		
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("//button[@id='details-button']")).click();
		
		driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
	
		driver.findElement(By.xpath("//a[contains(text(),'Live Posting')]")).click();
		
		WebElement place = driver.findElement(By.xpath("//input[@id='autocomplete']"));
		
		place.clear();
		
		place.sendKeys("China");
		
		String text;
		
		boolean a = true;
		
		do
		{
			place.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(2000);
			
			text = place.getAttribute("value");
			
			System.out.println(text);
			
			if(text.equals("Chinatown, Singapore"))
			{
				place.sendKeys(Keys.ENTER);
				a = false;
				break;
			}
			Thread.sleep(2000);
		}while(a==true);
		
		
		
	}

}
