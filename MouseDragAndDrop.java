package selenium_Java_day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseDragAndDrop {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();
		
		WebElement seoul = driver.findElement(By.id("box5"));
		WebElement WC = driver.findElement(By.id("box3"));
		
		
		WebElement southkorea = driver.findElement(By.id("box105"));
		WebElement US = driver.findElement(By.id("box103"));
		
		//to Perform Drag and Drop Actions, we use 'Actions' class
		Actions DandD = new Actions(driver);
		
		DandD.dragAndDrop(seoul, southkorea).build().perform();
		DandD.dragAndDrop(WC, US).build().perform();
		
		
		
		

	}

}
