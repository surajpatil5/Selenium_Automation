package selenium_Java_day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handlingNotification {

	public static void main(String[] args) {
		
		ChromeOptions handle = new ChromeOptions();
		handle.addArguments("--disable-notifications");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(handle);
		
		/*EdgeOptions handleedge = new EdgeOptions();
		handleedge.addArguments("--disable-notifications");
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver(handleedge);*/
			
		driver.get("https://www.redbus.com/");
		
		

	}

}
