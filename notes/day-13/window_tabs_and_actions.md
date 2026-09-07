# Day 13 — Windows, Tabs and Actions

## Goal

Learn how Selenium handles multiple browser window/tabs and begin working the Actions API for advanced mouse and keyboard interactions.

**What I will learn**:

- Window handles
- Current windows
- Switching windows
- Multiple tabs
- Actions API
- Hover
- Right click
- Double click
- Drag and drop
- Keyboard actions

### Window and Tabs

Let's start with the most important concept: **window handles**.

When Selenium creates a browser session, the browser has a window/tab. Selenium gives each browser window a unique identifier called a **window handle**.

You can get the current window's handle with":

```java
String currentWindow = driver.getWindowHandle();
```

And all currently open windows/tabs with:

```java
Set<String> windows = driver.getWindowHandles();
```

Think of it like:

```
Browser session
│
├── Tab A → "ABC123"
├── Tab B → "XYZ789"
└── Tab C → "PQR456"
```

Selenium doesn't primary think:

> "My current window handle is XYX789."

And to move between them:

```java
driver.switchTo().window(handle);
```

**Why do we need this?**

Suppose your test does this:

```
Login page
     ↓
Click "Open Help"
     ↓
New tab opens
     ↓
Need to test Help page
```

Selenium **doesn't automatically start operating on the new tab** just because it opened.

You need to explicitly switch Selenium's current window.

This is similar to what you learned yesterday with frames:

```
Frames:
switchTo().frame(...)
switchTo().defaultContent()

Windows/Tabs:
switchTo().window(...)
```

The underlying idea is similar:

> **Selenium has a current browsing context, and you explicitly change it when necessary.**

**Your first reasoning question**

Suppose this is the situation:

```
Tab A ← Selenium is currently here

Click button

Tab B opens
```

And we execute:

```java
Set<String> handles = driver.getWindowHandles();
```

What do you think handles contains?

**A.** Only Tab A's handle
**B.** Only Tab B's handle
**C.** Both Tab A and Tab B handles

And tell me **why?**

**Now let's test your understanding**

Suppose there are 3 tabs:

```
Tab A → current
Tab B
Tab C
```

You run:

```java
String current = driver.getWindowHandle();
Set<String> all = driver.getWindowHandles();
```

Which one contains **only the handle of Tab A?**

A. `all`
B. `current`
C. Both
