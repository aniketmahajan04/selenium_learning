# Day 5 — XPath

## Goal

Goal: Learn to construct XPath expressions yourself and understand when XPath is useful.

### What I will learn:

- Absolute XPath
- Relative XPath
- Attribute XPath
- Text XPath
- `contains()`
- `starts-with()`
- `normalize-space()`
- `and` / `or`
- Parent and child relationships
- Following sibling
- Preceding sibling

We already touched basic XPath during Day 3, so I won't waste time reteaching things you demonstrated successfully.

### Absolute vs Relative XPath

You already know this:

```text
//input[@id='my-text-id']
```

This is **relative XPath**.

The importand question is: **relative to what?**

Let's first understand the other type.

Imagine this DOM:

```html
<html>
  <body>
    <div>
      <form>
        <input id="username" />
      </form>
    </div>
  </body>
</html>
```

An absolute XPATH could describe the entire route:

```text
/html/body/div/form/input
```

It starts at the root:

```text
/
↓
html
↓
body
↓
div
↓
form
↓
input
```

A relative XPath can simply say:

```
//input[@id='my-text-id']
```

Meaning:

Search through the document for an `input` whose ID is `username`.

**Why does the curriculum specifically tell you to understand why relative XPath is generally preferred?**

Because imagine the developer changes:

```html
<div>
  <form></form>
</div>
```

to:

```text
<section>
    <div>
        <form>
```

The absolute path:

```text
/html/body/div/form/input
```

may break because the DOM hierarchy changed.

But:

**That's why professional Selenium code generally avoids unnecessarily long absolute XPath expressions.**

### XPATH `contains()`

Suppose an element has a dynamic ID:

```html
<input id="user-input-847291" />
```

and tomorrow it becomes:

```html
<input id="user-input-392817" />
```

we already know this is fragile:

```java
By.id("user-input-847191");
```

But notice that the **stable part** is:

```text
user-input-
```

XPATH's `contains()` allows us to say:

```text
//input[contains(@id, 'my-input-')]
```

Read it as:

```text
contains(
    @id,
    'user-input-'
)
```

The `id` attribute contains `user-input-`.

So it can survive changes to the dynamic portion.

**Now let's apply `contains()` with text**

You already learned:

```
//button[text()='submit']
```

that's and **exact text match**:

But imagine:

```html
<button>Submit Form</button>
```

This would **not** match:

```
//button[text()='Submit']
```

because the complete text is `Submit Form`.

instead we can use:

```
//button[contains(text(), 'Submit')]
```

Meaning:

Find a button whose text is `"Submit"`.

This could match:

```
Submit       ✅
Submit Form  ✅
Submit Now   ✅
```

### XPath `starts-with()`

It's similar to the CSS operator you learned yesterday:

```text
CSS:    [id^='user']
XPath:  starts-with(@id, 'user')
```

Suppose:

```html
<input id="user-email-93821" />
```

You can write:

```
//input[starts-with(@id, 'user-email')]
```

Meaning:

Find an `input` whose `id` **starts with** `user-email`.

**Compare**

CSS:

```
input[id^='user-email']
```

XPATH:

```
//input[starts-with(@id, 'user-email)]
```

Same general idea, different syntax.

### XPath `normalize-space()`

This is useful when the text has extra whitespace.

Suppose the html is:

```html
<button>Submit</button>
```

The visible text may contains surrounding whitespace/newline.

instead of:

```text
//button[text()='Submit']
```

we can use:

```text
//button[normalize-space()='Submit']
```

`normalize-space()` removes leading/trailing whitespace and normalize whitespace inside the text.

### XPath Relationship

Suppose the DOM is:

```html
<div class="user">
  <label>Username</label>
  <input name="username" />
</div>
```

If we locate the `input`, we can move **up to its parent** using:

```text
//input[@name='username']/parent::div
```

Read it as:
Find the username input → move to its parent `div`.

You can also use:

```text
//input[@name='username']/parent::*
```

Where `*` means any parent.

<span style="color:red">NOTE:- It only travel up to parent you cannot travel to ancestor</span>

### Child Relationship

Starting with:

```html
<div class="field">
  <label>Username</label>
  <input name="username" />
</div>
```

If we locate the `div`, we can not **down to its child elements**.

For example:

```text
//div[@class='field']/child::input
```

means:

Find the `div` with class `field`, then find its child `input`.

### Following sibling

Now consider:

```html
<div class="field">
  <label>Username</label>
  <input name="username" />
</div>
```

The `label` and `input` are **siblings** because they have the same parent:

```
div.field
├── label
└── input
```

XPath can move from one sibling to another.

For example:

```
//label[text()='username']/following-sibling::input
```

means:

Find the `label` whose text is `username`, then move to its following sibling `input`:

### Preceding siblings

There is the opposite sibling direction:

```
//input[@name='password']/preding-sibling::label
```

This means:

Find the password input, then move to the sibling that comes **before** it.

Given:

```html
<div class="field">
  <label>Password</label>
  <input name="password" />
</div>
```

the relationship is:

```
label  →  input
  ↑         ↑
preceding   following
 sibling    sibling
```
