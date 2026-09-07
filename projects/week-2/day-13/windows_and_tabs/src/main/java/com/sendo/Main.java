package com.sendo;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Main {
    static void main() {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://demoqa.com/browser-windows?utm_source=chatgpt.com");

            // Set<String> currentWindowHandle = driver.getWindowHandles();
            // driver.findElement(By.id("tabButton")).click();

            // Set<String> allWindowHandles = driver.getWindowHandles();

            // for (String window : allWindowHandles) {
            // System.out.println(window);
            // if (!currentWindowHandle.equals(window)) {
            // driver.switchTo().window(window);
            // }
            // }

            // String beforeHandle = driver.getWindowHandle();

            // Set<String> afterHandle;

            // driver.findElement(By.id("tabButton")).click();

            // afterHandle = driver.getWindowHandles();

            // for (String handle : afterHandle) {
            // System.out.println(handle);
            // }

            // afterHandle.remove(beforeHandle);

            // for (String handle : afterHandle) {
            // driver.switchTo().window(handle);

            // }

            // IO.println(driver.getCurrentUrl());

            // driver.close();
            // driver.switchTo().window(beforeHandle);

            // IO.println(driver.getCurrentUrl());

            WebElement buttonWithMouseAction = driver.findElement(By.id("tabButton"));

            Actions action = new Actions(driver);

            action.moveToElement(buttonWithMouseAction).click();
        } finally {
            // driver.quit();
        }

    }
}
