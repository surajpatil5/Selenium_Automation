package selenium_Java_day1;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedbusAutoSuggestDropdown {

	public static void main(String[] args) {
		
		ChromeOptions notif = new ChromeOptions();
		notif.addArguments("--disable-notifications");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(notif);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.get("https://www.redbus.in/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[@class='sc-ifAKCX gLwVlD']//div//input[@id='src']")).sendKeys("Pune");
		
		List<WebElement> results = driver.findElements(By.xpath("//li[@class='sc-iwsKbI jTMXri']//div[@class='sc-gZMcBi"
				+ " grvhsy']//text[@class='placeHolderMainText']"));

		System.out.println(results.size());
		
		Iterator<WebElement> values = results.iterator();
		
		while(values.hasNext())
		{
			WebElement S = (WebElement) values.next();
			if(S.getText().equals("Kharadi"))
			{
				S.click();
				break;
			}
		}
		
		
		driver.findElement(By.xpath("//div[@class='sc-ifAKCX gLwVlD']//div//input[@id='dest']")).sendKeys("Vashi");
		
		List<WebElement> destination = driver.findElements(By.xpath("//li[@class='sc-iwsKbI jTMXri']//div//text[@class='placeHolderMainText']"));
		
		for(WebElement dest:destination)
		{
			if(dest.getText().equals("Mumbai Naka"))
			{
				dest.click();
				break;
			}
		}
	}

}
