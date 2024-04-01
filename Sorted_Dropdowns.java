package selenium_Java_day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sorted_Dropdowns {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.twoplugs.com/");
		driver.findElement(By.xpath("//button[@id='details-button']")).click();
		driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
		driver.findElement(By.xpath("//div[@class='jq-selectbox__trigger-arrow']")).click();
		
		//To capture all dropdown values, first select the main tag, get the element
		WebElement List1 = driver.findElement(By.name("category_id"));
		
		//Once captured, pass the element into Select class
		Select C = new Select(List1);
		
		//get all the options/values into List collection using getoptions method present in Select class
		List<WebElement> option=C.getOptions();
		
		//Create two lists to save the elements & to compare the both the collection values using equal
		ArrayList OgList = new ArrayList();
		ArrayList tempList = new ArrayList();
				
		for(WebElement val:option)
		{
			OgList.add(val.getText());
			tempList.add(val.getText());
		}
		
		System.out.println("Original List: "+OgList);
		System.out.println("Temp List: "+tempList);
		
		//Apply sort on 1 list
		Collections.sort(tempList);   		//Not sorted since I only apply sort on 1 temp list.
		
		//Print both the list again
		System.out.println("Original List: "+OgList);
		System.out.println("Temp List after sort : "+tempList);
		
		//Compare
		if(OgList.equals(tempList))
		{
			System.out.println("Dropdown options sorted");
		}
		else
		{
			System.out.println("Dropdown options not sorted");
		}
		
		//Now apply sort on remaining list
		Collections.sort(OgList);
		
		System.out.println("Original List after sort: "+OgList);
		
		//Now compare
		if(OgList.equals(tempList))
		{
			System.out.println("Dropdown options sorted");
		}
		else
		{
			System.out.println("Dropdown options not sorted");
		}
		
		driver.close();
	}

}
