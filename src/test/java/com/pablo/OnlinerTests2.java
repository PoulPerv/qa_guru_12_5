package com.pablo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class OnlinerTests2 {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
    }
    @Disabled("not work")
    @DisplayName("CheckCategory")
    @ParameterizedTest
    @ValueSource(strings = {
            "Телевизоры",
            "Пылесосы"
    })
    void simSellTest(String testData) {
        Selenide.open("https://catalog.onliner.by");

        $(".fast-search__input").setValue(testData);
        $(".search").click();
                //.find(text(testData))
                //.shouldBe(visible);
    }


    static Stream<Arguments> methodSourceTest() {
        return Stream.of(
                Arguments.of("Телевизоры"),
                Arguments.of("Пылесосы")
        );
    }
    @Disabled("not work")
    @MethodSource("methodSourceTest")
    @ParameterizedTest
    void methodSourceTest(String testData) {
        Selenide.open("https://catalog.onliner.by");

        $(".fast-search__input").setValue(testData);
        $(".result__item result__item_category").$(byText(testData)).click();
        $("#schema-header__title js-schema-header_title").shouldHave(text(testData));
    }
}

