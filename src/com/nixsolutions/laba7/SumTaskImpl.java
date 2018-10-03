package com.nixsolutions.laba7;

import interfaces.task7.executor.SumTask;

import java.math.BigInteger;
import java.util.Random;

public class SumTaskImpl implements SumTask {

    public SumTaskImpl() {
    }

    private long max;
    private BigInteger result = BigInteger.valueOf(0);
    private int tryCount = 1;

    public SumTaskImpl(long max) {
        this.max = max;
    }

    @Override public String toString() {
        return "SumTaskImpl";
    }

    @Override public void setCount(int count) {

        this.tryCount = count;
    }

    @Override public void setMax(long max) {
        if(max<1){
            throw new IllegalArgumentException("max < 1");
        }

        this.max = max;
    }

    @Override public BigInteger getRandom() {
        BigInteger bigInteger = new BigInteger(
                String.valueOf(max));// uper limit
        Random rnd = new Random();
        int maxNumBitLength = bigInteger.bitLength();

        BigInteger aRandomBigInt;
        aRandomBigInt = new BigInteger(maxNumBitLength, rnd);
        return aRandomBigInt;

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

    @Override synchronized public boolean execute() throws Exception {
        //System.out.println(Thread.currentThread().getName() + " execute SumTask");
        try {
            for (int i = tryCount; i != 0; i--) {

                result = result.add(getRandom());
                //result = result.add(aRandomBigInt);

            }//System.out.println(result);

        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
