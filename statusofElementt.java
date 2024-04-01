package selenium_Java_day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class statusofElementt {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		//IsDisplayed() & IsEnabled
		
		driver.get("https://rahulshettyacademy.com/");
		driver.findElement(By.xpath("//a[@class='theme-btn register-btn']")).click();
		boolean A = driver.findElement(By.xpath("//input[@id='email']")).isDisplayed();
		boolean B = driver.findElement(By.xpath("//input[@id='email']")).isEnabled();
		System.out.println(A);
		System.out.println(B);
		WebElement C = driver.findElement(By.xpath("//label[text()='Remember Me']"));
		System.out.println(C.isSelected());
		C.click();
		Thread.sleep(3000);
		System.out.println(C.isSelected());
		
	}

}
