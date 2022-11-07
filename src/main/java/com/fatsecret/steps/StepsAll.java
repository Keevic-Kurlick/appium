package com.fatsecret.steps;

import com.fatsecret.enums.Activity;
import com.fatsecret.enums.Gender;
import com.fatsecret.enums.Goal;
import com.fatsecret.pages.fatsecret.AuthPage;
import com.fatsecret.pages.fatsecret.DiaryPage;
import com.fatsecret.pages.fatsecret.MePage;
import com.fatsecret.pages.homescreen.emulator.HomeScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * Класс шагов теста FatSecret (без проверок)
 */
public class StepsAll {
    private static AppiumDriver<MobileElement> driver;

    public StepsAll(AppiumDriver appiumDriver) {
        driver = appiumDriver;
    }

    @Step("Открыть приложение с рабочего стола {app}")
    public void openApp(String app) {
        HomeScreen homeScreen = new HomeScreen(driver);
        homeScreen.getAllApps();
        homeScreen.getApp(app);
    }

    @Step("Зарегистрироваться в приложении с параметрами {email}, {name}, {password}," +
            "{goal}, {gender}, {activity}, {weight}, {weightToChange}")
    public static void signUp(AuthPage authPage, Goal goal, Gender gender, Activity activity,
                              String weight, String height, String birthdate,
                              String email, String password, String name,
                              String weightToChange) {
        authPage.createAnAccount(goal, gender, activity, weight, height, birthdate, email,
                password, name, weightToChange);
    }

    @Step("Выйти из учетной записи")
    public static void signOut(MePage mePage) {
        mePage = new MePage(driver);
        mePage.signOut();
    }

    @Step("Авторизоваться под {name} {password}")
    public static void signIn(String name, String password) {
        AuthPage authPage = new AuthPage(driver);
        authPage.signIn(name, password);
    }

    @Step("За авторизованного пользователя перейти на вкладку Diary и добавить в {meal} {products}")
    public static void addProducts(String meal, List<String> products) {
        MePage mePage = new MePage(driver);
        mePage.goDiary();
        DiaryPage fatSecretDiaryPage = new DiaryPage(driver);
        fatSecretDiaryPage.addProducts(meal, products);
    }

    @Step("В добавленных продуктах изменить количество {productName} на {amount} {measurement} ")
    public static void changeAmountOfFood(DiaryPage diaryPage, String productName,
                                          String amount, String measurement) {
        diaryPage.changeAmountOfAddedProduct(productName, amount, measurement);
        Assertions.assertEquals(diaryPage.getAddedProductMeasurement(productName), amount + " " + measurement, "" +
                "Размер продукта " + productName + "не соответствует измененным параметрам");
    }

    @Step("В добавленных продуктах изменить количество {productName} на {amount} {measurement} ")
    public static void addProductsAndChangeAmountOfFood(DiaryPage diaryPage, String meal, List<String> products, String productName,
                                                        String amount, String measurement) {
        diaryPage.addProducts(meal, products);
        diaryPage.changeAmountOfAddedProduct(productName, amount, measurement);
        Assertions.assertEquals(diaryPage.getAddedProductMeasurement(productName), amount + " " + measurement, "" +
                "Размер продукта " + productName + "не соответствует измененным параметрам");
    }

    @Step("Добавить в {meal} продукты {products} и изменить количество {productName} на {amount} {measurement} ")
    public static void addProductChangeAmountOfFood(String meal, List<String> products, String productName,
                                                    String amount, String measurement) {
        DiaryPage fatSecretDiaryPage = new DiaryPage(driver);
        fatSecretDiaryPage.addProducts(meal, products);
        fatSecretDiaryPage.changeAmountOfAddedProduct(productName, amount, measurement);
    }

    @Step("Добавить в {meal} продукты {products} и удалить из списка продуктов {productsToDelete} ")
    public static void addAndDeleteProducts(String meal, List<String> products, List<String> productsToDelete) {
        DiaryPage fatSecretDiaryPage = new DiaryPage(driver);
        fatSecretDiaryPage.addProducts(meal, products);
        fatSecretDiaryPage.deleteProducts(productsToDelete);
    }

    @Step("Удалить из списка продуктов {productsToDelete} ")
    public static void deleteProducts(DiaryPage diaryPage, List<String> productsToDelete) {
        diaryPage.deleteProducts(productsToDelete);
    }
}
