package com.fatsecret.pages.fatsecret;

import com.fatsecret.helpers.wait.WaitUtils;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

/**
 * Класс страницы с личной информацией авторизованного пользователя Fatsecret
 */
public class MePage extends FatSecretAbstract {

    private By profilePhoto = By.id("com.fatsecret.android:id/user_profile_picture_image");
    private By emailHolder = By.id("com.fatsecret.android:id/side_navigation_member_email");
    private By weightHolder = By.id("com.fatsecret.android:id/my_weight_holder");

    private By accountTypeHolder = By.id("com.fatsecret.android:id/account_type_tv");

    private By communicationHolder = By.id("com.fatsecret.android:id/privacy_communication_holder");
    private By currentWeight = By.id("com.fatsecret.android:id/weight_history_current_weight_value");
    private By goalWeight = By.id("com.fatsecret.android:id/weight_history_goal_value");
    private By startWeight = By.id("com.fatsecret.android:id/weight_history_start_value");
    private By weighIn = By.id("com.fatsecret.android:id/weigh_in_weight_value_holder");
    private By saveButton = By.id("com.fatsecret.android:id/action_save");
    private By backWeightBtn = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ImageButton");

    public MePage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    /**
     * Возвращает почту пользователя
     *
     * @return Почта пользователя
     */
    public String getEmail() {
        return appiumDriver.findElement(emailHolder).getText();
    }

    /**
     * Переходит на страницу с изменением веса пользователя
     */
    public void goWeight() {
        WaitUtils.waitUntilVisibilityOfElementLocated(weightHolder).click();
    }

    /**
     * Получает текущий вес со страницы изменения веса пользователя
     *
     * @return
     */
    public String getWeight() {
        goWeight();
        String weight = WaitUtils.waitUntilVisibilityOfElementLocated(currentWeight).getText();
        goBackFromWeight();
        WaitUtils.waitUntilVisibilityOfElementLocated(weightHolder);
        return weight;
    }

    /**
     * Выходит со страницы изменения веса пользователя
     */
    public void goBackFromWeight() {
        WaitUtils.waitUntilVisibilityOfElementLocated(backWeightBtn).click();
    }

    /**
     * Получает целевой вес со страницы изменения веса пользователя
     *
     * @return Целевой вес пользователя
     */
    public String getGoalWeight() {
        goWeight();
        String weight = WaitUtils.waitUntilVisibilityOfElementLocated(goalWeight).getText();
        goBackFromWeight();
        return weight;
    }

    /**
     * Получает стартовый вес пользователя со страницы изменения веса
     *
     * @return Стартовый вес пользователя
     */
    public String getStartWeight() {
        goWeight();
        String weight = WaitUtils.waitUntilVisibilityOfElementLocated(startWeight).getText();
        goBackFromWeight();
        return weight;
    }

    /**
     * Измененяет текущий вес пользователя
     *
     * @param newWeight Новый текущий вес
     */
    public void changeWeight(String newWeight) {
        appiumDriver.findElement(currentWeight).click();
        WaitUtils.waitUntilVisibilityOfElementLocated(weighIn).sendKeys(Keys.CLEAR, newWeight);
        WaitUtils.waitUntilVisibilityOfElementLocated(saveButton).click();
    }
}
