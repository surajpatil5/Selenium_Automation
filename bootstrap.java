package selenium_Java_day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class bootstrap {

	public static void main(String[] args) {
		
		ChromeOptions handle = new ChromeOptions();
		handle.addArguments("--disable-notifications");
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(handle);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		driver.get("https://www.hdfcbank.com/");
		driver.manage().window().maximize();
		
		//For product type dropdown
		driver.findElement(By.xpath("//a[contains(text(),'Select Product Type')]")).click();
		
		List<WebElement> prdtypes = driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));
		bootstrap.selectdrpvalues(prdtypes, "Accounts");
		
		//Size of elements
		System.out.println("The size of first dropdown elements is: "+prdtypes.size());
		/*
		//Select one element using enhanced for loop
		for(WebElement fvalue :prdtypes)
		{
			if(fvalue.getText().equals("Loans"))
			{
				fvalue.click();
				break;
			}
		}
		*/
		//for select product dropdown
		
		driver.findElement(By.xpath("//a[contains(text(), 'Select Product')]")).click();
		
		List<WebElement> prddropdown = driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']/li"));
		System.out.println("The size of Second dropdown elements is: "+prddropdown.size());
		bootstrap.selectdrpvalues(prddropdown, "Rural Accounts");
		
		driver.findElement(By.xpath("//a[contains(., 'Apply online')]")).click();
		
		//driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		/*
		for(WebElement prdvalue:prddropdown)
		{
			if(prdvalue.getText().equals("Super Bike Loan"))
			{
				prdvalue.click();
				break;
			}
		}
		*/
	}
	
	//Generic method to select an value from both drodown
	public static void selectdrpvalues (List<WebElement> alldrpdowns, String value)
	{
		for(WebElement finaldrpvalues:alldrpdowns)
		{
			if(finaldrpvalues.getText().equals(value))
			{
				finaldrpvalues.click();
				break;
			}
		}
	}
	
	

}
