package com.rahulshettyacademy.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.microsoft.playwright.Page;
import com.rahulshettyacademy.base.BaseTest;
import java.nio.file.Paths;
import java.util.Date;

public class TestListener implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
        System.out.println("===============================================");
        System.out.println("Test Suite started at: " + new Date());
        System.out.println("===============================================");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("===============================================");
        System.out.println("Test Suite finished at: " + new Date());
        System.out.println("Total passed tests: " + context.getPassedTests().size());
        System.out.println("Total failed tests: " + context.getFailedTests().size());
        System.out.println("Total skipped tests: " + context.getSkippedTests().size());
        System.out.println("===============================================");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Starting test: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getMethod().getMethodName());
        System.out.println("Failure details: " + result.getThrowable());
        
        // Capture screenshot on failure
        try {
            BaseTest test = (BaseTest) result.getInstance();
            Page page = test.getPage();
            String screenshotPath = "test-output/screenshots/" + 
                result.getMethod().getMethodName() + "_" + 
                System.currentTimeMillis() + ".png";
            page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get(screenshotPath))
                .setFullPage(true));
            System.out.println("Screenshot captured: " + screenshotPath);
        } catch (Exception e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test failed but within success percentage: " + result.getMethod().getMethodName());
    }
} 