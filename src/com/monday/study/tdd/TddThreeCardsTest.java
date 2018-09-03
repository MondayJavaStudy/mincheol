package com.monday.study.tdd;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by mcpark on 9/3/18
 */
public class TddThreeCardsTest {
    @Test
    public void 결과값을_정상적으로_반환합니다() throws Exception {
        //Given
        List<Integer> cards = Arrays.asList(1, 2, 3);
        int target = 6;
        List<int[]> expect = Arrays.asList(new int[]{1, 2, 3});

        //When
        List<int[]> results = TddThreeCards.find(cards, target);

        //Then
        assertNotNull(results);
        for (int i = 0; i < results.size(); i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(results.get(i)[j], expect.get(i)[j]);
            }
        }
    }

    @Test
    public void 여러개의_결과를_반환합니다() {
        //Given
        List<Integer> cards = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        int target = 12;
        List<int[]> expect = Arrays.asList(
                new int[]{1, 3, 8},
                new int[]{1, 4, 7},
                new int[]{1, 5, 6},
                new int[]{2, 3, 7},
                new int[]{2, 4, 6},
                new int[]{3, 4, 5});

        //When
        List<int[]> results = TddThreeCards.find(cards, target);

        //Then
        assertThat("", results.size(), is(expect.size()));
    }


    @Test
    public void 정렬을_합니다() {
        //Given
        List<Integer> cards = Arrays.asList(3, 2, 1);
        int target = 6;
        List<int[]> expect = Arrays.asList(new int[]{1, 2, 3});

        //When
        List<int[]> results = TddThreeCards.find(cards, target);

        //Then
        assertThat("", results.size(), is(expect.size()));
        for (int i = 0; i < results.size(); i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(results.get(i)[j], expect.get(i)[j]);
            }
        }
    }

    @Test
    public void 중복을_제거합니다() {
        //Given
        List<Integer> cards = Arrays.asList(1, 1, 0, 1);
        int target = 2;
        List<int[]> expect = Arrays.asList(new int[]{0, 1, 1});

        //When
        List<int[]> results = TddThreeCards.find(cards, target);

        //Then
        assertThat("", results.size(), is(expect.size()));
    }
}
