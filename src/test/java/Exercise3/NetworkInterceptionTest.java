package Exercise3;

import com.google.common.net.MediaType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.NetworkInterceptor;
import org.openqa.selenium.remote.http.Contents;
import org.openqa.selenium.remote.http.HttpResponse;
import org.openqa.selenium.remote.http.Route;
import org.openqa.selenium.support.ui.Wait;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NetworkInterceptionTest {
    WebDriver driver;
    DevTools devtools;
    Wait<WebDriver> wait;


    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
    }
    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    public void InterceptWithNewContent() throws IOException, InterruptedException {

        Path path = Paths.get("src/test/resources/selenium-logo.png");
        byte[] bytes = Files.readAllBytes(path);

        Route route = Route.matching(req -> req.toString().contains("jpg"))
                .to(() -> req -> new HttpResponse()
                        .addHeader("Content-Type", MediaType.PNG.toString())
                        .setContent(Contents.bytes(bytes)));

        driver.get("https://automationbookstore.dev/");
        // Thread.sleep only meant for demo purposes!
        driver.manage().window().maximize();

        Thread.sleep(5000);
        try (NetworkInterceptor interceptor = new NetworkInterceptor(driver, route)) {
            driver.get("https://automationbookstore.dev/");
        }
        // Thread.sleep only meant for demo purposes!
        Thread.sleep(5000);
    }
}
