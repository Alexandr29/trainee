package com.nixsolutions.laba8;

import interfaces.task8.CyclicCollection;
import interfaces.task8.CyclicItem;

import java.io.*;

public class CyclicCollectionImpl implements CyclicCollection, Serializable {
    private CyclicItem fstItem;
    private CyclicItem lastItem;
    private int size;

    public CyclicCollectionImpl() {
    }

    @Override public boolean add(CyclicItem cyclicItem) {
        if (size == 0) {
            fstItem = cyclicItem;
            fstItem.setNextItem(fstItem);
            lastItem = fstItem;
            size++;
        } else {
            boolean cont = isContain(cyclicItem);
            if (cont) {
                throw new IllegalArgumentException();
            } else {
                lastItem.setNextItem(cyclicItem);
                lastItem = cyclicItem;
                lastItem.setNextItem(fstItem);
                size++;
            }
        }

        return true;
    }

    @Override public void insertAfter(CyclicItem oldItem, CyclicItem newItem) {

        if (oldItem == null || newItem == null) {
            throw new NullPointerException();
        }

        if (!isContain(oldItem)) {
            throw new IllegalArgumentException();
        }

        if (isContain(newItem)) {
            throw new IllegalArgumentException();
        }

        CyclicItem befItem = lastItem;
        CyclicItem currItem = fstItem;
        CyclicItem nextItem = fstItem.nextItem();
        for (int i = 0; i < size; i++) {
            if (currItem.equals(oldItem)) {
                if (size > 2) {
                    currItem.setNextItem(newItem);
                    newItem.setNextItem(nextItem);
                    size++;
                    return;
                } else if (size == 2) {
                    currItem.setNextItem(newItem);
                    newItem.setNextItem(nextItem);
                    fstItem = nextItem;
                    size++;
                    return;
                }
            }
            lastItem = currItem;
            currItem = nextItem;
            nextItem = nextItem.nextItem();
        }

    }

    @Override public CyclicItem getFirst() {
        return fstItem;
    }

    @Override public boolean remove(CyclicItem cyclicItem) {
        if (cyclicItem == null) {
            throw new NullPointerException();
        }

        if (size == 0) {
            return false;
        }

        CyclicItem befItem = lastItem;
        CyclicItem currItem = fstItem;
        CyclicItem nextItem = fstItem.nextItem();
        for (int i = 0; i < size; i++) {
            if (currItem.equals(cyclicItem)) {
                if (size > 2) {
                    currItem.setNextItem(null);
                    befItem.setNextItem(nextItem);
                    size--;
                    return true;
                } else if (size == 2) {
                    currItem.setNextItem(null);
                    befItem.setNextItem(nextItem);
                    fstItem = nextItem;
                    size--;
                    return true;
                } else {
                    fstItem = null;
                    size--;
                    return true;
                }
            }
            lastItem = currItem;
            currItem = nextItem;
            nextItem = nextItem.nextItem();
        }

        return false;
    }

    @Override public int size() {
        return size;
    }

    private boolean isContain(final CyclicItem item) {
        int n = size;
        CyclicItem currentItem = fstItem;
        while (n != 0) {
            boolean cont = currentItem.equals(item);
            if (cont) {
                return true;
            }
            currentItem = currentItem.nextItem();
            n--;
        }
        return false;
    }

    @Override public String toString() {
        return "CyclicCollectionImpl{" + "lastItem=" + lastItem + '}';
    }
}
