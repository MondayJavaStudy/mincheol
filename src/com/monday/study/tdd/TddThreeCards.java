package com.monday.study.tdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mcpark on 9/3/18
 */
public class TddThreeCards {

    public static List<int[]> find(List<Integer> cards, int target) {
        List<int[]> combs = new ArrayList<>();
        for (int i = 0; i < cards.size(); i++) {
            for (int j = i + 1; j < cards.size(); j++) {
                for (int k = j + 1; k < cards.size(); k++) {
                    if (cards.get(i) + cards.get(j) + cards.get(k) == target) {
                        int[] comb = {cards.get(i), cards.get(j), cards.get(k)};
                        Arrays.sort(comb);
                        addIfAbsent(combs, comb);
                    }
                }
            }
        }
        return combs;
    }

    private static void addIfAbsent(List<int[]> combinations, int[] combination) {
        boolean has = false;
        for (int[] combination1 : combinations) {
            if (eq(combination1, combination)) {
                has = true;
            }
        }

        if (!has) {
            combinations.add(combination);
        }
    }

    private static boolean eq(int[] comb1, int[] comb2) {
        final boolean invalid = (comb1.length < 3 || comb2.length < 3);
        return !invalid && (comb1[0] == comb2[0] && comb1[1] == comb2[1] && comb1[2] == comb2[2]);
    }
}
