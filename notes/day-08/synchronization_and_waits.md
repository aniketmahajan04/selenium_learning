# Day - 8 Synchronization and Waits

## Goal

Learn why Selenium sometimes try to interact with an element before the page is ready, and understand how waits solve that problem.

**What I will learn**:

- Why synchronization is necessary
- Static waits
- Implicit waits
- Explicit waits
- Fluent waits
- WebDriverWait
- Expected Conditions
- Element availability
- Race conditions
- Why blindly using Thread.sleep() is bad practice

#### Why do We Need Waits?

So far, we've worked with pages where the element was already available when selenium look for it:

```java
driver.get(url);

WebElement input = driver.findElement(By.id("username"));
input.sendKeys("Sendo");
```

But modern websites don't always work that way.

Imagine this sequence:

```text
0 ms     Page starts loading
         ↓
100 ms   HTML appears
         ↓
300 ms   JavaScript executes
         ↓
800 ms   Login button is created
         ↓
1000 ms  Button becomes clickable
```

Your Selenium code might execute:

```text
0 ms     driver.get()
         ↓
100 ms   findElement()
         ↓
         ❌ Button doesn't exist yet
```

Selenium isn't necessarily wrong.

**The test is running faster that application**.

This is called a **synchronization problem**.

### Static Waits

We've already established that:

```java
Thread.sleep(5000);
```

is a **Static Wait**.

#### What does mean static?

It means waiting time is **fixed in advanced**.

```java
Thread.sleep(5000);
```

means:

Stop this java thread for 5 seconds, regardless of whether the element is ready earlier or not?

The important thing is that Selenium isn't checking the browser for a condition during those 5 seconds.

It's simply:

```text
Wait 5 seconds
     ↓
Continue execution
```

**Why did we learn it if it's bad practice?**

Because you need to understand the problem that the better wait mechanisms are designed to solve.

Compare:

```text
STATIC WAIT

Thread.sleep(5000)
       ↓
always waits 5 seconds
       ↓
then continues
```

with that we eventually want?

```text
CONDITIONAL WAIT

Wait up to 10 seconds
       ↓
Is element ready?
   ↙           ↘
 YES           NO
  ↓             ↓
continue      keep waiting
                ↓
          timeout → fail
```

That's the key conceptual difference.

##### One important distinction

`Thread.sleep(5000)` isn't a Selenium wait API.

It's a **Java thread operation**:

```java
Thread.sleep(5000);
```

You're telling Java:
"Pause Execution."

### Implicit Waits

You configure one like this:

```java
driver.manage().timeouts().implicitlyWaits(Duration.ofSeconds(10));
```

This changes how WebDriver searches for elements.

Without an implicit wait:

```java
driver.findElement(By.id("username"));
```

can fail immediately with the element isn't available.

With a 10-second implicit wait, WebDriver will keep attempting to find the elements for **up to 10 seconds** before giving up.

### Explicit Waits

**What is an explicit wait?**

An explicit wait tells Selenium:

##### Wait for a specific condition to become true, for up to a maximum amout of time

For example:

```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

WebElement button = wait.until(
    ExpectedConditions.visibilityOfElementLocated(By.id("login"))
);
```

There are Three important pieces:

```text
WebDriverWait
      ↓
maximum timeout
      ↓
until(...)
      ↓
specific condition
```

Unlike `Thread.sleep()` you're not saying:

"Wait for 10 seconds"

We're saying:

"Wait up to 10 seconds for this condition. If it becomes true earlier, continue immediately."

Why `until()`?

This:

```java
wait.until(...);
```

keep checking the condition until earlier:

**Condition succeeds**:

```text
0s → ❌
1s → ❌
2s → ❌
3s → ✅
        ↓
     continue
```

or the timeout is reached:

```text
0s → ❌
1s → ❌
...
10s → ❌
        ↓
TimeoutException
```

That's the fundamental idea.

### Expected Conditions

This is an important piece:

You can think of:

```java
ExpectedConditions.visibilityOfElementLocated(...)
```

as a question **Selenium repeatedly asks the browser**:

"Is this element located and visible yet?"

For example:

```java
wait.until(
    ExpectedConditions.visibilityOfElementLocated(By.id("revealed"))
);
```

Conceptually:

```text
Is #revealed visible?
       ↓
      No → keep polling
       ↓
Is #revealed visible?
       ↓
      No → keep polling
       ↓
Is #revealed visible?
       ↓
     YES → return WebElement
```

And `WebDriverWait` handles the timeout/polling behavior for you.

**Common conditions you'll encounter**

```java
visibilityOfElementLocated(...)
presenceOfElementLocated(...)
elementToBeClickable(...)
textToBePresentInElement(...)
urlContains(...)
titleContains(...)
```

### Presence vs Visibility

let's test that distinction:

imagine this HTML:

```html
<div id="message" style="display:none;">Login successful</div>
```

The element **exists in the DOM**, but it isn't visible.

Suppose you write:

```java
WebElement message = wait.until(
    ExpectedConditions.presenceOfElementLocated(By.id("message"))
);
```

The condition can succeed because the element is present, even though it's hidden.

But:

```java
WebElement message = wait.until(
    ExpectedConditions.visibilityOfElementLocated(By.id("message"))
);
```

will continue waiting until it becomes visible.

**Your turn**

Imagine your next line is:

message.getText();

and your test requirement is:

"Read the success message **only after the user can actually see it**."

Which condition should you use?

A. `presenceOfElementLocated()`

B. `visibilityOfElementLocated()`

And tell me **why presence alone isn't enough**.
