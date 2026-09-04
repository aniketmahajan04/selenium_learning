package com.sendo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.sendo.utils.Utils;

public class Main {
    static void main() {
        WebDriver driver = new ChromeDriver();

        try {

            WebElement dropdown = driver.findElement(By.id("country"));

            Select select = new Select(dropdown);

            select.selectByValue("101");

            WebElement customDropdownButton = driver.findElement(By.xpath("//div[@id='stateDropdown']/button"));
            customDropdownButton.click();

            Utils util = new Utils(driver);

            WebElement optionDiv = util
                    .waitForElementToClickable(By.xpath("//div[@class='option' and text()='Maharashtra']"));

            optionDiv.click();
        } finally {
            driver.quit();
        }
    }
}
