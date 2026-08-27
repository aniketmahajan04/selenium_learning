package com.sendo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("my-text-input")));

        WebElement textInput = driver.findElement(By.id("my-text-input"));
        System.out.println("Text Input: " + textInput);

        WebElement passwordInput = driver.findElement((By.name("my-password")));
        System.out.println("Password Input: " + passwordInput);

        WebElement inputWithClassName = driver.findElement(By.className("form-label"));
        System.out.println("Input with Class: " + inputWithClassName);

        WebElement textArea = driver.findElement(By.tagName("textarea"));
        System.out.println("Text Area: " + textArea);

        WebElement linkText = driver.findElement(By.linkText("Read to index"));
        System.out.println("Link Text: " + linkText);

        WebElement partialLinkText = driver.findElement(By.partialLinkText("Read to index"));
        System.out.println("Partial Link Text: " + partialLinkText);

        WebElement inputWithCssSelector = driver.findElement(By.cssSelector("input[name='my-text'][type='text']"));
        System.out.println("CSS Selector Input: " + inputWithCssSelector);

        WebElement inputWithXpath = driver.findElement(By.xpath("//input[@id='my-text-id']"));
        System.out.println("XPath Input: " + inputWithXpath);

        WebElement button = driver.findElement(By.xpath("//button[text()='Submit' and @type='submit']"));
        System.out.println("Button with AND: " + button);

        WebElement buttonWithOrOperator = driver.findElement(By.xpath("//button[text()='Submit' or @type='submit']"));
        System.out.println("Button with OR: " + buttonWithOrOperator);

        // driver.quit();
    }
}