package com.monday.study;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mcpark on 10/1/18
 */
public class CustomStackImpl<E> implements CustomStack<E> {
    private List<E> store;

    CustomStackImpl() {
        store = new ArrayList<>();
    }

    @Override
    public void push(E item) {
        store.add(item);
    }

    @Override
    public E pop() {
        if (!store.isEmpty()) {
            E last = store.get(store.size() - 1);
            renewAfterPop();
            return last;
        }

        return null;
    }

    private void renewAfterPop() {
        List<E> newStore = new ArrayList<>();
        for (int i = 0; i < store.size() - 1; i++) {
            newStore.add(store.get(i));
        }

        store = newStore;
    }

    @Override
    public boolean isEmpty() {
        return store.isEmpty();
    }

    @Override
    public void clear() {
        store.clear();
    }

    @Override
    public int size() {
        return store.size();
    }
}
