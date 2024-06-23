import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scroll {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//		Creating javascript Executor object to scroll on page


		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)"); // line to scroll on webpage
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000"); // line to scroll on table given on
																					// page

//		traversing from parent tag to child using css selector, 4th col of the table will be highlighted
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum = 0; 
		for (int i = 0; i < values.size(); i++) {

			sum = sum + Integer.parseInt(values.get(i).getText()); // converting string value to integer
		}
		System.out.println(sum);
		
		driver.findElement(By.cssSelector(".totalAmount")).getText(); 
		int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim()); //getting expected value
		Assert.assertEquals(sum, total);
	}
}
