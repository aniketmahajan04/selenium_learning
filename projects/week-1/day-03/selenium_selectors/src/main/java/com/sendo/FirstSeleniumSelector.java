package com.sendo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumSelector {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        // This return only single element
        WebElement textInput = driver.findElement(By.id("my-text-id"));
        System.out.println("Tag: " + textInput.getTagName());
        System.out.println("ID: " + textInput.getAttribute("id"));
        System.out.println("Name: " + textInput.getAttribute("name"));

        // If you want to access multiple elements use this method
        List<WebElement> textInputs = driver.findElements(By.className("form-control"));

        for (WebElement we : textInputs) {
            System.out.println(we.getAttribute("type"));
        }

        WebElement inputText = driver.findElement(By.name("my-text"));

        WebElement submitButton = driver.findElement(By.className("btn"));
        System.out.println(submitButton.getAttribute("type"));

        WebElement link = driver.findElement(By.linkText("Return to index"));
        System.out.println(link.getText());

        WebElement linkWithHalfText = driver.findElement(By.partialLinkText("Return"));
        System.out.println(linkWithHalfText.getText());
        // driver.quit();
    }
}