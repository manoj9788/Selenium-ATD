package Exercise2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BadCode {

    public void test() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com/login");
        driver.findElement(By.id("username")).sendKeys("testuser");
        driver.findElement(By.id("password")).sendKeys("password123");
        driver.findElement(By.id("login")).click();

        if (driver.getTitle() == "Dashboard") {
            System.out.println("Login Successful");
        } else {
            System.out.println("Login Failed");
        }
    }
}















/*
Issues in the Bad Code:
Non-descriptive Method Name: The method is named test, which doesn’t convey what it’s testing.
Hardcoded Strings: Credentials and URLs are hardcoded, which is a bad practice.
Improper String Comparison: Uses == for string comparison instead of .equals().
No Cleanup: The WebDriver instance is not closed, potentially leaving resources open.
No Modularization: All steps (setup, login, and validation) are combined in one method, making it harder to read and maintain.
 */