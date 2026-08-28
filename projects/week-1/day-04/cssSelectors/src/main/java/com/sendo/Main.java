package com.sendo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        WebElement textInput = driver.findElement(By.cssSelector("#my-text-id.form-control"));

        WebElement textInputWithName = driver.findElement(By.cssSelector("input[name='my-text']"));

        System.out.println(textInput.getTagName());

        driver.quit();
    }
}