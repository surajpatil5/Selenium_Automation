package selenium_Java_day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowserWindow {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.get("https://suraj1998-trials712.orangehrmlive.com/auth/login");
		
		driver.manage().window().maximize();
		
		//1. getWindowHandle() 
//		String S = driver.getWindowHandle();
//		System.out.println(S);					//124670FA0CA27FD1E52C7C25016432F0
												//72A623181483602C80EA9C43125B4F43
		
		driver.findElement(By.xpath("//a[@class='linkedIn']/img")).click();
		
		//2. getWindowHandles()
		Set<String> twoids = driver.getWindowHandles();
		
		//Using Iteartor method
		Iterator<String> two = twoids.iterator();
		/*while(two.hasNext())
		{
			System.out.println(two.next());
		}*/
		
		//OR
		
		String S1 =two.next();      //This will return first element
		String S2 =two.next();		//This will return Second element
		
		System.out.println("Parent browser window address "+S1);
		System.out.println("Child browser window address "+S2);
		
		//Converting 'Set' collection to 'List' or converting to arraylist
//		List<String> arrlist = new ArrayList(twoids);
//		System.out.println("Parent browser window address "+arrlist.get(0));
//		System.out.println("Child browser window address "+arrlist.get(1));

		
		
		// How to use window IDs for switching 
		
//		driver.switchTo().window(S1);
//		System.out.println("Title of first window: "+driver.getTitle());		//Title of first window: OrangeHRM
//		
//		driver.switchTo().window(S2);
//		System.out.println("Title of Child window: "+driver.getTitle());		//Title of Child window: OrangeHRM | LinkedIn
		
		
		
		//Using enhanced loop
		/*for(String val:twoids)
		{
		   String str = driver.switchTo().window(val).getTitle();  		//OrangeHRM 
		   System.out.println(str);										//OrangeHRM | LinkedIn
		}
		*/
		
		
		
		for(String val:twoids)
		{
		   String str = driver.switchTo().window(val).getTitle();  		//OrangeHRM 
		   if(!str.equals("OrangeHRM"))
		   {
			   driver.close();
		   }
		}
		
		
		
		
		
		
		
	}

}
