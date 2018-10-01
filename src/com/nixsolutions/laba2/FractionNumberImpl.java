package com.nixsolutions.laba2;

import interfaces.task2.FractionNumber;

public class FractionNumberImpl implements FractionNumber {
    public FractionNumberImpl(int dividend, int divisor) {
        setDividendAndDivisor(dividend, divisor);
    }

    public FractionNumberImpl() {
    }

    // числитель
    private int dividend = 1;
    // знаменатель
    private int divisor = 1;

    private int getGreatestCommonDivisor(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return a + b;
    }

    private void setDividendAndDivisor(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor is 0");
        }

        int maximalCommonDivisor = getGreatestCommonDivisor(dividend, divisor);
        int sign = Integer.signum(dividend) * Integer.signum(divisor);
        this.dividend = Math.abs(dividend) / maximalCommonDivisor;
        this.divisor = Math.abs(divisor) / maximalCommonDivisor;
        if (sign < 0) {
            this.dividend *= -1;
        }

    }

    @Override public void setDividend(int dividend) {
        setDividendAndDivisor(dividend, this.divisor);
    }

    @Override public int getDividend() {
        return dividend;
    }

    @Override public void setDivisor(int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("The value can not be zero");
        }
        setDividendAndDivisor(this.dividend, divisor);
    }

    @Override public int getDivisor() {
        return divisor;
    }

    @Override public double value() {
        return dividend / divisor;
    }

    @Override public String toStringValue() {
        return dividend + "/" + divisor;
    }

    @Override public String toString() {
        return toStringValue();
    }
}
