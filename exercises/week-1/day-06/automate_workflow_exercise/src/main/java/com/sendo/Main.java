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

            WebElement textInput = driver.findElement(By.id("my-text-id"));

            textInput.sendKeys("Selenium day 6");

            System.out.println(textInput.getAttribute("value"));

            textInput.clear();

            textInput.sendKeys("WebDriver");

            System.out.println(textInput.getAttribute("value"));

            textInput.clear();

            WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));

            if (button.isDisplayed())
                System.out.println("Submit button is displayed!");

            if (button.isEnabled())
                System.out.println("Submit button is enabled!");

            button.click();

            System.out.println(driver.getCurrentUrl());

        } finally {
            driver.quit();
        }
    }
}