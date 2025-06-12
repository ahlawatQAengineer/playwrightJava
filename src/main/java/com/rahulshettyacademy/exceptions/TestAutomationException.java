package com.rahulshettyacademy.exceptions;

public class TestAutomationException extends RuntimeException {
    public TestAutomationException(String message) {
        super(message);
    }

    public TestAutomationException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestAutomationException(Throwable cause) {
        super(cause);
    }

    public static TestAutomationException elementNotFound(String elementDescription) {
        return new TestAutomationException("Element not found: " + elementDescription);
    }

    public static TestAutomationException elementNotVisible(String elementDescription) {
        return new TestAutomationException("Element not visible: " + elementDescription);
    }

    public static TestAutomationException elementNotClickable(String elementDescription) {
        return new TestAutomationException("Element not clickable: " + elementDescription);
    }

    public static TestAutomationException invalidState(String message) {
        return new TestAutomationException("Invalid state: " + message);
    }

    public static TestAutomationException timeout(String message) {
        return new TestAutomationException("Timeout: " + message);
    }
} 