package com.sendo.utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

    private final WebDriverWait wait;
    private static final int DEFAULT_TIMEOUT = 10;

    public Utility(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
    }

    public Alert waitForThAlert() {
        return this.wait.until(ExpectedConditions.alertIsPresent());
    }

}
