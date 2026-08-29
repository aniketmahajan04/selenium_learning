package com.sendo;

import java.util.List;

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
        // System.out.println(textInputWithMultipleAttribute.getAttribute("name"));

        WebElement textInputWithContainsXPath = driver.findElement(By.xpath("//input[contains(@id, 'my-text-')]"));

        // System.out.println(textInputWithContainsXPath.getAttribute("id"));

        WebElement submitButtonWithContainsXPath = driver.findElement(By.xpath("//button[contains(text(), 'Sub')]"));

        // System.out.println(submitButtonWithContainsXPath.getText());

        WebElement textInputWithStartWithXPath = driver.findElement(By.xpath("//input[starts-with(@id, 'my-text')]"));

        // System.out.println(textInputWithStartWithXPath.getAttribute("id"));

        WebElement textInputToParent = driver.findElement(By.xpath("//input[@id='my-text-id']/parent::label"));
        System.out.println(textInputToParent.getTagName());

        WebElement labelToSelect = driver
                .findElement(By.xpath("//label[starts-with(text(),'Dropdown')]/child::select"));
        System.out.println(labelToSelect.getAttribute("name"));

        WebElement followingToSiblingElement = driver
                .findElement(By.xpath("//input[@name='my-datalist']/following-sibling::datalist"));

        System.out.println(followingToSiblingElement.getAttribute("id"));

        // could not able to find so i put this wrong imlementation
        List<WebElement> followingToPrecedingSibling = driver
                .findElements(By.xpath("//datalist[@id='my-options']/preceding-sibling::input"));

        System.out.println(followingToPrecedingSibling.getFirst());
        driver.quit();
    }
}