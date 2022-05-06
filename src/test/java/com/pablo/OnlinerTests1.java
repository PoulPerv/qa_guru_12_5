package com.pablo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class OnlinerTests1 {
    @BeforeAll
    static void setUp() {
        //Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        open("https://catalog.onliner.by");
    }
    @DisplayName("Checkcategory")
    @ParameterizedTest(name = "Checkcategory{0}, ожидаем результат: {1}")
    @CsvSource({"Электроника, Гаджеты",
            "Компьютеры и сети, Комплектующие",
            "Дом и сад, Кухня"})

    void categoryTest(String testData, String expectedResult) {
        $(".catalog-navigation-classifier").$(byText(testData)).click();
        $$(".catalog-navigation-list__aside-list")
                .find(Condition.text(expectedResult));

    }
}
