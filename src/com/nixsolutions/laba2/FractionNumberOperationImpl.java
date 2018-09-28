package com.nixsolutions.laba2;

import interfaces.task2.FractionNumber;
import interfaces.task2.FractionNumberOperation;

public class FractionNumberOperationImpl implements FractionNumberOperation {
    public FractionNumberOperationImpl() {
    }

    @Override public FractionNumberImpl add(FractionNumber a,
            FractionNumber b) {
        int dividend = a.getDividend() * b.getDivisor() + a.getDivisor() * b
                .getDividend();
        int divisor = a.getDivisor() * b.getDivisor();
        return new FractionNumberImpl(dividend, divisor);
    }

    @Override public FractionNumber sub(FractionNumber a, FractionNumber b) {
        int dividend = a.getDividend() * b.getDivisor() - a.getDivisor() * b
                .getDividend();
        int divisor = a.getDivisor() * b.getDivisor();
        return new FractionNumberImpl(dividend, divisor);
    }

    @Override public FractionNumber mul(FractionNumber a, FractionNumber b) {
        int dividend = a.getDividend() * b.getDividend();
        int divisor = a.getDivisor() * b.getDivisor();
        return new FractionNumberImpl(dividend, divisor);
    }

    @Override public FractionNumber div(FractionNumber a, FractionNumber b) {
        int dividend = a.getDividend() * b.getDivisor();
        int divisor = a.getDivisor() * b.getDividend();
        if (divisor == 0) {
            throw new ArithmeticException("Divide by zero");
        }
        return new FractionNumberImpl(dividend, divisor);
    }
}
