package steps;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.GoogleHomePage;

public class GoogleSearchSteps {
    WebDriver driver;
    GoogleHomePage googleHomePage;

    @Given("I open Google homepage")
    public void i_open_google_homepage() throws MalformedURLException {
        String browser = System.getenv("BROWSER");
        String hubHost = System.getenv("HUB_HOST");

        if (browser == null || browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            driver = new RemoteWebDriver(new URL("http://" + hubHost + ":4444/wd/hub"), options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            driver = new RemoteWebDriver(new URL("http://" + hubHost + ":4444/wd/hub"), options);
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        driver.get("https://www.google.com");
        googleHomePage = new GoogleHomePage(driver);
    }

    @Then("I should see the search box")
    public void i_should_see_the_search_box() {
        Assert.assertTrue(googleHomePage.isSearchBoxDisplayed());
        driver.quit();
    }
    
    @Then("I should assert false")
    public void i_should_assert_false() {
        Assert.assertFalse(true);
        driver.quit();
    }
}