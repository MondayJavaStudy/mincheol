package com.monday.study.dto;

import java.util.Arrays;

/**
 * Created by mcpark on 8/20/18
 */
public class Combination {
    private int[] numbers;

    public Combination(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Combination that = (Combination) o;
        return Arrays.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(numbers);
    }
}
