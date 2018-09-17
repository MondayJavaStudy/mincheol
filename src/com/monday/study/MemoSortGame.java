package com.monday.study;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mcpark on 9/17/18
 */
public class MemoSortGame {

    public List<String> sortMemo(List<String> memos) {
        return memos.stream()
                .sorted((o1, o2) -> getWeight(findDateIntegers(o1)) < getWeight(findDateIntegers(o2)) ? -1 : 1)
                .collect(Collectors.toList());
    }

    private List<Integer> findDateIntegers(String sentence) {
        List<Integer> dateWords = new ArrayList<>();
        String[] split = sentence.split("[^0-9]*[-/년월일 ]");
        for (String word : split) {
            if (word.matches("[0-9]+")) {
                dateWords.add(Integer.valueOf(word));
            }
        }

        return dateWords;
    }

    private int getWeight(List<Integer> dateIntegers) {
        if (dateIntegers.size() < 3) {
            return 0;
        }

        int year = dateIntegers.get(0);
        year = (year < 100) ? year + 2000 : year;
        int month = dateIntegers.get(1);
        int day = dateIntegers.get(2);

        return (year * 10000 + month * 100 + day);
    }
}
