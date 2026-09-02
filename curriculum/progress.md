# Selenium Learning Progress

## Current Status

- Current Day: Day 7
- Current Topic: Project
- Status: Completed
- Week 1 Status: Completed

---

## Completed

### Day 1 — Selenium Fundamentals

- What Selenium is and why browser automation exists
- Selenium WebDriver and its role in browser automation
- `WebDriver` as a Java interface
- `ChromeDriver` as an implementation of `WebDriver`
- Basic interface/polymorphism reasoning with `WebDriver driver = new ChromeDriver()`
- Manual testing vs automation testing
- Maven project setup
- Maven `pom.xml` structure and project coordinates
- Maven dependencies and dependency resolution
- Added Selenium Java dependency
- Launched Chrome using Selenium 4
- Selenium Manager awareness
- `driver.get()`
- `driver.getTitle()`
- `driver.getCurrentUrl()`
- `driver.close()` vs `driver.quit()`
- Basic Selenium/WebDriver architecture
- Browser ↔ WebDriver communication concept
- W3C WebDriver concept
- Selenium 4 overview
- Selenium vs Playwright vs Cypress at a high level
- What Selenium can and cannot automate
- Basic title verification using Java `if/else`

### Day 2 — HTML, DOM and Web Elements

- HTML basics
- HTML elements/tags
- HTML attributes
- `id`
- `class`
- `name`
- `type`
- `value`
- `placeholder`
- DOM concept and tree structure
- Parent/child relationships
- Sibling relationships
- Inspecting elements using Chrome DevTools
- Inspecting real elements on the Selenium Web Form
- Identifying text fields
- Identifying buttons
- Identifying links
- Identifying forms
- Reasoning about DOM relationships

### Day 3 — Selenium Locators

- `By.id()`
- `By.name()`
- `By.className()`
- `By.tagName()`
- `By.linkText()`
- `By.partialLinkText()`
- `By.cssSelector()`
- `By.xpath()`
- `driver.findElement()`
- `driver.findElements()`
- Unique locators
- Broad locators
- Locator reliability
- Fragile locators
- Dynamic attributes
- Why stable IDs are generally preferred
- Choosing simple locators
- CSS vs XPath reasoning
- Practical locator exercises

### Day 4 — CSS Selectors

- ID selectors using `#`
- Class selectors using `.`
- Attribute selectors
- Exact attribute matching
- Multiple attribute selectors
- Descendant selectors
- Child selectors
- Difference between descendants and direct children
- Combining tag, class, and attribute selectors
- `^=` starts-with matching
- `$=` ends-with matching
- `*=` contains matching
- Practical CSS selector construction

### Day 5 — XPath

- Absolute XPath
- Relative XPath
- Attribute XPath
- Text XPath
- `contains()`
- `starts-with()`
- `normalize-space()`
- `and`
- `or`
- `parent::`
- `child::`
- `following-sibling::`
- `preceding-sibling::`
- XPath DOM navigation
- Exact vs partial text matching
- Dynamic attribute handling
- Practical XPath construction

### Day 6 — WebDriver and WebElement

#### WebDriver

- `driver.get()`
- `driver.getTitle()`
- `driver.getCurrentUrl()`
- `driver.navigate().to()`
- `driver.navigate().back()`
- `driver.navigate().forward()`
- `driver.navigate().refresh()`
- `driver.close()`
- `driver.quit()`
- Browser session concept
- `close()` vs `quit()`
- `get()` vs `navigate().to()`

#### WebElement

- `click()`
- `sendKeys()`
- `clear()`
- `getText()`
- `getAttribute()`
- `isDisplayed()`
- `isEnabled()`
- `isSelected()`
- Element references
- Finding and interacting with elements
- Input `value` vs visible text
- Element state inspection

### Day 7 — Week 1 Search Automation Project

- Designed a search automation workflow
- Selected a search website
- Inspected a real search field
- Identified that the DuckDuckGo search field is a `textarea`
- Located the search field using XPath and its placeholder
- Used `sendKeys()` to enter a search term
- Used `Keys.ENTER` to submit the search
- Retrieved the resulting page title
- Retrieved the resulting URL
- Verified the title using `contains()`
- Verified the search query in the URL using `contains()`
- Combined multiple verification conditions using Java `&&`
- Used `try/finally` for WebDriver cleanup
- Used `driver.quit()` to close the browser session
- Completed the Week 1 Search Automation project
- Completed the Week 1 assessment

---

## Day 7 Project

### Project: Search Automation

### Workflow

```text
Open search website
        ↓
Locate search box
        ↓
Enter search term
        ↓
Press ENTER
        ↓
Search is submitted
        ↓
Get title + URL
        ↓
Verify expected result
        ↓
Quit browser
```

### Search Used

```text
Selenium WebDriver
```

### Verification Strategy

Title verification:

```java
title.contains("Selenium WebDriver")
```

URL verification:

```java
currentUrl.contains("q=Selenium+WebDriver")
```

Combined verification:

```java
if (currentUrl.contains("q=Selenium+WebDriver")
        && title.contains("Selenium WebDriver")) {
    System.out.println("Search test successful");
}
```

---

## What I Understand

- Selenium automation should contain both **actions and verification**.
- Successfully executing Selenium commands does not automatically mean a test passed.
- A test should verify observable expected behavior.
- A stable portion of a dynamic URL can be used for verification.
- `contains()` is useful when part of a value is stable and another part is dynamic.
- `equals()` compares Java `String` contents.
- `==` compares Java object references.
- `findElement()` locates an element and returns one `WebElement`.
- `findElements()` returns multiple matching elements.
- A broad locator such as `By.tagName("input")` can select the wrong element when multiple inputs exist.
- A specific locator such as `By.name("username")` is preferable when it uniquely identifies the intended element.
- `WebDriver` controls the browser/session.
- `WebElement` represents a page element and provides interaction/state methods.
- `ChromeDriver` implements the `WebDriver` interface.
- `findElement()` belongs to WebDriver and returns a WebElement.
- `click()` interacts with an element.
- `sendKeys()` sends keyboard input.
- `Keys.ENTER` can be used to submit a search through a focused search field.
- `getText()` retrieves visible element text.
- `getAttribute("value")` retrieves an input's value.
- `isDisplayed()` checks visibility.
- `isEnabled()` checks whether an element is enabled.
- `isSelected()` checks whether a selectable element is selected.
- `driver.get()` navigates to a URL.
- `driver.navigate()` provides additional browser navigation operations.
- `driver.close()` closes the current window.
- `driver.quit()` ends the WebDriver session.
- Stable, specific, readable locators are preferred over unnecessarily complicated locators.

---

## Professional Practices Learned

- Inspect the DOM before choosing a locator.
- Don't automatically choose XPath or CSS based on personal preference.
- Choose locators based on stability, uniqueness, readability, and simplicity.
- Avoid overly broad locators.
- Avoid fragile absolute XPath when a stable relative locator is available.
- Don't add unnecessary `click()` calls before `sendKeys()`.
- Separate **locating**, **interacting**, and **verifying** in your mental model.
- Verify the expected application behavior rather than merely checking that Selenium executed without an exception.
- Store values such as title and URL in variables when it improves readability.
- Use `try/finally` to ensure browser cleanup.
- Don't attempt to bypass anti-automation verification mechanisms.
- When a real website interferes with automation, use an automation-friendly test website when appropriate.

---

## Week 1 Assessment

### Selenium Architecture

**Result: Passed**

Demonstrated understanding of:

- `WebDriver` interface
- `ChromeDriver` implementation
- `WebDriver.findElement()`
- `WebElement` interface
- Relationship between WebDriver and WebElement

### Locators

**Result: Passed**

Demonstrated ability to:

- Choose stable locators
- Avoid overly broad locators
- Prefer a unique stable ID when available
- Use `name` when it uniquely identifies an element
- Reason about CSS vs XPath
- Identify problems with dynamic and structural locators

### XPath

**Result: Passed**

Demonstrated understanding of:

- Relative XPath
- Attribute XPath
- Text XPath
- XPath functions
- XPath logical operators
- XPath axes
- DOM navigation

### CSS

**Result: Passed**

Demonstrated understanding of:

- IDs
- Classes
- Attributes
- Descendants
- Children
- Attribute operators
- Combined selectors

### WebDriver Navigation

**Result: Passed**

Demonstrated understanding of:

- `get()`
- `navigate().to()`
- `back()`
- `forward()`
- `refresh()`
- `close()`
- `quit()`

### WebElement Interaction

**Result: Passed**

Demonstrated understanding of:

- `click()`
- `sendKeys()`
- `clear()`
- `getText()`
- `getAttribute()`
- `isDisplayed()`
- `isEnabled()`
- `isSelected()`

### Test Design

**Result: Passed**

Demonstrated understanding that:

```text
Action ≠ Verification
```

and that a useful automation test should verify expected behavior.

---

## Mistakes and Lessons

- Initially thought `WebDriver` was an abstract class; corrected to understand that it is a Java interface.
- Initially described `driver` as an instance variable; corrected to understand that it is a reference variable.
- Initially thought `driver.get()` was needed before Chrome could open; corrected to understand that `new ChromeDriver()` starts the browser session.
- Initially described Selenium Manager as a command-line tool; corrected its role in driver management.
- Initially considered dynamic IDs acceptable; learned why they create fragile locators.
- Initially ranked XPath as inherently stronger than CSS; learned that locator quality depends on stability, uniqueness, readability, and simplicity.
- Initially used complete link text with `partialLinkText()`; learned the distinction between exact and partial matching.
- Initially wrote incorrect XPath `and`/`or` syntax; corrected it.
- Initially wrote incorrect CSS attribute-selector syntax; corrected it.
- Initially wrote `lable` instead of `label`; identified it as a spelling mistake.
- Initially wrote `start-with()` instead of `starts-with()`.
- Initially used `normalize-space()` incorrectly with multiple arguments.
- Learned that XPath is not inherently slow; browser behavior was affected by when `driver.quit()` executed.
- Initially thought `click()` was required before every `sendKeys()` call; learned that Selenium can generally send keys directly to the appropriate element.
- Initially used Google for the search project and encountered Google's anti-automation verification page.
- Learned to distinguish between Selenium code failure and application/website behavior.
- Initially used a weak verification based only on `isBlank()`; improved it to verify the expected title and query URL.
- Learned that `==` should not be used for Java String content comparison.
- Learned that URL verification should focus on stable expected portions when parameters are dynamic.
- Learned that broad locators can return unintended elements when multiple elements match.
- Initially thought `findElement()` automatically waits for an element.
- Learned that the default implicit wait is zero.
- Initially used `Duration.ofSeconds(500)` when intending a 500 ms polling interval.
- Corrected it to `Duration.ofMillis(500)`.
- Initially checked `isDisplayed()` after `visibilityOfElementLocated()`; learned that this check is redundant.
- Learned to distinguish DOM presence, visibility, and clickability.

---

## Current Project

- Maven project: `selenium_project_setup`
- Java version: 21
- Maven version: 3.9.16
- Selenium: 4.35.0
- IDE: IntelliJ IDEA
- Browser: Chrome/Chromium
- Main practice class: `com.sendo.Main`
- Practice website: Selenium Web Form
- Search project website: DuckDuckGo

---

## Current Skill Level

### Strong Foundations

- Selenium architecture
- WebDriver
- WebElement
- HTML/DOM basics
- Selenium locator strategies
- CSS selectors
- XPath
- Browser navigation
- Element interaction
- Element state inspection
- Basic test verification
- Basic test design

### Week 1 Completed

```text
Day 1  ✅ Selenium Fundamentals
Day 2  ✅ HTML, DOM & Web Elements
Day 3  ✅ Selenium Locators
Day 4  ✅ CSS Selectors
Day 5  ✅ XPath
Day 6  ✅ WebDriver & WebElement
Day 7  ✅ Search Automation Project
```

---

## Still To Learn

### Week 2 — Real-World Selenium

- Synchronization and waits
- Static waits
- Implicit waits
- Explicit waits
- Fluent waits
- `WebDriverWait`
- Expected Conditions
- Race conditions
- Element availability
- Reusable wait utilities
- Dropdowns
- Native HTML `<select>`
- Selenium `Select`
- Custom dropdowns
- Alerts
- Confirmation dialogs
- Prompt dialogs
- Frames/iFrames
- Nested frames
- Windows and tabs
- Window handles
- Actions API
- Hover
- Right click
- Double click
- Drag and drop
- Keyboard actions
- Screenshots
- Screenshots on test failure
- Week 2 Login + Product Search project

### Week 3 — Test Automation

- TestNG
- Test lifecycle annotations
- Assertions
- Data-driven testing
- `@DataProvider`
- External test data
- Page Object Model
- Advanced Page Object Model
- Maven
- Test execution
- Mini framework

### Week 4 — Professional Framework

- Framework architecture
- Driver factory
- Configuration
- Browser options
- Headless execution
- Logging
- Reporting
- Selenium Grid
- Parallel execution
- CI/CD
- Jenkins
- Final Selenium framework

---

## Completed

### Day 8 — Synchronization and Waits

- Why synchronization is necessary in Selenium
- Race conditions
- Static waits
- Thread.sleep() and why blindly using it is a bad practice
- Implicit waits
- Explicit waits
- WebDriverWait
- Expected Conditions
- Element availability
- Fluent waits
- Polling intervals
- Ignoring exceptions with FluentWait
- Difference between presence, visibility, and clickability
- Dynamic elements and asynchronous page behavior

## Next Lesson

### Day 8 — Synchronization and Waits

###

- Why synchronization is necessary
- Static waits
- Implicit waits
- Explicit waits
- Fluent waits
- `WebDriverWait`
- Expected Conditions
- Element availability
- Race conditions
- Why blindly using `Thread.sleep()` is bad practice

The main focus will be:

```java
WebDriverWait
```

---

## Last Updated

Day 7 completed — Week 1 completed.
