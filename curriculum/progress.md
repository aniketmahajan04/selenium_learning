# Selenium Learning Progress

## Current Status

- Current Day: Day 4
- Current Topic: CSS Selectors
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
- Inspecting HTML with Chrome DevTools
- Inspecting a real Google search field
- Inspecting a real Selenium Web Form page
- Identifying a button's tag, class, and type attributes
- Identifying a text field's element, attributes, and parent
- Reasoning about element relationships from HTML

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
- CSS selectors using IDs
- CSS selectors using classes
- CSS attribute selectors
- CSS selectors with multiple attributes
- XPath using element/tag names
- XPath using attributes
- XPath using visible text
- XPath `and` operator
- XPath `or` operator
- Basic CSS vs XPath reasoning

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
- Understanding that CSS selectors identify matching elements while `findElement()` returns the first matching element
- Practical CSS selector construction using the Selenium Web Form page

## What I Understand

- Selenium locators are strategies used to identify web elements in the DOM.
- `driver.findElement()` returns one matching `WebElement`.
- `driver.findElements()` returns a list of matching `WebElement` objects.
- `By.id()` is generally preferred when the ID is unique and stable.
- A locator being valid does not automatically make it a good locator.
- A good locator should be sufficiently unique, stable, readable, and simple.
- `By.tagName()` can be too broad when many elements share the same tag.
- `By.className()` accepts one class name even when an element has multiple CSS classes.
- CSS selectors can combine multiple conditions on the same element.
- `By.linkText()` uses exact visible link text.
- `By.partialLinkText()` can match part of a link's visible text.
- XPath can locate elements using attributes and visible text.
- XPath conditions can be combined using `and` and `or`.
- Dynamic IDs can make locators fragile.
- CSS and XPath can both locate the same element; the choice should depend on reliability, stability, readability, and simplicity.
- A simple reliable locator is preferable to an unnecessarily complicated locator.
- `#` represents an ID selector in CSS.
- `.` represents a class selector in CSS.
- A CSS space represents a descendant relationship.
- `>` represents a direct-child relationship.
- Multiple CSS attribute conditions without a space apply to the same element.
- `^=` means an attribute value starts with a specified value.
- `$=` means an attribute value ends with a specified value.
- `*=` means an attribute value contains a specified value.
- CSS selectors can combine tags, classes, attributes, and relationships.
- A CSS selector itself can match multiple elements; `findElement()` returns the first matching element.
- A more complicated locator is not automatically a better locator.

## Weak Areas

- Advanced CSS selector syntax has not yet been covered beyond the Day 4 curriculum.
- Advanced XPath functions and relationships have not yet been covered.
- Locator strategies have been practiced, but large-scale locator design and maintainability will need reinforcement through later exercises.
- Formal test assertions have not been learned yet and will be covered later with TestNG.
- Day 4 practical exercise was completed under a time constraint, so some selectors were demonstrated in a shortened form rather than producing 15 fully documented examples.

## Exercises Completed

### Day 1

- Created a Maven Selenium project using Java 21.
- Added Selenium as a Maven dependency.
- Launched Chrome with `ChromeDriver`.
- Navigated to a website.
- Printed the page title.
- Printed the current URL.
- Quit the browser.
- Added a basic Java title verification using `if/else`.

### Day 2

- Inspected HTML elements using Chrome DevTools.
- Identified attributes from real web elements.
- Identified parent, child, and sibling relationships.
- Inspected elements on the Selenium Web Form page.
- Identified text fields, buttons, and links.

### Day 3

- Located elements using `By.id()`.
- Located elements using `By.name()`.
- Located elements using `By.className()`.
- Located elements using `By.tagName()`.
- Located links using `By.linkText()`.
- Located links using `By.partialLinkText()`.
- Located elements using `By.cssSelector()`.
- Located elements using `By.xpath()`.
- Practiced `findElement()` and `findElements()`.
- Practiced CSS selectors with multiple attributes.
- Practiced XPath attribute conditions.
- Practiced XPath text conditions.
- Practiced XPath `and` and `or` conditions.
- Completed the 10+ locator practical exercise using the Selenium Web Form page.

### Day 4

- Practiced ID CSS selectors.
- Practiced class CSS selectors.
- Practiced attribute selectors.
- Practiced multiple attribute selectors.
- Practiced descendant selectors.
- Practiced child selectors.
- Practiced combined CSS selectors.
- Practiced `^=` starts-with selectors.
- Practiced `$=` ends-with selectors.
- Practiced `*=` contains selectors.
- Built selectors using the actual Selenium Web Form page.
- Verified CSS locator behavior with Selenium.

## Mistakes I Made

- Initially thought `WebDriver` was an abstract class; corrected to understand that it is a Java interface.
- Initially described `driver` as an instance variable; corrected to understand that it is a reference variable.
- Initially thought `driver.get()` was needed before Chrome could open; corrected to understand that `new ChromeDriver()` starts the browser session and `get()` performs navigation.
- Needed clarification that `WebDriver` (Java interface) and the W3C WebDriver standard/protocol are related but distinct concepts.
- Initially described Selenium Manager as a command-line tool; corrected to understand its role in browser-driver management.
- Initially considered a dynamic ID acceptable until understanding that changing IDs make locators fragile.
- Initially ranked XPath as stronger than CSS mainly because XPath can be made more specific; corrected to understand that locator quality depends on stability, uniqueness, readability, and simplicity rather than complexity.
- Initially used complete link text with `partialLinkText()`, then understood that partial link text should demonstrate a partial match.
- Initially wrote an XPath `and` condition without the `@` before the attribute name; corrected to `@type='submit'`.
- Initially placed an XPath `or` condition inside the `text()` string; corrected to separate XPath conditions.
- Initially wrote an incorrect CSS selector syntax for an attribute ending match and corrected it to `[name$='email']`.
- Initially used `lable` instead of `label` in one CSS selector exercise; this was a spelling mistake rather than a misunderstanding of descendant selectors.

## Current Project

- Maven project: `selenium_project_setup`
- Java version: 21
- Maven version: 3.9.16
- Selenium: 4.35.0
- IDE: IntelliJ IDEA
- Browser: Chrome/Chromium
- First Selenium class: `com.sendo.Main`
- Main practice website: Selenium Web Form

## Next Lesson

Day 5 — XPath

## Last Updated

Day 4 completed.
