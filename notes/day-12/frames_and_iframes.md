# Day 12 — Frames / iFrames

## Goal

Understand why an iframe creates a separate browsing context and how Selenium switches into it and back out.

**What I will learn**:

- What an iframe is
- Why Selenium cannot directly access its contents
- `driver.switchTo().frame(...)`
- `driver.switchTo().defaultContent()`
- Nested frames

### What is an iframe?

```
Main Page
│
├── Header
├── Login form
├── Product list
│
└── iframe
     │
     ├── Email input
     ├── Password input
     └── Submit button
```

**What is an iframe?**

An iframe (`<iframe>`) allows one HTML document to be embedded inside another html document.

For example:

```html
<iframe src="login.html"></iframe>
```

The important part for Selenium that iframe has its **own browsing content**.

If the element you want is inside the iframe, Selenium cannot simply do:

```java
driver.findElement(...);
```

from the main page context.

You first need to tell Selenium:

> "Switch into this iframe."

That's what this does:

```java
driver.switchTo().frame();
```

**Before we write any code**

Consider this HTML:

```html
<html>
  <body>
    <button id="mainButton">Main Page Button</button>

    <iframe id="paymentFrame">
      <html>
        <body>
          <input id="cardNumber" />
        </body>
      </html>
    </iframe>
  </body>
</html>
```

Suppose you're currently on the main page and try:

```java
driver.findElement(By.id("cardNumber"));
```

**Why do you think Selenium won't be able to find `cardNumber`?**

##### <span style="color:red">This is very important discussion here so please read it;</span>

My ans:

```
Because its iframe html thats why we should first find to iframe then we can locate
```

The important detail is **why?**

An `<iframe>` contains a **separate browsing context/document**. Selenium currently operating in the **main page's browsing context**, so it cannot search inside the iframe until you switch it to it.

Think of it like:

```
Main Page
│
├── button#mainButton       ← Selenium can access this
│
└── iframe#paymentFrame
     │
     └── input#cardNumber   ← Selenium cannot access yet
```

So the professional flow is:

```
1. Locate the iframe
        ↓
2. Switch into the iframe
        ↓
3. Locate/interact with elements inside it
```

And the Selenium operation for step 2 is:

```java
driver.switchTo().frame();
```

**The one important distinction**

You **don't necessarily "find the iframe, then locate its HTML".**

You find the **iframe element itself**, then tell Selenium:

> "From now on, search inside this iframe."

For example:

```java
WebElement frame = driver.findElement(By.id("paymentFrame"));
driver.switchTo().frame(frame);
```

After this, something like:

```java
driver.findElement(By.id("cardNumber"));
```

can work because Selenium's current context is now the iframe.

**Your turn**

Suppose we do:

```java
driver.switchTo().frame(frame);
driver.findElement(By.id("cardNumber")).sendKeys("1234");
```

Now we want to interact with:

```html
<button id="mainButton">Pay</button>
```

which is **outside the iframe**, back on the main page.

**What do you think we need to do before finding `mainButton`?**

##### <span style="color:red">This also is very important discussion here so please read it;</span>

My Response:

```
I think we switch out to frame. i have doubt also suppose what happen if i have located button before switching to frame and then use it after i send keys does selenium support that
```

My explanation:

Yes — exactly. To interact with `mainButton` again, you need to **switch back to the main page**:

```java
driver.switchTo().defaultContent();
```

Then you can locate/interact with `mainButton`.

**My doubt is very good:**

Suppose you locate the button before entering the iframe:

```java
WebElement mainButton = driver.findElement(By.id("mainButton"));

WebElement frame = driver.findElement(By.id("paymentFrame"));
driver.switchTo().frame(frame);

driver.findElement(By.id("cardNumber")).sendKeys("1234");

driver.switchTo().defaultContent();

mainButton.click();
```

**Yes, Selenium supports this. <span style="color:green">✅</span>**

Why?

Because `mainButton` is already a `WebElement` reference to an element in the **main page**. Switching into the iframe changes Selenium's **current browsing context**, but it doesn't automatically invalidate every `WebElement` you previously located.

Think of it like:

```
mainButton → reference to element on Main Page

Switch into iframe
      ↓
Selenium searches inside iframe now

switch back to main page
      ↓
mainButton → can be used again
```

**But there's an important professional caveat ⚠**

A `WebElement` reference can become invalid if the page/DOM changes and that particular element is removed or recreated. Then Selenium can throw:

```
StaleElementReferenceException
```

So don't learn the rule as:

> "Once I locate an element, I can always use it later."

Instead, the professional rule is:

> **A WebElement remains usable as long as the underlying DOM element it refers to still exists and hasn't become stale.**

And one more subtle point: **you generally need to be in correct browsing context when interacting with the element**. So your `mainButton` example works because you switch back to `defaultContent()` before clicking it.

### Switching into an iframe

These are **Three common ways** Selenium can switch into a frame:

```java
driver.switchTo().frame();
```

The `...` can be:

**1.** A `WebElement`
**2.** A frame index
**3.** A frame name/id

We'll learn them in that order because `WebElement` **is the approach I want you to become most comfortable with first**.

**1. Using the iframe `WebElement`**

For example:

```java
WebElement frame = driver.findElement(By.id("paymentFrame"));
```

After this:

```java
driver.findElement(By.id("cardNumber"));
```

searches inside `paymentFrame`, not the main page.

**Now let's reason about it**

Imagine this page:

```html
<iframe id="loginFrame">
  <!-- separate document -->
  <input id="username" />
  <input id="password" />
</iframe>

<button id="submit">Submit</button>
```

And you write:

```java
WebElement frame = driver.findElement(By.id("loginFrame"));
driver.switchTo().frame(frame);

driver.findElement(By.id("username")).sendKeys("Sendo");
```

That makes sense.

But now suppose you want to find:

```java
driver.findElement(By.id("submit"));
```

**What do you think will happen if you try that immediately, without switching back?**
