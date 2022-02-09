package org.jesperancinha.math;


import lombok.extern.slf4j.Slf4j;
import org.jesperancinha.math.exception.NotMagicSquareException;

import java.io.PrintStream;
import java.util.Arrays;

@Slf4j
public class MagicSquare {

    private final long[][] square;

    private final int dim;

    public MagicSquare(int dim) {
        this.dim = dim;
        this.square = new long[dim][dim];
    }

    public MagicSquare(long[][] square) {
        this.dim = square.length;
        this.square = square;
        validate();
    }

    public void setCoordValue(int x, int y, long value) {
        this.square[y][x] = value;
    }

    public long getCoordValue(int x, int y) {
        return this.square[y][x];
    }

    private void validate() throws NotMagicSquareException {
        long sumRowOne = sum(getRowByIndex(0));
        checkRows(sumRowOne);
        checkColumns(sumRowOne);
    }

    private void checkColumns(long sumRowOne) {
        for (int j = 0; j < square.length; j++) {
            if (sum(getColumnByIndex(j)) != sumRowOne) {
                throw NotMagicSquareException.createByColumn(j);
            }
        }
    }

    private void checkRows(long sumRowOne) {
        for (int i = 1; i < square.length; i++) {
            if (sum(getRowByIndex(i)) != sumRowOne) {
                throw NotMagicSquareException.createByRow(i);
            }
        }
    }

    private long sum(long[] arrayInt) {
        return Arrays.stream(arrayInt).sum();
    }

    private long[] getRowByIndex(int index) {
        return square[index];
    }

    private long[] getColumnByIndex(int index) {

        long[] columns = new long[square.length];
        for (int i = 0; i < square.length; i++) {
            columns[i] = square[i][index];
        }
        return columns;
    }

    public void fillGaps(int startX, int startY) {
            var nextX = startX + 1;
            var nextY = startY - 1;

            var currentValue = getCoordValue(startX, startY);
            var nextValue = currentValue + 1;

            if (insideSquare(nextX, nextY)) {
                if (getCoordValue(nextX, nextY) == 0) {
                    setCoordValue(nextX, nextY, nextValue);
                } else {
                    nextY= startY+1;
                    nextX = startX;
                    if (getCoordValue(nextX, nextY) != 0) {
                        nextX = startX+1;
                        nextY = startY;
                    }
                    setCoordValue(nextX, nextY, nextValue);
                }
            } else if (!insideSquare(nextX, nextY)) {
                if (nextX < dim) {
                    nextY = findNextY(nextX, startY);
                    setCoordValue(nextX, nextY, nextValue);
                } else if (nextY >= 0) {
                    nextX = findNextX(startX, nextY);
                    setCoordValue(nextX, nextY, nextValue);
                } else {
                    nextY= startY+1;
                    nextX = startX;
                    if (getCoordValue(nextX, nextY) != 0) {
                        nextX = startX+1;
                        nextY = startY;
                    }
                    setCoordValue(nextX, nextY, nextValue);
                }
            }
            if (nextValue != dim * dim) {
                fillGaps(nextX, nextY);
            } else {
                validate();
            }

    }

    private int findNextX(int startX, int nextY) {
        var nextX = 0;
        while (getCoordValue(nextX, nextY) != 0 && nextX < startX) {
            nextX++;
        }
        return nextX;
    }

    private int findNextY(int nextX, int startY) {
        var nextY = dim - 1;
        while (getCoordValue(nextX, nextY) != 0 && nextY > startY) {
            nextY--;
        }
        return nextY;
    }

    private boolean insideSquare(int nextX, int nextY) {
        return nextX < square.length && nextY >= 0;
    }

    public void writeSquare(PrintStream out) {
        for (long[] longs : square) {
            for (int j = 0; j < square.length; j++) {
                out.print(longs[j]);
            }
            out.println();
        }
    }
}
