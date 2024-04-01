package selenium_Java_day1;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class filedownload {

	public static void main(String[] args) {
		
		String location = System.getProperty("user.dir")+ "\\Downloads\\";
		
		HashMap preferences = new HashMap();
		preferences.put("download.default_directory", location);
		
		ChromeOptions locate = new ChromeOptions();
		locate.setExperimentalOption("prefs", preferences);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(locate);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
		
		driver.findElement(By.xpath("//body[1]/div[1]/main[1]/section[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/a[1]")).click();
		
		

	}

}
