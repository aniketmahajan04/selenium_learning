package com.sendo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void takeScreenshot(WebDriver driver, String filename) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFiles = screenshot.getScreenshotAs(OutputType.FILE);

        Path screenshotsDirectory = Paths.get("./projects/week-2/day-14/screenshots_sele");

        Path destinationFile = screenshotsDirectory.resolve(filename);

        Files.createDirectories(screenshotsDirectory);

        Files.copy(srcFiles.toPath(), destinationFile, StandardCopyOption.REPLACE_EXISTING);
    }

    static void main() {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.selenium.dev/selenium/web/web-form.html");

            takeScreenshot(driver, "homepage.png");
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            driver.quit();
        }

    }
}
