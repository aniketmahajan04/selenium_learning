package com.sendo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        String webPageTitle = driver.getTitle();
        if (webPageTitle.equals("Google")) {
            System.out.println(webPageTitle);
        } else {
            System.out.println("Title is not what i expected");
        }

        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        driver.quit();
    }
}