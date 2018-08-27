package com.monday.study;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by mcpark on 8/20/18
 */
public class MainTest {
    @Test
    public void test() {
        System.out.println("TEST");
    }

    @Ignore
    @Test
    public void 중복확인() {
        //Given
        int[] ints1 = {1, 2, 3};
        int[] ints2 = {1, 2, 3};
        List<Integer> arrays1 = Arrays.asList(1, 2, 3);
        List<Integer> arrays2 = Arrays.asList(1, 2, 3);

        //When
        boolean equalsForInts = ints1.equals(ints2);
        boolean equalsForArrays = arrays1.equals(arrays2);

        //Then
        assertTrue(equalsForArrays);
        assertTrue(equalsForInts);
    }

    @Test
    public void 결과값을_정상적으로_반환한다() throws Exception {
        //Given
        List<Integer> cards = Arrays.asList(1, 2, 3, 4, 5);
        int expectNumber = 8;
        List<Integer> answer1 = Arrays.asList(1, 2, 5);
        List<Integer> answer2 = Arrays.asList(1, 3, 4);

        //When
        List<List<Integer>> result = Main.sort(Main.collect(cards, expectNumber));

        //Then
        assertThat(result.size(), is(2));
        assertTrue(result.get(0).equals(answer1));
        assertTrue(result.get(1).equals(answer2));

    }

    @Test
    public void 중복저장_안됩니다() throws Exception {
        //Given
        List<Integer> cards = Arrays.asList(0, 0, 1, 0, 0);
        int expectNumber = 1;
        List<Integer> answer = Arrays.asList(0, 0, 1);

        //When
        List<List<Integer>> result = Main.sort(Main.collect(cards, expectNumber));

        //Then
        assertThat(result.size(), is(1));
        assertTrue(result.get(0).equals(answer));
    }
}