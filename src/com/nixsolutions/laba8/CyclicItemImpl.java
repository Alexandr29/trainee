package com.nixsolutions.laba8;

import interfaces.task8.CyclicItem;

import java.io.Serializable;

public class CyclicItemImpl implements CyclicItem, Serializable {
//    @Override public boolean equals(Object o) {
//        if (this == o)
//            return true;
//        if (o == null || getClass() != o.getClass())
//            return false;
//        CyclicItemImpl that = (CyclicItemImpl) o;
//        return Objects.equals(value, that.value) && Objects
//                .equals(temp, that.temp);
//    }
//
//    @Override public int hashCode() {
//        return Objects.hash(value, temp);
//    }

    private Object value;
    private transient Object temp;
    private CyclicItem nextItem;

    public CyclicItemImpl() {
        nextItem =this;
    }

    public CyclicItemImpl(Object value, Object temp) {
        super();
        this.temp = temp;
        this.value = value;
        nextItem =this;
    }

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
        return nextItem;
    }

    @Override public void setNextItem(CyclicItem nextItem) {
        this.nextItem = nextItem;
    }

    @Override public String toString() {
        return "CyclicItemImpl{" + "value=" + value + ", temp=" + temp + '}';
    }
}
