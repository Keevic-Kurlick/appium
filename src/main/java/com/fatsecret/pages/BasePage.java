package com.fatsecret.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {
    protected AppiumDriver appiumDriver;
    protected Actions actions;

    public BasePage(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        this.actions = new Actions(appiumDriver);
    }

}
