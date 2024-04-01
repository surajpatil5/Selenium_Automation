package selenium_Java_day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardActions1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/key_presses");
		driver.manage().window().maximize();
			
		//To perform Keyboard Actions, we need to use 'Actions' class & inside it use 'Keys' class
		Actions act = new Actions(driver);
		
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
		
		act.sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(3000);
		
		act.sendKeys(Keys.DELETE).perform();
		Thread.sleep(3000);
		
		act.sendKeys(Keys.ARROW_RIGHT).perform();
		
	}

}
