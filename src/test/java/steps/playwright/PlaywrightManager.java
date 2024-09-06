package steps.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.Assert;

public class PlaywrightManager {
    private static Playwright playwright;
    private static Browser browser;
    static String browserSelected = System.getenv("BROWSER");
    static String hubHost = System.getenv("HUB_HOST");
    private static BrowserContext context;
    private static Page page;

    public static Browser getBrowser() {
        if (playwright == null) {
            playwright = Playwright.create();
        }
        if (browser == null) {
            if (browserSelected == null) {
                browserSelected = "chrome-local";
            }
            if (hubHost == null) {
                hubHost = "localhost";
            }
            if(browserSelected.equalsIgnoreCase("firefox")) {
                //browser = playwright.firefox().connect("http://" + hubHost + ":4444/wd/hub");;
                System.err.println("Firefox on Selenium Grid is not supported in Playwright");
                Assert.assertFalse(true, "Firefox on Selenium Grid is not supported in Playwright");
            } else if (browserSelected.equalsIgnoreCase("chrome")) {
                //browser = playwright.chromium().connect("http://" + hubHost + ":4444/wd/hub");
                System.err.println("Chrome on Selenium Grid is not supported in Playwright");
                Assert.assertFalse(true, "Chrome on Selenium Grid is not supported in Playwright");
            } else if (browserSelected.equalsIgnoreCase("firefox-local")) {
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            } else if (browserSelected.equalsIgnoreCase("chrome-local")) {
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            }
            else {
                throw new IllegalArgumentException("Browser not supported: " + browser);
            }
        }
        return browser;
    }

    public static Page getPage() {
        if (context == null) {
            context = getBrowser().newContext();
        }
        if (page == null) {
            page = context.newPage();
            // Maximize the window by setting the viewport size to the screen size
            page.setViewportSize(1920, 1080);
        }
        return page;
    }

    public static void close() {
        if (page != null) {
            page.close();
            page = null;
        }
        if (context != null) {
            context.close();
            context = null;
        }
        if (browser != null) {
            browser.close();
            browser = null;
        }
        if (playwright != null) {
            playwright.close();
            playwright = null;
        }
    }
}