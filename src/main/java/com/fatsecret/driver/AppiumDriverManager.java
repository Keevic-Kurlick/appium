package com.fatsecret.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import properties.Properties;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverManager {
    private static AppiumDriver<MobileElement> driver;

    public static AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    public static void initAndroid(String appPackage, String appActivity, String deviceName) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
        desiredCapabilities.setCapability("appium:deviceName", deviceName);
        desiredCapabilities.setCapability("appPackage", appPackage);
        desiredCapabilities.setCapability("appActivity", appActivity);
        desiredCapabilities.setCapability("appium:newCommandTimeout", Properties.mainProperties.defaultTimeout());

        driver = new AndroidDriver(new URL(Properties.mainProperties.remoteUrl()), desiredCapabilities);
    }

    public static void killCurrentDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
