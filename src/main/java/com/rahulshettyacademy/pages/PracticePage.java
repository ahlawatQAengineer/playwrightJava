package com.rahulshettyacademy.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class PracticePage {
    private final Page page;
    
    // Radio Buttons
    private final Locator radioButtons;
    
    // Suggestion Class
    private final Locator suggestionInput;
    
    // Dropdown
    private final Locator dropdown;
    
    // Checkboxes
    private final Locator checkboxes;
    
    // Windows and Tabs
    private final Locator openWindowButton;
    private final Locator openTabButton;
    
    // Alert
    private final Locator alertButton;
    private final Locator confirmButton;
    
    // Tables
    private final Locator courseTable;
    private final Locator fixedTable;
    
    // Element Display
    private final Locator hideShowInput;
    private final Locator hideButton;
    private final Locator showButton;
    
    // Mouse Hover
    private final Locator mouseHoverButton;

    public PracticePage(Page page) {
        this.page = page;
        
        // Initialize locators
        this.radioButtons = page.locator("input[type='radio']");
        this.suggestionInput = page.locator("#autocomplete");
        this.dropdown = page.locator("#dropdown-class-example");
        this.checkboxes = page.locator("input[type='checkbox']");
        this.openWindowButton = page.locator("#openwindow");
        this.openTabButton = page.locator("#opentab");
        this.alertButton = page.locator("#alertbtn");
        this.confirmButton = page.locator("#confirmbtn");
        this.courseTable = page.locator(".table-display");
        this.fixedTable = page.locator(".tableFixHead");
        this.hideShowInput = page.locator("#displayed-text");
        this.hideButton = page.locator("#hide-textbox");
        this.showButton = page.locator("#show-textbox");
        this.mouseHoverButton = page.locator("#mousehover");
    }

    public void selectRadioButton(int index) {
        radioButtons.nth(index).click();
    }

    public void enterSuggestion(String text) {
        suggestionInput.fill(text);
    }

    public void selectFromDropdown(String option) {
        dropdown.selectOption(option);
    }

    public void checkOption(int index) {
        checkboxes.nth(index).check();
    }

    public void uncheckOption(int index) {
        checkboxes.nth(index).uncheck();
    }

    public void clickOpenWindow() {
        openWindowButton.click();
    }

    public void clickOpenTab() {
        openTabButton.click();
    }

    public void clickAlert() {
        alertButton.click();
    }

    public void clickConfirm() {
        confirmButton.click();
    }

    public String getTableCellText(int row, int col) {
        return courseTable.locator("tr").nth(row).locator("td").nth(col).textContent();
    }

    public String getFixedTableCellText(int row, int col) {
        return fixedTable.locator("tr").nth(row).locator("td").nth(col).textContent();
    }

    public void hideElement() {
        hideButton.click();
    }

    public void showElement() {
        showButton.click();
    }

    public boolean isElementVisible() {
        return hideShowInput.isVisible();
    }

    public void hoverMouseOver() {
        mouseHoverButton.hover();
    }
} 