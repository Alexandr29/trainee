package com.nixsolutions.laba2;

public class Main {
    public static void main(String[] args) {
        FractionNumberOperationImpl fractionNumberOperation = new FractionNumberOperationImpl();
        FractionNumberImpl fractionNumber = new FractionNumberImpl(10, 225);
        FractionNumberImpl fractionNumber1 = new FractionNumberImpl(10, 150);

        System.out.println(fractionNumber.toStringValue());
        System.out.println(fractionNumber1.toStringValue());

        System.out.println(
                fractionNumberOperation.add(fractionNumber, fractionNumber1)
                        .toStringValue());
        System.out.println(
                fractionNumberOperation.mul(fractionNumber, fractionNumber1)
                        .toStringValue());
        System.out.println(
                fractionNumberOperation.div(fractionNumber, fractionNumber1)
                        .toStringValue());
        System.out.println(
                fractionNumberOperation.sub(fractionNumber, fractionNumber1)
                        .toStringValue());

    }
}
