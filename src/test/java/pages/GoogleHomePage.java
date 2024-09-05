package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

public class GoogleHomePage extends LoadableComponent<GoogleHomePage>{
    WebDriver driver;

    By searchBox = By.name("q");

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSearchBox() {
        return driver.findElement(searchBox);
    }

    public boolean isSearchBoxDisplayed() {
        return getSearchBox().isDisplayed();
    }

    @Override
    protected void isLoaded() throws Error {
        Assert.assertTrue(driver.getCurrentUrl().contains("www.google.com"));
    }

    @Override
    protected void load() {
        driver.get("https://www.google.com");
    }
}