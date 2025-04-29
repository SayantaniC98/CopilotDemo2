package Assignment_13;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment_13_7 {

    private static final String dependsOnMethods = null;
	public static WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.out.println("Setting up browser...");

        // Configure ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        // Initialize ChromeDriver with options
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chrome\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Navigate to the URL
        driver.get("https://www.way2automation.com/angularjs-protractor/banking/#/login");
        System.out.println("Browser setup complete, navigated to login page.");
    }

    @Test
    public void loginTest() {
        System.out.println("Starting login test...");

        // Perform login actions
        WebElement customerLogin = driver.findElement(By.xpath("//button[text()='Customer Login']"));
        customerLogin.click();
        System.out.println("Customer login clicked.");

        WebElement nameDropdown = driver.findElement(By.id("userSelect"));
        Select select = new Select(nameDropdown);
        select.selectByVisibleText("Hermoine Granger");
        System.out.println("Customer name selected.");

        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
        loginButton.click();
        System.out.println("Login button clicked.");

        WebElement accountDropdown = driver.findElement(By.id("accountSelect"));
        select = new Select(accountDropdown);
        select.selectByVisibleText("1003");
        System.out.println("Account number selected.");
    }

    @Test
    public void testDeposit() {
        System.out.println("Starting deposit test...");

        // Perform deposit actions
        WebElement depositButton = driver.findElement(By.xpath("//div[@class='center']/button[2]"));
        depositButton.click();
        System.out.println("Deposit button clicked.");
        
        WebElement amount = driver.findElement(By.xpath("//input[@type='number']"));
        amount.sendKeys("1000");
        System.out.println("Amount is entered");
        
        WebElement deposit = driver.findElement(By.xpath("//button[text()='Deposit']"));
        deposit.click();
        System.out.println("Deposit button clicked.");
        
        String successMessage = driver.findElement(By.xpath("//span[text()='Deposit Successful']")).getText();
        Assert.assertEquals(successMessage, "Deposit Successful");
        System.out.println("Success message is matching");
    }
    
    @Test(dependsOnMethods = {"testDeposit"} )
    public void testWithdrawl() {
    	System.out.println("Starting withdrawl test...");

        // Perform deposit actions
        WebElement withdrawl = driver.findElement(By.xpath("//html/body/div[1]/div/div[2]/div/div[3]/button[3]"));
        withdrawl.click();
        System.out.println("Withdrawl button clicked.");

        WebElement amount = driver.findElement(By.xpath("//input[@type='number']"));
        amount.sendKeys("100");
        System.out.println("Amount is entered");
        
        WebElement withdrawlButton = driver.findElement(By.xpath("//button[text()='Deposit']"));
        withdrawlButton.click();
        System.out.println("Withdrawl button clicked.");
        
        String successMessage = driver.findElement(By.xpath("//span[text()='Transaction Successful']")).getText();
        Assert.assertEquals(successMessage, "Transaction Successful");
        System.out.println("Success message is matching");
    }

    @AfterClass
    public void logOut() {
        System.out.println("Closing the browser...");
        WebElement logout = driver.findElement(By.xpath("//button[text()='Logout']"));
        logout.click();
        System.out.println("Logout is clicked");
        driver.quit();
        System.out.println("Browser closed.");
    }
}