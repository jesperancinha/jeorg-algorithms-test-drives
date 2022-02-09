package org.jesperancinha.math;

import org.jesperancinha.math.exception.NotOddDimensionException;

public class MagicSquareBuilder {

    private int dim;

    public MagicSquareBuilder dim(final int dim) {
        if (dim % 2 == 0) {
            throw new NotOddDimensionException();
        }
        this.dim = dim;
        return this;
    }

    public MagicSquare build() {
        MagicSquare magicSquare = new MagicSquare(this.dim);
        int startX = dim / 2;
        int startY = 0;
        magicSquare.setCoordValue(startX, startY, 1);
        magicSquare.fillGaps(startX, startY);
        return magicSquare;
    }

}
