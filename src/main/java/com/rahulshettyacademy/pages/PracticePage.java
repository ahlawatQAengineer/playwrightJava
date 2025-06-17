package com.rahulshettyacademy.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.MouseButton;

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


    private final Locator courseClick;


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
        this.courseClick = page.locator("text=Home");
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

    public void clearSuggestionInput() {
        suggestionInput.clear();
    }

    //**
    //**
    //**
    //**
    //**


    public void enterinput(String hello){
        suggestionInput.fill(hello);
    }

    public void clearInput(){
        suggestionInput.clear();
    }

    public void typeinInput(String a, String b, String c, String d, int K){

        Locator.PressSequentiallyOptions typeOpt =  new Locator.PressSequentiallyOptions().setDelay((K*1000));
        suggestionInput.pressSequentially(a, typeOpt);
        suggestionInput.pressSequentially(b, typeOpt);
        suggestionInput.pressSequentially(c, typeOpt);
        suggestionInput.pressSequentially(d, typeOpt);
    }

    public void pressButtons(String P){
        suggestionInput.press(P);

    }

    public void focusSuggestionInput() {
        suggestionInput.focus();
    }

    public void fetchTestContent(){
        String Value1  =  suggestionInput.getAttribute("Value");
        System.out.println("Fetched Value is : " + Value1);

        String textContent1  = suggestionInput.textContent();
        System.out.println("Fetched entire Text content is : " + textContent1);

        String innerText1 = suggestionInput.innerText();
        System.out.println("Fetched inner Text content is : " + innerText1);

        String inputValue1 = suggestionInput.inputValue();
        System.out.println("Fetched input Value content is : " + inputValue1);

        String htmlCOntent1 = suggestionInput.innerHTML();
        System.out.println("Fetched inner HTML content is : " + inputValue1);

        String getAttribute =  null;
        getAttribute = suggestionInput.getAttribute("name");
        System.out.println("Fetched name attribute of the element is : " + getAttribute);


        getAttribute = suggestionInput.getAttribute("id");
        System.out.println("Fetched id attribute of the element is : " + getAttribute);

        getAttribute = suggestionInput.getAttribute("class");
        System.out.println("Fetched class attribute of the element is : " + getAttribute);

        getAttribute = suggestionInput.getAttribute("href");
        System.out.println("Fetched href attribute of the element is : " + getAttribute);

        getAttribute = suggestionInput.getAttribute("src");
        System.out.println("Fetched src attribute of the element is : " + getAttribute);

        getAttribute = suggestionInput.getAttribute("title");
        System.out.println("Fetched title attribute of the element is : " + getAttribute);

        getAttribute = suggestionInput.getAttribute("placeholder");
        System.out.println("Fetched placeholder attribute of the element is : " + getAttribute);

    }
        public void clicksTest() throws InterruptedException {

        // Click
            courseClick.click();
            Thread.sleep(1000);
            page.goBack();
            Thread.sleep(2000);
        }


        public  void rightClick() throws InterruptedException {

            Locator.ClickOptions rightClick = new Locator.ClickOptions().setButton(MouseButton.valueOf("RIGHT"));
            courseClick.click(rightClick);
            Thread.sleep(2000);


        }










} 