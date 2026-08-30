package com.sendo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {

            driver.get("https://www.selenium.dev/selenium/web/web-form.html");
            // driver.navigate().to("https://www.selenium.dev");

            // driver.navigate().back();

            // driver.navigate().forward();
            // System.out.println(driver.getCurrentUrl());

            // driver.navigate().refresh();

            WebElement button = driver.findElement(By.cssSelector("button[type='submit']"));
            // button.click();

            // System.out.println(driver.getCurrentUrl());
            // System.out.println(driver.getTitle());

            WebElement textInput = driver.findElement(By.id("my-text-id"));
            // textInput.click();
            textInput.sendKeys("Hello Aniket");
            System.out.println(textInput.getAttribute("value"));
            textInput.clear();
            textInput.sendKeys("Hello Aniket again");
            System.out.println(textInput.getAttribute("value"));
        } finally {
            driver.quit();
        }
    }
}