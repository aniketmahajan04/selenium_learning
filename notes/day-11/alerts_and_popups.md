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
