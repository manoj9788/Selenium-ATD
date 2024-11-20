package Exercise3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v130.emulation.Emulation;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GeolocationTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();
        Number latitude = 52.5043;
        Number longitude = 18.4501;

        devTools.send(Emulation.setGeolocationOverride(Optional.of(latitude),
                Optional.of(longitude),
                Optional.of(1)));

        driver.get("https://my-location.org/");
    }
}
