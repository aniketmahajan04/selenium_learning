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
