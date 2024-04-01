package selenium_Java_day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.get("https://www.google.com/?pli=1");
		
		driver.manage().window().maximize();
		
		WebElement searchbox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		searchbox.sendKeys("Java");
		Thread.sleep(4000);
		
		List<WebElement> options = driver.findElements(By.xpath("//li[@class='sbct PZPZlf']//div[1]//div[@class='pcTkSc']"
				+ "//div[@class='lnnVSe']//div[@class='wM6W7d']//span"));
		
		System.out.println("Size of above list items: "+options.size());
		
		for(WebElement val:options)
		{
			if(val.getText().contains("download"))
			{
				val.click();
				break;
			}
		}

	}

}
