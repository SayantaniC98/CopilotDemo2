package Assignment_13;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Assignment_13_06 {

    // Declare the WebDriver and ChromeOptions as static
    private static WebDriver driver;
    private static ChromeOptions options;

    @BeforeSuite
    public void setUp() {
        System.out.println("Setting up browser...");

        // Initialize ChromeOptions and set options
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
        options.setExperimentalOption("useAutomationExtension", false);

        // Set the ChromeDriver system property
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chrome\\chromedriver\\chromedriver.exe");

        // Initialize WebDriver only once at the suite level
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Navigate to the URL
        driver.get("https://opensource-demo.orangehrmlive.com/");
        System.out.println("Navigated to OrangeHRM website");
    }

    @Test(groups = {"login", "Integration"})
    public void loginTest() throws InterruptedException {
        System.out.println("Starting login test...");

        // Enter username
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        System.out.println("Entered username");

        // Enter password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        System.out.println("Entered password");

        // Click on the login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Clicked the Login button");

        // Wait for the page to load
        Thread.sleep(5000);

        // Verify successful login
        String dashboardText = driver.findElement(By.xpath("//h6")).getText();
        Assert.assertEquals(dashboardText, "Dashboard", "Login failed: 'Dashboard' not found!");
        System.out.println("Login verification successful.");
    }

    @Test(groups = {"logout", "Integration"})
    public void logoutTest() {
        System.out.println("Starting logout test...");

        // Locate and click on user menu
        driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']/i")).click();
        System.out.println("Opened user menu");

        // Locate and click on logout button
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
        System.out.println("Clicked the Logout button");

        // Verify redirection to login page
        String loginPageText = driver.findElement(By.xpath("//h5")).getText();
        Assert.assertEquals(loginPageText, "Login", "Logout failed: 'Login' page not displayed!");
        System.out.println("Logout verification successful.");
    }

    @AfterSuite
    public void tearDown() {
        System.out.println("Closing the browser...");
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully.");
        }
    }
}
