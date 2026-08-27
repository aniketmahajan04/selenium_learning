# Selenium Selectors

## Goal

Learn how selenium identifies specific elements on webpage and how to choose reliable locators.

### What I will learn:

- By.id()
- By.name()
- By.className()
- By.tagName()
- By.linkText()
- By.partialLinkText()
- By.cssSelector()
- By.xpath()
- Unique vs fragile locators
- Dynamic attributes
- Why id is usually preferred
- CSS vs XPath

### What is locators?

Yesterday you inspect HTML like this:

```html
<input id="my-text-id" class="form-control" name="my-text" type="text" />
```

Today we answer:

#### How does Selenium tell which element i want?

That's the job of locators.

Imagine a webpage has:

```html
<input id="username" />
<input id="password" />
<input id="email" />
```

If we tell seleniums find me and **input** then there are three possible elements.

So we need something more specific.
e.g.,

```java
// Don't worry we haven't covered what is By yet.
By.id("username");
```

But this tell selenium find and elements that has the id of `username`.

Conceptually:

```text
HTML
 ↓
<input id="username">
 ↓
Locator
 ↓
By.id("username")
 ↓
Selenium finds that element
```

#### Your first locator

The Selenium API provides `By` class for describing how an element should be located.

For example:

```java
By.id("username");
```

This isn't element itself. Its more like an **instruction for finding the element**.

Later we will combine it with:

```java
driver.findElement(...);
```

to actually retrieve a `webElement`.

For example:

```java
WebElement username = driver.findElement(By.id("username"));
```

Don't memorize this yet. Understand the separation.

```text
By.id("username")
        ↓
How to find it

driver.findElement(...)
        ↓
Actually find it
```

### First reasoning exercise

Consider this HTML:

```html
<input id="username" name="user" type="text" />
```

I give you these possible locators:

```java
By.id("username");
By.name("user");
By.tagName("input");
```

All three **could potentially find the element**.

#### Question:

Which one you choose as your **first preference**, and why?

Tip:
Think like an automation engineer:

```text
What makes one selector better than another?
```

<span style="color:green">IMP :- <b> Prefer a locator that is unique, stable, readable, and tied to the element's intended identity.</b><span>

### By.id()

Let's make your actual locator.

Suppose our page contains:

```html
<input id="username" name="user" type="text" />
```

We can write:

```java
By.id("username");
```

And to retrieve the element:

```java
WebElement username = driver.findElement(By.id("username"));
```

_Hope you already know enough java to understand this basic structure:_

```text
driver
  ↓
findElement()
  ↓
By.id("username")
  ↓
WebElement
```

The key distiction:

```java
By.id("username");
```

is the **locator strategy**.

```java
driver.findElement(...);
```

is the **WebDriver operation that uses that strategy**.

### Exercise - don't copy the answer

On the selenium Web Form page you used yesterday, you found:
Visit [Selenium Web Form page](https://www.selenium.dev/selenium/web/web-form.html)

```html
<input id="my-text-id" class="form-control" name="my-text" type="text" />
```

Write the Java statement that would locate this element using its id.

You already know the pieces:

```java
driver.findElement(...);
```

and

```java
By.id(...);
```

put them together yourself.

<span style="color:red">Note -> we are skipping name selector here dont worry it works same as id.</span>

#### Now let's test locator uniqueness

This is where things get interesting.

On the Selenium Web Form page, you found:

```html
<input id="my-text-id" class="form-control" name="my-text" type="text" />
```

But there are other elements on the page that also have:

```text
class="form-control"
```

so imagine we write:

```java
driver.findElement(By.className("form-control"));
```

**What do you predict?**

Suppose 5 elements have the class form-control.

Will `findElement()`:

A) Return all 5 elements

B) Return the first matching element

C) Throw an exception because there are multiple matches

D) Randomly choose one of the 5

Pick one and explain your reasoning.

If you want to return **multiple elements that share same selector values you can user `driver.findElements()` method**.

e.g.,

```java
 List<WebElement> textInputs = driver.findElements(By.className("form-control"));

        for (WebElement we : textInputs) {
            System.out.println(we.getAttribute("type"));
        }
```

`findElements()` return the list of elements.

**Compare these**

```java
By.id("my-text-id")
```

If that **ID** uniquely identifies your target → **✅ strong**.

```java
By.className("form-control")
```

If five elements use that class → **⚠️ potentially fragile**.

### By.className()

you already saw:

```text
className("form-control")
```

But here is a subtle detail:

Suppose you HTML is:

```html
<button class="btn btn-outline-primary" type="submit">submit</button>
```

Can we write:

```java
By.className("btn btn-outline-primary")
```

Tell me:

1. Is this valid?

```java
By.className("btn")
```

2. Is this valid?

```java
By.className("btn-outline-primary")
```

3. Is this valid?

```java
By.className("btn btn-outline-primary")
```

And most importantly:

**Why?**

<span style="color:red">Note -> we are skipping tagName selector here dont worry it works same as id.</span>

### By.linkText()

Now let's look at links:

Suppose HTML is:

```html
<a href="/login">Login</a>
```

The visible text of the link is:

```text
Login
```

Selenium provides:

```java
By.linkText("Login");
```

This means:

Find a link whose visible text matches **"Login"**.

**Your turn**

Suppose the page contains:

```html
<a href="/login">Login</a>
<a href="/signup">Sign Up</a>
<a href="/help">Help</a>
```

Would this:

```java
By.linkText("Login")
```

be a relatively specific locator?

**Why?**

And what do you think would happen if we instead used:

```java
By.linkText("Log")
```

For:

```java
By.linkText("Log")
```

Selenium does **not** treat "Log" as partial text. linkText() looks for the link's **full visible text**, so it would fail to find "Login".

That's exactly why Selenium also provides:

```java
By.partialLinkText("Log")
```

which can match a link containing "Log" in its visible text.

**Mental model**:

```text
By.linkText("Login")
↓
Exact link text

By.partialLinkText("Log")
↓
Partial link text
```

### By.cssSelector

You already know this HTML:

```html
<input id="my-text-id" class="form-control" name="my-text" type="text" />
```

CSS has a syntax for selecting elements.

For an **ID**:

```css
#my-text-id
```

For a **class**:

```text
.form-control
```

So Selenium can use them through:

```java
By.cssSelector("#my-text-id");
```

or

```java
By.cssSelector(".form-control");
```

Notice the difference from the Selenium methods you already learned:

```java
By.id("my-text-id");
```

versus:

```java
By.cssSelector("#my-text-id");
```

Both can same locate the same element, but CSS gives us much more flexiblity.

#### Atrribute Selectors

This is where CSS becomes useful.

Given:

```html
<input id="my-text-id" name="my-text" type="text" />
```

we can select based on a attribute:

```html
input[name="my-text"]
```

and Selenium:

```java
By.cssSelector("input[name='my-text']");
```

Read it as:

```text
input
   ↓
element/tag

[name='my-text']
   ↓
must have this attribute/value
```

So:

```java
By.cssSelectors("input[name='my-text']");
```

means:

Find an input whose **name is my-text**.

#### Why is this useful?

Remember our earlier problem:

```java
By.tagName("input");
```

might match many inputs.

But:

```java
By.cssSelector("input[name='my-text']");
```

is much more specific.

We're combining:

```text
tag + attribute
```

instead of relying on only:

```text
tag
```

That's the beginning of **reliable locator constrution**.

#### Your turn

Use this HTML:

```html
<button class="btn btn-outline-primary" type="submit">Submit</button>
```

I want you to create a CSS selector that means:

Find a `button` whose `type` is `submit`.

Don't use `By.className()`.

### By.xpath()

**xpath** is a way of describing where an element is in the HTML/DOM tree.

one simple xpath is:

```text
//button
```

Let's break that down.

```text
// → search from anywhere in the element
button → find a button element
```

So:

```
//button
```

means find the element anywhere in the document.

So xpath can become more specific.
For example:

```
//button[@id='login']
```

Read this as:

```
//button
       ↓
       find a button

[@id='login']
       ↓
       whose id is login
```

and in Selenium:

```java
By.xpath("//button[@id='login']");
```

Notice something familiar?
You already know the HTML:

```html
id="login"
```

XPath is simply giving us a syntax for using that information.

There are multiple xpath combinations you can try:
e.g.,

```java
WebElement buttonWithXPath = driver.findElement(By.xpath("//button[text()='Submit']"));
```

Here we are locating element using xpath that says find `button` that has visible text `Submit`.

<span style="color:red">NOTE:- search on google how many way to find a single elements with xpath.</span>

#### Locator-choice exercise

On the Selenium Web Form page, suppose the Submit button has:

```html
<button class="btn btn-outline-primary" type="submit">Submit</button>
```

You could potentially use:

```java
By.tagName("button")
By.className("btn")
By.cssSelector("button[type='submit']")
By.xpath("//button[text()='Submit']")
```

**Your task**

Rank these from strongest to weakest for this particular button.

Don't worry about there being one universally correct ranking—I'm interested in your reasoning.

For each one, tell me why you consider it strong or weak.

### Now let's introduce dynamic attributes

This is an important real-world problem.

Imagine you inspect a login button today:

```html
<button id="login-847291" type="submit">Login</button>
```

Tomorrow the application generates:

```html
<button id="login-392814" type="submit">Login</button>
```

Your locator:

```java
By.id("login-847291")
```

now fails.

But this:

```java
By.cssSelector("button[type='submit']")
```

might still work.

**🧠 Your turn**

Why would you call `id="login-847291"` a **fragile locator?**

And what would you look for instead when inspecting the element?

Give me your reasoning.
