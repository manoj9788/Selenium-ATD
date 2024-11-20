package Exercise1;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageTest {


        public static void main(String[] args) {
            // Setup WebDriver
            WebDriver driver = new ChromeDriver();

                // Step 1: Open page
                driver.get("https://practicetestautomation.com/practice-test-login/");

                // Step 2: Type username 'student' into Username field
                driver.findElement(By.id("username")).sendKeys("student");

                // Step 3: Type password 'Password123' into Password field
                driver.findElement(By.id("password")).sendKeys("Password123");

                // Step 4: Push Submit button
                driver.findElement(By.id("submit")).click();

            WebElement message = driver.findElement(By.id("success-message"));
            Assertions.assertEquals("Received!", message.getText());


            // Close the browser
                driver.quit();
        }
}
