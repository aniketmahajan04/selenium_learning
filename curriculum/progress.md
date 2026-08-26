# Selenium Learning Progress

## Current Status

- Current Day: Day 1
- Current Topic: Selenium Fundamentals
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

## What I Understand

- Selenium is primarily used for web browser/application automation.
- WebDriver is a Java interface in Selenium.
- ChromeDriver implements the WebDriver interface.
- `WebDriver driver = new ChromeDriver()` uses an interface reference to refer to a ChromeDriver object.
- `new ChromeDriver()` starts a Chrome WebDriver session.
- `driver.get(url)` navigates the current browser window to a URL.
- `driver.close()` closes the current browser window/tab.
- `driver.quit()` terminates the entire WebDriver session.
- W3C WebDriver provides a standardized approach to browser automation communication.
- Selenium Manager helps manage browser drivers automatically, so manual ChromeDriver setup is not required for the basic setup used in this course.
- Selenium is designed for browser/web application automation, not general operating-system automation.
- Maven manages project dependencies such as Selenium.

## Weak Areas

- W3C WebDriver internals and detailed browser communication are understood conceptually but not yet deeply.
- Selenium Manager was understood at a practical level; its internal behavior has not been studied in depth.
- Formal test assertions have not been learned yet and will be covered later with TestNG.
- Selenium architecture beyond the simplified Day 1 model will be reinforced throughout the course.

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

## Mistakes I Made

- Initially thought `WebDriver` was an abstract class; corrected to understand that it is a Java interface.
- Initially described `driver` as an instance variable; corrected to understand that it is a reference variable.
- Initially thought `driver.get()` was needed before Chrome could open; corrected to understand that `new ChromeDriver()` starts the browser session and `get()` performs navigation.
- Needed clarification that `WebDriver` (Java interface) and the W3C WebDriver standard/protocol are related but distinct concepts.
- Initially described Selenium Manager as a command-line tool; corrected to understand its role in browser-driver management.

## Current Project

- Maven project: `selenium_project_setup`
- Java version: 21
- Maven version: 3.9.16
- Selenium: 4.35.0
- IDE: IntelliJ IDEA
- Browser: Chrome/Chromium
- First Selenium class: `com.sendo.Main`

## Next Lesson

Day 2 — HTML, DOM and Web Elements

## Last Updated

Day 1 completed.

### Day 2 - HTML, DOM and Web Elements

- HTML basics
- HTML elements/tags
- HTML attributes
- id
- class
- name
- type
- value
- placeholder
- DOM concept and tree structure
- Parent/child relationships
- Sibling relationships
- Inspecting HTML with Chrome DevTools
- Inspecting a real Google search field
- Inspecting a real Selenium Web Form page
- Identifying a button's tag, class, and type attributes
- Identifying a text field's element, attributes, and parent
- Reasoning about element relationships from HTML

## What I Understand

- An HTML element is represented by an HTML tag such as input, button, form, or textarea.

- Attributes provide additional information about an HTML element.

- id, class, name, type, value, and placeholder are common HTML attributes relevant to Selenium.

- The DOM is a tree-like representation of a web document.

- Elements can have parent/child relationships.

- Elements that share the same parent are siblings.

- DevTools can be used to inspect the actual DOM and element attributes of a web page.

- A web element does not need to have every possible attribute; attributes may be missing.

- A button can have multiple CSS classes in its class attribute.

- Selenium locators will use information from the DOM/HTML to identify elements; locator strategies are the next day's topic.

## Weak Areas

- No weak areas.

## Mistakes I Made

- No major mistakes.

## Next Lesson

Day 3 - Slenium Locators

## Last Updated

Day 2 completed.
