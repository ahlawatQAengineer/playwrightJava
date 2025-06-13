package com.rahulshettyacademy.base;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    protected static Playwright playwright;
    protected static Browser browser;
    protected Page page;
    protected BrowserContext context;
    protected static Properties config;

    static {
        config = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            config.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public void setUpClass() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
            .setHeadless(false));
    }

    @BeforeMethod
    public void setUpTest() throws InterruptedException {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterMethod
    public void tearDownTest() throws InterruptedException {
        // Force wait between tests
        Thread.sleep(2000);

        // Close all pages in the context
        if (context != null) {
            for (Page p : context.pages()) {
                if (!p.isClosed()) {
                    p.close();
                }
            }
        }

        // Close context
        if (context != null) {
            context.close();
        }

        // Reset references
        page = null;
        context = null;
    }

    @AfterClass
    public void tearDownClass() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }

    protected void navigateToHomePage() {
        page.navigate(config.getProperty("home.url"));
    }

    protected void navigateToPracticePage() {
        page.navigate(config.getProperty("practice.url"));
    }

    public Page getPage() {
        return page;
    }

    protected void forceWait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread was interrupted during force wait", e);
        }
    }
} 