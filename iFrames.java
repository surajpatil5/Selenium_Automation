package selenium_Java_day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class iFrames {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
		
		driver.switchTo().frame("iframeResult");   //Switch to outer iframe
		driver.switchTo().frame(0);				//Switch to inner iframe
		
		System.out.println(driver.findElement(By.xpath("//h1")).getText());  //This page is displayed in an iframe
		
		//To go back to parent iframe
		driver.switchTo().parentFrame();
		
		WebElement S =driver.findElement(By.xpath("//p[contains(text(), 'You can use the height and width attributes to specify the size of the iframe:')]"));
		System.out.println(S.getText());
	}

}
