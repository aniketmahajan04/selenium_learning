# Day-4 CSS Selectors

## Goal

By the end of Day 4, I will look at the HTML and be able to construct a CSS selector myself rather than relying on DevTools' generated selector.

### What I will learn:

- ID selectors
- Class selectors
- Atrribute selectors
- Descendant selectors
- Child selectors
- Multiple attributes
- `^=`
- `$=`
- `*=`
- Combining selectors

I've already used CSS once:

```java
By.cssSelector("input[name='my-text'][type='text']")
```

Today we're going to understand **why that works** and build from there.

### ID CSS selectors

You already know this HTML from the Selenium Web Form:

```html
<input id="my-text-id" class="form-control" name="my-text" type="text" />
```

CSS uses `#` to select an element by ID:

```text
#my-text-id
```

Therefore Selenium can use:

```java
By.cssSelector("#my-text-id");
```

Compare that with what you already know:

```java
By.id("my-text-id);
```

Both can locate the same element.

**Why learn the CSS version if `By.id()` already exits?**
Because CSS doesn't stop at IDs.

You can start with:

```
#my-text-id
```

and then construct much more expressive selectors when necessary.

### Class selectors

Remenber this:

```html
<input class="form-control" />
```

CSS uses `.` for a class:

```css
.form-control
```

So:

```java
By.cssSelectors(".form-control");
```

means:
Find an element having the `form-control` class.

Compare:

```java
By.className("form-control");
```

with:

```java
By.cssSelector(".form-control");
```

Both can find elements having that class.
But CSS let us combine selectors.

For example, your earlier button:

```html
<button class="btn btn-outline-primary" type="submit">Submit</button>
```

has **two classes**.

CSS can express:

```text
.btn.btn-outline-primary
```

Notice:

```text
.btn
   ↓
has btn

.btn-outline-primary
   ↓
AND has btn-outline-primary
```

No space between them.

That's something `By.className()` connot express directly.

### Attrubute selectors

You've already used this:

```text
input[name='my-text']
```

This means:
Find an `input` whose `name` attribute is exactly `my-text`.

So there are two ideas:

```
[name='my-text']
       ↓
specific attribute value

[name]
       ↓
attribute exists
```

### Multiple attributes

You already accidentally discovered this one earlier:

```
input[name='my-text'][type='text']
```

This means:

Find an `input` whose `name` is `my-text` **AND** whose `type` is `text`.

Each [...] adds another condition to the same element.

For example:

```html
<input name="my-text" type="text" />
<input name="my-text" type="password" />
<input name="other" type="text" />
```

Then:

```
input[name='my-text'][type='text']
```

matches only:

```html
<input name="my-text" type="text" />
```

This is **multiple attribute**.

### Descendant selectors

Now we introduce something different.

Consider:

```html
<div class="login-form">
  <input name="username" />
  <div>
    <input name="password" />
  </div>
</div>
```

The CSS selector:

means:

Find an input **somewhere inside** `.login-form`.

That space means **descendant**.

### Child selector

Now compare that with:

```html
.login-form > input
```

The `>` means:

Find an input that is a **direct child** of `.login-form`.

Using our HTML:

```html
<div class="login-form">
  <input name="username" />
  <div>
    <input name="password" />
  </div>
</div>
```

This:

```html
.login-form input
```

can find **both** inputs.

But:

```
.login-form > input
```

finds only:

```text
username
```

because `password` is inside another `<div>`.

**Remember**:

```text
A B
```

→ B is anywhere inside A.

```text
A > B
```

→ B is a **direct child** of A.

#### Exercise — combining selectors

Now let's use your real Selenium Web Form knowledge.

Suppose we have:

```html
<div class="mb-3">
  <label for="my-text-id" class="form-label">Text input</label>
  <input id="my-text-id" name="my-text" class="form-control" type="text" />
</div>
```

We want a CSS selector that says:

Find the `input` with class `form-control` whose `name` is `my-text`.

You already know all three pieces:

```
input
.form-control
[name='my-text']
```

<span style="color:green">IMP:- we can combine multiple attribute without giving spaces but if we give spaces then its meaning is we are accessing descending elements</span>

### ^=, $=, \*=

These are attribute-value matching operators.

Suppose we have:

```html
<input name="user-email" />
<input name="user-password" />
<input name="admin-email" />
```

`^=` **— start with**

```html
input[name^='user']
```

Matches:

```text
user-email
user-password
```

because both **start with** `user`.

`$=` **— ends with**

```html
input[name$='email']
```

Matches:

```text
user-email
admin-email
```

because both end with email.

`*=` **— contains**

```html
input[name*='email']
```

Also matches both email fields because `email` occurs somewhere inside the value.
\*= — contains

input[name*='email']

Also matches both email fields because email occurs somewhere inside the value.

**Your turn**

Using:

```html
<input name="user-email" />
<input name="user-password" />
<input name="admin-email" />
```

Which selector would match **both email inputs but not the password input**?

And this time, don't just give me A/B/C. Write the actual Selenium expression:

```java
By.cssSelector("...")
```

**One more concept: combining everything**

Now we're going to combine:

- descendant selectors
- classes
- attributes
- multiple conditions

Suppose we have:

```html
<div class="login-form">
  <div class="field">
    <input name="username" type="text" />
  </div>

  <div class="field">
    <input name="password" type="password" />
  </div>
</div>
```

We want **only the password input**.

One possible selector is:

```html
.login-form input[name='password']
```

Read it from left to right:

```
.login-form
↓
inside login-form

input
↓
find an input

[name='password']
↓
whose name is password
```

This is a combined selector.

**Day 4 Knowledge Check**

Before we do the required 15-element practical exercise, let's verify the concepts.

Answer these in your own words:

1.  What's the difference between:

```html
.login-form input
```

and:

```html
.login-form > input
```

2.  What does this mean?

```html
input[name^='user']
```

And what is the difference between `^=`, `$=`, and `\*=`?

3.  What does this selector mean?

```html
input.form-control[name='my-text']
```

4.  If you have a unique, stable:

```html
<input id="username" />
```

would you prefer:

```java
By.cssSelector("#username")
```

or:

```java
By.cssSelector("div.login-form input.form-control[name='username'][type='text']")
```

and **why**?

5.  What does the space between two selectors mean in CSS?

For example:

```html
.login-form input
```
