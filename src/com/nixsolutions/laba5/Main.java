package com.nixsolutions.laba5;

import com.nixsolutions.laba2.FractionNumberImpl;
import com.nixsolutions.laba2.FractionNumberOperationImpl;
import interfaces.task2.FractionNumber;
import interfaces.task2.FractionNumberOperation;
import interfaces.task5.ArrayCollection;

import java.util.Arrays;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        Collection<FractionNumber> numbers = new ArrayCollectionImpl<>();
        numbers.add(new FractionNumberImpl(1, 1));
        numbers.add(new FractionNumberImpl(1, 2));
        numbers.add(new FractionNumberImpl(1, 2));

        FractionNumberOperation fno = new FractionNumberOperationImpl();

        FractionNumber fnRes = new FractionNumberImpl(0, 1);

        for (FractionNumber fractionNumber : numbers) {
            fnRes = fno.add(fnRes, fractionNumber);
        }

        System.out.println(fnRes.toStringValue());

        ArrayCollection<Double> arrayCollection = new ArrayCollectionImpl<>();
        //ArrayIterator<Double> it = (ArrayIterator<Double>) arrayCollection
        //        .iterator();

        Double[] doubleArray = { 1d, 2d, 3d };

        arrayCollection.add(-doubleArray[0]);
        arrayCollection.add(doubleArray[0]);
        arrayCollection.add(doubleArray[2]);

        boolean ddd = arrayCollection.retainAll(Arrays.asList(doubleArray));
        System.out.println(ddd);

        System.out.println("end");
    }
}
