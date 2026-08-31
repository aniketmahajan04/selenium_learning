# Selenium Learning Progress

## Current Status

- Current Day: Day 6
- Current Topic: WebDriver and WebElement
- Status: Completed

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
- Launched Chrome with Selenium 4
- Basic Selenium Manager awareness
- `driver.get()` for browser navigation
- `driver.getTitle()` for retrieving the page title
- `driver.getCurrentUrl()` for retrieving the current URL
- `driver.close()` vs `driver.quit()`
- Basic Selenium/WebDriver architecture
- Browser ↔ WebDriver communication concept
- W3C WebDriver standard concept
- Selenium 4 overview
- Selenium vs Playwright/Cypress at a high level
- What Selenium can and cannot automate
- First Selenium practical exercise
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
- Identifying text fields, buttons, links, and forms
- Reasoning about parent, child, and sibling relationships

### Day 3 — Selenium Locators

- What Selenium locators are
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
- Unique vs broad locators
- Locator reliability
- Fragile locators
- Dynamic attributes
- Why `id` is usually preferred when unique and stable
- Choosing simple locators over unnecessarily complicated locators
- CSS vs XPath reasoning
- Practical locator exercises using the Selenium Web Form

### Day 4 — CSS Selectors

- CSS selector fundamentals
- ID selectors using `#`
- Class selectors using `.`
- Attribute selectors
- Attribute presence selectors
- Exact attribute-value matching
- Multiple attribute selectors
- Descendant selectors using a space
- Child selectors using `>`
- Difference between descendants and direct children
- Combining tag, class, and attribute selectors
- `^=` starts-with attribute matching
- `$=` ends-with attribute matching
- `*=` contains attribute matching
- Choosing simple selectors when a reliable ID exists
- Using CSS selectors with Selenium's `By.cssSelector()`
- Practical CSS selector construction using the Selenium Web Form

### Day 5 — XPath

- Absolute XPath
- Relative XPath
- Why relative XPath is generally preferred over absolute XPath
- Attribute XPath
- Text XPath
- XPath `contains()`
- XPath `starts-with()`
- XPath `normalize-space()`
- XPath `and`
- XPath `or`
- XPath `parent::`
- XPath `child::`
- XPath `following-sibling::`
- XPath `preceding-sibling::`
- XPath navigation through DOM relationships
- Using XPath with Selenium's `By.xpath()`
- Constructing XPath expressions from real HTML
- Exact vs partial text matching
- Handling dynamic attributes with XPath functions
- Practical XPath construction using the Selenium Web Form

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
- Difference between closing a window and ending the WebDriver session
- Difference between `get()` and `navigate().to()`

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
- Finding an element and interacting with the resulting `WebElement`
- Difference between element text and input `value`
- Checking element state before interaction

## What I Understand

- `WebDriver` controls the browser and browser session.
- `WebElement` represents an element found on the page and provides methods for interacting with and inspecting it.
- `driver.findElement()` locates an element and returns a `WebElement`.
- `driver.findElements()` returns multiple matching elements.
- `driver.get()` navigates the browser to a URL.
- `driver.navigate()` provides navigation operations such as `to()`, `back()`, `forward()`, and `refresh()`.
- `driver.close()` closes the current browser window.
- `driver.quit()` ends the WebDriver session and closes its associated windows.
- `click()` performs a click on an element.
- `sendKeys()` sends keyboard input to an element.
- `clear()` removes existing text from an editable input/textarea.
- `getText()` retrieves visible text from an element.
- `getAttribute()` retrieves the value of a specified attribute.
- For an input's entered value, `getAttribute("value")` is appropriate.
- `isDisplayed()` checks whether an element is displayed.
- `isEnabled()` checks whether an element is enabled.
- `isSelected()` checks whether a selectable element such as a checkbox or radio button is selected.
- A `click()` is not necessarily required before `sendKeys()`; Selenium can generally send keys directly to an appropriate input element.
- An element can be located first and then interacted with through its `WebElement` reference.
- Browser navigation and element interaction are separate responsibilities of WebDriver and WebElement.

## Professional Practices Learned

- Use reliable and stable locators rather than unnecessarily complicated locators.
- Don't automatically assume CSS is better than XPath or vice versa; choose based on stability, uniqueness, readability, and simplicity.
- Don't add unnecessary `click()` calls before every `sendKeys()`.
- Use `getAttribute("value")` for input values instead of relying on `getText()`.
- Check element state when appropriate before interacting with it.
- Use `try/finally` to ensure `driver.quit()` executes even when an exception occurs.
- Keep browser cleanup in a reliable location so WebDriver sessions are not left running.

## Exercises Completed

### Day 1

- Created a Maven Selenium project using Java 21.
- Added Selenium as a Maven dependency.
- Launched Chrome using `ChromeDriver`.
- Navigated to a website.
- Printed the page title.
- Printed the current URL.
- Quit the browser.
- Added basic title verification using Java `if/else`.

### Day 2

- Inspected HTML elements using Chrome DevTools.
- Identified element attributes.
- Identified parent, child, and sibling relationships.
- Inspected the Selenium Web Form.
- Identified text fields, buttons, links, and forms.

### Day 3

- Practiced all major Selenium locator strategies.
- Practiced `findElement()` and `findElements()`.
- Practiced CSS selectors and XPath.
- Practiced locator reliability and fragile locator reasoning.
- Completed the locator practical exercise using the Selenium Web Form.

### Day 4

- Practiced ID CSS selectors.
- Practiced class CSS selectors.
- Practiced attribute selectors.
- Practiced multiple attributes.
- Practiced descendant and child selectors.
- Practiced `^=`, `$=`, and `*=`.
- Practiced combining selectors.
- Built and tested CSS selectors against the Selenium Web Form.

### Day 5

- Practiced absolute and relative XPath.
- Practiced attribute and text XPath.
- Practiced `contains()`.
- Practiced `starts-with()`.
- Practiced `normalize-space()`.
- Practiced `and` and `or`.
- Practiced parent, child, following-sibling, and preceding-sibling axes.
- Built and tested XPath expressions against the Selenium Web Form.

### Day 6

- Practiced browser navigation using `get()` and `navigate()`.
- Practiced `back()`, `forward()`, and `refresh()`.
- Practiced `click()`.
- Submitted the Selenium Web Form using Selenium.
- Retrieved the resulting URL and page information.
- Practiced `sendKeys()`.
- Practiced `clear()`.
- Retrieved input values using `getAttribute("value")`.
- Practiced `getText()` vs `getAttribute("value")`.
- Practiced `isDisplayed()`.
- Practiced `isEnabled()`.
- Practiced `isSelected()` with a radio button.
- Built a complete WebDriver/WebElement interaction workflow.
- Used `try/finally` with `driver.quit()` for browser cleanup.
- Passed the Day 6 knowledge check.

## Mistakes I Made

- Initially thought `WebDriver` was an abstract class; corrected to understand that it is a Java interface.
- Initially described `driver` as an instance variable; corrected to understand that it is a reference variable.
- Initially thought `driver.get()` was needed before Chrome could open; corrected to understand that `new ChromeDriver()` starts the browser session and `get()` performs navigation.
- Needed clarification that the Java `WebDriver` interface and the W3C WebDriver protocol are related but distinct concepts.
- Initially described Selenium Manager as a command-line tool; corrected to understand its role in browser-driver management.
- Initially considered a dynamic ID acceptable until understanding that changing IDs make locators fragile.
- Initially ranked XPath as stronger than CSS mainly because XPath can be made more specific; corrected to understand that locator quality depends on stability, uniqueness, readability, and simplicity.
- Initially used complete link text with `partialLinkText()`, then understood the purpose of partial matching.
- Initially wrote an XPath `and` condition without the `@` before the attribute name; corrected it.
- Initially placed an XPath `or` condition incorrectly inside the `text()` expression; corrected it.
- Initially wrote incorrect CSS selector syntax for an ending attribute match and corrected it.
- Initially used `lable` instead of `label`; identified this as a spelling error.
- Initially wrote `start-with()` instead of `starts-with()`.
- Initially wrote `normalize-space()` with an incorrect extra argument.
- Learned that XPath is not inherently slow; the browser closing quickly was caused by `driver.quit()` being reached quickly.
- Initially thought `click()` was needed before `sendKeys()` to give an input focus; learned that Selenium can generally send keys directly to the element.
- Initially omitted printing the second input value in the Day 6 practical exercise and corrected it.
- Initially omitted the `isEnabled()` check in the Day 6 practical exercise and corrected it.

## Current Project

- Maven project: `selenium_project_setup`
- Java version: 21
- Maven version: 3.9.16
- Selenium: 4.35.0
- IDE: IntelliJ IDEA
- Browser: Chrome/Chromium
- Main practice class: `com.sendo.Main`
- Main practice website: Selenium Web Form

## Current Skill Level

### Strong Foundations

- Selenium architecture basics
- WebDriver fundamentals
- WebElement fundamentals
- HTML/DOM basics
- Selenium locator strategies
- CSS selectors
- XPath
- Basic browser navigation
- Basic element interaction
- Basic element state inspection

### Still To Learn

- Synchronization and waits
- Implicit vs explicit waits
- `WebDriverWait`
- Expected Conditions
- Dropdowns
- Alerts
- Frames/iFrames
- Windows and tabs
- Actions API
- Screenshots
- TestNG
- Assertions
- Data-driven testing
- Page Object Model
- Maven test execution
- Framework architecture
- Configuration
- Logging and reporting
- Selenium Grid
- Parallel testing
- CI/CD
- Final Selenium automation framework

## Next Lesson

Day 7 — Week 1 Project: Search Automation

### Day 7 Project Goals

1. Open a search engine or test website.
2. Find the search input.
3. Enter a search term.
4. Submit the search.
5. Verify the page title.
6. Verify the URL or search results.
7. Close the browser.
8. Refactor the code to make it cleaner.

## Last Updated

Day 6 completed.
