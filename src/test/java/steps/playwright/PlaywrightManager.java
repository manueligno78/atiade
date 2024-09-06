package steps.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightManager {
    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;

    public static Browser getBrowser() {
        if (playwright == null) {
            playwright = Playwright.create();
        }
        if (browser == null) {
            // Set headless to false to see the browser in action
            //browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
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