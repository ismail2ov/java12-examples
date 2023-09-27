package com.github.ismail2ov;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class TeeingCollectorTest {

    @Test
    void testStreamWithTwoCollectors() {
        Stream<Integer> numbers = new Random().ints(100).boxed();

        Throwable thrown = catchThrowable(() -> {
            int min = numbers.collect(Collectors.minBy(Integer::compareTo)).orElseThrow();
            int max = numbers.collect(Collectors.maxBy(Integer::compareTo)).orElseThrow();
        });

        assertThat(thrown)
            .isInstanceOf(IllegalStateException.class)
            .hasMessageContaining("stream has already been operated upon or closed");
    }

    @Test
    void testStreamWithCustomCollector() {
        Stream<Integer> numbers = new Random().ints(100).boxed();

        int[] result = numbers.collect(
            () -> new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE},
            (minMax, i) -> {
                if (i < minMax[0]) {
                    minMax[0] = i;
                }
                if (i > minMax[1]) {
                    minMax[1] = i;
                }
            },
            (minMax1, minMax2) -> {
                if (minMax2[0] < minMax1[0]) {
                    minMax1[0] = minMax2[0];
                }
                if (minMax2[1] > minMax1[1]) {
                    minMax1[1] = minMax2[1];
                }
            });

        long range = (long) result[1] - result[0];

        assertThat(range).isBetween(Long.MIN_VALUE, Long.MAX_VALUE);
    }


    @Test
    void testTeeingCollector() {
        Stream<Integer> numbers = new Random().ints(100).boxed();

        long range =
            numbers.collect(
                Collectors.teeing(
                    Collectors.minBy(Integer::compareTo),
                    Collectors.maxBy(Integer::compareTo),
                    (min, max) -> (long) max.orElseThrow() - min.orElseThrow()));

        assertThat(range).isBetween(Long.MIN_VALUE, Long.MAX_VALUE);
    }

}
