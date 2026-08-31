package com.sendo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://duckduckgo.com/");

            WebElement searchBox = driver.findElement(By.xpath("//textarea[@placeholder='Search privately']"));

            searchBox.sendKeys("Selenium WebDriver", Keys.ENTER);

            String currentUrl = driver.getCurrentUrl();

            String title = driver.getTitle();

            if (currentUrl.contains("q=Selenium+WebDriver") && title.contains("Selenium WebDriver"))
                System.out.println("Both Test succesfull");

        } finally {
            driver.quit();
        }

    }
}