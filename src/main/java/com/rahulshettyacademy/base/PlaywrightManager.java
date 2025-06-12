package com.rahulshettyacademy.base;

import com.microsoft.playwright.*;
import java.nio.file.Paths;
import java.util.Properties;

public class PlaywrightManager {
    private static final ThreadLocal<Playwright> playwrightThread = new ThreadLocal<>();
    private static final ThreadLocal<Browser> browserThread = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> contextThread = new ThreadLocal<>();
    private static final ThreadLocal<Page> pageThread = new ThreadLocal<>();
    private static Properties config;

    public static void initBrowser(Properties properties) {
        config = properties;
        Playwright playwright = Playwright.create();
        playwrightThread.set(playwright);

        Browser browser = createBrowser(playwright);
        browserThread.set(browser);

        BrowserContext context = createContext(browser);
        contextThread.set(context);

        Page page = context.newPage();
        pageThread.set(page);
    }

    private static Browser createBrowser(Playwright playwright) {
        String browserType = config.getProperty("browser", "chromium").toLowerCase();
        boolean headless = Boolean.parseBoolean(config.getProperty("headless", "false"));
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(headless);

        switch (browserType) {
            case "firefox":
                return playwright.firefox().launch(launchOptions);
            case "webkit":
                return playwright.webkit().launch(launchOptions);
            default:
                return playwright.chromium().launch(launchOptions);
        }
    }

    private static BrowserContext createContext(Browser browser) {
        Browser.NewContextOptions contextOptions = new Browser.NewContextOptions()
            .setViewportSize(
                Integer.parseInt(config.getProperty("viewport.width", "1920")),
                Integer.parseInt(config.getProperty("viewport.height", "1080"))
            )
            .setRecordVideoDir(Boolean.parseBoolean(config.getProperty("video.enabled", "false")) 
                ? Paths.get(config.getProperty("video.dir", "test-output/videos"))
                : null);

        return browser.newContext(contextOptions);
    }

    public static Page getPage() {
        return pageThread.get();
    }

    public static void closeBrowser() {
        if (pageThread.get() != null) {
            pageThread.get().close();
            pageThread.remove();
        }
        if (contextThread.get() != null) {
            contextThread.get().close();
            contextThread.remove();
        }
        if (browserThread.get() != null) {
            browserThread.get().close();
            browserThread.remove();
        }
        if (playwrightThread.get() != null) {
            playwrightThread.get().close();
            playwrightThread.remove();
        }
    }
} 