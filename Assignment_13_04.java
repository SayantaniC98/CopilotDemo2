package Assignment_13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class Assignment_13_04 {
	
	public static void main(String[] args) {

		EdgeDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://cleartax.in/s/compound-interest-calculator");
		
		WebElement compoundFrequency = driver.findElement(By.xpath("//select[@id='compoundFrequency']"));
		Select select = new Select(compoundFrequency);
		select.selectByVisibleText("Yearly");
		System.out.println("Compound Frequency Yearly is selected");
		
		WebElement principal = driver.findElement(By.id("principleAmount"));
		principal.clear();
		principal.sendKeys("7000");
		System.out.println("Principal amount is entered");
		
		WebElement annualRate = driver.findElement(By.id("annualrate"));
		annualRate.clear();
		annualRate.sendKeys("10");
		System.out.println("Anual amount is entered");
		
		WebElement periodUnit = driver.findElement(By.xpath("//select[@id='periodUnit']"));
		select = new Select(periodUnit);
		select.selectByVisibleText("Years");
		System.out.println("Period Unit is selected");
		
		WebElement periodValue = driver.findElement(By.id("periodInDigit"));
		periodValue.clear();
		periodValue.sendKeys("1");
		System.out.println("Period unit is entered");
		
		WebElement interestEarned = driver.findElement(By.xpath("//div[text()='Interest Earned']/../div[2]"));
		String interestEarnedValue = interestEarned.getText();
		
		WebElement totalValue = driver.findElement(By.xpath("//div[text()='Total Value']/../div[2]"));
		String totalAmount = totalValue.getText();
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(interestEarnedValue.contains("700"));
		softAssert.assertTrue(totalAmount.contains("7,800"));
		softAssert.assertAll();
		System.out.println("Interest earned and Total value is as expected");
		
		driver.close();
	}

}
