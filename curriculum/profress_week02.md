# Selenium Learning Progress

## Current Status

- Current Day: Day 8
- Current Topic: Synchronization and Waits
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

---

## Weak Areas

- Need more practice choosing the most appropriate Expected Condition for different scenarios.
- Need more practice creating reusable wait utilities.

---

## Mistakes I Made

- Initially thought findElement() automatically waits for an element.
- Learned that the default implicit wait is zero.
- Initially used Duration.ofSeconds(500) when intending a 500 ms polling interval.
- Corrected it to Duration.ofMillis(500).
- Initially checked isDisplayed() after visibilityOfElementLocated(); learned that this check is redundant.
- Learned to distinguish DOM presence, visibility, and clickability.

## Next Lesson

### Day 9 — Explicit Waits in Depth

###

- Visibility conditions
- Presence conditions
- Clickability conditions
- Text presence
- Element selection
- URL changes
- Title changes
- Reusable wait utilities
- `waitForElementVisible()`
- `waitForElementClickable()`

---

## Last Updated

Day 8 completed — Synchronization and Waits completed.
