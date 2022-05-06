package com.pablo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

@DisplayName("TestMethodSource1")  // Подписывать тесты, понятное отображение
public class ParametrizeTestsMethodSource {
    static Stream<Arguments> TestMethodSource() {
        return Stream.of(
                Arguments.of("Vladislav, ", "Privet", List.of(12, 13, 10)),
                Arguments.of("Privet", "Poka", List.of("lopa", 13, 10))
        );
    }

    @MethodSource("TestMethodSource")
    @ParameterizedTest(name = "TestMethodSource")
    void Test2MethodSource(String value1, String value2, List<Long> value3) {
        System.out.println(value1 + value2 + value3);
    }
}

