package Exercise1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class TestWithTestFrameworkJunit {

    private WebDriver driver;

    @Before
    public void setup() {
        // Arrange: Set up WebDriver and navigate to the login page
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void testPositiveLogin() {
        // Act: Perform login steps
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("student");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Password123");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Assert: Verify results
        // Verify URL contains the expected path
        String currentUrl = driver.getCurrentUrl();
        assertTrue("URL does not contain the expected path.",
                currentUrl.contains("practicetestautomation.com/logged-in-successfully/"));

        // Verify page contains expected text
        WebElement bodyText = driver.findElement(By.tagName("body"));
        String pageText = bodyText.getText();
        assertTrue("Page does not contain 'Congratulations' or 'successfully logged in'.",
                pageText.contains("Congratulations") || pageText.contains("successfully logged in"));

        // Verify Log out button is displayed
        WebElement logoutButton = driver.findElement(By.linkText("Log out"));
        assertTrue("Log out button is not displayed.", logoutButton.isDisplayed());
    }

    @After
    public void tearDown() {
        // Cleanup: Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
