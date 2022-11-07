package tests.com.fatsecret;

import com.fatsecret.enums.Activity;
import com.fatsecret.enums.Gender;
import com.fatsecret.enums.Goal;
import com.fatsecret.pages.fatsecret.AuthPage;
import com.fatsecret.pages.fatsecret.DiaryPage;
import com.fatsecret.pages.fatsecret.MePage;
import com.fatsecret.steps.StepsAssert;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static com.fatsecret.steps.StepsAll.*;

public class FatSecretTests extends BaseTests {

    @Feature("Проверка регистрации, авторизации в FatSecret")
    @DisplayName("Проверка регистрации, авторизации, разлогинивания в FatSecret")
    @ParameterizedTest
    @MethodSource("com.fatsecret.helpers.DataProvider#provideCheckingFatSecretAuth")
    public void testAuthorizationFatSecret(Goal goal, Gender gender, Activity activity,
                                           String weight, String height, String birthdate,
                                           String email, String password, String name,
                                           String weightToChange) {
        AuthPage authPage = new AuthPage(driver);
        signUp(authPage, goal, gender, activity, weight, height, birthdate,
                email, password, name, weightToChange);
        MePage mePage = new MePage(driver);
        StepsAssert.checkSignUp(mePage, email, weight, name);
        signOut(mePage);
        StepsAssert.checkSignOut();
        signIn(name, password);
        StepsAssert.checkSignIn(name);

    }

    @Feature("Проверка дневника питания в FatSecret")
    @DisplayName("Проверка добавления, изменения, удаления продуктов в дневнике в FatSecret")
    @ParameterizedTest
    @MethodSource("com.fatsecret.helpers.DataProvider#provideCheckingFatSecretProductsAmount")
    public void voidTestDiaryFatSecret(String name, String password, String meal, List<String> products, List<String> productsToDelete, String productName,
                                       String amount, String measurement) {
        signIn(name, password);
        addProducts(meal, products);
        DiaryPage diaryPage = new DiaryPage(driver);
        StepsAssert.checkIfProductsWereAdded(diaryPage, products);
        changeAmountOfFood(diaryPage, productName, amount, measurement);
        StepsAssert.checkIfAmountChanged(diaryPage, productName, amount, measurement);
        StepsAssert.checkCorrectCalories(diaryPage);
        deleteProducts(diaryPage, productsToDelete);
        StepsAssert.checkIfProductsAreRemoved(diaryPage, productsToDelete);
    }
}
