package selenium_Java_day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropdown2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		driver.get("https://www.opencart.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='navbar-right hidden-xs']/a[2]")).click();
		
		WebElement country = driver.findElement(By.xpath("//select[@id='input-country']"));
		
		/*
		//Using 'Select' Methods
		Select selcountry = new Select(country);
		Thread.sleep(2000);
		selcountry.selectByVisibleText("Argentina");   //Argentina
		Thread.sleep(2000);
		selcountry.selectByIndex(3);   //Algeria
		Thread.sleep(2000);
		selcountry.selectByValue("5"); //Andora
		*/
		
		
		////Without using above three methods
		Select selcountry = new Select(country);
		List<WebElement> options = selcountry.getOptions();
		
		for(WebElement con:options)
		{
			if(con.getText().equals("Zambia"))
			{
				Thread.sleep(1000);
				con.click();
				break;
			}
		}
		
		
		
		
	}

}
