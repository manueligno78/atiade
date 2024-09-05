package steps.cucumber;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Step {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    public static void setUp() throws MalformedURLException {
        if (driver == null) {
            System.out.println("SETUP BROWSER");
            String browser = System.getenv("BROWSER");
            String hubHost = System.getenv("HUB_HOST");
            // Default to Chrome Local execution
            if (browser == null) {
                browser = "firefox-local";
            }
            if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                driver = new RemoteWebDriver(new URL("http://" + hubHost + ":4444/wd/hub"), options);
            } else if (browser.equalsIgnoreCase("firefox")) {
                FirefoxOptions options = new FirefoxOptions();
                driver = new RemoteWebDriver(new URL("http://" + hubHost + ":4444/wd/hub"), options);
            } else if (browser.equalsIgnoreCase("chrome-local")) {
                WebDriverManager.chromedriver().clearDriverCache().setup();
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox-local")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else {
                throw new IllegalArgumentException("Browser not supported: " + browser);
            }
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, 10);
            System.out.println("SETUP BROWSER DONE!");
        }
    }


    public static void tearDown() {
        if (driver != null) {
            System.out.println("TEARING DOWN BROWSER");
            driver.quit();
            driver= null;
        }
    }
}
