package Assignment_13;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Assignment_13_03 {
	
	public static void main(String[] args) {

		EdgeDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "OrangeHRM");
		System.out.println("Title is as expected");
		
		driver.quit();
	}

}
