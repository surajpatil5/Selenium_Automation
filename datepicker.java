package selenium_Java_day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class datepicker {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.redbus.in/");
		
		driver.manage().window().maximize();
		
		WebElement from =driver.findElement(By.xpath("//input[@id='src']"));
		from.click();
		from.sendKeys("Mumbai");
		WebElement to =driver.findElement(By.xpath("//input[@id='dest']"));
		to.click();
		to.sendKeys("Pune");
		
		
		String reqmonth = "Jun";
		String reqyear = "2024";
		String reqdate = "20";
		
		driver.findElement(By.xpath("//span[@class='dateText']")).click();
		
		
		
		
		
		while(true)
		{
			
			String text = driver.findElement(By.xpath("//div[@class='DayNavigator__CalendarHeader-qj8jdz-1 fxvMrr']//div[2]")).getText();
			
			String arr[]=text.split(" ");
			String month = arr[0];
			String year = arr[1];
			
			if(month.equalsIgnoreCase(reqmonth) && year.equalsIgnoreCase(reqyear))
			{
				break;
			}
			else
				driver.findElement(By.xpath("//div[@class='DayNavigator__CalendarHeader-qj8jdz-1 fxvMrr']//div[3]//*[name()='svg']")).click();

		}
		
		
		//Date Selection
		
		List<WebElement> alldates = driver.findElements(By.xpath("//div[@class='DatePicker__MainBlock-sc-1kf43k8-1 hHKFiR']//div"));
	
		for(WebElement ele:alldates)
		{
			String date = ele.getText();
			
			if(date.equals(reqdate))
			{
				ele.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//button[@id='search_button']")).click();
		
		
		
		
		
	}

}
