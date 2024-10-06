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

        // TODO: Browserstack variables should be get from a yaml specific file browserstack.yaml
        // this will happen only if browser is "bs-chrome" or "bs-firefox", only if browser contains "bs-" prefix
        if (driver == null) {
            System.out.println("SETUP BROWSER");
            String browser = System.getenv("BROWSER");
            String hubHost = System.getenv("HUB_HOST");
            String hubPort = System.getenv("HUB_PORT");
            String hubUrl = (hubPort != null && !hubPort.isEmpty()) ? hubHost + ":" + hubPort : hubHost;
            System.out.println("HUB URL: " + hubUrl);
            String browserstackUser = System.getenv("BROWSERSTACK_USERNAME");
            String browserstackKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
            if (browser == null) {
                browser = "firefox-local";
            }
            if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                if (browserstackUser != null && browserstackKey != null) {
                    options.setCapability("browserstack.user", browserstackUser);
                    options.setCapability("browserstack.key", browserstackKey);
                    options.setCapability("build", "Docker example");
                    options.setCapability("browserName", "chrome");
                    options.setCapability("os", "OS X");
                }
                driver = new RemoteWebDriver(new URL("http://" + hubUrl + "/wd/hub"), options);
            } else if (browser.equalsIgnoreCase("firefox")) {
                FirefoxOptions options = new FirefoxOptions();
                if (browserstackUser != null && browserstackKey != null) {
                    options.setCapability("browserstack.user", browserstackUser);
                    options.setCapability("browserstack.key", browserstackKey);
                    options.setCapability("build", "Docker example");
                    options.setCapability("browserName", "firefox");
                    options.setCapability("os", "OS X");
                }
                driver = new RemoteWebDriver(new URL("http://" + hubUrl + "/wd/hub"), options);

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
