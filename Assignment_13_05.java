package Assignment_13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment_13_05 {
	
	public static EdgeDriver driver;
	
	@BeforeTest
	public void openBrowser() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.calculator.net/bmi-calculator.html");
	}
	
	@Test(priority = 1)
	public void calculateBMI1() {
		
		WebElement age = driver.findElement(By.id("cage"));
		age.clear();
		age.sendKeys("30");
		System.out.println("Age is entered");
		
		WebElement feet = driver.findElement(By.id("cheightfeet"));
		feet.clear();
		feet.sendKeys("5");
		WebElement inches = driver.findElement(By.id("cheightinch"));
		inches.clear();
		inches.sendKeys("7");
		System.out.println("Height is entered");
		
		WebElement weight = driver.findElement(By.id("cpound"));
		weight.clear();
		weight.sendKeys("132.277");
		System.out.println("Weight is entered");
		
		WebElement calculate = driver.findElement(By.xpath("//input[@type='submit']"));
		calculate.click();
		System.out.println("Calculate is clicked");
		
		String actualBMI = driver.findElement(By.xpath("//h2[text()='Result']/../div[1]/b")).getText();
		String expectedBMI = "20.7";
		Assert.assertTrue(actualBMI.contains(expectedBMI));
		System.out.println("First BMI is as expected");
	}
	
	@Test(priority = 2)
	public void calculateBMI2() {
		
		WebElement age = driver.findElement(By.id("cage"));
		age.clear();
		age.sendKeys("10");
		System.out.println("Age is entered");
		
		WebElement feet = driver.findElement(By.id("cheightfeet"));
		feet.clear();
		feet.sendKeys("2");
		WebElement inches = driver.findElement(By.id("cheightinch"));
		inches.clear();
		inches.sendKeys("9");
		System.out.println("Height is entered");
		
		WebElement weight = driver.findElement(By.id("cpound"));
		weight.clear();
		weight.sendKeys("132.277");
		System.out.println("Weight is entered");
		
		WebElement calculate = driver.findElement(By.xpath("//input[@type='submit']"));
		calculate.click();
		System.out.println("Calculate is clicked");
		
		String actualBMI = driver.findElement(By.xpath("//h2[text()='Result']/../div[1]/b")).getText();
		String expectedBMI = "85.4";
		Assert.assertTrue(actualBMI.contains(expectedBMI));
		System.out.println("Second BMI is as expected");
	}
	
	@Test(priority = 3)
	public void calculateBMI3() {
		
		WebElement age = driver.findElement(By.id("cage"));
		age.clear();
		age.sendKeys("69");
		System.out.println("Age is entered");
		
		WebElement feet = driver.findElement(By.id("cheightfeet"));
		feet.clear();
		feet.sendKeys("5");
		WebElement inches = driver.findElement(By.id("cheightinch"));
		inches.clear();
		inches.sendKeys("5");
		System.out.println("Height is entered");
		
		WebElement weight = driver.findElement(By.id("cpound"));
		weight.clear();
		weight.sendKeys("154.324");
		System.out.println("Weight is entered");
		
		WebElement calculate = driver.findElement(By.xpath("//input[@type='submit']"));
		calculate.click();
		System.out.println("Calculate is clicked");
		
		String actualBMI = driver.findElement(By.xpath("//h2[text()='Result']/../div[1]/b")).getText();
		String expectedBMI = "25.7";
		Assert.assertTrue(actualBMI.contains(expectedBMI));
		System.out.println("Third BMI is as expected");
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
