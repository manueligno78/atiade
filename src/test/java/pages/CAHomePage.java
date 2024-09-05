package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CAHomePage extends LoadableComponent<CAHomePage> {
    WebDriver driver;
    WebDriverWait wait;

    public CAHomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void search(String query) {
        //<input type="text" autocomplete="off" aria-autocomplete="list" aria-controls="react-autowhatever-1" class="react-autosuggest__input" placeholder="Search in our library..." value=""><div id="react-autowhatever-1" role="listbox" class="react-autosuggest__suggestions-container"></div>
        driver.findElement(By.xpath("//input[@class='react-autosuggest__input']"))
                .sendKeys(query);
    }

    @Override
    protected void load() {
        driver.get("https://platform.qa.com/library/");
    }

    @Override
    protected void isLoaded() throws Error {
        Assert.assertTrue(driver.getCurrentUrl().contains("https://platform.qa.com/library/"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='react-autosuggest__input']")));
    }

    public void clickPricing() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='Pricing & Plans']")));
        driver.findElement(By.xpath("//a[@aria-label='Pricing & Plans']")).click();

    }

    public void clickStartNowSmallTeams() {
        driver.findElement(By.xpath("//span[contains(text(),'Start Now')]")).click();
    }
}
