package com.sendo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://www.selenium.dev/selenium/web/dynamic.html?utm_source=chatgpt.com");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement revealInput = driver.findElement(By.id("reveal"));

            revealInput.click();

            WebElement revealedInput = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("revealed")));

            System.out.println("Test Successfull!");

        } finally {
            driver.quit();
        }
    }
}