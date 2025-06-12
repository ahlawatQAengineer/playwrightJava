package com.rahulshettyacademy.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class HomePage {
    private final Page page;
    
    // Navigation Menu
    private final Locator loginLink;
    private final Locator registerLink;
    private final Locator coursesLink;
    private final Locator practiceLink;
    private final Locator blogLink;
    
    // Course Section
    private final Locator featuredCourses;
    private final Locator allCoursesButton;
    
    // Statistics
    private final Locator studentCount;
    private final Locator courseCount;
    private final Locator ratingCount;
    private final Locator projectCount;

    public HomePage(Page page) {
        this.page = page;
        
        // Initialize navigation locators
        this.loginLink = page.locator("text=Login");
        this.registerLink = page.locator("text=Register");
        this.coursesLink = page.locator("text=Courses");
        this.practiceLink = page.locator("text=Practice");
        this.blogLink = page.locator("text=Blog");
        
        // Initialize course section locators
        this.featuredCourses = page.locator(".course-box");
        this.allCoursesButton = page.locator("text=VIEW ALL COURSES");
        
        // Initialize statistics locators
        this.studentCount = page.locator("text=Students").first();
        this.courseCount = page.locator("text=Courses").first();
        this.ratingCount = page.locator("text=Ratings").first();
        this.projectCount = page.locator("text=Projects").first();
    }

    public void clickLogin() {
        loginLink.click();
    }

    public void clickRegister() {
        registerLink.click();
    }

    public void clickCourses() {
        coursesLink.click();
    }

    public void clickPractice() {
        practiceLink.click();
    }

    public void clickBlog() {
        blogLink.click();
    }

    public void clickAllCourses() {
        allCoursesButton.click();
    }

    public int getFeaturedCoursesCount() {
        return featuredCourses.count();
    }

    public String getStudentCount() {
        return studentCount.textContent();
    }

    public String getCourseCount() {
        return courseCount.textContent();
    }

    public String getRatingCount() {
        return ratingCount.textContent();
    }

    public String getProjectCount() {
        return projectCount.textContent();
    }

    public void clickFeaturedCourse(int index) {
        featuredCourses.nth(index).click();
    }

    public String getFeaturedCourseTitle(int index) {
        return featuredCourses.nth(index).locator(".course-title").textContent();
    }

    public String getFeaturedCoursePrice(int index) {
        return featuredCourses.nth(index).locator(".course-price").textContent();
    }
} 