package com.pablo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class OnlinerTestExample {
        @BeforeAll
        static void setUp() {
            Configuration.holdBrowserOpen = true;
            Configuration.browserSize = "1920x1080";
            open("https://catalog.onliner.by");
        }
        @DisplayName("Checkcategory")
        @Test void categoryTest() {
            String testData = "Электроника",
                    expectedResult = "Гаджеты";

           $(".catalog-navigation-classifier").parent().$(byText(testData)).click();
       $$(".catalog-navigation-list__aside-list")
               .find(Condition.text(expectedResult));
    }

}
