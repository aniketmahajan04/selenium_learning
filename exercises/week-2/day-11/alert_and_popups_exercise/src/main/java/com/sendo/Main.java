package com.sendo;

import com.sendo.utils.Utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    static void main() {
        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://www.selenium.dev/selenium/web/alerts.html?utm_source=chatgpt.com#");

            WebElement alertLink = driver.findElement(By.id("alert"));

            alertLink.click();

            Utility utility = new Utility(driver);

            Alert alert = utility.waitForThAlert();

            System.out.println(alert.getText());

            alert.accept();

            WebElement confirmLink = driver.findElement(By.id("confirm"));

            confirmLink.click();

            Alert confirm = utility.waitForThAlert();

            System.out.println(confirm.getText());

            confirm.dismiss();

            if (isAlertGone(driver)) {
                System.out.println("Alert present");
            } else {
                System.out.println("No alert present");
            }

            WebElement promptLink = driver.findElement(By.id("prompt"));

            promptLink.click();

            Alert promptAlert = utility.waitForThAlert();

            System.out.println(promptAlert.getText());

            promptAlert.sendKeys("Sendo");
            promptAlert.accept();
        } finally {
            driver.quit();
        }
    }

    public static boolean isAlertGone(WebDriver driver) {
        try {
            driver.switchTo().alert();

            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
