Day 7 — Week 1 Project: Search Automation

Goal: Bring together everything you've learned in Days 1–6 into one small Selenium project.

out curriculum says Day 7 as a Search Automation project: open a search engine/test site, locate the search input, enter a search term, submit it, verify the title and URL/results, close the browser, and then refactor the code.

#### **Part 1 — Think Like an Automation Engineer**

Before writing code, let's decide **what we actually want to test**.

Suppose our test scenario is:

Search for `Selenium WebDriver` and verify that the search was successful.

A human tester might do:

```text
Open search engine
↓
Find search box
↓
Type "Selenium WebDriver"
↓
Submit search
↓
Look at results
↓
Verify search succeeded
```

Your Selenium test should represent that workflow.

But there's an important distinction:

**Actions vs Verification**

These are **actions**:

Open page
Find input
Type text
Click button

But this is **verification**:

Did the expected thing actually happen?

You've already performed actions throughout Days 1–6.

Today I want you to start thinking like a **test automation engineer**, where an automated test isn't successful merely because Selenium managed to click something.

#### First challenge — Design the test

Before touching Selenium code, answer these:

1.

What website would you choose for this project?

You can use Google, Bing, DuckDuckGo, or another search/test website.

2.

What element do you need to locate to perform the search?

3.

What Selenium interaction will you use to enter:

Selenium WebDriver 4.

How will you submit the search?

Think about the HTML and Selenium methods you've already learned.

5.

After submitting, what two things could you verify to determine whether the search succeeded?

Don't write code yet.

I want you to design the test first, just like an automation engineer would before implementing it.

#### Day 7 — Final Project Challenge

You've built the core search workflow. Now I want you to put it together as a **complete program yourself**.

Requirements:

1. Create `WebDriver`.
2. Use `try/finally`.
3. Open DuckDuckGo.
4. Locate the search box.
5. Search for `"Selenium WebDriver"`.
6. Press `ENTER`.
7. Get the title.
8. Get the URL.
9. Verify both using `&&`.
10. Print whether the search test passed.
11. Quit the browser in `finally`.

**One additional requirement**

Make your code readable.
