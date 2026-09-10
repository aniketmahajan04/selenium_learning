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

**Your next exercise**

Let's build a small reusable method.

Create:

```java
public static void takeScreenshot(WebDriver driver, String fileName)
```

Its responsibility should be:

```
Receive driver
   ↓
Take screenshot
   ↓
Create screenshots directory
   ↓
Save screenshot using fileName
```

You've already written every piece required for this.

**Don't worry about exception handling yet.**

**Think about existing screenshots**

Earlier you discovered:

```
StandardCopyOption.REPLACE_EXISTING
```

But your reusable method currently has:

```java
Files.copy(srcFiles.toPath(), destinationFile);
```

What happens if you call:

```java
takeScreenshot(driver, "login-failure.png");
```

twice?

The second call will encounter the same `FileAlreadyExistsException` you saw earlier.

For a screenshot utility, do you think we should:

**A.** Allow the second screenshot to fail because the file already exists?
**B.** Automatically replace the previous screenshot?
**C.** Generate a unique filename every time?

There isn't necessarily one universal answer here. I want you to think like an automation engineer about what makes sense for failure screenshots.

Which would you choose, and why?

Explanation:

```
C we should generate the unique file name every time because there might be multiple test failed then we should capture them instead of replacing them
```

Ans:

Exactly. **C is the strongest choice for failure evidence.**

Our reasoning is correct:

> Multiple tests can fail, and we don't want later failure to overwrite evidence from an earlier failure.

For example:

```
screenshots/
├── LoginTest_20260908_101530.png
├── ProductSearchTest_20260908_101545.png
└── AddToCartTest_20260908_101601.png
```

Now each failure has its own artifact.

**Professional Thinking**

There are actually two useful concepts here:

**Test identity + uniqueness**

A professional filename might contains:

```
<TestName>_<timestamp>.png
```

or something:

```
<TestName>_<UUID>.png
```

The timestamp makes the screenshot easy for human to understand; a UUID virtually guarantees uniqueness.

You just made an important architectural decision:

> "Failure artifacts should be preserved, not overwritten".

That's exactly the kind of reasoning I want you developing - not merely memorizing `getScreenShotAs()`.

**Let's implement it**

We don't want the caller to have to generate filename manually.

Instead of:

```java
takeScreenshot(driver, "homepage.png");
```

we could eventually have something conceptually like:

```java
takeScreenshot(driver, "LoginPage");
```

and the utility generates:

```
LoginTest_20260908.png
```

**Your Exercise**

Use Java's date/time API to generate a timestamp.

Think about what you've learned in java:

```java
LocalDateTime
DateTimeFormatter
```

We want a timestamp formatted roughly like:

```
20260908_143015
```

So:

```
yyyyMMdd_HHmmss
```

**Your task**:

**1.** Create a DateTimeFormatter.
**2.** Create a timestamp using LocalDateTime.now().
**3.** Combine it with the supplied filename.
**4.** Make sure the final filename ends in .png.

For example, If the caller passes:

```
"LoginPage"
```

the resulting, filename should resemble:

```
LoginTest_20260908_143015.png
```

### Making Failure Screenshots reliable

Before we move to the week 2 project, I want to strengthen the failure-handling code just wrote.

Your current flow is:

```java
catch(Exception e) {
   System.err.println("Test failed due to: "+ e.message());
   takeScreenshot(driver, generateFilename("WebFormFailure"));
}
```

This works when the screenshot succeeds.

But think about this scenario:

```
Test fails
   ↓
catch(Exception e)
   ↓
takeScreenshot()
   ↓
❌ IOException
```

Now the screenshot itself has failed.

The danger is that the **original Selenium failure can become harder to diagnose.**

**Professional debugging principle**

When a test fails, we want to preserve both:

```
Original failure
   +
Failure evidence
```

For example:

```
❌ Test failed: NoSuchElementException
 Screenshot: WebFormFailure_20260910_095100.png
```

If the screenshot itself fail:

```
❌ Test failed: NoSuchElementException
⚠️ Screenshot capture failed: ...
```

We don't want the screenshot problem to completely obscure the original Selenium problem.

**Your next exercise**:

Modify your `catch` block so that:
**1.** You **attempt the screenshot first**
**2.** If screenshot capture fails, print a separate message screenshot capture failed.
**3.** Regardless of whether screenshot capture succeeds, print **original exception.**

You will need a nested `try/catch`

**Next Understanding**

Suppose this happens:

```java
driver.findElement(By.id("product-search")).sendKeys("Laptop");

driver.findElement(By.id("search-button")).click();

driver.findElement(By.id("laptop-product")).click();

driver.findElement(By.id("add-to-cart")).click();
```

The final line throw:

```
ElementClickInterceptedException
```

You get a screenshot.

**Here is the important question**

The screenshot shows the browser at the moment of failure.

**What kinds of things would you inspect in that screenshot to help determine why `add-to-cart` failed?**

Give me **at least 3 things** you'd look for.

For example, if `add-to-cart` failed, I'd inspect the screenshot for things like:

**1. Are we actually on the expected product page?**
**2. Is the add to cart button visible?**
**3. Is a popup/model/overlay covering the button?**
**4. Is there an error or validation message visible?**
**5. Does the page look partially loaded or in unexpected state?**

And then we'd combine that visual evidence with the exception:

```
Screenshot
   +
Exception
   +
Test logs
   ↓
Root-cause investigation
```

**One more exercise before we move on**

Imagine your screenshot shows this:

```
┌──────────────────────────────────────┐
│ Product: Laptop                      │
│                                      │
│ [ Add to Cart ]                      │
│                                      │
│        ┌──────────────────────┐      │
│        │ 🔄 Loading...        │      │
│        └──────────────────────┘      │
└──────────────────────────────────────┘
```

And Selenium throws:

```
ElementClickInterceptedException
```

**Question**

Based on the **screenshot + exception**, what do you think is the likely reason Selenium couldn't click the button?

And more importantly:

What Selenium concept from Days 8–9 would you use to make the test handle this situation more reliably?

### Screenshot Utility

You've now learned the fundamental screenshot workflow.

Before we move to **Week 2 project**, I want you to make one final improvement to your utility itself to handle filename generation.

Currently your method requires:

```java
takeScreenshot(driver, generateFilename("WebFormFailure"));
```

I'd like the utility itself to handle filename generation.

So the caller should eventually be able to write:

```java
takeScreenshot(driver, "WebFormFailure");
```
