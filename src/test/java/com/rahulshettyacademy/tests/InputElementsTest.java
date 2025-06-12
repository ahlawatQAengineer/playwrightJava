package com.rahulshettyacademy.tests;

import com.rahulshettyacademy.base.BaseTest;
import com.rahulshettyacademy.pages.PracticePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class InputElementsTest extends BaseTest {
    private PracticePage practicePage;

    @BeforeMethod
    @Override
    public void setUpTest() throws InterruptedException {
        super.setUpTest();
        navigateToPracticePage();
        practicePage = new PracticePage(page);
    }

    @Test(description = "Test all radio button selections")
    public void testAllRadioButtons() {
        // Test each radio button
        for (int i = 0; i < 3; i++) {
            practicePage.selectRadioButton(i);
            assertThat(page.locator("input[type='radio']").nth(i)).isChecked();
            // Verify other radio buttons are unchecked
            for (int j = 0; j < 3; j++) {
                if (j != i) {
                    assertThat(page.locator("input[type='radio']").nth(j)).not().isChecked();
                }
            }
        }
    }

    @Test(description = "Test suggestion input with different types of data")
    public void testSuggestionInputWithDifferentData() {
        // Test with alphabets
        practicePage.enterSuggestion("India");
        assertThat(page.locator("#autocomplete")).hasValue("India");

        // Test with alphanumeric
        practicePage.enterSuggestion("India123");
        assertThat(page.locator("#autocomplete")).hasValue("India123");

        // Test with special characters
        practicePage.enterSuggestion("India@#$");
        assertThat(page.locator("#autocomplete")).hasValue("India@#$");

        // Test with spaces
        practicePage.enterSuggestion("New Delhi");
        assertThat(page.locator("#autocomplete")).hasValue("New Delhi");
    }

    @Test(description = "Test all dropdown options")
    public void testAllDropdownOptions() {
        String[] options = {"option1", "option2", "option3"};
        for (String option : options) {
            practicePage.selectFromDropdown(option);
            assertThat(page.locator("#dropdown-class-example")).hasValue(option);
        }
    }

    @Test(description = "Test checkbox combinations")
    public void testCheckboxCombinations() {
        // Test checking individual boxes
        for (int i = 0; i < 3; i++) {
            practicePage.checkOption(i);
            assertThat(page.locator("input[type='checkbox']").nth(i)).isChecked();
            practicePage.uncheckOption(i);
            assertThat(page.locator("input[type='checkbox']").nth(i)).not().isChecked();
        }

        // Test checking all boxes
        for (int i = 0; i < 3; i++) {
            practicePage.checkOption(i);
        }
        for (int i = 0; i < 3; i++) {
            assertThat(page.locator("input[type='checkbox']").nth(i)).isChecked();
        }

        // Test unchecking all boxes
        for (int i = 0; i < 3; i++) {
            practicePage.uncheckOption(i);
        }
        for (int i = 0; i < 3; i++) {
            assertThat(page.locator("input[type='checkbox']").nth(i)).not().isChecked();
        }
    }

    @Test(description = "Test element visibility toggle")
    public void testElementVisibilityToggle() {
        // Test initial visibility
        assertThat(page.locator("#displayed-text")).isVisible();
        
        // Test hiding
        practicePage.hideElement();
        assertThat(page.locator("#displayed-text")).isHidden();
        
        // Test showing
        practicePage.showElement();
        assertThat(page.locator("#displayed-text")).isVisible();
        
        // Test multiple toggles
        practicePage.hideElement();
        assertThat(page.locator("#displayed-text")).isHidden();
        practicePage.showElement();
        assertThat(page.locator("#displayed-text")).isVisible();
    }
} 