package com.rahulshettyacademy.tests;

import com.rahulshettyacademy.base.BaseTest;
import com.rahulshettyacademy.pages.PracticePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import com.microsoft.playwright.Page;
import org.testng.Assert;

public class WindowHandlingTest extends BaseTest {
    private PracticePage practicePage;

    @BeforeMethod
    @Override
    public void setUpTest() throws InterruptedException {
        super.setUpTest();
        navigateToPracticePage();
        practicePage = new PracticePage(page);
    }

    @Test(description = "Test opening and handling new window")
    public void testNewWindowHandling() {
        // Handle new window
        Page newPage = page.waitForPopup(() -> {
            practicePage.clickOpenWindow();
        });
        
        // Verify new window is opened
        Assert.assertNotNull(newPage, "New window should be opened");
        
        // Verify content in new window
        assertThat(newPage.locator("h3")).containsText("Featured Courses");
        
        // Close new window
        newPage.close();
    }

    @Test(description = "Test opening and handling new tab")
    public void testNewTabHandling() {
        // Handle new tab
        Page newPage = page.waitForPopup(() -> {
            practicePage.clickOpenTab();
        });
        
        // Verify new tab is opened
        Assert.assertNotNull(newPage, "New tab should be opened");
        
        // Verify content in new tab
        assertThat(newPage.locator("h3")).containsText("Featured Courses");
        
        // Close new tab
        newPage.close();
    }

    @Test(description = "Test alert handling")
    public void testAlertHandling() {
        // Set up alert handler
        page.onDialog(dialog -> {
            Assert.assertTrue(dialog.message().contains("Hello"), 
                "Alert message should contain 'Hello'");
            dialog.accept();
        });
        
        // Trigger alert
        practicePage.clickAlert();
    }

    @Test(description = "Test confirm dialog handling - Accept")
    public void testConfirmDialogAccept() {
        // Set up confirm dialog handler - Accept
        page.onDialog(dialog -> {
            Assert.assertTrue(dialog.message().contains("confirm"), 
                "Confirm dialog message should contain 'confirm'");
            dialog.accept();
        });
        
        // Trigger confirm dialog
        practicePage.clickConfirm();
    }

    @Test(description = "Test confirm dialog handling - Dismiss")
    public void testConfirmDialogDismiss() {
        // Set up confirm dialog handler - Dismiss
        page.onDialog(dialog -> {
            Assert.assertTrue(dialog.message().contains("confirm"), 
                "Confirm dialog message should contain 'confirm'");
            dialog.dismiss();
        });
        
        // Trigger confirm dialog
        practicePage.clickConfirm();
    }
} 