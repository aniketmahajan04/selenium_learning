package com.sendo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        WebElement inputTextById = driver.findElement(By.cssSelector("#my-text-id"));

        WebElement inputPasswordByClass = driver.findElement(By.cssSelector(".form-control[name='my-password']"));

        WebElement textAreaByAttribute = driver.findElement((By.cssSelector("textarea[name='my-textarea']")));

        WebElement disabledInputByMultipleAttribute = driver
                .findElement(By.cssSelector("input.form-control[name='my-disabled']"));

        WebElement readOnlyInput = driver.findElement(By.cssSelector("lable input[name='my-readonly']"));

        WebElement checkBoxes = driver.findElement(By.cssSelector(".form-check > label"));

        WebElement checkBoxesWithOperators = driver.findElement(By.cssSelector(".form-check label[class^='form']"));

        WebElement checkBoxesWithEnds = driver.findElement(By.cssSelector(".form-check label[class$='label']"));

        WebElement checkBoxesWithContains = driver.findElement(By.cssSelector(".form-check label[class*='check']"));
        driver.quit();
    }
}