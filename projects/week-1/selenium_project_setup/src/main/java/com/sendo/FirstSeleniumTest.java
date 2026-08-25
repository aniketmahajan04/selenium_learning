package com.sendo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://youtube.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://google.com");
        driver.quit();
    }
}