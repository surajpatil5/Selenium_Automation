package selenium_Java_day1;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CookiesOperations {

	public static void main(String[] args) {

		ChromeOptions redbusnotification = new ChromeOptions();
		redbusnotification.addArguments("--disable-notifications");

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(redbusnotification);
		
		driver.get("https://demo.nopcommerce.com/");
		
		//How to capture cookies from Browser?
		Set<Cookie> setofallcookie = driver.manage().getCookies();
		System.out.println("The size of cookies is: "+ setofallcookie.size());
		
		//How to print cookies from Browser?
		for(Cookie val :setofallcookie)
		{
			System.out.println(val.getName()+" =  "+ val.getValue());
		}
		
		//How to add cookie to the Browser?
		//to add cookie, first we need to create an instance of the cookie class & pass the values
		Cookie newadd = new Cookie("Mycookiesbiroooo", "2111998Surajpatil");
		driver.manage().addCookie(newadd);
		
		setofallcookie = driver.manage().getCookies();
		System.out.println("The size of cookies after adding one is: "+ setofallcookie.size());

		//How to delete specific cookie from the Browser?
		driver.manage().deleteCookieNamed(".Nop.Culture");
		setofallcookie = driver.manage().getCookies();
		System.out.println("The size of cookies after deleting one is: "+ setofallcookie.size());
		
		for(Cookie delone:setofallcookie)
		{
			System.out.println(delone.getName());
		}
		
		//How to delete all cookies from the Browser?
//		driver.manage().deleteAllCookies();
//		setofallcookie = driver.manage().getCookies();
//		System.out.println("The size of cookies after deleting all is: "+ setofallcookie.size());
		
		driver.quit();
	}

}
