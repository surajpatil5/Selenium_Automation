package selenium_Java_day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleLinks {

	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.amazon.in/");
		
        List<WebElement> allinks = driver.findElements(By.tagName("a"));
		
		System.out.println("The size of all present links on amazon homepage is: "+allinks.size());
		
		
		//Using enhance for loop, print all links name & 'href' attribute value
		for(WebElement link:allinks)
		{
			System.out.println(link.getText());
			System.out.println(link.getAttribute("href"));
		}
		
		
		//Using for loop
		/*for(int i=1;i<=allinks.size();i++)
		{
			System.out.println(allinks.get(i).getText());
			System.out.println(allinks.get(i).getAttribute("href"));
		}*/
		
		driver.findElement(By.linkText("Sell")).click();
		//driver.findElement(By.partialLinkText("Deals")).click();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		
		
		
		driver.close();

		
	}

}
