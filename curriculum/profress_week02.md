# Selenium Learning Progress

## Current Status

- Current Day: Day 10
- Current Topic: Dropdowns and Select
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

---

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

---

## Professional Practices Learned

- Prefer condition-based waits over arbitrary fixed delays.
- Choose a wait condition based on what the next operation requires.
- Use `WebDriverWait` for normal explicit-wait scenarios.
- Use `FluentWait` when customized polling or exception handling is needed.
- Avoid blindly using `Thread.sleep()` to solve synchronization problems.
- Avoid unnecessary checks after a wait condition has already established the required state.
- Understand the difference between DOM presence, visibility, and clickability.
- Synchronize with application state instead of guessing how long an operation will take.

- Prefer condition-based waits over arbitrary fixed delays.
- Choose a wait condition based on what the next operation requires.
- Use `WebDriverWait` for normal explicit-wait scenarios.
- Use `FluentWait` when customized polling or exception handling is needed.
- Avoid blindly using `Thread.sleep()` to solve synchronization problems.
- Avoid unnecessary checks after a wait condition has already established the required state.
- Distinguish DOM presence, visibility, clickability, text state,selection state, URL state, and title state.
- Keep reusable Selenium infrastructure inside utility classes instead of duplicating wait implementation across tests.
- Prefer constructor chaining when multiple constructors share initialization logic.
- Support a sensible default timeout while allowing a custom timeout when a test genuinely requires one.
- Keep test code focused on test intent rather than WebDriverWait mechanics.

- Inspect the DOM before using Selenium's `Select` class.
- Use `selectByValue()` when the HTML value is a suitable stable identifier.
- Use `selectByVisibleText()` when user-facing text is the appropriate stable identifier.
- Use `selectByIndex()` when the requirement explicitly depends on position.
- Treat custom dropdowns as normal web elements rather than forcing them into the `Select` abstraction.
- Use explicit waits for dynamically rendered or interactable custom dropdown options.
- Choose `elementToBeClickable()` when the next operation is a click.
- Keep locators grounded in the actual DOM.
- Avoid fragile position-dependent automation when a specific business option is required.
- Continue avoiding `Thread.sleep()` in favor of condition-based synchronization.
- Keep test code focused on test intent and reusable wait utilities for synchronization mechanics.

---

## Weak Areas

- Need more practice choosing the most appropriate Expected Condition for different scenarios.
- Need more practice creating reusable wait utilities.
- Need more practice choosing the most appropriate Expected Condition for unfamiliar scenarios.
- Need more practice with `elementToBeSelected()`.
- Need more practice designing reusable wait utilities and deciding when custom timeout values are justified.
- Should continue practicing the distinction between visibility and actual interactability.

- Need more practice choosing between selectByValue() and selectByVisibleText() based on application-specific stability.
- Need more practice writing robust locators for custom dropdown options.
- Need more practice distinguishing visibility from clickability in dynamic custom UIs.
- Continue practicing stable locator selection for dynamic interfaces.

---

## Mistakes I Made

- Initially thought `findElement()` automatically waits for an element.
- Learned that the default implicit wait is zero.
- Initially used `Duration.ofSeconds(500)` when intending a 500 ms polling interval.
- Corrected it to `Duration.ofMillis(500)`.
- Initially checked `isDisplayed()` after `visibilityOfElementLocated()`; learned that this check is redundant.
- Learned to distinguish DOM presence, visibility, and clickability.

- Initially chose `visibilityOfElementLocated()` for a selection-state scenario; learned that `elementToBeSelected()` is the condition for a changing selected state.
- Initially chose `visibilityOfElementLocated()` for a scenario where an already-visible element's text was changing; learned to use `textToBePresentInElementLocated()`.
- Used Google to check the selection-related Expected Condition; then reviewed the reasoning instead of simply memorizing the API.

- Initially suggested using `selectByVisibleText()` for a custom dropdown after correctly identifying it as custom.
- Learned that `selectByVisibleText()` belongs to Selenium's Select class and requires a native `<select>` element.
- Used `By.name("Maharashtra")` even though the provided custom option had no name attribute.
- Corrected the custom dropdown approach to locate the actual option using DOM attributes/text and wait for it to become clickable.
- Correctly recognized that `selectByIndex()` is appropriate when the requirement explicitly specifies a position.
- Correctly applied `elementToBeClickable()` when the next operation is clicking the custom dropdown button or option.

---

## Next Lesson

## Day 11 — Alerts and Popups

###

- JavaScript alerts
- Confirmation dialogs
- Prompt dialogs
- `switchTo().alert()`
- Accept
- Dismiss
- Get text
- Send keys

---

## Last Updated

Day 10 completed — Dropdowns and Select completed.
