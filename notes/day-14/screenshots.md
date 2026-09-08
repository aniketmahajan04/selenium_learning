### Day 14 — Screenshots + Week 2 Project

## Goal

Learn how screenshots become a professional debugging tool, then gradually build the Week 2 Login + Product Search automation project.

**What I will learn today:**

- Taking screenshots
- Saving screenshots to files
- Why screenshots are useful for debugging
- How screenshots fit into test failure handling
- Eventually: the Week 2 Login + Product Search workflow

### Why screenshots?

Imagine your automation does this:

```
Login
   ↓
Search product
   ↓
Click product
   ↓
Add to cart
   ↓
❌ Test fails
```

Your terminal says:

```
ElementClickInterceptedException
```

That's useful, but there's an important question:

> **What did the browser actually look like when the failure happened?**

Maybe:

- a popup covered the button
- the page hadn't finished loading
- the wrong page appeared
- the element was outside the viewport
- a validation message appeared
- your locator selected something unexpected

A screenshot gives you **visual evidence of the browser state at that moment**.

This is why screenshots aren't merely a "nice Selenium feature." In professional automation they're **failure evidence.**

### The Selenium API

The main interface is:

```java
TakesScreenshot
```

The important method is:

```java
getScreenShotAs(...);
```

Conceptually:

```
WebDriver
   │
   └── TakesScreenshot
          │
          └── getScreenshotAs(...)
```

Here's the basic idea:

```java
TakesScreenshot screenshot = (TakesScreenshot)driver:
File source = screenshot.getScreenShotAs(OutputType.FILE);
```

**Think about this carefully**

You already know:

```java
WebDriver driver = new ChromeDriver();
```

So why we need:

```java
(TakesScreenshot)driver;
```

?

Because `WebDriver` itself doesn't define `getScreenshotAs()`.

Instead, Selenium provides the screenshot capability through the `TakesScreenshot` interface.

### Now let's actually save one

Suppose your selenium code has:

```java
WebDriver driver = new ChromeDriver();
driver.get("https://www.selenium.dev/selenium/web/web-form.html");
```

We want:

```
Browser
   ↓
Take screenshot
   ↓
Temporary screenshot file
   ↓
Save it somewhere we choose
```

The API gives us a `File`:

```java
File source = screenshot.getScreenshotAs(OutputType.FILE);
```

But **getting screenshots and saving it to your desired location are two separate operations.**

This distinction is important.

**One important question**

Right now the screenshots look something like:

```
/tmp/screenshot123456789.png
```

If your test fails and the program ends, do you think this temporary file is necessarily where you want your debugging screenshots to live"?

Probably not.

For real project, we'd want something like:

```
selenium-project/
├── screenshots/
│   ├── login-failure.png
│   ├── product-search-failure.png
│   └── cart-failure.png
```

So now we need to learn **how to copy/save the captured screenshot to a location we control.**

**Your exercise**

Write the code yourself that does the following:

**1.** Create a TakesScreenshot reference from driver.
**2.** Take a screenshot using `getScreenshotAs(OutputType.FILE)`.
**3.** Store the returned screenshot in a File variable.
**4.** Print the file's path using:

```java
source.getAbsolutePath()
```

You should end up with something conceptually like:

```
// your code here
```

Don't worry about copying/saving it to a permanent location yet.

**Your next exercise**

Without me giving you the solution yet, think about this:

We have:

```java
File source = screenshot.getScreenshotAs(OutputType.FILE);
```

and we want to get it into:

```
screenshots/homepage.png
```

**Question:** What Java mechanism would you use to copy the contents of one `File` to another file.

### The Real Reason We Take Screenshots

So far we've manually done:

```
Run test
   ↓
Take screenshot
   ↓
Save screenshot
```

But that's not very useful in a real test suite.

We don't want to write:

```java
takeScreenshot();
```

After every single operation.

**Instead, we want**

```
Test starts
   ↓
Test performs actions
   ↓
        ┌───────────────┐
        │ Test succeeds │ → No screenshot necessary
        └───────────────┘

        OR

        ┌──────────────┐
        │ Test fails ❌ │
        └──────────────┘
                ↓
        Capture screenshot
                ↓
        Save failure evidence
```

That's the professional use case.
