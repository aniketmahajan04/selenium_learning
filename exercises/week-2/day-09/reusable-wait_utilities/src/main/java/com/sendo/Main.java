package com.sendo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sendo.utils.WaitUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
    public static WebElement waitForElementVisibility(By locator, WebDriverWait wait) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://www.selenium.dev/selenium/web/dynamic.html?utm_source=chatgpt.com");

            // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement revealButton = driver.findElement(By.id("reveal"));

            revealButton.click();

            // WebElement revealedButton = waitForElementVisibility(By.id("revealed"),
            // wait);
            WaitUtility waitUtils = new WaitUtility(driver);
            WebElement revealedButton = waitUtils.waitForElementVisibility(By.id("revealed"));

            System.out.println("Revealed is visible");

        } finally {
            driver.quit();
        }
    }
}
