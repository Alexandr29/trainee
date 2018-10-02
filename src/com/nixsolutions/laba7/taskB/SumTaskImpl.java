package com.nixsolutions.laba7.taskB;

import interfaces.task7.executor.SumTask;

import java.math.BigInteger;
import java.util.Random;

public class SumTaskImpl implements SumTask {

    private long max;
    private BigInteger result;
    private int tryCount;

    @Override public String toString() {
        return "SumTaskImpl";
    }

    public SumTaskImpl() {
    }

    @Override public void setCount(int count) {

        this.tryCount = count;
    }

    @Override public void setMax(long max) {
        this.max = max;
    }

    @Override public BigInteger getRandom() {
        Random random = new Random();
        BigInteger result = new BigInteger(4, random);
        return result;

    }

    @Override public BigInteger getResult() {
        return result;
    }

    @Override public int getTryCount() {
        return 0;
    }

    @Override public void incTryCount() {
        tryCount++;
    }

    @Override public boolean execute() throws Exception {
        try {
            for (int i = tryCount; i != 0; i--) {
                BigInteger bigInteger = getRandom();
                result = result.add(bigInteger);
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
