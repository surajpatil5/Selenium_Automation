package selenium_Java_day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2Fregister");
//		WebElement drpdate = driver.findElement(By.name("DateOfBirthYear"));
		
		//With select class method
//		Select dropdowndt = new Select(drpdate);
//		dropdowndt.selectByVisibleText("1916");  //1916
//		dropdowndt.selectByIndex(10);            //1923
//		dropdowndt.selectByValue("1924");        //1924
		
		//Without using Methods
		
//		List<WebElement> newlist = dropdowndt.getOptions();
//		for(WebElement yearval :newlist)
//		{
//			if(yearval.getText().equals("1940"))
//			{
//				yearval.click();
//				break;
//			}
//		}
//		
		//Without using Select class
		List<WebElement> withoutselect = driver.findElements(By.xpath("//select[@name='DateOfBirthYear']//child::*"));
		
		//ForEach loop
		for(WebElement yearval :withoutselect)
		{
			if(yearval.getText().equals("1930"))
			{
				yearval.click();
				break;
			}
		}
		
		//But we will not write this much of code for single dropdown, there will be multiple dropdowns
		// to overcome this issue by writing a simple generic method & pass the values in it.
		//and that method will automatically select the values
		
		
		
		
		
		Thread.sleep(10000);
		driver.close();

	}

}
