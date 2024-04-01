package selenium_Java_day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHoverAction {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		WebElement option1 = driver.findElement(By.linkText("Desktops"));
		
		WebElement option2 = driver.findElement(By.linkText("Laptops & Notebooks"));
		
		WebElement suboption = driver.findElement(By.partialLinkText("Mac"));
		
		Actions mousehover = new Actions(driver);
		
		mousehover.moveToElement(option2).moveToElement(option1).moveToElement(suboption).click().perform();
		
			

	}

}
