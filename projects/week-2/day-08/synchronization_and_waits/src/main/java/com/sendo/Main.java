package com.sendo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://www.selenium.dev/selenium/web/dynamic.html?utm_source=chatgpt.com");

            WebElement button = driver.findElement(By.id("adder"));

            // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            button.click();

            // WebElement div = driver.findElement(By.id("box0"));
            // System.out.println("Found the div that has id: " + div.getAttribute("id"));

            // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement revealInput = driver.findElement(By.id("reveal"));

            revealInput.click();

            // WebElement revealedInput = wait.until(
            // ExpectedConditions.presenceOfElementLocated(By.id("revealed")));
            // System.out.println("Here is the text of hidden input " +
            // revealedInput.getText());

            Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);
            WebElement revealedInput = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("revealed")));

        } finally {
            driver.quit();
        }
    }
}
