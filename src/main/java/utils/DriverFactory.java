package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static WebDriver driver;

    private DriverFactory() {
    }

    public static WebDriver getDriver() {
        try {

            if (driver == null) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                driver = new RemoteWebDriver(new URL("http://10.22.221.63:4004/wd/hub"), new ChromeOptions());
                driver.manage().window().maximize();
                driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    public static void quit() {
        driver.quit();
        driver = null;
    }
}
