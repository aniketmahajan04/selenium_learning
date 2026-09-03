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

```text
DOM
 │
 ├── element doesn't exist
 │
 └── element exists
       │
       ├── hidden
       │
       └── visible
```

`presenceOfElementLocated()` cares about the **existence**.
`visibilityOfElementLocated()` cares about the **existence + visibility.**

#### Now the important part: think like a QA engineer

Suppose your test needs to do this:

```java
WebElement message = ...;
System.out.println(message.getText());
```

The application creates the element in the DOM immediately, but initially keeps it hidden. After 2 seconds, it becomes visible.

**Which wait should you choose?**

**A.**

```java
presenceOfElementLocated();
```

**B.**

```java
visibilityOfElementLocated();
```

**C.**

```java
Thread.sleep();
```

Don't just choose the one you remember.

Tell me **which one you would choose and why**.

Also answer this:

> If `presenceOfElementLocated()` succeeds, we conclude that the user can the element?

#### One professional nuance

Don't think of `visibilityOfElementLocated()` as:

> "Wait until the user can interact with it."

It establishes **visibility**, but that doesn't necessarily mean the element is ready for every interaction.

For example, a button might be visible but still disabled:

```html
<button id="submit" disabled>Submit</button>
```

For a click, we may need:

```java
ExpectedConditions.elementToBeClickable(...)
```

That's why **the condition should match what your next action requires**.

### `elementToBeClickable()`

Let's go one level deeper.

Suppose we have:

```html
<button id="submit" disabled>Submit</button>
```

After some javascript processing, the application changes it to:

```html
<button id="submit">Submit</button>
```

Your test want to do:

```java
driver.findElement(By.id("submit")).click();
```

A naive approach would be:

```java
Thread.sleep(3000)
driver.findElement(By.id("submit"));
```

But you've already learned why that's poor synchronization.

Instead;

```java
WebDriverWait driver = new WebDriverWait(driver, Duration.ofSeconds(10));

WebElement submitButton = wait.until(
    ExpectedConditions.elementToBeClickable(By.id("submit"))
);

submitButton.click();
```

The important mental model is:

```
Application state
      ↓
Is the element ready for the intended click?
      ↓
YES → Selenium continues
NO  → keep waiting
```

Notice something important: **we don't need to add another `isEnabled()` check after this wait just to prove the same thing**..

**Your turn — choose the condition**

Imagine this scenario:

A product page has an **"Add to Cart"** button.

The button is present in the DOM immediately and visible, but the application keeps it disabled while product information is loading.

Once loading finishes, the button becomes enabled.

Your test's next action is:

```java
addToCart.click();
```

what would you use:

A. `presenceOfElementLocated()`

B. `visibilityOfElementLocated()`

C. `elementToBeClickable()`

And **why are the other two less appropriate for this particular situation**?

### Waiting for Text

Now let's move away from element state.
