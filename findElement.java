package selenium_Java_day1;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class findElement {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		// With findelement() method
		driver.get("https://demo.nopcommerce.com/register");
		WebElement searchbox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		searchbox.sendKeys("Demo");
		
		// With findelements() method
		WebElement singlelink = driver.findElement(By.xpath("//div[@class='footer-upper']//a"));
		//22 elements returning but findelement() will only show single element
		System.out.println(singlelink.getText());
		
		
		//locating one element with findelements() method
		List<WebElement> trywithfindelements = driver.findElements(By.xpath("//button[@class='button-1 search-box-button']"));
		Iterator<WebElement> one = trywithfindelements.iterator();
		while(one.hasNext())
		{
			WebElement X = one.next();
			System.out.println(X.getText());
		}
		
		//locating multiple elements using xpath with findelement() method -> returning single element
		WebElement S = driver.findElement(By.xpath("//div[@class='footer-upper']//a"));
		System.out.println(S.getText());
		
		
		List<WebElement> multiplelinks = driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
		
		//Using ForEach loop
		for (WebElement ele: multiplelinks)
		{
			System.out.print(ele.getText()+", ");
		}
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		
		
		//Using Iterator interface
		Iterator<WebElement> A = multiplelinks.iterator();
		//int count=0;
		while(A.hasNext())
		{
			WebElement B = A.next();
			System.out.print(B.getText()+" ");
			//count++;    //The total number of elemennts are: 22
		}
		
		//OR
		
		
		System.out.println();
		System.out.println("The total number of elemennts are: "+multiplelinks.size() );  //The total number of elemennts are: 22
		
		
		List<WebElement> error = driver.findElements(By.xpath("//button[@class='button-1 search-box-buon']"));
		int a = error.size();
		System.out.println(a);
	}

}
