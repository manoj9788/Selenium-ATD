package Exercise2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoodCode {
    private WebDriver driver;

    // Setup method to initialize WebDriver
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://example.com/login");
    }

    // Login method to handle user input
    public void login(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login")).click();
    }

    // Method to verify page title
    public void verifyTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        if (!actualTitle.equals(expectedTitle)) {
            System.out.println("Test failed: Expected '" + expectedTitle + "', but got '" + actualTitle + "'.");
        } else {
            System.out.println("Test passed: Title matches expected value.");
        }
    }

    // Cleanup method to close the browser
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Test case: should login and navigate to Dashboard
    public void shouldLoginSuccessfully() {
        setup();
        login("testuser", "password123");
        verifyTitle("Dashboard");
        tearDown();
    }
}
