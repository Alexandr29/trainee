package com.nixsolutions.laba8;

import interfaces.task8.CyclicItem;

public class CyclicItemImpl implements CyclicItem {

    private Object value;
    private transient Object temp;
    private CyclicItem cyclicItem;

    @Override public void setValue(Object value) {

        this.value = value;
    }

    @Override public Object getValue() {
        return value;
    }

    @Override public void setTemp(Object temp) {

        this.temp = temp;
    }

    @Override public Object getTemp() {
        return temp;
    }

    @Override public CyclicItem nextItem() {
        return null;
    }

    @Override public void setNextItem(CyclicItem cyclicItem) {
    }
}
