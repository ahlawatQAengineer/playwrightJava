package com.rahulshettyacademy.base;

import com.microsoft.playwright.Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    protected Page page;
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

    @BeforeMethod
    public void setUp() {
        PlaywrightManager.initBrowser(config);
        page = PlaywrightManager.getPage();
    }

    @AfterMethod
    public void tearDown() {
        PlaywrightManager.closeBrowser();
    }

    protected void navigateToHomePage() {
        page.navigate(config.getProperty("home.url"));
    }

    protected void navigateToPracticePage() {
        page.navigate(config.getProperty("practice.url"));
    }
} 