package selenium_Java_day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseDragandDrop2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.manage().window().maximize();
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
		
		driver.switchTo().frame(frame);
		
		WebElement img1 = driver.findElement(By.xpath("//img[@alt='The peaks of High Tatras']"));
		WebElement img2 = driver.findElement(By.xpath("//img[@alt='The chalet at the Green mountain lake']"));
		
		WebElement trash = driver.findElement(By.id("trash"));
		
		Actions dragnDrop = new Actions(driver);
		
		dragnDrop.dragAndDrop(img1, trash).perform();
		dragnDrop.dragAndDrop(img2, trash).perform();
		
		
		
	}

}
