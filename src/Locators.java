import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		//Types of Locators - 1- Id Locator
		driver.findElement(By.id("inputUsername")).sendKeys("rishabh");
		//2- name locator
		driver.findElement(By.name("inputPassword")).sendKeys("123");
		//3- class locator
		driver.findElement(By.className("signInBtn")).click();
		//4- css selector locator
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		//5- link text locator
		driver.findElement(By.linkText("Forgot your password?")).click();
//		Thread.sleep(1000);
		//6- xpath locator
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("rishabh");
		//7- css selector 2nd type
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");
		//8- xpath locator with indexing
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		//9- xpath
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("rishabh@gmail.com");
		//10- xpath - traversing parent to child locator
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("7355238907");
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		System.out.println(driver.findElement(By.cssSelector("p.infoMsg")).getText());
		//11- xpath with Regular Expression
		driver.findElement(By.xpath("//button[contains(@class,'go-to-login-btn')]")).click();
//		explicit wait
//		WebDriverWait w = new WebDriverWait(driver,5);
//		w.until(ExpectedConditions.invisibilityOfElementLocated(By.id("chkboxOne")));
		driver.findElement(By.id("inputUsername")).sendKeys("rishabh");
		driver.findElement(By.xpath("//input[contains(@placeholder,'Pass')]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,'signInBtn')]")).click();
	}

}
