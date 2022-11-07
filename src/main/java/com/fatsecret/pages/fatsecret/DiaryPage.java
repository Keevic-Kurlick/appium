package com.fatsecret.pages.fatsecret;

import com.fatsecret.helpers.appium.AndroidGestures;
import com.fatsecret.enums.Direction;
import com.fatsecret.helpers.wait.WaitUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Класс дневника питания FatSecret авторизованного пользователя
 */
//TODO: исключения
public class DiaryPage extends FatSecretAbstract {
    private Map<String, WebElement> mealHolders;
    private By autosuggestionResult = By.id("com.fatsecret.android:id/auto_suggestion_type_icon");
    private By foodHolderTitle = By.id("com.fatsecret.android:id/food_journal_heading_row_title");

    private By productTitle = By.id("com.fatsecret.android:id/title_description");
    private By clearProductButton = By.id("com.fatsecret.android:id/trailing_icon");
    private By rightIcon = By.id("com.fatsecret.android:id/chevron_right_icon");
    private By addedProductCalories = By.id("com.fatsecret.android:id/food_journal_item_row_title_energy");
    private By totalMealCalories = By.id("com.fatsecret.android:id/food_journal_heading_row_total_calories");
    private By addedProductHolder = By.id("com.fatsecret.android:id/cnt");
    private By addedProductTitle = By.id("com.fatsecret.android:id/food_journal_item_row_title");
    private By addedProductPortion = By.id("com.fatsecret.android:id/food_journal_item_row_details");
    private By saveProduct = By.id("com.fatsecret.android:id/multi_add_save_text");
    private By checkboxProduct = By.id("com.fatsecret.android:id/multi_add_item_checked");
    private By productItem = By.id("com.fatsecret.android:id/multi_add_item_row");
    private By closeProductInput = By.id("com.fatsecret.android:id/close_icon");
    private By foodSearchInput = By.id("com.fatsecret.android:id/edit_text");
    private By foodHolder = By.id("com.fatsecret.android:id/food_journal_add_food_holder");
    private By copyMealTextButton = By.id("com.fatsecret.android:id/copy_meal_text");
    private By saveFoodButton = By.id("com.fatsecret.android:id/fem_save_btn");
    private By portionsCountContainer = By.id("com.fatsecret.android:id/portions_count_container");
    private By foodMeasure = By.id("com.fatsecret.android:id/fem_dialog_spinner_item_text");

    private By doneButton = By.id("com.fatsecret.android:id/done_btn");
    private By rateExperienceLike = By.id("com.fatsecret.android:id/image_icon_4");

    public DiaryPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
        WaitUtils.waitUntilVisibilityOfElementLocated(foodHolder);
    }

    /**
     * Возвращает список приемом пищи
     *
     * @return Список приемов пищи
     */
    public List<String> foodHolders() {
        return new ArrayList<>(mealHolders.keySet());
    }

    /**
     * Добавляет продукты в прием пищи
     *
     * @param meal         Прием пищи
     * @param productNames Наименования продуктов
     */
    public void addProducts(String meal, List<String> productNames) {
        mealHolders = new HashMap<>();
        List<WebElement> foodHolders = appiumDriver.findElements(foodHolder);
        foodHolders.forEach(holder -> mealHolders.put(holder.findElement(foodHolderTitle).getText(), holder));
        mealHolders.get(meal).click();
        WaitUtils.waitUntilVisibilityOfElementLocated(foodSearchInput).click();
        WaitUtils.waitUntilVisibilityOfElementLocated(closeProductInput);
        productNames.forEach(product -> {
            appiumDriver.findElement(foodSearchInput).sendKeys(product);
            WaitUtils.waitUntilVisibilityOfElementLocated(autosuggestionResult).click();
            WaitUtils.waitUntilVisibilityOfElementLocated(productItem);
            appiumDriver.findElement(checkboxProduct).click();
            appiumDriver.findElement(foodSearchInput).click();
            appiumDriver.findElement(clearProductButton).click();
        });

        appiumDriver.findElement(saveProduct).click();

        WaitUtils.waitUntilVisibilityOfElementLocated(rateExperienceLike).click();
        WaitUtils.waitUntilElementClickable(appiumDriver.findElement(doneButton)).click();

    }

    /**
     * Возвращает список добавленных продуктов
     *
     * @return Список добавленных продуктов
     */
    private List<WebElement> getAddedProducts() {
        WaitUtils.waitUntilVisibilityOfElementLocated(foodHolder);
        List<WebElement> addedProducts = appiumDriver.findElements(addedProductHolder);
        return addedProducts;
    }

    /**
     * Возвращает наименования добавленных продуктов
     *
     * @return Список наименований добавленных продуктов
     */
    public List<String> getAddedProductsTitles() {
        List<String> prodTitles = new ArrayList<>();
        getAddedProducts().forEach(prod -> prodTitles.add(prod.findElement(addedProductTitle).getText().toLowerCase()));
        return prodTitles;
    }

    /**
     * Возвращает единицу измерения добавленного продукта по наименованию продукта
     *
     * @param productName Наименование продукта
     * @return Единица измерения (ml, g, cup, etc)
     */
    public String getAddedProductMeasurement(String productName) {
        WebElement product = getAddedProducts().stream().filter(prod -> prod.findElement(addedProductTitle).getText().toLowerCase().contains(productName.toLowerCase()))
                .findFirst().get();
        return product.findElement(addedProductPortion).getText();
    }

    /**
     * Изменяет количество и единицу измерения добавленного продукта
     *
     * @param productName Наименование добавленного продукта
     * @param amount      Количество продукта
     * @param measurement Единица измерения
     */
    public void changeAmountOfAddedProduct(String productName, String amount, String measurement) {
        WaitUtils.waitUntilVisibilityOfElementLocated(foodHolder);

        getAddedProducts().stream()
                .filter(prod -> prod.findElement(addedProductTitle).getText().toLowerCase().contains(productName.toLowerCase()))
                .findFirst().get().click();

        WaitUtils.waitUntilVisibilityOfElementLocated(portionsCountContainer).click();
        actions.click(WaitUtils.waitUntilVisibilityOfElementLocated(portionsCountContainer))
                .sendKeys(appiumDriver.findElement(portionsCountContainer), amount)
                .perform();

        WaitUtils.waitUntilVisibilityOfElementLocated(foodMeasure).click();
        List<WebElement> measureValues = appiumDriver.findElements(foodMeasure);
        measureValues.stream().filter(measure -> measure.getText().toLowerCase().contains(measurement.toLowerCase()))
                .findFirst().get().click();

        WaitUtils.waitUntilVisibilityOfElementLocated(saveFoodButton).click();
    }

    /**
     * Удаляет продукт по его наименованию
     *
     * @param productName Наименование продукта
     */
    public void deleteProduct(String productName) {
        MobileElement product = (MobileElement) getAddedProducts().stream().filter(prod ->
                prod.findElement(addedProductTitle).getText().toLowerCase().contains(productName.toLowerCase())).findFirst().get();
        AndroidGestures.swipeElementAndroidToBorders(appiumDriver, product.findElement(rightIcon), Direction.LEFT);
    }

    /**
     * Удаляет продукты из списка
     *
     * @param products Список продуктов к удалению
     */
    public void deleteProducts(List<String> products) {
        products.forEach(productToDelete -> {
            WaitUtils.waitUntilVisibilityOfElementLocated(foodHolder);
            MobileElement product = (MobileElement) getAddedProducts().stream().filter(prod ->
                    prod.findElement(addedProductTitle).getText().toLowerCase().contains(productToDelete.toLowerCase())).findFirst().get();
            AndroidGestures.swipeElementAndroidToBorders(appiumDriver, product.findElement(rightIcon), Direction.LEFT);
        });
    }

    /**
     * Удаляет все продукты
     */
    public void deleteAllProducts() {
        getAddedProducts().forEach(prod -> actions.clickAndHold(prod.findElement(addedProductCalories))
                .moveToElement(appiumDriver.findElement(copyMealTextButton))
                .release().perform());
    }

    /**
     * Проверяет, остались ли продукты из списка на странице
     *
     * @param productNames Список продуктов
     * @return true - остались, false - их нет
     */
    public boolean areProductsPresented(List<String> productNames) {
        AtomicBoolean isPresented = new AtomicBoolean(false);
        productNames.forEach(product -> {
            WaitUtils.waitUntilVisibilityOfElementLocated(foodHolder);
            isPresented.set(getAddedProductsTitles().contains(product.toLowerCase()));
        });
        return isPresented.get();
    }

    /**
     * Проверяет, остался ли продукт на странице
     *
     * @param productName Наименование продукта
     * @return true - остался, false - его нет
     */
    public boolean isProductPresented(String productName) {
        WaitUtils.waitUntilVisibilityOfElementLocated(foodHolder);
        return getAddedProductsTitles().contains(productName.toLowerCase());
    }

    /**
     * Подсчитывает и возвращает сумму калорий всех продуктов
     *
     * @return Сумма калорий
     */
    public int getSumOfProductCalories() {
        AtomicInteger sum = new AtomicInteger();
        getAddedProducts().forEach(prod -> sum.addAndGet(Integer.valueOf(prod.findElement(addedProductCalories).getText())));
        return sum.get();
    }

    /**
     * Возвращает сумму калорий за прием пищи со страницы дневника
     *
     * @return Сумма калорий за прием пищи
     */
    public int getTotalMealCalories() {
        return Integer.parseInt(appiumDriver.findElement(totalMealCalories).getText());
    }
}
