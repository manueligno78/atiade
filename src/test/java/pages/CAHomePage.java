package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CAHomePage {
    WebDriver driver;

    public CAHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void search(String query) {
        //<input type="text" autocomplete="off" aria-autocomplete="list" aria-controls="react-autowhatever-1" class="react-autosuggest__input" placeholder="Search in our library..." value=""><div id="react-autowhatever-1" role="listbox" class="react-autosuggest__suggestions-container"></div>
        driver.findElement(By.xpath("//input[@class='react-autosuggest__input']"))
                .sendKeys(query);
    }
}
