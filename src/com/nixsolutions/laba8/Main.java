package com.nixsolutions.laba8;

import interfaces.task8.CyclicCollection;
import interfaces.task8.CyclicItem;
import interfaces.task8.SerializableUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)
            throws FileNotFoundException, ClassNotFoundException {
        CyclicCollection cyclicCollection = new CyclicCollectionImpl();
        System.out.println("Objects before serialization:");
        for (int i = 0; i < 5; i++) {
            CyclicItem cyclicItem = new CyclicItemImpl();
            cyclicItem.setValue(i);
            cyclicItem.setTemp(i);
            cyclicCollection.add(cyclicItem);
            System.out.println(
                    "Value: " + cyclicItem.getValue() + " temp: " + cyclicItem
                            .getTemp());
        }

        String tempFilePath = "/home/NIX/asinkevich/IdeaProjects/trainee/test.txt";

        SerializableUtils serializableUtils = new SerializableUtilsImpl();
        serializableUtils.serialize(new FileOutputStream(tempFilePath),
                cyclicCollection);
        CyclicCollection deserializeCollection = (CyclicCollection) serializableUtils
                .deserialize(new FileInputStream(tempFilePath));

        CyclicItem item = deserializeCollection.getFirst();
        System.out.println("Objects after serialization:");
        for (int i = 0; i < deserializeCollection.size(); i++) {
            System.out.println(
                    "Value: " + item.getValue() + " temp: " + item.getTemp());
            item = item.nextItem();
        }

        serializableUtils.serialize(new FileOutputStream(tempFilePath), item);
        serializableUtils.serialize(new FileOutputStream(tempFilePath), item);

        CyclicItem firstDeserializeItem = (CyclicItem) serializableUtils
                .deserialize(new FileInputStream(tempFilePath));
        CyclicItem secondDeserializeItem = (CyclicItem) serializableUtils
                .deserialize(new FileInputStream(tempFilePath));
        System.out.println("First deserialize item: " + firstDeserializeItem
                + "\nSecond deserialize item: " + secondDeserializeItem
                + "\nAre First and Second equals? " + firstDeserializeItem
                .equals(secondDeserializeItem)
                + "\nAre First and Second the same? " + (firstDeserializeItem
                == secondDeserializeItem));

        ClassLoaderImpl classLoaderSub = new ClassLoaderImpl();
        classLoaderSub.setPath(
                "/home/NIX/asinkevich/IdeaProjects/trainee/src/com/nixsolutions/laba1/task1/Main.java");
        Class<?> loadClass = classLoaderSub
                .loadClass("com.nixsolutions.laba8.CyclicItemImpl");
        Arrays.stream(loadClass.getMethods()).forEach(System.out::println);
    }
}