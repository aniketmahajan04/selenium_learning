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

Don't let the name scare you.

Imagine this HTML:

```html
<html>
  <body>
    <h1>Login</h1>

    <form>
      <input id="username" />
      <input id="password" />
    </form>
  </body>
</html>
```

Browser doesn't keep this as flat block of text but it builds a **tree like representation** of the document.

Conceptually:

```text
html
└── body
    ├── h1
    │   └── "Login"
    │
    └── form
        ├── input#username
        ├── input#password
        └── button
            └── "Login"
```

this tree is the basic idea behind the **DOM**.

##### Why does Selenium care about the DOM?

Because Selenium interacts with **elements in the browser's document**.

For example:

```text
DOM
 │
 ├── input
 ├── button
 ├── link
 └── form
       ↓
   Selenium finds
       ↓
   WebElement
```

So we eventually write:

```java
// Don't worry about this we didn't introduced findElement yet
WebElement button = driver.findElement(...);
```

### Inspecting the DOM with DevTools

Open Chrome and go to a simpel page such as:

```text
https://google.com
```

Then:
**Right-click somewhere on page → Inspect**

You should see Chrome DevTools.

Look for the **Element** tab.

You'll see HTMl similar to what we've been studying:

```html
<html>
  <body>
    ...
  </body>
</html>
```

**Your first real-world exercise**
Find the Google search input using DevTools.

Don't use Selenium yet.

Tell me:

1. What **HTML tag** is the search field?
2. What name attribute does it have, if present?
3. What class attribute does it have, if present?
4. Does it have an id?
5. What other useful attribute do you notice?
