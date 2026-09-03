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

Imagine a login application:

```html
<div id="status">Logging in...</div>
```

A few seconds later, Javascript changes it to:

```html
<div id="status">Login successful</div>
```

Your test needs to continue only when the status `"Login successful"`

You could locate the element:

```java
WebElement status = driver.findElement(By.id("status"));
```

But here's the problem:

```text
0 sec → Logging in...
1 sec → Logging in...
2 sec → Logging in...
3 sec → Login successful
```

Simply waiting for the element's **visibility** isn't enough because the element was visible from the beginning.

We need to wait for a **change in its text**.

Selenium provides:

```java
ExpectedConditions.textToBePresentInElementLocated(...);
```

Conceptually:

```java
wait.until(
    ExpectedConditions.textToBePresentInElementLocated(By.id("status"), "Login successful")
);
```

The important difference is:

```text
visibility
    ↓
"Is the element visible?"

text condition
    ↓
"Does the element currently contain the text I expect?"
```

**Your next challenge — URL changes**

Now let's apply the same reasoning to something that isn't an element.

Suppose your test does:

```java
driver.findElement(By.id("login")).click();
```

The application performs login and then redirects:

```text
/login
   ↓
/dashboard
```

You don't necessarily care whether a particular dashboard element is visible yet.

Your requirement is:

> **Wait until the browser URL contains `/dashboard`**.

Which condition would you expect to use?

Think about the distinction:

```
Element-related condition
        vs
Browser/navigation-related condition
```

**Your task**

Tell me:

1. Which `ExpectedConditions` method you would use.
2. Why an element visibility condition would be the wrong abstraction here.
3. What you think the Java code would roughly look like.

---

**Now let's test your understanding**

Imagine this login flow:

```
Click Login
↓
URL changes to /dashboard
↓
Dashboard HTML loads
↓
"Welcome, Sendo" becomes visible
```

Your test has two different requirements:

**Requirement 1**

Wait until the browser reaches:

```
/dashboard
```

**Requirement 2**

Then wait until:

```
"Welcome, Sendo"
```

is visible.

Would you use **one wait condition or two separate wait conditions?**

And what conditions would you choose for each?

### Element Selection

Now we're going to look at one of the less obvious Expected Conditions from today's syllabus:

**waiting for an element to be selected**.

Imagine a checkbox:

```html
<input id="terms" type="checkbox" />
```

Your automation performs:

```java
driver.findElement(By.id("terms")).click();
```

But suppose the application uses JavaScript and the checkbox's selected state doesn't update immediately.

You could need to synchronize with:

> "Wait until this checkbox is actually selected."

Selenium provides:

```java
ExpectedConditions.elementToBeSelected(...);
```

For example:

```java
wait.until(
    ExpectedConditions.elementToBeSelected(
        By.id("terms")
    )
);
```

The important distinction is:

```text
visibility → Is it visible?
clickability → Can I click it?
selection → Is it selected?
```

Again, we're matching the wait condition to the **state we actually care about**.

Your challenge:
