package com.sendo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    static void main() {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.selenium.dev/selenium/web/iframes.html?utm_source=chatgpt.com");

            WebElement frame = driver.findElement(By.id("iframe1"));

            driver.switchTo().frame("iframe1-name");

            WebElement emailInput = driver.findElement(By.id("email"));

            emailInput.sendKeys("sendo@gmail.com");

            driver.switchTo().defaultContent();

            WebElement mainHeading = driver.findElement(By.id("iframe_page_heading"));
            System.out.println(mainHeading.getText());

            WebElement outerIframe = driver.findElement(By.id("outer"));

            driver.switchTo().frame(outerIframe);

            WebElement innerIframe = driver.findElement(By.id("inner"));

            driver.switchTo().frame(innerIframe);

            WebElement emailInput = driver.findElement(By.tagName("input"));
            emailInput.sendKeys("sendo@gmail.com");

            driver.switchTo().defaultContent();

            WebElement submitButton = driver.findElement(By.id("submit"));
            submitButton.click();
        } finally {
            // driver.quit();
        }

    }
}
