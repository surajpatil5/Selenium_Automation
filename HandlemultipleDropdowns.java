package selenium_Java_day1;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlemultipleDropdowns {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2Fregister");
		HandlemultipleDropdowns obj = new HandlemultipleDropdowns();
		
		//Getting all dropdown elements in a single webElement
		WebElement day = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
		obj.generic(day, "21");
		Thread.sleep(2000);
		WebElement month = driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
		obj.generic(month, "January");
		Thread.sleep(2000);
		WebElement year = driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
		obj.generic(year, "1998");
		Thread.sleep(2000);

	}
	
		public void generic(WebElement ele, String Value)
		{
			Select drpval = new Select(ele);
			//getOptions will get all the values/options & that I will store  it in List collection
			List<WebElement> drpoptions = drpval.getOptions();
			//Using foreach loop
			/*
			 * for(WebElement val:drpoptions) { if(val.getText().equals(Value)) {
			 * val.click(); } }
			 */
			
			//Iterator interface
			Iterator<WebElement> val = drpoptions.iterator();
			while(val.hasNext())
			{
				WebElement A =val.next();
				if (A.getText().equals(Value))
						{
					A.click();	
						}
			}
			
		}
}
