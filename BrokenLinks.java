package selenium_Java_day1;

import java.io.IOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://www.deadlinkcity.com/");
		
		driver.manage().window().maximize();
		
		List<WebElement> Alinks = driver.findElements(By.tagName("a"));
		System.out.println(Alinks.size());
		
		int brokenurls=0;
		
		//Use enhance for loop, to check the broken links
		for(WebElement link:Alinks)
		{
			//convert or save url link into string so that we can check whether it is empty/null or not (Both are string methods) 
			String url = link.getAttribute("href");  //To get the link & store it in String format
			
			//To check whether any url is empty or null
			if(url==null || url.isEmpty())
			{
				System.out.println("URL is empty");
			}
			
			//Convert String url into proper URL format
			URL Link = new URL(url);
			try {
				
				HttpURLConnection httpreq = (HttpURLConnection) Link.openConnection();
				httpreq.connect();
				
				if(httpreq.getResponseCode()>=400)
				{
					System.out.println(httpreq.getResponseCode()+" "+ url +  " is "+ " Broken" );
					brokenurls++;
				}
				else
				{
					System.out.println(httpreq.getResponseCode()+" "+ url +" is "+ " valid" );
				}
				
			} 
			catch (Exception e) {
				System.out.println("This is optional catch block");
			}
		}
		
		System.out.println("The count of broken links on this page is: "+brokenurls);

	}

}
