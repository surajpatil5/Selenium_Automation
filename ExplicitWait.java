package selenium_Java_day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.google.com/");
		//First I have to create webdriverwait class instance & specify the value/time
		WebDriverWait webwait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement searchbox = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
		searchbox.sendKeys("Selenium");
		searchbox.sendKeys(Keys.RETURN); //'Enter' key, Keyboard action
		//driver.findElement(By.xpath("//input[@value='Google Search']")).click();

		WebElement foundelement = webwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Selenium']")));
		foundelement.click();
		

	}

}
