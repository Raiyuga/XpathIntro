import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ecommerce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		No need to download and give path of chromedriver anymore as selenium manager, new feature introduced by selenium
//		team does all that for us
		WebDriver driver = new ChromeDriver();
		//made an object to use explicit wait
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
//		implicit wait
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] veggies = { "Cucumber", "Brocolli", "Beetroot" };
		additems(driver, veggies);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
//		using explicit wait
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));	
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText()); 
	}
	
	public static void additems(WebDriver driver, String[] veggies) {
		// Taking multiple items at once and storing them in the arraylist
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		// after that iterating through all the stored items to get the desired item
		int j = 0;
		for (int i = 0; i < products.size(); i++) {
			// Receiving Broccoli - 1 Kg but only want product name "Broccoli" so using
			// split and trim methods to remove whitespace and 1 Kg

			String[] name = products.get(i).getText().split("-");
			String formattedname = name[0].trim();
			// Convert array into arraylist for easy search
//			Check whether the name you extracted is present in arraylist or not

			List veggiesList = Arrays.asList(veggies);

			if (veggiesList.contains(formattedname)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j++;
				if (j == veggies.length) {
					break;
				}
			}

		}

	}

}
