	import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
		//Dropdowns with select tags are called static dropdowns
//		WebElement staticdropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
//		Select dropdown = new Select(staticdropdown);
//		dropdown.selectByIndex(3);
//		System.out.println(dropdown.getFirstSelectedOption().getText());		
//		dropdown.selectByValue("INR");
//		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//selecting dropdown values using for loop
//		driver.findElement(By.id("divpaxinfo")).click();
//		Thread.sleep(2000L);
//		int i=0;
//		while(i<4) {
//			driver.findElement(By.id("hrefIncAdt")).click();
//			i++;
//		}
//		driver.findElement(By.id("btnclosepaxoption")).click();
//		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		//selecting dynamic dropdowns 
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
//		Parent-Child relationship
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();
		
//		Auto-Suggestive Dropdowns
//		driver.findElement(By.id("autosuggest")).sendKeys("ind");
//		Thread.sleep(2000);
//        List <WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
//		
//		for(WebElement option: options) {
//			if(option.getText().equalsIgnoreCase("India")) {
//				option.click();
//				break;
//			}
//		}
	}

}
