package com.sendo;

import java.security.Key;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

            // WebElement buttonWithMouseAction = driver.findElement(By.id("tabButton"));

            // Actions action = new Actions(driver);

            // action.moveToElement(buttonWithMouseAction).click();
            // action.contextClick(buttonWithMouseAction).perform();
            // action.doubleClick(buttonWithMouseAction).perform();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // WebElement interactionsHeader = wait.until(ExpectedConditions
            // .elementToBeClickable(By.xpath("//div[normalize-space(text())='Interactions']/parent::div")));

            // interactionsHeader.click();

            // WebElement interactionsContent =
            // wait.until(ExpectedConditions.visibilityOfElementLocated(
            // By.xpath(
            // "//div[text()='Interactions']/parent::div/parent::span/following-sibling::div")));

            // WebElement droppableLink =
            // wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
            // "a[href='/droppable']")));
            // droppableLink.click();

            // WebElement draggableBlock =
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggable")));

            // WebElement droppableBlock =
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("droppable")));

            // Actions actions = new Actions(driver);

            // //
            // actions.clickAndHold(draggableBlock).moveToElement(droppableBlock).release().perform();
            // actions.dragAndDrop(draggableBlock, droppableBlock).perform();

            WebElement elementsHeader = driver
                    .findElement(By.xpath("//div[normalize-space(text())='Elements']/parent::div"));

            elementsHeader.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[text()='Elements']/parent::div/parent::span/following-sibling::div")));

            WebElement textBoxLink = wait
                    .until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/text-box']")));
            textBoxLink.click();

            WebElement fullNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
            fullNameInput.click();
            Actions action = new Actions(driver);
            action.sendKeys(fullNameInput, "Selenium").perform();
            action.sendKeys(Keys.TAB).perform();
        } finally {
            // driver.quit();
        }

    }
}
