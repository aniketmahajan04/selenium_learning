# day 10 — Dropdowns

## Goal

Goal: Learn how Selenium handles native HTML `<select>` dropdowns and understand when Select works versus when you must treat a dropdown as a normal custom UI component.

**What I will learn**:

- Native HTML `<select>`
- Selenium Select
- `selectByVisibleText()`
- `selectByValue()`
- `selectByIndex()`
- Custom dropdowns

### First: What is Dropdown?

Consider HTML:

```html
<select id="country">
  <option value="in">India</option>
  <option value="us">United States</option>
  <option value="uk">United Kingdom</option>
</select>
```

The important thing is that Selenium provides a special class for interacting with this type of dropdown:

```java
Select
```

So instead of manually clicking the `<select>` and then trying to click an `<option>`, Selenium give us an cleaner abstraction.

Conceptually:

```
<select>
      ↓
Selenium Select
      ↓
choose an <option>
```

**Why does this matters**

Because not every dropdown on webpage is `<select>`.

> That's going to become very important later when we discuss custom dropdowns.

**First reasoning exercise**

Look at these two examples

**Dropdown A**

```html
<select id="country">
  <option>India</option>
  <option>USA</option>
</select>
```

**Dropdown B**

```html
<div class="dropdown">
  <button>Select Country</button>

  <div class="options">
    <div>India</div>
    <div>USA</div>
  </div>
</div>
```

**Question:**

Which one can you directly use Selenium's `Select` class with — **A, B, or both?**

And tell me **what you would inspect in DevTools to decide whether Select can be used**.

**Now your First `Select` question**

Suppose we have:

```html
<select id="country">
  <option value="in">India</option>
  <option value="us">United States</option>
  <option value="uk">United Kingdom</option>
</select>
```

And in Java:

```java
WebElement countryDropdown = driver.findElement(By.locator("country"));
Select select = new Select(countryDropdown);
```
