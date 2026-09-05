# Day 11 — Alerts and Popups

## Goal

Learn how Selenium interacts with Javascript browser dialogs instead of normal HTML elements.

**What I will learn:**

- JavaScript alerts
- Confirmation dialogs
- Prompt dialogs
- `switchTo().alert()`
- Accept
- Dismiss
- Get text
- Send keys

### 1. First concept: What is a JavaScript alert?

You've already worked with normal HTML elements:

```html
<button>Delete</button>
```

Selenium can do:

```java
driver.findElement(By.id("delete")).click();
```

because the button is part of page's **DOM**.

But JavaScript can create a browser dialog like:

```js
alert("Are you sure?");
```

It looks something like this:

```
┌──────────────────────────────┐
│  Are you sure?               │
│                              │
│                    [  OK  ]  │
└──────────────────────────────┘
```

The important difference is:

> **"This dialog is not normal HTML element that you can locate with `By.id()`, XPath, or CSS."**

So this approach is wrong:

```java
driver.findElement(By.xpath("//button[text()='OK']")).click();
```

The `OK` button belongs to the **browser's JavaScript dialog**, not the webpage HTML.

That's why selenium provides:

```java
driver.switchTo().alert();
```

Think of it similarly to the way you learned frames:

```
Normal webpage
     ↓
driver.findElement(...)

JavaScript alert
     ↓
driver.switchTo().alert()
```

**One important distinction**

Don't think of `switchTo().alert()` as `clicking the alert`.

It only `gets access to the alert`.

For example, conceptually:

```java
Alert alert = driver.switchTo().alert();
```

Now `alert` represents the JavaScript dialog.

Then:

```java
alert.accept();
```

means click OK.

**Your turn — next question**

Suppose this JavaScript runs:

```js
confirm("Do you want to continue?");
```

A confirmation dialog appears with:

**OK | Cancel**

You want the test to click **Cancel**.

Which Selenium method would you use?

A. `accept()`
B. `dismiss()`

And tell me **why**.

### Reading the alert

Suppose the browser shows:

```js
alert("Registration successful!");
```

Your test needs to verify the message before accepting it.

Selenium provides:

```java
alert.getText()
```

Before I show you how to use it, tell me:

**What do you think `getText()` returns?**

A. The text of the webpage
B. The text displayed inside the JavaScript alert
C. The alert's title
D. The HTML of the alert

**Next question**

Imagine you have a prompt dialog:

```js
prompt("Enter your name:");
```

The dialog contains a text input and has **OK / Cancel**.

You want Selenium to type:

```
Sendo
```

into that input.

Which **Selenium method do you think you should use**?

**A.** `getText()`
**B.** `sendKeys()`
**C.** `accept()`
**D.** `dismiss()`

And explain your reasoning.

#### Your first Day 11 mini-task

Using the Selenium alerts practice [Selenium alert webpage](https://www.selenium.dev/selenium/web/alerts.html?utm_source=chatgpt.com#), automate this flow:

Prompt → type `Sendo` → click **OK**

Don't worry about assertions or waits yet.

Write the Java code yourself using what you've learned so far.
