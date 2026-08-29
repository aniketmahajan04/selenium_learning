package com.sendo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        WebElement textInput = driver.findElement(By.xpath("/html/body/main/div/form/div/div/label/input"));

        WebElement textInputWithName = driver.findElement(By.xpath("//input[@name='my-text']"));

        WebElement textInputWithMultipleAttribute = driver
                .findElement(By.xpath("//input[@type='text' and @name='my-text']"));
        System.out.println(textInputWithMultipleAttribute.getAttribute("name"));
        driver.quit();
    }
}