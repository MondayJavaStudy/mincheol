package com.monday.study;

/**
 * Created by mcpark on 10/1/18
 */
public interface CustomStack<E> {

    void push(E item);

    E pop();

    boolean isEmpty();

    void clear();

    int size();
}
