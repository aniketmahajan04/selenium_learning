package com.sendo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        WebElement textInput = driver.findElement(By.cssSelector("#my-text-id.form-control"));

        WebElement textInputWithName = driver.findElement(By.cssSelector("input[name='my-text']"));

        System.out.println(textInput.getTagName());

        // here we are accessing input that is child element of label
        WebElement inputText = driver.findElement(By.cssSelector(".form-label input"));
        System.out.println(inputText.getAttribute("myprop"));

        WebElement inputTextWith = driver.findElement(By.cssSelector("input.form-control[name='my-text']"));

        WebElement inputTextOp = driver.findElement(By.cssSelector("input[name^='my']"));
        System.out.println("inputTextOp " + inputTextOp.getAttribute("type"));

        WebElement selectDropdown = driver.findElement(By.name("my-select"));

        Select dropdown = new Select(selectDropdown);
        List<WebElement> options = dropdown.getOptions();
        System.out.println(options.size());
        driver.quit();
    }
}