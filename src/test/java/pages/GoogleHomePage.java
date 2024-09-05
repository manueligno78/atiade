package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleHomePage {
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
}