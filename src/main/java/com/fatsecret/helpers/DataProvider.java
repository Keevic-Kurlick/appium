package com.fatsecret.helpers;

import com.fatsecret.enums.Activity;
import com.fatsecret.enums.Gender;
import com.fatsecret.enums.Goal;
import org.junit.jupiter.params.provider.Arguments;
import properties.Properties;

import java.util.List;
import java.util.stream.Stream;

public class DataProvider {

    /**
     * Устанавливает аргументы для параметров тестирования регистрации в FatSecret
     *
     * @return Stream аргументов для параметров тестового метода
     */
    public static Stream<Arguments> provideCheckingFatSecretAuth() {

        return Stream.of(
                Arguments.of(Goal.WEIGHT_GAIN, Gender.MALE, Activity.VERY_ACTIVE,
                        "78", "184", "08/Dec/1991", "tovqsaiwerq514@gmail.com", "Krakva32@@", "Qehkstrmmo73622", "20")
        );
    }

    /**
     * Устанавливает аргументы для параметров тестирования дневника питания в FatSecret
     *
     * @return Stream аргументов для параметров тестового метода
     */
    public static Stream<Arguments> provideCheckingFatSecretProductsAmount() {
        return Stream.of(
                Arguments.of(Properties.mainProperties.userName(), Properties.mainProperties.userPassword(), "Breakfast", List.of("milk", "cottage cheese", "apple"), List.of("milk", "apple"), "milk", "200", "ml")
        );
    }
}
