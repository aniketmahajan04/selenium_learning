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
