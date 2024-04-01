package selenium_Java_day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropdown2 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.get("https://www.bing.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//textarea[@id='sb_form_q']")).sendKeys("RCB");
		
		List<WebElement> results = driver.findElements(By.xpath("//li[@class=\"sa_sg\"]//div[@class=\"sa_tm\"]//span[@class='sa_tm_text']"));
		
		for(WebElement Value:results)
		{
			if(Value.getText().equals("mi vs rcb"))
			{
				Value.click();
				break;
			}
		}

	}

}
