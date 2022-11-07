package com.fatsecret.pages.fatsecret;

import com.fatsecret.helpers.wait.WaitUtils;
import com.fatsecret.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

/**
 * Абстрактный класс, содержащий элементы нижней панели Fatsecret, методы взаимодействия с ними,
 * элементы и метод выхода из учетной записи
 */
public abstract class FatSecretAbstract extends BasePage {
    protected By diaryPage = By.id("com.fatsecret.android:id/tab_food");

    protected By mePage = By.id("com.fatsecret.android:id/tab_me");
    protected By reportsPage = By.id("com.fatsecret.android:id/tab_reports");
    protected By homePage = By.id("com.fatsecret.android:id/tab_home");
    protected By premiumPage = By.id("com.fatsecret.android:id/tab_premium");
    protected By closeButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ImageButton");
    protected By settingButton = By.id("com.fatsecret.android:id/tooltip_anchor");
    protected By signOutButton = By.id("com.fatsecret.android:id/settings_user_email_holder");
    protected By confirmSignOutButton = By.id("com.fatsecret.android:id/md_buttonDefaultPositive");

    public FatSecretAbstract(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    /**
     * Переходит на страницу личного кабинета (Me)
     */
    public void goMe() {
        WaitUtils.waitUntilVisibilityOfElementLocated(mePage).click();
    }

    /**
     * Переходит на страицу с репортами/отчетами (Reports)
     */
    public void goReports() {
        WaitUtils.waitUntilVisibilityOfElementLocated(reportsPage).click();
    }

    /**
     * Переходит на домашнюю страницу с блогами (Home)
     */
    public void goHome() {
        WaitUtils.waitUntilVisibilityOfElementLocated(homePage).click();
    }

    /**
     * Переходит на страницу оформления премиум подписки (Premium)
     */
    public void goPremium() {
        WaitUtils.waitUntilVisibilityOfElementLocated(premiumPage).click();
    }

    /**
     * Переходит на страницу дневника питания (Diary)
     */
    public void goDiary() {
        WaitUtils.waitUntilVisibilityOfElementLocated(diaryPage).click();
    }

    /**
     * Осуществляет выход из учетной записи
     */
    public void signOut() {
        actions.moveToElement(WaitUtils.waitUntilVisibilityOfElementLocated(closeButton))
                .clickAndHold(appiumDriver.findElement(closeButton)).release().perform();
        WaitUtils.waitUntilVisibilityOfElementLocated(settingButton).click();
        appiumDriver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().text(\"Sign Out\"))"));
        appiumDriver.findElement(signOutButton).click();
        WaitUtils.waitUntilVisibilityOfElementLocated(confirmSignOutButton).click();
    }

    /**
     * Проверят, авторизован ли пользователь, по видимости иконки Home
     *
     * @return true - авторизован, false - нет
     */
    public boolean isAuthenticated() {
        return appiumDriver.findElements(homePage).size() != 0;
    }
}
