package org.jesperancinha.math.exception;

public class NotOddDimensionException extends RuntimeException {

    public NotOddDimensionException(){
        super("The dimension you provided isn't odd. This magic square algorithm only works with odd dimensions");
    }
}
