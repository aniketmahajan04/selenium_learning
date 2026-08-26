# Day-2 - HTML, DOM and Web Elements

## Goal

Understand the structure of web page well enough that you can look at HTML and reason about what selenium can interact with.

### What I will learn

- HTML basics
- DOM
- HTML elements
- Attributes
- `id`, `class`, `name`, `type`, `value`, `placeholder`
- Parent/child relationships
- Sibling Relationships
- Inspecting elements with browser DevTools

### HTML

Before Selenium can interact with a webpage, you need to understand **what is selenium interacting with**.

Considering this simpel HTML:

```html
<button id="login-button" class="primary-button" type="submit">Login</button>
```

A normal human will see a login button but Selenium sees a **web element** represent by html.

<span style="color:red">NOTE:- I am skipping HTML basics here.</span>

### Why HTML matters for Selenium

Suppose Selenium need to interact with this:

```html
<input id="email" class="userEmail" type="email" />
```

A human can look at the page and think:

```text
That's the email field.
```

But Selenium needs a **way to identify that exact element**.

e.g.,

```java
driver.findElement(By.id("email"));
```

Notice what happened:

```text
HTML
 ↓
id="email"
 ↓
Selenium locator
 ↓
By.id("email")
 ↓
WebElement
```

### DOM (Document Object Model)
