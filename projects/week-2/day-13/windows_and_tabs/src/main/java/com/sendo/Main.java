package com.sendo;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    static void main() {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://demoqa.com/browser-windows?utm_source=chatgpt.com");

            String currentWindowHandle = driver.getWindowHandle();

            driver.findElement(By.id("tabButton")).click();

            Set<String> allWindowHandles = driver.getWindowHandles();

            for (String window : allWindowHandles) {
                System.out.println(window);
                if (!currentWindowHandle.equals(window)) {
                    driver.switchTo().window(window);
                }
            }

            System.out.println(driver.getCurrentUrl());

        } finally {
            driver.quit();
        }

    }
}
