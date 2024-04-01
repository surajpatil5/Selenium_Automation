package selenium_Java_day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Upload_File {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		
		driver.manage().window().maximize();
		
		//Using SendKeys Method
		WebElement Fileupload = driver.findElement(By.xpath("//input[@name='upfile']"));
		//Fileupload.sendKeys("C:\\Users\\Suraj Patil\\Documents\\Resume\\SurajPatil_Resume.pdf");  //PDF file 
		Thread.sleep(3000);
		Fileupload.sendKeys("C:\\Users\\Suraj Patil\\Documents\\Resume\\Suraj Patil_MT_Resume.docx");	//Word
		
		
		
		
		

	}

}
