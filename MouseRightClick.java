package selenium_Java_day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseRightClick {
	
	public static void main(String args[])
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		
		WebElement rightclick = driver.findElement(By.xpath("//span[contains(text(), 'right click me')]"));
		
		//To perform mouse right click option, use Action class
		Actions Rclick = new Actions(driver);  //This will invoke driver constructor
		
		//Rclick.contextClick(rightclick).build().perform();
		Rclick.contextClick(rightclick).perform();            //At the backend, anyways build method is present under perform method. 
		
		driver.findElement(By.xpath("//ul[@class='context-menu-list context-menu-root']//li[2]")).click();
		
		
	}

}
