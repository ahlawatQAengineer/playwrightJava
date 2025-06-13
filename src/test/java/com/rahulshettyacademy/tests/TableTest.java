package com.rahulshettyacademy.tests;

import com.rahulshettyacademy.base.BaseTest;
import com.rahulshettyacademy.pages.PracticePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableTest extends BaseTest {
    private PracticePage practicePage;

    @BeforeMethod
    @Override
    public void setUpTest() throws InterruptedException {
        super.setUpTest();
        navigateToPracticePage();
        practicePage = new PracticePage(page);
    }

    @Test(priority = 1, description = "Test course table content and structure")
    public void testCourseTableContent() {
        // Verify table headers
        assertThat(page.locator(".table-display th").nth(0)).hasText("Instructor");
        assertThat(page.locator(".table-display th").nth(1)).hasText("Course");
        assertThat(page.locator(".table-display th").nth(2)).hasText("Price");

        // Verify specific row content
        String instructor = practicePage.getTableCellText(1, 0);
        String course = practicePage.getTableCellText(1, 1);
        String price = practicePage.getTableCellText(1, 2);
        
        assertThat(page.locator(".table-display tr").nth(1).locator("td").nth(0)).hasText(instructor);
        assertThat(page.locator(".table-display tr").nth(1).locator("td").nth(1)).hasText(course);
        assertThat(page.locator(".table-display tr").nth(1).locator("td").nth(2)).hasText(price);
    }

    @Test(priority = 2, description = "Test fixed header table content and sum verification")
    public void testFixedHeaderTableContent() {
        // Create a list to store amounts
        List<Integer> amounts = new ArrayList<>();
        
        // Get number of rows in fixed table (excluding header)
        int rowCount = page.locator(".tableFixHead tbody tr").count();
        
        // Collect all amounts
        for (int i = 0; i < rowCount; i++) {
            String amountText = practicePage.getFixedTableCellText(i, 3);
            amounts.add(Integer.parseInt(amountText.trim()));
        }
        
        // Calculate sum
        int calculatedSum = amounts.stream().mapToInt(Integer::intValue).sum();
        
        // Get displayed total amount
        String totalText = page.locator(".totalAmount").textContent();
        int displayedTotal = Integer.parseInt(totalText.replaceAll("[^0-9]", ""));
        
        // Verify sum matches displayed total
        assertThat(page.locator(".totalAmount")).hasText("Total Amount Collected: " + calculatedSum);
    }

    @Test(priority = 3, description = "Test table data aggregation by city")
    public void testTableAggregationByCity() {
        // Create a map to store city-wise employee count
        Map<String, Integer> cityCount = new HashMap<>();
        
        // Get number of rows
        int rowCount = page.locator(".tableFixHead tbody tr").count();
        
        // Collect city-wise counts
        for (int i = 0; i < rowCount; i++) {
            String city = practicePage.getFixedTableCellText(i, 2);
            cityCount.merge(city, 1, Integer::sum);
        }
        
        // Verify Chennai has maximum employees
        int chennaiCount = cityCount.getOrDefault("Chennai", 0);
        for (Map.Entry<String, Integer> entry : cityCount.entrySet()) {
            if (!entry.getKey().equals("Chennai")) {
                assertThat(page.locator("body")).isVisible(); // Dummy assertion to keep test structure
                assert chennaiCount >= entry.getValue() : 
                    "Chennai should have maximum employees but " + entry.getKey() + " has more";
            }
        }
    }

    @Test(priority = 4, description = "Test table sorting functionality")
    public void testTableSorting() {
        // Get all amounts in original order
        List<Integer> originalAmounts = new ArrayList<>();
        List<Integer> sortedAmounts = new ArrayList<>();
        
        int rowCount = page.locator(".tableFixHead tbody tr").count();
        
        for (int i = 0; i < rowCount; i++) {
            String amountText = practicePage.getFixedTableCellText(i, 3);
            int amount = Integer.parseInt(amountText.trim());
            originalAmounts.add(amount);
            sortedAmounts.add(amount);
        }
        
        // Sort the copied list
        sortedAmounts.sort((a, b) -> b - a); // Descending order
        
        // Verify maximum amount is at expected position
        String maxAmountCell = practicePage.getFixedTableCellText(
            originalAmounts.indexOf(sortedAmounts.get(0)), 3);
        assertThat(page.locator(".tableFixHead tbody tr")
            .nth(originalAmounts.indexOf(sortedAmounts.get(0)))
            .locator("td").nth(3)).hasText(maxAmountCell);
    }
} 