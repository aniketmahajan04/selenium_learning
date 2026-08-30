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
