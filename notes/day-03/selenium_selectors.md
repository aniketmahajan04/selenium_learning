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
