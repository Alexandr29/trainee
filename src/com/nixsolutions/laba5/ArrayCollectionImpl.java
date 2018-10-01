package com.nixsolutions.laba5;
import interfaces.task5.ArrayCollection;
import interfaces.task5.ArrayIterator;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;


public class ArrayCollectionImpl<E> implements ArrayCollection<E> {
    @Override public String toString() {
        return "ArrayCollectionImpl{" + "elementData=" + Arrays
                .toString(elementData) + '}';
    }

    public ArrayCollectionImpl() {
    }

    private int size = 0;
    private E[] elementData = (E[]) new Object[0];
    //transient Object[] elementData;
    private transient int modCount = 0;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private static final int DEFAULT_CAPACITY = 10;

    @Override public int size() {
        return size;
    }

    @Override public boolean isEmpty() {
        return size == 0;
    }

    @Override public boolean contains(Object o) {

        return indexOf(o) >= 0;
    }

    @Override public Iterator<E> iterator() {
        return new ArrayIteratorImpl();
    }

    @Override public Object[] toArray() {
        return elementData;
        //return Arrays.copyOf(elementData, size);
    }

    @Override public boolean add(final E e) {

        if (size == elementData.length) {
            increaseArray();
            elementData[size] = e;
            size++;
        } else {
            elementData[size] = e;
            size++;
        }

        return true;

        //        ensureCapacityInternal(size + 1);  // Increments modCount!!
        //        elementData[size++] = o;
        //        return true;
    }

    private void increaseArray() {
        E[] newArray = (E[]) new Object[elementData.length + 1];
        System.arraycopy(elementData, 0, newArray, 0, elementData.length);
        elementData = newArray;
    }

    @Override public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++)
                if (elementData[index] == null) {
                    fastRemove(index);
                    reduceCapacity(1);
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (o.equals(elementData[index])) {
                    fastRemove(index);
                    reduceCapacity(1);
                    return true;
                }
        }
        return false;
    }

    private void reduceCapacity(int i) {
        Object[] newArray = new Object[elementData.length - i];
        System.arraycopy(elementData, 0, newArray, 0, newArray.length);
        elementData = (E[]) newArray;
    }

    @Override public boolean addAll(Collection c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        ensureCapacityInternal(size + numNew);  // Increments modCount
        System.arraycopy(a, 0, elementData, size, numNew);
        size += numNew;
        return numNew != 0;
    }

    @Override public void clear() {
        modCount++;

        // clear to let GC do its work
        for (int i = 0; i < size; i++)
            elementData[i] = null;

        size = 0;
    }

    @Override public boolean retainAll(Collection c) {
        Objects.requireNonNull(c);
        return batchRemove(c, true);

    }

    @Override public boolean removeAll(Collection c) {
        //        boolean modified = false;
        //
        //        for (Object object : c) {
        //            if (remove(object)) {
        //                modified = true;
        //
        //            }
        //        }
        //
        //        return modified;

        Objects.requireNonNull(c);
        return batchRemove(c, false);
    }

    @Override public boolean containsAll(Collection c) {
        for (Object e : c)
            if (!contains(e))
                return false;
        return true;
    }

    @Override public Object[] toArray(Object[] a) {
        return a.clone();
    }

    @Override public Object[] getArray() {
        return elementData;
    }

    @Override public void setArray(E[] objects) {
        if (objects == null) {
            throw new NullPointerException();
        }
        elementData = objects;
        //langth = elementData.length;
        size = elementData.length;
    }

    private boolean batchRemove(Collection<?> c, boolean complement) {

        final Object[] elementData = this.elementData;
        int r = 0, w = 0;
        boolean modified = false;
        try {
            for (; r < size; r++)
                if (c.contains(elementData[r]) == complement)
                    elementData[w++] = elementData[r];
        } finally {
            // Preserve behavioral compatibility with AbstractCollection,
            // even if c.contains() throws.
            if (r != size) {
                System.arraycopy(elementData, r, elementData, w, size - r);
                w += size - r;
            }
            if (w != size) {
                // clear to let GC do its work
                for (int i = w; i < size; i++)
                    elementData[i] = null;
                modCount += size - w;
                size = w;

                modified = true;
            }
            reduceCapacity(modCount);
        }

        return modified;
    }

    private void fastRemove(int index) {
        modCount++;
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index + 1, elementData, index,
                    numMoved);
        elementData[--size] = null; // clear to let GC do its work
    }

    private int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (elementData[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }

    private void ensureExplicitCapacity(int minCapacity) {
        //modCount++;

        // overflow-conscious code
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    private static int calculateCapacity(Object[] elementData,
            int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }

    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }

    private class ArrayIteratorImpl implements ArrayIterator<E> {
        int cursor;       // index of next element to return
        //int lastRet = -1; // index of last element returned; -1 if no such
        private int current;
        //private boolean nextWasCall;

        //int expectedModCount = modCount;
        public ArrayIteratorImpl() {
        }

        @Override public Object[] getArray() {
            return elementData;
            //return new Object[0];
        }

        public boolean hasNext() {
            return cursor != size;
        }
        //        @Override
        //        public void remove() {
        //            if (!nextWasCall) {
        //                throw new IllegalStateException();
        //            }
        //            if (!hasNext()) {
        //                throw new IllegalStateException();
        //            }
        //            fastRemove(current);
        //            cursor--;
        //            nextWasCall = false;
        //        }

        @Override public E next() throws NoSuchElementException {
            if (cursor >= size) {
                throw new NoSuchElementException();
            } else {
                current = cursor++;
                //nextWasCall = true;
                return elementData[current];
            }

            //            int i = cursor;
            //            if (i >= size)
            //                throw new NoSuchElementException();
            //            Object[] elementData = ArrayCollectionImpl.this.elementData;
            //            if (i >= elementData.length)
            //                throw new ConcurrentModificationException();
            //            cursor = i + 1;
            //            return elementData[lastRet = i];
        }
    }

}
