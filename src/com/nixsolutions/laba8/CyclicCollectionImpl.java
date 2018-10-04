package com.nixsolutions.laba8;

import interfaces.task8.CyclicCollection;
import interfaces.task8.CyclicItem;


public class CyclicCollectionImpl implements CyclicCollection {
    private CyclicItemImpl head;       // указатель на первый элемент
    private CyclicItemImpl tail;

    @Override public boolean add(CyclicItem cyclicItem) {
        CyclicItemImpl a = new CyclicItemImpl();
        a = (CyclicItemImpl) cyclicItem;

        // указатель на следующий элемент автоматически инициализируется как null
        if(head == null)            //если список пуст
        {                           //то указываем ссылки начала и конца на новый элемент
            head = a;               //т.е. список теперь состоит из одного элемента
            tail = a;
        }
        else {
            a.setNextItem(head);          //иначе новый элемент теперь ссылается на "бывший" первый
            head = a;               //а указатель на первый элемент теперь ссылается на новый элемент
        }
        return true;
    }

    @Override public void insertAfter(CyclicItem cyclicItem,
            CyclicItem cyclicItem1) {

    }

    @Override public CyclicItem getFirst() {
        return null;
    }

    @Override public boolean remove(CyclicItem cyclicItem) {
        return false;
    }

    @Override public int size() {
        return 0;
    }
}
