package Assignment_13;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment_13_01 {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void openBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chrome\\chromedriver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.saucedemo.com/v1/index.html");
		
	}
	
	@BeforeMethod
	public void enterCredentials() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		System.out.println("Username is entered");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		System.out.println("Password is entered");
		driver.findElement(By.id("login-button")).click();;
		System.out.println("Login is clicked");
	}
	
	@Test
	public void placeAnOrder() {
		driver.findElement(By.xpath("(//button[text()='ADD TO CART'])[1]")).click();
		System.out.println("Add to Cart is clicked");
		driver.findElement(By.xpath("(//button[text()='ADD TO CART'])[2]")).click();
		System.out.println("Add to Cart is clicked");
		driver.findElement(By.xpath("//div[@id='shopping_cart_container']/a/*[local-name()='svg']")).click();
		System.out.println("Cart is clicked");
		driver.findElement(By.xpath("//a[text()='CHECKOUT']")).click();
		System.out.println("Checkout is clicked");
		driver.findElement(By.id("first-name")).sendKeys("Chayan");
		System.out.println("First name is entered");
		driver.findElement(By.id("last-name")).sendKeys("Roy");
		System.out.println("Last name is entered");
		driver.findElement(By.id("postal-code")).sendKeys("128799");
		System.out.println("Zip code is entered");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println("Continue is clicked");
		driver.findElement(By.xpath("//a[text()='FINISH']")).click();
		System.out.println("Finish is clicked");
		String actualMessage = driver.findElement(By.xpath("//h2")).getText();
		String expectedMessage = "THANK YOU FOR YOUR ORDER";
		Assert.assertEquals(actualMessage, expectedMessage);
		System.out.println("Message is as expected");
	}
	
	@AfterMethod
	public void logOut() {
		driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
		System.out.println("Open menu is clicked");
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		System.out.println("Log out is clicked");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
