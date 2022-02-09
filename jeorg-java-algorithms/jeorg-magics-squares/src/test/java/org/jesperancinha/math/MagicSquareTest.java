package org.jesperancinha.math;

import org.jesperancinha.math.exception.NotMagicSquareException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MagicSquareTest {

    @Test
    public void build() {
        final var square = new long[2][2];
        square[0][0] = 1;
        square[1][0] = 1;
        square[0][1] = 1;
        square[1][1] = 1;

        assertAll(() -> new MagicSquare(square));
    }

    @Test
    public void buildNull() {
        assertThrows(NullPointerException.class, () -> new MagicSquare(null));
    }

    @Test
    public void buildUnevenSquare() {
        final var square = new long[2][2];
        square[0][0] = 2;
        square[1][0] = 1;
        square[0][1] = 1;
        square[1][1] = 1;

        assertThrows(NotMagicSquareException.class, () -> new MagicSquare(square));
    }

}