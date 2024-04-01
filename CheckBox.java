package selenium_Java_day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7000));
		driver.get("https://training.rcvacademy.com/test-automation-practice-page");
		
		driver.manage().window().maximize();
		
		//Select specific Check box
		//driver.findElement(By.xpath("//label[contains(text(),'Selenium with Java')]")).click();
		
		//UnSelect By-default selected checkbox
		WebElement A = driver.findElement(By.xpath("//label[contains(text(),'Playwright with JavaScript')]"));
		System.out.println(A.isEnabled());
		A.click();
		
		//select all the check boxes
		/*List<WebElement> alloptions = driver.findElements(By.xpath("//div[@class='checkbox']//label"));
		System.out.println(alloptions.size());
		
		for(WebElement A:alloptions)
		{
			System.out.println(A.getText());
			A.click();
		}
		*/
		
		
		//How to select multiple check boxes by choice
		/*List<WebElement> alloptions = driver.findElements(By.xpath("//div[@class='checkbox']//label"));
		
		for(WebElement A:alloptions)
		{
			if(A.getText().equals("Cypress") || A.getText().equals("Selenium with Java"))
			//if(A.getText().contains("with"))
			{
				A.click();
			}
		}
		*/
		
		//How to select last N (3) check boxes
		/*List<WebElement> alloptions = driver.findElements(By.xpath("//div[@class='checkbox']//label"));
		System.out.println(alloptions.size());
		
		for(int i=2;i<alloptions.size();i++)
		{
			alloptions.get(i).click();
		}
		*/
		
		//How to select first N (3) check boxes
		List<WebElement> alloptions = driver.findElements(By.xpath("//div[@class='checkbox']//label"));
		System.out.println(alloptions.size());
		
		for(WebElement two:alloptions)
		{
			if(two.getText().equalsIgnoreCase("cypress"))
			{
				break;
			}
			two.click();
		}

		
	}

}
