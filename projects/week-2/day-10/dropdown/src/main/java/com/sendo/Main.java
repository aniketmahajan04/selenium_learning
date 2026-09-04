package com.sendo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Main {
    static void main() {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.selenium.dev/selenium/web/web-form.html");

            WebElement dropdown = driver.findElement(By.name("my-select"));

            Select select = new Select(dropdown);

            // select.selectByVisibleText("मराठी");
            // select.selectByValue("2");
            select.selectByIndex(2);

        } finally {
            // driver.quit();
        }
    }
}
