package selenium_Java_day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardActions2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		
		WebElement textarea1 = driver.findElement(By.xpath("//textarea[@id='inputText1']"));
		WebElement textarea2 = driver.findElement(By.xpath("//textarea[@id='inputText2']"));
		
		textarea1.sendKeys("Welcome to Java & Selenium Guys");
		
		//CTRL + A
		Actions act = new Actions(driver);
		act.keyDown(textarea1, Keys.CONTROL).perform();
		act.sendKeys("a").perform();
		act.sendKeys("c").perform();
		act.keyUp(textarea1, Keys.CONTROL).perform();
		Thread.sleep(3000);
		act.sendKeys(Keys.TAB).perform();
		act.keyDown(textarea2, Keys.CONTROL).perform();
		act.sendKeys("v").perform();
		act.keyUp(textarea2, Keys.CONTROL).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='compareButtonText']")).click();
		
		
		
		
	}

}
