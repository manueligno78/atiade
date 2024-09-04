package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleHomePage {
    WebDriver driver;

    // Localizzatore per la casella di ricerca
    By searchBox = By.name("q");

    // Costruttore
    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Metodo per ottenere la casella di ricerca
    public WebElement getSearchBox() {
        return driver.findElement(searchBox);
    }

    // Metodo per verificare se la casella di ricerca è visibile
    public boolean isSearchBoxDisplayed() {
        return getSearchBox().isDisplayed();
    }
}