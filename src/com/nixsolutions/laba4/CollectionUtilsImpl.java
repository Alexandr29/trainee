package com.nixsolutions.laba4;

import interfaces.task4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class CollectionUtilsImpl implements CollectionUtils {
    public CollectionUtilsImpl() {
    }

    @Override public List<Integer> union(Collection<Integer> collection,
            Collection<Integer> collection1) {
        if (collection == null || collection1 == null) {
            throw new NullPointerException("a или b == null");
        }
        List<Integer> temp = new ArrayList<>();
        temp.addAll(collection);
        temp.addAll(collection1);
        return temp;
    }

    @Override public List<Integer> intersection(Collection<Integer> collection,
            Collection<Integer> collection1) {
        if (collection == null || collection1 == null) {
            throw new NullPointerException("a или b == null");
        }
        List<Integer> rtnList = new ArrayList<>();
        for (Integer dto : collection) {
            if (collection1.contains(dto)) {
                rtnList.add(dto);
            }
        }
        return rtnList;
    }

    @Override public Set<Integer> intersectionWithoutDuplicate(
            Collection<Integer> collection, Collection<Integer> collection1) {
        if (collection == null || collection1 == null) {
            throw new NullPointerException("a или b == null");
        }
        Set<Integer> rtnList = new HashSet<>();
        for (Integer dto : collection) {
            if (collection1.contains(dto)) {
                rtnList.add(dto);
            }
        }
        return rtnList;
    }

    @Override public Collection<Integer> difference(
            Collection<Integer> collection, Collection<Integer> collection1) {
        if (collection == null || collection1 == null) {
            throw new NullPointerException("a или b == null");
        }
        collection.removeAll(collection1);
        return collection;
    }

    public static void main(String[] args) {
        CollectionUtilsImpl collectionUtils = new CollectionUtilsImpl();
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            arr1.add(i + 1);
            if (arr1.get(i) == 10) {
                arr1.add(10);
                arr1.add(10);
            }
        }
        for (int i = 0; i < 10; i++) {
            arr2.add(i + 5);
        }
        System.out.println("list 1: " + arr1);
        System.out.println("list 2: " + arr2);

        System.out.println("union:  " + collectionUtils.union(arr1, arr2));
        System.out.println(
                "intersection:  " + collectionUtils.intersection(arr1, arr2));
        System.out.println(
                "intersection without duplicates:  " + collectionUtils
                        .intersectionWithoutDuplicate(arr1, arr2));
        System.out.println(
                "difference:  " + collectionUtils.difference(arr1, arr2));

    }

}
