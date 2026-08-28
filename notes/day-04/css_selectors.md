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
