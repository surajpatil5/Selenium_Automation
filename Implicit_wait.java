package selenium_Java_day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Implicit_wait {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		driver.get("https://www.google.com/");
		WebElement searchbox = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
		searchbox.sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@value='Google Search']")).click();
		
		driver.findElement(By.xpath("//h3[text()='Selenium']")).click();
		

	}

}
