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

Now you want to select United States.

There are three methods:

```java
select.selectByVisibleText(...);
select.selectByValue(...);
select.selectByIndex(...);
```

**Your task**: Which method would you choose, and what argument would you pass?

**Your next challenge**

Consider this dropdown:

```html
<select id="language">
  <option value="1">English</option>
  <option value="2">हिन्दी</option>
  <option value="3">मराठी</option>
</select>
```

You need to select `मराठी`.

As a QA, which of these would you choose and **why?**

```java
select.selectByVisibleText("मराठी");
```

or

```java
select.selectByValue("3");
```

Think about **test stability and maintainability**, not just which one works.

##### One more thing before `selectByIndex()`

Suppose the requirement says:

> "Select the third option in the dropdown."

Now the test isn't asking for a particular country or language. It's explicitly asking for a **position**.

Which method would you use?

```java
select.selectByVisibleText(...);
select.selectByValue(...);
select.selectByIndex(...);
```

and **why?**

### Custom Dropdown

Now comes the important real-world case: **custom dropdowns**.

Consider this HTML:

```html
<div class="dropdown">
  <button>Select Country</button>

  <div class="options">
    <div>India</div>
    <div>USA</div>
    <div>UK</div>
  </div>
</div>
```

There is no `<select>` element here:

Therefore:

```java
Select select = new Select();
```

<span style="color:red">❌</span> will not work?

Instead, Selenium treats this as ordinary web elements.

The interaction would conceptually be:

1. Find the dropdown button.
2. Click it.
3. Wait for the options to appear.
4. Find the required option.
5. Click that option.

For example, the automation flow might look conceptually like:

```
Click "Select Country"
        ↓
Options become visible
        ↓
Find "India"
        ↓
Click "India"
```

**Your turn**

Imagine this custom dropdown:

```html
<div id="countryDropdown">
  <button>Select Country</button>

  <div class="options">
    <div class="option">India</div>
    <div class="option">USA</div>
    <div class="option">UK</div>
  </div>
</div>
```

The requirement is:

> Select India from the dropdown.

As a QA automation engineer, tell me **what Selenium actions you would perform in what order**.

**Your next challenge**

Suppose the custom dropdown behaves like this:

```
1. Click "Select Country"
2. Options appear with an animation
3. "India" becomes clickable only after the animation finishes
```

You have these two choices:

**A**

```java
wait.until(ExpectedConditions.visibilityOfElementLocated(
    By.xpath("//div[text()='India']")
));
```

**B**

```java
wait.until(ExpectedConditions.elementToBeClickable(
    By.xpath("//div[text()='India']")
));
```

Which would you choose **for the actual click**, and **why?**
