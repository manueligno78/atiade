package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class CAHomePage extends LoadableComponent<CAHomePage> {
    WebDriver driver;
    WebDriverWait wait;

    // Define locators using @FindBy annotation
    @FindBy(xpath = "//input[@class='react-autosuggest__input']")
    WebElement searchInput;

    @FindBy(xpath = "//a[@aria-label='Pricing & Plans']")
    WebElement pricingLink;

    @FindBy(xpath = "//span[contains(text(),'Start Now')]")
    WebElement startNowButton;

    @FindBy(xpath = "//h1[@data-cy='search-result-title']")
    List<WebElement> searchResultTitles;

    @FindBy(xpath = "//div[@data-cy='GridCol']//span[@data-cy='button-label']")
    List<WebElement> pricingPlans;

    @FindBy(xpath = "//input[@name='name']")
    WebElement nameField;

    @FindBy(xpath = "//input[@name='email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordField;

    @FindBy(xpath = "//input[@name='company']")
    WebElement companyField;

    @FindBy(xpath = "//input[@name='phone']")
    WebElement phoneField;

    public CAHomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void search(String query) {
        searchInput.sendKeys(query);
    }

    public void clickPricing() {
        wait.until(ExpectedConditions.visibilityOf(pricingLink));
        pricingLink.click();
    }

    public void clickStartNowSmallTeams() {
        startNowButton.click();
    }

    public List<WebElement> getSearchResultTitles() {
        return searchResultTitles;
    }

    public List<WebElement> getPricingPlans() {
        return pricingPlans;
    }

    public WebElement getNameField() {
        return nameField;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getCompanyField() {
        return companyField;
    }

    public WebElement getPhoneField() {
        return phoneField;
    }

    @Override
    protected void load() {
        driver.get("https://platform.qa.com/library/");
    }

    @Override
    protected void isLoaded() throws Error {
        Assert.assertTrue(driver.getCurrentUrl().contains("https://platform.qa.com/library/"));
        wait.until(ExpectedConditions.visibilityOf(searchInput));
    }
}