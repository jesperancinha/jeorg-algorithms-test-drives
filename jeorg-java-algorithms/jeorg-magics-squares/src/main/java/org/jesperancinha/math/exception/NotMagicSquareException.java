package org.jesperancinha.math.exception;

public class NotMagicSquareException extends RuntimeException {

    private NotMagicSquareException(final String message) {
        super(message);
    }

    public static NotMagicSquareException createByRow(int i) {
        return new NotMagicSquareException(String.format("Sum of row 0 does not match sum of row %d", i));
    }

    public static NotMagicSquareException createByColumn(int j) {
        return new NotMagicSquareException(String.format("Sum of row 0 does not match sum of column %d", j));
    }
}
