package selenium_Java_day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetText_attributeMethod {

	public static void main(String[] args) {

		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://demo.nopcommerce.com/login?returnUrl=%2Fregister");

		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("Surajpatil2111998@gmail.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Suraj1998");
		
		WebElement text = driver.findElement(By.xpath("//input[@id='Email']"));
		//WebElement attri = driver.findElement(By.xpath("//input[@id='Email']"));
		System.out.println("Text of email field is: "+ text.getText());
		System.out.println("Returning attribute: "+ text.getAttribute("data-val-required"));
		
		WebElement button = driver.findElement(By.xpath("//button[@class ='button-1 login-button']"));
		System.out.println("Returning button text: "+ button.getText());
		System.out.println("Returning button attribute: "+ button.getAttribute("class"));
		
		WebElement img = driver.findElement(By.xpath("//div[@class='header-logo']/a"));
		System.out.println("Returning img text: "+ img.getText());
		System.out.println("Returning img attribute: "+ img.getAttribute("alt"));
		
	}

}
