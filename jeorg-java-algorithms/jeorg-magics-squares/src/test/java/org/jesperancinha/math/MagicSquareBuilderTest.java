package org.jesperancinha.math;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;

@Slf4j
public class MagicSquareBuilderTest {

    @Test
    void testBuild3() {
        assertAll(() -> new MagicSquareBuilder().dim(3).build());
    }

    @Test
    void testBuild5() {
        assertAll(() -> new MagicSquareBuilder().dim(5).build());
    }

    @Test
    void testBuild7() {
        assertAll(() -> new MagicSquareBuilder().dim(7).build());
    }
}