package selenium_Java_day1;

import java.time.Duration;
import java.util.List;

import org.bouncycastle.util.Arrays.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleDropdown2 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
		driver.get("https://www.orangehrm.com/30-day-free-trial/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/div[2]/ul[1]/li[2]/a[1]/button[1]")).click();
		
		WebElement country = driver.findElement(By.xpath("//select[@id='Form_getForm_Country']"));
		//HandleMultipleDropdown2.Employee(country, "India");
		HandleMultipleDropdown2.Employee2(country, "India");
		
		WebElement NoOFEmp = driver.findElement(By.xpath("//select[@id='Form_getForm_NoOfEmployees']"));
		//HandleMultipleDropdown2.Employee(NoOFEmp, "5,001 - 5,500");
		HandleMultipleDropdown2.Employee2(NoOFEmp, "5,001 - 5,500");
		
		
	}
	
	//Method 1 - generic Method
	public static void Employee(WebElement element, String Value)
	{
		Select selcountry = new Select(element);
		List<WebElement> finalvalues = selcountry.getOptions();
		
		for(WebElement val:finalvalues)
		{
			if(val.getText().equals(Value))
			{
				val.click();
				break;
			}
		}
		
	}
	
	
	
	public static void Employee2(WebElement element, String Value)
	{
		Select selcountry = new Select(element);
		List<WebElement> finalvalues = selcountry.getOptions();
		
		java.util.Iterator<WebElement> allvalues = finalvalues.iterator();
		while(allvalues.hasNext())
		{
			WebElement S = allvalues.next();
			if(S.getText().equals(Value))
			{
				S.click();
				break;
			}
		}
	}
	

}
