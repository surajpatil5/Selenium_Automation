package selenium_Java_day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseDoubleClick {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("iframeResult");
		
		WebElement Doubleclick = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
		
		//To perform double click mouse operation, we have to use 'Actions' class
		
		Actions dclick = new Actions(driver);
		
		String X = driver.findElement(By.id("demo")).getText();
		
		if(X.isEmpty())
			System.out.println("The string is empty");
		else
			System.out.println("The string is not empty");
		
		
		dclick.doubleClick(Doubleclick).perform();
		
		System.out.println(driver.findElement(By.id("demo")).getText());
		
		
		
		
	}

}
