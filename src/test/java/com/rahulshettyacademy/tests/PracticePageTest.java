package com.rahulshettyacademy.tests;

import com.rahulshettyacademy.base.BaseTest;
import com.rahulshettyacademy.pages.PracticePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PracticePageTest extends BaseTest {
    private PracticePage practicePage;

    @BeforeMethod
    public void setUpTest() throws InterruptedException {
        navigateToPracticePage();
        practicePage = new PracticePage(page);
        Thread.sleep(2000);

    }

    @Test(description = "Verify radio button selection")
    public void testRadioButtonSelection() throws InterruptedException {
        practicePage.selectRadioButton(0);
        assertThat(page.locator("input[type='radio']").nth(0)).isChecked();
        Thread.sleep(2000);

    }

    @Test(description = "Verify suggestion input")
    public void testSuggestionInput() throws InterruptedException {
        practicePage.enterSuggestion("India");
        assertThat(page.locator("#autocomplete")).hasValue("India");
        Thread.sleep(2000);

    }

    @Test(description = "Verify dropdown selection")
    public void testDropdownSelection() throws InterruptedException {
        practicePage.selectFromDropdown("option1");
        assertThat(page.locator("#dropdown-class-example")).hasValue("option1");
        Thread.sleep(2000);

    }

    @Test(description = "Verify checkbox functionality")
    public void testCheckboxFunctionality() throws InterruptedException {
        practicePage.checkOption(0);
        assertThat(page.locator("input[type='checkbox']").nth(0)).isChecked();
        
        practicePage.uncheckOption(0);
        assertThat(page.locator("input[type='checkbox']").nth(0)).not().isChecked();
        Thread.sleep(2000);
    }

    @Test(description = "Verify element visibility")
    public void testElementVisibility() throws InterruptedException {
        assertThat(page.locator("#displayed-text")).isVisible();
        
        practicePage.hideElement();
        assertThat(page.locator("#displayed-text")).isHidden();
        
        practicePage.showElement();
        assertThat(page.locator("#displayed-text")).isVisible();
        Thread.sleep(2000);

    }

    @Test(description = "Verify table content")
    public void testTableContent() throws InterruptedException {
        String cellText = practicePage.getTableCellText(1, 0);
        assertThat(page.locator(".table-display tr").nth(1).locator("td").nth(0))
            .hasText(cellText);
        Thread.sleep(2000);

    }
} 