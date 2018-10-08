package com.monday.study;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by mcpark on 10/1/18
 */
public class CustomStackImplTest {
    @Test
    public void push를_정상적으로_수행합니다() {
        //Given
        CustomStack<String> stack = new CustomStackImpl<>();

        //When
        stack.push("hello");

        //Then
        Assert.assertThat("", stack.isEmpty(), is(false));
    }

    @Test
    public void pop을_정상적으로_수행합니다() {
        //Given
        CustomStack<Integer> stack = new CustomStackImpl<>();
        stack.push(111);
        stack.push(222);
        stack.push(333);

        //When
        Integer pop = stack.pop();

        //Then
        Assert.assertNotNull(pop);
        Assert.assertThat("", pop, is(333));
        Assert.assertThat("", stack.pop(), is(222));
        Assert.assertThat("", stack.size(), is(1));
    }
}
