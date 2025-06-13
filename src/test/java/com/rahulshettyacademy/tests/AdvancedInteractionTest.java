package com.rahulshettyacademy.tests;

import com.rahulshettyacademy.base.BaseTest;
import com.rahulshettyacademy.pages.PracticePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import com.microsoft.playwright.FrameLocator;

public class AdvancedInteractionTest extends BaseTest {
    private PracticePage practicePage;

    @BeforeMethod
    @Override
    public void setUpTest() throws InterruptedException {
        super.setUpTest();
        navigateToPracticePage();
        practicePage = new PracticePage(page);
    }

    @Test(priority = 1, description = "Test mouse hover functionality")
    public void testMouseHover() {
        // Perform mouse hover
        practicePage.hoverMouseOver();
        
        // Verify dropdown becomes visible
        assertThat(page.locator(".mouse-hover-content")).isVisible();
        
        // Verify dropdown options
        assertThat(page.locator(".mouse-hover-content a").nth(0)).hasText("Top");
        assertThat(page.locator(".mouse-hover-content a").nth(1)).hasText("Reload");
    }

    @Test(priority = 2, description = "Test mouse hover interaction with dropdown items")
    public void testMouseHoverInteraction() {
        // Hover and click top link
        page.hover("#mousehover");
        page.locator(".mouse-hover-content a").nth(0).click();
        
        // Verify we're at the top
        assertThat(page.locator("h1")).isVisible();
        
        // Hover and click reload
        page.hover("#mousehover");
        page.locator(".mouse-hover-content a").nth(1).click();
        
        // Verify page is reloaded by checking a known element
        assertThat(page.locator("h1")).isVisible();
    }

    @Test(priority = 3, description = "Test iframe content and interactions")
    public void testIframeContent() {
        // Get the iframe
        FrameLocator frameLocator = page.frameLocator("#courses-iframe");
        
        // Verify iframe content
        assertThat(frameLocator.locator("h1")).isVisible();
        
        // Verify navigation elements in iframe
        assertThat(frameLocator.locator("nav")).isVisible();
        
        // Verify specific content in iframe
        assertThat(frameLocator.locator(".text h2")).containsText("Courses");
    }

    @Test(priority = 4, description = "Test iframe navigation and interaction")
    public void testIframeNavigation() {
        // Get the iframe
        FrameLocator frameLocator = page.frameLocator("#courses-iframe");
        
        // Click on a navigation link
        frameLocator.locator("a:has-text('Courses')").click();
        
        // Verify navigation worked
        assertThat(frameLocator.locator(".course-listing")).isVisible();
        
        // Verify course elements are present
        assertThat(frameLocator.locator(".course-listing-title")).isVisible();
    }

    @Test(priority = 5, description = "Test iframe form interaction")
    public void testIframeFormInteraction() {
        // Get the iframe
        FrameLocator frameLocator = page.frameLocator("#courses-iframe");
        
        // Find and interact with search form if present
        if (frameLocator.locator("input[type='search']").isVisible()) {
            frameLocator.locator("input[type='search']").fill("Selenium");
            frameLocator.locator("input[type='search']").press("Enter");
            
            // Verify search results
            assertThat(frameLocator.locator(".course-listing")).isVisible();
        }
        
        // Alternative: Interact with newsletter form if present
        if (frameLocator.locator("input[placeholder*='email']").isVisible()) {
            frameLocator.locator("input[placeholder*='email']").fill("test@example.com");
            // Don't actually submit to avoid real form submission
            assertThat(frameLocator.locator("input[placeholder*='email']")).hasValue("test@example.com");
        }
    }
} 