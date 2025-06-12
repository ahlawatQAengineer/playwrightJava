# Rahul Shetty Academy Automation Framework

This is a Playwright-based test automation framework for the Rahul Shetty Academy website. The framework is built using Java, Playwright, TestNG, and Maven.

## Project Structure

```
your-playwright-automation-framework/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/rahulshettyacademy/
│   │   │       ├── base/
│   │   │       │   ├── BaseTest.java
│   │   │       │   └── PlaywrightManager.java
│   │   │       └── pages/
│   │   │           ├── HomePage.java
│   │   │           └── PracticePage.java
│   │   └── resources/
│   │       └── config.properties
│   └── test/
│       └── java/
│           └── com/rahulshettyacademy/
│               └── tests/
│                   └── PracticePageTest.java
├── pom.xml
├── testng.xml
└── README.md
```

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher
- Playwright for Java

## Setup

1. Clone the repository
2. Install dependencies:
   ```bash
   mvn clean install
   ```
3. Install Playwright browsers:
   ```bash
   mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="install"
   ```

## Running Tests

To run all tests:
```bash
mvn clean test
```

To run a specific test class:
```bash
mvn test -Dtest=PracticePageTest
```

## Framework Features

- Page Object Model design pattern
- Thread-safe Playwright instance management
- Parallel test execution support
- Configuration management
- Screenshot capture on test failure
- Video recording support
- Logging support

## Configuration

The framework can be configured using the `config.properties` file located in `src/main/resources/`. Key configurations include:

- Browser type (chromium/firefox/webkit)
- Headless mode
- Viewport settings
- Timeouts
- Screenshot and video recording settings

## Test Reports

Test reports are generated in the `test-output` directory after test execution. The framework generates:

- TestNG HTML reports
- Screenshots of failed tests
- Test execution videos (if enabled)

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request 