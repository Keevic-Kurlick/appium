package com.fatsecret.helpers.wait;

import com.fatsecret.driver.AppiumDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import properties.Properties;

import java.time.Duration;
import java.util.NoSuchElementException;

/**
 * Вспомогательный класс для краткой записи вызова WebDriverWait
 */
public class WaitUtils {

    private static WebDriverWait wait = new WebDriverWait(AppiumDriverManager.getDriver(), Properties.mainProperties.defaultTimeout());

    /**
     * Реинициализирует хранимый экземпляр класса WebDriverWait
     */
    public static void reinitWait() {
        wait = new WebDriverWait(AppiumDriverManager.getDriver(), Properties.mainProperties.defaultTimeout());
    }

    public static WebElement waitUntilVisibilityOfElementLocated(By path) {
        return wait.ignoring(NoSuchElementException.class).pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(path));
    }

    public static void waitUntilStalenessOfElement(WebElement element) {
        wait.until(ExpectedConditions.stalenessOf(element));
    }

    public static WebElement waitUntilElementClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
