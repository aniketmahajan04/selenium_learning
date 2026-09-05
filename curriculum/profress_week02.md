# Selenium Learning Progress

## Current Status

- Current Day: Day 11
- Current Topic: Alerts and Popups
- Status: Completed
- Week: Week 2

---

## Completed

## Day 8 — Synchronization and Waits

- Why synchronization is necessary in Selenium
- Race conditions
- Static waits
- `Thread.sleep()`
- Why blindly using static waits is bad practice
- Implicit waits
- Explicit waits
- `WebDriverWait`
- Expected Conditions
- `visibilityOfElementLocated()`
- `presenceOfElementLocated()`
- `elementToBeClickable()`
- Fluent waits
- `FluentWait`
- Custom polling intervals
- Ignoring exceptions with FluentWait
- Element availability
- Difference between DOM presence,

## Day 9 --- Explicit Waits in Depth

- Visibility conditions
- Presence conditions
- Clickability conditions
- Text presence
- Element selection
- URL changes
- Title changes
- Reusable wait utilities
- Default and custom wait timeouts
- Constructor chaining for reusable utility initialization
- Matching the wait condition to the state that is changing

## Day 10 — Dropdowns and Select

- Native HTML `<select>`
- Selenium `Select`
- `selectByVisibleText()`
- `selectByValue()`
- `selectByIndex()`
- Zero-based indexing
- Custom dropdowns
- Difference between native and custom dropdown interaction
- Applying explicit waits to custom dropdown options
- Choosing locators based on actual DOM attributes/text
- Avoiding position-dependent selection when a specific option is required

## Day 11 — Alerts and Popups

- JavaScript alerts
- Confirmation dialogs
- Prompt dialogs
- `switchTo().alert()`
- `Alert`
- `accept()`
- `dismiss()`
- `getText()`
- `sendKeys()`
- `ExpectedConditions.alertIsPresent()`
- Waiting for alerts with `WebDriverWait`
- `NoAlertPresentException`
- Difference between browser dialogs and normal DOM elements
- Reusable alert wait utility

## Checking whether an alert is present after dismissal

## What I Understand

- Selenium can execute commands before a web application has finished creating, rendering, or enabling an element.

- A race condition can occur when Selenium reaches an operation before the application reaches the required state.
- `Thread.sleep()` is a fixed/static wait.
- Static waits can waste time or still be insufficient.
- Implicit waits are global WebDriver settings used during element location.
- An implicit wait is an upper limit, not a mandatory delay.
- Explicit waits wait for a specific condition.
- `WebDriverWait` is the main explicit-wait tool.
- `ExpectedConditions` provide common conditions Selenium can wait for.
- `presenceOfElementLocated()` checks whether an element exists in the DOM.
- `visibilityOfElementLocated()` checks whether an element exists and is visible.
- `elementToBeClickable()` is appropriate when the next operation is clicking.
- Fluent waits allow customization of timeout, polling interval, and ignored exceptions.
- A wait continues as soon as its condition becomes true; it does not necessarily consume the entire timeout.
- Waiting for the actual application condition is better than using an arbitrary fixed delay.
- `isDisplayed()` is redundant after `visibilityOfElementLocated()` has already succeeded.

- `presenceOfElementLocated()` checks whether an element exists in the DOM.
- `visibilityOfElementLocated()` waits until an element exists and is visible.
- `elementToBeClickable()` is appropriate when the next operation is clicking and the element needs to be ready for that interaction.
- `textToBePresentInElementLocated()` is appropriate when an element already exists but its text changes asynchronously.
- `urlContains()` is appropriate when the browser URL is the state that needs to change.
- `titleContains()` is appropriate when the page title is the state that needs to change.
- `elementToBeSelected()` is the appropriate condition when an element's selected state needs to become true.
- URL and title conditions return `boolean`, while visibility and
- clickability conditions can return a `WebElement`.
- The correct Expected Condition should be selected based on the actual state the test needs to wait for.
- A wait condition should match the next action or verification requirement rather than using a generic wait.
- A reusable `WaitUtility` keeps Selenium wait implementation out of test/business logic.
- `WebDriverWait` can be created once in the utility constructor and reused by its wait methods.
- A default timeout can be provided through constructor overloading.
- A custom timeout can be supplied when creating `WaitUtility`.
- Constructor chaining uses `this()` to call another constructor in the same class and reuse initialization logic.

- Selenium's Select class is designed for native HTML `<select>` elements.
- Custom dropdowns built with elements such as `<div>` and `<button>` are not compatible with Select.
- `selectByVisibleText()` selects an option using the text displayed to the user.
- `selectByValue()` selects an option using the HTML value attribute.
- `selectByIndex()` selects an option using its zero-based position.
- The correct selection method depends on the test requirement and identifier stability.
- `selectByIndex()` is appropriate when the requirement itself is position-based.
- Position-based selection is fragile when the requirement is actually about a specific option.
- An HTML `value` can be a stable identifier if the application intentionally maintains it.

- Custom dropdowns must be handled as normal Selenium web elements.
- A typical custom dropdown flow is:
  1. Locate the dropdown button.
  2. Wait until the button is ready to click.
  3. Click the button.
  4. Wait until the required option is ready.
  5. Locate the required option.
  6. Click the option.
- `elementToBeClickable()` is appropriate when the next operation is clicking.
- A container being present in the DOM does not necessarily mean it is visible or ready for interaction.
- Locators must match attributes or text that actually exist in the DOM.
- `By.name("Maharashtra")` is incorrect when the element has no name attribute.
- Custom options can be located using actual attributes and visible text.

- JavaScript alerts are browser dialogs, not normal webpage DOM elements.
- Normal findElement() locators cannot locate their OK/Cancel controls or prompt input.
- driver.switchTo().alert() switches Selenium to the currently present JavaScript alert.
- switchTo().alert() does not automatically wait.
- If no alert is present, switchTo().alert() throws NoAlertPresentException.
- accept() is equivalent to choosing OK.
- dismiss() is equivalent to choosing Cancel.
- getText() returns the message displayed by the JavaScript alert.
- getText() does not return the value typed into a prompt input.
- sendKeys() sends keyboard input to a JavaScript prompt's input field.
- ExpectedConditions.alertIsPresent() can be used with WebDriverWait to wait for an alert.
- A professional alert flow is: trigger dialog → wait for alert → obtain Alert → interact → accept/dismiss.
- The alert message and prompt input value are separate concepts.
- A helper such as isAlertPresent() can use switchTo().alert() and NoAlertPresentException to check alert presence.
- Method names should accurately describe what their return values mean.

---

## Professional Practices Learned

- Prefer condition-based waits over arbitrary fixed delays.
- Match the wait condition to the next action or verification.
- Avoid blindly using `Thread.sleep()`.
- Keep reusable Selenium infrastructure inside utility classes.
- Keep test code focused on test intent.
- Choose stable, DOM-grounded locators.
- Treat custom dropdowns as normal web elements.
- Treat JavaScript dialogs differently from DOM elements.
- Wait for alert presence instead of assuming the dialog is immediately available.
- Use the `Alert` API rather than DOM locators for JavaScript dialogs.
- Use descriptive names such as `promptAlert` and `isAlertPresent()`.
- Handle `NoAlertPresentException` when checking alert presence.
- Avoid misleading method names whose return values do not match their names.

---

## Weak Areas

- Need more practice choosing the most appropriate Expected Condition for unfamiliar scenarios.
- Need more practice designing reusable wait utilities.
- Need more practice choosing between `selectByValue()` and `selectByVisibleText()` based on application-specific stability.
- Need more practice writing robust locators for custom dropdown options.
- Need more practice distinguishing visibility from clickability in dynamic UIs.
- Need more practice with assertions for alert messages and resulting application state.
- The Selenium alerts practice page did not visibly populate the prompt input when using `Alert.sendKeys()`, although the prompt appeared and manual typing worked.

---

## Mistakes I Made

- Initially thought `findElement()` automatically waits for an element.
- Initially used `Duration.ofSeconds(500)` when intending a 500 ms polling interval; corrected it to `Duration.ofMillis(500)`.
- Initially checked `isDisplayed()` after `visibilityOfElementLocated()`; learned this is redundant.
- Initially chose the wrong Expected Condition for selection state and asynchronous text changes.
- Initially suggested `selectByVisibleText()` for a custom dropdown; learned that Select requires a native `<select>`.
- Used `By.name("Maharashtra")` when the custom option had no name attribute; corrected the locator to actual DOM attributes/text.
- Initially considered that `switchTo().alert()` might return null or wait automatically; learned it throws `NoAlertPresentException` when no alert exists.
- Created `isAlertGone()` whose return value actually meant an alert was present; learned to use a name such as `isAlertPresent()` that matches the return value.
- Correctly reasoned that after `confirm.dismiss()`, an alert-presence check should return false.

---

## Next Lesson

## Day 12 — Frames and IFrames

###

- What an iframe is
- Why Selenium cannot directly access its contents
- Switching into a frame
- Switching back to default content
- Nested frames

---

## Last Updated

Day 11 completed — Alerts and Popups
