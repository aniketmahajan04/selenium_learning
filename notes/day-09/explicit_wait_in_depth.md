# Day 9 — Explicit Waits in Depth

## Goal

Become comfortable choosing the right explicit wait condition instead of simply waiting for an element to exist.

**What I will learn today**:

- Visibility conditions
- Presence conditions
- Clickability conditions
- Text presence
- Element selection
- URL changes
- Title changes
- Reusable wait utilities

### Presence VS Visibility

We have learned this on day 8, so today we're just going to sharpen our understanding.

Imagine this HTML:

```html
<button id="login">Login</button>
```

Selenium might reach this point while the browser is still processing the page.

There are two different questions we could ask.

**Question 1 — "Does the element exists?"**

```java
wait.until(
    ExpectedConditions.presenceOfElementLocated(By.id("login"))
);
```

This means:

> "Wait until an element matching this locator exists in the DOM."

<span style="color:green"><b>This doesn't necessarily mean that users can it.</b></span>

**Question 2 — "Can I see the element?"**

```java
wait.until(
    ExpectedConditions.visibilityOfElementLocated(By.id("login"))
);
```

This means:

> "Wait until element exists and is visible."
