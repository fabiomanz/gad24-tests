package gad.simplesort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class DoubleDistributedMedianPivotTest {
    @ParameterizedTest
    @MethodSource({"numbersOfConsideredElementsDeviating",
            "allParameterDiffer"})
    @DisplayName("Based on Artemis")
    void doubleDistributedMedianPivotTest(int[] numbers, int[] expected, int numbersOfConsideredElements, int from,
                                          int to) {
        DualPivotFinder dualPivotFinder = DualPivotFinder
                .getMedianPivotDistributed(numbersOfConsideredElements);
        assertArrayEquals(expected, dualPivotFinder.findPivot(numbers, from, to));
    }

    @ParameterizedTest
    @MethodSource("notRequire")
    @DisplayName("General Tests not necessary")
    void doubleDistributedMedianPivotTest2(int[] numbers, int[] expected, int numbersOfConsideredElements, int from,
                                           int to) {
        DualPivotFinder dualPivotFinder = DualPivotFinder
                .getMedianPivotDistributed(numbersOfConsideredElements);
        assertArrayEquals(expected, dualPivotFinder.findPivot(numbers, from, to));
    }

    private static Stream<Arguments> numbersOfConsideredElementsDeviating() {
        return Stream.of(
                Arguments.of(
                        new int[]{4, 9, 1, 10, 2, 15, 13, 26, 17, 55, 3, 11},
                        new int[]{4, 6},
                        5,
                        0,
                        11));
    }

    private static Stream<Arguments> allParameterDiffer() {
        return Stream.of(
                Arguments.of(
                        new int[]{30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16,
                                15, 12, 9, 6, 3, 0},
                        new int[]{2, 6},
                        5,
                        0,
                        11),
                Arguments.of(
                        new int[]{30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16,
                                15, 12, 9, 6, 3, 0},
                        new int[]{14, 18},
                        5,
                        12,
                        21));
    }

    private static Stream<Arguments> notRequire() {
        return Stream.of(
                Arguments.of(
                        new int[]{4, 9, 1, 10, 2, 15, 13, 26, 17, 55, 3, 11},
                        new int[]{0, 6},
                        12,
                        0,
                        11),
                Arguments.of(
                        new int[]{4, 9, 1, 10, 2},
                        new int[]{2, 4},
                        3,
                        0,
                        4),
                Arguments.of(
                        new int[]{4, 9, 1, 10, 2, 15, 13, 26, 17, 55, 3, 11},
                        new int[]{0, 10},
                        3,
                        0,
                        11),
                Arguments.of(
                        new int[]{4, 9, 1, 10, 2, 15, 13, 26, 17, 55, 3, 11},
                        new int[]{0, 6},
                        4,
                        0,
                        11),
                Arguments.of(
                        new int[]{30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16,
                                15, 12, 9, 6, 3, 0},
                        new int[]{4, 8},
                        21,
                        0,
                        11),
                Arguments.of(
                        new int[]{5, 6, 5, 6, 55, 6, 5, 6, 55, 6, 5, 6, 5},
                        new int[]{4, 5},
                        13,
                        4,
                        8),
                Arguments.of(
                        new int[]{5, 6, 5, 6, 5, 6, 55, 6, 5, 6, 5, 6, 55, 6, 5, 6, 5, 6, 55,
                                6, 5, 6, 5, 6, 5},
                        new int[]{2, 3},
                        25,
                        2,
                        18),
                Arguments.of(
                        new int[]{5, 6, 5, 6, 5, 6, 55, 6, 5, 6, 5, 6, 55, 6, 5, 6, 5, 6, 55,
                                6, 5, 6, 5, 6, 5},
                        new int[]{2, 4},
                        8,
                        2,
                        18)
        );
    }
}