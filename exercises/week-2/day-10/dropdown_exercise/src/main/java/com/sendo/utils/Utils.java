package com.sendo.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

    private final WebDriverWait wait;
    private final static int DEFAULT_TIMEOUT = 10;

    public Utils(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
    }

    public WebElement waitForElementToClickable(By locator) {
        return this.wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}
