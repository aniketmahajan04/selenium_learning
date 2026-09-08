package com.sendo;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    static void main() {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.selenium.dev/selenium/web/web-form.html");

            TakesScreenshot screenshot = (TakesScreenshot) driver;

            File source = screenshot.getScreenshotAs(OutputType.FILE);
            System.out.println(source.getAbsolutePath());
        } finally {
            driver.quit();
        }

    }
}
