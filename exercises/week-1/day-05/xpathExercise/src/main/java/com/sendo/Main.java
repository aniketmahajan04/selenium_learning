package com.sendo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        try {

            driver.get("https://www.selenium.dev/selenium/web/web-form.html");

            // Absolute xpath
            WebElement h1 = driver.findElement(By.xpath("/html/body/main/div/div/div/h1"));
            System.out.println(h1.getText());

            // Relative xpath
            WebElement h1WithRelative = driver.findElement(By.xpath("//h1[@class='display-6']"));
            System.out.println(h1WithRelative.getText());

            WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
            System.out.println(submitButton.getText());

            WebElement link = driver.findElement(By.xpath("//a[contains(text(), 'Return to')]"));
            System.out.println(link.getText());

            // starts-with()
            WebElement linkWithStartsWith = driver.findElement(By.xpath("//input[starts-with(@id, 'my-text')]"));
            System.out.println(linkWithStartsWith.getAttribute("id"));

            WebElement submitButtonWithNomalize = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
            System.out.println(submitButtonWithNomalize.getText());

            // WebElement inputTextWithAnd = driver
            // .findElement(By.xpath("//input[@id='my-text-id' and
            // normalize-space(@name,'my-text')]"));
            // System.out.println(inputTextWithAnd.getAttribute("id"));

            WebElement buttonSUbmit = driver
                    .findElement(By.xpath("//button[@type='submit' and text()='Submit']"));
            System.out.println(buttonSUbmit.getText());

            WebElement buttonSubmitWithOr = driver
                    .findElement(By.xpath("//button[@type='submit' or text()='Submit']"));
            System.out.println(buttonSubmitWithOr.getText());

            WebElement inputToLabel = driver.findElement(By.xpath("//input[@id='my-text-id']/parent::label"));
            System.out.println(inputToLabel.getTagName());

            WebElement divToLink = driver.findElement(By.xpath("//div[contains(@class, 'tp-align-right')]/child::a"));
            System.out.println(divToLink.getText());

            WebElement followingSiblingOfInput = driver
                    .findElement(By.xpath("//input[@name='my-datalist']/following-sibling::datalist"));
            System.out.println(followingSiblingOfInput.getAttribute("id"));

            WebElement precedingSiblingOfDatalist = driver
                    .findElement(By.xpath("//datalist[@id='my-options']/preceding-sibling::input"));
            System.out.println(precedingSiblingOfDatalist.getAttribute("name"));

        } finally {

            driver.quit();
        }
    }
}