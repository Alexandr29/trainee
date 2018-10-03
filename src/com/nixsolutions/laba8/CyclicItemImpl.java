package com.nixsolutions.laba8;

import interfaces.task8.CyclicItem;

import java.io.Serializable;

public class CyclicItemImpl implements CyclicItem, Serializable {
    String string = "Hello";
    @Override public void setValue(Object o) {

    }

    @Override public Object getValue() {
        return null;
    }

    @Override public void setTemp(Object o) {

    }

    @Override public Object getTemp() {
        return null;
    }

    @Override public CyclicItem nextItem() {
        return null;
    }

    @Override public void setNextItem(CyclicItem cyclicItem) {

    }
}
