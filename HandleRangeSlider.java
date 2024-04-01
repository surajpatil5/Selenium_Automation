package selenium_Java_day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleRangeSlider {

	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		
		driver.manage().window().maximize();
		
		WebElement minValue = driver.findElement(By.xpath("//div[@id='slider-range']//span[1]"));
		
		//Before take action on slider
		//To find the location value & size of element
		System.out.println("The location value of min element is "+minValue.getLocation());		//(59, 249)
		System.out.println("The size of min element is "+minValue.getSize());					//(20, 20)
		
		//To drag the element in slider, we use 'Actions' class
		Actions act = new Actions(driver);
		
		act.dragAndDropBy(minValue, 160, 249).perform();
		
		//After take action on slider
		System.out.println("The location value of min element is "+minValue.getLocation());		//(221, 249)
		System.out.println("The size of min element is "+minValue.getSize());					// (20, 20)
		
		
		WebElement maxValue = driver.findElement(By.xpath("//div[@id='slider-range']//span[2]"));
		
		System.out.println("The location value of min element is "+maxValue.getLocation());		//(619, 249)
		System.out.println("The size of min element is "+maxValue.getSize());					//20, 20)
		
		act.dragAndDropBy(maxValue, -200, 249).perform();
		
		
	}

}
