package com.sendo;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
    static void main() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        try {

            driver.get("https://www.selenium.dev/selenium/web/alerts.html?utm_source=chatgpt.com#");

            // WebElement checkAlert = driver.findElement(By.id("alert"));
            // checkAlert.click();

            // Alert alert = driver.switchTo().alert();

            // System.out.println(alert.getText());
            // alert.dismiss();

            WebElement promptTrigger = driver.findElement(By.id("prompt"));
            promptTrigger.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Alert promptAlert = wait.until(ExpectedConditions.alertIsPresent());

            promptAlert.sendKeys("Sendo");
            System.out.println("Text sent to prompt");
            // System.out.println(promptAlert.getText());

            // promptAlert.accept();

        } finally {
            // driver.quit();
        }
    }
}
