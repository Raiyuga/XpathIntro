import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {
	public static void main(String[] args) throws InterruptedException {
		
		String name = "rishabh";
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String Password = getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(Password);
//		Thread.sleep(1000);
		driver.findElement(By.className("signInBtn")).click();
		//using assertion actual vs expected
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'You are successfully logged in.')]")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.xpath("//h2[contains(text(),'Hello')]")).getText(), "Hello "+name+",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.close();
	}
	
	
	// Writing  a function to get the password dynamically instead of hard-coding it. Using Split method of String Object
	public static String getPassword(WebDriver driver) throws InterruptedException {
	
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
//		Please use temporary password 'rahulshettyacademy' to Login.
		String Pass = driver.findElement(By.cssSelector("p.infoMsg")).getText();
		String[] Passwordarray1 = Pass.split("'");
//		String[] Passwordarray2 = Passwordarray1[1].split("'"); can write like this too	
		String Password = Passwordarray1[1].split("'")[0];
		
		return Password;
	}
}
