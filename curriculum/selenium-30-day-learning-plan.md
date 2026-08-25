# Selenium in 30 Days — Professional Learning Plan

## Purpose

This README is a complete 30-day learning curriculum for learning **Selenium WebDriver with Java** from scratch to a practical, job-ready level.

The goal is not to memorize Selenium APIs. The goal is to understand browser automation, write reliable tests, design maintainable automation frameworks, and build a realistic Selenium project.

Use this README as the curriculum for an AI teacher.

---

# How ChatGPT Should Teach Me

When I give this README to ChatGPT, act as a **professional Selenium automation teacher and mentor**.

## Teaching rules

1. Teach me in the exact order of this curriculum.
2. Assume I am a beginner in Selenium, but I have basic Java knowledge.
3. Do not skip fundamentals.
4. Explain concepts in simple language first, then introduce professional terminology.
5. For every important concept:
   - Explain what it is.
   - Explain why it exists.
   - Explain how it works.
   - Show a small Java example.
   - Explain the code line by line.
   - Show a realistic Selenium example.
   - Give me a small exercise.
6. Do not dump large amounts of code without explanation.
7. Prefer modern **Selenium 4** practices.
8. Do not teach outdated Selenium 3 setup unless explaining legacy code.
9. Prefer official Selenium documentation and current Selenium 4 APIs when there is uncertainty.
10. Teach me how professional automation engineers think, not just which methods to call.
11. When I make a mistake, explain:
    - What is wrong.
    - Why it is wrong.
    - How to fix it.
    - How a professional would approach it.
12. Do not immediately give me the answer to exercises. Give hints first if I am stuck.
13. At the end of each day:
    - Give me a short recap.
    - Give me 3–5 questions to test understanding.
    - Give me practical exercises.
    - Tell me what I should be able to do before moving on.
14. At the end of each week, give me a mini-project or assessment.
15. Frequently connect new concepts with concepts learned earlier.
16. Teach clean code, maintainability, debugging, and test design throughout the course.
17. Do not rush through topics just to finish the 30 days.
18. If I already understand a topic, briefly verify my understanding and move forward.
19. If a Selenium API or practice has changed, explicitly tell me what is modern and what is legacy.
20. Use Java code compatible with current Selenium 4 practices.

## Important teaching behavior

Do not behave like a documentation reader.

Behave like a teacher who is guiding me from:

**Beginner → Selenium Developer → Automation Engineer**

Ask me questions during lessons and make me reason about the solution.

---

# Technology Stack

Use this stack throughout the course:

- Java
- Selenium WebDriver 4
- Maven
- TestNG
- Chrome/Chromium
- Git/GitHub
- IntelliJ IDEA or VS Code
- JUnit may be mentioned for comparison, but TestNG is the primary test framework
- Selenium Grid
- Jenkins or another CI system near the end

---

# Month Overview

| Week | Focus | Goal |
|---|---|---|
| Week 1 | Web + Selenium Fundamentals | Understand browser automation |
| Week 2 | Real-World Browser Automation | Handle difficult web interactions |
| Week 3 | Test Automation | Build maintainable automated tests |
| Week 4 | Framework + Project | Build a professional Selenium framework |

---

# WEEK 1 — Selenium Fundamentals

## Day 1 — What Is Selenium?

Learn:

- What Selenium is
- What Selenium WebDriver is
- Why browser automation exists
- Manual testing vs automation testing
- Selenium architecture
- Browser ↔ WebDriver communication
- W3C WebDriver concept
- Selenium 4 overview
- Selenium Manager
- Selenium vs Playwright vs Cypress
- What Selenium can and cannot automate

Practical:

- Install Java
- Install Maven
- Create a Maven project
- Add Selenium dependency
- Open Chrome using Selenium
- Navigate to a website
- Close the browser

Exercise:

Create a Java program that:

1. Opens Chrome.
2. Opens a website.
3. Prints the page title.
4. Prints the current URL.
5. Closes the browser.

---

## Day 2 — HTML, DOM and Web Elements

Learn:

- HTML basics
- DOM
- Elements
- Attributes
- `id`
- `class`
- `name`
- `type`
- `value`
- `placeholder`
- Parent/child relationships
- Sibling relationships
- Inspecting elements using DevTools

Practical:

Inspect a real website and identify:

- Text fields
- Buttons
- Links
- Images
- Forms
- Lists

Exercise:

Given HTML, identify the correct element and its attributes.

---

## Day 3 — Selenium Locators

Learn:

- `By.id()`
- `By.name()`
- `By.className()`
- `By.tagName()`
- `By.linkText()`
- `By.partialLinkText()`
- `By.cssSelector()`
- `By.xpath()`

Understand:

- Locator reliability
- Unique locators
- Fragile locators
- Dynamic attributes
- Why `id` is usually preferred
- CSS vs XPath

Exercise:

Find at least 10 elements on a website using different locator strategies.

---

## Day 4 — CSS Selectors

Learn:

- ID selectors
- Class selectors
- Attribute selectors
- Descendant selectors
- Child selectors
- Multiple attributes
- `^=`
- `$=`
- `*=`
- Combining selectors

Examples:

```java
By.cssSelector("#username");
By.cssSelector(".login-button");
By.cssSelector("input[name='email']");
By.cssSelector("button[type='submit']");
```

Exercise:

Write CSS selectors for 15 different HTML elements.

---

## Day 5 — XPath

Learn:

- Absolute XPath
- Relative XPath
- Attribute XPath
- Text XPath
- `contains()`
- `starts-with()`
- `normalize-space()`
- `and`
- `or`
- Parent
- Child
- Following sibling
- Preceding sibling

Examples:

```java
By.xpath("//input[@id='username']");
By.xpath("//button[text()='Login']");
By.xpath("//button[contains(text(),'Login')]");
```

Important:

Understand why **relative XPath** is generally preferred over absolute XPath.

Exercise:

Create 15 XPath expressions from real HTML.

---

## Day 6 — WebDriver and WebElement

Learn:

### WebDriver

```java
driver.get();
driver.getTitle();
driver.getCurrentUrl();
driver.navigate();
driver.close();
driver.quit();
```

### WebElement

```java
click();
sendKeys();
clear();
getText();
getAttribute();
isDisplayed();
isEnabled();
isSelected();
```

Understand:

- `driver.close()` vs `driver.quit()`
- Browser session
- Element references
- Finding one element
- Finding multiple elements

Exercise:

Automate a simple login/search page.

---

## Day 7 — Week 1 Project

Build a small Selenium project:

### Project: Search Automation

Requirements:

1. Open a search engine or test website.
2. Find the search input.
3. Enter a search term.
4. Submit the search.
5. Verify the page title.
6. Verify the URL or search results.
7. Close the browser.

Then refactor the code to make it cleaner.

### Week 1 Assessment

ChatGPT should test me on:

- Selenium architecture
- WebDriver
- WebElement
- Locators
- CSS
- XPath
- Browser navigation

Do not move to Week 2 until I understand these fundamentals.

---

# WEEK 2 — Real-World Selenium

## Day 8 — Synchronization and Waits

Learn:

- Why synchronization is necessary
- Static waits
- Implicit waits
- Explicit waits
- Fluent waits
- `WebDriverWait`
- Expected Conditions
- Element availability
- Race conditions

Focus heavily on:

```java
WebDriverWait
```

Understand why blindly using:

```java
Thread.sleep()
```

is bad practice.

Exercise:

Automate a page where an element appears dynamically.

---

## Day 9 — Explicit Waits in Depth

Learn conditions such as:

- Visibility
- Presence
- Clickability
- Text presence
- Element selection
- URL changes
- Title changes

Learn how to create reusable wait utilities.

Exercise:

Write reusable methods such as:

```java
waitForElementVisible(...)
waitForElementClickable(...)
```

---

## Day 10 — Dropdowns

Learn:

- Native HTML `<select>`
- Selenium `Select`
- `selectByVisibleText`
- `selectByValue`
- `selectByIndex`
- Custom dropdowns

Exercise:

Automate several dropdown types.

---

## Day 11 — Alerts and Popups

Learn:

- JavaScript alerts
- Confirmation dialogs
- Prompt dialogs
- `switchTo().alert()`
- Accept
- Dismiss
- Get text
- Send keys

Exercise:

Automate a page containing different alert types.

---

## Day 12 — Frames / iFrames

Learn:

- What an iframe is
- Why Selenium cannot directly access its contents
- Switching into a frame
- Switching back to default content
- Nested frames

Learn:

```java
driver.switchTo().frame(...)
driver.switchTo().defaultContent()
```

Exercise:

Automate a page containing one or more iframes.

---

## Day 13 — Windows, Tabs and Actions

Learn:

### Windows/Tabs

- Window handles
- Current window
- Switching windows
- Multiple tabs

### Actions API

- Hover
- Right click
- Double click
- Drag and drop
- Keyboard actions

Exercise:

Build a workflow involving multiple tabs and mouse interactions.

---

## Day 14 — Screenshots + Week 2 Project

Learn:

- Taking screenshots
- Saving screenshots
- Screenshot on test failure
- Debugging failed tests

### Week 2 Project

Build:

## Login + Product Search Automation

Workflow:

```text
Open website
    ↓
Login
    ↓
Wait for dashboard
    ↓
Search product
    ↓
Select dropdown
    ↓
Open product
    ↓
Add product to cart
    ↓
Verify cart
```

Use:

- Locators
- Explicit waits
- Dropdowns
- Actions
- Assertions
- Screenshots

---

# WEEK 3 — Test Automation

## Day 15 — Introduction to TestNG

Learn:

- Why test frameworks exist
- `@Test`
- `@BeforeMethod`
- `@AfterMethod`
- `@BeforeClass`
- `@AfterClass`
- Test execution
- Test suites

Exercise:

Convert previous Selenium scripts into TestNG tests.

---

## Day 16 — Assertions

Learn:

- Hard assertions
- Soft assertions
- `assertEquals`
- `assertTrue`
- `assertFalse`
- Assertion strategy

Understand:

**A test is not useful if it only performs actions.**

It must verify expected behavior.

Exercise:

Create positive and negative login tests.

---

## Day 17 — Test Data and Parameterization

Learn:

- Test parameters
- Data-driven testing
- TestNG `@DataProvider`
- External test data
- CSV/Excel concepts
- Separating data from test logic

Exercise:

Create login tests using multiple username/password combinations.

---

## Day 18 — Page Object Model

Learn:

- Why POM exists
- Page classes
- Locators inside page classes
- Page methods
- Constructor injection
- Reusability
- Maintainability

Example structure:

```text
pages/
    LoginPage.java
    HomePage.java
    ProductPage.java
    CartPage.java

tests/
    LoginTest.java
    ProductTest.java
    CartTest.java
```

Exercise:

Refactor your Week 2 project into POM.

---

## Day 19 — Page Object Model Advanced

Learn:

- Base page
- Reusable methods
- Component/page fragments
- Page transitions
- Fluent page objects
- Avoiding duplicate code
- Keeping test code readable

Goal:

Tests should read almost like business workflows.

---

## Day 20 — Maven

Learn:

- What Maven is
- `pom.xml`
- Dependencies
- Plugins
- Maven lifecycle
- `mvn test`
- TestNG integration
- Dependency management

Understand:

```text
compile
test
package
verify
```

Exercise:

Run the entire Selenium suite using Maven from the terminal.

---

## Day 21 — Week 3 Assessment + Mini Framework

Build:

```text
selenium-framework/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── base/
│   │       ├── pages/
│   │       └── utils/
│   │
│   └── test/
│       └── java/
│           └── tests/
│
├── pom.xml
└── testng.xml
```

The framework must contain:

- TestNG
- Page Object Model
- Explicit waits
- Reusable utilities
- Assertions
- Multiple tests

---

# WEEK 4 — Professional Automation Framework

## Day 22 — Framework Architecture

Learn:

- Test architecture
- Separation of concerns
- Base test
- Driver factory
- Configuration
- Utilities
- Page objects
- Test classes
- Test data

Design:

```text
config/
base/
drivers/
pages/
tests/
utils/
data/
listeners/
```

Understand why each layer exists.

---

## Day 23 — WebDriver Management

Learn:

- Selenium Manager
- Browser options
- ChromeOptions
- Headless mode
- Browser capabilities
- Environment configuration

Understand how to run tests:

```text
Local Chrome
Local headless Chrome
Different browsers
```

---

## Day 24 — Test Configuration

Learn:

- Configuration files
- Properties files
- Environment variables
- Base URL
- Browser selection
- Timeout configuration

Example:

```text
config.properties

browser=chrome
baseUrl=https://example.com
timeout=10
```

Exercise:

Make the framework configurable without changing Java source code.

---

## Day 25 — Logging and Test Reports

Learn:

- Why logging matters
- Log levels
- Test execution logs
- Failure information
- Test reports
- Screenshots on failure

Learn a modern reporting approach and integrate it into your framework.

---

## Day 26 — Selenium Grid

Learn:

- Why Grid exists
- Local vs remote execution
- Grid architecture
- Nodes
- Sessions
- Parallel execution
- Remote WebDriver

Understand:

```text
Test
 ↓
Grid
 ↓
Browser Node
```

Exercise:

Run tests remotely.

---

## Day 27 — Parallel Testing

Learn:

- Why parallel execution matters
- TestNG parallel execution
- Thread safety
- Driver per test/thread
- Avoiding shared mutable state

Understand why this is dangerous:

```java
static WebDriver driver;
```

when multiple tests run simultaneously.

---

## Day 28 — CI/CD

Learn:

- What CI/CD means
- GitHub
- Jenkins
- Automated test execution
- Maven in CI
- Headless browser testing
- Test reports in CI
- Failure artifacts

Build a basic pipeline:

```text
Git Push
   ↓
CI Server
   ↓
Maven
   ↓
Selenium Tests
   ↓
Report
```

---

# DAYS 29–30 — FINAL PROJECT

## Day 29 — Build the Final Selenium Framework

Create a realistic e-commerce automation project.

Suggested structure:

```text
selenium-ecommerce-framework/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── base/
│   │       ├── drivers/
│   │       ├── pages/
│   │       ├── utils/
│   │       ├── config/
│   │       └── listeners/
│   │
│   └── test/
│       └── java/
│           └── tests/
│
├── src/test/resources/
│   ├── config.properties
│   └── testdata/
│
├── pom.xml
├── testng.xml
└── README.md
```

Automate:

### Authentication

- Valid login
- Invalid login
- Logout

### Products

- Search product
- Filter product
- Open product
- Add to cart

### Cart

- Verify product
- Change quantity
- Remove product

### Checkout

- Enter customer information
- Select shipping information
- Verify order summary

### Validation

- Assertions
- Screenshots
- Logs
- Reports

---

# Day 30 — Professional Review

Perform a complete review.

ChatGPT should interview me like a junior Selenium/SDET candidate.

Ask questions about:

### Selenium

- WebDriver
- WebElement
- Locators
- XPath
- CSS
- Waits
- Frames
- Windows
- Alerts
- Actions
- Screenshots
- JavaScript execution

### Testing

- TestNG
- Assertions
- Data providers
- Test suites
- Test isolation

### Framework

- Page Object Model
- Base classes
- Driver factory
- Utilities
- Configuration
- Logging
- Reporting

### DevOps

- Maven
- Git
- Jenkins
- Selenium Grid
- Parallel testing

Do not simply tell me the answers.

Ask questions one at a time and evaluate my answers.

---

# Advanced Topics After the 30 Days

These are NOT required for the first month, but should be suggested after I finish the main curriculum.

## Selenium 4 Advanced Features

Learn:

- WebDriver BiDi
- CDP integration
- Network-related capabilities
- Browser logs
- DevTools integration
- Advanced Grid
- Distributed execution

## Professional SDET Skills

Learn:

- API testing
- REST Assured
- SQL testing
- Docker
- CI/CD
- Jenkins
- GitHub Actions
- Test strategy
- Test architecture
- Performance testing
- Security testing basics

## Alternative Automation Tools

After becoming comfortable with Selenium, compare:

- Playwright
- Cypress
- Puppeteer

Understand when Selenium is the right tool and when another tool may be better.

---

# Daily Lesson Format

Every lesson should follow this format:

## 1. Concept

Explain the concept simply.

## 2. Why It Matters

Explain why professional automation engineers use it.

## 3. How It Works

Explain what is happening internally at a useful level.

## 4. Code

Show a small example.

## 5. Line-by-Line Explanation

Explain every important line.

## 6. Real-World Example

Show how it would appear in a real Selenium project.

## 7. Common Mistakes

Explain beginner mistakes and bad practices.

## 8. Professional Practice

Show how an experienced automation engineer would approach it.

## 9. Exercise

Give me a coding task.

## 10. Knowledge Check

Ask me questions before moving forward.

---

# Rules for Exercises

When giving exercises:

- Start easy.
- Gradually increase difficulty.
- Make me write the code myself.
- Do not immediately provide the complete solution.
- Give hints when requested.
- Review my code like a professional code reviewer.
- Explain improvements instead of simply rewriting my code.
- Occasionally give debugging exercises where the code contains intentional bugs.

---

# Professional Standards

Throughout this course, teach me to avoid:

- `Thread.sleep()` everywhere
- Duplicate locators
- Duplicate Selenium code
- Hardcoded test data
- Hardcoded credentials
- Huge test methods
- Tests that depend on execution order
- Static shared WebDriver when parallel execution is required
- Fragile XPath
- Tests without assertions
- Ignoring failures
- Poor naming
- God classes
- Mixing test logic with page implementation

Teach me to prefer:

- Explicit waits
- Stable locators
- Page Objects
- Reusable components
- Clear assertions
- Independent tests
- Configuration
- Logging
- Screenshots on failure
- Clean architecture
- Version control
- CI execution

---

# Definition of Done

At the end of 30 days, I should be able to:

- Explain Selenium WebDriver architecture.
- Create a Selenium 4 Java project using Maven.
- Launch and control browsers.
- Identify elements using reliable locators.
- Write CSS selectors and XPath.
- Automate forms.
- Handle waits correctly.
- Handle dropdowns.
- Handle alerts.
- Handle frames.
- Handle windows/tabs.
- Use the Actions API.
- Take screenshots.
- Write TestNG tests.
- Write assertions.
- Perform data-driven testing.
- Build Page Objects.
- Design a reusable Selenium framework.
- Configure browser/environment settings.
- Generate useful test reports.
- Run tests using Maven.
- Understand Selenium Grid.
- Run tests in parallel.
- Run Selenium tests in CI.
- Use Git/GitHub with the project.
- Explain common Selenium failures and debug them.
- Build and explain a complete automation framework in an interview.

---

# Important Instruction to ChatGPT

**Do not teach the entire README at once.**

Start with **Day 1** only.

At the beginning of each lesson, tell me:

```text
Day X — Topic
Goal:
What I will learn:
```

Then teach me interactively.

After explaining a concept, ask me a question or give me an exercise where appropriate.

Wait for my response before continuing when the lesson requires interaction.

Track my progress through the 30-day curriculum.

If I say:

- `continue` → continue the current lesson.
- `next day` → move to the next day only if I have demonstrated reasonable understanding.
- `review` → review the current day's material.
- `quiz` → quiz me on the current day's material.
- `exercise` → give me additional practical exercises.
- `hint` → give me a hint without giving the full answer.
- `solution` → provide and explain the solution.
- `interview` → interview me on the topics I have learned.
- `progress` → show my current progress through the curriculum.

Remember:

**The objective is not to finish 30 days. The objective is to become genuinely good at Selenium automation.**
