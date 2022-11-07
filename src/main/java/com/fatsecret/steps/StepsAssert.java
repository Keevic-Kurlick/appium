package com.fatsecret.steps;

import com.fatsecret.pages.fatsecret.DiaryPage;
import com.fatsecret.pages.fatsecret.MePage;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class StepsAssert {
    private static AppiumDriver driver;

    public StepsAssert(AppiumDriver driver) {
        this.driver = driver;
    }
    @Step("Проверить, что пользователь {name} зарегистрировался и его почта и целевой вес правильно проставились")
    public static void checkSignUp(MePage mePage, String email, String weight, String name) {
        Assertions.assertTrue(mePage.isAuthenticated(), "Пользователь " + name + " не залогинился");
        Assertions.assertEquals(email, mePage.getEmail(),
                "Почта пользователя " + email
                        + " после регистрации не соответствует отображаемой почте " + mePage.getEmail());
        Assertions.assertEquals(weight, mePage.getWeight(), "Указанный вес пользователя "
                + weight + " после регистрации не соответствует отображаемому весу");
    }

    @Step("Проверить, что выход из учетной записи осуществлен")
    public static void checkSignOut() {
        MePage mePage = new MePage(driver);
        Assertions.assertFalse(mePage.isAuthenticated());
    }

    @Step("Проверить, что авторизация валидными данными пользователя {name} проходит")
    public static void checkSignIn(String name) {
        MePage mePage = new MePage(driver);
        Assertions.assertTrue(mePage.isAuthenticated(), "Пользователь " + name + " не залогинился.");
    }

    @Step("Проверить, что все продукты добавились")
    public static void checkIfProductsWereAdded(DiaryPage diaryPage, List<String> products) {
        Assertions.assertTrue(diaryPage.getAddedProductsTitles()
                .stream().allMatch(addedProduct -> products.stream().anyMatch(
                        searchProduct -> addedProduct.toLowerCase().contains(searchProduct.toLowerCase())
                )), "Не все продукты попали в список"
        );
    }

    @Step("Проверить, что количество продукта изменилось по заданным параметрам")
    public static void checkIfAmountChanged(DiaryPage diaryPage, String productName, String amount, String measurement) {
        Assertions.assertEquals(diaryPage.getAddedProductMeasurement(productName), amount + " " + measurement, "" +
                "Размер продукта " + productName + "не соответствует измененным параметрам");
    }

    @Step("Проверить, что продукты {productsToDelete} удалились")
    public static void checkIfProductsAreRemoved(DiaryPage diaryPage, List<String> productsToDelete) {
        Assertions.assertFalse(diaryPage.areProductsPresented(productsToDelete), productsToDelete + " не удалены");
    }


    @Step("Проверить корректность подсчета калорий")
    public static void checkCorrectCalories(DiaryPage diaryPage) {
        Assertions.assertEquals(diaryPage.getSumOfProductCalories(), diaryPage.getTotalMealCalories(),
                "Некорректный подсчёт калорий");
    }
}
