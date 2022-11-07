package com.fatsecret.pages.fatsecret;

import com.fatsecret.enums.Activity;
import com.fatsecret.enums.Gender;
import com.fatsecret.enums.Goal;
import com.fatsecret.helpers.wait.WaitUtils;
import com.fatsecret.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Класс, объединяющий последовательность страниц при регистрации и авторизации FatSecret
 */
public class AuthPage extends BasePage {
    private By homePage = By.id("com.fatsecret.android:id/tab_home");
    private By newUserButton = By.id("com.fatsecret.android:id/registration_lets_begin_text_solid");
    private By signInUpWithEmail = By.id("com.fatsecret.android:id/sign_in_sign_up_with_email");
    private By signInEmailInput = By.id("com.fatsecret.android:id/sign_in_email_member_name_input");
    private By signInPasswordInput = By.id("com.fatsecret.android:id/sign_in_password_input");
    private By signInButton = By.id("com.fatsecret.android:id/sign_in_sign_in_button");

    private By forgotPassword = By.id("com.fatsecret.android:id/sign_in_forgot_password");
    private By haveAccountButton = By.id("com.fatsecret.android:id/registration_sign_in_outline");
    private By agreeButton = By.id("com.fatsecret.android:id/existing_user_data_optin_disagree_go_back");

    private By disagreeButton = By.id("com.fatsecret.android:id/existing_user_data_optin_disagree_delete_account");
    private By nextButton = By.id("com.fatsecret.android:id/floating_action_next_button");
    private By loseWeightHolder = By.id("com.fatsecret.android:id/registration_diet_goal_lose_weight_holder");
    private By maintainWeightHolder = By.id("com.fatsecret.android:id/registration_diet_goal_maintain_weight_holder_parent");
    private By gainWeightHolder = By.id("com.fatsecret.android:id/registration_diet_goal_gain_weight_holder");
    private By genderFemaleHolder = By.id("com.fatsecret.android:id/registration_gender_female");
    private By genderMaleHolder = By.id("com.fatsecret.android:id/registration_gender_male");
    private By activitySedentaryHolder = By.id("com.fatsecret.android:id/registration_activity_list_sedentary_holder");
    private By activityLowHolder = By.id("com.fatsecret.android:id/registration_activity_list_low_active_holder");
    private By activeHolder = By.id("com.fatsecret.android:id/registration_activity_list_active_holder");
    private By veryActiveHolder = By.id("com.fatsecret.android:id/registration_activity_list_very_active_holder");
    private By input = By.id("com.fatsecret.android:id/edit_text");
    private By dayOfBirthInput = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[2]/android.widget.EditText");
    private By monthOfBirthInput = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[1]/android.widget.EditText");
    private By yearOfBirthInput = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[3]/android.widget.EditText");
    private By dayOfBirthSmaller = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[2]/android.widget.Button[1]");
    private By dayOfBirthLarger = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[2]/android.widget.Button[2]");
    private By monthOfBirthLarger = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[1]/android.widget.Button[2]");
    private By yearOfBirthLarger = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[3]/android.widget.Button[2]");
    private By yearOfBirthSmaller = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.widget.DatePicker/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.NumberPicker[3]/android.widget.Button[1]");
    private By defaultUsaHolder = By.id("com.fatsecret.android:id/registration_default_region_holder");
    private By emailHolder = By.id("com.fatsecret.android:id/create_account_sign_up_with_email");
    private By continueEmail = By.id("com.fatsecret.android:id/create_account_email_continue_button");
    private By continuePassword = By.id("com.fatsecret.android:id/create_account_password_continue_button");
    private By continueMember = By.id("com.fatsecret.android:id/create_account_member_name_continue_button");
    private By startNowBtn = By.id("com.fatsecret.android:id/predicted_goal_date_get_started");

    private By content = By.id("android:id/content");

    public AuthPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
        WaitUtils.waitUntilVisibilityOfElementLocated(content);
    }

    /**
     * Осуществляет регистрацию пользователя
     *
     * @param goal           Цель пользователя (Weight loss, Weight gain, Maintain)
     * @param gender         Пол пользователя (Male, Female)
     * @param activity       Активность пользователя (Low, High, Sedentary, Active)
     * @param weight         Вес пользователя
     * @param height         Рост пользователя
     * @param birthdate      Дата рождения пользователя по формату (01/Feb/2000)
     * @param email          Почта пользователя
     * @param password       Пароль пользователя
     * @param name           Никнэйм пользователя
     * @param weightToChange Вес, который пользователь планирует набрать/сбросить
     */
    public void createAnAccount(Goal goal, Gender gender, Activity activity, String weight, String height, String birthdate,
                                String email, String password, String name, String weightToChange) {

        if (isAuthenticated()) {
            MePage mePage = new MePage(appiumDriver);
            mePage.signOut();
        }

        WaitUtils.waitUntilVisibilityOfElementLocated(newUserButton).click();

        WaitUtils.waitUntilVisibilityOfElementLocated(agreeButton).click();

        WaitUtils.waitUntilVisibilityOfElementLocated(nextButton).click();

        chooseGoal(goal, weightToChange);
        chooseGender(gender);
        chooseActivity(activity);
        setWeight(weight);
        setHeight(height);
        setDateOfBirth(birthdate);
        setDefaultCountry();
        setEmail(email);
        setPassword(password);
        setMemberName(name);

        WaitUtils.waitUntilVisibilityOfElementLocated(homePage);
    }

    /**
     * Проверяет, авторизован ли пользователь, по иконке Home в нижней панели
     *
     * @return true - авторизован, false - неавторизован
     */
    private boolean isAuthenticated() {
        return appiumDriver.findElements(homePage).size() != 0;
    }

    /**
     * Устанавливает пароль
     *
     * @param password Пароль пользователя
     */
    private void setPassword(String password) {
        WaitUtils.waitUntilVisibilityOfElementLocated(input).sendKeys(password);
        appiumDriver.findElement(continuePassword).click();
    }

    /**
     * Устанавливает почту
     *
     * @param email Почта пользователя
     */
    private void setEmail(String email) {
        WaitUtils.waitUntilVisibilityOfElementLocated(emailHolder).click();
        WaitUtils.waitUntilVisibilityOfElementLocated(input).sendKeys(email);
        appiumDriver.findElement(continueEmail).click();
    }

    /**
     * Устанавливает страну по умолчанию (United States)
     */
    private void setDefaultCountry() {
        WaitUtils.waitUntilVisibilityOfElementLocated(defaultUsaHolder).click();
        appiumDriver.findElement(nextButton).click();
    }

    /**
     * Устанавливает вес пользователя
     *
     * @param weight Вес пользователя
     */
    private void setWeight(String weight) {
        WaitUtils.waitUntilVisibilityOfElementLocated(input).sendKeys(weight);
        appiumDriver.findElement(nextButton).click();
    }

    /**
     * Устанавливает рост пользователя
     *
     * @param height Рост пользователя
     */
    private void setHeight(String height) {
        WaitUtils.waitUntilVisibilityOfElementLocated(input).sendKeys(height);
        appiumDriver.findElement(nextButton).click();
    }

    /**
     * Устанавливает цель пользователя и, отталкиваясь от цели, устанавливает желаемый к изменению вес
     *
     * @param goal           Цель пользователя (Weight loss, Weight gain, Maintain)
     * @param weightToChange Вес для изменения
     */
    private void chooseGoal(Goal goal, String... weightToChange) {
        switch (goal) {
            case WEIGHT_LOSS:
                WaitUtils.waitUntilVisibilityOfElementLocated(loseWeightHolder).click();
                appiumDriver.findElement(nextButton).click();
                WaitUtils.waitUntilVisibilityOfElementLocated(input).sendKeys(weightToChange);
                break;
            case MAINTAIN:
                WaitUtils.waitUntilVisibilityOfElementLocated(maintainWeightHolder).click();
                appiumDriver.findElement(maintainWeightHolder).click();
                break;
            case WEIGHT_GAIN:
                WaitUtils.waitUntilVisibilityOfElementLocated(gainWeightHolder).click();
                appiumDriver.findElement(nextButton).click();
                WaitUtils.waitUntilVisibilityOfElementLocated(input).sendKeys(weightToChange);
                break;
        }

        appiumDriver.findElement(nextButton).click();
    }

    /**
     * Устанавливает пол пользователя
     *
     * @param gender Пол пользователя (Male, Female)
     */
    private void chooseGender(Gender gender) {
        switch (gender) {
            case MALE:
                WaitUtils.waitUntilVisibilityOfElementLocated(genderMaleHolder).click();
                break;
            case FEMALE:
                WaitUtils.waitUntilVisibilityOfElementLocated(genderFemaleHolder).click();
                break;
        }

        appiumDriver.findElement(nextButton).click();
    }

    /**
     * Устанавливает никнейм
     *
     * @param name Никнейм пользователя
     */
    private void setMemberName(String name) {
        WaitUtils.waitUntilVisibilityOfElementLocated(input).sendKeys(name);
        appiumDriver.findElement(continueMember).click();

        if (appiumDriver.findElements(startNowBtn).size() != 0) {
            appiumDriver.findElement(startNowBtn).click();
            WaitUtils.waitUntilStalenessOfElement(appiumDriver.findElement(startNowBtn));
        }
    }

    /**
     * Устанавливает активность пользователя
     *
     * @param activity Активность пользователя (Low, High, Sedentary, Active)
     */
    private void chooseActivity(Activity activity) {
        switch (activity) {
            case SEDENTARY:
                WaitUtils.waitUntilVisibilityOfElementLocated(activitySedentaryHolder).click();
                break;
            case LOW_ACTIVITY:
                WaitUtils.waitUntilVisibilityOfElementLocated(activityLowHolder).click();
                break;
            case ACTIVE:
                WaitUtils.waitUntilVisibilityOfElementLocated(activeHolder).click();
                break;
            case VERY_ACTIVE:
                WaitUtils.waitUntilVisibilityOfElementLocated(veryActiveHolder).click();
        }
        WaitUtils.waitUntilVisibilityOfElementLocated(nextButton).click();
    }

    /**
     * @param birthDate Формат даты 01/Feb/2000, 30/Apr/1999
     */
    private void setDateOfBirth(String birthDate) {
        String[] date = birthDate.split("/");
        int day = Integer.parseInt(date[0]);
        String month = date[1];
        int year = Integer.parseInt(date[2]);

        WaitUtils.waitUntilVisibilityOfElementLocated(dayOfBirthInput);

        if (Integer.parseInt(appiumDriver.findElement(dayOfBirthInput).getText()) > day) {
            while (Integer.parseInt(appiumDriver.findElement(dayOfBirthInput).getText()) > day) {
                actions.clickAndHold(appiumDriver.findElement(dayOfBirthInput))
                        .moveToElement(appiumDriver.findElement(dayOfBirthLarger)).release().perform();

            }
        } else if (Integer.parseInt(appiumDriver.findElement(dayOfBirthInput).getText()) < day) {
            while (Integer.parseInt(appiumDriver.findElement(dayOfBirthInput).getText()) < day) {
                actions.clickAndHold(appiumDriver.findElement(dayOfBirthInput))
                        .moveToElement(appiumDriver.findElement(dayOfBirthSmaller)).release().perform();
            }
        }

        if (!appiumDriver.findElement(monthOfBirthInput).getText().equals(month)) {
            while (!appiumDriver.findElement(monthOfBirthInput).getText().equals(month)) {
                actions.clickAndHold(appiumDriver.findElement(monthOfBirthInput))
                        .moveToElement(appiumDriver.findElement(monthOfBirthLarger)).release().perform();
            }
        }

        if (Integer.parseInt(appiumDriver.findElement(yearOfBirthInput).getText()) > year) {
            while (Integer.parseInt(appiumDriver.findElement(yearOfBirthInput).getText()) > year) {
                actions.clickAndHold(appiumDriver.findElement(yearOfBirthInput))
                        .moveToElement(appiumDriver.findElement(yearOfBirthLarger)).release().perform();
            }
        } else if (Integer.parseInt(appiumDriver.findElement(yearOfBirthInput).getText()) < year) {
            while (Integer.parseInt(appiumDriver.findElement(yearOfBirthInput).getText()) < year) {
                actions.clickAndHold(appiumDriver.findElement(yearOfBirthInput))
                        .moveToElement(appiumDriver.findElement(yearOfBirthSmaller)).release().perform();
            }
        }

        appiumDriver.findElement(nextButton).click();

    }


    /**
     * Проводит авторизацию по никнэйму и паролю
     *
     * @param name     Никнэйм пользователя
     * @param password Пароль пользователя
     */
    public void signIn(String name, String password) {
        MePage mePage = new MePage(appiumDriver);
        if (mePage.isAuthenticated()) {
            mePage.signOut();
        }

        WaitUtils.waitUntilVisibilityOfElementLocated(haveAccountButton).click();

        WaitUtils.waitUntilVisibilityOfElementLocated(signInUpWithEmail).click();
        WaitUtils.waitUntilVisibilityOfElementLocated(signInEmailInput).click();
        actions.sendKeys(name).perform();
        appiumDriver.findElement(signInPasswordInput).click();
        actions.sendKeys(password).perform();
        appiumDriver.findElement(signInButton).click();
        WaitUtils.waitUntilVisibilityOfElementLocated(homePage);
    }
}
