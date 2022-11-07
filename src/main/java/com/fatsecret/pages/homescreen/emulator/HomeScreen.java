package com.fatsecret.pages.homescreen.emulator;

import com.fatsecret.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.util.List;

public class HomeScreen extends BasePage {

    private By fastPanel = By.id("com.google.android.apps.nexuslauncher:id/hotseat");
    private By upPanel = By.id("com.google.android.apps.nexuslauncher:id/workspace");
    private By allApps = By.id("com.google.android.apps.nexuslauncher:id/apps_list_view");

    public HomeScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    /**
     * Выполняет свайп вверх для отображения списка всех приложений
     */
    public void getAllApps() {
        actions.clickAndHold(appiumDriver.findElement(fastPanel))
                .moveToElement(appiumDriver.findElement(upPanel))
                .release().perform();
    }

    /**
     * Выбирает и кликает на приложение из списка всех приложений
     *
     * @param app Наименование приложения
     */
    //TODO: исключение
    public void getApp(String app) {
        List<AndroidElement> list = appiumDriver.findElement(allApps).findElements(By.xpath(".//android.widget.TextView[@content-desc]"));
        list.stream()
                .filter(androidElement -> androidElement.getAttribute("content-desc")
                        .contains(app)).findFirst().get().click();
    }
}
