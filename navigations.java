package selenium_Java_day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class navigations {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		//Both Get & Navigate().to() method will work same
		driver.get("https://rahulshettyacademy.com/");
		driver.navigate().to("https://www.snapdeal.com/");
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);

	}

}
