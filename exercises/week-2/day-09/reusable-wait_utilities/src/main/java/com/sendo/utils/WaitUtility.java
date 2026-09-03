package com.sendo.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

    private static final int DEFAULT_TIMEOUT = 10;
    private final WebDriverWait wait;

    public WaitUtility(WebDriver driver) {
        // this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        this(driver, DEFAULT_TIMEOUT); // this is the constructor chaining
    }

    public WaitUtility(WebDriver driver, int timeoutInSeconds) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }

    public WebElement waitForElementVisibility(By locator) {
        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementClickable(By locator) {
        return this.wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean waitForUrlContains(String value) {
        return this.wait.until(ExpectedConditions.urlContains(value));
    }

    public boolean waitForTitleContains(String value) {
        return this.wait.until(ExpectedConditions.titleContains(value));
    }

    public boolean waitForTextToBePresentInElementLocated(By locator, String text) {
        return this.wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public boolean waitForOptionToBeSelected(By locator, String option) {
        return this.wait.until(ExpectedConditions.elementToBeSelected(locator));
    }
}
