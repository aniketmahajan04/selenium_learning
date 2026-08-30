# Day 6 — WebDriver and WebElement

## Goal:

Move from finding elements to actually **interacting with them and inspecting their state**.

**WebDriver**

- `driver.get()`
- `driver.getTitle()`
- `driver.getCurrentUrl()`
- `driver.navigate()`
- `driver.close()`
- `driver.quit()`

**WebElement**

- `click()`
- `sendKeys()`
- `clear()`
- `getText()`
- `getAttribute()`
- `isDisplayed()`
- `isEnabled()`
- `isSelected()`

`WebDriver.navigate()`

You've already used:

```java
driver.get("https://www.selenium.dev/selenium/web/web-form.html");
```

Now Selenium provides another way to control navigation:

```java
driver.navigate().to("https://www.google.com");
```

At first glance, they look almost identical.

```java
driver.get(url);
```

vs.

```java
driver.navigate().to(url);
```

For a simple page navigation, both navigate the current browser window to the specified URL.

But `navigate()` gives you additional browser-navigation operation:

```java
driver.navigate().back();
driver.navigate().forward();
driver.navigate().refresh();
```

Think of it as Selenium giving you access to the browser's navigation controls:

```text
        WebDriver
            │
       navigate()
      /     |      \
    to()  back()  forward()
                  refresh()
```

**Example**

```java
driver.get("https://www.google.com");

driver.navigate().to("https://www.selenium.dev");

driver.navigate().back();

driver.navigate().forward();

driver.navigate().refresh();
```

### WebElement.click()

Now we're moving from controlling the **browser** to controlling an **element**.

You already know how to locate the element:

```java
WebElement button = driver.findElement(By.cssSelector("button[type='submit']"))
```

But finding it doesn't means interacting with it:

`WebElement` gives us:

```java
button.click();
```

Conceptually:

```text
WebDriver
   │
   └── findElement()
          ↓
     WebElement
          │
          └── click()
```

So:

```java
WebElement button = driver.findElement(By.cssSelector("button[type='submit']"));
button.click();
```

means:

1. Selenium searches the DOM.
2. It get a reference to the button.
3. `click()` asks the browser to perform a click on that element.

This distinction is important:

```java
driver.findElement(...);
```

**finds** the element.

```java
element.click();
```

**Your exercise**

Use the Selenium Web Form:

```text
https://www.selenium.dev/selenium/web/web-form.html
```

Find the **Submit** button using a locator you've already learned, then click it.

Don't use XPath unless you want to—choose what you think is the best locator.

Write only the relevant code:

WebElement submitButton = ...;
submitButton.click();

Then tell me **which locator you chose and why**.

**Now actually write it**

For the Selenium Web Form, create the WebElement for the Submit button and call:

```java
click()
```

Then tell me:

**What do you expect to happen to the page after clicking Submit?**

**Your exercise**

Write code that:

**1.** Opens the Selenium Web Form.
**2.** Finds the Submit button using your CSS selector.
**3.** Clicks it.
**4.** Prints the **current URL** after submission.

### sendKeys()

Let's understand how to interact with inputs fields.

Take this input field as example:

```html
<input id="my-text-id" name="my-text" type="text" />
```

You can type into it with:

```java
WebElement textInput = driver.findElement(By.id("my-text-id"));
textInput.sendKeys("Hello Selenium");
```

**Your turn**

Using the Selenium Web Form:

**1.** Find the text input using `By.id("my-text-id")`.
**2.** Type:

```
Hello Selenium
```

**3.** Then retrieve its value using getAttribute("value").
**4.** Print it.

Don't just assume getText() will give you the typed value—**reason about which attribute actually stores the input's value**.

### `clear()`

Now let's say the field already contains:

```text
Hello Aniket
```

and you want to replace it with:

```text
Selenium
```

You could do:

```java
textInput.clear();
textInput.sendKeys();
```

### `getText()` vs `getAttribute()`

This distinction is very important in real automation.

Consider:

```html
<input id="username" value="Sendo" />
```

and:

```html
<button>Login</button>
```

For the button:

```java
button.getText();
```

makes sense because `Login` is **text inside the element**.

For the input:

```java
textInput.getAttribute("value");
```

### `isDisplayed()`, `isEnabled()`, `isSelected()`

These three methods are about **element state**.

Imagine:

```html
<input id="username" />
<input id="disabled" disabled />
<input type="checkbox" id="remember" />
```

Selenium lets you ask question about those elements.

`isDisplayed()`:

```java
element.isDisplayed();
```

is this element currently displayed/visible?

`isEnabled()`

```java
element.isEnabled();
```

Can this element currently be interacted with/enabled?

For example, a disabled button:

```html
<button disabled>Submit</button>
```

would report:

```java
button.isEnabled();
```

`isSelectd()`

```java
element.isSelected();
```

Primarily useful for selectable elements such as:

- checkbox
- radio button
- `<option>` elements

For example:

```html
<input type="checkbox" id="remember" />
```

If it's checked:

```java
element.isSelected(); // true
```

If it's unchecked:

```java
element.isSelected(); // false
```
