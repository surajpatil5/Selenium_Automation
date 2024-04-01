package selenium_Java_day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handling_alerts {
	
	public static void main(String args[]) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//1. Handling alert pop-up by clicking on 'Ok' button
		//driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		//Thread.sleep(3000);
	    //driver.switchTo().alert().accept();
		
		//2. Handling alert pop-up by clicking on both 'Ok' button & 'Cancel' button
		/*WebElement secondalert = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
		secondalert.click();
		
		Alert alert1 = driver.switchTo().alert();
		Thread.sleep(3000);
		alert1.accept();
		
		secondalert.click();
		Thread.sleep(3000);
		alert1.dismiss();*/
		
		//3. Handling alert pop-up by entering some value in it & then accept.
		WebElement thirdalert = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
		thirdalert.click();
		
		Alert alert2 = driver.switchTo().alert();
		alert2.sendKeys("Hello");
		Thread.sleep(2000);
		alert2.accept();
		
		thirdalert.click();
		alert2.sendKeys("Hello");
		Thread.sleep(2000);
		alert2.dismiss();
		
		System.out.println("The name of third alert is: "+thirdalert.getText());
		
	}

}
