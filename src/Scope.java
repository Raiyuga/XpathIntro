import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
//		implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
//		1. Code to get count of the links on page
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
//		2. Code to get count of the links present on footer
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));  //Limiting webdriver scope
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
//		3. Code to get count of the links present on section 1 of the footer (limiting the scope further)
		WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		for(int i=0; i<columndriver.findElements(By.tagName("a")).size(); i++) {
			 
			String clickonlinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER); //This line will open all the links on new tab
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
		}
		//Writing code to navigate through all the open tabs using while loop & window handles
		Set<String> windows = driver.getWindowHandles();
		Iterator<String>it = windows.iterator();
			while(it.hasNext()) {
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
		
	}

}
