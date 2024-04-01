package selenium_Java_day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice_D1 {

	public static void main(String arg[])
	{
		//invoke chrome browser
		/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\Suraj Patil\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		//ChromeDriver driver = new ChromeDriver();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");*/
		
		//invoke Edge browser
		/*System.setProperty("webdriver.edge.driver", "C:\\Users\\Suraj Patil\\Downloads\\edgedriver_win64 (1)\\msedgedriver.exe");
		//EdgeDriver driver = new EdgeDriver();
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.makemytrip.com/");*/
		
		//Invoke Firefox driver
		/*System.setProperty("webdriver.gecko.driver", "C:\\Users\\Suraj Patil\\Downloads\\geckodriver-v0.34.0-win64(1)\\geckodriver.exe");
		//FirefoxDriver driver = new FirefoxDriver();
		WebDriver drive = new FirefoxDriver();
		drive.get("https://rahulshettyacademy.com/");*/
		
		//***********Using WebDriverManager***********//
		//Invoke chrome browser using webdrivermanager 
		/*WebDriverManager.chromedriver().setup();   //---> No need to specify the path manually
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.goibibo.com/");*/
		
		
		//Invoke edge browser using webdrivermanager 
		/*WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.goibibo.com/");*/
		
		//Invoke firefox browser using webdrivermanager 
		WebDriverManager.chromedriver().setup();;
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		String S = driver.getTitle();
		System.out.println("Title of the web page is: "+S);
		
		String S1 = driver.getCurrentUrl();
		System.out.println("CurrentURL of the web page is: "+S1);
		
		//System.out.println(driver.getPageSource());    //not getting above results
		
		
		
		
		
		
		
	}

}
